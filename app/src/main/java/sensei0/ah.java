package sensei0;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ah {
    public static final int[] a = {R.attr.state_checked};
    public static final int[] b = new int[0];
    public static final Rect c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        if (i < 29 || i >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(a);
        } else {
            drawable.setState(b);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect b(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Insets insetsA = xg.a(drawable);
            return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
        }
        boolean z = drawable instanceof jm0;
        Object obj = drawable;
        if (z) {
            ((km0) ((jm0) drawable)).getClass();
            obj = null;
        }
        if (i >= 29) {
            boolean z2 = wg.a;
        } else if (wg.a) {
            try {
                Object objInvoke = wg.b.invoke(obj, null);
                if (objInvoke != null) {
                    return new Rect(wg.c.getInt(objInvoke), wg.d.getInt(objInvoke), wg.e.getInt(objInvoke), wg.f.getInt(objInvoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return c;
    }

    public static PorterDuff.Mode c(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
