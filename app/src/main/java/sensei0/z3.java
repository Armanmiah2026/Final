package sensei0;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class z3 extends pr {
    public final /* synthetic */ int n;
    public final /* synthetic */ int o;
    public final /* synthetic */ WeakReference p;
    public final /* synthetic */ e4 q;

    public z3(e4 e4Var, int i, int i2, WeakReference weakReference) {
        this.q = e4Var;
        this.n = i;
        this.o = i2;
        this.p = weakReference;
    }

    @Override // sensei0.pr
    public final void I(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.n) != -1) {
            typeface = d4.a(typeface, i, (this.o & 2) != 0);
        }
        e4 e4Var = this.q;
        if (e4Var.m) {
            e4Var.l = typeface;
            TextView textView = (TextView) this.p.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new a4(textView, typeface, e4Var.j));
                } else {
                    textView.setTypeface(typeface, e4Var.j);
                }
            }
        }
    }

    @Override // sensei0.pr
    public final void H(int i) {
    }
}
