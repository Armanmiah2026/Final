import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:free_vpn/controller/auth_controller.dart';
import 'package:free_vpn/screen/auth/auth_ui.dart';

class ResetPasswordScreen extends StatefulWidget {
  const ResetPasswordScreen({super.key});

  @override
  State<ResetPasswordScreen> createState() => _ResetPasswordScreenState();
}

class _ResetPasswordScreenState extends State<ResetPasswordScreen> {
  final _tokenController = TextEditingController();
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _confirmPasswordController = TextEditingController();
  bool _obscurePassword = true;
  bool _obscureConfirmPassword = true;

  final _formKey = GlobalKey<FormState>();

  static final _emailRe = RegExp(
    r'^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$',
  );
  static final _passwordRe = RegExp(
    r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$',
  );

  @override
  void dispose() {
    _tokenController.dispose();
    _emailController.dispose();
    _passwordController.dispose();
    _confirmPasswordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<AuthController>(
      builder: (authController) {
        return AuthShell(
          title: 'Set new password',
          subtitle:
              'Use the verification code from your email together with your account email.',
          headerIcon: Icons.password_rounded,
          showBack: true,
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                AuthUi.fieldLabel('Verification code'),
                TextFormField(
                  controller: _tokenController,
                  keyboardType: TextInputType.text,
                  autovalidateMode: AutovalidateMode.onUserInteraction,
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return 'Enter the code from your email';
                    }
                    return null;
                  },
                  decoration: AuthUi.textFieldDecoration(
                    hint: 'Paste code',
                    prefixIcon: Icon(
                      Icons.pin_outlined,
                      color: Colors.grey.shade500,
                      size: 22,
                    ),
                  ),
                ),
                const SizedBox(height: 18),
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
                AuthUi.fieldLabel('New password'),
                TextFormField(
                  controller: _passwordController,
                  obscureText: _obscurePassword,
                  autovalidateMode: AutovalidateMode.onUserInteraction,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Choose a new password';
                    }
                    if (!_passwordRe.hasMatch(value)) {
                      return 'Min 8 chars with upper, lower, number & symbol';
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
                const SizedBox(height: 18),
                AuthUi.fieldLabel('Confirm password'),
                TextFormField(
                  controller: _confirmPasswordController,
                  obscureText: _obscureConfirmPassword,
                  autovalidateMode: AutovalidateMode.onUserInteraction,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Confirm your password';
                    }
                    if (value != _passwordController.text) {
                      return 'Passwords do not match';
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
                        _obscureConfirmPassword
                            ? Icons.visibility_off_outlined
                            : Icons.visibility_outlined,
                        color: Colors.grey.shade600,
                        size: 22,
                      ),
                      onPressed: () {
                        setState(() =>
                            _obscureConfirmPassword = !_obscureConfirmPassword);
                      },
                    ),
                  ),
                ),
                const SizedBox(height: 26),
                AuthUi.primaryButton(
                  loading: authController.isLoadingReset,
                  label: 'Update password',
                  onPressed: () {
                    if (_formKey.currentState?.validate() ?? false) {
                      authController.resetPassword(
                        token: _tokenController.text.trim(),
                        email: _emailController.text.trim(),
                        password: _passwordController.text.trim(),
                        confirmPassword:
                            _confirmPasswordController.text.trim(),
                      );
                    }
                  },
                ),
                const SizedBox(height: 18),
                AuthUi.linkRow(
                  leading: 'Back to ',
                  action: 'Sign in',
                  onTap: () => Navigator.pop(context),
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
