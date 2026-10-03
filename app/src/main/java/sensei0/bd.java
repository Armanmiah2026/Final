package sensei0;

import android.graphics.Rect;
import android.view.View;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bd {
    public final Object a;

    public bd() {
        this.a = new LinkedHashMap();
    }

    public static bd a(g40 g40Var, int i) {
        if (i == 0) {
            return new lz(g40Var, 0);
        }
        if (i == 1) {
            return new lz(g40Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public bd(g40 g40Var) {
        new Rect();
        this.a = g40Var;
    }
}
