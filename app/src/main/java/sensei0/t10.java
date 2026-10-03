package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t10 extends s10 {
    public final Object d;

    public t10() {
        super(12);
        this.d = new Object();
    }

    @Override // sensei0.s10
    public final Object a() {
        Object objA;
        synchronized (this.d) {
            objA = super.a();
        }
        return objA;
    }

    @Override // sensei0.s10
    public final boolean c(Object obj) {
        boolean zC;
        synchronized (this.d) {
            zC = super.c(obj);
        }
        return zC;
    }
}
