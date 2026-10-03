package sensei0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class jl0 extends il0 {
    public hr o;
    public hr p;
    public hr q;

    public jl0(rl0 rl0Var, WindowInsets windowInsets) {
        super(rl0Var, windowInsets);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override // sensei0.ol0
    public hr g() {
        if (this.p == null) {
            this.p = hr.c(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override // sensei0.ol0
    public hr i() {
        if (this.o == null) {
            this.o = hr.c(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override // sensei0.ol0
    public hr k() {
        if (this.q == null) {
            this.q = hr.c(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override // sensei0.gl0, sensei0.ol0
    public rl0 l(int i, int i2, int i3, int i4) {
        return rl0.d(null, this.c.inset(i, i2, i3, i4));
    }

    @Override // sensei0.hl0, sensei0.ol0
    public void r(hr hrVar) {
    }
}
