package sensei0;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p4 extends wf0 {
    public static volatile p4 g;
    public final Object f;

    public p4(int i) {
        switch (i) {
            case 1:
                this.f = new Object();
                Executors.newFixedThreadPool(4, new of(0));
                break;
            default:
                this.f = new p4(1);
                break;
        }
    }

    public static p4 K() {
        if (g != null) {
            return g;
        }
        synchronized (p4.class) {
            try {
                if (g == null) {
                    g = new p4(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return g;
    }
}
