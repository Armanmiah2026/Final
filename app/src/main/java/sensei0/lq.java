package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class lq {
    public final l6 a;
    public final tn b;
    public final tn c;

    public lq(l6 l6Var, tn tnVar, tn tnVar2) {
        int i = l6Var.b;
        this.a = l6Var;
        this.b = tnVar;
        this.c = tnVar2;
        int i2 = l6Var.c;
        int i3 = l6Var.a;
        if (i2 - i3 == 0 && l6Var.d - i == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i3 != 0 && i != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!lq.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        pr.g("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature", obj);
        lq lqVar = (lq) obj;
        return pr.b(this.a, lqVar.a) && pr.b(this.b, lqVar.b) && pr.b(this.c, lqVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return lq.class.getSimpleName() + " { " + this.a + ", type=" + this.b + ", state=" + this.c + " }";
    }
}
