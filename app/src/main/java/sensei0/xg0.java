package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xg0 implements jc {
    public final xg0 a;
    public final ve b;

    public xg0(xg0 xg0Var, ve veVar) {
        this.a = xg0Var;
        this.b = veVar;
    }

    @Override // sensei0.lc
    public final lc c(kc kcVar) {
        return k6.J(this, kcVar);
    }

    @Override // sensei0.lc
    public final Object d(Object obj, jp jpVar) {
        return jpVar.c(obj, this);
    }

    public final void e(ve veVar) {
        if (this.b == veVar) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        xg0 xg0Var = this.a;
        if (xg0Var != null) {
            xg0Var.e(veVar);
        }
    }

    @Override // sensei0.jc
    public final kc getKey() {
        return mh.u;
    }

    @Override // sensei0.lc
    public final lc j(lc lcVar) {
        pr.j("context", lcVar);
        return lcVar == oi.a ? this : (lc) lcVar.d(this, new y9(1));
    }

    @Override // sensei0.lc
    public final jc n(kc kcVar) {
        return k6.s(this, kcVar);
    }
}
