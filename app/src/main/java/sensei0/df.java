package sensei0;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class df extends fj implements Executor {
    public static final df c = new df();
    public static final pc d;

    static {
        pc xtVar = pg0.c;
        int i = ed0.a;
        if (64 >= i) {
            i = 64;
        }
        int iU = pr.U(i, "kotlinx.coroutines.io.parallelism", 12);
        xtVar.getClass();
        if (iU < 1) {
            throw new IllegalArgumentException(za0.h(iU, "Expected positive parallelism level, but got ").toString());
        }
        if (iU < id0.d) {
            if (iU < 1) {
                throw new IllegalArgumentException(za0.h(iU, "Expected positive parallelism level, but got ").toString());
            }
            xtVar = new xt(xtVar, iU);
        }
        d = xtVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        d.e(lcVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        e(oi.a, runnable);
    }

    @Override // sensei0.pc
    public final String toString() {
        return "Dispatchers.IO";
    }
}
