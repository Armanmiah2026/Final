package sensei0;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gt extends mm0 {
    public final /* synthetic */ int l;
    public final SideSheetBehavior m;

    public /* synthetic */ gt(SideSheetBehavior sideSheetBehavior, int i) {
        this.l = i;
        this.m = sideSheetBehavior;
    }

    @Override // sensei0.mm0
    public final int A(View view) {
        switch (this.l) {
            case 0:
                return view.getRight() + this.m.o;
            default:
                return view.getLeft() - this.m.o;
        }
    }

    @Override // sensei0.mm0
    public final int B(CoordinatorLayout coordinatorLayout) {
        switch (this.l) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // sensei0.mm0
    public final int C() {
        switch (this.l) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // sensei0.mm0
    public final boolean H(float f) {
        switch (this.l) {
            case 0:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // sensei0.mm0
    public final boolean J(View view) {
        switch (this.l) {
            case 0:
                if (view.getRight() < (v() - w()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (v() + this.m.m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // sensei0.mm0
    public final boolean K(float f, float f2) {
        switch (this.l) {
            case 0:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // sensei0.mm0
    public final int e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.l) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // sensei0.mm0
    public final float f(int i) {
        switch (this.l) {
            case 0:
                float fW = w();
                return (i - fW) / (v() - fW);
            default:
                float f = this.m.m;
                return (f - i) / (f - v());
        }
    }

    @Override // sensei0.mm0
    public final boolean h0(View view, float f) {
        switch (this.l) {
            case 0:
                float left = view.getLeft();
                SideSheetBehavior sideSheetBehavior = this.m;
                float fAbs = Math.abs((f * sideSheetBehavior.k) + left);
                sideSheetBehavior.getClass();
                if (fAbs > 0.5f) {
                }
                break;
            default:
                float right = view.getRight();
                SideSheetBehavior sideSheetBehavior2 = this.m;
                float fAbs2 = Math.abs((f * sideSheetBehavior2.k) + right);
                sideSheetBehavior2.getClass();
                if (fAbs2 > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // sensei0.mm0
    public final void n0(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        switch (this.l) {
            case 0:
                if (i <= this.m.m) {
                    marginLayoutParams.leftMargin = i2;
                }
                break;
            default:
                int i3 = this.m.m;
                if (i <= i3) {
                    marginLayoutParams.rightMargin = i3 - i;
                }
                break;
        }
    }

    @Override // sensei0.mm0
    public final int v() {
        switch (this.l) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.m;
                return Math.max(0, sideSheetBehavior.n + sideSheetBehavior.o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.m;
                return Math.max(0, (sideSheetBehavior2.m - sideSheetBehavior2.l) - sideSheetBehavior2.o);
        }
    }

    @Override // sensei0.mm0
    public final int w() {
        switch (this.l) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.m;
                return (-sideSheetBehavior.l) - sideSheetBehavior.o;
            default:
                return this.m.m;
        }
    }

    @Override // sensei0.mm0
    public final int y() {
        switch (this.l) {
            case 0:
                return this.m.o;
            default:
                return this.m.m;
        }
    }

    @Override // sensei0.mm0
    public final int z() {
        switch (this.l) {
            case 0:
                return -this.m.l;
            default:
                return v();
        }
    }
}
