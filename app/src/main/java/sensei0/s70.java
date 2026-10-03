package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import com.trilead.ssh2.ConnectionMonitor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s70 implements ConnectionMonitor {
    public final /* synthetic */ SenseiTunnelVpnService a;

    public s70(SenseiTunnelVpnService senseiTunnelVpnService) {
        this.a = senseiTunnelVpnService;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    @Override // com.trilead.ssh2.ConnectionMonitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void connectionLost(java.lang.Throwable r4) {
        /*
            r3 = this;
            com.sensei.tunnel.SenseiTunnelVpnService r0 = r3.a
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.d
            boolean r1 = r1.get()
            if (r1 != 0) goto Lb
            return
        Lb:
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.o0
            r1 = 1
            r0.set(r1)
            if (r4 == 0) goto L35
            java.lang.Class r0 = r4.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ": "
            r1.append(r0)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            if (r4 != 0) goto L37
        L35:
            java.lang.String r4 = "unknown"
        L37:
            java.lang.String r0 = "SenseiTunnelVPN"
            java.lang.String r1 = "SSH connection lost: "
            java.lang.String r2 = r1.concat(r4)
            android.util.Log.w(r0, r2)
            boolean r0 = com.sensei.tunnel.SenseiTunnelVpnService.J0
            java.lang.String r4 = r1.concat(r4)
            sensei0.xe.i(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.s70.connectionLost(java.lang.Throwable):void");
    }

    @Override // com.trilead.ssh2.ConnectionMonitor
    public final void onReceiveInfo(int i, String str) {
        if (i != 101 || str == null) {
            return;
        }
        Log.i("SenseiTunnelVPN", "SSH MOTD: ".concat(str));
        SenseiTunnelVpnService.g("motd:".concat(str));
    }

    @Override // com.trilead.ssh2.ConnectionMonitor
    public final void log(int i, String str, String str2) {
    }
}
