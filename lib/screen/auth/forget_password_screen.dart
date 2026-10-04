import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:free_vpn/controller/auth_controller.dart';
import 'package:free_vpn/screen/auth/auth_ui.dart';

class ForgotPasswordScreen extends StatefulWidget {
  const ForgotPasswordScreen({super.key});

  @override
  State<ForgotPasswordScreen> createState() => _ForgotPasswordScreenState();
}

class _ForgotPasswordScreenState extends State<ForgotPasswordScreen> {
  final _emailController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  static final _emailRe = RegExp(
    r'^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$',
  );

  @override
  void dispose() {
    _emailController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return GetBuilder<AuthController>(
      builder: (authController) {
        return AuthShell(
          title: 'Forgot password',
          subtitle:
              'Enter the email linked to your account. We will send you a code or link to reset your password.',
          headerIcon: Icons.mark_email_unread_outlined,
          showBack: true,
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
                const SizedBox(height: 26),
                AuthUi.primaryButton(
                  loading: authController.isLoadingForget,
                  label: 'Send instructions',
                  onPressed: () {
                    if (_formKey.currentState?.validate() ?? false) {
                      authController.forgetPassword(
                        email: _emailController.text.trim(),
                      );
                    }
                  },
                ),
                const SizedBox(height: 18),
                AuthUi.linkRow(
                  leading: 'Remember your password? ',
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
