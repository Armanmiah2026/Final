package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vf0 implements Serializable {
    public final Object a;
    public final Object b;
    public final Serializable c;

    public vf0(Object obj, Object obj2, Serializable serializable) {
        this.a = obj;
        this.b = obj2;
        this.c = serializable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vf0)) {
            return false;
        }
        vf0 vf0Var = (vf0) obj;
        return this.a.equals(vf0Var.a) && pr.b(this.b, vf0Var.b) && this.c.equals(vf0Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Object obj = this.b;
        return this.c.hashCode() + ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31);
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ')';
    }
}
