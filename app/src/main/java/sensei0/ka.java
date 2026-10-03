package sensei0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ka implements ThreadFactory {
    public final /* synthetic */ String a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a);
        thread.setPriority(10);
        return thread;
    }
}
