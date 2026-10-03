package sensei0;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gi {
    public int a = 1;
    public final sx b;
    public sx c;
    public sx d;
    public int e;
    public int f;

    public gi(sx sxVar) {
        this.b = sxVar;
        this.c = sxVar;
    }

    public final void a() {
        this.a = 1;
        this.c = this.b;
        this.f = 0;
    }

    public final boolean b() {
        qx qxVarB = this.c.b.b();
        int iA = qxVarB.a(6);
        return !(iA == 0 || ((ByteBuffer) qxVarB.d).get(iA + qxVarB.a) == 0) || this.e == 65039;
    }
}
