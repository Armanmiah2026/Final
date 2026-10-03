package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a8 extends z7 {
    public final gl d;

    public a8(gl glVar, lc lcVar, int i, m6 m6Var) {
        super(lcVar, i, m6Var);
        this.d = glVar;
    }

    @Override // sensei0.z7
    public final Object a(s20 s20Var, xb xbVar) {
        Object objE = this.d.e(new k70(s20Var), (yb) xbVar);
        mg0 mg0Var = mg0.a;
        vc vcVar = vc.a;
        if (objE != vcVar) {
            objE = mg0Var;
        }
        return objE == vcVar ? objE : mg0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // sensei0.z7, sensei0.gl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(sensei0.il r7, sensei0.yb r8) throws java.lang.Throwable {
        /*
            r6 = this;
            int r0 = r6.b
            r1 = -3
            sensei0.vc r2 = sensei0.vc.a
            sensei0.mg0 r3 = sensei0.mg0.a
            if (r0 != r1) goto L6d
            sensei0.lc r0 = r8.f()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            sensei0.mc r4 = sensei0.mc.d
            sensei0.lc r5 = r6.a
            java.lang.Object r1 = r5.d(r1, r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L24
            sensei0.lc r1 = r0.j(r5)
            goto L29
        L24:
            r1 = 0
            sensei0.lc r1 = sensei0.xe.k(r0, r5, r1)
        L29:
            boolean r4 = sensei0.pr.b(r1, r0)
            if (r4 == 0) goto L3c
            sensei0.gl r0 = r6.d
            java.lang.Object r7 = r0.e(r7, r8)
            if (r7 != r2) goto L38
            goto L39
        L38:
            r7 = r3
        L39:
            if (r7 != r2) goto L74
            return r7
        L3c:
            sensei0.mh r4 = sensei0.mh.c
            sensei0.jc r5 = r1.n(r4)
            sensei0.jc r0 = r0.n(r4)
            boolean r0 = sensei0.pr.b(r5, r0)
            if (r0 == 0) goto L6d
            sensei0.lc r0 = r8.f()
            boolean r4 = r7 instanceof sensei0.k70
            if (r4 == 0) goto L55
            goto L5b
        L55:
            sensei0.pl r4 = new sensei0.pl
            r4.<init>(r7, r0)
            r7 = r4
        L5b:
            sensei0.a7 r0 = new sensei0.a7
            r4 = 0
            r5 = 2
            r0.<init>(r6, r4, r5)
            java.lang.Object r4 = sensei0.xe.M(r1)
            java.lang.Object r7 = sensei0.k6.Y(r1, r7, r4, r0, r8)
            if (r7 != r2) goto L74
            return r7
        L6d:
            java.lang.Object r7 = super.e(r7, r8)
            if (r7 != r2) goto L74
            return r7
        L74:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.a8.e(sensei0.il, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.z7
    public final String toString() {
        return this.d + " -> " + super.toString();
    }
}
