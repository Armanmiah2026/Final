/// Rules: ads only for free users on free servers — never on premium servers
/// or for premium subscribers.
class AdEligibility {
  static bool isPremiumUser(Map<String, dynamic>? profile) {
    if (profile == null) return false;
    final value = profile['isPremium'];
    if (value is bool) return value;
    if (value is num) return value == 1;
    return value?.toString() == '1';
  }

  static bool hasActivePremium(Map<String, dynamic>? profile) {
    if (!isPremiumUser(profile)) return false;
    final expired =
        DateTime.tryParse(profile!['expired_date']?.toString() ?? '');
    if (expired == null) return true;
    return expired.isAfter(DateTime.now());
  }

  static bool shouldShowAdsForUser(Map<String, dynamic>? profile) {
    return !hasActivePremium(profile);
  }

  static bool shouldShowAdsForServer({
    required bool serverIsPremium,
    Map<String, dynamic>? profile,
  }) {
    if (serverIsPremium) return false;
    return shouldShowAdsForUser(profile);
  }

  static bool parseStoredServerPremium(dynamic value) {
    if (value == null) return false;
    if (value is bool) return value;
    if (value is num) return value == 1;
    final text = value.toString().trim().toLowerCase();
    return text == '1' || text == 'true';
  }
}
