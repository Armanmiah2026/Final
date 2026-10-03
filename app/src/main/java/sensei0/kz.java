package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kz {
    public final SenseiTunnelVpnService a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final int g;
    public final List h;
    public int i;
    public final AtomicReference j;
    public final AtomicReference k;
    public final AtomicReference l;
    public final AtomicBoolean m;
    public Thread n;
    public boolean o;
    public final ArrayList p;
    public final ArrayList q;
    public final jz r;

    public kz(SenseiTunnelVpnService senseiTunnelVpnService, String str, String str2, int i, String str3, String str4, int i2) {
        pr.j("profileText", str);
        pr.j("dnsPrimary", str3);
        pr.j("dnsSecondary", str4);
        this.a = senseiTunnelVpnService;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = i2;
        this.h = p9.f0("ovpn:eval_ok", "ovpn:creds_ok", "ovpn:connect", "ovpn:cb_log", "ovpn:cb_event", "ovpn:cb_socket_protect", "ovpn:cb_new", "ovpn:cb_address", "ovpn:cb_reroute", "ovpn:cb_route", "ovpn:cb_local_nets", "ovpn:cb_exclude", "ovpn:cb_establish", "ovpn:done");
        this.i = -1;
        this.j = new AtomicReference(null);
        this.k = new AtomicReference(null);
        this.l = new AtomicReference(null);
        this.m = new AtomicBoolean(false);
        this.o = true;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new jz(this);
    }

    public static final boolean a(String str, uo uoVar) {
        return ((Boolean) b(str, Boolean.FALSE, uoVar)).booleanValue();
    }

    public static Object b(String str, Object obj, uo uoVar) {
        try {
            return uoVar.a();
        } catch (Throwable th) {
            String str2 = "ovpn callback " + str + " failed: " + th.getClass().getSimpleName() + ": " + th.getMessage();
            Log.w("OpenVpnEngine", str2, th);
            boolean z = SenseiTunnelVpnService.J0;
            xe.i(str2);
            return obj;
        }
    }

    public final void c(String str) {
        int iIndexOf = this.h.indexOf(str);
        if (iIndexOf <= this.i) {
            return;
        }
        this.i = iIndexOf;
        try {
            xe.T(new File(this.a.getFilesDir(), "sensei_phase.txt"), str + "|" + this.c + "|" + System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.kz.d():void");
    }

    public final void e() {
        try {
            this.r.stop();
        } catch (Throwable th) {
            Log.w("OpenVpnEngine", "stop: " + th.getMessage());
        }
        Thread thread = this.n;
        if (thread != null) {
            thread.interrupt();
        }
        this.n = null;
    }
}
