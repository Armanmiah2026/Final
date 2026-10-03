package sensei0;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class zi0 extends ui0 {
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g = true;

    @Override // sensei0.ui0
    public void e(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.e(view, i);
        } else if (g) {
            try {
                yi0.a(view, i);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        if (f) {
            try {
                wi0.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }

    public void g(View view, Matrix matrix) {
        if (d) {
            try {
                vi0.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                d = false;
            }
        }
    }

    public void h(View view, Matrix matrix) {
        if (e) {
            try {
                vi0.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }
}
