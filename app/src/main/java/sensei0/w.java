package sensei0;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w implements Future {
    public static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger f = Logger.getLogger(w.class.getName());
    public static final mm0 h;
    public static final Object o;
    public volatile Object a;
    public volatile s b;
    public volatile v c;

    static {
        mm0 uVar;
        try {
            uVar = new t(AtomicReferenceFieldUpdater.newUpdater(v.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(v.class, v.class, "b"), AtomicReferenceFieldUpdater.newUpdater(w.class, v.class, "c"), AtomicReferenceFieldUpdater.newUpdater(w.class, s.class, "b"), AtomicReferenceFieldUpdater.newUpdater(w.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            uVar = new u();
        }
        h = uVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        o = new Object();
    }

    public static void b(w wVar) {
        v vVar;
        s sVar;
        do {
            vVar = wVar.c;
        } while (!h.i(wVar, vVar, v.c));
        while (vVar != null) {
            Thread thread = vVar.a;
            if (thread != null) {
                vVar.a = null;
                LockSupport.unpark(thread);
            }
            vVar = vVar.b;
        }
        do {
            sVar = wVar.b;
        } while (!h.g(wVar, sVar));
        s sVar2 = null;
        while (sVar != null) {
            s sVar3 = sVar.a;
            sVar.a = sVar2;
            sVar2 = sVar;
            sVar = sVar3;
        }
        while (sVar2 != null) {
            sVar2 = sVar2.a;
            try {
                throw null;
            } catch (RuntimeException e) {
                f.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e);
            }
        }
    }

    public static Object c(Object obj) throws ExecutionException {
        if (obj instanceof q) {
            Throwable th = ((q) obj).a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof r) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == o) {
            return null;
        }
        return obj;
    }

    public static Object d(w wVar) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = wVar.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objD = d(this);
            sb.append("SUCCESS, result=[");
            sb.append(objD == this ? "this future" : String.valueOf(objD));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (obj != null) {
            return false;
        }
        if (!h.h(this, obj, d ? new q(new CancellationException("Future.cancel() was called."), z) : z ? q.b : q.c)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(v vVar) {
        vVar.a = null;
        while (true) {
            v vVar2 = this.c;
            if (vVar2 == v.c) {
                return;
            }
            v vVar3 = null;
            while (vVar2 != null) {
                v vVar4 = vVar2.b;
                if (vVar2.a != null) {
                    vVar3 = vVar2;
                } else if (vVar3 != null) {
                    vVar3.b = vVar4;
                    if (vVar3.a == null) {
                        break;
                    }
                } else if (!h.i(this, vVar2, vVar4)) {
                    break;
                }
                vVar2 = vVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        v vVar = v.c;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if (obj != null) {
            return c(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            v vVar2 = this.c;
            if (vVar2 != vVar) {
                v vVar3 = new v();
                do {
                    mm0 mm0Var = h;
                    mm0Var.X(vVar3, vVar2);
                    if (mm0Var.i(this, vVar2, vVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(vVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if (obj2 != null) {
                                return c(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        e(vVar3);
                    } else {
                        vVar2 = this.c;
                    }
                } while (vVar2 != vVar);
            }
            return c(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if (obj3 != null) {
                return c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strK = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strK2 = za0.k(strK, " (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strK3 = strK2 + jConvert + " " + lowerCase;
                if (z) {
                    strK3 = za0.k(strK3, ",");
                }
                strK2 = za0.k(strK3, " ");
            }
            if (z) {
                strK2 = strK2 + nanos2 + " nanoseconds ";
            }
            strK = za0.k(strK2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(za0.k(strK, " but future completed as timeout expired"));
        }
        throw new TimeoutException(strK + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a instanceof q;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.a instanceof q) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        v vVar = v.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if (obj2 != null) {
                return c(obj2);
            }
            v vVar2 = this.c;
            if (vVar2 != vVar) {
                v vVar3 = new v();
                do {
                    mm0 mm0Var = h;
                    mm0Var.X(vVar3, vVar2);
                    if (mm0Var.i(this, vVar2, vVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                e(vVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return c(obj);
                    }
                    vVar2 = this.c;
                } while (vVar2 != vVar);
            }
            return c(this.a);
        }
        throw new InterruptedException();
    }
}
