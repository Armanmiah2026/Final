package sensei0;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vm implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ View.OnFocusChangeListener b;
    public final /* synthetic */ FrameLayout c;

    public vm(View.OnFocusChangeListener onFocusChangeListener, wm wmVar) {
        this.b = onFocusChangeListener;
        this.c = wmVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        switch (this.a) {
            case 0:
                wm wmVar = (wm) this.c;
                this.b.onFocusChange(wmVar, ri0.d(wmVar, new kf0()));
                break;
            default:
                i10 i10Var = (i10) this.c;
                this.b.onFocusChange(i10Var, ri0.d(i10Var, new kf0()));
                break;
        }
    }

    public vm(i10 i10Var, View.OnFocusChangeListener onFocusChangeListener) {
        this.c = i10Var;
        this.b = onFocusChangeListener;
    }
}
