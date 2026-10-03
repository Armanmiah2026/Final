package sensei0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r20 extends g implements s20, x7 {
    public final o6 d;

    public r20(lc lcVar, o6 o6Var) {
        super(lcVar, true);
        this.d = o6Var;
    }

    @Override // sensei0.g
    public final void T(Throwable th, boolean z) {
        if (this.d.f(th, false) || z) {
            return;
        }
        wf0.o(th, this.c);
    }

    @Override // sensei0.g
    public final void U(Object obj) {
        this.d.f(null, false);
    }

    public final void W(se seVar) {
        o6 o6Var = this.d;
        o6Var.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o6.r;
        while (!atomicReferenceFieldUpdater.compareAndSet(o6Var, null, seVar)) {
            if (atomicReferenceFieldUpdater.get(o6Var) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(o6Var);
                    tn tnVar = q6.q;
                    if (obj != tnVar) {
                        if (obj == q6.r) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    tn tnVar2 = q6.r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(o6Var, tnVar, tnVar2)) {
                        if (atomicReferenceFieldUpdater.get(o6Var) != tnVar) {
                            break;
                        }
                    }
                    seVar.g(o6Var.m());
                    return;
                }
            }
        }
    }

    @Override // sensei0.ls, sensei0.bs
    public final void b(CancellationException cancellationException) {
        Object objD = D();
        if (objD instanceof ga) {
            return;
        }
        if ((objD instanceof js) && ((js) objD).d()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new cs(u(), null, this);
        }
        s(cancellationException);
    }

    @Override // sensei0.j70
    public final Object i(Object obj, yb ybVar) {
        return this.d.i(obj, ybVar);
    }

    @Override // sensei0.j70
    public final Object k(Object obj) {
        return this.d.k(obj);
    }

    @Override // sensei0.ls
    public final void s(CancellationException cancellationException) {
        this.d.f(cancellationException, true);
        r(cancellationException);
    }
}
