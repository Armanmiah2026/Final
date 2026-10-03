package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q70 {
    public final String a;
    public final int b;
    public final String c;

    public q70(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q70)) {
            return false;
        }
        q70 q70Var = (q70) obj;
        return pr.b(this.a, q70Var.a) && this.b == q70Var.b && pr.b(this.c, q70Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartTarget(address=");
        sb.append(this.a);
        sb.append(", port=");
        sb.append(this.b);
        sb.append(", mode=");
        return za0.o(sb, this.c, ")");
    }
}
