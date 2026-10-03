package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gs extends xu implements or, ng, wq {
    public ls d;

    @Override // sensei0.wq
    public final boolean a() {
        return true;
    }

    @Override // sensei0.ng
    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ls lsVarK = k();
        while (true) {
            Object objD = lsVarK.D();
            if (objD instanceof gs) {
                if (objD != this) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = ls.a;
                mi miVar = xe.m;
                while (!atomicReferenceFieldUpdater2.compareAndSet(lsVarK, objD, miVar)) {
                    if (atomicReferenceFieldUpdater2.get(lsVarK) != objD) {
                        break;
                    }
                }
                return;
            }
            if (!(objD instanceof wq) || ((wq) objD).e() == null) {
                return;
            }
            while (true) {
                Object objH = h();
                if (objH instanceof e50) {
                    return;
                }
                if (objH == this) {
                    return;
                }
                pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", objH);
                xu xuVar = (xu) objH;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = xu.c;
                e50 e50Var = (e50) atomicReferenceFieldUpdater3.get(xuVar);
                if (e50Var == null) {
                    e50Var = new e50(xuVar);
                    atomicReferenceFieldUpdater3.set(xuVar, e50Var);
                }
                do {
                    atomicReferenceFieldUpdater = xu.a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, objH, e50Var)) {
                        xuVar.f();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == objH);
            }
        }
    }

    @Override // sensei0.wq
    public final sy e() {
        return null;
    }

    public bs getParent() {
        return k();
    }

    public final ls k() {
        ls lsVar = this.d;
        if (lsVar != null) {
            return lsVar;
        }
        pr.V("job");
        throw null;
    }

    @Override // sensei0.xu
    public final String toString() {
        return getClass().getSimpleName() + '@' + xe.o(this) + "[job@" + xe.o(k()) + ']';
    }
}
