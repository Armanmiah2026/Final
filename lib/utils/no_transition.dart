import 'package:flutter/material.dart';

/// Instant page transitions for Material [Navigator] routes.
class NoAnimationPageTransitionsBuilder extends PageTransitionsBuilder {
  const NoAnimationPageTransitionsBuilder();

  @override
  Widget buildTransitions<T>(
    PageRoute<T> route,
    BuildContext context,
    Animation<double> animation,
    Animation<double> secondaryAnimation,
    Widget child,
  ) {
    return child;
  }
}

PageTransitionsTheme get instantPageTransitionsTheme {
  return PageTransitionsTheme(
    builders: {
      for (final platform in TargetPlatform.values)
        platform: const NoAnimationPageTransitionsBuilder(),
    },
  );
}
