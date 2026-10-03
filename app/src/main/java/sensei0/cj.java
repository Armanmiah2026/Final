package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cj extends dj implements rf {
    public static final /* synthetic */ AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(cj.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(cj.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater q = AtomicIntegerFieldUpdater.newUpdater(cj.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        m(runnable);
    }

    @Override // sensei0.dj
    public final long k() {
        Runnable runnable;
        if (!l()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                runnable = null;
                if (obj == null) {
                    break;
                }
                if (!(obj instanceof av)) {
                    if (obj != k6.c) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        runnable = (Runnable) obj;
                        break loop0;
                    }
                    break;
                }
                av avVar = (av) obj;
                Object objD = avVar.d();
                if (objD != av.g) {
                    runnable = (Runnable) objD;
                    break;
                }
                av avVarC = avVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, avVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            r4 r4Var = this.f;
            if (((r4Var == null || r4Var.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object obj2 = o.get(this);
                if (obj2 == null) {
                } else if (obj2 instanceof av) {
                    long j = av.f.get((av) obj2);
                    if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                        return 0L;
                    }
                } else if (obj2 == k6.c) {
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        sensei0.af.r.m(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(java.lang.Runnable r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sensei0.cj.o
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = sensei0.cj.q
            int r2 = r2.get(r5)
            if (r2 == 0) goto Lf
            goto L4a
        Lf:
            if (r1 != 0) goto L20
        L11:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L19
            goto L66
        L19:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L11
            goto L0
        L20:
            boolean r2 = r1 instanceof sensei0.av
            r3 = 1
            if (r2 == 0) goto L46
            r2 = r1
            sensei0.av r2 = (sensei0.av) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L66
            if (r4 == r3) goto L34
            r0 = 2
            if (r4 == r0) goto L4a
            goto L0
        L34:
            sensei0.av r2 = r2.c()
        L38:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L3f
            goto L0
        L3f:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L38
            goto L0
        L46:
            sensei0.tn r2 = sensei0.k6.c
            if (r1 != r2) goto L50
        L4a:
            sensei0.af r0 = sensei0.af.r
            r0.m(r6)
            return
        L50:
            sensei0.av r2 = new sensei0.av
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L60:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L74
        L66:
            java.lang.Thread r6 = r5.h()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L73
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L73:
            return
        L74:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L60
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.cj.m(java.lang.Runnable):void");
    }

    public final boolean o() {
        r4 r4Var = this.f;
        if (r4Var != null ? r4Var.isEmpty() : true) {
            Object obj = o.get(this);
            if (obj != null) {
                if (obj instanceof av) {
                    long j = av.f.get((av) obj);
                    return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
                }
                if (obj == k6.c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // sensei0.dj
    public void shutdown() {
        ie0.a.set(null);
        q.set(this, 1);
        tn tnVar = k6.c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof av)) {
                    if (obj != tnVar) {
                        av avVar = new av(8, true);
                        avVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, avVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((av) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, tnVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (k() <= 0) {
        }
        System.nanoTime();
    }
}
