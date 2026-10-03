package sensei0;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class id0 {
    public static final String a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static final mh f;
    public static final xs g;
    public static final xs h;

    static {
        String property;
        int i = ed0.a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        a = property;
        b = pr.T("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i2 = ed0.a;
        if (i2 < 2) {
            i2 = 2;
        }
        c = pr.U(i2, "kotlinx.coroutines.scheduler.core.pool.size", 8);
        d = pr.U(2097150, "kotlinx.coroutines.scheduler.max.pool.size", 4);
        e = TimeUnit.SECONDS.toNanos(pr.T("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f = mh.q;
        g = new xs(0);
        h = new xs(1);
    }
}
