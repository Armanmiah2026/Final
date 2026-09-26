# Sensei Tunnel — V1 Update

## Free server config flow
- Added a dedicated live VPN Gate public-server loader using the documented public API endpoint.
- Live public OpenVPN profiles can be downloaded into memory, reviewed, then **Save & Use**.
- Saved free profiles are stored in the same OpenVPN Server List as manually imported profiles.
- Saved free profiles are immediately selected; the normal **Connect OpenVPN** button is used to start the tunnel.
- Public VPN Gate credentials are prefilled as `vpn` / `vpn` for profiles that require authentication, matching the provider's documented public access instructions.
- Existing source-page `.ovpn` discovery and direct `.ovpn` URL import remain available.

## Build/version
- versionCode: 2
- versionName: 1.0.1
- Gradle wrapper: 9.6.0
- Android Gradle Plugin: 9.4.0

## Verification
- All Android resource XML files parse successfully.
- MainActivity `R.id` references were checked against the main layout.
- Java source was checked for duplicate method declarations and lexical delimiter consistency.
- Full Gradle APK build is environment-blocked because the Gradle distribution is not cached and external DNS/network access is unavailable in the build environment.
- No claim of successful APK compilation is made without a real Gradle/Android SDK build.
