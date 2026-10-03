package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xt extends pc implements rf {
    public static final /* synthetic */ AtomicIntegerFieldUpdater o = AtomicIntegerFieldUpdater.newUpdater(xt.class, "runningWorkers$volatile");
    public final pc c;
    public final int d;
    public final yu f;
    public final Object h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public xt(pc pcVar, int i) {
        this.c = pcVar;
        this.d = i;
        if ((pcVar instanceof rf ? (rf) pcVar : null) == null) {
            int i2 = bf.a;
        }
        this.f = new yu();
        this.h = new Object();
    }

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        this.f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
        if (atomicIntegerFieldUpdater.get(this) < this.d) {
            synchronized (this.h) {
                if (atomicIntegerFieldUpdater.get(this) >= this.d) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableG = g();
                if (runnableG == null) {
                    return;
                }
                this.c.e(this, new e2(4, this, runnableG));
            }
        }
    }

    public final Runnable g() {
        while (true) {
            Runnable runnable = (Runnable) this.f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.h) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
