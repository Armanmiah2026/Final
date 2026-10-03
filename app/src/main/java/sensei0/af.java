package sensei0;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class af extends cj implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final af r;
    public static final long s;

    static {
        Long l;
        af afVar = new af();
        r = afVar;
        afVar.i(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        s = timeUnit.toNanos(l.longValue());
    }

    @Override // sensei0.dj
    public final Thread h() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(af.class.getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // sensei0.cj
    public final void m(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.m(runnable);
    }

    public final synchronized void p() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            cj.o.set(this, null);
            cj.p.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zO;
        ie0.a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (zO) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jK = k();
                    if (jK == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = s + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            p();
                            if (o()) {
                                return;
                            }
                            h();
                            return;
                        }
                        if (jK > j2) {
                            jK = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jK > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            p();
                            if (o()) {
                                return;
                            }
                            h();
                            return;
                        }
                        LockSupport.parkNanos(this, jK);
                    }
                }
            }
        } finally {
            _thread = null;
            p();
            if (!o()) {
                h();
            }
        }
    }

    @Override // sensei0.cj, sensei0.dj
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
