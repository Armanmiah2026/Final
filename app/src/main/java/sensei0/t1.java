package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {
    public final View a;
    public final int b;

    public t1(View view, int i) {
        this.a = view;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.b == t1Var.b && this.a.equals(t1Var.a);
    }

    public final int hashCode() {
        return ((this.a.hashCode() + 31) * 31) + this.b;
    }
}
