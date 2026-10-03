package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jg0 extends x60 {
    public final ThreadLocal f;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public jg0(yb ybVar, lc lcVar) {
        kg0 kg0Var = kg0.a;
        super(ybVar, lcVar.n(kg0Var) == null ? lcVar.j(kg0Var) : lcVar);
        this.f = new ThreadLocal();
        if (ybVar.f().n(mh.c) instanceof pc) {
            return;
        }
        Object objP = xe.P(lcVar, null);
        xe.C(lcVar, objP);
        X(lcVar, objP);
    }

    public final boolean W() {
        boolean z = this.threadLocalIsSet && this.f.get() == null;
        this.f.remove();
        return !z;
    }

    public final void X(lc lcVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f.set(new qz(lcVar, obj));
    }

    @Override // sensei0.x60, sensei0.ls
    public final void q(Object obj) {
        if (this.threadLocalIsSet) {
            qz qzVar = (qz) this.f.get();
            if (qzVar != null) {
                xe.C((lc) qzVar.a, qzVar.b);
            }
            this.f.remove();
        }
        Object objB = xe.B(obj);
        yb ybVar = this.d;
        lc lcVarF = ybVar.f();
        Object objP = xe.P(lcVarF, null);
        jg0 jg0VarQ = objP != xe.v ? xe.Q(ybVar, lcVarF, objP) : null;
        try {
            this.d.h(objB);
            if (jg0VarQ == null || jg0VarQ.W()) {
                xe.C(lcVarF, objP);
            }
        } catch (Throwable th) {
            if (jg0VarQ == null || jg0VarQ.W()) {
                xe.C(lcVarF, objP);
            }
            throw th;
        }
    }
}
