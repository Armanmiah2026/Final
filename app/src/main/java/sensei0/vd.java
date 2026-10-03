package sensei0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vd extends bd0 implements jp {
    public Iterator f;
    public Object h;
    public int o;
    public /* synthetic */ Object p;
    public final /* synthetic */ List q;
    public final /* synthetic */ ArrayList r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vd(List list, ArrayList arrayList, xb xbVar) {
        super(2, xbVar);
        this.q = list;
        this.r = arrayList;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        return ((vd) j(obj, (xb) obj2)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        vd vdVar = new vd(this.q, this.r, xbVar);
        vdVar.p = obj;
        return vdVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        Iterator it;
        List list;
        int i = this.o;
        if (i == 0) {
            wf0.H(obj);
            obj = this.p;
            it = this.q.iterator();
            list = this.r;
        } else if (i == 1) {
            Object obj2 = this.h;
            Iterator it2 = this.f;
            List list2 = (List) this.p;
            wf0.H(obj);
            if (((Boolean) obj).booleanValue()) {
                list2.add(new ud(1, null));
                this.p = list2;
                this.f = it2;
                this.h = null;
                this.o = 2;
                throw null;
            }
            obj = obj2;
            it = it2;
            list = list2;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = this.f;
            list = (List) this.p;
            wf0.H(obj);
        }
        if (!it.hasNext()) {
            return obj;
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        this.p = list;
        this.f = it;
        this.h = obj;
        this.o = 1;
        throw null;
    }
}
