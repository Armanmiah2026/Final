package sensei0;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class om implements ThreadFactory {
    public int a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("flutter-worker-");
        int i = this.a;
        this.a = i + 1;
        sb.append(i);
        thread.setName(sb.toString());
        return thread;
    }
}
