class SubscriptionPlanModel {
  final int id;
  final String name;
  final int validity;
  final double price;

  const SubscriptionPlanModel({
    required this.id,
    required this.name,
    required this.validity,
    required this.price,
  });

  factory SubscriptionPlanModel.fromJson(Map<String, dynamic> json) {
    return SubscriptionPlanModel(
      id: int.tryParse('${json['id']}') ?? 0,
      name: (json['name'] ?? json['package_name'] ?? json['pakage_name'] ?? '')
          .toString(),
      validity: int.tryParse('${json['validity']}') ?? 0,
      price: double.tryParse('${json['price']}') ?? 0,
    );
  }
}
