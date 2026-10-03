package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y8 implements View.OnFocusChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ xi b;

    public /* synthetic */ y8(xi xiVar, int i) {
        this.a = i;
        this.b = xiVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.a) {
            case 0:
                b9 b9Var = (b9) this.b;
                b9Var.s(b9Var.t());
                break;
            default:
                jh jhVar = (jh) this.b;
                jhVar.l = z;
                jhVar.p();
                if (!z) {
                    jhVar.s(false);
                    jhVar.m = false;
                }
                break;
        }
    }
}
