package sensei0;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ki0 extends bc {
    public za a;

    @Override // sensei0.bc
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        r(coordinatorLayout, view, i);
        if (this.a == null) {
            this.a = new za(view);
        }
        za zaVar = this.a;
        View view2 = (View) zaVar.c;
        zaVar.a = view2.getTop();
        zaVar.b = view2.getLeft();
        za zaVar2 = this.a;
        View view3 = (View) zaVar2.c;
        int top = 0 - (view3.getTop() - zaVar2.a);
        Field field = ai0.a;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - zaVar2.b));
        return true;
    }

    public void r(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.q(view, i);
    }
}
