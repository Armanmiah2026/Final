package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pe extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public /* synthetic */ boolean o;
    public final /* synthetic */ ve p;
    public final /* synthetic */ int q;
    public Object r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pe(ve veVar, int i, xb xbVar, int i2) {
        super(2, xbVar);
        this.f = i2;
        this.p = veVar;
        this.q = i;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        int i = this.f;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        xb xbVar = (xb) obj2;
        switch (i) {
        }
        return ((pe) j(bool, xbVar)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                pe peVar = new pe(this.p, this.q, xbVar, 0);
                peVar.o = ((Boolean) obj).booleanValue();
                return peVar;
            default:
                pe peVar2 = new pe(this.p, this.q, xbVar, 1);
                peVar2.o = ((Boolean) obj).booleanValue();
                return peVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // sensei0.l5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(java.lang.Object r7) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pe.n(java.lang.Object):java.lang.Object");
    }
}
