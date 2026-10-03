package sensei0;

import android.net.VpnService;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gz implements uo {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ kz c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int f;

    public /* synthetic */ gz(boolean z, kz kzVar, String str, int i, int i2) {
        this.a = i2;
        this.b = z;
        this.c = kzVar;
        this.d = str;
        this.f = i;
    }

    @Override // sensei0.uo
    public final Object a() throws UnknownHostException {
        VpnService.Builder builder;
        VpnService.Builder builder2;
        switch (this.a) {
            case 0:
                boolean z = this.b;
                kz kzVar = this.c;
                if (!z || kzVar.o) {
                    InetAddress byName = InetAddress.getByName(this.d);
                    VpnService.Builder builder3 = (VpnService.Builder) kzVar.j.get();
                    if (builder3 != null) {
                        builder3.excludeRoute(w0.f(byName, this.f));
                    }
                }
                break;
            case 1:
                boolean z2 = this.b;
                kz kzVar2 = this.c;
                if ((!z2 || kzVar2.o) && (builder = (VpnService.Builder) kzVar2.j.get()) != null) {
                    builder.addAddress(this.d, this.f);
                }
                break;
            default:
                boolean z3 = this.b;
                kz kzVar3 = this.c;
                if ((!z3 || kzVar3.o) && (builder2 = (VpnService.Builder) kzVar3.j.get()) != null) {
                    builder2.addRoute(this.d, this.f);
                }
                break;
        }
        return Boolean.TRUE;
    }
}
