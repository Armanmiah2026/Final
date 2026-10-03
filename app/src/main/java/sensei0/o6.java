package sensei0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class o6 implements x7 {
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(o6.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(o6.class, "receivers$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(o6.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(o6.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(o6.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(o6.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(o6.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(o6.class, Object.class, "_closeCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater r = AtomicReferenceFieldUpdater.newUpdater(o6.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    public final int a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public o6(int i) {
        this.a = i;
        if (i < 0) {
            throw new IllegalArgumentException(za0.i(i, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        d8 d8Var = q6.a;
        this.bufferEnd$volatile = i != 0 ? i != Integer.MAX_VALUE ? i : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = d.get(this);
        d8 d8Var2 = new d8(0L, null, this, 3);
        this.sendSegment$volatile = d8Var2;
        this.receiveSegment$volatile = d8Var2;
        if (u()) {
            d8Var2 = q6.a;
            pr.g("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>", d8Var2);
        }
        this.bufferEndSegment$volatile = d8Var2;
        this._closeCause$volatile = q6.s;
    }

    public static final d8 a(o6 o6Var, long j, d8 d8Var) {
        Object objQ;
        o6 o6Var2;
        d8 d8Var2 = q6.a;
        p6 p6Var = p6.p;
        loop0: while (true) {
            objQ = k6.q(d8Var, j, p6Var);
            if (!k6.E(objQ)) {
                d70 d70VarB = k6.B(objQ);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                    d70 d70Var = (d70) atomicReferenceFieldUpdater.get(o6Var);
                    if (d70Var.c >= d70VarB.c) {
                        break loop0;
                    }
                    if (!d70VarB.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(o6Var, d70Var, d70VarB)) {
                        if (atomicReferenceFieldUpdater.get(o6Var) != d70Var) {
                            if (d70VarB.e()) {
                                d70VarB.d();
                            }
                        }
                    }
                    if (d70Var.e()) {
                        d70Var.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zE = k6.E(objQ);
        AtomicLongFieldUpdater atomicLongFieldUpdater = c;
        if (zE) {
            o6Var.s();
            if (d8Var.c * ((long) q6.b) < atomicLongFieldUpdater.get(o6Var)) {
                d8Var.a();
                return null;
            }
        } else {
            d8 d8Var3 = (d8) k6.B(objQ);
            long j2 = d8Var3.c;
            if (j2 <= j) {
                return d8Var3;
            }
            long j3 = ((long) q6.b) * j2;
            while (true) {
                long j4 = b.get(o6Var);
                long j5 = 1152921504606846975L & j4;
                if (j5 >= j3) {
                    o6Var2 = o6Var;
                    break;
                }
                o6Var2 = o6Var;
                if (b.compareAndSet(o6Var2, j4, (((long) ((int) (j4 >> 60))) << 60) + j5)) {
                    break;
                }
                o6Var = o6Var2;
            }
            if (j2 * ((long) q6.b) < atomicLongFieldUpdater.get(o6Var2)) {
                d8Var3.a();
            }
        }
        return null;
    }

    public static final void c(o6 o6Var, Object obj, f7 f7Var) {
        f7Var.h(wf0.i(o6Var.o()));
    }

    public static final int d(o6 o6Var, d8 d8Var, int i, Object obj, long j, Object obj2, boolean z) {
        d8Var.m(i, obj);
        if (z) {
            return o6Var.B(d8Var, i, obj, j, obj2, z);
        }
        Object objK = d8Var.k(i);
        if (objK == null) {
            if (o6Var.e(j)) {
                if (d8Var.j(i, null, q6.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (d8Var.j(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof kj0) {
            d8Var.m(i, null);
            if (o6Var.y(objK, obj)) {
                d8Var.n(i, q6.i);
                return 0;
            }
            tn tnVar = q6.k;
            if (d8Var.f.getAndSet((i * 2) + 1, tnVar) == tnVar) {
                return 5;
            }
            d8Var.l(i, true);
            return 5;
        }
        return o6Var.B(d8Var, i, obj, j, obj2, z);
    }

    public static void q(o6 o6Var) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        if ((atomicLongFieldUpdater.addAndGet(o6Var, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(o6Var) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static boolean z(Object obj) {
        if (!(obj instanceof e7)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        e7 e7Var = (e7) obj;
        d8 d8Var = q6.a;
        tn tnVarL = e7Var.l(mg0.a, null);
        if (tnVarL == null) {
            return false;
        }
        e7Var.m(tnVarL);
        return true;
    }

    public final Object A(d8 d8Var, int i, long j, Object obj) {
        AtomicReferenceArray atomicReferenceArray = d8Var.f;
        Object objK = d8Var.k(i);
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (objK == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return q6.n;
                }
                if (d8Var.j(i, objK, obj)) {
                    j();
                    return q6.m;
                }
            }
        } else if (objK == q6.d && d8Var.j(i, objK, q6.i)) {
            j();
            Object obj2 = atomicReferenceArray.get(i * 2);
            d8Var.m(i, null);
            return obj2;
        }
        while (true) {
            Object objK2 = d8Var.k(i);
            if (objK2 == null || objK2 == q6.e) {
                if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (d8Var.j(i, objK2, q6.h)) {
                        j();
                        return q6.o;
                    }
                } else {
                    if (obj == null) {
                        return q6.n;
                    }
                    if (d8Var.j(i, objK2, obj)) {
                        j();
                        return q6.m;
                    }
                }
            } else if (objK2 != q6.d) {
                tn tnVar = q6.j;
                if (objK2 == tnVar) {
                    return q6.o;
                }
                if (objK2 == q6.h) {
                    return q6.o;
                }
                if (objK2 == q6.l) {
                    j();
                    return q6.o;
                }
                if (objK2 != q6.g && d8Var.j(i, objK2, q6.f)) {
                    boolean z = objK2 instanceof lj0;
                    if (z) {
                        objK2 = ((lj0) objK2).a;
                    }
                    if (z(objK2)) {
                        d8Var.n(i, q6.i);
                        j();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        d8Var.m(i, null);
                        return obj3;
                    }
                    d8Var.n(i, tnVar);
                    d8Var.h();
                    if (z) {
                        j();
                    }
                    return q6.o;
                }
            } else if (d8Var.j(i, objK2, q6.i)) {
                j();
                Object obj4 = atomicReferenceArray.get(i * 2);
                d8Var.m(i, null);
                return obj4;
            }
        }
    }

    public final int B(d8 d8Var, int i, Object obj, long j, Object obj2, boolean z) {
        while (true) {
            Object objK = d8Var.k(i);
            if (objK == null) {
                if (!e(j) || z) {
                    if (z) {
                        if (d8Var.j(i, null, q6.j)) {
                            d8Var.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (d8Var.j(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (d8Var.j(i, null, q6.d)) {
                    break;
                }
            } else {
                if (objK != q6.e) {
                    tn tnVar = q6.k;
                    if (objK == tnVar) {
                        d8Var.m(i, null);
                        return 5;
                    }
                    if (objK == q6.h) {
                        d8Var.m(i, null);
                        return 5;
                    }
                    if (objK == q6.l) {
                        d8Var.m(i, null);
                        s();
                        return 4;
                    }
                    d8Var.m(i, null);
                    if (objK instanceof lj0) {
                        objK = ((lj0) objK).a;
                    }
                    if (y(objK, obj)) {
                        d8Var.n(i, q6.i);
                        return 0;
                    }
                    if (d8Var.f.getAndSet((i * 2) + 1, tnVar) != tnVar) {
                        d8Var.l(i, true);
                    }
                    return 5;
                }
                if (d8Var.j(i, objK, q6.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void C(long j) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        o6 o6Var = this;
        if (o6Var.u()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = d;
            if (atomicLongFieldUpdater.get(o6Var) > j) {
                break;
            } else {
                o6Var = this;
            }
        }
        int i = q6.c;
        int i2 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f;
            if (i2 < i) {
                long j2 = atomicLongFieldUpdater.get(o6Var);
                if (j2 == (4611686018427387903L & atomicLongFieldUpdater2.get(o6Var)) && j2 == atomicLongFieldUpdater.get(o6Var)) {
                    return;
                } else {
                    i2++;
                }
            } else {
                while (true) {
                    long j3 = atomicLongFieldUpdater2.get(o6Var);
                    if (atomicLongFieldUpdater2.compareAndSet(o6Var, j3, (j3 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        o6Var = this;
                    }
                }
                while (true) {
                    long j4 = atomicLongFieldUpdater.get(o6Var);
                    long j5 = atomicLongFieldUpdater2.get(o6Var);
                    long j6 = j5 & 4611686018427387903L;
                    boolean z = (j5 & 4611686018427387904L) != 0;
                    if (j4 == j6 && j4 == atomicLongFieldUpdater.get(o6Var)) {
                        break;
                    }
                    if (z) {
                        o6Var = this;
                    } else {
                        o6Var = this;
                        atomicLongFieldUpdater2.compareAndSet(o6Var, j5, 4611686018427387904L + j6);
                    }
                }
                while (true) {
                    long j7 = atomicLongFieldUpdater2.get(o6Var);
                    if (atomicLongFieldUpdater2.compareAndSet(o6Var, j7, j7 & 4611686018427387903L)) {
                        return;
                    } else {
                        o6Var = this;
                    }
                }
            }
        }
    }

    @Override // sensei0.w30
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        f(cancellationException, true);
    }

    public final boolean e(long j) {
        return j < d.get(this) || j < c.get(this) + ((long) this.a);
    }

    public final boolean f(Throwable th, boolean z) {
        o6 o6Var;
        boolean z2;
        long j;
        long j2;
        long j3;
        Object obj;
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        if (!z) {
            o6Var = this;
            break;
        }
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if (((int) (j5 >> 60)) != 0) {
                o6Var = this;
                break;
            }
            d8 d8Var = q6.a;
            o6Var = this;
        } while (!atomicLongFieldUpdater.compareAndSet(o6Var, j5, (j5 & 1152921504606846975L) + (((long) 1) << 60)));
        tn tnVar = q6.s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q;
            if (atomicReferenceFieldUpdater.compareAndSet(this, tnVar, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != tnVar) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j4 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(o6Var, j4, (((long) 3) << 60) + (j4 & 1152921504606846975L)));
        } else {
            do {
                j = atomicLongFieldUpdater.get(this);
                int i = (int) (j >> 60);
                if (i == 0) {
                    j2 = j & 1152921504606846975L;
                    j3 = 2;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j2 = j & 1152921504606846975L;
                    j3 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(o6Var, j, (j3 << 60) + j2));
        }
        s();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = r;
                obj = atomicReferenceFieldUpdater2.get(this);
                tn tnVar2 = obj == null ? q6.q : q6.r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, tnVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                wf0.c(1, obj);
                ((fp) obj).g(m());
                return z2;
            }
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (sensei0.d8) ((sensei0.na) sensei0.na.b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.d8 g(long r13) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.g(long):sensei0.d8");
    }

    public final void h(long j) {
        d8 d8Var = (d8) o.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(((long) this.a) + j2, d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j2, 1 + j2)) {
                long j3 = q6.b;
                long j4 = j2 / j3;
                int i = (int) (j2 % j3);
                if (d8Var.c != j4) {
                    d8 d8VarL = l(j4, d8Var);
                    if (d8VarL != null) {
                        d8Var = d8VarL;
                    }
                }
                d8 d8Var2 = d8Var;
                if (A(d8Var2, i, j2, null) != q6.o || j2 < p()) {
                    d8Var2.a();
                }
                d8Var = d8Var2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0177, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163 A[RETURN] */
    @Override // sensei0.j70
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object i(java.lang.Object r23, sensei0.yb r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.i(java.lang.Object, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        q(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00be A[SYNTHETIC] */
    @Override // sensei0.j70
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object k(java.lang.Object r16) {
        /*
            r15 = this;
            sensei0.c8 r8 = sensei0.wf0.a
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = sensei0.o6.b
            long r1 = r9.get(r15)
            r10 = 0
            boolean r3 = r15.r(r1, r10)
            r11 = 1
            r12 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L17
            r1 = r10
            goto L1d
        L17:
            long r1 = r1 & r12
            boolean r1 = r15.e(r1)
            r1 = r1 ^ r11
        L1d:
            if (r1 == 0) goto L20
            return r8
        L20:
            sensei0.tn r6 = sensei0.q6.j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sensei0.o6.h
            java.lang.Object r1 = r1.get(r15)
            sensei0.d8 r1 = (sensei0.d8) r1
        L2a:
            long r2 = r9.getAndIncrement(r15)
            long r4 = r2 & r12
            boolean r7 = r15.r(r2, r10)
            int r14 = sensei0.q6.b
            long r2 = (long) r14
            long r12 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r10 = r1.c
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 == 0) goto L5d
            sensei0.d8 r3 = a(r15, r12, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        L54:
            r10 = 0
            r11 = 1
        L56:
            r12 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r10 = d(r0, r1, r2, r3, r4, r6, r7)
            sensei0.mg0 r3 = sensei0.mg0.a
            if (r10 == 0) goto Lbe
            r11 = 1
            if (r10 == r11) goto Lbd
            r3 = 2
            if (r10 == r3) goto L9c
            r2 = 3
            if (r10 == r2) goto L94
            r2 = 4
            if (r10 == r2) goto L7d
            r2 = 5
            if (r10 == r2) goto L78
            goto L7b
        L78:
            r1.a()
        L7b:
            r10 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sensei0.o6.c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.a()
        L8a:
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        L94:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L9c:
            if (r7 == 0) goto Lab
            r1.h()
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        Lab:
            boolean r3 = r6 instanceof sensei0.kj0
            if (r3 == 0) goto Lb2
            sensei0.kj0 r6 = (sensei0.kj0) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.a(r1, r2)
        Lb9:
            r1.h()
            return r8
        Lbd:
            return r3
        Lbe:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.k(java.lang.Object):java.lang.Object");
    }

    public final d8 l(long j, d8 d8Var) {
        Object objQ;
        long j2;
        d8 d8Var2 = q6.a;
        p6 p6Var = p6.p;
        loop0: while (true) {
            objQ = k6.q(d8Var, j, p6Var);
            if (!k6.E(objQ)) {
                d70 d70VarB = k6.B(objQ);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
                    d70 d70Var = (d70) atomicReferenceFieldUpdater.get(this);
                    if (d70Var.c >= d70VarB.c) {
                        break loop0;
                    }
                    if (!d70VarB.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, d70Var, d70VarB)) {
                        if (atomicReferenceFieldUpdater.get(this) != d70Var) {
                            if (d70VarB.e()) {
                                d70VarB.d();
                            }
                        }
                    }
                    if (d70Var.e()) {
                        d70Var.d();
                    }
                }
            } else {
                break;
            }
        }
        if (k6.E(objQ)) {
            s();
            if (d8Var.c * ((long) q6.b) < p()) {
                d8Var.a();
                return null;
            }
        } else {
            d8 d8Var3 = (d8) k6.B(objQ);
            long j3 = d8Var3.c;
            if (!u() && j <= d.get(this) / ((long) q6.b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = p;
                    d70 d70Var2 = (d70) atomicReferenceFieldUpdater2.get(this);
                    if (d70Var2.c >= j3 || !d8Var3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, d70Var2, d8Var3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != d70Var2) {
                            if (d8Var3.e()) {
                                d8Var3.d();
                            }
                        }
                    }
                    if (d70Var2.e()) {
                        d70Var2.d();
                    }
                }
            }
            if (j3 <= j) {
                return d8Var3;
            }
            long j4 = j3 * ((long) q6.b);
            do {
                j2 = c.get(this);
                if (j2 >= j4) {
                    break;
                }
            } while (!c.compareAndSet(this, j2, j4));
            if (j3 * ((long) q6.b) < p()) {
                d8Var3.a();
            }
        }
        return null;
    }

    public final Throwable m() {
        return (Throwable) q.get(this);
    }

    public final Throwable n() {
        Throwable thM = m();
        return thM == null ? new f9("Channel was closed") : thM;
    }

    public final Throwable o() {
        Throwable thM = m();
        return thM == null ? new g9("Channel was closed") : thM;
    }

    public final long p() {
        return b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (sensei0.d8) ((sensei0.na) sensei0.na.b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(long r14, boolean r16) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.r(long, boolean):boolean");
    }

    public final boolean s() {
        return r(b.get(this), false);
    }

    public boolean t() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01aa, code lost:
    
        r16 = r7;
        r3 = (sensei0.d8) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01b3, code lost:
    
        if (r3 != null) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.toString():java.lang.String");
    }

    public final boolean u() {
        long j = d.get(this);
        return j == 0 || j == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v(long r5, sensei0.d8 r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            sensei0.na r0 = r7.b()
            sensei0.d8 r0 = (sensei0.d8) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            sensei0.na r5 = r7.b()
            sensei0.d8 r5 = (sensei0.d8) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = sensei0.o6.p
            java.lang.Object r6 = r5.get(r4)
            sensei0.d70 r6 = (sensei0.d70) r6
            long r0 = r6.c
            long r2 = r7.c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o6.v(long, sensei0.d8):void");
    }

    public final Object w(Object obj, yb ybVar) throws Throwable {
        f7 f7Var = new f7(1, pr.D(ybVar));
        f7Var.u();
        f7Var.h(wf0.i(o()));
        Object objT = f7Var.t();
        return objT == vc.a ? objT : mg0.a;
    }

    public final void x(kj0 kj0Var, boolean z) {
        if (kj0Var instanceof e7) {
            ((xb) kj0Var).h(wf0.i(z ? n() : o()));
            return;
        }
        if (!(kj0Var instanceof n6)) {
            throw new IllegalStateException(("Unexpected waiter: " + kj0Var).toString());
        }
        n6 n6Var = (n6) kj0Var;
        f7 f7Var = n6Var.b;
        pr.f(f7Var);
        n6Var.b = null;
        n6Var.a = q6.l;
        Throwable thM = n6Var.c.m();
        if (thM == null) {
            f7Var.h(Boolean.FALSE);
        } else {
            f7Var.h(wf0.i(thM));
        }
    }

    public final boolean y(Object obj, Object obj2) {
        if (!(obj instanceof n6)) {
            if (!(obj instanceof e7)) {
                throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
            }
            e7 e7Var = (e7) obj;
            d8 d8Var = q6.a;
            tn tnVarL = e7Var.l(obj2, null);
            if (tnVarL == null) {
                return false;
            }
            e7Var.m(tnVarL);
            return true;
        }
        n6 n6Var = (n6) obj;
        f7 f7Var = n6Var.b;
        pr.f(f7Var);
        n6Var.b = null;
        n6Var.a = obj2;
        Boolean bool = Boolean.TRUE;
        d8 d8Var2 = q6.a;
        tn tnVarL2 = f7Var.l(bool, null);
        if (tnVarL2 == null) {
            return false;
        }
        f7Var.m(tnVarL2);
        return true;
    }
}
