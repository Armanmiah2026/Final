class HomeVpnStatus {
  final String state;
  final String duration;
  final int downloadSpeed;
  final int uploadSpeed;

  const HomeVpnStatus({
    this.state = 'DISCONNECTED',
    this.duration = '00:00:00',
    this.downloadSpeed = 0,
    this.uploadSpeed = 0,
  });

  bool get isConnected => state == 'CONNECTED';

  bool get isConnecting => state == 'CONNECTING';

  HomeVpnStatus copyWith({
    String? state,
    String? duration,
    int? downloadSpeed,
    int? uploadSpeed,
  }) {
    return HomeVpnStatus(
      state: state ?? this.state,
      duration: duration ?? this.duration,
      downloadSpeed: downloadSpeed ?? this.downloadSpeed,
      uploadSpeed: uploadSpeed ?? this.uploadSpeed,
    );
  }
}
