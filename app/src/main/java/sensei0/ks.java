package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ks extends d5 {
    public final gs b;
    public sy c;
    public final /* synthetic */ ls d;
    public final /* synthetic */ wq e;

    public ks(gs gsVar, ls lsVar, wq wqVar) {
        this.d = lsVar;
        this.e = wqVar;
        this.b = gsVar;
    }

    @Override // sensei0.d5
    public final void b(Object obj, Object obj2) {
        xu xuVar = (xu) obj;
        boolean z = obj2 == null;
        gs gsVar = this.b;
        wq wqVar = z ? gsVar : this.c;
        if (wqVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = xu.a;
            while (!atomicReferenceFieldUpdater.compareAndSet(xuVar, this, wqVar)) {
                if (atomicReferenceFieldUpdater.get(xuVar) != this) {
                    return;
                }
            }
            if (z) {
                sy syVar = this.c;
                pr.f(syVar);
                gsVar.g(syVar);
            }
        }
    }

    @Override // sensei0.d5
    public final tn c(Object obj) {
        if (this.d.D() == this.e) {
            return null;
        }
        return pr.d;
    }
}
