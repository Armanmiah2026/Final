package sensei0;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class of implements ThreadFactory {
    public final /* synthetic */ int a;
    public final AtomicInteger b;

    public of(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new AtomicInteger(1);
                break;
            case 2:
                this.b = new AtomicInteger(1);
                break;
            default:
                this.b = new AtomicInteger(0);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.a) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.b.getAndIncrement());
                return thread;
            case 1:
                pr.j("r", runnable);
                Thread thread2 = new Thread(runnable, za0.h(this.b.getAndIncrement(), "dnsgw-"));
                thread2.setDaemon(true);
                return thread2;
            default:
                pr.j("r", runnable);
                Thread thread3 = new Thread(runnable, za0.h(this.b.getAndIncrement(), "injector-"));
                thread3.setDaemon(true);
                return thread3;
        }
    }
}
