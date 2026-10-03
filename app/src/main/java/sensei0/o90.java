package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o90 extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public final /* synthetic */ t90 o;
    public final /* synthetic */ String p;
    public final /* synthetic */ String q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o90(t90 t90Var, String str, String str2, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.o = t90Var;
        this.p = str;
        this.q = str2;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        uc ucVar = (uc) obj;
        xb xbVar = (xb) obj2;
        switch (this.f) {
        }
        return ((o90) j(ucVar, xbVar)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                return new o90(this.o, this.p, this.q, xbVar, 0);
            case 1:
                return new o90(this.o, this.p, this.q, xbVar, 1);
            default:
                return new o90(this.o, this.p, this.q, xbVar, 2);
        }
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        switch (this.f) {
            case 0:
                int i = this.h;
                if (i == 0) {
                    wf0.H(obj);
                    this.h = 1;
                    Object objH = t90.h(this.o, this.p, this.q, this);
                    vc vcVar = vc.a;
                    if (objH == vcVar) {
                        return vcVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                }
                return mg0.a;
            case 1:
                int i2 = this.h;
                if (i2 == 0) {
                    wf0.H(obj);
                    this.h = 1;
                    Object objH2 = t90.h(this.o, this.p, this.q, this);
                    vc vcVar2 = vc.a;
                    if (objH2 == vcVar2) {
                        return vcVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                }
                return mg0.a;
            default:
                int i3 = this.h;
                if (i3 == 0) {
                    wf0.H(obj);
                    this.h = 1;
                    Object objH3 = t90.h(this.o, this.p, this.q, this);
                    vc vcVar3 = vc.a;
                    if (objH3 == vcVar3) {
                        return vcVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                }
                return mg0.a;
        }
    }
}
