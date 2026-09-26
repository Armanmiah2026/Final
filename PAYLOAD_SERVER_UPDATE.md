# Payload + Server workflow update

This update integrates the requested classic payload/server management flow into the existing VPN project.

## Added
- Payload List -> Add Payload now offers:
  - Generate Payload (existing RK generator)
  - Add Payload Manually
- Manual payload supports name, payload type, host/IP, port, SNI and raw request/payload text.
- Existing OpenVPN server selection can be attached to manually saved payloads.
- Server List -> Add Server / Config now supports:
  - OpenVPN `.ovpn` config
  - V2Ray/Xray JSON/share-link config
  - local name/country and OpenVPN credentials
- Saved servers remain in the existing profile/config store, so the normal Configs and Connect flow can use them.

## Compatibility
Existing generated payloads, imported configs, private-server installer, payload testing, locking and connection logic were left in place.
