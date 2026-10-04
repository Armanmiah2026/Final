List<dynamic> extractVpnRawList(dynamic body) {
  if (body == null) return [];
  if (body is List<dynamic>) return body;
  if (body is! Map) return [];

  final map = Map<String, dynamic>.from(body);
  final layer = map['data'];

  if (layer is List<dynamic>) return layer;
  if (layer is Map) {
    final inner = layer['data'];
    if (inner is List<dynamic>) return inner;
  }

  return [];
}

bool isProtocolEnabled(dynamic value) {
  return value == 1 || value == '1' || value == true;
}
