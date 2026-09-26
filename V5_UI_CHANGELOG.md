# Sensei Tunnel V5 — UI Match Pass

This version is a visual redesign based on the supplied Sensei Tunnel reference collage and the supplied screen-recording.

## Main changes
- Added a reference-style splash screen with Sensei branding and V5 label.
- Rebuilt the home dashboard around the reference hierarchy: top toolbar, connection card, server/config rows, and compact bottom navigation.
- Added reference-style full-screen Server List with search, tabs, filter chips, favorites, latency metadata, and server details.
- Added reference-style Free Server screen with Live Servers / Multiple Sources, refresh, auto-refresh, VPN Gate catalog, and manual URL import.
- Added reference-style Server Details and Connect actions.
- Added reference-style Payload List with search, type filters, favorites, and Generate / Manual actions.
- Added reference-style Add Server / Config screen with .ovpn, URL, and Manual workflow controls.
- Added reference-style Free Server Download progress screen.
- Added reference-style Favorite Servers, Settings, Speed Test & Ping, Auto Reconnect, Connection Logs, and Quick Connect screens.
- Kept the existing OpenVPN and V2Ray/Xray engine controls hidden behind the redesigned UI so the VPN logic is not removed.
- Version bumped to 5.0.0 / versionCode 5.

## Verification
- All XML resources parse successfully.
- All Java `R.id` references are defined.
- Java source passed parser-level syntax checks with `javac` (Android SDK classes are not available in this build container).
- Gradle wrapper could not perform a real Android build in this environment because the environment cannot reach services.gradle.org. GitHub Actions remains the final Android compile check.
