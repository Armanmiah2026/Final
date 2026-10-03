package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ce extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public final /* synthetic */ ve o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ce(ve veVar, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.o = veVar;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        switch (this.f) {
        }
        return ((ce) j((uc) obj, (xb) obj2)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                return new ce(this.o, xbVar, 0);
            case 1:
                return new ce(this.o, xbVar, 1);
            default:
                return new ce(this.o, xbVar, 2);
        }
    }

    @Override // sensei0.l5
    public final Object n(Object obj) throws Throwable {
        switch (this.f) {
            case 0:
                int i = this.h;
                if (i == 0) {
                    wf0.H(obj);
                    this.h = 1;
                    Object objD = ve.d(this.o, this);
                    vc vcVar = vc.a;
                    if (objD == vcVar) {
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
                mg0 mg0Var = mg0.a;
                ve veVar = this.o;
                vc vcVar2 = vc.a;
                if (i2 == 0) {
                    wf0.H(obj);
                    j1 j1Var = veVar.q;
                    this.h = 1;
                    Object objT = ((da) j1Var.b).T(this);
                    if (objT != vcVar2) {
                        objT = mg0Var;
                    }
                    if (objT != vcVar2) {
                    }
                    return vcVar2;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                    return mg0Var;
                }
                wf0.H(obj);
                gl glVar = veVar.g().c;
                boolean z = glVar instanceof up;
                m6 m6Var = m6.b;
                gl glVarY = z ? pr.y((y6) ((up) glVar), null, 0, m6Var, 1) : new a8(glVar, oi.a, 0, m6Var);
                z6 z6Var = new z6(1, veVar);
                this.h = 2;
                if (glVarY.e(z6Var, this) != vcVar2) {
                    return mg0Var;
                }
                return vcVar2;
            default:
                ve veVar2 = this.o;
                sv svVar = veVar2.p;
                int i3 = this.h;
                vc vcVar3 = vc.a;
                try {
                    if (i3 == 0) {
                        wf0.H(obj);
                        if (svVar.B() instanceof dl) {
                            return svVar.B();
                        }
                        this.h = 1;
                        if (veVar2.h(this) == vcVar3) {
                            return vcVar3;
                        }
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            wf0.H(obj);
                            return (vb0) obj;
                        }
                        wf0.H(obj);
                    }
                    this.h = 2;
                    obj = ve.e(veVar2, false, this);
                    if (obj == vcVar3) {
                        return vcVar3;
                    }
                    return (vb0) obj;
                } catch (Throwable th) {
                    return new v30(th, -1);
                }
        }
    }
}
