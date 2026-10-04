import 'dart:io';

import 'package:flutter/foundation.dart';

class AppConfig {
  /// Toggle local backend while developing.
  static const bool useLocalBackend = false;

  static const String localPort = '8000';
  static const String productionBaseUrl = 'https://powerbtr.online';

  static String get baseUrl {
    if (!useLocalBackend) {
      return productionBaseUrl;
    }

    if (kIsWeb) {
      return 'http://localhost:$localPort';
    }

    if (Platform.isAndroid) {
      // Android emulator: 10.0.2.2 points to the host machine's localhost.
      return 'http://10.0.2.2:$localPort';
    }

    // iOS simulator, macOS, Windows, Linux
    return 'http://localhost:$localPort';
  }
}
