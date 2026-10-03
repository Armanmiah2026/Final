package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a20 {
    public final String a;

    public a20(String str) {
        pr.j("name", str);
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a20)) {
            return false;
        }
        return pr.b(this.a, ((a20) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
