package sensei0;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l6 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public l6(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        if (i > i3) {
            throw new IllegalArgumentException(za0.j("Left must be less than or equal to right, left: ", i, ", right: ", i3).toString());
        }
        if (i2 > i4) {
            throw new IllegalArgumentException(za0.j("top must be less than or equal to bottom, top: ", i2, ", bottom: ", i4).toString());
        }
    }

    public final Rect a() {
        return new Rect(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l6.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        pr.g("null cannot be cast to non-null type androidx.window.core.Bounds", obj);
        l6 l6Var = (l6) obj;
        return this.a == l6Var.a && this.b == l6Var.b && this.c == l6Var.c && this.d == l6Var.d;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(l6.class.getSimpleName());
        sb.append(" { [");
        sb.append(this.a);
        sb.append(',');
        sb.append(this.b);
        sb.append(',');
        sb.append(this.c);
        sb.append(',');
        return za0.n(sb, this.d, "] }");
    }
}
