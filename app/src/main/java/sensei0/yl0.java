package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yl0 {
    public final l6 a;
    public final rl0 b;

    public yl0(l6 l6Var, rl0 rl0Var) {
        pr.j("_windowInsetsCompat", rl0Var);
        this.a = l6Var;
        this.b = rl0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!yl0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        pr.g("null cannot be cast to non-null type androidx.window.layout.WindowMetrics", obj);
        yl0 yl0Var = (yl0) obj;
        return pr.b(this.a, yl0Var.a) && pr.b(this.b, yl0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.a + ", windowInsetsCompat=" + this.b + ')';
    }
}
