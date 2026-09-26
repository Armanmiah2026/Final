# Free + Private Server Update

## Free servers
- Added a **Free Server List** menu.
- Primary source: the official VPN Gate public server catalog/API over HTTPS.
- The app can fetch a live public-server catalog and decode the published OpenVPN configuration into the normal Server List flow.
- The previous source-page `.ovpn` discovery flow remains available as a generic fallback.
- Each downloaded profile goes through the existing OVPN save flow, where username/password can be entered if the profile requires `auth-user-pass`.
- Added VPN Gate live public OpenVPN catalog/API as a first-class free-server source.
- Added direct `.ovpn` URL import.

## Private servers
- Added **My Private VPN Server** menu.
- User can import a local `.ovpn`, paste an `.ovpn` config, or import an `.ovpn` URL.
- Username/password are entered during profile save when required.
- No third-party credentials are guessed or embedded.

## Important
The primary free-server URL could not be reached from the build environment at update time, so the integration uses a runtime HTML/.ovpn-link parser rather than hard-coding a server list. A TCP-open port is not treated as proof that an OpenVPN account or payload is valid; the existing OpenVPN connection/authentication flow remains the final test.
