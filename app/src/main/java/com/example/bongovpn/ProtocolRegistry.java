package com.example.bongovpn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Protocol definitions mirrored from the supplied RK generator project. */
public final class ProtocolRegistry {
    public static final String OPENVPN = "OpenVPN";
    public static final String UDP_HYSTERIA = "UDP Hysteria";
    public static final String V2RAY = "V2Ray";
    public static final String PSIPHON = "Psiphon";
    public static final String OPENCONNECT = "OpenConnect";
    public static final String SSH = "SSH";
    public static final String SLOW_DNS = "Slow DNS";

    private ProtocolRegistry() {}

    public static List<String> all() {
        return Collections.unmodifiableList(Arrays.asList(
                OPENVPN, UDP_HYSTERIA, V2RAY, PSIPHON, OPENCONNECT, SSH, SLOW_DNS
        ));
    }

    public static boolean isImplemented(String protocol) {
        // These are the two native engines currently present in vpn.zip.
        return OPENVPN.equals(protocol) || V2RAY.equals(protocol);
    }
}
