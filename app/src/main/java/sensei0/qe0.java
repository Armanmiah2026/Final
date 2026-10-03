package sensei0;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qe0 implements View.OnClickListener {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    public qe0(we0 we0Var) {
        this.b = we0Var;
        we0Var.a.getContext();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                se0 se0Var = ((Toolbar) this.b).S;
                rw rwVar = se0Var == null ? null : se0Var.b;
                if (rwVar != null) {
                    rwVar.collapseActionView();
                }
                break;
            default:
                we0 we0Var = (we0) this.b;
                if (we0Var.k != null) {
                    we0Var.getClass();
                }
                break;
        }
    }

    public qe0(Toolbar toolbar) {
        this.b = toolbar;
    }
}
