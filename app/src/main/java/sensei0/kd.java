package sensei0;

import android.content.res.AssetManager;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kd implements a6 {
    public final FlutterJNI a;
    public final AssetManager b;
    public final long c;
    public final rd d;
    public final sv f;
    public boolean h;

    public kd(FlutterJNI flutterJNI, AssetManager assetManager, long j) {
        this.h = false;
        mh mhVar = new mh(this);
        this.a = flutterJNI;
        this.b = assetManager;
        this.c = j;
        rd rdVar = new rd(flutterJNI);
        this.d = rdVar;
        rdVar.t("flutter/isolate", mhVar, null);
        this.f = new sv(15, rdVar);
        if (flutterJNI.isAttached()) {
            this.h = true;
        }
    }

    public final void a(jd jdVar, List list) {
        if (this.h) {
            Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        df0.b("DartExecutor#executeDartEntrypoint");
        try {
            Objects.toString(jdVar);
            this.a.runBundleAndSnapshotFromLibrary(jdVar.a, jdVar.c, jdVar.b, this.b, list, this.c);
            this.h = true;
            Trace.endSection();
        } finally {
        }
    }

    @Override // sensei0.a6
    public final void b(String str, y5 y5Var) {
        this.f.b(str, y5Var);
    }

    @Override // sensei0.a6
    public final mh i(mh mhVar) {
        return ((rd) this.f.b).i(mhVar);
    }

    @Override // sensei0.a6
    public final void n(String str, ByteBuffer byteBuffer) {
        this.f.n(str, byteBuffer);
    }

    @Override // sensei0.a6
    public final void p(String str, ByteBuffer byteBuffer, z5 z5Var) {
        this.f.p(str, byteBuffer, z5Var);
    }

    @Override // sensei0.a6
    public final void t(String str, y5 y5Var, mh mhVar) {
        this.f.t(str, y5Var, mhVar);
    }
}
