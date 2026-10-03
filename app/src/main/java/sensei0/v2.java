package sensei0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v2 {
    public final sv a;
    public final WeakHashMap b = new WeakHashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final ReferenceQueue e = new ReferenceQueue();
    public final HashMap f = new HashMap();
    public final Handler g;
    public final u2 h;
    public long i;
    public boolean j;
    public final long k;

    public v2(sv svVar) {
        this.a = svVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.g = handler;
        u2 u2Var = new u2(0, this);
        this.h = u2Var;
        this.i = 65536L;
        this.k = 3000L;
        handler.postDelayed(u2Var, 3000L);
    }

    public final void a(long j, Object obj) {
        pr.j("instance", obj);
        f();
        c(j, obj);
    }

    public final long b(Object obj) {
        pr.j("instance", obj);
        f();
        if (!d(obj)) {
            long j = this.i;
            this.i = 1 + j;
            c(j, obj);
            return j;
        }
        throw new IllegalArgumentException(("Instance of " + obj.getClass() + " has already been added.").toString());
    }

    public final void c(long j, Object obj) {
        if (j < 0) {
            throw new IllegalArgumentException(("Identifier must be >= 0: " + j).toString());
        }
        Long lValueOf = Long.valueOf(j);
        HashMap map = this.c;
        if (map.containsKey(lValueOf)) {
            throw new IllegalArgumentException(("Identifier has already been added: " + j).toString());
        }
        WeakReference weakReference = new WeakReference(obj, this.e);
        this.b.put(obj, Long.valueOf(j));
        map.put(Long.valueOf(j), weakReference);
        this.f.put(weakReference, Long.valueOf(j));
        this.d.put(Long.valueOf(j), obj);
    }

    public final boolean d(Object obj) {
        f();
        return this.b.containsKey(obj);
    }

    public final Object e(long j) {
        f();
        WeakReference weakReference = (WeakReference) this.c.get(Long.valueOf(j));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void f() {
        if (this.j) {
            Log.w("PigeonInstanceManager", "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }
}
