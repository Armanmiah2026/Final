package sensei0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rd implements a6, y00 {
    public final FlutterJNI a;
    public final HashMap b;
    public final HashMap c;
    public final Object d;
    public final AtomicBoolean f;
    public final HashMap h;
    public int o;
    public final c10 p;
    public final WeakHashMap q;
    public final sv r;

    public rd(FlutterJNI flutterJNI) {
        sv svVar = new sv(16);
        svVar.b = (ExecutorService) o4.O().d;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new Object();
        this.f = new AtomicBoolean(false);
        this.h = new HashMap();
        this.o = 1;
        this.p = new c10();
        this.q = new WeakHashMap();
        this.a = flutterJNI;
        this.r = svVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [sensei0.ld] */
    public final void a(final String str, final od odVar, final ByteBuffer byteBuffer, final int i, final long j) {
        nd ndVar = odVar != null ? odVar.b : null;
        String strA = df0.a("PlatformChannel ScheduleHandler on " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            bf0.a(i, mm0.l0(strA));
        } else {
            String strL0 = mm0.l0(strA);
            try {
                if (mm0.j == null) {
                    mm0.j = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                mm0.j.invoke(null, Long.valueOf(mm0.h), strL0, Integer.valueOf(i));
            } catch (Exception e) {
                mm0.F("asyncTraceBegin", e);
            }
        }
        Runnable r0 = new Runnable() { // from class: sensei0.ld
            @Override // java.lang.Runnable
            public final void run() {
                long j2 = j;
                FlutterJNI flutterJNI = this.a.a;
                StringBuilder sb = new StringBuilder("PlatformChannel ScheduleHandler on ");
                String str2 = str;
                sb.append(str2);
                String strA2 = df0.a(sb.toString());
                int i2 = Build.VERSION.SDK_INT;
                int i3 = i;
                if (i2 >= 29) {
                    bf0.b(i3, mm0.l0(strA2));
                } else {
                    String strL02 = mm0.l0(strA2);
                    try {
                        if (mm0.k == null) {
                            mm0.k = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                        }
                        mm0.k.invoke(null, Long.valueOf(mm0.h), strL02, Integer.valueOf(i3));
                    } catch (Exception e2) {
                        mm0.F("asyncTraceEnd", e2);
                    }
                }
                try {
                    df0.b("DartMessenger#handleMessageFromDart on " + str2);
                    od odVar2 = odVar;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    try {
                        if (odVar2 != null) {
                            try {
                                try {
                                    odVar2.a.u(byteBuffer2, new pd(flutterJNI, i3));
                                } catch (Exception e3) {
                                    Log.e("DartMessenger", "Uncaught exception in binary message listener", e3);
                                    flutterJNI.invokePlatformMessageEmptyResponseCallback(i3);
                                }
                            } catch (Error e4) {
                                Thread threadCurrentThread = Thread.currentThread();
                                if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
                                    throw e4;
                                }
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e4);
                            }
                        } else {
                            flutterJNI.invokePlatformMessageEmptyResponseCallback(i3);
                        }
                        if (byteBuffer2 != null && byteBuffer2.isDirect()) {
                            byteBuffer2.limit(0);
                        }
                        Trace.endSection();
                    } finally {
                    }
                } finally {
                    flutterJNI.cleanupMessageData(j2);
                }
            }
        };
        nd ndVar2 = ndVar;
        if (ndVar == null) {
            ndVar2 = this.p;
        }
        ndVar2.a(r0);
    }

    @Override // sensei0.a6
    public final void b(String str, y5 y5Var) {
        t(str, y5Var, null);
    }

    @Override // sensei0.a6
    public final mh i(mh mhVar) {
        sv svVar = this.r;
        svVar.getClass();
        qd qdVar = new qd((ExecutorService) svVar.b);
        mh mhVar2 = new mh(28);
        this.q.put(mhVar2, qdVar);
        return mhVar2;
    }

    @Override // sensei0.a6
    public final void n(String str, ByteBuffer byteBuffer) {
        p(str, byteBuffer, null);
    }

    @Override // sensei0.a6
    public final void p(String str, ByteBuffer byteBuffer, z5 z5Var) {
        df0.b("DartMessenger#send on " + str);
        try {
            int i = this.o;
            this.o = i + 1;
            if (z5Var != null) {
                this.h.put(Integer.valueOf(i), z5Var);
            }
            FlutterJNI flutterJNI = this.a;
            if (byteBuffer == null) {
                flutterJNI.dispatchEmptyPlatformMessage(str, i);
            } else {
                flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // sensei0.a6
    public final void t(String str, y5 y5Var, mh mhVar) {
        nd ndVar;
        if (y5Var == null) {
            synchronized (this.d) {
                this.b.remove(str);
            }
            return;
        }
        if (mhVar != null) {
            ndVar = (nd) this.q.get(mhVar);
            if (ndVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            ndVar = null;
        }
        synchronized (this.d) {
            try {
                this.b.put(str, new od(y5Var, ndVar));
                List<md> list = (List) this.c.remove(str);
                if (list == null) {
                    return;
                }
                for (md mdVar : list) {
                    a(str, (od) this.b.get(str), mdVar.a, mdVar.b, mdVar.c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
