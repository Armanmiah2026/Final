package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hs extends f7 {
    public final da q;

    public hs(xb xbVar, da daVar) {
        super(1, xbVar);
        this.q = daVar;
    }

    @Override // sensei0.f7
    public final Throwable s(ls lsVar) {
        Throwable thC;
        Object objD = this.q.D();
        return (!(objD instanceof js) || (thC = ((js) objD).c()) == null) ? objD instanceof ga ? ((ga) objD).a : lsVar.z() : thC;
    }

    @Override // sensei0.f7
    public final String z() {
        return "AwaitContinuation";
    }
}
