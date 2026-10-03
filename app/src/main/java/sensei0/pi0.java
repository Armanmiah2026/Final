package sensei0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pi0 {
    public static final zi0 a;
    public static final r7 b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new aj0();
        } else {
            a = new zi0();
        }
        b = new r7(Float.class, "translationAlpha", 6);
        new r7(Rect.class, "clipBounds", 7);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.f(view, i, i2, i3, i4);
    }

    public static void b(View view, int i) {
        a.e(view, i);
    }
}
