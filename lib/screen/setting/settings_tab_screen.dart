import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:free_vpn/screen/apps/split_tunnel.dart';
import 'package:free_vpn/screen/setting/contact_us_screen.dart';
import 'package:free_vpn/screen/setting/help_center_screen.dart';
import 'package:free_vpn/utils/app_colors.dart';
import 'package:free_vpn/utils/app_strings.dart';
import 'dynamic_content_screen.dart';

class SettingsTabScreen extends StatelessWidget {
  const SettingsTabScreen({super.key});

  static const _pageBg = Color(0xFFF4F6F8);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: _pageBg,
      body: SafeArea(
        child: ListView(
          padding: const EdgeInsets.fromLTRB(20, 12, 20, 28),
          children: [
            Text(
              'Settings',
              style: GoogleFonts.poppins(
                fontSize: 26,
                fontWeight: FontWeight.w700,
                color: const Color(0xFF111827),
                letterSpacing: -0.3,
              ),
            ),
            const SizedBox(height: 4),
            Text(
              AppStrings.appName,
              style: GoogleFonts.poppins(
                fontSize: 14,
                fontWeight: FontWeight.w500,
                color: Colors.grey.shade600,
              ),
            ),
            const SizedBox(height: 24),
            const _SectionLabel('VPN'),
            _SettingsGroup(
              items: [
                _SettingsItem(
                  icon: Icons.call_split_rounded,
                  title: 'Split Tunneling',
                  subtitle: 'Choose apps to bypass VPN',
                  onTap: presentSplitTunnelConfirmation,
                ),
              ],
            ),
            const SizedBox(height: 20),
            const _SectionLabel('Support'),
            _SettingsGroup(
              items: [
                _SettingsItem(
                  icon: Icons.mail_outline_rounded,
                  title: 'Contact Us',
                  onTap: () => Get.to(() => const ContactUsScreen()),
                ),
                _SettingsItem(
                  icon: Icons.help_outline_rounded,
                  title: 'Help Center',
                  onTap: () => Get.to(() => HelpCenterScreen()),
                ),
              ],
            ),
            const SizedBox(height: 20),
            const _SectionLabel('Legal'),
            _SettingsGroup(
              items: [
                _SettingsItem(
                  icon: Icons.privacy_tip_outlined,
                  title: 'Privacy Policy',
                  onTap: () => Get.to(
                    () => const DynamicContentScreen(
                      title: 'Privacy Policy',
                      prefKey: 'privacy_policy',
                    ),
                  ),
                ),
                _SettingsItem(
                  icon: Icons.description_outlined,
                  title: 'Terms of Service',
                  onTap: () => Get.to(
                    () => const DynamicContentScreen(
                      title: 'Terms & Conditions',
                      prefKey: 'terms_conditions',
                    ),
                  ),
                ),
                _SettingsItem(
                  icon: Icons.info_outline_rounded,
                  title: 'About Us',
                  onTap: () => Get.to(
                    () => const DynamicContentScreen(
                      title: 'About Us',
                      prefKey: 'about_us',
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 20),
            const _SectionLabel('More'),
            _SettingsGroup(
              items: [
                _SettingsItem(
                  icon: Icons.star_outline_rounded,
                  title: 'Rate Us',
                  onTap: () => _openPrefUrl(
                    prefKey: 'rate_app_url',
                    emptyMsg: 'No rate link available',
                  ),
                ),
                _SettingsItem(
                  icon: Icons.share_outlined,
                  title: 'Share App',
                  onTap: () async {
                    final prefs = await SharedPreferences.getInstance();
                    final shareUrl = prefs.getString('share_app_url') ?? '';
                    if (shareUrl.isNotEmpty) {
                      await Clipboard.setData(ClipboardData(text: shareUrl));
                      Fluttertoast.showToast(
                        msg: 'Share link copied to clipboard',
                        backgroundColor: Colors.green,
                      );
                    } else {
                      Fluttertoast.showToast(
                        msg: 'No share link available',
                        backgroundColor: Colors.orange,
                      );
                    }
                  },
                ),
                _SettingsItem(
                  icon: Icons.apps_rounded,
                  title: 'More Apps',
                  onTap: () => _openPrefUrl(
                    prefKey: 'more_app_url',
                    emptyMsg: 'No link available',
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }

  static Future<void> _openPrefUrl({
    required String prefKey,
    required String emptyMsg,
  }) async {
    final prefs = await SharedPreferences.getInstance();
    final url = prefs.getString(prefKey) ?? '';
    if (url.isEmpty) {
      Fluttertoast.showToast(
        msg: emptyMsg,
        backgroundColor: Colors.orange,
      );
      return;
    }
    final uri = Uri.parse(url);
    if (await canLaunchUrl(uri)) {
      await launchUrl(uri, mode: LaunchMode.externalApplication);
    } else {
      Fluttertoast.showToast(
        msg: 'Cannot open URL',
        backgroundColor: Colors.red,
      );
    }
  }
}

class _SectionLabel extends StatelessWidget {
  const _SectionLabel(this.text);

  final String text;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(left: 4, bottom: 8),
      child: Text(
        text.toUpperCase(),
        style: GoogleFonts.poppins(
          fontSize: 11,
          fontWeight: FontWeight.w600,
          letterSpacing: 0.8,
          color: Colors.grey.shade500,
        ),
      ),
    );
  }
}

class _SettingsGroup extends StatelessWidget {
  const _SettingsGroup({required this.items});

  final List<_SettingsItem> items;

  @override
  Widget build(BuildContext context) {
    return DecoratedBox(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.grey.shade200),
      ),
      child: Column(
        children: [
          for (var i = 0; i < items.length; i++) ...[
            items[i],
            if (i < items.length - 1)
              Divider(
                height: 1,
                thickness: 1,
                indent: 56,
                endIndent: 16,
                color: Colors.grey.shade100,
              ),
          ],
        ],
      ),
    );
  }
}

class _SettingsItem extends StatelessWidget {
  const _SettingsItem({
    required this.icon,
    required this.title,
    required this.onTap,
    this.subtitle,
  });

  final IconData icon;
  final String title;
  final String? subtitle;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: onTap,
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
        child: Row(
          children: [
            Container(
              width: 36,
              height: 36,
              decoration: BoxDecoration(
                color: AppColors.appPrimaryColor.withValues(alpha: 0.1),
                borderRadius: BorderRadius.circular(10),
              ),
              child: Icon(
                icon,
                size: 20,
                color: AppColors.appPrimaryColor,
              ),
            ),
            const SizedBox(width: 14),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    title,
                    style: GoogleFonts.poppins(
                      fontSize: 15,
                      fontWeight: FontWeight.w500,
                      color: const Color(0xFF1F2937),
                    ),
                  ),
                  if (subtitle != null) ...[
                    const SizedBox(height: 2),
                    Text(
                      subtitle!,
                      style: GoogleFonts.poppins(
                        fontSize: 12,
                        color: Colors.grey.shade500,
                      ),
                    ),
                  ],
                ],
              ),
            ),
            Icon(
              Icons.chevron_right_rounded,
              size: 22,
              color: Colors.grey.shade400,
            ),
          ],
        ),
      ),
    );
  }
}
