package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import ph.yooh.novpn.ClientAPI_LogInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hz implements uo {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ hz(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.uo
    public final Object a() {
        String string;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                String text = ((ClientAPI_LogInfo) obj).getText();
                if (text != null && (string = fc0.A0(text).toString()) != null) {
                    Log.d("OpenVpnEngine", "ovpn: ".concat(string));
                    boolean z = SenseiTunnelVpnService.J0;
                    xe.i("ovpn: ".concat(string));
                }
                return mg0.a;
            default:
                boolean z2 = SenseiTunnelVpnService.J0;
                return ((SenseiTunnelVpnService) obj).getSharedPreferences("sensei_session", 0);
        }
    }
}
