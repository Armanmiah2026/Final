package sensei0;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements ic {
    public final ic a;
    public final float b;

    public n2(float f, ic icVar) {
        while (icVar instanceof n2) {
            icVar = ((n2) icVar).a;
            f += ((n2) icVar).b;
        }
        this.a = icVar;
        this.b = f;
    }

    @Override // sensei0.ic
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.a.equals(n2Var.a) && this.b == n2Var.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
