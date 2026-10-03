package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ue extends bd0 implements jp {
    public w40 f;
    public int h;
    public /* synthetic */ Object o;
    public final /* synthetic */ w40 p;
    public final /* synthetic */ ve q;
    public final /* synthetic */ Object r;
    public final /* synthetic */ boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue(w40 w40Var, ve veVar, Object obj, boolean z, xb xbVar) {
        super(2, xbVar);
        this.p = w40Var;
        this.q = veVar;
        this.r = obj;
        this.s = z;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        return ((ue) j((bl) obj, (xb) obj2)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        ue ueVar = new ue(this.p, this.q, this.r, this.s, xbVar);
        ueVar.o = obj;
        return ueVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r5.b(r1, r7) == r6) goto L16;
     */
    @Override // sensei0.l5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.h
            java.lang.Object r1 = r7.r
            sensei0.ve r2 = r7.q
            sensei0.w40 r3 = r7.p
            r4 = 2
            r5 = 1
            sensei0.vc r6 = sensei0.vc.a
            if (r0 == 0) goto L28
            if (r0 == r5) goto L1e
            if (r0 != r4) goto L16
            sensei0.wf0.H(r8)
            goto L65
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            sensei0.w40 r0 = r7.f
            java.lang.Object r5 = r7.o
            sensei0.bl r5 = (sensei0.bl) r5
            sensei0.wf0.H(r8)
            goto L4f
        L28:
            sensei0.wf0.H(r8)
            java.lang.Object r8 = r7.o
            sensei0.bl r8 = (sensei0.bl) r8
            sensei0.oa0 r0 = r2.g()
            r7.o = r8
            r7.f = r3
            r7.h = r5
            sensei0.sv r0 = r0.b
            java.lang.Object r0 = r0.b
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            int r0 = r0.incrementAndGet()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r0)
            if (r5 != r6) goto L4b
            goto L64
        L4b:
            r0 = r5
            r5 = r8
            r8 = r0
            r0 = r3
        L4f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.a = r8
            r8 = 0
            r7.o = r8
            r7.f = r8
            r7.h = r4
            java.lang.Object r8 = r5.b(r1, r7)
            if (r8 != r6) goto L65
        L64:
            return r6
        L65:
            boolean r8 = r7.s
            if (r8 == 0) goto L7d
            sensei0.sv r8 = r2.p
            sensei0.sd r0 = new sensei0.sd
            if (r1 == 0) goto L74
            int r2 = r1.hashCode()
            goto L75
        L74:
            r2 = 0
        L75:
            int r3 = r3.a
            r0.<init>(r1, r2, r3)
            r8.F(r0)
        L7d:
            sensei0.mg0 r8 = sensei0.mg0.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ue.n(java.lang.Object):java.lang.Object");
    }
}
