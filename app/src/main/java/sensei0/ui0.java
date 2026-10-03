package sensei0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ui0 {
    public static boolean a = true;
    public static Field b;
    public static boolean c;

    public float a(View view) {
        if (a) {
            try {
                return ti0.a(view);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
        return view.getAlpha();
    }

    public abstract void c(boolean z);

    public void d(View view, float f) {
        if (a) {
            try {
                ti0.b(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
        view.setAlpha(f);
    }

    public void e(View view, int i) {
        if (!c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            c = true;
        }
        Field field = b;
        if (field != null) {
            try {
                b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void b(boolean z) {
    }
}
