package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends mm0 {
    public final AtomicReferenceFieldUpdater l;
    public final AtomicReferenceFieldUpdater m;
    public final AtomicReferenceFieldUpdater n;
    public final AtomicReferenceFieldUpdater o;
    public final AtomicReferenceFieldUpdater p;

    public t(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.l = atomicReferenceFieldUpdater;
        this.m = atomicReferenceFieldUpdater2;
        this.n = atomicReferenceFieldUpdater3;
        this.o = atomicReferenceFieldUpdater4;
        this.p = atomicReferenceFieldUpdater5;
    }

    @Override // sensei0.mm0
    public final void X(v vVar, v vVar2) {
        this.m.lazySet(vVar, vVar2);
    }

    @Override // sensei0.mm0
    public final void Y(v vVar, Thread thread) {
        this.l.lazySet(vVar, thread);
    }

    @Override // sensei0.mm0
    public final boolean g(w wVar, s sVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.o;
            if (atomicReferenceFieldUpdater.compareAndSet(wVar, sVar, s.b)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(wVar) == sVar);
        return false;
    }

    @Override // sensei0.mm0
    public final boolean h(w wVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.p;
            if (atomicReferenceFieldUpdater.compareAndSet(wVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(wVar) == obj);
        return false;
    }

    @Override // sensei0.mm0
    public final boolean i(w wVar, v vVar, v vVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.n;
            if (atomicReferenceFieldUpdater.compareAndSet(wVar, vVar, vVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(wVar) == vVar);
        return false;
    }
}
