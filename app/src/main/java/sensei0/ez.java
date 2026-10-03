package sensei0;

import android.net.VpnService;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ez implements uo {
    public final /* synthetic */ int a;
    public final /* synthetic */ kz b;
    public final /* synthetic */ int c;

    public /* synthetic */ ez(kz kzVar, int i, int i2) {
        this.a = i2;
        this.b = kzVar;
        this.c = i;
    }

    @Override // sensei0.uo
    public final Object a() {
        switch (this.a) {
            case 0:
                return Boolean.valueOf(this.b.a.protect(this.c));
            default:
                VpnService.Builder builder = (VpnService.Builder) this.b.j.get();
                if (builder != null) {
                    builder.setMtu(this.c);
                }
                return Boolean.TRUE;
        }
    }
}
