package sensei0;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ll0 extends jl0 {
    public static final rl0 r = rl0.d(null, WindowInsets.CONSUMED);

    public ll0(rl0 rl0Var, WindowInsets windowInsets) {
        super(rl0Var, windowInsets);
    }

    @Override // sensei0.gl0, sensei0.ol0
    public hr f(int i) {
        return hr.c(this.c.getInsets(pl0.a(i)));
    }

    @Override // sensei0.gl0, sensei0.ol0
    public boolean o(int i) {
        return this.c.isVisible(pl0.a(i));
    }

    @Override // sensei0.gl0, sensei0.ol0
    public final void d(View view) {
    }
}
