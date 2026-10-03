package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vb implements uc {
    public final lc a;

    public vb(lc lcVar) {
        this.a = lcVar;
    }

    @Override // sensei0.uc
    public final lc g() {
        return this.a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.a + ')';
    }
}
