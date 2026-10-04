import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:free_vpn/data/model/base_model/api_response.dart';

Map<String, dynamic>? parseResponseMap(dynamic data) {
  if (data == null) return null;
  if (data is Map<String, dynamic>) return data;
  if (data is Map) return Map<String, dynamic>.from(data);
  if (data is String && data.trim().isNotEmpty) {
    final decoded = jsonDecode(data);
    if (decoded is Map) return Map<String, dynamic>.from(decoded);
  }
  return null;
}

String formatApiError(dynamic error) {
  if (error == null) return 'Something went wrong';
  if (error is String) return error;
  if (error is List) {
    return error.map((e) => e.toString()).join('\n');
  }
  if (error is Map) {
    final parts = <String>[];
    error.forEach((key, value) {
      if (value is List) {
        parts.addAll(value.map((e) => e.toString()));
      } else {
        parts.add(value.toString());
      }
    });
    if (parts.isNotEmpty) return parts.join('\n');
  }
  return error.toString();
}

String? extractAuthToken(Map<String, dynamic> data) {
  final token = data['token'];
  if (token == null) return null;
  final value = token.toString().trim();
  return value.isEmpty ? null : value;
}

/// Parses login/register responses and network failures into a single result.
({String? token, String? error}) parseAuthApiResponse(ApiResponse apiResponse) {
  if (apiResponse.error != null) {
    final err = apiResponse.error;
    if (err is String) {
      return (token: null, error: err);
    }
    return (token: null, error: err.toString());
  }

  final response = apiResponse.response;
  if (response == null) {
    return (token: null, error: 'No response from server');
  }

  final data = parseResponseMap(response.data);
  if (data == null) {
    return (token: null, error: 'Invalid server response');
  }

  if (data.containsKey('error')) {
    return (token: null, error: formatApiError(data['error']));
  }

  final token = extractAuthToken(data);
  if (token != null) {
    return (token: token, error: null);
  }

  final message = data['message']?.toString() ?? data['massage']?.toString();
  return (token: null, error: message ?? 'Authentication failed');
}

String dioErrorMessage(Object error) {
  if (error is DioException) {
    final data = parseResponseMap(error.response?.data);
    if (data != null && data.containsKey('error')) {
      return formatApiError(data['error']);
    }
    return error.message ?? 'Network request failed';
  }
  return error.toString();
}
