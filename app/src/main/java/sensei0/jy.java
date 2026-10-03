package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jy implements e7, kj0 {
    public final f7 a;
    public final /* synthetic */ ky b;

    public jy(ky kyVar, f7 f7Var) {
        this.b = kyVar;
        this.a = f7Var;
    }

    @Override // sensei0.kj0
    public final void a(d70 d70Var, int i) {
        this.a.a(d70Var, i);
    }

    @Override // sensei0.xb
    public final lc f() {
        return this.a.f;
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        this.a.h(obj);
    }

    @Override // sensei0.e7
    public final tn l(Object obj, fp fpVar) {
        ky kyVar = this.b;
        iy iyVar = new iy(kyVar, this, 1);
        tn tnVarL = this.a.l((mg0) obj, iyVar);
        if (tnVarL != null) {
            ky.g.set(kyVar, null);
        }
        return tnVarL;
    }

    @Override // sensei0.e7
    public final void m(Object obj) {
        this.a.m(obj);
    }
}
