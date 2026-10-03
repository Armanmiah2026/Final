package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ve implements wd {
    public final wk a;
    public final pf b;
    public final uc c;
    public int h;
    public ob0 o;
    public final j1 q;
    public final dd0 r;
    public final dd0 s;
    public final j1 t;
    public final ws d = new ws(new y7(this, null));
    public final ky f = new ky();
    public final sv p = new sv(18);

    public ve(wk wkVar, List list, pf pfVar, uc ucVar) {
        this.a = wkVar;
        this.b = pfVar;
        this.c = ucVar;
        j1 j1Var = new j1();
        j1Var.c = this;
        j1Var.a = new ky();
        da daVar = new da(true);
        daVar.G(null);
        j1Var.b = daVar;
        j1Var.d = o9.r0(list);
        this.q = j1Var;
        this.r = new dd0(new be(this, 1));
        this.s = new dd0(new be(this, 0));
        se seVar = new se(0, this);
        a7 a7Var = new a7(this, (xb) null, 5);
        j1 j1Var2 = new j1();
        j1Var2.a = ucVar;
        j1Var2.b = a7Var;
        j1Var2.c = xe.a(Integer.MAX_VALUE, null, 6);
        j1Var2.d = new sv(8);
        bs bsVar = (bs) ucVar.g().n(mh.p);
        if (bsVar != null) {
            ((ls) bsVar).H(false, true, new nr(new ja0(seVar, j1Var2)));
        }
        this.t = j1Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(sensei0.ve r4, sensei0.yb r5) {
        /*
            boolean r0 = r5 instanceof sensei0.ie
            if (r0 == 0) goto L13
            r0 = r5
            sensei0.ie r0 = (sensei0.ie) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.ie r0 = new sensei0.ie
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.h
            int r1 = r0.p
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            sensei0.ky r4 = r0.f
            sensei0.ve r0 = r0.d
            sensei0.wf0.H(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            sensei0.wf0.H(r5)
            sensei0.ky r5 = r4.f
            r0.d = r4
            r0.f = r5
            r0.p = r2
            java.lang.Object r0 = r5.c(r0)
            sensei0.vc r1 = sensei0.vc.a
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.h     // Catch: java.lang.Throwable -> L58
            int r1 = r1 + (-1)
            r4.h = r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5c
            sensei0.ob0 r1 = r4.o     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L5a
            r1.b(r0)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4.o = r0     // Catch: java.lang.Throwable -> L58
        L5c:
            r5.e(r0)
            sensei0.mg0 r4 = sensei0.mg0.a
            return r4
        L62:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.b(sensei0.ve, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(0)|8|(8:68|(1:(1:(2:18|19))(3:20|21|22))|13|14|62|(1:64)(1:65)|66|67)(5:23|73|24|(3:26|71|27)(3:37|(1:39)(1:40)|(2:42|(2:44|(1:46))(2:53|54))(2:55|(2:57|58)(2:59|60)))|50)|47|69|48) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v3, types: [sensei0.bd0, sensei0.jp] */
    /* JADX WARN: Type inference failed for: r1v9, types: [sensei0.bd0, sensei0.jp] */
    /* JADX WARN: Type inference failed for: r9v0, types: [sensei0.ve] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [sensei0.ve] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(sensei0.ve r9, sensei0.cx r10, sensei0.yb r11) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.c(sensei0.ve, sensei0.cx, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(sensei0.ve r4, sensei0.yb r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof sensei0.le
            if (r0 == 0) goto L13
            r0 = r5
            sensei0.le r0 = (sensei0.le) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.le r0 = new sensei0.le
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.h
            int r1 = r0.p
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            sensei0.ky r4 = r0.f
            sensei0.ve r0 = r0.d
            sensei0.wf0.H(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            sensei0.wf0.H(r5)
            sensei0.ky r5 = r4.f
            r0.d = r4
            r0.f = r5
            r0.p = r2
            java.lang.Object r0 = r5.c(r0)
            sensei0.vc r1 = sensei0.vc.a
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.h     // Catch: java.lang.Throwable -> L5e
            int r1 = r1 + r2
            r4.h = r1     // Catch: java.lang.Throwable -> L5e
            if (r1 != r2) goto L60
            sensei0.uc r1 = r4.c     // Catch: java.lang.Throwable -> L5e
            sensei0.ce r2 = new sensei0.ce     // Catch: java.lang.Throwable -> L5e
            r3 = 1
            r2.<init>(r4, r0, r3)     // Catch: java.lang.Throwable -> L5e
            sensei0.ob0 r1 = sensei0.wf0.q(r1, r2)     // Catch: java.lang.Throwable -> L5e
            r4.o = r1     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r4 = move-exception
            goto L66
        L60:
            r5.e(r0)
            sensei0.mg0 r4 = sensei0.mg0.a
            return r4
        L66:
            r5.e(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.d(sensei0.ve, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(sensei0.ve r8, boolean r9, sensei0.yb r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.e(sensei0.ve, boolean, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x013f, code lost:
    
        if (r11 != r4) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6 A[Catch: zc -> 0x00a7, TryCatch #1 {zc -> 0x00a7, blocks: (B:36:0x00a2, B:70:0x0142, B:41:0x00b0, B:67:0x0124, B:49:0x00cd, B:57:0x00e6, B:58:0x00ea, B:53:0x00d6, B:64:0x0112), top: B:76:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(sensei0.ve r9, boolean r10, sensei0.yb r11) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.f(sensei0.ve, boolean, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.wd
    public final Object a(jp jpVar, yb ybVar) {
        xg0 xg0Var = (xg0) ybVar.f().n(mh.u);
        if (xg0Var != null) {
            xg0Var.e(this);
        }
        return wf0.I(new xg0(xg0Var, this), new y7(this, jpVar, null), ybVar);
    }

    public final oa0 g() {
        return (oa0) this.s.a();
    }

    @Override // sensei0.wd
    public final gl getData() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r3.j(r0) == r4) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(sensei0.yb r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sensei0.me
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.me r0 = (sensei0.me) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.me r0 = new sensei0.me
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.h
            int r1 = r0.p
            r2 = 2
            r3 = 1
            sensei0.vc r4 = sensei0.vc.a
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            int r1 = r0.f
            sensei0.ve r0 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r7 = move-exception
            goto L6e
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            sensei0.ve r1 = r0.d
            sensei0.wf0.H(r7)
            goto L51
        L3e:
            sensei0.wf0.H(r7)
            sensei0.oa0 r7 = r6.g()
            r0.d = r6
            r0.p = r3
            java.lang.Integer r7 = r7.a()
            if (r7 != r4) goto L50
            goto L65
        L50:
            r1 = r6
        L51:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            sensei0.j1 r3 = r1.q     // Catch: java.lang.Throwable -> L69
            r0.d = r1     // Catch: java.lang.Throwable -> L69
            r0.f = r7     // Catch: java.lang.Throwable -> L69
            r0.p = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = r3.j(r0)     // Catch: java.lang.Throwable -> L69
            if (r7 != r4) goto L66
        L65:
            return r4
        L66:
            sensei0.mg0 r7 = sensei0.mg0.a
            return r7
        L69:
            r0 = move-exception
            r5 = r1
            r1 = r7
            r7 = r0
            r0 = r5
        L6e:
            sensei0.sv r0 = r0.p
            sensei0.v30 r2 = new sensei0.v30
            r2.<init>(r7, r1)
            r0.F(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.h(sensei0.yb):java.lang.Object");
    }

    public final Object i(yb ybVar) {
        return ((zk) this.r.a()).a(new fe(3, (xb) null), ybVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.lang.Object r10, boolean r11, sensei0.yb r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof sensei0.te
            if (r0 == 0) goto L13
            r0 = r12
            sensei0.te r0 = (sensei0.te) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            sensei0.te r0 = new sensei0.te
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f
            int r1 = r0.o
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            sensei0.w40 r10 = r0.d
            sensei0.wf0.H(r12)
            goto L56
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            sensei0.wf0.H(r12)
            sensei0.w40 r4 = new sensei0.w40
            r4.<init>()
            sensei0.dd0 r12 = r9.r
            java.lang.Object r12 = r12.a()
            sensei0.zk r12 = (sensei0.zk) r12
            sensei0.ue r3 = new sensei0.ue
            r8 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.d = r4
            r0.o = r2
            java.lang.Object r10 = r12.b(r3, r0)
            sensei0.vc r11 = sensei0.vc.a
            if (r10 != r11) goto L55
            return r11
        L55:
            r10 = r4
        L56:
            int r10 = r10.a
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ve.j(java.lang.Object, boolean, sensei0.yb):java.lang.Object");
    }
}
