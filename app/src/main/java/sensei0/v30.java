package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v30 extends vb0 {
    public final Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v30(Throwable th, int i) {
        super(i);
        pr.j("readException", th);
        this.b = th;
    }
}
