package sensei0;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tc implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater p = AtomicLongFieldUpdater.newUpdater(tc.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater q = AtomicLongFieldUpdater.newUpdater(tc.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater r = AtomicIntegerFieldUpdater.newUpdater(tc.class, "_isTerminated$volatile");
    public static final tn s = new tn("NOT_IN_STACK", 4);
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int a;
    public final int b;
    public final long c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;
    public final eq f;
    public final eq h;
    public final m50 o;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public tc(int i, int i2, long j, String str) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
        if (i < 1) {
            throw new IllegalArgumentException(za0.i(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(za0.j("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(za0.i(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f = new eq();
        this.h = new eq();
        this.o = new m50((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    public final int a() {
        synchronized (this.o) {
            try {
                if (r.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = q;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.a) {
                    return 0;
                }
                if (i >= this.b) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.o.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                rc rcVar = new rc(this, i3);
                this.o.c(i3, rcVar);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                rcVar.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, xs xsVar) {
        gd0 hd0Var;
        sc scVar;
        id0.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof gd0) {
            hd0Var = (gd0) runnable;
            hd0Var.a = jNanoTime;
            hd0Var.b = xsVar;
        } else {
            hd0Var = new hd0(runnable, jNanoTime, xsVar);
        }
        boolean z = hd0Var.b.a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = q;
        long jAddAndGet = z ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        rc rcVar = threadCurrentThread instanceof rc ? (rc) threadCurrentThread : null;
        if (rcVar == null || !pr.b(rcVar.p, this)) {
            rcVar = null;
        }
        if (rcVar != null && (scVar = rcVar.c) != sc.f && (hd0Var.b.a != 0 || scVar != sc.b)) {
            rcVar.o = true;
            im0 im0Var = rcVar.a;
            im0Var.getClass();
            hd0Var = (gd0) im0.b.getAndSet(im0Var, hd0Var);
            if (hd0Var == null) {
                hd0Var = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = im0Var.a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = im0.c;
                if (atomicIntegerFieldUpdater.get(im0Var) - im0.d.get(im0Var) != 127) {
                    if (hd0Var.b.a == 1) {
                        im0.e.incrementAndGet(im0Var);
                    }
                    int i = atomicIntegerFieldUpdater.get(im0Var) & 127;
                    while (atomicReferenceArray.get(i) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i, hd0Var);
                    atomicIntegerFieldUpdater.incrementAndGet(im0Var);
                    hd0Var = null;
                }
            }
        }
        if (hd0Var != null) {
            if (!(hd0Var.b.a == 1 ? this.h.a(hd0Var) : this.f.a(hd0Var))) {
                throw new RejectedExecutionException(za0.o(new StringBuilder(), this.d, " was terminated"));
            }
        }
        if (z) {
            if (e() || d(jAddAndGet)) {
                return;
            }
            e();
            return;
        }
        if (e() || d(atomicLongFieldUpdater.get(this))) {
            return;
        }
        e();
    }

    public final void c(rc rcVar, int i, int i2) {
        while (true) {
            long j = p.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object objC = rcVar.c();
                    while (true) {
                        if (objC == s) {
                            i3 = -1;
                            break;
                        }
                        if (objC == null) {
                            i3 = 0;
                            break;
                        }
                        rc rcVar2 = (rc) objC;
                        int iB = rcVar2.b();
                        if (iB != 0) {
                            i3 = iB;
                            break;
                        }
                        objC = rcVar2.c();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                if (p.compareAndSet(this, j, ((long) i3) | j2)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = sensei0.tc.r
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof sensei0.rc
            r3 = 0
            if (r1 == 0) goto L17
            sensei0.rc r0 = (sensei0.rc) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            sensei0.tc r1 = r0.p
            boolean r1 = sensei0.pr.b(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            sensei0.m50 r1 = r8.o
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = sensei0.tc.q     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            sensei0.m50 r5 = r8.o
            java.lang.Object r5 = r5.b(r1)
            sensei0.pr.f(r5)
            sensei0.rc r5 = (sensei0.rc) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            sensei0.im0 r5 = r5.a
            sensei0.eq r6 = r8.h
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = sensei0.im0.b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            sensei0.gd0 r7 = (sensei0.gd0) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            sensei0.gd0 r7 = r5.a()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            sensei0.eq r1 = r8.h
            r1.b()
            sensei0.eq r1 = r8.f
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            sensei0.gd0 r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            sensei0.eq r1 = r8.f
            java.lang.Object r1 = r1.d()
            sensei0.gd0 r1 = (sensei0.gd0) r1
            if (r1 != 0) goto Lb2
            sensei0.eq r1 = r8.h
            java.lang.Object r1 = r1.d()
            sensei0.gd0 r1 = (sensei0.gd0) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            sensei0.sc r1 = sensei0.sc.f
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = sensei0.tc.p
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = sensei0.tc.q
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.tc.close():void");
    }

    public final boolean d(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.a;
        if (i < i2) {
            int iA = a();
            if (iA == 1 && i2 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        tn tnVar;
        int iB;
        while (true) {
            long j = p.get(this);
            rc rcVar = (rc) this.o.b((int) (2097151 & j));
            if (rcVar == null) {
                rcVar = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objC = rcVar.c();
                while (true) {
                    tnVar = s;
                    if (objC == tnVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    rc rcVar2 = (rc) objC;
                    iB = rcVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = rcVar2.c();
                }
                if (iB >= 0) {
                    if (p.compareAndSet(this, j, ((long) iB) | j2)) {
                        rcVar.g(tnVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (rcVar == null) {
                return false;
            }
            if (rc.q.compareAndSet(rcVar, -1, 0)) {
                LockSupport.unpark(rcVar);
                return true;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, id0.g);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        m50 m50Var = this.o;
        int iA = m50Var.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            rc rcVar = (rc) m50Var.b(i6);
            if (rcVar != null) {
                im0 im0Var = rcVar.a;
                im0Var.getClass();
                int i7 = im0.b.get(im0Var) != null ? (im0.c.get(im0Var) - im0.d.get(im0Var)) + 1 : im0.c.get(im0Var) - im0.d.get(im0Var);
                int iOrdinal = rcVar.c.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iOrdinal == 4) {
                    i5++;
                }
            }
        }
        long j = q.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.d);
        sb4.append('@');
        sb4.append(xe.o(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.a;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.h.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
