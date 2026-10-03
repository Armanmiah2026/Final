package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rc extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater q = AtomicIntegerFieldUpdater.newUpdater(rc.class, "workerCtl$volatile");
    public final im0 a;
    public final x40 b;
    public sc c;
    public long d;
    public long f;
    public int h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    public boolean o;
    public final /* synthetic */ tc p;
    private volatile /* synthetic */ int workerCtl$volatile;

    public rc(tc tcVar, int i) {
        this.p = tcVar;
        setDaemon(true);
        setContextClassLoader(tc.class.getClassLoader());
        this.a = new im0();
        this.b = new x40();
        this.c = sc.d;
        this.nextParkedWorker = tc.s;
        int iNanoTime = (int) System.nanoTime();
        this.h = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r12 = sensei0.im0.d.get(r9);
        r0 = sensei0.im0.c.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (sensei0.im0.e.get(r9) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r0 = r0 - 1;
        r1 = r9.b(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r1 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.gd0 a(boolean r12) {
        /*
            r11 = this;
            sensei0.sc r0 = r11.c
            sensei0.tc r2 = r11.p
            r7 = 0
            r8 = 1
            sensei0.im0 r9 = r11.a
            sensei0.sc r10 = sensei0.sc.a
            if (r0 != r10) goto Le
            goto L86
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = sensei0.tc.q
        L10:
            long r3 = r0.get(r2)
            r5 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r5 = r5 & r3
            r1 = 42
            long r5 = r5 >> r1
            int r1 = (int) r5
            if (r1 != 0) goto L75
            r9.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = sensei0.im0.b
            java.lang.Object r0 = r12.get(r9)
            sensei0.gd0 r0 = (sensei0.gd0) r0
            if (r0 != 0) goto L2e
            goto L43
        L2e:
            sensei0.xs r1 = r0.b
            int r1 = r1.a
            if (r1 != r8) goto L43
        L34:
            boolean r1 = r12.compareAndSet(r9, r0, r7)
            if (r1 == 0) goto L3c
            r7 = r0
            goto L63
        L3c:
            java.lang.Object r1 = r12.get(r9)
            if (r1 == r0) goto L34
            goto L23
        L43:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = sensei0.im0.d
            int r12 = r12.get(r9)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = sensei0.im0.c
            int r0 = r0.get(r9)
        L4f:
            if (r12 == r0) goto L63
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = sensei0.im0.e
            int r1 = r1.get(r9)
            if (r1 != 0) goto L5a
            goto L63
        L5a:
            int r0 = r0 + (-1)
            sensei0.gd0 r1 = r9.b(r0, r8)
            if (r1 == 0) goto L4f
            r7 = r1
        L63:
            if (r7 != 0) goto L74
            sensei0.eq r12 = r2.h
            java.lang.Object r12 = r12.d()
            sensei0.gd0 r12 = (sensei0.gd0) r12
            if (r12 != 0) goto L73
            sensei0.gd0 r12 = r11.i(r8)
        L73:
            return r12
        L74:
            return r7
        L75:
            r5 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r5 = r3 - r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sensei0.tc.q
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L10
            r11.c = r10
        L86:
            if (r12 == 0) goto Lba
            int r12 = r2.a
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L93
            goto L94
        L93:
            r8 = 0
        L94:
            if (r8 == 0) goto L9d
            sensei0.gd0 r12 = r11.e()
            if (r12 == 0) goto L9d
            return r12
        L9d:
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = sensei0.im0.b
            java.lang.Object r12 = r12.getAndSet(r9, r7)
            sensei0.gd0 r12 = (sensei0.gd0) r12
            if (r12 != 0) goto Lae
            sensei0.gd0 r12 = r9.a()
        Lae:
            if (r12 == 0) goto Lb1
            return r12
        Lb1:
            if (r8 != 0) goto Lc1
            sensei0.gd0 r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lba:
            sensei0.gd0 r12 = r11.e()
            if (r12 == 0) goto Lc1
            return r12
        Lc1:
            r12 = 3
            sensei0.gd0 r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.rc.a(boolean):sensei0.gd0");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.h;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.h = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
    }

    public final gd0 e() {
        int iD = d(2);
        tc tcVar = this.p;
        if (iD == 0) {
            gd0 gd0Var = (gd0) tcVar.f.d();
            return gd0Var != null ? gd0Var : (gd0) tcVar.h.d();
        }
        gd0 gd0Var2 = (gd0) tcVar.h.d();
        return gd0Var2 != null ? gd0Var2 : (gd0) tcVar.f.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.p.d);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(sc scVar) {
        sc scVar2 = this.c;
        boolean z = scVar2 == sc.a;
        if (z) {
            tc.q.addAndGet(this.p, 4398046511104L);
        }
        if (scVar2 != scVar) {
            this.c = scVar;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        r7 = -2;
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.gd0 i(int r26) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.rc.i(int):sensei0.gd0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.rc.run():void");
    }
}
