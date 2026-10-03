package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class y6 extends z7 {
    public final y7 d;
    public final y7 f;

    public y6(y7 y7Var, lc lcVar, int i, m6 m6Var) {
        super(lcVar, i, m6Var);
        this.d = y7Var;
        this.f = y7Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // sensei0.z7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sensei0.s20 r5, sensei0.xb r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof sensei0.x6
            if (r0 == 0) goto L13
            r0 = r6
            sensei0.x6 r0 = (sensei0.x6) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L1a
        L13:
            sensei0.x6 r0 = new sensei0.x6
            sensei0.yb r6 = (sensei0.yb) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f
            int r1 = r0.o
            sensei0.mg0 r2 = sensei0.mg0.a
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 != r3) goto L2b
            sensei0.s20 r5 = r0.d
            sensei0.wf0.H(r6)
            goto L49
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            sensei0.wf0.H(r6)
            r0.d = r5
            r0.o = r3
            sensei0.y7 r6 = r4.d
            java.lang.Object r6 = r6.c(r5, r0)
            sensei0.vc r0 = sensei0.vc.a
            if (r6 != r0) goto L45
            goto L46
        L45:
            r6 = r2
        L46:
            if (r6 != r0) goto L49
            return r0
        L49:
            sensei0.r20 r5 = (sensei0.r20) r5
            sensei0.o6 r5 = r5.d
            boolean r5 = r5.s()
            if (r5 == 0) goto L54
            return r2
        L54:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.y6.a(sensei0.s20, sensei0.xb):java.lang.Object");
    }

    @Override // sensei0.z7
    public final String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }
}
