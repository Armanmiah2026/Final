package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m90 extends bd0 implements jp {
    public /* synthetic */ Object f;
    public final /* synthetic */ a20 h;
    public final /* synthetic */ boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m90(a20 a20Var, boolean z, xb xbVar) {
        super(2, xbVar);
        this.h = a20Var;
        this.o = z;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        m90 m90Var = (m90) j((gy) obj, (xb) obj2);
        mg0 mg0Var = mg0.a;
        m90Var.n(mg0Var);
        return mg0Var;
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        m90 m90Var = new m90(this.h, this.o, xbVar);
        m90Var.f = obj;
        return m90Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        gy gyVar = (gy) this.f;
        wf0.H(obj);
        gyVar.d(this.h, Boolean.valueOf(this.o));
        return mg0.a;
    }
}
