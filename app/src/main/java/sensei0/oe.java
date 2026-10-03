package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class oe extends bd0 implements fp {
    public Throwable f;
    public int h;
    public final /* synthetic */ ve o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oe(ve veVar, xb xbVar) {
        super(1, xbVar);
        this.o = veVar;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        return new oe(this.o, (xb) obj).n(mg0.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r6 != r4) goto L22;
     */
    @Override // sensei0.l5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.h
            sensei0.ve r1 = r5.o
            r2 = 2
            r3 = 1
            sensei0.vc r4 = sensei0.vc.a
            if (r0 == 0) goto L23
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            java.lang.Throwable r0 = r5.f
            sensei0.wf0.H(r6)
            goto L41
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            sensei0.wf0.H(r6)     // Catch: java.lang.Throwable -> L20
            goto L2f
        L20:
            r6 = move-exception
            r0 = r6
            goto L32
        L23:
            sensei0.wf0.H(r6)
            r5.h = r3     // Catch: java.lang.Throwable -> L20
            java.lang.Object r6 = sensei0.ve.f(r1, r3, r5)     // Catch: java.lang.Throwable -> L20
            if (r6 != r4) goto L2f
            goto L40
        L2f:
            sensei0.vb0 r6 = (sensei0.vb0) r6     // Catch: java.lang.Throwable -> L20
            goto L4d
        L32:
            sensei0.oa0 r6 = r1.g()
            r5.f = r0
            r5.h = r2
            java.lang.Integer r6 = r6.a()
            if (r6 != r4) goto L41
        L40:
            return r4
        L41:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            sensei0.v30 r1 = new sensei0.v30
            r1.<init>(r0, r6)
            r6 = r1
        L4d:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            sensei0.qz r1 = new sensei0.qz
            r1.<init>(r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.oe.n(java.lang.Object):java.lang.Object");
    }
}
