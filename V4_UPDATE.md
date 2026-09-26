# Sensei Tunnel V4 Update

Version code: 4
Version name: 4.0.0

This package keeps the dark Sensei Tunnel dashboard direction and the existing server/payload workflows.

## Included feature areas
- OpenVPN server profiles and .ovpn import
- V2Ray/Xray profile import/manual configuration
- Free-server discovery/download/save flow
- Server list, favorites and latency metadata
- Fastest tested server selection
- Payload list with generated/manual payload support
- Payload-to-server assignment for OpenVPN
- Auto reconnect/failover controls
- Speed test / latency UI
- Connection history/logging
- DNS / Always-on / Kill-switch / boot settings where supported by Android/core
- Dark Sensei Tunnel dashboard and bottom navigation
- GitHub Actions debug APK build workflow

## Build
Run `./gradlew assembleDebug` on a machine/CI runner with Android/Gradle dependencies available.
The included GitHub Actions workflow builds and uploads `app-debug.apk` as an artifact.
