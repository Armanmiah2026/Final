package sensei0;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vn {
    public String a;
    public String b;
    public List c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vn)) {
            return false;
        }
        vn vnVar = (vn) obj;
        return Objects.equals(this.a, vnVar.a) && Objects.equals(this.b, vnVar.b) && Objects.equals(this.c, vnVar.c);
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}
