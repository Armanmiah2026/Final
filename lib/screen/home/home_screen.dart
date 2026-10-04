import 'dart:convert';
import 'dart:developer';
import 'dart:io';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_v2ray_client/flutter_v2ray.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:openvpn_flutter/openvpn_flutter.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:free_vpn/model/home_vpn_status.dart';
import 'package:free_vpn/screen/location/location_screen.dart';
import 'package:free_vpn/screen/profile/profile_screen.dart';
import '../../ads/ads_service.dart';
import 'package:free_vpn/controller/app_setting_controller.dart';
import 'package:free_vpn/controller/auth_controller.dart';
import 'package:free_vpn/controller/profile_controller.dart';
import 'package:free_vpn/controller/vpn_location_controller.dart';
import 'package:free_vpn/utils/ad_eligibility_helper.dart';
import 'package:free_vpn/utils/app_strings.dart';
import 'package:free_vpn/utils/split_tunnel_storage.dart';
import 'package:free_vpn/widgets/home/home_dashboard.dart';

/// Uses 1024-based steps: B/s, KB/s, MB/s, GB/s (native speeds are bytes/sec).
({String value, String unit}) _formatBitrateParts(int bytesPerSecond) {
  var bps = bytesPerSecond < 0 ? 0 : bytesPerSecond;
  if (bps == 0) {
    return (value: '0', unit: 'B/s');
  }
  const suffixes = ['B/s', 'KB/s', 'MB/s', 'GB/s'];
  var v = bps.toDouble();
  var i = 0;
  while (v >= 1024 && i < suffixes.length - 1) {
    v /= 1024;
    i++;
  }
  final String numStr;
  if (i == 0) {
    numStr = v.round().toString();
  } else if (v >= 100) {
    numStr = v.round().toString();
  } else if (v >= 10) {
    numStr = _trimTrailingZeros(v.toStringAsFixed(1));
  } else {
    numStr = _trimTrailingZeros(v.toStringAsFixed(2));
  }
  return (value: numStr, unit: suffixes[i]);
}

String _formatBitrateLine(int bytesPerSecond) {
  final p = _formatBitrateParts(bytesPerSecond);
  return '${p.value} ${p.unit}';
}

String _trimTrailingZeros(String s) {
  if (!s.contains('.')) return s;
  var t = s.replaceFirst(RegExp(r'0+$'), '');
  t = t.replaceFirst(RegExp(r'\.$'), '');
  return t;
}

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {

  final ValueNotifier<HomeVpnStatus> connectionStatus =
      ValueNotifier<HomeVpnStatus>(const HomeVpnStatus());

  late V2ray v2ray;
  late OpenVPN openvpn;

  bool _userAdsEnabled = true;
  bool isConnect = false;
  bool _openVpnInitialized = false;
  bool _vpnUiLocked = true;

  int _lastByteIn = 0;
  int _lastByteOut = 0;
  DateTime? _lastSpeedSample;

  String serverName = '';
  String vpnProtocol = 'v2ray';
  String vpnUsername = '';
  String vpnPassword = '';

  dynamic id;
  dynamic config;
  dynamic isPremium;
  String? countryCode;

  Future<void> _loadConfigData() async {
    try {
      SharedPreferences prefs = await SharedPreferences.getInstance();

      id = prefs.getInt('id');
      serverName = _decodeBase64(prefs.getString('name'));
      config = _decodeBase64(prefs.getString('link'));
      isPremium = _decodeBase64(prefs.getString('isPremium'));
      countryCode = _decodeBase64(prefs.getString('country_code'));
      vpnProtocol = _decodeBase64(prefs.getString('protocol'));
      vpnUsername = _decodeBase64(prefs.getString('vpn_username'));
      vpnPassword = _decodeBase64(prefs.getString('vpn_password'));

      if (vpnProtocol.isEmpty) {
        vpnProtocol = 'v2ray';
      }


      if (kDebugMode) {
        print('Loaded id: $id');
        print('Loaded server: $serverName');
        print('Config: $config');
        print('Config length: ${config?.length ?? 0}');
      }

      // If any required data is missing, don't validate yet
      if (serverName.isEmpty || config == null || config.toString().isEmpty) {
        if (kDebugMode) {
          print('Missing server data. Will fetch from API...');
        }
        return;
      }

      // Validate config by protocol
      final configStr = config.toString().trim();
      if (vpnProtocol == 'openvpn') {
        final isValidOvpn = configStr.contains('remote ') ||
            configStr.contains('client') ||
            configStr.contains('dev tun');
        if (!isValidOvpn) {
          if (kDebugMode) {
            print('Invalid OpenVPN config format');
          }
          config = '';
          serverName = '';
        }
      } else {
        final validProtocols = [
          'vmess://',
          'vless://',
          'ss://',
          'trojan://',
          'socks://',
          'http://',
        ];
        final isValidConfig = validProtocols.any(
          (protocol) => configStr.toLowerCase().startsWith(protocol),
        );

        if (!isValidConfig) {
          if (kDebugMode) {
            print('Invalid V2Ray config format: $configStr');
          }
          config = '';
          serverName = '';
        } else if (kDebugMode) {
          print('Valid V2Ray config detected');
        }
      }

      setState(() {});
    } catch (e) {
      if (kDebugMode) {
        print('Error loading server data: $e');
      }
    }
  }

  String _decodeBase64(String? value) {
    if (value == null || value.isEmpty) return '';
    try {
      return utf8.decode(base64.decode(value));
    } catch (_) {
      return '';
    }
  }

  List<String> _splitTunnelBypassPackages = [];

  Future<void> _refreshSplitTunnelPackages() async {
    final packages = await loadSplitTunnelBypassPackages();
    if (!mounted) return;
    setState(() {
      _splitTunnelBypassPackages = packages;
    });
    if (kDebugMode) {
      print('Split tunnel bypass packages: $_splitTunnelBypassPackages');
    }
  }

  //ads

  late BannerAd _bannerAd;
  bool _isBannerAdReady = false;

  void _loadBannerAd() {
    final unitId = AdHelper.bannerAdUnitId;
    if (unitId.isEmpty) {
      if (kDebugMode) print('Banner ad unit id missing - skipping banner load');
      _isBannerAdReady = false;
      return;
    }

    _bannerAd = BannerAd(
      adUnitId: unitId,
      request: const AdRequest(),
      size: AdSize.banner,
      listener: BannerAdListener(
        onAdLoaded: (_) {
          setState(() {
            _isBannerAdReady = true;
          });
        },
        onAdFailedToLoad: (ad, err) {
          _isBannerAdReady = false;
          ad.dispose();
        },
      ),
    );

    _bannerAd.load();
  }

  NativeAd? _nativeAd;
  //bool _isAdLoaded = false;

  void _loadAd() {
    final unitId = AdHelper.nativeBannerAdUnitId;
    if (unitId.isEmpty) {
      if (kDebugMode) print('Native ad unit id missing - skipping native ad load');
      return;
    }

    _nativeAd = NativeAd(
      adUnitId: unitId,
      request: const AdRequest(),
      // No factoryId needed when using templates
      nativeTemplateStyle: NativeTemplateStyle(
        templateType: TemplateType.small,
        mainBackgroundColor: Colors.white,
      ),
      listener: NativeAdListener(
        onAdLoaded: (ad) {
          setState(() {
            //_isAdLoaded = true;
          });
          log('Native ad loaded');
        },
        onAdFailedToLoad: (ad, error) {
          ad.dispose();
          log('Failed to load native ad: $error');
        },
      ),
    )..load();
  }

  RewardedAd? _rewardedAd;
  int _numRewardedLoadAttempts = 0;

  void _createRewardedAd() {
    final unitId = AdHelper.rewardedAdUnitId;
    if (unitId.isEmpty) {
      if (kDebugMode) print('Rewarded ad unit id missing - skipping rewarded load');
      return;
    }
    RewardedAd.load(
        adUnitId: unitId,
        request: const AdRequest(),
        rewardedAdLoadCallback: RewardedAdLoadCallback(
          onAdLoaded: (RewardedAd ad) {
            log('$ad loaded.');
            _rewardedAd = ad;
            _numRewardedLoadAttempts = 0;
          },
          onAdFailedToLoad: (LoadAdError error) {
            log('RewardedAd failed to load: $error');
            _rewardedAd = null;
            _numRewardedLoadAttempts += 1;
            if (_numRewardedLoadAttempts < 3) {
              _createRewardedAd();
            }
          },
        ));
  }

  void _showRewardedAd() {
    if (_rewardedAd == null) {
      log('Warning: attempt to show rewarded before loaded.');
      return;
    }
    _rewardedAd!.fullScreenContentCallback = FullScreenContentCallback(
      onAdShowedFullScreenContent: (RewardedAd ad) =>
          log('ad onAdShowedFullScreenContent.'),
      onAdDismissedFullScreenContent: (RewardedAd ad) {
        log('$ad onAdDismissedFullScreenContent.');
        ad.dispose();
        _createRewardedAd();
      },
      onAdFailedToShowFullScreenContent: (RewardedAd ad, AdError error) {
        log('$ad onAdFailedToShowFullScreenContent: $error');
        ad.dispose();
        _createRewardedAd();
      },
    );

    _rewardedAd!.setImmersiveMode(true);
    _rewardedAd!.show(
        onUserEarnedReward: (AdWithoutView ad, RewardItem reward) {
          log('$ad with reward $RewardItem(${reward.amount}, ${reward.type})');
        });
    _rewardedAd = null;
  }

  Future<void> _initAdsForUser() async {
    Map<String, dynamic>? profile;
    final token = await Get.find<AuthController>().getAuthToken();
    if (token.isNotEmpty && Get.isRegistered<ProfileController>()) {
      await Get.find<ProfileController>().getProfileData();
      profile = Get.find<ProfileController>().profileData;
    }

    final showAds = AdEligibility.shouldShowAdsForUser(profile);
    if (!mounted) return;
    setState(() => _userAdsEnabled = showAds);
    if (!showAds) return;

    final appCtrl = Get.isRegistered<AppSettingController>()
        ? Get.find<AppSettingController>()
        : null;
    if (appCtrl == null) return;

    if (appCtrl.shouldShowNative) {
      _loadAd();
    }
    if (appCtrl.shouldShowRewarded) {
      _createRewardedAd();
    }
    if (appCtrl.shouldShowBanner) {
      _loadBannerAd();
    }
  }

  bool _shouldShowDisconnectAd() {
    if (!_userAdsEnabled) return false;
    return !AdEligibility.parseStoredServerPremium(isPremium);
  }

  @override
  void initState() {
    super.initState();

    _refreshSplitTunnelPackages();

    WidgetsBinding.instance.addPostFrameCallback((_) {
      _bootstrapVpnEngines();
      _initAdsForUser();
      _preloadVpnServers();
    });
  }

  Future<void> _preloadVpnServers() async {
    if (!Get.isRegistered<VpnLocationController>()) return;

    Map<String, dynamic>? profile;
    if (Get.isRegistered<AuthController>() &&
        Get.isRegistered<ProfileController>()) {
      final token = await Get.find<AuthController>().getAuthToken();
      if (token.isNotEmpty) {
        await Get.find<ProfileController>().getProfileData();
        profile = Get.find<ProfileController>().profileData;
      }
    }

    await Get.find<VpnLocationController>().loadServers(profile: profile);
    if (mounted) {
      await _loadConfigData();
      setState(() {});
    }
  }

  Future<void> _bootstrapVpnEngines() async {
    await _loadConfigData();

    v2ray = V2ray(onStatusChanged: _handleV2RayStatus);
    await v2ray.initialize(
      notificationIconResourceType: 'mipmap',
      notificationIconResourceName: 'ic_launcher',
    );

    openvpn = OpenVPN(
      onVpnStatusChanged: _handleOpenVpnStatus,
      onVpnStageChanged: _handleOpenVpnStage,
    );
    await openvpn.initialize();
    _openVpnInitialized = true;

    await _syncVpnUiState();
    _vpnUiLocked = false;
  }

  Future<void> _syncVpnUiState() async {
    if (vpnProtocol == 'openvpn') {
      final stage = await openvpn.stage();
      _applyOpenVpnStage(stage, stage.name);
      return;
    }

    connectionStatus.value = const HomeVpnStatus();
    setState(() {
      isConnect = false;
    });
  }

  void _handleV2RayStatus(V2RayStatus status) {
    if (_vpnUiLocked || vpnProtocol != 'v2ray') return;

    if (kDebugMode) {
      print('V2Ray status changed: ${status.state}');
    }

    connectionStatus.value = HomeVpnStatus(
      state: status.state,
      duration: status.duration,
      downloadSpeed: status.downloadSpeed,
      uploadSpeed: status.uploadSpeed,
    );

    setState(() {
      isConnect = status.state == 'CONNECTED';
    });
  }

  void _resetOpenVpnSpeedTracking() {
    _lastByteIn = 0;
    _lastByteOut = 0;
    _lastSpeedSample = null;
  }

  String _openVpnStateFromStage(VPNStage stage) {
    switch (stage) {
      case VPNStage.connected:
        return 'CONNECTED';
      case VPNStage.disconnected:
      case VPNStage.denied:
      case VPNStage.error:
      case VPNStage.disconnecting:
      case VPNStage.exiting:
        return 'DISCONNECTED';
      default:
        return 'CONNECTING';
    }
  }

  void _handleOpenVpnStage(VPNStage stage, String rawStage) {
    if (_vpnUiLocked || vpnProtocol != 'openvpn') return;
    _applyOpenVpnStage(stage, rawStage);
  }

  void _applyOpenVpnStage(VPNStage stage, String rawStage) {
    if (kDebugMode) {
      print('OpenVPN stage: $rawStage');
    }

    final state = _openVpnStateFromStage(stage);
    final connected = state == 'CONNECTED';
    if (!connected && state == 'DISCONNECTED') {
      _resetOpenVpnSpeedTracking();
    }

    connectionStatus.value = connectionStatus.value.copyWith(
      state: state,
      downloadSpeed: connected ? connectionStatus.value.downloadSpeed : 0,
      uploadSpeed: connected ? connectionStatus.value.uploadSpeed : 0,
      duration: connected ? connectionStatus.value.duration : '00:00:00',
    );

    setState(() {
      isConnect = connected;
    });
  }

  void _handleOpenVpnStatus(VpnStatus? status) {
    if (status == null || _vpnUiLocked || vpnProtocol != 'openvpn') return;
    if (!connectionStatus.value.isConnected) return;

    final now = DateTime.now();
    final byteIn = int.tryParse(status.byteIn ?? '0') ?? 0;
    final byteOut = int.tryParse(status.byteOut ?? '0') ?? 0;
    var downSpeed = 0;
    var upSpeed = 0;

    if (_lastSpeedSample != null) {
      final seconds =
          now.difference(_lastSpeedSample!).inMilliseconds / 1000.0;
      if (seconds > 0) {
        downSpeed = ((byteIn - _lastByteIn) / seconds).round();
        upSpeed = ((byteOut - _lastByteOut) / seconds).round();
        if (downSpeed < 0) downSpeed = 0;
        if (upSpeed < 0) upSpeed = 0;
      }
    }

    _lastByteIn = byteIn;
    _lastByteOut = byteOut;
    _lastSpeedSample = now;

    connectionStatus.value = connectionStatus.value.copyWith(
      duration: status.duration ?? connectionStatus.value.duration,
      downloadSpeed: downSpeed,
      uploadSpeed: upSpeed,
    );
  }

  void _setOpenVpnConnecting() {
    connectionStatus.value = connectionStatus.value.copyWith(
      state: 'CONNECTING',
      downloadSpeed: 0,
      uploadSpeed: 0,
      duration: '00:00:00',
    );
    setState(() {
      isConnect = false;
    });
  }

  Future<void> _connectOpenVpn() async {
    await _refreshSplitTunnelPackages();
    _setOpenVpnConnecting();

    if (!_openVpnInitialized) {
      await openvpn.initialize();
      _openVpnInitialized = true;
    }

    if (Platform.isAndroid) {
      final granted = await openvpn.requestPermissionAndroid();
      if (!granted) {
        connectionStatus.value = const HomeVpnStatus();
        setState(() {
          isConnect = false;
        });
        Fluttertoast.showToast(
          msg: 'VPN permission is required',
          backgroundColor: Colors.orange,
          textColor: Colors.white,
        );
        return;
      }
    }

    final configStr = config.toString().trim();
    final filtered = await OpenVPN.filteredConfig(configStr);
    await openvpn.connect(
      filtered ?? configStr,
      serverName.isNotEmpty ? serverName : 'VPN',
      username: vpnUsername.isNotEmpty ? vpnUsername : null,
      password: vpnPassword.isNotEmpty ? vpnPassword : null,
      bypassPackages: _splitTunnelBypassPackages,
    );
  }

  Future<void> _disconnectVpn() async {
    if (vpnProtocol == 'openvpn') {
      openvpn.disconnect();
      _resetOpenVpnSpeedTracking();
    } else {
      await v2ray.stopV2Ray();
    }

    connectionStatus.value = const HomeVpnStatus();
    setState(() {
      isConnect = false;
    });
  }

  Future<void> _connectVpn() async {
    if (_vpnUiLocked) return;

    if (config == null || config.toString().trim().isEmpty) {
      Fluttertoast.showToast(
        msg: 'No server selected. Please select a server.',
        backgroundColor: Colors.orange,
        textColor: Colors.white,
        fontSize: 16.0,
      );
      return;
    }

    await _refreshSplitTunnelPackages();

    if (vpnProtocol == 'openvpn') {
      try {
        await v2ray.stopV2Ray();
      } catch (_) {}
      await _connectOpenVpn();
      return;
    }

    openvpn.disconnect();
    _resetOpenVpnSpeedTracking();

    final configStr = config.toString().trim();
    final V2RayURL parser = V2ray.parseFromURL(configStr);

    if (await v2ray.requestPermission()) {
      v2ray.startV2Ray(
        remark: parser.remark,
        config: parser.getFullConfiguration(),
        proxyOnly: false,
        bypassSubnets: null,
        blockedApps: _splitTunnelBypassPackages,
      );
      setState(() {});
    }
  }

  @override
  void dispose() {
    // Dispose ad objects if they were created
    try {
      if (_isBannerAdReady) {
        try { _bannerAd.dispose(); } catch (_) {}
      }
    } catch (_) {}

    try {
      _nativeAd?.dispose();
    } catch (_) {}

    try {
      _rewardedAd?.dispose();
    } catch (_) {}

    connectionStatus.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFF4F6F8),
      extendBodyBehindAppBar: true,
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        scrolledUnderElevation: 0,
        surfaceTintColor: Colors.transparent,
        centerTitle: true,
        automaticallyImplyLeading: false,
        title: Text(
          AppStrings.appName,
          style: GoogleFonts.poppins(
            color: Colors.white,
            fontSize: 18,
            fontWeight: FontWeight.w600,
            letterSpacing: 0.2,
          ),
        ),
        actions: [
          Padding(
            padding: const EdgeInsets.only(right: 12),
            child: Material(
              color: Colors.transparent,
              child: InkWell(
                onTap: () => Get.to(() => const ProfileScreen()),
                borderRadius: BorderRadius.circular(24),
                child: Ink(
                  width: 40,
                  height: 40,
                  decoration: BoxDecoration(
                    color: Colors.white.withValues(alpha: 0.12),
                    shape: BoxShape.circle,
                    border: Border.all(
                      color: Colors.white.withValues(alpha: 0.22),
                    ),
                  ),
                  child: const Icon(
                    Icons.person_rounded,
                    color: Colors.white,
                    size: 22,
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
      body: ValueListenableBuilder<HomeVpnStatus>(
        valueListenable: connectionStatus,
        builder: (context, value, child) {
          final combinedRate =
              _formatBitrateParts(value.downloadSpeed + value.uploadSpeed);

          return SingleChildScrollView(
            //physics: const BouncingScrollPhysics(),
            child: Column(
              children: [
                HomeHeroSection(
                  status: value,
                  speedValue: combinedRate.value,
                  speedUnit: combinedRate.unit,
                  downloadLine: _formatBitrateLine(value.downloadSpeed),
                  uploadLine: _formatBitrateLine(value.uploadSpeed),
                ),
                HomeConnectButton(
                  isConnected: value.isConnected,
                  isConnecting: value.isConnecting,
                  onTap: () async {
                    try {
                      if (value.isConnecting) {
                        return;
                      }
                      if (value.isConnected) {
                        final appCtrl =
                            Get.isRegistered<AppSettingController>()
                                ? Get.find<AppSettingController>()
                                : null;
                        if (appCtrl != null &&
                            _shouldShowDisconnectAd() &&
                            appCtrl.shouldShowRewarded &&
                            AdHelper.rewardedAdUnitId.isNotEmpty) {
                          _showRewardedAd();
                        }
                        await _disconnectVpn();
                        Fluttertoast.showToast(
                          msg: 'VPN Disconnected',
                          backgroundColor: Colors.red,
                          textColor: Colors.white,
                          fontSize: 16.0,
                        );
                      } else {
                        if (kDebugMode) {
                          print(
                            'Starting ${vpnProtocol.toUpperCase()} VPN...',
                          );
                        }
                        await _connectVpn();
                      }
                    } catch (e) {
                      if (kDebugMode) print('Connection error: $e');
                      if (vpnProtocol == 'openvpn') {
                        connectionStatus.value = const HomeVpnStatus();
                        setState(() {
                          isConnect = false;
                        });
                      }
                      Fluttertoast.showToast(
                        msg: 'Operation failed: $e',
                        backgroundColor: Colors.red,
                        textColor: Colors.white,
                        fontSize: 16.0,
                      );
                    } finally {
                      setState(() {});
                    }
                  },
                ),
                HomeLocationCard(
                  serverName: serverName,
                  countryCode: countryCode,
                  protocol: vpnProtocol,
                  onTap: () async {
                    await Get.to(() => const LocationScreen());
                    await _loadConfigData();
                    if (!_vpnUiLocked && !connectionStatus.value.isConnected) {
                      await _syncVpnUiState();
                    }
                  },
                ),
                GetBuilder<AppSettingController>(
                  builder: (appCtrl) {
                    if (appCtrl.shouldShowBanner &&
                        _userAdsEnabled &&
                        !_isBannerAdReady &&
                        AdHelper.bannerAdUnitId.isNotEmpty) {
                      WidgetsBinding.instance.addPostFrameCallback(
                        (_) => _loadBannerAd(),
                      );
                    }

                    if (!_userAdsEnabled && _isBannerAdReady) {
                      try {
                        _bannerAd.dispose();
                      } catch (_) {}
                      _isBannerAdReady = false;
                    }

                    if (!appCtrl.shouldShowBanner && _isBannerAdReady) {
                      try {
                        _bannerAd.dispose();
                      } catch (_) {}
                      _isBannerAdReady = false;
                    }

                    if (appCtrl.shouldShowBanner &&
                        _userAdsEnabled &&
                        _isBannerAdReady) {
                      return Padding(
                        padding: const EdgeInsets.fromLTRB(0, 20, 0, 16),
                        child: Align(
                          alignment: Alignment.bottomCenter,
                          child: SizedBox(
                            width: _bannerAd.size.width.toDouble(),
                            height: _bannerAd.size.height.toDouble(),
                            child: AdWidget(ad: _bannerAd),
                          ),
                        ),
                      );
                    }

                    return const SizedBox(height: 16);
                  },
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}
