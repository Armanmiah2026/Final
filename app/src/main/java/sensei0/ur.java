package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ur extends ds {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(ur.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;
    public final or e;

    public ur(or orVar) {
        this.e = orVar;
    }

    @Override // sensei0.or
    public final void d(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.d(th);
        }
    }
}
