package sensei0;

import android.content.res.TypedArray;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vi {
    public final SparseArray a = new SparseArray();
    public final wi b;
    public final int c;
    public final int d;

    public vi(wi wiVar, o4 o4Var) {
        this.b = wiVar;
        TypedArray typedArray = (TypedArray) o4Var.b;
        this.c = typedArray.getResourceId(28, 0);
        this.d = typedArray.getResourceId(52, 0);
    }
}
