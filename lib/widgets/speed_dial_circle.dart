import 'package:flutter/material.dart';
import 'package:free_vpn/utils/app_colors.dart';

/// Layered circular speed dial with a clean inner disc for metrics.
class SpeedDialCircle extends StatelessWidget {
  const SpeedDialCircle({
    super.key,
    this.size = 260,
    this.isActive = false,
  });

  final double size;
  final bool isActive;

  @override
  Widget build(BuildContext context) {
    final layers = isActive ? _activeLayers : _idleLayers;

    return SizedBox(
      width: size,
      height: size,
      child: Stack(
        alignment: Alignment.center,
        clipBehavior: Clip.none,
        children: [
          // Soft ambient glow when connected
          if (isActive)
            Container(
              width: size,
              height: size,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                boxShadow: [
                  BoxShadow(
                    color: AppColors.appPrimaryColor.withValues(alpha: 0.35),
                    blurRadius: size * 0.18,
                    spreadRadius: size * 0.02,
                  ),
                ],
              ),
            ),
          // Outer track ring
          Container(
            width: size,
            height: size,
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              border: Border.all(
                color: isActive
                    ? Colors.white.withValues(alpha: 0.14)
                    : Colors.white.withValues(alpha: 0.08),
                width: 1.5,
              ),
            ),
          ),
          for (final layer in layers)
            ClipPath(
              clipper: CircularLayerClipper(radiusScale: layer.radiusScale),
              child: DecoratedBox(
                decoration: BoxDecoration(
                  color: layer.color,
                  border: layer.borderColor != null
                      ? Border.all(
                          color: layer.borderColor!,
                          width: layer.borderWidth,
                        )
                      : null,
                ),
                child: const SizedBox.expand(),
              ),
            ),
        ],
      ),
    );
  }

  static const _activeLayers = <_DialLayer>[
    _DialLayer(radiusScale: 0.92, color: Color(0xFFCC5500)),
    _DialLayer(radiusScale: 0.76, color: Color(0xFFFF7A00)),
    _DialLayer(radiusScale: 0.60, color: Color(0xFFFFA040)),
    _DialLayer(
      radiusScale: 0.44,
      color: Color(0xFFFFF8F0),
      borderColor: Color(0xFFFFE0B2),
      borderWidth: 1,
    ),
  ];

  static const _idleLayers = <_DialLayer>[
    _DialLayer(radiusScale: 0.92, color: Color(0xFF2A323D)),
    _DialLayer(radiusScale: 0.76, color: Color(0xFF343D4A)),
    _DialLayer(radiusScale: 0.60, color: Color(0xFF3E4856)),
    _DialLayer(
      radiusScale: 0.44,
      color: Color(0xFFF5F6F8),
      borderColor: Color(0xFFE2E8F0),
      borderWidth: 1,
    ),
  ];
}

class _DialLayer {
  const _DialLayer({
    required this.radiusScale,
    required this.color,
    this.borderColor,
    this.borderWidth = 1,
  });

  final double radiusScale;
  final Color color;
  final Color? borderColor;
  final double borderWidth;
}

/// Perfect circle clipper for each concentric dial layer.
class CircularLayerClipper extends CustomClipper<Path> {
  const CircularLayerClipper({required this.radiusScale});

  final double radiusScale;

  @override
  Path getClip(Size size) {
    final center = Offset(size.width / 2, size.height / 2);
    final radius = size.width / 2 * radiusScale;
    return Path()..addOval(Rect.fromCircle(center: center, radius: radius));
  }

  @override
  bool shouldReclip(covariant CircularLayerClipper oldClipper) {
    return oldClipper.radiusScale != radiusScale;
  }
}
