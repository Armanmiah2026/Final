package sensei0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class uf0 {
    public final View b;
    public final HashMap a = new HashMap();
    public final ArrayList c = new ArrayList();

    public uf0(View view) {
        this.b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof uf0)) {
            return false;
        }
        uf0 uf0Var = (uf0) obj;
        return this.b == uf0Var.b && this.a.equals(uf0Var.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        String strK = za0.k(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + "\n", "    values:");
        HashMap map = this.a;
        for (String str : map.keySet()) {
            strK = strK + "    " + str + ": " + map.get(str) + "\n";
        }
        return strK;
    }
}
