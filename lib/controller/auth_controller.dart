import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:get/get.dart';
import 'package:free_vpn/screen/main_shell_screen.dart';
import 'package:free_vpn/screen/auth/signin_screen.dart';
import 'package:free_vpn/utils/api_json_helper.dart';
import '../data/datasource/remote/dio/dio_client.dart';
import '../data/model/base_model/api_response.dart';
import '../data/repository/auth_repo.dart';
import '../screen/auth/reset_password_screen.dart';

class AuthController extends GetxController {
  final DioClient dioClient;
  final AuthRepo authRepo;

  AuthController({
    required this.authRepo,
    required this.dioClient,
  });

  bool isLoadingLogin = false;
  bool isLoadingRegister = false;
  bool isLoadingForget = false;
  bool isLoadingReset = false;

  var rememberMe = false.obs;

  void _showToast({required String msg, required bool isSuccess}) {
    Fluttertoast.showToast(
      msg: msg,
      toastLength: Toast.LENGTH_SHORT,
      gravity: ToastGravity.BOTTOM,
      timeInSecForIosWeb: 1,
      backgroundColor: isSuccess ? Colors.green : Colors.red,
      textColor: Colors.white,
      fontSize: 16.0,
    );
  }

  Future<bool> _persistAuthToken(String token) async {
    await authRepo.saveUserToken(token);
    return true;
  }

  // ================= REGISTER =================

  Future<bool> register({
    required String email,
    required String name,
    required String password,
  }) async {
    isLoadingRegister = true;
    update();

    try {
      final ApiResponse apiResponse = await authRepo.register(
        name: name,
        email: email,
        password: password,
      );

      final result = parseAuthApiResponse(apiResponse);
      if (result.token != null) {
        await _persistAuthToken(result.token!);
        _showToast(
          msg: 'Account created successfully',
          isSuccess: true,
        );
        return true;
      }

      _showToast(
        msg: result.error ?? 'Registration failed',
        isSuccess: false,
      );
      return false;
    } catch (e) {
      if (kDebugMode) {
        print('Register error: $e');
      }
      _showToast(msg: dioErrorMessage(e), isSuccess: false);
      return false;
    } finally {
      isLoadingRegister = false;
      update();
    }
  }

  // ================= LOGIN =================

  Future<void> login({
    required String email,
    required String password,
    required String deviceId,
  }) async {
    isLoadingLogin = true;
    update();

    try {
      final ApiResponse apiResponse = await authRepo.login(
        email: email,
        password: password,
        deviceId: deviceId,
      );

      final result = parseAuthApiResponse(apiResponse);
      if (result.token != null) {
        await _persistAuthToken(result.token!);
        _showToast(msg: 'Login successful', isSuccess: true);
        Get.offAll(() => const MainShellScreen());
        return;
      }

      _showToast(
        msg: result.error ?? 'Login failed',
        isSuccess: false,
      );
    } catch (e) {
      if (kDebugMode) {
        print('Login error: $e');
      }
      _showToast(msg: dioErrorMessage(e), isSuccess: false);
    } finally {
      isLoadingLogin = false;
      update();
    }
  }

  forgetPassword({dynamic email}) async {
    isLoadingForget = true;
    update();

    try {
      ApiResponse apiResponse = await authRepo.forgetPassword(email: email);

      if (apiResponse.response != null &&
          apiResponse.response!.statusCode == 200) {
        _showToast(msg: 'Please check your email Inbox', isSuccess: true);
        Get.to(() => const ResetPasswordScreen());
      } else {
        final result = parseAuthApiResponse(apiResponse);
        _showToast(
          msg: result.error ?? apiResponse.error?.toString() ?? 'Request failed',
          isSuccess: false,
        );
      }
    } catch (e) {
      if (kDebugMode) {
        print('Forget password error: $e');
      }
      _showToast(msg: dioErrorMessage(e), isSuccess: false);
    } finally {
      isLoadingForget = false;
      update();
    }
  }

  resetPassword({
    dynamic email,
    dynamic token,
    dynamic password,
    dynamic confirmPassword,
  }) async {
    isLoadingReset = true;
    update();

    try {
      ApiResponse apiResponse = await authRepo.resetPassword(
        email: email,
        token: token,
        password: password,
        confirmPassword: confirmPassword,
      );

      if (apiResponse.response != null &&
          apiResponse.response!.statusCode == 200) {
        _showToast(msg: 'Password reset successful', isSuccess: true);
        Get.to(() => const SignInScreen());
      } else {
        final result = parseAuthApiResponse(apiResponse);
        _showToast(
          msg: result.error ?? apiResponse.error?.toString() ?? 'Reset failed',
          isSuccess: false,
        );
      }
    } catch (e) {
      if (kDebugMode) {
        print('Reset password error: $e');
      }
      _showToast(msg: dioErrorMessage(e), isSuccess: false);
    } finally {
      isLoadingReset = false;
      update();
    }
  }

  // ================= TOKEN =================

  Future<String> getUserToken() async {
    final token = await authRepo.getUserToken();
    WidgetsBinding.instance.addPostFrameCallback((_) {
      update();
    });
    return token;
  }

  Future<void> removeUserToken() async {
    await authRepo.removeUserToken();
    WidgetsBinding.instance.addPostFrameCallback((_) {
      update();
    });
  }

  Future<String> getAuthToken() async {
    final token = await authRepo.getAuthToken();
    dioClient.updateHeader(token, '');
    WidgetsBinding.instance.addPostFrameCallback((_) {
      update();
    });
    return token;
  }
}
