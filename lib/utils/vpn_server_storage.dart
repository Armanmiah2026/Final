import 'dart:convert';

import 'package:free_vpn/model/vpn_server_model.dart';
import 'package:shared_preferences/shared_preferences.dart';

/// Persists the user's selected VPN server in SharedPreferences.
class VpnServerStorage {
  static String _encode(String input) => base64Encode(utf8.encode(input));

  static String _decode(String? input) {
    if (input == null || input.isEmpty) return '';
    try {
      return utf8.decode(base64Decode(input));
    } catch (_) {
      return '';
    }
  }

  static const String _autoSelectModeKey = 'vpn_auto_select_mode';

  static int? getSelectedServerId(SharedPreferences prefs) => prefs.getInt('id');

  /// When true, the app picks the best server automatically; manual picks disable this.
  static bool isAutoSelectMode(SharedPreferences prefs) =>
      prefs.getBool(_autoSelectModeKey) ?? true;

  static Future<void> setAutoSelectMode(
    SharedPreferences prefs,
    bool enabled,
  ) async {
    await prefs.setBool(_autoSelectModeKey, enabled);
  }

  static String getSelectedServerName(SharedPreferences prefs) =>
      _decode(prefs.getString('name'));

  static bool hasValidSelection(
    SharedPreferences prefs,
    List<VpnServerModel> servers,
  ) {
    final id = getSelectedServerId(prefs);
    if (id == null) return false;
    return servers.any((server) => server.id.toString() == id.toString());
  }

  static Future<void> saveServer(
    SharedPreferences prefs,
    VpnServerModel server,
  ) async {
    await prefs.setInt('id', int.tryParse('${server.id}') ?? 0);
    await prefs.setString('name', _encode(server.name));
    await prefs.setString('link', _encode(server.config));
    await prefs.setString('isPremium', _encode(server.isPremium ? '1' : '0'));
    await prefs.setString('country_code', _encode(server.countryCode));
    await prefs.setString('protocol', _encode(server.protocol));
    await prefs.setString('vpn_username', _encode(server.username));
    await prefs.setString('vpn_password', _encode(server.password));
  }

  static VpnServerModel? findById(List<VpnServerModel> servers, dynamic id) {
    if (id == null) return null;
    for (final server in servers) {
      if (server.id.toString() == id.toString()) {
        return server;
      }
    }
    return null;
  }
}
