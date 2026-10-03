package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z7 implements up {
    public final lc a;
    public final int b;
    public final m6 c;

    public z7(lc lcVar, int i, m6 m6Var) {
        this.a = lcVar;
        this.b = i;
        this.c = m6Var;
    }

    public abstract Object a(s20 s20Var, xb xbVar);

    @Override // sensei0.gl
    public Object e(il ilVar, yb ybVar) throws Throwable {
        y7 y7Var = new y7(ilVar, this, null, 0);
        x60 x60Var = new x60(ybVar, ybVar.f());
        Object objV = k6.V(x60Var, x60Var, y7Var);
        return objV == vc.a ? objV : mg0.a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        oi oiVar = oi.a;
        lc lcVar = this.a;
        if (lcVar != oiVar) {
            arrayList.add("context=" + lcVar);
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        m6 m6Var = m6.a;
        m6 m6Var2 = this.c;
        if (m6Var2 != m6Var) {
            arrayList.add("onBufferOverflow=" + m6Var2);
        }
        return getClass().getSimpleName() + '[' + o9.m0(arrayList, ", ", null, null, null, 62) + ']';
    }
}
