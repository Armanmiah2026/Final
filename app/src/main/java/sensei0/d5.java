package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d5 extends bz {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(d5.class, Object.class, "_consensus$volatile");
    private volatile /* synthetic */ Object _consensus$volatile = k6.a;

    @Override // sensei0.bz
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        tn tnVar = k6.a;
        if (obj2 == tnVar) {
            tn tnVarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == tnVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, tnVar, tnVarC)) {
                        obj2 = tnVarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != tnVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract tn c(Object obj);
}
