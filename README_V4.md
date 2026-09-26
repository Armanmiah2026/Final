# Sensei Tunnel V4 update

This update adds:
- Service-file library inside app with share support through Android FileProvider.
- Service file can contain OpenVPN server, V2Ray/Xray config, payload, or combinations.
- Expiry date, max-device metadata, network name, allowed-app list, adult-site routing preference.
- Home server filter: all OpenVPN servers or only servers with an assigned payload.
- Live TCP endpoint probes for server cards.
- Payload test status (GOOD/WRONG) based on endpoint reachability.
- Custom wallpaper stored in app-private storage.
- Proxy host + port fields and SSL SNI/Host field in payload editor.
- Expanded payload/transport presets: HTTP Custom, WS, SSL WS, HTTP Injection, CONNECT, HTTP/2, gRPC, XHTTP, HTTPUpgrade.
- SSH private-server installer UI for Debian/Ubuntu package setup and explicitly selected firewall ports. SSH credentials are not persisted.

Important limitations:
- TCP reachability is not proof that a VPN tunnel or carrier-specific payload is functionally working.
- HTTP injection/carrier tricks are not a generic OpenVPN feature; arbitrary raw injection requires a dedicated transport engine.
- Xray can import existing Xray/V2Ray JSON and common share links, but reproducing every V2RayNG UI/core feature is not equivalent to embedding V2RayNG.
- maxDevices is portable metadata; strict cross-device device-count enforcement requires a server-side licensing backend.
- The installer opens only the ports entered by the user; it intentionally does not expose every port.
