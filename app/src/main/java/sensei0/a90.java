package sensei0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a90 extends bd0 implements jp {
    public final /* synthetic */ int f;
    public x40 h;
    public int o;
    public final /* synthetic */ String p;
    public final /* synthetic */ t90 q;
    public final /* synthetic */ x40 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a90(String str, t90 t90Var, x40 x40Var, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.p = str;
        this.q = t90Var;
        this.r = x40Var;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        uc ucVar = (uc) obj;
        xb xbVar = (xb) obj2;
        switch (this.f) {
        }
        return ((a90) j(ucVar, xbVar)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                return new a90(this.p, this.q, this.r, xbVar, 0);
            case 1:
                return new a90(this.p, this.q, this.r, xbVar, 1);
            case 2:
                return new a90(this.p, this.q, this.r, xbVar, 2);
            default:
                return new a90(this.p, this.q, this.r, xbVar, 3);
        }
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        x40 x40Var;
        x40 x40Var2;
        x40 x40Var3;
        x40 x40Var4;
        switch (this.f) {
            case 0:
                int i = this.o;
                if (i == 0) {
                    wf0.H(obj);
                    a20 a20Var = new a20(this.p);
                    Context context = this.q.a;
                    if (context == null) {
                        pr.V("context");
                        throw null;
                    }
                    z80 z80Var = new z80(((wd) u90.a(context).b).getData(), a20Var, 0);
                    x40Var = this.r;
                    this.h = x40Var;
                    this.o = 1;
                    obj = pr.x(z80Var, this);
                    vc vcVar = vc.a;
                    if (obj == vcVar) {
                        return vcVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    x40Var = this.h;
                    wf0.H(obj);
                }
                x40Var.a = obj;
                return mg0.a;
            case 1:
                int i2 = this.o;
                if (i2 == 0) {
                    wf0.H(obj);
                    a20 a20Var2 = new a20(this.p);
                    t90 t90Var = this.q;
                    Context context2 = t90Var.a;
                    if (context2 == null) {
                        pr.V("context");
                        throw null;
                    }
                    o4 o4Var = new o4(((wd) u90.a(context2).b).getData(), a20Var2, t90Var, 16);
                    x40Var2 = this.r;
                    this.h = x40Var2;
                    this.o = 1;
                    obj = pr.x(o4Var, this);
                    vc vcVar2 = vc.a;
                    if (obj == vcVar2) {
                        return vcVar2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    x40Var2 = this.h;
                    wf0.H(obj);
                }
                x40Var2.a = obj;
                return mg0.a;
            case 2:
                int i3 = this.o;
                if (i3 == 0) {
                    wf0.H(obj);
                    a20 a20Var3 = new a20(this.p);
                    Context context3 = this.q.a;
                    if (context3 == null) {
                        pr.V("context");
                        throw null;
                    }
                    z80 z80Var2 = new z80(((wd) u90.a(context3).b).getData(), a20Var3, 1);
                    x40Var3 = this.r;
                    this.h = x40Var3;
                    this.o = 1;
                    obj = pr.x(z80Var2, this);
                    vc vcVar3 = vc.a;
                    if (obj == vcVar3) {
                        return vcVar3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    x40Var3 = this.h;
                    wf0.H(obj);
                }
                x40Var3.a = obj;
                return mg0.a;
            default:
                int i4 = this.o;
                if (i4 == 0) {
                    wf0.H(obj);
                    a20 a20Var4 = new a20(this.p);
                    Context context4 = this.q.a;
                    if (context4 == null) {
                        pr.V("context");
                        throw null;
                    }
                    z80 z80Var3 = new z80(((wd) u90.a(context4).b).getData(), a20Var4, 2);
                    x40Var4 = this.r;
                    this.h = x40Var4;
                    this.o = 1;
                    obj = pr.x(z80Var3, this);
                    vc vcVar4 = vc.a;
                    if (obj == vcVar4) {
                        return vcVar4;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    x40Var4 = this.h;
                    wf0.H(obj);
                }
                x40Var4.a = obj;
                return mg0.a;
        }
    }
}
