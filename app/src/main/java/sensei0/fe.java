package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fe extends bd0 implements kp {
    public final /* synthetic */ int f = 1;
    public int h;
    public /* synthetic */ Object o;

    public /* synthetic */ fe(int i, xb xbVar) {
        super(i, xbVar);
    }

    @Override // sensei0.kp
    public final Object i(Object obj, Object obj2, yb ybVar) {
        switch (this.f) {
            case 0:
                return new fe((ve) this.o, ybVar).n(mg0.a);
            default:
                ((Boolean) obj2).getClass();
                fe feVar = new fe(3, ybVar);
                feVar.o = (uk) obj;
                return feVar.n(mg0.a);
        }
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        switch (this.f) {
            case 0:
                int i = this.h;
                if (i == 0) {
                    wf0.H(obj);
                    ve veVar = (ve) this.o;
                    this.h = 1;
                    Object objB = ve.b(veVar, this);
                    vc vcVar = vc.a;
                    if (objB == vcVar) {
                        return vcVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                }
                return mg0.a;
            default:
                int i2 = this.h;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                    return obj;
                }
                wf0.H(obj);
                uk ukVar = (uk) this.o;
                this.h = 1;
                ukVar.getClass();
                Object objA = uk.a(ukVar, this);
                vc vcVar2 = vc.a;
                return objA == vcVar2 ? vcVar2 : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe(ve veVar, yb ybVar) {
        super(3, ybVar);
        this.o = veVar;
    }
}
