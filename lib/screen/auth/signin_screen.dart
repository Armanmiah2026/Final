import 'dart:io';

import 'package:android_id/android_id.dart';
import 'package:device_info_plus/device_info_plus.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:free_vpn/controller/auth_controller.dart';
import 'package:free_vpn/screen/auth/auth_ui.dart';
import 'package:free_vpn/screen/auth/forget_password_screen.dart';
import 'package:free_vpn/screen/auth/sign_up_screen.dart';
import 'package:free_vpn/utils/app_colors.dart';

class SignInScreen extends StatefulWidget {
  const SignInScreen({super.key});

  @override
  State<SignInScreen> createState() => _SignInScreenState();
}

class _SignInScreenState extends State<SignInScreen> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  bool _obscurePassword = true;

  final _formKey = GlobalKey<FormState>();
  String? deviceId;

  static final _emailRe = RegExp(
    r'^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$',
  );

  Future<String?> getDeviceId() async {
    final deviceInfo = DeviceInfoPlugin();
    if (Platform.isIOS) {
      final iosInfo = await deviceInfo.iosInfo;
      return iosInfo.identifierForVendor;
    }
    if (Platform.isAndroid) {
      return const AndroidId().getId();
    }
    return null;
  }

  @override
  void initState() {
    super.initState();
    loadDeviceId();
  }

  Future<void> loadDeviceId() async {
    deviceId = await getDeviceId();
    deviceId ??= 'unknown_device';
    setState(() {});
  }

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<AuthController>(
      builder: (authController) {
        return AuthShell(
          title: 'Welcome back',
          subtitle:
              'Sign in with your email to continue using secure browsing.',
          headerIcon: Icons.login_rounded,
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                AuthUi.fieldLabel('Email'),
                TextFormField(
                  controller: _emailController,
                  keyboardType: TextInputType.emailAddress,
                  autovalidateMode: AutovalidateMode.onUserInteraction,
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return 'Enter your email';
                    }
                    if (!_emailRe.hasMatch(value.trim())) {
                      return 'Enter a valid email';
                    }
                    return null;
                  },
                  decoration: AuthUi.textFieldDecoration(
                    hint: 'you@example.com',
                    prefixIcon: Icon(
                      Icons.mail_outline_rounded,
                      color: Colors.grey.shade500,
                      size: 22,
                    ),
                  ),
                ),
                const SizedBox(height: 18),
                AuthUi.fieldLabel('Password'),
                TextFormField(
                  controller: _passwordController,
                  obscureText: _obscurePassword,
                  autovalidateMode: AutovalidateMode.onUserInteraction,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Enter your password';
                    }
                    return null;
                  },
                  decoration: AuthUi.textFieldDecoration(
                    hint: '••••••••',
                    prefixIcon: Icon(
                      Icons.lock_outline_rounded,
                      color: Colors.grey.shade500,
                      size: 22,
                    ),
                    suffixIcon: IconButton(
                      icon: Icon(
                        _obscurePassword
                            ? Icons.visibility_off_outlined
                            : Icons.visibility_outlined,
                        color: Colors.grey.shade600,
                        size: 22,
                      ),
                      onPressed: () {
                        setState(() => _obscurePassword = !_obscurePassword);
                      },
                    ),
                  ),
                ),
                Align(
                  alignment: Alignment.centerRight,
                  child: TextButton(
                    onPressed: () => Get.to(() => const ForgotPasswordScreen()),
                    child: Text(
                      'Forgot password?',
                      style: TextStyle(
                        color: AppColors.appPrimaryColor,
                        fontWeight: FontWeight.w600,
                        fontSize: 13,
                      ),
                    ),
                  ),
                ),
                const SizedBox(height: 8),
                AuthUi.primaryButton(
                  loading: authController.isLoadingLogin,
                  label: 'Sign in',
                  onPressed: () {
                    if (_formKey.currentState?.validate() ?? false) {
                      authController.login(
                        email: _emailController.text.trim(),
                        password: _passwordController.text.trim(),
                        deviceId: deviceId ?? 'unknown_device',
                      );
                    }
                  },
                ),
                const SizedBox(height: 20),
                AuthUi.linkRow(
                  leading: "Don't have an account? ",
                  action: 'Sign up',
                  onTap: () => Get.to(() => const SignUpScreen()),
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
