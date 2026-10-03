package sensei0;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ix {
    public Boolean a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ix.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((ix) obj).a);
    }

    public final int hashCode() {
        return Objects.hash(this.a);
    }
}
