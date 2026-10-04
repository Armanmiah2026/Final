import 'package:firebase_analytics/firebase_analytics.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:get/get.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:free_vpn/controller/app_setting_controller.dart';
import 'package:free_vpn/screen/splash/splash_screen.dart';
import 'package:free_vpn/utils/app_strings.dart';
import 'package:free_vpn/utils/no_transition.dart';
import 'di_container.dart' as di;

void main() async{
  WidgetsFlutterBinding.ensureInitialized();
  MobileAds.instance.initialize();
  // Check if Firebase is already initialized
  await Firebase.initializeApp();
  // Lock orientation to portrait
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
    DeviceOrientation.portraitDown,
  ]);
  await di.init();
  try {
    await Get.find<AppSettingController>().getAdmobData();
  } catch (e, st) {
    debugPrint('getAdmobData failed: $e\n$st');
  }
  runApp(const FreeVpnApp());
}

class FreeVpnApp extends StatelessWidget {
  static FirebaseAnalytics analytics = FirebaseAnalytics.instance;
  const FreeVpnApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      navigatorObservers: [
        FirebaseAnalyticsObserver(analytics: analytics),
      ],
      title: AppStrings.appName,
      debugShowCheckedModeBanner: false,
      defaultTransition: Transition.noTransition,
      transitionDuration: Duration.zero,
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: const Color(0xFFE8E8E8),
        fontFamily: 'SF Pro',
        pageTransitionsTheme: instantPageTransitionsTheme,
      ),
      home: SplashScreen(),
    );
  }
}

