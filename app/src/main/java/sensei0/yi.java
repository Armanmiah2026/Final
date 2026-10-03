package sensei0;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yi {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final /* synthetic */ o4 b;

    public yi(o4 o4Var) {
        this.b = o4Var;
    }

    public final void a(Object obj) {
        if (this.a.get()) {
            return;
        }
        o4 o4Var = this.b;
        if (((AtomicReference) o4Var.c).get() != this) {
            return;
        }
        aj ajVar = (aj) o4Var.d;
        ajVar.a.n(ajVar.b, ajVar.c.c(obj));
    }
}
