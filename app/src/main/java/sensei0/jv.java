package sensei0;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.sensei.tunnel.MainActivity;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jv implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ jv(Object obj, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        int i2 = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj;
                for (ov ovVar : MainActivity.n()) {
                    Intent intentAddFlags = ((Intent) ovVar.b.a()).addFlags(268435456);
                    pr.i("addFlags(...)", intentAddFlags);
                    intentAddFlags.putExtra("android.provider.extra.SUB_ID", i2);
                    intentAddFlags.putExtra("sub_id", i2);
                    if (mainActivity.E(intentAddFlags, ovVar.a + " (SIM " + i2 + ")")) {
                        break;
                    }
                }
                boolean z = SenseiTunnelVpnService.J0;
                xe.i("Network settings: SIM-specific launch failed everywhere — generic chain");
                mainActivity.x(false);
                break;
            case 1:
                boolean z2 = MainActivity.B;
                ((rk) obj).d(Integer.valueOf(i2));
                break;
            case 2:
                i3 i3Var = ((a10) obj).b.b;
                if ((i2 & 4) == 0) {
                    ((aj) i3Var.b).a("SystemChrome.systemUIChange", Arrays.asList(Boolean.TRUE), null);
                } else {
                    ((aj) i3Var.b).a("SystemChrome.systemUIChange", Arrays.asList(Boolean.FALSE), null);
                }
                break;
            case 3:
                ((pr) obj).H(i2);
                break;
            case 4:
                String str = (String) obj;
                boolean z3 = SenseiTunnelVpnService.J0;
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(str, i2), 5000);
                    socket.close();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    SenseiTunnelVpnService.K0 = jCurrentTimeMillis2;
                    Log.i("SenseiTunnelVPN", "Delay to " + str + ":" + i2 + " = " + jCurrentTimeMillis2 + "ms");
                } catch (Exception e) {
                    SenseiTunnelVpnService.K0 = -1L;
                    Log.w("SenseiTunnelVPN", "Delay measurement failed: " + e.getMessage());
                    return;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.p.get();
                if (view != null) {
                    sideSheetBehavior.t(view, i2, false);
                }
                break;
        }
    }
}
