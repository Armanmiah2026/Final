package sensei0;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class h40 extends ViewGroup.MarginLayoutParams {
    public final Rect a;
    public boolean b;

    public h40(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
        this.b = true;
    }

    public h40(int i, int i2) {
        super(i, i2);
        this.a = new Rect();
        this.b = true;
    }

    public h40(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.a = new Rect();
        this.b = true;
    }

    public h40(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = new Rect();
        this.b = true;
    }

    public h40(h40 h40Var) {
        super((ViewGroup.LayoutParams) h40Var);
        this.a = new Rect();
        this.b = true;
    }
}
