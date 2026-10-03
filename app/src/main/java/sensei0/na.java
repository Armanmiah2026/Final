package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class na {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(na.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(na.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public na(d70 d70Var) {
        this._prev$volatile = d70Var;
    }

    public final void a() {
        b.set(this, null);
    }

    public final na b() {
        Object obj = a.get(this);
        if (obj == k6.b) {
            return null;
        }
        return (na) obj;
    }

    public abstract boolean c();

    public final void d() {
        na naVarB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            na naVar = (na) atomicReferenceFieldUpdater.get(this);
            while (naVar != null && naVar.c()) {
                naVar = (na) atomicReferenceFieldUpdater.get(naVar);
            }
            na naVarB2 = b();
            pr.f(naVarB2);
            while (naVarB2.c() && (naVarB = naVarB2.b()) != null) {
                naVarB2 = naVarB;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(naVarB2);
                na naVar2 = ((na) obj) == null ? null : naVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(naVarB2, obj, naVar2)) {
                    if (atomicReferenceFieldUpdater.get(naVarB2) != obj) {
                        break;
                    }
                }
            }
            if (naVar != null) {
                a.set(naVar, naVarB2);
            }
            if (!naVarB2.c() || naVarB2.b() == null) {
                if (naVar == null || !naVar.c()) {
                    return;
                }
            }
        }
    }
}
