package sensei0;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wl0 {
    public final Object a;

    public wl0(List list) {
        this.a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !wl0.class.equals(obj.getClass())) {
            return false;
        }
        return this.a.equals(((wl0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return o9.m0((Collection) this.a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
