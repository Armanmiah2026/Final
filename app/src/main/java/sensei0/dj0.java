package sensei0;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dj0 implements ViewTreeObserver.OnDrawListener {
    public final View a;
    public f5 b;

    public dj0(View view, f5 f5Var) {
        this.a = view;
        this.b = f5Var;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        f5 f5Var = this.b;
        if (f5Var == null) {
            return;
        }
        f5Var.run();
        this.b = null;
        this.a.post(new f5(16, this));
    }
}
