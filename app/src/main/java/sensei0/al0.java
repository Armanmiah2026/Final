package sensei0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class al0 extends fl0 {
    public static Field e = null;
    public static boolean f = false;
    public static Constructor g = null;
    public static boolean h = false;
    public WindowInsets c;
    public hr d;

    public al0() {
        this.c = i();
    }

    private static WindowInsets i() {
        if (!f) {
            try {
                e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f = true;
        }
        Field field = e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!h) {
            try {
                g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            h = true;
        }
        Constructor constructor = g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // sensei0.fl0
    public rl0 b() {
        a();
        rl0 rl0VarD = rl0.d(null, this.c);
        hr[] hrVarArr = this.b;
        ol0 ol0Var = rl0VarD.a;
        ol0Var.p(hrVarArr);
        ol0Var.r(this.d);
        return rl0VarD;
    }

    @Override // sensei0.fl0
    public void e(hr hrVar) {
        this.d = hrVar;
    }

    @Override // sensei0.fl0
    public void g(hr hrVar) {
        WindowInsets windowInsets = this.c;
        if (windowInsets != null) {
            this.c = windowInsets.replaceSystemWindowInsets(hrVar.a, hrVar.b, hrVar.c, hrVar.d);
        }
    }

    public al0(rl0 rl0Var) {
        super(rl0Var);
        this.c = rl0Var.c();
    }
}
