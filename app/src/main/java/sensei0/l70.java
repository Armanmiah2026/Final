package sensei0;

import android.net.TrafficStats;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.sensei.tunnel.AppSecurity;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/** Background workers for VPN startup, liveness and native process output. */
public final class l70 implements Runnable {
    public final int a;
    public final SenseiTunnelVpnService b;

    public l70(SenseiTunnelVpnService service, int mode) {
        this.a = mode;
        this.b = service;
    }

    private static String message(Throwable t) {
        String m = t.getMessage();
        return m == null || m.trim().isEmpty() ? t.getClass().getSimpleName() : m;
    }

    private void readProcessOutput(Process process, String prefix, boolean keepTail) {
        if (process == null) return;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), e8.a), 8192)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("SenseiTunnelVPN", prefix + line);
                if (keepTail) {
                    synchronized (b.r0) {
                        b.r0.append(line).append('\n');
                        if (b.r0.length() > 4000) b.r0.delete(0, b.r0.length() - 4000);
                    }
                }
            }
        } catch (Exception e) {
            if (b.d.get()) Log.e("SenseiTunnelVPN", prefix + "output reader error", e);
        }
    }

    private void startTunnel() {
        if (b.d.getAndSet(true)) {
            Log.w("SenseiTunnelVPN", "VPN already running");
            return;
        }
        try {
            // Rebuilt APKs have a different signing certificate; integrity mismatch
            // must not prevent a user-built debug APK from starting the VPN.
            try {
                if (!AppSecurity.a.d(b)) Log.w("SenseiTunnelVPN", "Native integrity check did not match rebuilt APK; continuing");
            } catch (Throwable e) {
                Log.w("SenseiTunnelVPN", "Integrity check unavailable; continuing: " + message(e));
            }

            SenseiTunnelVpnService.g("connecting");
            b.n("start");
            b.D();
            b.e();
            b.F();
            b.a();
            b.s();

            VpnService.Builder builder = new VpnService.Builder(b)
                    .setSession("Sensei Tunnel")
                    .setMtu(b.z)
                    .addAddress("26.26.26.1", 30)
                    .addRoute("0.0.0.0", 0)
                    .addDnsServer(b.A)
                    .addDnsServer(b.B);
            if (b.C) {
                try {
                    w0.o(builder, w0.e(java.net.InetAddress.getByName("10.0.0.0")));
                    w0.o(builder, w0.u(java.net.InetAddress.getByName("172.16.0.0")));
                    builder = w0.g(builder, w0.y(java.net.InetAddress.getByName("192.168.0.0")));
                } catch (Throwable e) {
                    Log.w("SenseiTunnelVPN", "excludeRoute (bypass LAN) failed: " + message(e));
                }
            }
            try {
                builder.addAddress("fc00::1", 7);
                builder.addRoute("::", 0);
            } catch (Throwable e) {
                Log.w("SenseiTunnelVPN", "IPv6 not supported: " + message(e));
            }
            b.b(builder);
            ParcelFileDescriptor tun = builder.establish();
            if (tun == null) throw new java.io.IOException("VPN interface rejected by the system");
            b.a = tun;
            Log.i("SenseiTunnelVPN", "VPN interface created, fd=" + tun.getFd());
            if (!b.E()) throw new java.io.IOException("No network interface (turn on WiFi / mobile data / Ethernet / BT tether)");
            Log.i("SenseiTunnelVPN", "Network interface up, starting engines");
            b.C(true);

            if (b.X) {
                b.n("openvpn");
                b.w();
            } else {
                String mode = b.W == null ? "" : b.W.toLowerCase(Locale.ROOT);
                boolean dnstt = mode.contains("dnstt");
                boolean sshNeedsDnstt = b.o && !fc0.l0(b.a0);
                if (b.o) {
                    if (dnstt || sshNeedsDnstt) b.v();
                    b.x();
                } else {
                    if (b.i0) b.z();
                    b.A();
                }
                b.y();
            }
            b.o();

            Thread monitor = new Thread(new l70(b, 1), "sensei-liveness");
            monitor.setDaemon(true);
            b.z0 = monitor;
            monitor.start();

            SenseiTunnelVpnService.g("probe:checking");
            if (!b.t()) throw new java.io.IOException("Tunnel engines started but local SOCKS bind never came up");
            if (!b.u()) throw new java.io.IOException("Tunnel is up but no internet flows through it — server may be down or blocked");

            long connectedAt = System.currentTimeMillis();
            b.N = connectedAt;
            ((android.content.SharedPreferences) b.P.a()).edit().putLong("connectedAt", connectedAt).apply();
            b.Q.removeCallbacks(b.R);
            b.Q.postDelayed(b.R, 1000L);
            b.C(true);
            b.c();
            try { b.p().delete(); } catch (Throwable ignored) {}
            SenseiTunnelVpnService.g("connected");
            Log.i("SenseiTunnelVPN", "VPN connected successfully to " + b.h);
        } catch (Throwable error) {
            String reason = message(error);
            Log.e("SenseiTunnelVPN", "VPN start failed: " + reason, error);
            SenseiTunnelVpnService.g("error:" + reason);
            try { b.p().delete(); } catch (Throwable ignored) {}
            b.B();
        }
    }

    private void monitor() {
        int failedProbes = 0;
        long lastRx = TrafficStats.getTotalRxBytes();
        long lastTx = TrafficStats.getTotalTxBytes();
        long lastAt = System.currentTimeMillis();
        while (b.d.get()) {
            try { Thread.sleep(1000L); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
            long now = System.currentTimeMillis();
            long rx = TrafficStats.getTotalRxBytes();
            long tx = TrafficStats.getTotalTxBytes();
            long dt = Math.max(1L, now - lastAt);
            b.h(Math.max(0L, (rx - lastRx) * 1000L / dt), Math.max(0L, (tx - lastTx) * 1000L / dt), rx, tx);
            b.C(true);
            lastRx = rx; lastTx = tx; lastAt = now;

            boolean alive;
            if (b.X) {
                cz ovpn2 = b.q0;
                kz ovpn3 = b.p0;
                alive = (ovpn2 != null && ovpn2.k.get() && ovpn2.l != null && ovpn2.l.isAlive())
                        || (ovpn3 != null && ovpn3.n != null && ovpn3.n.isAlive());
            } else {
                alive = (b.b == null || s0.A(b.b)) && (b.c == null || s0.A(b.c)) && (b.d0 == null || s0.A(b.d0));
            }
            if (!alive) { Log.w("SenseiTunnelVPN", "engine process died"); b.j(); return; }
            try {
                if (b.m()) failedProbes = 0;
                else if (++failedProbes >= 3) { Log.e("SenseiTunnelVPN", "tunnel dead: 3 consecutive probes failed"); b.j(); return; }
            } catch (Throwable e) {
                if (++failedProbes >= 3) { b.j(); return; }
            }
        }
    }

    @Override public void run() {
        switch (a) {
            case 1: monitor(); return;
            case 2: readProcessOutput(b.c, "tun2socks: ", false); return;
            case 3: readProcessOutput(b.d0, "dnstt: ", false); return;
            case 4: readProcessOutput(b.b, "xray: ", true); return;
            default: startTunnel();
        }
    }
}
