package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n6 implements kj0 {
    public Object a = q6.p;
    public f7 b;
    public final /* synthetic */ o6 c;

    public n6(o6 o6Var) {
        this.c = o6Var;
    }

    @Override // sensei0.kj0
    public final void a(d70 d70Var, int i) {
        f7 f7Var = this.b;
        if (f7Var != null) {
            f7Var.a(d70Var, i);
        }
    }

    public final Object b(jl jlVar) throws Throwable {
        d8 d8VarL;
        d8 d8VarL2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o6.o;
        o6 o6Var = this.c;
        d8 d8Var = (d8) atomicReferenceFieldUpdater.get(o6Var);
        while (!o6Var.r(o6.b.get(o6Var), true)) {
            long andIncrement = o6.c.getAndIncrement(o6Var);
            long j = q6.b;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (d8Var.c != j2) {
                d8VarL = o6Var.l(j2, d8Var);
                if (d8VarL == null) {
                    continue;
                }
            } else {
                d8VarL = d8Var;
            }
            Object objA = o6Var.A(d8VarL, i, andIncrement, null);
            tn tnVar = q6.m;
            if (objA == tnVar) {
                throw new IllegalStateException("unreachable");
            }
            tn tnVar2 = q6.o;
            if (objA == tnVar2) {
                if (andIncrement < o6Var.p()) {
                    d8VarL.a();
                }
                d8Var = d8VarL;
            } else {
                if (objA != q6.n) {
                    d8VarL.a();
                    this.a = objA;
                    return Boolean.TRUE;
                }
                f7 f7VarZ = pr.z(pr.D(jlVar));
                try {
                    this.b = f7VarZ;
                    try {
                        Object objA2 = o6Var.A(d8VarL, i, andIncrement, this);
                        if (objA2 == tnVar) {
                            a(d8VarL, i);
                        } else {
                            if (objA2 == tnVar2) {
                                if (andIncrement < o6Var.p()) {
                                    d8VarL.a();
                                }
                                d8 d8Var2 = (d8) o6.o.get(o6Var);
                                while (true) {
                                    if (o6Var.r(o6.b.get(o6Var), true)) {
                                        f7 f7Var = this.b;
                                        pr.f(f7Var);
                                        this.b = null;
                                        this.a = q6.l;
                                        Throwable thM = o6Var.m();
                                        if (thM == null) {
                                            f7Var.h(Boolean.FALSE);
                                        } else {
                                            f7Var.h(wf0.i(thM));
                                        }
                                    } else {
                                        long andIncrement2 = o6.c.getAndIncrement(o6Var);
                                        long j3 = q6.b;
                                        long j4 = andIncrement2 / j3;
                                        int i2 = (int) (andIncrement2 % j3);
                                        if (d8Var2.c != j4) {
                                            d8VarL2 = o6Var.l(j4, d8Var2);
                                            if (d8VarL2 == null) {
                                            }
                                        } else {
                                            d8VarL2 = d8Var2;
                                        }
                                        Object objA3 = o6Var.A(d8VarL2, i2, andIncrement2, this);
                                        if (objA3 == q6.m) {
                                            a(d8VarL2, i2);
                                            break;
                                        }
                                        if (objA3 == q6.o) {
                                            if (andIncrement2 < o6Var.p()) {
                                                d8VarL2.a();
                                            }
                                            d8Var2 = d8VarL2;
                                        } else {
                                            if (objA3 == q6.n) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            d8VarL2.a();
                                            this.a = objA3;
                                            this.b = null;
                                        }
                                    }
                                }
                            } else {
                                d8VarL.a();
                                this.a = objA2;
                                this.b = null;
                            }
                            f7VarZ.B(Boolean.TRUE, null);
                        }
                        return f7VarZ.t();
                    } catch (Throwable th) {
                        th = th;
                        f7VarZ.A();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        this.a = q6.l;
        Throwable thM2 = o6Var.m();
        if (thM2 == null) {
            return Boolean.FALSE;
        }
        int i3 = jb0.a;
        throw thM2;
    }
}
