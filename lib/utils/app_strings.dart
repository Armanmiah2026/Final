import 'app_config.dart';

class AppStrings {
  static const String appName = 'Free VPN';

  //API BASE URL
  static String get baseUrl => AppConfig.baseUrl;
  static const String tokenKey = 'auth_token';

  //API ENDPOINTS
  static const String v2rayUrl = "/api/v2ray/list";
  static const String openVpnUrl = "/api/openvpn/list";
  static const String serversMetaUrl = "/api/servers/meta";
  static const String helpCenterUrl = "/api/help_center/search";
  static const String loginUrl = "/api/auth/user/login";
  static const String registerUrl = "/api/auth/user/register";
  static const String forgetPasswordUrl = "/api/auth/forgot-password";
  static const String resetPasswordUrl = "/api/auth/reset-password";
  static const String profileUrl = "/api/user/show-profile";
  static const String subscriptionPlansUrl = "/api/subscription/plans";
  static const String userStatusUrl = "/api/user/status";
  static const String subscriptionCancelUrl = "/api/user/subscription/cancel";
  static const String appUpdateUrl = "/api/popup-setting";
  static const String appContactUrl = "/api/contact-setting";
  static const String appGeneralSettingUrl = "/api/general-setting";
  static const String appSettingUrl = "/api/app-setting";
  static const String admobUrl = "/api/admob-setting";

}