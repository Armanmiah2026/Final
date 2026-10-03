package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p90 extends bd0 implements jp {
    public /* synthetic */ Object f;
    public final /* synthetic */ a20 h;
    public final /* synthetic */ double o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p90(a20 a20Var, double d, xb xbVar) {
        super(2, xbVar);
        this.h = a20Var;
        this.o = d;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        p90 p90Var = (p90) j((gy) obj, (xb) obj2);
        mg0 mg0Var = mg0.a;
        p90Var.n(mg0Var);
        return mg0Var;
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        p90 p90Var = new p90(this.h, this.o, xbVar);
        p90Var.f = obj;
        return p90Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        gy gyVar = (gy) this.f;
        wf0.H(obj);
        gyVar.d(this.h, new Double(this.o));
        return mg0.a;
    }
}
