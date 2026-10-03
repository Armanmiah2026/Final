package sensei0;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gj extends fj implements rf {
    public final Executor c;

    public gj(Executor executor) {
        Method method;
        this.c = executor;
        Method method2 = ma.a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = ma.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.c;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        try {
            this.c.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            bs bsVar = (bs) lcVar.n(mh.p);
            if (bsVar != null) {
                bsVar.b(cancellationException);
            }
            kg.b.e(lcVar, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof gj) && ((gj) obj).c == this.c;
    }

    public final int hashCode() {
        return System.identityHashCode(this.c);
    }

    @Override // sensei0.pc
    public final String toString() {
        return this.c.toString();
    }
}
