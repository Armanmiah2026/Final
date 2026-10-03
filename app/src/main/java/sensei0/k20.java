package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k20 implements Comparable {
    public ab0 a;
    public final /* synthetic */ l20 b;

    public k20(l20 l20Var) {
        this.b = l20Var;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.a.b - ((ab0) obj).b;
    }

    public final String toString() {
        String str = "[ ";
        if (this.a != null) {
            for (int i = 0; i < 9; i++) {
                str = str + this.a.h[i] + " ";
            }
        }
        return str + "] " + this.a;
    }
}
