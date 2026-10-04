import 'dart:developer';

import 'package:free_vpn/model/vpn_server_model.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:free_vpn/controller/vpn_location_controller.dart';
import 'package:free_vpn/screen/auth/signin_screen.dart';
import 'package:free_vpn/utils/ad_eligibility_helper.dart';
import 'package:free_vpn/utils/app_colors.dart';
import '../../ads/ads_service.dart';
import '../../controller/auth_controller.dart';
import '../../controller/profile_controller.dart';
import '../../controller/app_setting_controller.dart';
import '../subscription/subscription_plans_screen.dart';

class LocationScreen extends StatefulWidget {
  const LocationScreen({super.key});

  @override
  State<LocationScreen> createState() => _LocationScreenState();
}

class _LocationScreenState extends State<LocationScreen> {
  final TextEditingController _searchController = TextEditingController();
  String _searchQuery = '';
  _LocationTab _activeTab = _LocationTab.free;

  /// Stable future so nested `GetBuilder` rebuilds don't reset [FutureBuilder].
  late final Future<String> _authTokenFuture =
      Get.find<AuthController>().getAuthToken();

  Future<void> _goHomeAfterServerSelection(
    VpnServerModel item, {
    Map<String, dynamic>? profileData,
  }) async {
    if (AdEligibility.shouldShowAdsForServer(
      serverIsPremium: item.isPremium,
      profile: profileData,
    )) {
      final appCtrl = Get.isRegistered<AppSettingController>()
          ? Get.find<AppSettingController>()
          : null;
      if (appCtrl != null &&
          appCtrl.shouldShowInterstitial &&
          AdHelper.interstitialAdUnitId.isNotEmpty) {
        _showInterstitialAd();
      }
    }
    Get.back();
  }

  Future<void> _selectServerAndGoHome(
    VpnServerModel item,
    String countryCode, {
    Map<String, dynamic>? profileData,
  }) async {
    await Get.find<VpnLocationController>().selectServer(
      item,
      profile: profileData,
    );

    await _goHomeAfterServerSelection(item, profileData: profileData);
  }

  Future<void> _applyAutoSelectAndGoHome({
    required VpnLocationController controller,
    Map<String, dynamic>? profileData,
  }) async {
    final picked = await controller.applyAutoSelect(profile: profileData);
    if (picked == null || !mounted) return;
    await _goHomeAfterServerSelection(picked, profileData: profileData);
  }

  void checkAuthAndFetchProfile() async {
    final token = await Get.find<AuthController>().getAuthToken();
    if (token.isEmpty) return;

    WidgetsBinding.instance.addPostFrameCallback((_) {
      Get.find<ProfileController>().getProfileData().then((value) {
        if (value != 200) return;

        final profile = Get.find<ProfileController>().profileData;
        if (profile == null) return;

        final isPremium = AdEligibility.isPremiumUser(profile);
        final expiredDate =
            DateTime.tryParse(profile['expired_date']?.toString() ?? '');

        if (AdEligibility.hasActivePremium(profile)) {
          log('Premium valid until: $expiredDate');
        } else if (isPremium) {
          Get.find<ProfileController>().cancelSubscriptionData();
          log('Premium expired or not active');
        }
      });
    });
  }

  void _onServerTap({
    required VpnServerModel item,
    required String countryCode,
    required Map<String, dynamic>? profileData,
  }) async {
    final token = await Get.find<AuthController>().getAuthToken();

    if (!item.isPremium) {
      _selectServerAndGoHome(
        item,
        countryCode,
        profileData: profileData,
      );
      return;
    }

    if (token.isEmpty) {
      _promptLoginFirst(
        message: 'Please log in first to use premium servers.',
      );
      return;
    }

    if (AdEligibility.hasActivePremium(profileData)) {
      _selectServerAndGoHome(
        item,
        countryCode,
        profileData: profileData,
      );
      return;
    }

    Get.to(() => const SubscriptionPlansScreen());
  }

  void _promptLoginFirst({required String message}) {
    Get.dialog(
      Dialog(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
        backgroundColor: Colors.white,
        child: Padding(
          padding: const EdgeInsets.fromLTRB(22, 24, 22, 20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Container(
                padding: const EdgeInsets.all(14),
                decoration: BoxDecoration(
                  color: AppColors.appPrimaryColor.withValues(alpha: 0.12),
                  shape: BoxShape.circle,
                ),
                child: Icon(
                  Icons.login_rounded,
                  color: AppColors.appPrimaryColor,
                  size: 32,
                ),
              ),
              const SizedBox(height: 16),
              Text(
                'Login required',
                style: GoogleFonts.poppins(
                  fontSize: 18,
                  fontWeight: FontWeight.w700,
                  color: Colors.grey.shade900,
                ),
              ),
              const SizedBox(height: 8),
              Text(
                message,
                textAlign: TextAlign.center,
                style: GoogleFonts.poppins(
                  fontSize: 14,
                  color: Colors.grey.shade600,
                  height: 1.4,
                ),
              ),
              const SizedBox(height: 22),
              Row(
                children: [
                  Expanded(
                    child: OutlinedButton(
                      onPressed: () => Get.back(),
                      style: OutlinedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 13),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                        side: BorderSide(color: Colors.grey.shade300),
                      ),
                      child: Text(
                        'Cancel',
                        style: GoogleFonts.poppins(
                          fontWeight: FontWeight.w600,
                          color: Colors.grey.shade700,
                        ),
                      ),
                    ),
                  ),
                  const SizedBox(width: 12),
                  Expanded(
                    child: ElevatedButton(
                      onPressed: () {
                        Get.back();
                        Get.to(() => const SignInScreen());
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: AppColors.appPrimaryColor,
                        foregroundColor: Colors.white,
                        padding: const EdgeInsets.symmetric(vertical: 13),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      child: Text(
                        'Log in',
                        style: GoogleFonts.poppins(fontWeight: FontWeight.w600),
                      ),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
      barrierDismissible: true,
      transitionDuration: Duration.zero,
    );
  }

  List<VpnServerModel> _filterServers(List<VpnServerModel> servers) {
    if (_searchQuery.isEmpty) return servers;
    return servers.where((server) {
      return server.name.toLowerCase().contains(_searchQuery) ||
          server.cityName.toLowerCase().contains(_searchQuery) ||
          server.countryCode.toLowerCase().contains(_searchQuery);
    }).toList();
  }

  Widget _buildTabSwitcher() {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 0, 16, 12),
      child: Container(
        height: 44,
        padding: const EdgeInsets.all(4),
        decoration: BoxDecoration(
          color: Colors.grey.shade100,
          borderRadius: BorderRadius.circular(12),
        ),
        child: Row(
          children: [
            _tabButton(
              label: 'Free',
              tab: _LocationTab.free,
              icon: Icons.public_rounded,
            ),
            _tabButton(
              label: 'Premium',
              tab: _LocationTab.premium,
              icon: Icons.workspace_premium_rounded,
            ),
          ],
        ),
      ),
    );
  }

  Widget _tabButton({
    required String label,
    required _LocationTab tab,
    required IconData icon,
  }) {
    final selected = _activeTab == tab;
    return Expanded(
      child: GestureDetector(
        onTap: () {
          if (_activeTab == tab) return;
          setState(() => _activeTab = tab);
        },
        child: AnimatedContainer(
          duration: Duration.zero,
          alignment: Alignment.center,
          decoration: BoxDecoration(
            color: selected ? Colors.white : Colors.transparent,
            borderRadius: BorderRadius.circular(10),
            boxShadow: selected
                ? [
                    BoxShadow(
                      color: Colors.black.withValues(alpha: 0.06),
                      blurRadius: 8,
                      offset: const Offset(0, 2),
                    ),
                  ]
                : null,
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(
                icon,
                size: 18,
                color: selected
                    ? AppColors.appPrimaryColor
                    : Colors.grey.shade600,
              ),
              const SizedBox(width: 6),
              Text(
                label,
                style: GoogleFonts.poppins(
                  fontSize: 14,
                  fontWeight: selected ? FontWeight.w600 : FontWeight.w500,
                  color: selected
                      ? AppColors.appPrimaryColor
                      : Colors.grey.shade600,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildAutoSelectCard({
    required VpnServerModel? server,
    required bool isAutoSelectActive,
    required String token,
    required Map<String, dynamic>? profileData,
    required VpnLocationController controller,
  }) {
    final countryCode = server?.countryCode.toLowerCase() ?? '';
    final showSelectedServer = isAutoSelectActive && server != null;
    final activeServer = showSelectedServer ? server : null;

    return Padding(
      padding: const EdgeInsets.fromLTRB(16, 10, 16, 6),
      child: Material(
        color: Colors.white,
        elevation: 0,
        borderRadius: BorderRadius.circular(16),
        child: InkWell(
          borderRadius: BorderRadius.circular(16),
          onTap: () async {
            if (isAutoSelectActive && server != null) {
              await _goHomeAfterServerSelection(server, profileData: profileData);
              return;
            }
            await _applyAutoSelectAndGoHome(
              controller: controller,
              profileData: profileData,
            );
          },
          child: Ink(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(16),
              gradient: LinearGradient(
                colors: [
                  AppColors.appPrimaryColor.withValues(alpha: 0.08),
                  const Color(0xFFFF8C00).withValues(alpha: 0.06),
                ],
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
              ),
              border: Border.all(
                color: isAutoSelectActive
                    ? AppColors.appPrimaryColor
                    : AppColors.appPrimaryColor.withValues(alpha: 0.28),
                width: isAutoSelectActive ? 1.5 : 1,
              ),
            ),
            child: Row(
              children: [
                Container(
                  width: 48,
                  height: 48,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    gradient: LinearGradient(
                      colors: [
                        AppColors.appPrimaryColor,
                        const Color(0xFFFF8C00),
                      ],
                    ),
                  ),
                  child: showSelectedServer && countryCode.isNotEmpty
                      ? ClipOval(
                          child: Image.asset(
                            'assets/flags/$countryCode.png',
                            fit: BoxFit.cover,
                            errorBuilder: (_, __, ___) => const Icon(
                              Icons.bolt_rounded,
                              color: Colors.white,
                              size: 24,
                            ),
                          ),
                        )
                      : const Icon(
                          Icons.bolt_rounded,
                          color: Colors.white,
                          size: 24,
                        ),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        children: [
                          Text(
                            'Auto Select',
                            style: GoogleFonts.poppins(
                              fontSize: 12,
                              fontWeight: FontWeight.w600,
                              color: AppColors.appPrimaryColor,
                              letterSpacing: 0.2,
                            ),
                          ),
                          const SizedBox(width: 6),
                          Container(
                            padding: const EdgeInsets.symmetric(
                              horizontal: 7,
                              vertical: 2,
                            ),
                            decoration: BoxDecoration(
                              color: AppColors.appPrimaryColor.withValues(alpha: 0.12),
                              borderRadius: BorderRadius.circular(8),
                            ),
                            child: Text(
                              'Recommended',
                              style: GoogleFonts.poppins(
                                fontSize: 10,
                                fontWeight: FontWeight.w600,
                                color: AppColors.appPrimaryColor,
                              ),
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 4),
                      Text(
                        showSelectedServer && activeServer != null
                            ? activeServer.name
                            : 'Find the best server for you',
                        style: GoogleFonts.poppins(
                          fontSize: 16,
                          fontWeight: FontWeight.w700,
                          color: Colors.grey.shade900,
                        ),
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                      ),
                    ],
                  ),
                ),
                const SizedBox(width: 8),
                Material(
                  color: Colors.transparent,
                  child: InkWell(
                    onTap: () async {
                      await _applyAutoSelectAndGoHome(
                        controller: controller,
                        profileData: profileData,
                      );
                    },
                    borderRadius: BorderRadius.circular(20),
                    child: Padding(
                      padding: const EdgeInsets.all(8),
                      child: Icon(
                        Icons.refresh_rounded,
                        size: 20,
                        color: Colors.grey.shade700,
                      ),
                    ),
                  ),
                ),
                const SizedBox(width: 4),
                Icon(
                  Icons.arrow_forward_ios_rounded,
                  size: 14,
                  color: AppColors.appPrimaryColor,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildServerTile({
    required VpnServerModel item,
    required String token,
    required Map<String, dynamic>? profileData,
    required bool isSelected,
  }) {
    final countryCode = item.countryCode.toLowerCase();
    final isLocked =
        item.isPremium && (token.isEmpty || !AdEligibility.hasActivePremium(profileData));

    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 6),
      child: Material(
        color: Colors.white,
        borderRadius: BorderRadius.circular(12),
        child: InkWell(
          borderRadius: BorderRadius.circular(12),
          onTap: () => _onServerTap(
            item: item,
            countryCode: countryCode,
            profileData: profileData,
          ),
          child: Ink(
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(12),
              border: Border.all(
                color: isSelected
                    ? AppColors.appPrimaryColor
                    : Colors.black.withValues(alpha: 0.06),
                width: isSelected ? 1.5 : 1,
              ),
              color: isSelected
                  ? AppColors.appPrimaryColor.withValues(alpha: 0.04)
                  : Colors.white,
            ),
            child: ListTile(
              contentPadding:
                  const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              leading: ClipOval(
                child: Image.asset(
                  'assets/flags/$countryCode.png',
                  height: 32,
                  width: 32,
                  fit: BoxFit.cover,
                  errorBuilder: (_, __, ___) => Container(
                    height: 32,
                    width: 32,
                    color: Colors.grey.shade200,
                    child: Icon(Icons.public_rounded,
                        size: 18, color: Colors.grey.shade600),
                  ),
                ),
              ),
              title: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    item.name,
                    style: GoogleFonts.poppins(
                      color: Colors.black,
                      fontSize: 16,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                  if (item.cityName.isNotEmpty)
                    Text(
                      item.cityName,
                      style: GoogleFonts.poppins(
                        color: Colors.black54,
                        fontSize: 14,
                        fontWeight: FontWeight.w400,
                      ),
                    ),
                  const SizedBox(height: 4),
                  Text(
                    item.isOpenVpn ? 'OpenVPN' : 'V2Ray',
                    style: GoogleFonts.poppins(
                      color: item.isOpenVpn
                          ? Colors.green.shade700
                          : Colors.blue.shade700,
                      fontSize: 12,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
                ],
              ),
              trailing: isSelected
                  ? Container(
                      padding: const EdgeInsets.symmetric(
                        horizontal: 10,
                        vertical: 6,
                      ),
                      decoration: BoxDecoration(
                        color: AppColors.appPrimaryColor.withValues(alpha: 0.12),
                        borderRadius: BorderRadius.circular(20),
                      ),
                      child: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          Icon(Icons.check_circle_rounded,
                              color: AppColors.appPrimaryColor, size: 16),
                          const SizedBox(width: 4),
                          Text(
                            'Active',
                            style: GoogleFonts.poppins(
                              color: AppColors.appPrimaryColor,
                              fontSize: 12,
                              fontWeight: FontWeight.w600,
                            ),
                          ),
                        ],
                      ),
                    )
                  : isLocked
                  ? Icon(Icons.lock_rounded, color: Colors.amber.shade700, size: 22)
                  : item.isPremium
                      ? Icon(Icons.workspace_premium_rounded,
                          color: AppColors.appPrimaryColor, size: 22)
                      : Icon(Icons.chevron_right_rounded,
                          color: Colors.grey.shade400),
            ),
          ),
        ),
      ),
    );
  }



  @override
  void dispose() {
    _searchController.dispose();
    try {
      _interstitialAd?.dispose();
    } catch (_) {}
    super.dispose();
  }

  InterstitialAd? _interstitialAd;

  void _createInterstitialAd() {
    final unitId = AdHelper.interstitialAdUnitId;
    if (unitId.isEmpty) {
      if (kDebugMode) print('Interstitial ad unit id missing - skipping load');
      return;
    }
    InterstitialAd.load(
        adUnitId: unitId,
        request: const AdRequest(),
        adLoadCallback: InterstitialAdLoadCallback(
          onAdLoaded: (InterstitialAd ad) {
            if (kDebugMode) {
              print('$ad loaded');
            }
            _interstitialAd = ad;
            _interstitialAd!.setImmersiveMode(true);
          },
          onAdFailedToLoad: (LoadAdError error) {
            if (kDebugMode) {
              print('InterstitialAd failed to load: $error.');
            }
            _interstitialAd = null;
          },
        ));
  }
  void _showInterstitialAd() {
    if (_interstitialAd == null) {
      log('Warning: attempt to show interstitial before loaded.');
      return;
    }
    _interstitialAd!.fullScreenContentCallback = FullScreenContentCallback(
      onAdShowedFullScreenContent: (InterstitialAd ad) =>
          log('ad onAdShowedFullScreenContent.'),
      onAdDismissedFullScreenContent: (InterstitialAd ad) {
        log('\$ad onAdDismissedFullScreenContent.');
        ad.dispose();
        _createInterstitialAd();
      },
      onAdFailedToShowFullScreenContent: (InterstitialAd ad, AdError error) {
        log('\$ad onAdFailedToShowFullScreenContent: $error');
        ad.dispose();
        _createInterstitialAd();
      },
    );
    _interstitialAd!.show();
    _interstitialAd = null;
  }

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addPostFrameCallback((_) async {
      Map<String, dynamic>? profile;
      final token = await Get.find<AuthController>().getAuthToken();
      if (token.isNotEmpty) {
        await Get.find<ProfileController>().getProfileData();
        profile = Get.find<ProfileController>().profileData;
      }
      await Get.find<VpnLocationController>().loadServers(profile: profile);
      checkAuthAndFetchProfile();
      _loadInterstitialIfNeeded();
    });
  }

  Future<void> _loadInterstitialIfNeeded() async {
    Map<String, dynamic>? profile;
    final token = await Get.find<AuthController>().getAuthToken();
    if (token.isNotEmpty) {
      await Get.find<ProfileController>().getProfileData();
      profile = Get.find<ProfileController>().profileData;
    }
    if (!AdEligibility.shouldShowAdsForUser(profile)) return;

    final appCtrl = Get.isRegistered<AppSettingController>()
        ? Get.find<AppSettingController>()
        : null;
    if (appCtrl != null &&
        appCtrl.shouldShowInterstitial &&
        AdHelper.interstitialAdUnitId.isNotEmpty) {
      _createInterstitialAd();
    }
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<VpnLocationController>(
      builder: (vpnLocationController) {
        return GetBuilder<ProfileController>(
          builder: (profileController) {
            final isLoading = vpnLocationController.isLoading;
            final isRefreshing = vpnLocationController.isRefreshing;
            final loadError = vpnLocationController.loadError;
            final selectedServerId = vpnLocationController.selectedServerId;
            final tabServers = _activeTab == _LocationTab.free
                ? vpnLocationController.freeServers
                : vpnLocationController.premiumServers;
            final filteredServers = _filterServers(tabServers);
            final selectedServer = vpnLocationController.selectedServer;
            final isAutoSelectActive = vpnLocationController.isAutoSelectMode;
            final profileData = profileController.profileData;
            final showAutoSelectCard = _searchQuery.isEmpty &&
                (_activeTab == _LocationTab.free ||
                    AdEligibility.hasActivePremium(profileData));

            return Scaffold(
              backgroundColor: const Color(0xFFF4F6F8),
              appBar: AppBar(
                centerTitle: true,
                backgroundColor: Colors.white,
                elevation: 0,
                scrolledUnderElevation: 0,
                surfaceTintColor: Colors.transparent,
                leading: IconButton(
                  onPressed: Get.back,
                  icon: Icon(Icons.arrow_back_ios_new_rounded,
                      color: Colors.grey.shade800, size: 20),
                ),
                title: Text(
                  'VPN Locations',
                  style: GoogleFonts.poppins(
                    color: Colors.grey.shade900,
                    fontSize: 17,
                    fontWeight: FontWeight.w600,
                  ),
                ),
                actions: [
                  if (isRefreshing)
                    Padding(
                      padding: const EdgeInsets.only(right: 16),
                      child: SizedBox(
                        width: 18,
                        height: 18,
                        child: CircularProgressIndicator(
                          strokeWidth: 2,
                          color: AppColors.appPrimaryColor,
                        ),
                      ),
                    ),
                ],
              ),
              body: SafeArea(
                top: false,
                child: Column(
                  children: [
                    Padding(
                      padding: const EdgeInsets.fromLTRB(16, 16, 16, 0),
                      child: TextField(
                        controller: _searchController,
                        onChanged: (value) {
                          setState(() {
                            _searchQuery = value.trim().toLowerCase();
                          });
                        },
                        style: GoogleFonts.poppins(color: Colors.black87),
                        decoration: InputDecoration(
                          hintText: 'Search locations...',
                          hintStyle: GoogleFonts.poppins(
                            fontSize: 15,
                            color: Colors.grey.shade500,
                          ),
                          prefixIcon: Icon(Icons.search_rounded,
                              color: Colors.grey.shade500),
                          suffixIcon: _searchQuery.isNotEmpty
                              ? IconButton(
                                  icon: Icon(Icons.clear_rounded,
                                      color: Colors.grey.shade600),
                                  onPressed: () {
                                    setState(() {
                                      _searchController.clear();
                                      _searchQuery = '';
                                    });
                                  },
                                )
                              : null,
                          filled: true,
                          fillColor: Colors.white,
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(12),
                            borderSide: BorderSide(color: Colors.grey.shade200),
                          ),
                          enabledBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(12),
                            borderSide: BorderSide(color: Colors.grey.shade200),
                          ),
                          focusedBorder: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(12),
                            borderSide: BorderSide(
                              color: AppColors.appPrimaryColor.withValues(alpha: 0.6),
                            ),
                          ),
                          contentPadding: const EdgeInsets.symmetric(
                            horizontal: 16,
                            vertical: 12,
                          ),
                        ),
                      ),
                    ),
                    const SizedBox(height: 16),
                    _buildTabSwitcher(),
                    Expanded(
                      child: isLoading
                          ? Center(
                              child: CircularProgressIndicator(
                                color: AppColors.appPrimaryColor,
                                strokeWidth: 2,
                              ),
                            )
                          : loadError != null && tabServers.isEmpty
                              ? _buildErrorState(loadError)
                              : FutureBuilder<String>(
                                  future: _authTokenFuture,
                                  builder: (context, snapshot) {
                                    final token = snapshot.data ?? '';
                                    final profileData =
                                        profileController.profileData;

                                    if (filteredServers.isEmpty && !showAutoSelectCard) {
                                      return _buildEmptyState();
                                    }

                                    return ListView.builder(
                                      padding: const EdgeInsets.only(bottom: 16),
                                      itemCount: filteredServers.length +
                                          (showAutoSelectCard ? 1 : 0),
                                      physics: const BouncingScrollPhysics(),
                                      itemBuilder: (context, index) {
                                        if (showAutoSelectCard && index == 0) {
                                          return _buildAutoSelectCard(
                                            server: isAutoSelectActive
                                                ? selectedServer
                                                : null,
                                            isAutoSelectActive: isAutoSelectActive,
                                            token: token,
                                            profileData: profileData,
                                            controller: vpnLocationController,
                                          );
                                        }

                                        final serverIndex =
                                            showAutoSelectCard ? index - 1 : index;
                                        final item = filteredServers[serverIndex];

                                        return _buildServerTile(
                                          item: item,
                                          token: token,
                                          profileData: profileData,
                                          isSelected: !isAutoSelectActive &&
                                              selectedServerId != null &&
                                              selectedServerId.toString() ==
                                                  item.id.toString(),
                                        );
                                      },
                                    );
                                  },
                                ),
                    ),
                  ],
                ),
              ),
            );
          },
        );
      },
    );
  }

  Widget _buildEmptyState() {
    final isFreeTab = _activeTab == _LocationTab.free;
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(32),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              isFreeTab ? Icons.public_off_rounded : Icons.workspace_premium_outlined,
              size: 48,
              color: Colors.grey.shade400,
            ),
            const SizedBox(height: 16),
            Text(
              _searchQuery.isNotEmpty
                  ? 'No matching servers'
                  : isFreeTab
                      ? 'No free servers available'
                      : 'No premium servers available',
              textAlign: TextAlign.center,
              style: GoogleFonts.poppins(
                fontSize: 16,
                fontWeight: FontWeight.w600,
                color: Colors.grey.shade800,
              ),
            ),
            if (_searchQuery.isNotEmpty) ...[
              const SizedBox(height: 8),
              Text(
                'Try a different search term',
                style: GoogleFonts.poppins(
                  fontSize: 14,
                  color: Colors.grey.shade600,
                ),
              ),
            ],
          ],
        ),
      ),
    );
  }

  Widget _buildErrorState(String message) {
    return Center(
      child: Padding(
        padding: const EdgeInsets.all(32),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.cloud_off_rounded, size: 48, color: Colors.grey.shade400),
            const SizedBox(height: 16),
            Text(
              'Could not load servers',
              style: GoogleFonts.poppins(
                fontSize: 16,
                fontWeight: FontWeight.w600,
                color: Colors.grey.shade800,
              ),
            ),
            const SizedBox(height: 8),
            Text(
              message,
              textAlign: TextAlign.center,
              style: GoogleFonts.poppins(
                fontSize: 14,
                color: Colors.grey.shade600,
              ),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () async {
                Map<String, dynamic>? profile;
                final token = await Get.find<AuthController>().getAuthToken();
                if (token.isNotEmpty) {
                  await Get.find<ProfileController>().getProfileData();
                  profile = Get.find<ProfileController>().profileData;
                }
                await Get.find<VpnLocationController>().loadServers(
                  forceRefresh: true,
                  profile: profile,
                );
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: AppColors.appPrimaryColor,
                foregroundColor: Colors.white,
                padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(12),
                ),
              ),
              child: Text(
                'Retry',
                style: GoogleFonts.poppins(fontWeight: FontWeight.w600),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

enum _LocationTab { free, premium }
