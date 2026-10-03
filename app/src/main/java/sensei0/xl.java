package sensei0;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xl implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ nn a;
    public final /* synthetic */ zl b;

    public xl(zl zlVar, nn nnVar) {
        this.b = zlVar;
        this.a = nnVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        zl zlVar = this.b;
        if (zlVar.h && zlVar.f != null) {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            zlVar.f = null;
        }
        return zlVar.h;
    }
}
