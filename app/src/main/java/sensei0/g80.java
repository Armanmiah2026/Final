package sensei0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g80 extends m80 {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Matrix d;

    public g80(ArrayList arrayList, Matrix matrix) {
        this.c = arrayList;
        this.d = matrix;
    }

    @Override // sensei0.m80
    public final void a(Matrix matrix, b80 b80Var, int i, Canvas canvas) {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((m80) obj).a(this.d, b80Var, i, canvas);
        }
    }
}
