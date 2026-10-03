package sensei0;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u60 extends fj {
    public tc c;

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        tc tcVar = this.c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = tc.p;
        tcVar.b(runnable, id0.g);
    }
}
