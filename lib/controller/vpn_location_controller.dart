import 'dart:developer';

import 'package:free_vpn/data/repository/genral_setting_repo.dart';
import 'package:free_vpn/data/repository/openvpn_repo.dart';
import 'package:free_vpn/data/repository/server_list_repo.dart';
import 'package:free_vpn/data/repository/v2ray_repo.dart';
import 'package:free_vpn/model/vpn_server_model.dart';
import 'package:free_vpn/utils/vpn_list_parser.dart';
import 'package:free_vpn/utils/vpn_server_auto_select.dart';
import 'package:free_vpn/utils/vpn_server_cache.dart';
import 'package:free_vpn/utils/vpn_server_storage.dart';
import 'package:get/get.dart';
import 'package:shared_preferences/shared_preferences.dart';

class VpnLocationController extends GetxController {
  final V2rayVpnRepo v2rayVpnRepo;
  final OpenVpnRepo openVpnRepo;
  final GeneralSettingRepo generalSettingRepo;
  final ServerListRepo serverListRepo;
  final SharedPreferences sharedPreferences;

  VpnLocationController({
    required this.v2rayVpnRepo,
    required this.openVpnRepo,
    required this.generalSettingRepo,
    required this.serverListRepo,
    required this.sharedPreferences,
  });

  bool _isLoading = false;
  bool _isRefreshing = false;
  bool _loadedFromCache = false;

  bool get isLoading => _isLoading;
  bool get isRefreshing => _isRefreshing;
  bool get loadedFromCache => _loadedFromCache;

  List<VpnServerModel> _vpnServers = [];
  List<VpnServerModel> get vpnServers => _vpnServers;

  List<VpnServerModel> get freeServers =>
      _vpnServers.where((server) => !server.isPremium).toList();

  List<VpnServerModel> get premiumServers =>
      _vpnServers.where((server) => server.isPremium).toList();

  String? loadError;
  int? selectedServerId;
  bool _autoSelectApplied = false;

  bool get isAutoSelectMode =>
      VpnServerStorage.isAutoSelectMode(sharedPreferences);

  VpnServerModel? get selectedServer =>
      VpnServerStorage.findById(_vpnServers, selectedServerId);

  /// Enables auto-select mode and picks the best server.
  Future<VpnServerModel?> applyAutoSelect({
    Map<String, dynamic>? profile,
  }) async {
    _autoSelectApplied = false;
    await VpnServerStorage.setAutoSelectMode(sharedPreferences, true);
    await _ensureAutoSelected(profile: profile);
    update();
    return selectedServer;
  }

  Future<VpnServerModel?> reapplyAutoSelect({
    Map<String, dynamic>? profile,
  }) =>
      applyAutoSelect(profile: profile);

  Future<void> loadServers({
    bool forceRefresh = false,
    Map<String, dynamic>? profile,
  }) async {
    final cached = VpnServerCache.read(sharedPreferences);
    if (cached != null && cached.servers.isNotEmpty) {
      _applyServers(cached.servers, fromCache: true);
      _isLoading = false;
      update();
      await _ensureAutoSelected(profile: profile);
    } else {
      _isLoading = true;
      loadError = null;
      update();
    }

    _isRefreshing = cached != null;
    update();

    try {
      final remoteFingerprint = await _fetchRemoteFingerprint();
      final cachedFingerprint = VpnServerCache.storedFingerprint(sharedPreferences);
      final shouldFetchFullList = forceRefresh ||
          cached == null ||
          (remoteFingerprint != null && remoteFingerprint != cachedFingerprint);

      if (!shouldFetchFullList) {
        log('VPN server cache is up to date');
        _isRefreshing = false;
        _isLoading = false;
        update();
        return;
      }

      if (cached == null) {
        _isLoading = true;
        update();
      }

      final fetched = await _fetchServersFromApi();
      if (fetched.servers.isEmpty) {
        if (_vpnServers.isEmpty) {
          loadError = fetched.error ?? 'No VPN servers available';
        }
      } else {
        final fingerprint = remoteFingerprint ?? _buildLocalFingerprint(fetched.servers);
        await VpnServerCache.save(
          sharedPreferences,
          fingerprint: fingerprint,
          servers: fetched.servers,
        );
        _applyServers(fetched.servers, fromCache: false);
        loadError = null;
        _autoSelectApplied = false;
        await _ensureAutoSelected(profile: profile);
      }
    } catch (e, stack) {
      log('loadServers failed', error: e, stackTrace: stack);
      if (_vpnServers.isEmpty) {
        loadError = 'Could not load VPN servers';
      }
    } finally {
      _isLoading = false;
      _isRefreshing = false;
      update();
    }
  }

  void _applyServers(List<VpnServerModel> servers, {required bool fromCache}) {
    _vpnServers = List<VpnServerModel>.from(servers);
    _loadedFromCache = fromCache;
    selectedServerId = VpnServerStorage.getSelectedServerId(sharedPreferences);
  }

  Future<String?> _fetchRemoteFingerprint() async {
    final response = await serverListRepo.getServersMeta();
    if (response.error != null) {
      log('Server meta failed: ${response.error}');
      return null;
    }

    final data = response.response?.data;
    if (data is Map && data['fingerprint'] != null) {
      return data['fingerprint'].toString();
    }
    return null;
  }

  String _buildLocalFingerprint(List<VpnServerModel> servers) {
    final parts = servers.map((server) {
      return '${server.protocol}:${server.id}:${server.name}:${server.isPremium}';
    }).toList();
    return parts.join('|');
  }

  Future<({List<VpnServerModel> servers, String? error})> _fetchServersFromApi() async {
    var v2rayEnabled = true;
    var openvpnEnabled = true;
    String? error;

    final generalResponse = await generalSettingRepo.getGeneralData();
    if (generalResponse.error != null) {
      error = generalResponse.error.toString();
    } else if (generalResponse.response != null &&
        generalResponse.response!.statusCode == 200 &&
        generalResponse.response!.data != null) {
      final settings = Map<String, dynamic>.from(
        generalResponse.response!.data as Map,
      );
      v2rayEnabled = isProtocolEnabled(settings['v2ray_status']);
      openvpnEnabled = isProtocolEnabled(settings['openvpn_status']);
    }

    final servers = <VpnServerModel>[];

    if (v2rayEnabled) {
      servers.addAll(await _loadV2rayServers());
    }
    if (openvpnEnabled) {
      servers.addAll(await _loadOpenVpnServers());
    }

    return (servers: servers, error: error);
  }

  Future<void> _ensureAutoSelected({Map<String, dynamic>? profile}) async {
    if (_vpnServers.isEmpty) return;

    if (!isAutoSelectMode) {
      selectedServerId = VpnServerStorage.getSelectedServerId(sharedPreferences);
      update();
      return;
    }

    if (_autoSelectApplied) {
      final currentId = VpnServerStorage.getSelectedServerId(sharedPreferences);
      final current = VpnServerStorage.findById(_vpnServers, currentId);
      if (current != null &&
          VpnServerAutoSelect.isAutoSelectCandidate(current, profile: profile)) {
        selectedServerId = int.tryParse('${current.id}');
        update();
        return;
      }
    }

    final picked = VpnServerAutoSelect.pickBest(
      _vpnServers,
      profile: profile,
    );

    if (picked == null) {
      selectedServerId = VpnServerStorage.getSelectedServerId(sharedPreferences);
      update();
      return;
    }

    await VpnServerStorage.saveServer(sharedPreferences, picked);
    selectedServerId = int.tryParse('${picked.id}');
    _autoSelectApplied = true;
    update();
  }

  Future<void> selectServer(
    VpnServerModel server, {
    Map<String, dynamic>? profile,
  }) async {
    await VpnServerStorage.setAutoSelectMode(sharedPreferences, false);
    await VpnServerStorage.saveServer(sharedPreferences, server);
    selectedServerId = int.tryParse('${server.id}');
    _autoSelectApplied = false;
    update();
  }

  Future<List<VpnServerModel>> _loadV2rayServers() async {
    final apiResponse = await v2rayVpnRepo.getV2rayVpnData();
    if (apiResponse.response == null ||
        apiResponse.response!.statusCode != 200 ||
        apiResponse.response!.data == null) {
      log('Failed to load V2ray servers');
      return [];
    }

    try {
      final rawList = extractVpnRawList(apiResponse.response!.data);
      return rawList
          .whereType<Map>()
          .map((e) => VpnServerModel.fromV2rayJson(Map<String, dynamic>.from(e)))
          .where((s) => s.config.isNotEmpty)
          .toList();
    } catch (e) {
      log('Failed to parse V2ray list: $e');
      return [];
    }
  }

  Future<List<VpnServerModel>> _loadOpenVpnServers() async {
    final apiResponse = await openVpnRepo.getOpenVpnData();
    if (apiResponse.response == null ||
        apiResponse.response!.statusCode != 200 ||
        apiResponse.response!.data == null) {
      log('Failed to load OpenVPN servers');
      return [];
    }

    try {
      final rawList = extractVpnRawList(apiResponse.response!.data);
      return rawList
          .whereType<Map>()
          .map((e) => VpnServerModel.fromOpenVpnJson(Map<String, dynamic>.from(e)))
          .where((s) => s.config.trim().isNotEmpty)
          .toList();
    } catch (e) {
      log('Failed to parse OpenVPN list: $e');
      return [];
    }
  }
}
