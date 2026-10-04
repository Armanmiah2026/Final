import 'dart:convert';

import 'package:free_vpn/model/vpn_server_model.dart';
import 'package:shared_preferences/shared_preferences.dart';

class VpnServerCacheData {
  final String fingerprint;
  final List<VpnServerModel> servers;
  final DateTime cachedAt;

  const VpnServerCacheData({
    required this.fingerprint,
    required this.servers,
    required this.cachedAt,
  });
}

/// Local cache for VPN server lists keyed by server-list fingerprint.
class VpnServerCache {
  static const _serversKey = 'vpn_servers_cache_json';
  static const _fingerprintKey = 'vpn_servers_fingerprint';
  static const _cachedAtKey = 'vpn_servers_cached_at';

  static VpnServerCacheData? read(SharedPreferences prefs) {
    final raw = prefs.getString(_serversKey);
    final fingerprint = prefs.getString(_fingerprintKey);
    if (raw == null || raw.isEmpty || fingerprint == null || fingerprint.isEmpty) {
      return null;
    }

    try {
      final decoded = jsonDecode(raw);
      if (decoded is! List) return null;

      final servers = decoded
          .whereType<Map>()
          .map((item) => VpnServerModel.fromCacheJson(
                Map<String, dynamic>.from(item),
              ))
          .where((server) => server.config.trim().isNotEmpty)
          .toList();

      if (servers.isEmpty) return null;

      final cachedAtRaw = prefs.getString(_cachedAtKey);
      final cachedAt = DateTime.tryParse(cachedAtRaw ?? '') ?? DateTime.now();

      return VpnServerCacheData(
        fingerprint: fingerprint,
        servers: servers,
        cachedAt: cachedAt,
      );
    } catch (_) {
      return null;
    }
  }

  static Future<void> save(
    SharedPreferences prefs, {
    required String fingerprint,
    required List<VpnServerModel> servers,
  }) async {
    final payload = servers.map((server) => server.toCacheJson()).toList();
    await prefs.setString(_serversKey, jsonEncode(payload));
    await prefs.setString(_fingerprintKey, fingerprint);
    await prefs.setString(_cachedAtKey, DateTime.now().toIso8601String());
  }

  static String? storedFingerprint(SharedPreferences prefs) =>
      prefs.getString(_fingerprintKey);

  static Future<void> clear(SharedPreferences prefs) async {
    await prefs.remove(_serversKey);
    await prefs.remove(_fingerprintKey);
    await prefs.remove(_cachedAtKey);
  }
}
