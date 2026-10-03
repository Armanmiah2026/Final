package sensei0;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v9 implements u70 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ v9(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Iterable, java.lang.Object] */
    @Override // sensei0.u70
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return this.b.iterator();
            case 1:
                return new dq(this);
            case 2:
                return new gu(this);
            case 3:
                return (Iterator) this.b;
            default:
                return new fu((CharSequence) this.b);
        }
    }

    public v9(dz dzVar) {
        this.a = 1;
        a50 a50Var = a50.p;
        this.b = dzVar;
    }
}
