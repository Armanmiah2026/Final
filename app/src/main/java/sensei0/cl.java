package sensei0;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cl implements u70 {
    public final /* synthetic */ int a;
    public final u70 b;
    public final fp c;

    public /* synthetic */ cl(u70 u70Var, fp fpVar, int i) {
        this.a = i;
        this.b = u70Var;
        this.c = fpVar;
    }

    @Override // sensei0.u70
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new pg(this);
            case 1:
                return new pg(this, (byte) 0);
            default:
                return new ef0(this);
        }
    }

    public cl(cl clVar, fp fpVar) {
        this.a = 1;
        y70 y70Var = y70.p;
        this.b = clVar;
        this.c = fpVar;
    }
}
