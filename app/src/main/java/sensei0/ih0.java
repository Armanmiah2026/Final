package sensei0;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ih0 implements Comparable {
    public static final ih0 h;
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final dd0 f = new dd0(new vk(4, this));

    static {
        new ih0("", 0, 0, 0);
        h = new ih0("", 0, 1, 0);
        new ih0("", 1, 0, 0);
    }

    public ih0(String str, int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ih0 ih0Var = (ih0) obj;
        pr.j("other", ih0Var);
        Object objA = this.f.a();
        pr.i("<get-bigInteger>(...)", objA);
        Object objA2 = ih0Var.f.a();
        pr.i("<get-bigInteger>(...)", objA2);
        return ((BigInteger) objA).compareTo((BigInteger) objA2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ih0)) {
            return false;
        }
        ih0 ih0Var = (ih0) obj;
        return this.a == ih0Var.a && this.b == ih0Var.b && this.c == ih0Var.c;
    }

    public final int hashCode() {
        return ((((527 + this.a) * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        String str = this.d;
        String strS = !fc0.l0(str) ? za0.s("-", str) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        return za0.n(sb, this.c, strS);
    }
}
