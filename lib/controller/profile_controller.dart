import 'package:free_vpn/controller/auth_controller.dart';
import 'package:free_vpn/utils/api_json_helper.dart';
import 'package:get/get.dart';
import '../data/model/base_model/api_response.dart';
import '../data/repository/profile_repo.dart';

class ProfileController extends GetxController {
  final ProfileRepo profileRepo;

  ProfileController({required this.profileRepo});

  bool isLoading = false;
  bool isLoadingCancel = false;
  String? loadError;

  Map<String, dynamic>? profileData;
  dynamic subscriptionCancelData;

  /// True after profile load failed and the stored session was cleared.
  bool get requiresLogin => loadError == 'Not authenticated';

  void clearSession() {
    profileData = null;
    loadError = null;
    isLoading = false;
    isLoadingCancel = false;
    subscriptionCancelData = null;
    update();
  }

  Future<void> _invalidateSession() async {
    if (Get.isRegistered<AuthController>()) {
      await Get.find<AuthController>().removeUserToken();
    }
    profileData = null;
    loadError = 'Not authenticated';
    isLoading = false;
    update();
  }

  Future<int?> getProfileData() async {
    isLoading = true;
    loadError = null;
    update();

    final ApiResponse apiResponse = await profileRepo.getProfileData();

    if (apiResponse.error != null) {
      await _invalidateSession();
      return 401;
    }

    final response = apiResponse.response;
    if (response != null && response.statusCode == 200) {
      final data = parseResponseMap(response.data);
      if (data != null && !data.containsKey('error')) {
        profileData = data;
        isLoading = false;
        loadError = null;
        update();
        return 200;
      }
      await _invalidateSession();
      return 401;
    }

    if (response?.statusCode == 401) {
      await _invalidateSession();
      return 401;
    }

    await _invalidateSession();
    return response?.statusCode ?? 401;
  }

  cancelSubscriptionData() async {
    isLoadingCancel = true;
    update();
    ApiResponse apiResponse = await profileRepo.cancelSubscription();

    if (apiResponse.response != null &&
        apiResponse.response!.statusCode == 200) {
      isLoadingCancel = false;
      update();
      if (apiResponse.response!.data != null) {
        subscriptionCancelData = apiResponse.response!.data;
      }
    } else {
      isLoadingCancel = false;
      update();
    }
  }
}
