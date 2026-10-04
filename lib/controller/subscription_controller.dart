import 'package:free_vpn/model/subscription_plan_model.dart';
import 'package:free_vpn/utils/api_json_helper.dart';
import 'package:get/get.dart';
import '../data/model/base_model/api_response.dart';
import '../data/repository/subscription_repo.dart';

class SubscriptionController extends GetxController {
  final SubscriptionRepo subscriptionRepo;

  SubscriptionController({required this.subscriptionRepo});

  bool isLoading = false;
  String? loadError;
  List<SubscriptionPlanModel> plans = [];

  Future<void> loadPlans() async {
    isLoading = true;
    loadError = null;
    update();

    final ApiResponse apiResponse = await subscriptionRepo.getSubscriptionPlans();

    if (apiResponse.error != null) {
      isLoading = false;
      loadError = apiResponse.error.toString();
      update();
      return;
    }

    final response = apiResponse.response;
    if (response != null && response.statusCode == 200) {
      plans = _parsePlans(response.data);
      isLoading = false;
      loadError = plans.isEmpty ? 'No subscription plans available.' : null;
      update();
      return;
    }

    isLoading = false;
    loadError = 'Could not load subscription plans.';
    update();
  }

  List<SubscriptionPlanModel> _parsePlans(dynamic data) {
    final map = parseResponseMap(data);
    if (map != null && map['plans'] is List) {
      return (map['plans'] as List)
          .whereType<Map>()
          .map((item) => SubscriptionPlanModel.fromJson(
                Map<String, dynamic>.from(item),
              ))
          .where((plan) => plan.id > 0 && plan.name.isNotEmpty)
          .toList();
    }

    if (data is List) {
      return data
          .whereType<Map>()
          .map((item) => SubscriptionPlanModel.fromJson(
                Map<String, dynamic>.from(item),
              ))
          .where((plan) => plan.id > 0 && plan.name.isNotEmpty)
          .toList();
    }

    return [];
  }
}
