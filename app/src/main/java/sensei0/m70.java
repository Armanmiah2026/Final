package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m70 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ m70(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                String str = this.b;
                try {
                    yi yiVar = SenseiTunnelVpnService.N0;
                    if (yiVar != null) {
                        yiVar.a(str);
                    }
                } catch (Exception e) {
                    Log.e("SenseiTunnelVPN", "Failed to emit state", e);
                    return;
                }
                break;
            default:
                String str2 = this.b;
                try {
                    yi yiVar2 = SenseiTunnelVpnService.N0;
                    if (yiVar2 != null) {
                        pr.j("msg", str2);
                        yiVar2.a("log:" + SenseiTunnelVpnService.Q0.d(str2, new a3(17)));
                    }
                } catch (Exception e2) {
                    Log.e("SenseiTunnelVPN", "Failed to emit log", e2);
                }
                break;
        }
    }
}
