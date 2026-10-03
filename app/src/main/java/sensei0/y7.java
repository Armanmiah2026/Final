package sensei0;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class y7 extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public /* synthetic */ Object o;
    public Object p;
    public final /* synthetic */ Object q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y7(Object obj, Object obj2, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.p = obj;
        this.q = obj2;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        switch (this.f) {
            case 0:
                return ((y7) j((uc) obj, (xb) obj2)).n(mg0.a);
            case 1:
                return ((y7) j((il) obj, (xb) obj2)).n(mg0.a);
            case 2:
                return ((y7) j((uc) obj, (xb) obj2)).n(mg0.a);
            default:
                return ((y7) j((s20) obj, (xb) obj2)).n(mg0.a);
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                y7 y7Var = new y7((il) this.p, (z7) this.q, xbVar, 0);
                y7Var.o = obj;
                return y7Var;
            case 1:
                y7 y7Var2 = new y7((ve) this.q, xbVar);
                y7Var2.o = obj;
                return y7Var2;
            case 2:
                y7 y7Var3 = new y7((ve) this.p, (bd0) this.q, xbVar);
                y7Var3.o = obj;
                return y7Var3;
            default:
                y7 y7Var4 = new y7((fb0) this.p, (Activity) this.q, xbVar, 3);
                y7Var4.o = obj;
                return y7Var4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ab  */
    /* JADX WARN: Type inference failed for: r6v4, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.l5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.y7.n(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y7(ve veVar, xb xbVar) {
        super(2, xbVar);
        this.f = 1;
        this.q = veVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y7(ve veVar, jp jpVar, xb xbVar) {
        super(2, xbVar);
        this.f = 2;
        this.p = veVar;
        this.q = (bd0) jpVar;
    }
}
