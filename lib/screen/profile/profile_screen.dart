import 'dart:developer';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:intl/intl.dart';
import 'package:free_vpn/screen/auth/signin_screen.dart';
import 'package:free_vpn/utils/app_colors.dart';
import '../../controller/auth_controller.dart';
import '../../controller/profile_controller.dart';

class ProfileScreen extends StatefulWidget {
  final bool showBackButton;

  const ProfileScreen({super.key, this.showBackButton = true});

  @override
  State<ProfileScreen> createState() => _ProfileScreenState();
}

class _ProfileScreenState extends State<ProfileScreen> {
  Future<String>? _authTokenFuture;

  Future<String> _loadAuthToken() async {
    final token = await Get.find<AuthController>().getAuthToken();
    if (token.isEmpty) {
      Get.find<ProfileController>().clearSession();
    }
    return token;
  }

  void _refreshAuth() {
    setState(() {
      _authTokenFuture = _loadAuthToken();
    });
  }

  Future<void> checkAuthAndFetchProfile() async {
    final token = await Get.find<AuthController>().getAuthToken();
    if (token.isEmpty) {
      Get.find<ProfileController>().clearSession();
      _refreshAuth();
      return;
    }

    final value = await Get.find<ProfileController>().getProfileData();
    if (!mounted) return;

    if (value == 200) {
      final profile = Get.find<ProfileController>().profileData;
      if (profile == null) {
        _goToLogin();
        return;
      }
      final isPremium = _isPremiumUser(profile);
      final expiredDate =
          DateTime.tryParse(profile['expired_date']?.toString() ?? '');
      final now = DateTime.now();

      if (isPremium && expiredDate != null && expiredDate.isAfter(now)) {
        log('Premium valid until: $expiredDate');
      } else {
        if (isPremium) {
          Get.find<ProfileController>().cancelSubscriptionData();
        }
        log('Premium expired or not active');
      }
      _refreshAuth();
      return;
    }

    _goToLogin();
  }

  void _goToLogin() {
    _refreshAuth();
    Get.to(() => const SignInScreen());
  }

  bool _needsLogin(String? token, ProfileController profileController) {
    if (token == null || token.isEmpty) return true;
    if (profileController.isLoading) return false;
    return profileController.requiresLogin;
  }

  @override
  void initState() {
    super.initState();
    _authTokenFuture = _loadAuthToken();
    WidgetsBinding.instance.addPostFrameCallback((_) {
      checkAuthAndFetchProfile();
    });
  }

  String formatDate(String dateString) {
    try {
      DateTime date = DateTime.parse(dateString);
      return DateFormat('dd MMM, yyyy').format(date);
    } catch (e) {
      return "-";
    }
  }

  bool _isPremiumUser(Map<String, dynamic> data) {
    final value = data['isPremium'];
    if (value is bool) return value;
    if (value is num) return value == 1;
    return value?.toString() == '1';
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<ProfileController>(
      builder: (profileController) {
        return Scaffold(
          backgroundColor: const Color(0xFFF0F2F5),
          appBar: AppBar(
            backgroundColor: const Color(0xFFF0F2F5),
            elevation: 0,
            scrolledUnderElevation: 0,
            surfaceTintColor: Colors.transparent,
            automaticallyImplyLeading: widget.showBackButton,
            leading: widget.showBackButton
                ? IconButton(
                    icon: Icon(Icons.arrow_back_ios_new_rounded,
                        color: Colors.grey.shade800, size: 20),
                    onPressed: () => Get.back(),
                  )
                : null,
            title: Text(
              'Profile',
              style: GoogleFonts.poppins(
                color: Colors.grey.shade900,
                fontSize: 17,
                fontWeight: FontWeight.w600,
              ),
            ),
            centerTitle: true,
          ),
          body: SafeArea(
            child: FutureBuilder<String>(
              future: _authTokenFuture,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(
                    child: CircularProgressIndicator(
                      color: AppColors.appPrimaryColor,
                      strokeWidth: 2.5,
                    ),
                  );
                }

                final authToken = snapshot.data ?? '';

                if (_needsLogin(authToken, profileController)) {
                  return _buildNotLoggedInUI();
                }

                if (profileController.isLoading) {
                  return Center(
                    child: CircularProgressIndicator(
                      color: AppColors.appPrimaryColor,
                      strokeWidth: 2.5,
                    ),
                  );
                }

                if (profileController.profileData == null) {
                  return _buildNotLoggedInUI();
                }

                final data = profileController.profileData!;
                final isPremium = _isPremiumUser(data);

                return SingleChildScrollView(
                  physics: const BouncingScrollPhysics(),
                  padding: const EdgeInsets.fromLTRB(20, 8, 20, 28),
                  child: Column(
                    children: [
                      _buildProfileCard(data),
                      const SizedBox(height: 16),
                      _buildAccountCard(data, isPremium),
                      const SizedBox(height: 22),
                      _buildLogoutButton(context),
                    ],
                  ),
                );
              },
            ),
          ),
        );
      },
    );
  }

  // -------------------------------
  // COMPONENTS
  // -------------------------------

  Widget _buildProfileCard(Map<String, dynamic> data) {
    final primary = AppColors.appPrimaryColor;

    return Container(
      width: double.infinity,
      padding: const EdgeInsets.fromLTRB(20, 28, 20, 26),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(24),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.06),
            blurRadius: 20,
            offset: const Offset(0, 8),
          ),
        ],
      ),
      child: Column(
        children: [
          Container(
            padding: const EdgeInsets.all(5),
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              border: Border.all(
                color: primary.withValues(alpha: 0.35),
                width: 2.5,
              ),
              boxShadow: [
                BoxShadow(
                  color: primary.withValues(alpha: 0.18),
                  blurRadius: 16,
                  offset: const Offset(0, 6),
                ),
              ],
            ),
            child: CircleAvatar(
              radius: 46,
              backgroundColor: primary.withValues(alpha: 0.12),
              child: Icon(Icons.person_rounded, color: primary, size: 48),
            ),
          ),
          const SizedBox(height: 18),
          Text(
            data["name"] ?? "Unknown",
            textAlign: TextAlign.center,
            style: GoogleFonts.poppins(
              fontSize: 22,
              color: Colors.grey.shade900,
              fontWeight: FontWeight.w700,
              letterSpacing: -0.3,
            ),
          ),
          const SizedBox(height: 10),
          Container(
            padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 7),
            decoration: BoxDecoration(
              color: const Color(0xFFEEF1F6),
              borderRadius: BorderRadius.circular(24),
            ),
            child: Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                Icon(Icons.alternate_email_rounded,
                    size: 16, color: Colors.grey.shade600),
                const SizedBox(width: 6),
                Flexible(
                  child: Text(
                    data["email"] ?? "No email",
                    style: GoogleFonts.poppins(
                      fontSize: 13,
                      color: Colors.grey.shade700,
                      fontWeight: FontWeight.w500,
                    ),
                    overflow: TextOverflow.ellipsis,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildAccountCard(Map<String, dynamic> data, bool isPremium) {
    final primary = AppColors.appPrimaryColor;

    return Container(
      width: double.infinity,
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(24),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withValues(alpha: 0.06),
            blurRadius: 20,
            offset: const Offset(0, 8),
          ),
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Padding(
            padding: const EdgeInsets.fromLTRB(18, 18, 18, 14),
            child: Row(
              children: [
                Container(
                  padding: const EdgeInsets.all(11),
                  decoration: BoxDecoration(
                    color: isPremium
                        ? const Color(0xFFFFF8E6)
                        : primary.withValues(alpha: 0.1),
                    borderRadius: BorderRadius.circular(14),
                  ),
                  child: Icon(
                    isPremium
                        ? Icons.workspace_premium_rounded
                        : Icons.verified_user_outlined,
                    color: isPremium ? const Color(0xFFB8860B) : primary,
                    size: 24,
                  ),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'Membership',
                        style: GoogleFonts.poppins(
                          fontSize: 12,
                          color: Colors.grey.shade600,
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                      const SizedBox(height: 2),
                      Text(
                        isPremium ? 'Premium' : 'Free plan',
                        style: GoogleFonts.poppins(
                          fontSize: 17,
                          color: Colors.grey.shade900,
                          fontWeight: FontWeight.w700,
                        ),
                      ),
                    ],
                  ),
                ),
                if (isPremium)
                  Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 11, vertical: 5),
                    decoration: BoxDecoration(
                      gradient: LinearGradient(
                        colors: [
                          primary,
                          primary.withValues(alpha: 0.85),
                        ],
                      ),
                      borderRadius: BorderRadius.circular(20),
                      boxShadow: [
                        BoxShadow(
                          color: primary.withValues(alpha: 0.35),
                          blurRadius: 8,
                          offset: const Offset(0, 3),
                        ),
                      ],
                    ),
                    child: Text(
                      'PRO',
                      style: GoogleFonts.poppins(
                        fontSize: 11,
                        fontWeight: FontWeight.w800,
                        color: Colors.white,
                        letterSpacing: 0.8,
                      ),
                    ),
                  ),
              ],
            ),
          ),
          Divider(height: 1, thickness: 1, color: Colors.grey.shade100),
          _buildDetailTile(
            Icons.event_available_outlined,
            'Joined',
            formatDate(data["created_at"] ?? ""),
          ),
          if (isPremium)
            _buildDetailTile(
              Icons.hourglass_top_rounded,
              'Validity',
              data["validity"] != null ? '${data["validity"]} days' : '-',
            ),
          if (isPremium && data["expired_date"] != null)
            _buildDetailTile(
              Icons.event_busy_outlined,
              'Expires',
              formatDate(data["expired_date"].toString()),
            ),
        ],
      ),
    );
  }

  Widget _buildLogoutButton(BuildContext context) {
    final primary = AppColors.appPrimaryColor;

    return SizedBox(
      width: double.infinity,
      child: OutlinedButton.icon(
        style: OutlinedButton.styleFrom(
          foregroundColor: primary,
          side: BorderSide(color: primary.withValues(alpha: 0.65), width: 1.5),
          padding: const EdgeInsets.symmetric(vertical: 16),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
          ),
          backgroundColor: Colors.white,
        ),
        icon: Icon(Icons.logout_rounded, size: 21, color: primary),
        label: Text(
          'Log out',
          style: GoogleFonts.poppins(
            fontSize: 16,
            fontWeight: FontWeight.w600,
          ),
        ),
        onPressed: _showLogoutDialog,
      ),
    );
  }

  Widget _buildDetailTile(IconData icon, String label, String value) {
    final primary = AppColors.appPrimaryColor;

    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 14),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            width: 42,
            height: 42,
            decoration: BoxDecoration(
              color: primary.withValues(alpha: 0.08),
              borderRadius: BorderRadius.circular(12),
            ),
            child: Icon(icon, color: primary, size: 21),
          ),
          const SizedBox(width: 14),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  label,
                  style: GoogleFonts.poppins(
                    fontSize: 12,
                    color: Colors.grey.shade600,
                    fontWeight: FontWeight.w500,
                  ),
                ),
                const SizedBox(height: 4),
                Text(
                  value,
                  style: GoogleFonts.poppins(
                    fontSize: 15,
                    color: Colors.grey.shade900,
                    fontWeight: FontWeight.w600,
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildNotLoggedInUI() {
    final primary = AppColors.appPrimaryColor;

    return Center(
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 24),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
          Container(
            padding: const EdgeInsets.all(28),
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              color: Colors.white,
              boxShadow: [
                BoxShadow(
                  color: Colors.black.withValues(alpha: 0.06),
                  blurRadius: 24,
                  offset: const Offset(0, 10),
                ),
              ],
            ),
            child: Icon(Icons.lock_person_rounded, size: 56, color: primary),
          ),
          const SizedBox(height: 28),
          Text(
            'Sign in to continue',
            style: GoogleFonts.poppins(
              fontSize: 22,
              color: Colors.grey.shade900,
              fontWeight: FontWeight.w700,
            ),
          ),
          const SizedBox(height: 10),
          Text(
            'Log in to sync your subscription and manage your VPN profile.',
            textAlign: TextAlign.center,
            style: GoogleFonts.poppins(
              fontSize: 14,
              color: Colors.grey.shade600,
              height: 1.45,
            ),
          ),
          const SizedBox(height: 28),
          SizedBox(
            width: double.infinity,
            child: ElevatedButton(
              onPressed: () async {
                await Get.to(() => const SignInScreen());
                _refreshAuth();
                checkAuthAndFetchProfile();
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: primary,
                foregroundColor: Colors.white,
                elevation: 0,
                shadowColor: primary.withValues(alpha: 0.4),
                padding: const EdgeInsets.symmetric(vertical: 16),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(16),
                ),
              ),
              child: Text(
                'Go to login',
                style: GoogleFonts.poppins(
                  fontSize: 16,
                  fontWeight: FontWeight.w600,
                ),
              ),
            ),
          ),
        ],
        ),
      ),
    );
  }

  void _showLogoutDialog() {
    final primary = AppColors.appPrimaryColor;

    Get.dialog(
      Dialog(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(22)),
        backgroundColor: Colors.white,
        child: Padding(
          padding: const EdgeInsets.fromLTRB(22, 26, 22, 22),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Container(
                padding: const EdgeInsets.all(14),
                decoration: BoxDecoration(
                  color: primary.withValues(alpha: 0.12),
                  shape: BoxShape.circle,
                ),
                child: Icon(Icons.logout_rounded, color: primary, size: 32),
              ),
              const SizedBox(height: 18),
              Text(
                'Log out?',
                style: GoogleFonts.poppins(
                  fontSize: 20,
                  fontWeight: FontWeight.w700,
                  color: Colors.grey.shade900,
                ),
              ),
              const SizedBox(height: 8),
              Text(
                'You will need to sign in again to use account features.',
                textAlign: TextAlign.center,
                style: GoogleFonts.poppins(
                  fontSize: 14,
                  color: Colors.grey.shade600,
                  height: 1.4,
                ),
              ),
              const SizedBox(height: 26),
              Row(
                children: [
                  Expanded(
                    child: TextButton(
                      onPressed: () => Get.back(),
                      style: TextButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 14),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(14),
                          side: BorderSide(color: Colors.grey.shade300),
                        ),
                      ),
                      child: Text(
                        'Cancel',
                        style: GoogleFonts.poppins(
                          fontSize: 15,
                          fontWeight: FontWeight.w600,
                          color: Colors.grey.shade700,
                        ),
                      ),
                    ),
                  ),
                  const SizedBox(width: 12),
                  Expanded(
                    child: ElevatedButton(
                      onPressed: () async {
                        Get.find<AuthController>().removeUserToken();
                        Get.back();
                        Get.offAll(() => const SignInScreen());
                        Fluttertoast.showToast(
                          msg: 'Logged out',
                          backgroundColor: Colors.green,
                          textColor: Colors.white,
                        );
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: primary,
                        foregroundColor: Colors.white,
                        elevation: 0,
                        padding: const EdgeInsets.symmetric(vertical: 14),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(14),
                        ),
                      ),
                      child: Text(
                        'Log out',
                        style: GoogleFonts.poppins(
                          fontSize: 15,
                          fontWeight: FontWeight.w600,
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
      transitionDuration: Duration.zero,
    );
  }
}
