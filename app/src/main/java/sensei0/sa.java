package sensei0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sa implements u70 {
    public final AtomicReference a;

    public sa(u70 u70Var) {
        this.a = new AtomicReference(u70Var);
    }

    @Override // sensei0.u70
    public final Iterator iterator() {
        u70 u70Var = (u70) this.a.getAndSet(null);
        if (u70Var != null) {
            return u70Var.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
