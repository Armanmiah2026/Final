package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u50 implements Serializable {
    public final Throwable a;

    public u50(Throwable th) {
        pr.j("exception", th);
        this.a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u50) {
            return pr.b(this.a, ((u50) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.a + ')';
    }
}
