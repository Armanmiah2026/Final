package sensei0;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jd0 extends pr {
    public final /* synthetic */ mm0 n;
    public final /* synthetic */ ld0 o;

    public jd0(ld0 ld0Var, mm0 mm0Var) {
        this.o = ld0Var;
        this.n = mm0Var;
    }

    @Override // sensei0.pr
    public final void H(int i) {
        this.o.m = true;
        this.n.Q(i);
    }

    @Override // sensei0.pr
    public final void I(Typeface typeface) {
        ld0 ld0Var = this.o;
        ld0Var.n = Typeface.create(typeface, ld0Var.c);
        ld0Var.m = true;
        this.n.R(ld0Var.n, false);
    }
}
