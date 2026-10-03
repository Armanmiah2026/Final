package sensei0;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d7 extends mm0 {
    public final Typeface l;
    public final sv m;
    public boolean n;

    public d7(sv svVar, Typeface typeface) {
        this.l = typeface;
        this.m = svVar;
    }

    @Override // sensei0.mm0
    public final void Q(int i) {
        if (this.n) {
            return;
        }
        n9 n9Var = (n9) this.m.b;
        if (n9Var.j(this.l)) {
            n9Var.h(false);
        }
    }

    @Override // sensei0.mm0
    public final void R(Typeface typeface, boolean z) {
        if (this.n) {
            return;
        }
        n9 n9Var = (n9) this.m.b;
        if (n9Var.j(typeface)) {
            n9Var.h(false);
        }
    }
}
