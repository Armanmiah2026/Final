package sensei0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rl0 {
    public static final rl0 b;
    public final ol0 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = nl0.s;
        } else if (i >= 30) {
            b = ll0.r;
        } else {
            b = ol0.b;
        }
    }

    public rl0(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.a = new nl0(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.a = new ml0(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new ll0(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new jl0(this, windowInsets);
        } else if (i >= 28) {
            this.a = new il0(this, windowInsets);
        } else {
            this.a = new hl0(this, windowInsets);
        }
    }

    public static hr b(hr hrVar, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, hrVar.a - i);
        int iMax2 = Math.max(0, hrVar.b - i2);
        int iMax3 = Math.max(0, hrVar.c - i3);
        int iMax4 = Math.max(0, hrVar.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? hrVar : hr.b(iMax, iMax2, iMax3, iMax4);
    }

    public static rl0 d(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        rl0 rl0Var = new rl0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            Field field = ai0.a;
            rl0 rl0VarA = uh0.a(view);
            ol0 ol0Var = rl0Var.a;
            ol0Var.q(rl0VarA);
            ol0Var.d(view.getRootView());
            ol0Var.s(view.getWindowSystemUiVisibility());
        }
        return rl0Var;
    }

    public final int a() {
        return this.a.j().b;
    }

    public final WindowInsets c() {
        ol0 ol0Var = this.a;
        if (ol0Var instanceof gl0) {
            return ((gl0) ol0Var).c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof rl0) {
            return Objects.equals(this.a, ((rl0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        ol0 ol0Var = this.a;
        if (ol0Var == null) {
            return 0;
        }
        return ol0Var.hashCode();
    }

    public rl0() {
        this.a = new ol0(this);
    }
}
