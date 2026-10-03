package sensei0;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ou implements AbsListView.OnScrollListener {
    public final /* synthetic */ qu a;

    public ou(qu quVar) {
        this.a = quVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        qu quVar = this.a;
        mu muVar = quVar.v;
        w3 w3Var = quVar.D;
        if (i != 1 || w3Var.getInputMethodMode() == 2 || w3Var.getContentView() == null) {
            return;
        }
        quVar.z.removeCallbacks(muVar);
        muVar.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
