package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ee extends bd0 implements jp {
    public final /* synthetic */ int f;
    public /* synthetic */ Object h;
    public final /* synthetic */ Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ee(Object obj, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        this.o = obj;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        switch (this.f) {
            case 0:
                return ((ee) j((vb0) obj, (xb) obj2)).n(mg0.a);
            default:
                ee eeVar = (ee) j((gy) obj, (xb) obj2);
                mg0 mg0Var = mg0.a;
                eeVar.n(mg0Var);
                return mg0Var;
        }
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                ee eeVar = new ee((vb0) this.o, xbVar, 0);
                eeVar.h = obj;
                return eeVar;
            default:
                ee eeVar2 = new ee((List) this.o, xbVar, 1);
                eeVar2.h = obj;
                return eeVar2;
        }
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        int i = this.f;
        Object obj2 = this.o;
        switch (i) {
            case 0:
                wf0.H(obj);
                vb0 vb0Var = (vb0) this.h;
                return Boolean.valueOf((vb0Var instanceof sd) && vb0Var.a <= ((vb0) obj2).a);
            default:
                gy gyVar = (gy) this.h;
                wf0.H(obj);
                List<String> list = (List) obj2;
                if (list != null) {
                    for (String str : list) {
                        pr.j("name", str);
                        a20 a20Var = new a20(str);
                        gyVar.b();
                        gyVar.a.remove(a20Var);
                    }
                } else {
                    gyVar.b();
                    gyVar.a.clear();
                }
                return mg0.a;
        }
    }
}
