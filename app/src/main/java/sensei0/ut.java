package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ut {
    public mt a;
    public rt b;

    public final void a(tt ttVar, lt ltVar) {
        mt mtVarA = ltVar.a();
        mt mtVar = this.a;
        pr.j("state1", mtVar);
        if (mtVarA.compareTo(mtVar) < 0) {
            mtVar = mtVarA;
        }
        this.a = mtVar;
        this.b.f(ttVar, ltVar);
        this.a = mtVarA;
    }
}
