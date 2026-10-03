package sensei0;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.view.TextureRegistry$SurfaceTextureEntry;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class an implements TextureRegistry$SurfaceTextureEntry, ee0 {
    public final long a;
    public final SurfaceTextureWrapper b;
    public boolean c;
    public ee0 d;
    public final /* synthetic */ io.flutter.embedding.engine.renderer.e e;

    public an(io.flutter.embedding.engine.renderer.e eVar, long j, SurfaceTexture surfaceTexture) {
        this.e = eVar;
        this.a = j;
        SurfaceTextureWrapper surfaceTextureWrapper = new SurfaceTextureWrapper(surfaceTexture, new u2(6, this));
        this.b = surfaceTextureWrapper;
        surfaceTextureWrapper.surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: sensei0.zm
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                an anVar = this.a;
                FlutterJNI flutterJNI = anVar.e.a;
                if (anVar.c || !flutterJNI.isAttached()) {
                    return;
                }
                anVar.b.markDirty();
                flutterJNI.scheduleFrame();
            }
        }, new Handler());
    }

    public final void finalize() throws Throwable {
        try {
            if (this.c) {
                return;
            }
            io.flutter.embedding.engine.renderer.e eVar = this.e;
            eVar.e.post(new bn(this.a, eVar.a));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final long id() {
        return this.a;
    }

    @Override // sensei0.ee0
    public final void onTrimMemory(int i) {
        ee0 ee0Var = this.d;
        if (ee0Var != null) {
            ee0Var.onTrimMemory(i);
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void release() {
        if (this.c) {
            return;
        }
        this.b.release();
        long j = this.a;
        io.flutter.embedding.engine.renderer.e eVar = this.e;
        eVar.a.unregisterTexture(j);
        eVar.h(this);
        this.c = true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void setOnTrimMemoryListener(ee0 ee0Var) {
        this.d = ee0Var;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final SurfaceTexture surfaceTexture() {
        return this.b.surfaceTexture();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceTextureEntry
    public final void setOnFrameConsumedListener(de0 de0Var) {
    }
}
