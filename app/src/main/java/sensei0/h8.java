package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class h8 extends ds {
    public final f7 e;

    public h8(f7 f7Var) {
        this.e = f7Var;
    }

    @Override // sensei0.or
    public final void d(Throwable th) {
        ls lsVarK = k();
        f7 f7Var = this.e;
        Throwable thS = f7Var.s(lsVarK);
        if (f7Var.x()) {
            xb xbVar = f7Var.d;
            pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", xbVar);
            hg hgVar = (hg) xbVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = hg.p;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hgVar);
                tn tnVar = pr.c;
                if (!pr.b(obj, tnVar)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hgVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hgVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hgVar, tnVar, thS)) {
                    if (atomicReferenceFieldUpdater.get(hgVar) != tnVar) {
                        break;
                    }
                }
                return;
            }
        }
        f7Var.p(thS);
        if (f7Var.x()) {
            return;
        }
        f7Var.q();
    }
}
