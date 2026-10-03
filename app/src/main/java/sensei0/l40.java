package sensei0;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l40 {
    public SparseArray a;
    public int b;

    public final k40 a(int i) {
        SparseArray sparseArray = this.a;
        k40 k40Var = (k40) sparseArray.get(i);
        if (k40Var != null) {
            return k40Var;
        }
        k40 k40Var2 = new k40();
        sparseArray.put(i, k40Var2);
        return k40Var2;
    }
}
