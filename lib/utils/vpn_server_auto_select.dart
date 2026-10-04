import 'package:free_vpn/model/vpn_server_model.dart';
import 'package:free_vpn/utils/ad_eligibility_helper.dart';
import 'package:free_vpn/utils/vpn_server_storage.dart';
import 'package:shared_preferences/shared_preferences.dart';

class VpnServerAutoSelect {
  static bool canUseServer(
    VpnServerModel server,
    Map<String, dynamic>? profile,
  ) {
    if (!server.isPremium) return true;
    return AdEligibility.hasActivePremium(profile);
  }

  static bool hasActivePremium(Map<String, dynamic>? profile) =>
      AdEligibility.hasActivePremium(profile);

  /// Servers eligible for auto-select for this user's plan.
  static List<VpnServerModel> eligiblePool(
    List<VpnServerModel> servers, {
    Map<String, dynamic>? profile,
  }) {
    if (hasActivePremium(profile)) {
      return servers.where((server) => server.isPremium).toList();
    }
    return servers.where((server) => !server.isPremium).toList();
  }

  /// Whether [server] belongs to the auto-select pool for this user.
  static bool isAutoSelectCandidate(
    VpnServerModel server, {
    Map<String, dynamic>? profile,
  }) {
    if (!canUseServer(server, profile)) return false;
    if (hasActivePremium(profile)) return server.isPremium;
    return !server.isPremium;
  }

  /// Picks the best available server from the user's plan pool only.
  static VpnServerModel? pickBest(
    List<VpnServerModel> servers, {
    Map<String, dynamic>? profile,
  }) {
    final pool = eligiblePool(servers, profile: profile);
    if (pool.isEmpty) return null;
    return pool.first;
  }

  static VpnServerModel? pick(
    List<VpnServerModel> servers, {
    required SharedPreferences prefs,
    Map<String, dynamic>? profile,
  }) {
    if (servers.isEmpty) return null;

    if (!VpnServerStorage.isAutoSelectMode(prefs)) {
      final currentId = VpnServerStorage.getSelectedServerId(prefs);
      if (currentId != null) {
        final current = VpnServerStorage.findById(servers, currentId);
        if (current != null && canUseServer(current, profile)) {
          return current;
        }
      }
      return null;
    }

    final currentId = VpnServerStorage.getSelectedServerId(prefs);
    if (currentId != null) {
      final current = VpnServerStorage.findById(servers, currentId);
      if (current != null && isAutoSelectCandidate(current, profile: profile)) {
        return current;
      }
    }

    return pickBest(servers, profile: profile);
  }
}
