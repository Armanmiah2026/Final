package sensei0;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oe0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ oe0(Toolbar toolbar, int i) {
        this.a = i;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                se0 se0Var = this.b.S;
                rw rwVar = se0Var == null ? null : se0Var.b;
                if (rwVar != null) {
                    rwVar.collapseActionView();
                }
                break;
            default:
                this.b.m();
                break;
        }
    }
}
