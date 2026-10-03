package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class yu {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(yu.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new av(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            av avVar = (av) atomicReferenceFieldUpdater.get(this);
            int iA = avVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                av avVarC = avVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, avVar, avVarC) && atomicReferenceFieldUpdater.get(this) == avVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            av avVar = (av) atomicReferenceFieldUpdater.get(this);
            if (avVar.b()) {
                return;
            }
            av avVarC = avVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, avVar, avVarC) && atomicReferenceFieldUpdater.get(this) == avVar) {
            }
        }
    }

    public final int c() {
        av avVar = (av) a.get(this);
        avVar.getClass();
        long j = av.f.get(avVar);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            av avVar = (av) atomicReferenceFieldUpdater.get(this);
            Object objD = avVar.d();
            if (objD != av.g) {
                return objD;
            }
            av avVarC = avVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, avVar, avVarC) && atomicReferenceFieldUpdater.get(this) == avVar) {
            }
        }
    }
}
