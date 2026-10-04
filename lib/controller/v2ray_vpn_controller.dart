import 'dart:developer';
import 'package:get/get.dart';
import 'package:free_vpn/data/repository/v2ray_repo.dart';
import 'package:free_vpn/model/v2ray_vpn_model.dart';
import '../data/model/base_model/api_response.dart';

/// Resolves the server array from common API shapes:
/// `{ "data": [ ... ] }`, `{ "data": { "data": [ ... ], "current_page": ... } }`,
/// or a raw JSON array.
List<dynamic> _extractV2rayRawList(dynamic body) {
  if (body == null) return [];
  if (body is List<dynamic>) return body;
  if (body is! Map) return [];

  final map = Map<String, dynamic>.from(body);
  final layer = map['data'];

  if (layer is List<dynamic>) return layer;
  if (layer is Map) {
    final inner = layer['data'];
    if (inner is List<dynamic>) return inner;
  }

  return [];
}

class V2rayVpnController extends GetxController {
  final V2rayVpnRepo v2rayVpnRepo;

  V2rayVpnController({required this.v2rayVpnRepo});

  bool _isLoadingV2rayVpn = false;
  bool get isLoadingV2rayVpn => _isLoadingV2rayVpn;

  List<V2rayVpnModel> _vpnServers = [];
  List<V2rayVpnModel> get vpnServers => _vpnServers;

  Future<void> getV2rayVpnData() async {
    _isLoadingV2rayVpn = true;
    update();

    ApiResponse apiResponse = await v2rayVpnRepo.getV2rayVpnData();

    _isLoadingV2rayVpn = false;

    if (apiResponse.response != null &&
        apiResponse.response!.statusCode == 200 &&
        apiResponse.response!.data != null) {
      try {
        final rawList = _extractV2rayRawList(apiResponse.response!.data);
        _vpnServers = [];
        for (final e in rawList) {
          if (e is Map) {
            _vpnServers.add(
              V2rayVpnModel.fromJson(Map<String, dynamic>.from(e)),
            );
          } else {
            log(
              'Skipping VPN list row (expected object, got ${e.runtimeType})',
            );
          }
        }
      } catch (e) {
        _vpnServers = [];
        log('Failed to parse VPN server list: $e');
      }
    } else {
      _vpnServers = [];
      log('Failed to load VPN data. Status: ${apiResponse.response?.statusCode}');
    }

    update(); // Notify UI about data change
  }
}
