package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements fp {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        int i = this.a;
        mg0 mg0Var = mg0.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                if (obj != ((m) obj2)) {
                    break;
                }
                break;
            case 1:
                String str = (String) obj;
                pr.j("it", str);
                ((ArrayList) obj2).add(str);
                break;
            case 2:
                cz czVar = (cz) obj2;
                String str2 = (String) obj;
                pr.j("line", str2);
                if (!fc0.l0(str2)) {
                    String strC = czVar.D.c(str2, "");
                    Log.d("OpenVpn2Engine", "ovpn2: ".concat(strC));
                    boolean z = SenseiTunnelVpnService.J0;
                    xe.i("ovpn2: ".concat(strC));
                }
                break;
            default:
                ((fp) obj2).g(new w50(((v50) obj).a));
                break;
        }
        return mg0Var;
    }
}
