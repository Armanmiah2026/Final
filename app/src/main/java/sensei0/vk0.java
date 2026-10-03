package sensei0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.sensei.tunnel.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vk0 extends yk0 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final fk f = new fk();
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator h = new AccelerateInterpolator(1.5f);

    public static void e(View view) {
        qb qbVarJ = j(view);
        if (qbVarJ != null) {
            ((View) qbVarJ.f).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i));
            }
        }
    }

    public static void f(View view, rl0 rl0Var, boolean z) {
        qb qbVarJ = j(view);
        if (qbVarJ != null) {
            qbVarJ.b = rl0Var;
            if (!z) {
                View view2 = (View) qbVarJ.f;
                int[] iArr = (int[]) qbVarJ.h;
                view2.getLocationOnScreen(iArr);
                z = true;
                qbVarJ.c = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), rl0Var, z);
            }
        }
    }

    public static void g(View view, rl0 rl0Var, List list) {
        qb qbVarJ = j(view);
        if (qbVarJ != null) {
            qbVarJ.a(rl0Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), rl0Var, list);
            }
        }
    }

    public static void h(View view, ii0 ii0Var) {
        qb qbVarJ = j(view);
        if (qbVarJ != null) {
            View view2 = (View) qbVarJ.f;
            int[] iArr = (int[]) qbVarJ.h;
            view2.getLocationOnScreen(iArr);
            int i = qbVarJ.c - iArr[1];
            qbVarJ.d = i;
            view2.setTranslationY(i);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                h(viewGroup.getChildAt(i2), ii0Var);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static qb j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof uk0) {
            return ((uk0) tag).a;
        }
        return null;
    }
}
