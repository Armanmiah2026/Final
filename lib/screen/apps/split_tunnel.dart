import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:installed_apps/app_info.dart';
import 'package:installed_apps/installed_apps.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:free_vpn/utils/split_tunnel_storage.dart';

import '../../utils/app_colors.dart';

/// Shows privacy consent and a preview list of installed apps, then opens [SplitTunnelScreen] if confirmed.
Future<void> presentSplitTunnelConfirmation() async {
  final confirmed = await Get.dialog<bool>(
    const _SplitTunnelConsentDialog(),
    barrierDismissible: false,
    transitionDuration: Duration.zero,
  );
  if (confirmed == true) {
    Get.to(() => const SplitTunnelScreen());
  }
}

class _SplitTunnelConsentDialog extends StatefulWidget {
  const _SplitTunnelConsentDialog();

  @override
  State<_SplitTunnelConsentDialog> createState() =>
      _SplitTunnelConsentDialogState();
}

class _SplitTunnelConsentDialogState extends State<_SplitTunnelConsentDialog> {
  List<AppInfo> _apps = [];
  bool _loading = true;
  String? _error;

  @override
  void initState() {
    super.initState();
    _loadApps();
  }

  Future<void> _loadApps() async {
    setState(() {
      _loading = true;
      _error = null;
    });
    try {
      final apps = await InstalledApps.getInstalledApps(true, true);
      if (!mounted) return;
      apps.sort((a, b) =>
          a.name.toLowerCase().compareTo(b.name.toLowerCase()));
      setState(() {
        _apps = apps;
        _loading = false;
      });
    } catch (e) {
      if (!mounted) return;
      setState(() {
        _loading = false;
        _error =
            'Could not load your app list. Check permissions and try again.';
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    final primary = AppColors.appPrimaryColor;

    return Dialog(
      insetPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 24),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      backgroundColor: Colors.white,
      child: Padding(
        padding: const EdgeInsets.fromLTRB(20, 20, 20, 16),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Row(
              children: [
                Container(
                  padding: const EdgeInsets.all(10),
                  decoration: BoxDecoration(
                    color: primary.withValues(alpha: 0.12),
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Icon(Icons.privacy_tip_rounded, color: primary, size: 26),
                ),
                const SizedBox(width: 12),
                Expanded(
                  child: Text(
                    'Split tunneling access',
                    style: GoogleFonts.poppins(
                      fontSize: 18,
                      fontWeight: FontWeight.w700,
                      color: Colors.grey.shade900,
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 14),
            Text(
              'To configure split tunneling, this screen needs to read the list of '
              'applications installed on this device. Below is what will be shown on '
              'the next screen.',
              style: GoogleFonts.poppins(
                fontSize: 13.5,
                height: 1.45,
                color: Colors.grey.shade700,
              ),
            ),
            const SizedBox(height: 12),
            SizedBox(
              height: 220,
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: Colors.grey.shade50,
                  borderRadius: BorderRadius.circular(14),
                  border: Border.all(color: Colors.grey.shade200),
                ),
                child: _loading
                    ? const Center(
                        child: SizedBox(
                          width: 28,
                          height: 28,
                          child: CircularProgressIndicator(
                            strokeWidth: 2.5,
                            color: AppColors.appPrimaryColor,
                          ),
                        ),
                      )
                    : _error != null
                        ? Padding(
                            padding: const EdgeInsets.all(16),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                Icon(Icons.error_outline_rounded,
                                    color: Colors.red.shade400, size: 36),
                                const SizedBox(height: 10),
                                Text(
                                  _error!,
                                  textAlign: TextAlign.center,
                                  style: GoogleFonts.poppins(
                                    fontSize: 13,
                                    color: Colors.grey.shade800,
                                  ),
                                ),
                                const SizedBox(height: 12),
                                TextButton.icon(
                                  onPressed: _loadApps,
                                  icon: const Icon(Icons.refresh_rounded, size: 20),
                                  label: Text(
                                    'Retry',
                                    style: GoogleFonts.poppins(
                                      fontWeight: FontWeight.w600,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          )
                        : _apps.isEmpty
                            ? Center(
                                child: Text(
                                  'No apps found.',
                                  style: GoogleFonts.poppins(
                                    color: Colors.grey.shade600,
                                  ),
                                ),
                              )
                            : Column(
                                crossAxisAlignment: CrossAxisAlignment.stretch,
                                children: [
                                  Padding(
                                    padding: const EdgeInsets.fromLTRB(
                                        12, 10, 12, 6),
                                    child: Text(
                                      '${_apps.length} apps on this device',
                                      style: GoogleFonts.poppins(
                                        fontSize: 12,
                                        fontWeight: FontWeight.w600,
                                        color: Colors.grey.shade600,
                                      ),
                                    ),
                                  ),
                                  Expanded(
                                    child: ListView.separated(
                                      padding: const EdgeInsets.only(
                                        left: 8,
                                        right: 8,
                                        bottom: 8,
                                      ),
                                      itemCount: _apps.length,
                                      separatorBuilder: (_, __) =>
                                          Divider(height: 1, color: Colors.grey.shade200),
                                      itemBuilder: (context, index) {
                                        final app = _apps[index];
                                        return ListTile(
                                          dense: true,
                                          contentPadding:
                                              const EdgeInsets.symmetric(
                                            horizontal: 8,
                                            vertical: 0,
                                          ),
                                          leading: app.icon != null
                                              ? Image.memory(
                                                  app.icon!,
                                                  width: 32,
                                                  height: 32,
                                                )
                                              : Icon(Icons.apps_rounded,
                                                  size: 28,
                                                  color: Colors.grey.shade500),
                                          title: Text(
                                            app.name,
                                            maxLines: 1,
                                            overflow: TextOverflow.ellipsis,
                                            style: GoogleFonts.poppins(
                                              fontSize: 13.5,
                                              fontWeight: FontWeight.w500,
                                            ),
                                          ),
                                          subtitle: Text(
                                            app.packageName,
                                            maxLines: 1,
                                            overflow: TextOverflow.ellipsis,
                                            style: GoogleFonts.poppins(
                                              fontSize: 11,
                                              color: Colors.grey.shade600,
                                            ),
                                          ),
                                        );
                                      },
                                    ),
                                  ),
                                ],
                              ),
              ),
            ),
            const SizedBox(height: 14),
            Text(
              'Are you sure you want to continue?',
              textAlign: TextAlign.center,
              style: GoogleFonts.poppins(
                fontSize: 14,
                fontWeight: FontWeight.w600,
                color: Colors.grey.shade900,
              ),
            ),
            const SizedBox(height: 16),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton(
                    onPressed: () => Get.back(result: false),
                    style: OutlinedButton.styleFrom(
                      padding: const EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                    child: Text(
                      'Cancel',
                      style: GoogleFonts.poppins(fontWeight: FontWeight.w600),
                    ),
                  ),
                ),
                const SizedBox(width: 12),
                Expanded(
                  flex: 2,
                  child: FilledButton(
                    onPressed: _loading || _error != null
                        ? null
                        : () => Get.back(result: true),
                    style: FilledButton.styleFrom(
                      backgroundColor: primary,
                      foregroundColor: Colors.white,
                      disabledBackgroundColor: Colors.grey.shade300,
                      padding: const EdgeInsets.symmetric(vertical: 14),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                    child: Text(
                      'Yes, continue',
                      style: GoogleFonts.poppins(fontWeight: FontWeight.w600),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

class SplitTunnelScreen extends StatefulWidget {
  const SplitTunnelScreen({super.key});

  @override
  State<SplitTunnelScreen> createState() => _SplitTunnelScreenState();
}

class _SplitTunnelScreenState extends State<SplitTunnelScreen> {
  List<AppInfo> _apps = [];
  Set<String> _enabledApps = {};

  @override
  void initState() {
    super.initState();
    _loadApps();
    _loadEnabledApps();
  }

  Future<void> _loadApps() async {
    final apps = await InstalledApps.getInstalledApps(true, true);
    setState(() {
      _apps = apps;
    });
  }

  Future<void> _loadEnabledApps() async {
    final saved = await loadSplitTunnelBypassPackages();
    setState(() {
      _enabledApps = saved.toSet();
    });
  }

  Future<void> _toggleApp(String packageName, bool enabled) async {
    setState(() {
      if (enabled) {
        _enabledApps.add(packageName);
      } else {
        _enabledApps.remove(packageName);
      }
    });
    await saveSplitTunnelBypassPackages(_enabledApps.toList());
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white, // switched to white
        elevation: 1,
        centerTitle: true,
        title: Text('Split Tunnel',style: GoogleFonts.poppins(
            fontSize: 16,
            fontWeight: FontWeight.w600,
            color: Colors.black // dark title on white
        ),),
        automaticallyImplyLeading: false,
        leading: IconButton(
          onPressed: (){
            Get.back();
          },
          icon: const Icon(Icons.arrow_back,color: Colors.black,size: 20,),
        ),
        iconTheme: const IconThemeData(color: Colors.black),
      ),
      backgroundColor: Colors.white, // overall background white
      body: _apps.isEmpty
          ? const Center(child: SizedBox(
          height: 30,width: 30,
          child: CircularProgressIndicator(
            color: Colors.orange,
            strokeWidth: 2,
          )))
          : ListView.builder(
        itemCount: _apps.length,
        itemBuilder: (context, index) {
          final app = _apps[index];
          final isEnabled = _enabledApps.contains(app.packageName);
          return ListTile(
            leading: app.icon != null
                ? Image.memory(app.icon!, width: 40, height: 40)
                : Icon(Icons.android, size: 40, color: AppColors.appPrimaryColor),
            title: Text(app.name,style: GoogleFonts.poppins(
                color: Colors.black,
                fontWeight: FontWeight.w500,
                letterSpacing: 0,
                fontSize: 16
            ),),
            subtitle: Text(app.packageName,style: GoogleFonts.poppins(
                color: Colors.black.withValues(alpha: 0.7),
                fontWeight: FontWeight.w500,
                letterSpacing: 0,
                fontSize: 14
            ),),
            trailing: Switch(
              activeColor: AppColors.appPrimaryColor,
              value: isEnabled,
              onChanged: (value) async {
                await _toggleApp(app.packageName, value);
                Fluttertoast.showToast(
                  msg: 'Saved. Reconnect VPN to apply split tunnel changes.',
                  backgroundColor: AppColors.appPrimaryColor,
                  textColor: Colors.white,
                );
              },
            ),
          );
        },
      ),
    );
  }
}
