package sensei0;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class lz extends bd {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lz(g40 g40Var, int i) {
        super(g40Var);
        this.b = i;
    }

    @Override // sensei0.bd
    public final int b(View view) {
        int right;
        int i;
        switch (this.b) {
            case 0:
                h40 h40Var = (h40) view.getLayoutParams();
                ((g40) this.a).getClass();
                right = view.getRight() + ((h40) view.getLayoutParams()).a.right;
                i = ((ViewGroup.MarginLayoutParams) h40Var).rightMargin;
                break;
            default:
                h40 h40Var2 = (h40) view.getLayoutParams();
                ((g40) this.a).getClass();
                right = view.getBottom() + ((h40) view.getLayoutParams()).a.bottom;
                i = ((ViewGroup.MarginLayoutParams) h40Var2).bottomMargin;
                break;
        }
        return right + i;
    }

    @Override // sensei0.bd
    public final int c(View view) {
        int left;
        int i;
        switch (this.b) {
            case 0:
                h40 h40Var = (h40) view.getLayoutParams();
                ((g40) this.a).getClass();
                left = view.getLeft() - ((h40) view.getLayoutParams()).a.left;
                i = ((ViewGroup.MarginLayoutParams) h40Var).leftMargin;
                break;
            default:
                h40 h40Var2 = (h40) view.getLayoutParams();
                ((g40) this.a).getClass();
                left = view.getTop() - ((h40) view.getLayoutParams()).a.top;
                i = ((ViewGroup.MarginLayoutParams) h40Var2).topMargin;
                break;
        }
        return left - i;
    }

    @Override // sensei0.bd
    public final int d() {
        int i;
        int iV;
        switch (this.b) {
            case 0:
                g40 g40Var = (g40) this.a;
                i = g40Var.f;
                iV = g40Var.v();
                break;
            default:
                g40 g40Var2 = (g40) this.a;
                i = g40Var2.g;
                iV = g40Var2.t();
                break;
        }
        return i - iV;
    }

    @Override // sensei0.bd
    public final int e() {
        switch (this.b) {
            case 0:
                return ((g40) this.a).u();
            default:
                return ((g40) this.a).w();
        }
    }

    @Override // sensei0.bd
    public final int f() {
        int iU;
        int iV;
        switch (this.b) {
            case 0:
                g40 g40Var = (g40) this.a;
                iU = g40Var.f - g40Var.u();
                iV = g40Var.v();
                break;
            default:
                g40 g40Var2 = (g40) this.a;
                iU = g40Var2.g - g40Var2.w();
                iV = g40Var2.t();
                break;
        }
        return iU - iV;
    }
}
