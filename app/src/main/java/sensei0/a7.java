package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a7 extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public Object o;
    public final /* synthetic */ Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a7(Object obj, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.p = obj;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        switch (this.f) {
            case 0:
                return ((a7) j((uc) obj, (xb) obj2)).n(mg0.a);
            case 1:
                return ((a7) j((s20) obj, (xb) obj2)).n(mg0.a);
            case 2:
                return ((a7) j((il) obj, (xb) obj2)).n(mg0.a);
            case 3:
                return ((a7) j((zd) obj, (xb) obj2)).n(mg0.a);
            case 4:
                return ((a7) j((uc) obj, (xb) obj2)).n(mg0.a);
            case 5:
                return ((a7) j((cx) obj, (xb) obj2)).n(mg0.a);
            case 6:
                return ((a7) j((uc) obj, (xb) obj2)).n(mg0.a);
            default:
                return ((a7) j(obj, (xb) obj2)).n(mg0.a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                return new a7((gl) this.o, (kb) this.p, xbVar);
            case 1:
                a7 a7Var = new a7((z7) this.p, xbVar, 1);
                a7Var.o = obj;
                return a7Var;
            case 2:
                a7 a7Var2 = new a7((a8) this.p, xbVar, 2);
                a7Var2.o = obj;
                return a7Var2;
            case 3:
                a7 a7Var3 = new a7((List) this.p, xbVar, 3);
                a7Var3.o = obj;
                return a7Var3;
            case 4:
                return new a7((jp) this.o, (sd) this.p, xbVar);
            case 5:
                a7 a7Var4 = new a7((ve) this.p, xbVar, 5);
                a7Var4.o = obj;
                return a7Var4;
            case 6:
                return new a7((j1) this.p, xbVar, 6);
            default:
                a7 a7Var5 = new a7((il) this.p, xbVar, 7);
                a7Var5.o = obj;
                return a7Var5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b6, code lost:
    
        if (r2.c(r0, r21) != r5) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Type inference failed for: r0v25, types: [sensei0.bd0, sensei0.jp] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, sensei0.o6] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01b6 -> B:98:0x01ba). Please report as a decompilation issue!!! */
    @Override // sensei0.l5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.a7.n(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a7(gl glVar, kb kbVar, xb xbVar) {
        super(2, xbVar);
        this.f = 0;
        this.o = glVar;
        this.p = kbVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a7(jp jpVar, sd sdVar, xb xbVar) {
        super(2, xbVar);
        this.f = 4;
        this.o = (bd0) jpVar;
        this.p = sdVar;
    }
}
