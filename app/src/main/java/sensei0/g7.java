package sensei0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g7 extends ga {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(g7.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public g7(f7 f7Var, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + f7Var + " was cancelled normally");
        }
        super(th, z);
        this._resumed$volatile = 0;
    }
}
