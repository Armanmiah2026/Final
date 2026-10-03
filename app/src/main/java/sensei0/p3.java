package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p3 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static p3 c;
    public p50 a;

    public static synchronized PorterDuffColorFilter b(int i, PorterDuff.Mode mode) {
        return p50.e(i, mode);
    }

    public static synchronized void c() {
        if (c == null) {
            p3 p3Var = new p3();
            c = p3Var;
            p3Var.a = p50.b();
            p50 p50Var = c.a;
            o3 o3Var = new o3();
            synchronized (p50Var) {
                p50Var.e = o3Var;
            }
        }
    }

    public static void d(Drawable drawable, r60 r60Var, int[] iArr) {
        PorterDuff.Mode mode = p50.f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = r60Var.b;
        if (!z && !r60Var.a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z ? (ColorStateList) r60Var.c : null;
        PorterDuff.Mode mode2 = r60Var.a ? (PorterDuff.Mode) r60Var.d : p50.f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = p50.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable a(Context context, int i) {
        return this.a.c(context, i);
    }
}
