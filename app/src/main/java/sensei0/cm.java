package sensei0;

import android.util.SparseArray;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cm implements dm {
    public final /* synthetic */ em a;

    public cm(em emVar) {
        this.a = emVar;
    }

    @Override // sensei0.dm
    public final void b() {
        em emVar = this.a;
        Iterator it = emVar.v.iterator();
        while (it.hasNext()) {
            ((dm) it.next()).b();
        }
        io.flutter.plugin.platform.c cVar = emVar.s;
        SparseArray sparseArray = cVar.t;
        while (sparseArray.size() > 0) {
            cVar.E.r(sparseArray.keyAt(0));
        }
        q10 q10Var = emVar.t;
        SparseArray sparseArray2 = q10Var.q;
        while (sparseArray2.size() > 0) {
            q10Var.y.g(sparseArray2.keyAt(0));
        }
        emVar.k.d = null;
    }

    @Override // sensei0.dm
    public final void a() {
    }
}
