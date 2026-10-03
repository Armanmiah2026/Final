package sensei0;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sx {
    public final SparseArray a;
    public eg0 b;

    public sx(int i) {
        this.a = new SparseArray(i);
    }

    public final void a(eg0 eg0Var, int i, int i2) {
        int iA = eg0Var.a(i);
        SparseArray sparseArray = this.a;
        sx sxVar = sparseArray == null ? null : (sx) sparseArray.get(iA);
        if (sxVar == null) {
            sxVar = new sx(1);
            sparseArray.put(eg0Var.a(i), sxVar);
        }
        if (i2 > i) {
            sxVar.a(eg0Var, i + 1, i2);
        } else {
            sxVar.b = eg0Var;
        }
    }
}
