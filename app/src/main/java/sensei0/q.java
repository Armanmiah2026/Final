package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final q b;
    public static final q c;
    public final Throwable a;

    static {
        if (w.d) {
            c = null;
            b = null;
        } else {
            c = new q(null, false);
            b = new q(null, true);
        }
    }

    public q(Throwable th, boolean z) {
        this.a = th;
    }
}
