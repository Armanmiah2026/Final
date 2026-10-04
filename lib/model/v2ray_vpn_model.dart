class V2rayVpnModel {
  dynamic id;
  final String name;
  final String config;
  final bool isPremium;
  final String countryCode;
  final String cityName;

  V2rayVpnModel({
    required this.id,
    required this.name,
    required this.config,
    required this.isPremium,
    required this.countryCode,
    required this.cityName,
  });

  factory V2rayVpnModel.fromJson(Map<String, dynamic> json) {
    final type = json['type'];
    final dynamic premiumFlag = json['isPremium'];
    final bool premiumByType = type == 1 || type == '1';
    final bool premiumByFlag = premiumFlag == true ||
        premiumFlag == 1 ||
        premiumFlag == '1';

    return V2rayVpnModel(
      id: json['id'] ?? '',
      name: '${json['name'] ?? ''}',
      config: '${json['link'] ?? ''}',
      isPremium: premiumByType || premiumByFlag,
      countryCode: '${json['country_code'] ?? ''}',
      cityName: '${json['city_name'] ?? ''}',
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'config': config,
      'isPremium': isPremium,
      'country_code': countryCode,
      'city_name': cityName,
    };
  }
}
