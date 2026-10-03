package sensei0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class aj0 extends zi0 {
    @Override // sensei0.ui0
    public final float a(View view) {
        return view.getTransitionAlpha();
    }

    @Override // sensei0.ui0
    public final void d(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // sensei0.zi0, sensei0.ui0
    public final void e(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // sensei0.zi0
    public final void f(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // sensei0.zi0
    public final void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // sensei0.zi0
    public final void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
