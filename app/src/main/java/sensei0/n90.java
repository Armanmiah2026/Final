package sensei0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n90 extends bd0 implements jp {
    public int f;
    public final /* synthetic */ String h;
    public final /* synthetic */ t90 o;
    public final /* synthetic */ boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n90(String str, t90 t90Var, boolean z, xb xbVar) {
        super(2, xbVar);
        this.h = str;
        this.o = t90Var;
        this.p = z;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        return ((n90) j((uc) obj, (xb) obj2)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        return new n90(this.h, this.o, this.p, xbVar);
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        int i = this.f;
        if (i == 0) {
            wf0.H(obj);
            a20 a20Var = new a20(this.h);
            Context context = this.o.a;
            if (context == null) {
                pr.V("context");
                throw null;
            }
            ws wsVarA = u90.a(context);
            m90 m90Var = new m90(a20Var, this.p, null);
            this.f = 1;
            Object objA = wsVarA.a(new x10(m90Var, null, 1), this);
            vc vcVar = vc.a;
            if (objA == vcVar) {
                return vcVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            wf0.H(obj);
        }
        return mg0.a;
    }
}
