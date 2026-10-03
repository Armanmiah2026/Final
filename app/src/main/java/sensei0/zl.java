package sensei0;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zl {
    public vl a;
    public em b;
    public nn c;
    public b10 d;
    public u3 e;
    public xl f;
    public boolean g;
    public boolean h;
    public boolean j;
    public Integer k;
    public final wl l = new wl(0, this);
    public boolean i = false;

    public zl(vl vlVar) {
        this.a = vlVar;
    }

    public final void a(jm jmVar) {
        String strC = this.a.c();
        if (strC == null || strC.isEmpty()) {
            strC = (String) ((um) o4.O().b).e.c;
        }
        jd jdVar = new jd(strC, this.a.f());
        String strG = this.a.g();
        if (strG == null) {
            vl vlVar = this.a;
            vlVar.getClass();
            strG = d(vlVar.getIntent());
            if (strG == null) {
                strG = "/";
            }
        }
        jmVar.b = jdVar;
        jmVar.c = strG;
        jmVar.d = (List) this.a.getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    public final void b() {
        if (this.a.j()) {
            throw new AssertionError("The internal FlutterEngine created by " + this.a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
        }
        vl vlVar = this.a;
        vlVar.getClass();
        Log.w("FlutterActivity", "FlutterActivity " + vlVar + " connection to the engine " + vlVar.b.b + " evicted by another attaching activity");
        zl zlVar = vlVar.b;
        if (zlVar != null) {
            zlVar.e();
            vlVar.b.f();
        }
    }

    public final void c() {
        if (this.a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    public final String d(Intent intent) {
        boolean z;
        Uri data;
        vl vlVar = this.a;
        vlVar.getClass();
        try {
            Bundle bundleH = vlVar.h();
            z = (bundleH == null || !bundleH.containsKey("flutter_deeplinking_enabled")) ? true : bundleH.getBoolean("flutter_deeplinking_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            z = false;
        }
        if (!z || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    public final void e() {
        c();
        if (this.f != null) {
            this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
            this.f = null;
        }
        nn nnVar = this.c;
        if (nnVar != null) {
            nnVar.a();
            nn nnVar2 = this.c;
            nnVar2.o.remove(this.l);
        }
    }

    public final void f() {
        if (this.j) {
            c();
            this.a.getClass();
            this.a.getClass();
            vl vlVar = this.a;
            vlVar.getClass();
            if (vlVar.isChangingConfigurations()) {
                zf zfVar = this.b.d;
                if (zfVar.f()) {
                    df0.b("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
                    try {
                        zfVar.a = true;
                        Iterator it = ((HashMap) zfVar.f).values().iterator();
                        while (it.hasNext()) {
                            ((l2) it.next()).f();
                        }
                        zfVar.d();
                        Trace.endSection();
                    } finally {
                    }
                } else {
                    Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
                }
            } else {
                this.b.d.c();
            }
            b10 b10Var = this.d;
            if (b10Var != null) {
                b10Var.b.c = null;
                this.d = null;
            }
            u3 u3Var = this.e;
            if (u3Var != null) {
                ((ws) u3Var.c).b = null;
                u3Var.b = null;
                this.e = null;
            }
            this.a.getClass();
            em emVar = this.b;
            if (emVar != null) {
                ot otVar = emVar.g;
                otVar.a(1, otVar.c);
            }
            if (this.a.j()) {
                em emVar2 = this.b;
                FlutterJNI flutterJNI = emVar2.a;
                Iterator it2 = emVar2.v.iterator();
                while (it2.hasNext()) {
                    ((dm) it2.next()).a();
                }
                zf zfVar2 = emVar2.d;
                zfVar2.e();
                HashMap map = (HashMap) zfVar2.b;
                for (Class cls : new HashSet(map.keySet())) {
                    xm xmVar = (xm) map.get(cls);
                    if (xmVar != null) {
                        df0.b("FlutterEngineConnectionRegistry#remove ".concat(cls.getSimpleName()));
                        try {
                            if (xmVar instanceof l2) {
                                if (zfVar2.f()) {
                                    ((l2) xmVar).b();
                                }
                                ((HashMap) zfVar2.f).remove(cls);
                            }
                            xmVar.e((j1) zfVar2.e);
                            map.remove(cls);
                            Trace.endSection();
                        } finally {
                        }
                    }
                }
                map.clear();
                io.flutter.plugin.platform.c cVar = emVar2.s;
                SparseArray sparseArray = cVar.t;
                while (sparseArray.size() > 0) {
                    cVar.E.r(sparseArray.keyAt(0));
                }
                q10 q10Var = emVar2.t;
                SparseArray sparseArray2 = q10Var.q;
                while (sparseArray2.size() > 0) {
                    q10Var.y.g(sparseArray2.keyAt(0));
                }
                emVar2.c.a.setPlatformMessageHandler(null);
                flutterJNI.removeEngineLifecycleListener(emVar2.x);
                flutterJNI.setDeferredComponentManager(null);
                flutterJNI.detachFromNativeAndReleaseResources();
                o4.O().getClass();
                em.z.remove(Long.valueOf(emVar2.w));
                if (this.a.e() != null) {
                    if (lm.c == null) {
                        lm.c = new lm(1);
                    }
                    lm lmVar = lm.c;
                    lmVar.a.remove(this.a.e());
                }
                this.b = null;
            }
            this.j = false;
        }
    }
}
