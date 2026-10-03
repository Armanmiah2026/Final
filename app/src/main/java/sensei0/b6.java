package sensei0;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b6 extends g {
    public final Thread d;
    public final dj f;

    public b6(lc lcVar, Thread thread, dj djVar) {
        super(lcVar, true);
        this.d = thread;
        this.f = djVar;
    }

    @Override // sensei0.ls
    public final void p(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.d;
        if (pr.b(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
