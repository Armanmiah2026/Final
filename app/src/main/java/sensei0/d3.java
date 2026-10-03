package sensei0;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d3 {
    public static final LinearInterpolator a = new LinearInterpolator();
    public static final fk b = new fk(fk.d);
    public static final fk c = new fk();
    public static final fk d = new fk(fk.e);

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static float b(float f, float f2, float f3, float f4, float f5) {
        return f5 <= f3 ? f : f5 >= f4 ? f2 : a(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int c(int i, int i2, float f) {
        return Math.round(f * (i2 - i)) + i;
    }
}
