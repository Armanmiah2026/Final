import 'package:shared_preferences/shared_preferences.dart';

/// SharedPreferences key for apps excluded from the VPN (split tunnel bypass).
const String splitTunnelPrefsKey = 'enabled_apps';

/// Loads package names that should bypass the VPN tunnel.
Future<List<String>> loadSplitTunnelBypassPackages() async {
  final prefs = await SharedPreferences.getInstance();
  return List<String>.from(prefs.getStringList(splitTunnelPrefsKey) ?? []);
}

/// Persists package names that should bypass the VPN tunnel.
Future<void> saveSplitTunnelBypassPackages(List<String> packages) async {
  final prefs = await SharedPreferences.getInstance();
  await prefs.setStringList(splitTunnelPrefsKey, packages);
}
