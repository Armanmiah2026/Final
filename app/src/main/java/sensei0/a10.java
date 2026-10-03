package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a10 implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ b10 b;

    public a10(b10 b10Var, View view) {
        this.b = b10Var;
        this.a = view;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        this.a.post(new jv(this, i, 2));
    }
}
