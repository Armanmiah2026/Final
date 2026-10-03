package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v50 implements Serializable {
    public final Object a;

    public static final Throwable a(Object obj) {
        if (obj instanceof u50) {
            return ((u50) obj).a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v50) {
            return pr.b(this.a, ((v50) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.a;
        if (obj instanceof u50) {
            return ((u50) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
