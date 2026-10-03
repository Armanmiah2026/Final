package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class da extends ls implements ca {
    public final Object T(bd0 bd0Var) {
        Object objD;
        do {
            objD = D();
            if (!(objD instanceof wq)) {
                if (objD instanceof ga) {
                    throw ((ga) objD).a;
                }
                return xe.O(objD);
            }
        } while (Q(objD) < 0);
        hs hsVar = new hs(pr.D(bd0Var), this);
        hsVar.u();
        hsVar.w(new og(mm0.G(this, false, new vr(1, hsVar), 3)));
        return hsVar.t();
    }
}
