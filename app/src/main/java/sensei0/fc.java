package sensei0;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fc implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ CoordinatorLayout a;

    public fc(CoordinatorLayout coordinatorLayout) {
        this.a = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.p(0);
        return true;
    }
}
