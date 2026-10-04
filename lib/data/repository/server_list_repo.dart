import 'package:free_vpn/utils/app_strings.dart';
import '../datasource/remote/dio/dio_client.dart';
import '../datasource/remote/exception/api_error_handler.dart';
import '../model/base_model/api_response.dart';

class ServerListRepo {
  final DioClient dioClient;

  ServerListRepo({required this.dioClient});

  Future<ApiResponse> getServersMeta() async {
    try {
      final response = await dioClient.get(AppStrings.serversMetaUrl);
      return ApiResponse.withSuccess(response);
    } catch (e) {
      return ApiResponse.withError(ApiErrorHandler.getMessage(e));
    }
  }
}
