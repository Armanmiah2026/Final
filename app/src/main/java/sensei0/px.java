package sensei0;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class px {
    public Boolean a;
    public Boolean b;
    public Map c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && px.class == obj.getClass()) {
            px pxVar = (px) obj;
            if (this.a.equals(pxVar.a) && this.b.equals(pxVar.b) && this.c.equals(pxVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}
