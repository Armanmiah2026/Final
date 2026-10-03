package sensei0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class th0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static rl0 b(View view, rl0 rl0Var, Rect rect) {
        WindowInsets windowInsetsC = rl0Var.c();
        if (windowInsetsC != null) {
            return rl0.d(view, view.computeSystemWindowInsets(windowInsetsC, rect));
        }
        rect.setEmpty();
        return rl0Var;
    }

    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    public static float e(View view) {
        return view.getElevation();
    }

    public static String f(View view) {
        return view.getTransitionName();
    }

    public static float g(View view) {
        return view.getZ();
    }

    public static boolean h(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void i(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void j(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void k(View view, float f) {
        view.setElevation(f);
    }

    public static void l(View view, wy wyVar) {
        sh0 sh0Var = wyVar != null ? new sh0(view, wyVar) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, sh0Var);
        }
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (sh0Var != null) {
            view.setOnApplyWindowInsetsListener(sh0Var);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }

    public static void m(View view) {
        view.stopNestedScroll();
    }
}
