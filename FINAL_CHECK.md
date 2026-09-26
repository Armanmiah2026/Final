# Final verification report

This package contains the latest V4 source available in the workspace plus the final safety/logic fix for an empty V2Ray app allow-list.

## Verified locally
- Java source brace balance checked for all main Java files.
- Android resource XML files parsed successfully.
- Every `R.id.*` reference used by MainActivity exists in `activity_main.xml`.
- ZIP packaging can be tested after creation.

## Important runtime limitations
- A full Android/Gradle build could not be executed in this environment because Gradle 9.6.0 is not cached and `services.gradle.org` is unreachable from the build environment.
- Real OpenVPN/V2Ray connectivity cannot be certified without a physical Android device, the BongoVPN runtime, libXray runtime, and reachable test servers.
- Server ONLINE/OFFLINE is a TCP endpoint probe, not proof of a successful VPN handshake.
- Payload GOOD/WRONG testing is protocol-aware for basic HTTP/HTTPS request cases; carrier-specific injection behavior still depends on the target network/server.
- V2Ray/Xray support covers the implemented share-link/Xray JSON paths; this is not a claim of feature parity with every V2RayNG release.
- The private-server installer installs requested packages and opens only explicitly entered ports. It does not blindly open 1-65535 and does not claim universal automatic OpenVPN/Xray server provisioning for every distro/provider.
- Service-file device limits are metadata unless a server-side licensing/activation backend enforces them.
- Android app allow-list enforcement is implemented for the Xray VpnService path. OpenVPN per-app routing depends on the capabilities exposed by the BongoVPN library.
