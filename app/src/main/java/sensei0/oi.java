package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class oi implements lc, Serializable {
    public static final oi a = new oi();

    @Override // sensei0.lc
    public final lc c(kc kcVar) {
        pr.j("key", kcVar);
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // sensei0.lc
    public final lc j(lc lcVar) {
        pr.j("context", lcVar);
        return lcVar;
    }

    @Override // sensei0.lc
    public final jc n(kc kcVar) {
        pr.j("key", kcVar);
        return null;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // sensei0.lc
    public final Object d(Object obj, jp jpVar) {
        return obj;
    }
}
