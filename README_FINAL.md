# Sensei Tunnel – Final audit build

This build consolidates the V4 fixes and removes known Java source-level defects from the previous V4 package.

## Implemented / hardened
- OpenVPN and V2Ray/Xray profile import/manual save.
- Live free-server catalog with VPN Gate OpenVPN config download/save/use flow.
- OpenVPN `auth-user-pass` credential prompt and per-profile credential storage.
- Separate Payload List; OpenVPN payloads can be assigned to an OpenVPN server; Xray payloads can be used with the selected Xray config.
- Payload editor with HTTP Custom, WebSocket, SSL WebSocket, HTTP Injection label, CONNECT, HTTP/2, gRPC, XHTTP and HTTPUpgrade presets; template placeholders; proxy host/port; SNI/Host.
- Protocol-aware payload test: TCP/TLS handshake and HTTP-style response checks where applicable; persistent GOOD/WRONG status is shown in Payload List.
- Server card ONLINE/OFFLINE endpoint probing.
- Selected profile persistence and failover sequencing.
- Country filtering and payload-assigned-server filter.
- Sensei-style scrollable drawer.
- Device Token and encrypted app-private File Locker.
- Service files encrypted with a key derived from the Device Token; expiry validation; allowed-app metadata; adult-site routing preference; server/config/payload selection; in-app service-file list and FileProvider sharing.
- Imported service-profile metadata is retained and checked for token/expiry on later use.
- Custom wallpaper stored in app-private storage.
- Private Server Installer using SSH; credentials are not persisted; installed servers are saved to a Private Server List; SSH endpoint check; encrypted server access file with expiry/device-count metadata.
- Xray Android `VpnService` TUN bridge, per-app allow-list support, and optional porn-domain routing rule.
- Xray share-link/JSON handling through libXray plus legacy VMess Base64 compatibility.

## Explicit limitations
- A TCP/TLS probe is not proof that a complete VPN tunnel or carrier-specific payload works. The GOOD/WRONG test is intentionally based on the strongest protocol-level check available without performing a full VPN session.
- Arbitrary carrier injection/HTTP Custom tricks cannot be implemented as a generic Xray/OpenVPN feature; they require a compatible transport engine and server/carrier behavior.
- Every V2RayNG screen/core feature is not the same thing as embedding V2RayNG. This app uses the bundled libXray core and supports common Xray JSON/share-link workflows.
- A `maxDevices` value in a service/access file is metadata only. Real cross-device device-count enforcement requires a server-side licensing/activation service.
- The private-server installer opens only explicitly selected ports. It does not blindly open TCP/UDP 1–65535, and it does not claim that packages alone constitute a complete production VPN deployment.
- Some Android settings such as APN and preferred 4G/5G mode are opened through system settings because ordinary apps cannot universally change carrier-controlled settings.
- A real Android/Gradle build was attempted but could not reach the Gradle 9.6 distribution in this environment. Java source/resource/static checks and ZIP integrity checks were run locally.
