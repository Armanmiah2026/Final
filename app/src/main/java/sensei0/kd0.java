package sensei0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kd0 extends mm0 {
    public final /* synthetic */ Context l;
    public final /* synthetic */ TextPaint m;
    public final /* synthetic */ mm0 n;
    public final /* synthetic */ ld0 o;

    public kd0(ld0 ld0Var, Context context, TextPaint textPaint, mm0 mm0Var) {
        this.o = ld0Var;
        this.l = context;
        this.m = textPaint;
        this.n = mm0Var;
    }

    @Override // sensei0.mm0
    public final void Q(int i) {
        this.n.Q(i);
    }

    @Override // sensei0.mm0
    public final void R(Typeface typeface, boolean z) {
        this.o.g(this.l, this.m, typeface);
        this.n.R(typeface, z);
    }
}
