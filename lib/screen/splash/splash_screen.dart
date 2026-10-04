import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:free_vpn/screen/main_shell_screen.dart';
import 'package:free_vpn/utils/app_colors.dart';
import 'package:free_vpn/utils/app_strings.dart';
import 'package:url_launcher/url_launcher.dart';
// Import controllers to use typed Get.find
import 'package:free_vpn/controller/app_update_controller.dart';
import 'package:free_vpn/controller/general_setting_controller.dart';
import 'package:free_vpn/controller/app_setting_controller.dart';

// Splash Screen
class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  AppUpdateController? _appUpdateController;
  GeneralSettingController? _generalSettingController;
  AppSettingController? _appSettingController;

  @override
  void initState() {
    super.initState();
    _initializeApp();
  }

  Future<void> _initializeApp() async {
    // Attempt to get controllers only if registered to prevent runtime errors
    if (Get.isRegistered<AppUpdateController>()) {
      _appUpdateController = Get.find<AppUpdateController>();
    } else {
      if (kDebugMode) print('AppUpdateController not registered yet');
    }

    if (Get.isRegistered<GeneralSettingController>()) {
      _generalSettingController = Get.find<GeneralSettingController>();
    } else {
      if (kDebugMode) print('GeneralSettingController not registered yet');
    }

    if (Get.isRegistered<AppSettingController>()) {
      _appSettingController = Get.find<AppSettingController>();
    } else {
      if (kDebugMode) print('AppSettingController not registered yet');
    }

    try {
      // Optimization: app update info is critical for forced-update UX, so fetch it first
      // with a short timeout. Other settings (general/app) are fetched in background so
      // they don't block splash navigation.
      if (_appUpdateController != null) {
        try {
          await _appUpdateController!.getUpdateData().timeout(const Duration(seconds: 2));
        } catch (e) {
          if (kDebugMode) print('App update fetch timeout or error: $e');
        }
      }

      // Start general & app settings fetch in background (do not await) to avoid blocking
      if (_generalSettingController != null) {
        _generalSettingController!.getGeneralData().catchError((e) {
          if (kDebugMode) print('General setting fetch failed: $e');
        });
      }
      if (_appSettingController != null) {
        _appSettingController!.getAppSettingData().catchError((e) {
          if (kDebugMode) print('App setting fetch failed: $e');
        });
      }
    } catch (e) {
      if (kDebugMode) print('Error fetching initial data: $e');
    }

    // Small delay for splash screen visibility
    await Future.delayed(const Duration(milliseconds: 500));

    // Check for app updates after data is fetched
    // Check update data; _checkForUpdates will use cached data from controller if available.
    bool updateDialogShown = await _checkForUpdates();

    // If force update dialog is shown (blocking) then don't navigate
    if (updateDialogShown) {
      return;
    }

    // Wait for remaining splash screen duration
    await Future.delayed(const Duration(seconds: 2));

    if (!mounted) return;

    await _navigateToSelectedProtocol();
  }

  Future<bool> _checkForUpdates() async {
    try {
      final updateData = (_appUpdateController == null || _appUpdateController!.appUpdateData == null)
          ? null
          : _appUpdateController!.appUpdateData;

      if (updateData == null) return false;

      // Get current app version. PackageInfo not available in this build environment, default to '1.0.0'
      String currentVersion = '1.0.0';

      // Get remote version info
      String remoteVersion = updateData['app_version'] ?? '1.0.0';
      String forceUpdate = updateData['force_update'] ?? '0';
      String popupTitle = updateData['popup_title'] ?? 'New Update Available!';
      String popupContent = updateData['popup_content'] ?? 'Please update the app to get new features!';
      String appUrl = updateData['app_url'] ?? '';

      // Compare versions
      if (_isUpdateRequired(currentVersion, remoteVersion)) {
        if (!mounted) return false;

        bool isForced = forceUpdate == '1';

        await _showUpdateDialog(
          title: popupTitle,
          content: popupContent,
          appUrl: appUrl,
          isForceUpdate: isForced,
        );

        // Return true only if it's a forced update (to block navigation)
        return isForced;
      }

      return false;
    } catch (e) {
      if (kDebugMode) {
        print('Error checking for updates: $e');
      }
      return false;
    }
  }

  bool _isUpdateRequired(String currentVersion, String remoteVersion) {
    try {
      List<int> current = currentVersion.split('.').map(int.parse).toList();
      List<int> remote = remoteVersion.split('.').map(int.parse).toList();

      // Pad with zeros if needed
      while (current.length < 3) {
        current.add(0);
      }
      while (remote.length < 3) {
        remote.add(0);
      }

      // Compare major.minor.patch
      for (int i = 0; i < 3; i++) {
        if (remote[i] > current[i]) return true;
        if (remote[i] < current[i]) return false;
      }
      return false;
    } catch (e) {
      return false;
    }
  }

  Future<void> _showUpdateDialog({
    required String title,
    required String content,
    required String appUrl,
    required bool isForceUpdate,
  }) async {
    // Use Get.dialog (GetX) to show the same dialog content. Returns when dialog is closed.
    await Get.dialog(
      PopScope(
        canPop: !isForceUpdate,
        child: Dialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
          child: Container(
            padding: const EdgeInsets.all(24),
            decoration: BoxDecoration(
              gradient: const LinearGradient(
                begin: Alignment.topLeft,
                end: Alignment.bottomRight,
                colors: [Color(0xff2fd9fc), Color(0xFF5FB563)],
              ),
              borderRadius: BorderRadius.circular(20),
            ),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Container(
                  padding: const EdgeInsets.all(20),
                  decoration: BoxDecoration(
                    color: Colors.white.withValues(alpha: 0.12),
                    shape: BoxShape.circle,
                  ),
                  child: const Icon(Icons.system_update_rounded, size: 60, color: Colors.white),
                ),
                const SizedBox(height: 18),
                Text(title, style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.white), textAlign: TextAlign.center),
                const SizedBox(height: 12),
                Text(content, style: TextStyle(fontSize: 15, color: Colors.white.withValues(alpha: 0.95), height: 1.4), textAlign: TextAlign.center),
                const SizedBox(height: 20),
                SizedBox(
                  width: double.infinity,
                  height: 48,
                  child: ElevatedButton(
                    onPressed: () async {
                      if (appUrl.isNotEmpty) {
                        final uri = Uri.parse(appUrl);
                        if (await canLaunchUrl(uri)) await launchUrl(uri, mode: LaunchMode.externalApplication);
                      }
                    },
                    style: ElevatedButton.styleFrom(backgroundColor: const Color(0xFF1A1A2E), shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10))),
                    child: const Row(mainAxisAlignment: MainAxisAlignment.center, children: [Icon(Icons.download_rounded), SizedBox(width: 8), Text('Update Now')]),
                  ),
                ),
                if (!isForceUpdate) ...[
                  const SizedBox(height: 12),
                  TextButton(
                    onPressed: () {
                      Get.back();
                    },
                    child: Text('Maybe Later', style: TextStyle(color: Colors.white.withValues(alpha: 0.85))),
                  ),
                ],
              ],
            ),
          ),
        ),
      ),
      barrierDismissible: !isForceUpdate,
      transitionDuration: Duration.zero,
    );

    // If user selected Maybe Later (non-forced), continue navigation from caller
  }

  Future<void> _navigateToSelectedProtocol() async {
    // Default: navigate to HomeScreen. Modify this function to navigate to specific protocol screens
    // based on saved preference or controller values.
    Get.off(() => const MainShellScreen());
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Container(
        width: double.infinity,
        height: double.infinity,
        color: Colors.white,
        child: Stack(
          children: [
            Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Image.asset(
                    "assets/images/app_logo.png",
                    height: 130,
                    width: 130,
                    fit: BoxFit.cover,
                  ),
                  const SizedBox(height: 28),
                  Text(
                    AppStrings.appName,
                    style: TextStyle(
                      fontSize: 28,
                      fontWeight: FontWeight.w700,
                      color: Colors.grey.shade900,
                      letterSpacing: -0.4,
                    ),
                  ),
                  const SizedBox(height: 10),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 32),
                    child: Text(
                      'Fast Powerful VPN Ever',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 15,
                        height: 1.35,
                        color: Colors.black.withValues(alpha: 0.52),
                        fontWeight: FontWeight.w500,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            Positioned(
              bottom: 100,
              left: 0,
              right: 0,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  SizedBox(
                    width: 24,
                    height: 24,
                    child: CircularProgressIndicator(
                      strokeWidth: 3,
                      valueColor: AlwaysStoppedAnimation<Color>(
                        AppColors.appPrimaryColor,
                      ),
                    ),
                  ),
                  const SizedBox(width: 12),
                  Text(
                    'Processing....',
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.black.withValues(alpha: 0.55),
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

}
