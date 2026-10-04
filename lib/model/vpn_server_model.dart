class VpnServerModel {
  final dynamic id;
  final String name;
  final String config;
  final bool isPremium;
  final String countryCode;
  final String cityName;
  final String protocol;
  final String username;
  final String password;

  const VpnServerModel({
    required this.id,
    required this.name,
    required this.config,
    required this.isPremium,
    required this.countryCode,
    required this.cityName,
    required this.protocol,
    this.username = '',
    this.password = '',
  });

  bool get isOpenVpn => protocol == 'openvpn';
  bool get isV2ray => protocol == 'v2ray';

  Map<String, dynamic> toCacheJson() => {
        'id': id,
        'name': name,
        'config': config,
        'isPremium': isPremium,
        'country_code': countryCode,
        'city_name': cityName,
        'protocol': protocol,
        'username': username,
        'password': password,
      };

  factory VpnServerModel.fromCacheJson(Map<String, dynamic> json) {
    final premiumValue = json['isPremium'];
    final isPremium = premiumValue == true ||
        premiumValue == 1 ||
        premiumValue == '1';

    return VpnServerModel(
      id: json['id'] ?? '',
      name: '${json['name'] ?? ''}',
      config: '${json['config'] ?? ''}',
      isPremium: isPremium,
      countryCode: '${json['country_code'] ?? ''}',
      cityName: '${json['city_name'] ?? ''}',
      protocol: '${json['protocol'] ?? 'v2ray'}',
      username: '${json['username'] ?? ''}',
      password: '${json['password'] ?? ''}',
    );
  }

  factory VpnServerModel.fromV2rayJson(Map<String, dynamic> json) {
    final type = json['type'];
    final dynamic premiumFlag = json['isPremium'];
    final bool premiumByType = type == 1 || type == '1';
    final bool premiumByFlag =
        premiumFlag == true || premiumFlag == 1 || premiumFlag == '1';

    return VpnServerModel(
      id: json['id'] ?? '',
      name: '${json['name'] ?? ''}',
      config: '${json['link'] ?? ''}',
      isPremium: premiumByType || premiumByFlag,
      countryCode: '${json['country_code'] ?? ''}',
      cityName: '${json['city_name'] ?? ''}',
      protocol: 'v2ray',
    );
  }

  factory VpnServerModel.fromOpenVpnJson(Map<String, dynamic> json) {
    final type = json['type'];
    final bool premium = type == 1 || type == '1';

    return VpnServerModel(
      id: json['id'] ?? '',
      name: '${json['name'] ?? ''}',
      config: '${json['ovpn_config'] ?? ''}',
      isPremium: premium,
      countryCode: '${json['country_code'] ?? ''}',
      cityName: '${json['city_name'] ?? ''}',
      protocol: 'openvpn',
      username: '${json['username'] ?? ''}',
      password: '${json['password'] ?? ''}',
    );
  }
}
