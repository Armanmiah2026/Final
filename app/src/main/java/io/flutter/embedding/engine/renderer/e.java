package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$ImageTextureEntry;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import sensei0.ad0;
import sensei0.an;
import sensei0.ee0;
import sensei0.hn;
import sensei0.wl;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final FlutterJNI a;
    public Surface c;
    public final wl h;
    public final AtomicLong b = new AtomicLong(0);
    public boolean d = false;
    public final Handler e = new Handler();
    public final HashSet f = new HashSet();
    public final ArrayList g = new ArrayList();

    public e(FlutterJNI flutterJNI) {
        wl wlVar = new wl(1, this);
        this.h = wlVar;
        this.a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(wlVar);
    }

    public final void a(hn hnVar) {
        this.a.addIsDisplayingFlutterUiListener(hnVar);
        if (this.d) {
            hnVar.b();
        }
    }

    public final void b(ee0 ee0Var) {
        HashSet hashSet = this.f;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ee0) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
        hashSet.add(new WeakReference(ee0Var));
    }

    public final TextureRegistry$ImageTextureEntry c() {
        FlutterRenderer$ImageTextureRegistryEntry flutterRenderer$ImageTextureRegistryEntry = new FlutterRenderer$ImageTextureRegistryEntry(this, this.b.getAndIncrement());
        flutterRenderer$ImageTextureRegistryEntry.id();
        this.a.registerImageTexture(flutterRenderer$ImageTextureRegistryEntry.id(), flutterRenderer$ImageTextureRegistryEntry, false);
        return flutterRenderer$ImageTextureRegistryEntry;
    }

    public final TextureRegistry$SurfaceProducer d(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || (i2 <= 29 && "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER))) {
            an anVarE = e();
            return new ad0(anVarE.a, this.e, this.a, anVarE);
        }
        long andIncrement = this.b.getAndIncrement();
        FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = new FlutterRenderer$ImageReaderSurfaceProducer(this, andIncrement);
        boolean z = i == 2;
        this.a.registerImageTexture(andIncrement, flutterRenderer$ImageReaderSurfaceProducer, z);
        if (z) {
            b(flutterRenderer$ImageReaderSurfaceProducer);
        }
        this.g.add(flutterRenderer$ImageReaderSurfaceProducer);
        return flutterRenderer$ImageReaderSurfaceProducer;
    }

    public final an e() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        long andIncrement = this.b.getAndIncrement();
        surfaceTexture.detachFromGLContext();
        an anVar = new an(this, andIncrement, surfaceTexture);
        this.a.registerTexture(anVar.a, anVar.b);
        b(anVar);
        return anVar;
    }

    public final void f(int i) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ee0 ee0Var = (ee0) ((WeakReference) it.next()).get();
            if (ee0Var != null) {
                ee0Var.onTrimMemory(i);
            } else {
                it.remove();
            }
        }
    }

    public final void g(hn hnVar) {
        this.a.removeIsDisplayingFlutterUiListener(hnVar);
    }

    public final void h(ee0 ee0Var) {
        HashSet<WeakReference> hashSet = this.f;
        for (WeakReference weakReference : hashSet) {
            if (weakReference.get() == ee0Var) {
                hashSet.remove(weakReference);
                return;
            }
        }
    }

    public final void i() {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((FlutterRenderer$ImageReaderSurfaceProducer) obj).getClass();
        }
    }

    public final void j() {
        if (this.c != null) {
            this.a.onSurfaceDestroyed();
            if (this.d) {
                this.h.a();
            }
            this.d = false;
            this.c = null;
        }
    }
}
