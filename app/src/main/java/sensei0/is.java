package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class is extends gs {
    public final ls e;
    public final js f;
    public final j8 g;
    public final Object h;

    public is(ls lsVar, js jsVar, j8 j8Var, Object obj) {
        this.e = lsVar;
        this.f = jsVar;
        this.g = j8Var;
        this.h = obj;
    }

    @Override // sensei0.or
    public final void d(Throwable th) {
        j8 j8VarL = ls.L(this.g);
        ls lsVar = this.e;
        js jsVar = this.f;
        Object obj = this.h;
        if (j8VarL != null) {
            while (mm0.G(j8VarL.e, false, new is(lsVar, jsVar, j8VarL, obj), 1) == ty.a) {
                j8VarL = ls.L(j8VarL);
                if (j8VarL == null) {
                }
            }
            return;
        }
        lsVar.p(lsVar.y(jsVar, obj));
    }
}
