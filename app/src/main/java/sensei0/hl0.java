package sensei0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class hl0 extends gl0 {
    public hr n;

    public hl0(rl0 rl0Var, WindowInsets windowInsets) {
        super(rl0Var, windowInsets);
        this.n = null;
    }

    @Override // sensei0.ol0
    public rl0 b() {
        return rl0.d(null, this.c.consumeStableInsets());
    }

    @Override // sensei0.ol0
    public rl0 c() {
        return rl0.d(null, this.c.consumeSystemWindowInsets());
    }

    @Override // sensei0.ol0
    public final hr h() {
        if (this.n == null) {
            WindowInsets windowInsets = this.c;
            this.n = hr.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.n;
    }

    @Override // sensei0.ol0
    public boolean m() {
        return this.c.isConsumed();
    }

    @Override // sensei0.ol0
    public void r(hr hrVar) {
        this.n = hrVar;
    }
}
