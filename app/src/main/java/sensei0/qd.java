package sensei0;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qd implements nd {
    public final ExecutorService a;
    public final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    public final AtomicBoolean c = new AtomicBoolean(false);

    public qd(ExecutorService executorService) {
        this.a = executorService;
    }

    @Override // sensei0.nd
    public final void a(ld ldVar) {
        this.b.add(ldVar);
        this.a.execute(new u2(3, this));
    }
}
