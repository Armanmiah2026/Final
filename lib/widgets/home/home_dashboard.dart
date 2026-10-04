import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:free_vpn/model/home_vpn_status.dart';
import 'package:free_vpn/utils/app_colors.dart';
import 'package:free_vpn/widgets/speed_dial_circle.dart';

/// Solid dark background for the home hero header.
const Color _heroBackground = Color(0xFF0F1419);

/// Responsive dial size: ~70% of screen width, bigger on all devices.
double homeDialSize(BuildContext context) {
  final width = MediaQuery.sizeOf(context).width;
  return (width * 0.70).clamp(260.0, 320.0);
}

/// Scales the speed value font so long numbers still fit inside the dial.
double _dialSpeedFontSize(String value, double dialScale) {
  final len = value.length;
  if (len <= 3) return 38 * dialScale;
  if (len <= 5) return 30 * dialScale;
  if (len <= 7) return 24 * dialScale;
  return 19 * dialScale;
}

class HomeHeroSection extends StatelessWidget {
  const HomeHeroSection({
    super.key,
    required this.status,
    required this.speedValue,
    required this.speedUnit,
    required this.downloadLine,
    required this.uploadLine,
  });

  final HomeVpnStatus status;
  final String speedValue;
  final String speedUnit;
  final String downloadLine;
  final String uploadLine;

  @override
  Widget build(BuildContext context) {
    final connected = status.isConnected;
    final connecting = status.isConnecting;
    final dialSize = homeDialSize(context);
    final dialScale = dialSize / 260;

    final displaySpeed = speedValue.isEmpty ? '0' : speedValue;
    final displayUnit = speedUnit.isEmpty ? 'B/s' : speedUnit;
    final topInset = MediaQuery.paddingOf(context).top + 16;

    return Container(
      width: double.infinity,
      decoration: const BoxDecoration(
        color: _heroBackground,
        borderRadius: BorderRadius.only(
          bottomLeft: Radius.circular(32),
          bottomRight: Radius.circular(32),
        ),
      ),
      child: Padding(
        padding: EdgeInsets.fromLTRB(20, topInset, 20, 48),
        child: Column(
          children: [
            Text(
              'Session Time',
              style: GoogleFonts.poppins(
                color: Colors.white.withValues(alpha: 0.5),
                fontSize: 12,
                fontWeight: FontWeight.w500,
                letterSpacing: 0.5,
              ),
            ),
            const SizedBox(height: 4),
            Text(
              status.duration,
              style: GoogleFonts.jetBrainsMono(
                color: Colors.white,
                fontSize: 36,
                fontWeight: FontWeight.w600,
                letterSpacing: 2,
                height: 1.1,
              ),
            ),
            const SizedBox(height: 20),
            SizedBox(
              height: dialSize + 16,
              width: double.infinity,
              child: Center(
                child: Stack(
                  alignment: Alignment.center,
                  clipBehavior: Clip.none,
                  children: [
                    SpeedDialCircle(
                      size: dialSize,
                      isActive: connected || connecting,
                    ),
                    SizedBox(
                      width: dialSize * 0.38,
                      child: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          FittedBox(
                            fit: BoxFit.scaleDown,
                            child: Text(
                              displaySpeed,
                              maxLines: 1,
                              style: GoogleFonts.jetBrainsMono(
                                fontSize: _dialSpeedFontSize(
                                  displaySpeed,
                                  dialScale,
                                ),
                                fontWeight: FontWeight.w700,
                                color: connected
                                    ? const Color(0xFF111827)
                                    : const Color(0xFF94A3B8),
                                height: 1,
                                letterSpacing: -0.5,
                              ),
                            ),
                          ),
                          if (displayUnit.isNotEmpty) ...[
                            SizedBox(height: 2 * dialScale),
                            FittedBox(
                              fit: BoxFit.scaleDown,
                              child: Text(
                                displayUnit,
                                maxLines: 1,
                                style: GoogleFonts.poppins(
                                  fontSize: 14 * dialScale,
                                  fontWeight: FontWeight.w600,
                                  color: const Color(0xFF64748B),
                                  height: 1,
                                ),
                              ),
                            ),
                          ],
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 12),
            Row(
              children: [
                Expanded(
                  child: _SpeedStatCard(
                    icon: Icons.arrow_downward_rounded,
                    label: 'Download',
                    value: downloadLine,
                    accent: const Color(0xFF38BDF8),
                  ),
                ),
                const SizedBox(width: 10),
                Expanded(
                  child: _SpeedStatCard(
                    icon: Icons.arrow_upward_rounded,
                    label: 'Upload',
                    value: uploadLine,
                    accent: const Color(0xFF4ADE80),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}

class _SpeedStatCard extends StatelessWidget {
  const _SpeedStatCard({
    required this.icon,
    required this.label,
    required this.value,
    required this.accent,
  });

  final IconData icon;
  final String label;
  final String value;
  final Color accent;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 14, vertical: 12),
      decoration: BoxDecoration(
        color: const Color(0xFF1A2129),
        borderRadius: BorderRadius.circular(14),
        border: Border.all(color: Colors.white.withValues(alpha: 0.06)),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(icon, size: 16, color: accent),
              const SizedBox(width: 6),
              Text(
                label,
                style: GoogleFonts.poppins(
                  color: Colors.white.withValues(alpha: 0.55),
                  fontSize: 11,
                  fontWeight: FontWeight.w500,
                ),
              ),
            ],
          ),
          const SizedBox(height: 6),
          Text(
            value,
            style: GoogleFonts.jetBrainsMono(
              color: Colors.white,
              fontSize: 14,
              fontWeight: FontWeight.w700,
            ),
          ),
        ],
      ),
    );
  }
}

class HomeConnectButton extends StatelessWidget {
  const HomeConnectButton({
    super.key,
    required this.isConnected,
    required this.isConnecting,
    required this.onTap,
  });

  final bool isConnected;
  final bool isConnecting;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final buttonLabel = isConnected
        ? 'STOP'
        : isConnecting
            ? 'CONNECTING'
            : 'START';

    final buttonIcon = isConnected
        ? Icons.power_settings_new_rounded
        : isConnecting
            ? Icons.sync_rounded
            : Icons.play_arrow_rounded;

    final gradientColors = isConnected
        ? [const Color(0xFFE53935), const Color(0xFFC62828)]
        : isConnecting
            ? [const Color(0xFF64748B), const Color(0xFF475569)]
            : [AppColors.appPrimaryColor, const Color(0xFFFF8C00)];

    return Transform.translate(
      offset: const Offset(0, -28),
      child: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 72),
        child: Material(
          color: Colors.transparent,
          child: InkWell(
            onTap: isConnecting ? null : onTap,
            borderRadius: BorderRadius.circular(30),
            child: Ink(
              height: 58,
              decoration: BoxDecoration(
                gradient: LinearGradient(
                  colors: gradientColors,
                  begin: Alignment.topLeft,
                  end: Alignment.bottomRight,
                ),
                borderRadius: BorderRadius.circular(30),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  if (isConnecting)
                    const SizedBox(
                      width: 22,
                      height: 22,
                      child: CircularProgressIndicator(
                        strokeWidth: 2.5,
                        color: Colors.white,
                      ),
                    )
                  else
                    Icon(
                      buttonIcon,
                      color: Colors.white,
                      size: 24,
                    ),
                  const SizedBox(width: 8),
                  Text(
                    buttonLabel,
                    style: GoogleFonts.poppins(
                      color: Colors.white,
                      fontSize: isConnecting ? 15 : 17,
                      fontWeight: FontWeight.w700,
                      letterSpacing: 1.2,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class HomeLocationCard extends StatelessWidget {
  const HomeLocationCard({
    super.key,
    required this.serverName,
    required this.countryCode,
    required this.protocol,
    required this.onTap,
  });

  final String serverName;
  final String? countryCode;
  final String protocol;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    final hasServer = serverName.isNotEmpty;
    final code = (countryCode ?? '').toLowerCase();

    return Padding(
      padding: const EdgeInsets.fromLTRB(20, 4, 20, 0),
      child: Material(
        color: Colors.white,
        elevation: 0,
        borderRadius: BorderRadius.circular(20),
        child: InkWell(
          onTap: onTap,
          borderRadius: BorderRadius.circular(20),
          child: Ink(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(20),
              border: Border.all(color: Colors.grey.shade200),
              boxShadow: [
                BoxShadow(
                  color: Colors.black.withValues(alpha: 0.05),
                  blurRadius: 20,
                  offset: const Offset(0, 8),
                ),
              ],
            ),
            child: Row(
              children: [
                Container(
                  width: 48,
                  height: 48,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    color: Colors.grey.shade100,
                    border: Border.all(color: Colors.grey.shade200),
                  ),
                  clipBehavior: Clip.antiAlias,
                  child: hasServer && code.isNotEmpty
                      ? Image.asset(
                          'assets/flags/$code.png',
                          fit: BoxFit.cover,
                          errorBuilder: (_, __, ___) => const Icon(
                            Icons.public_rounded,
                            color: AppColors.appPrimaryColor,
                          ),
                        )
                      : const Icon(
                          Icons.location_on_rounded,
                          color: AppColors.appPrimaryColor,
                          size: 26,
                        ),
                ),
                const SizedBox(width: 14),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        hasServer ? serverName : 'Select Location',
                        style: GoogleFonts.poppins(
                          color: Colors.black87,
                          fontSize: 16,
                          fontWeight: FontWeight.w600,
                        ),
                        maxLines: 1,
                        overflow: TextOverflow.ellipsis,
                      ),
                      const SizedBox(height: 2),
                      Text(
                        hasServer
                            ? protocol == 'openvpn'
                                ? 'OpenVPN Server'
                                : 'V2Ray Server'
                            : 'Choose a server to connect',
                        style: GoogleFonts.poppins(
                          color: Colors.grey.shade600,
                          fontSize: 12,
                          fontWeight: FontWeight.w500,
                        ),
                      ),
                    ],
                  ),
                ),
                Container(
                  padding: const EdgeInsets.all(10),
                  decoration: BoxDecoration(
                    gradient: LinearGradient(
                      colors: [
                        AppColors.appPrimaryColor,
                        const Color(0xFFFF8C00),
                      ],
                    ),
                    shape: BoxShape.circle,
                  ),
                  child: const Icon(
                    Icons.arrow_forward_ios_rounded,
                    color: Colors.white,
                    size: 14,
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
