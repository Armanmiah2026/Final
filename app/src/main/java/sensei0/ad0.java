package sensei0;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$GLTextureConsumer;
import io.flutter.view.TextureRegistry$SurfaceProducer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ad0 implements TextureRegistry$SurfaceProducer, TextureRegistry$GLTextureConsumer {
    public final long a;
    public int b;
    public int c;
    public boolean d;
    public Surface e;
    public final an f;
    public final Handler g;
    public final FlutterJNI h;

    public ad0(long j, Handler handler, FlutterJNI flutterJNI, an anVar) {
        this.a = j;
        this.g = handler;
        this.h = flutterJNI;
        this.f = anVar;
    }

    public final void finalize() throws Throwable {
        try {
            if (this.d) {
                return;
            }
            release();
            this.g.post(new bn(this.a, this.h));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final Surface getForcedNewSurface() {
        this.e = null;
        return getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final int getHeight() {
        return this.c;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final Surface getSurface() {
        Surface surface = this.e;
        if (surface == null || !surface.isValid()) {
            this.e = new Surface(this.f.b.surfaceTexture());
        }
        return this.e;
    }

    @Override // io.flutter.view.TextureRegistry$GLTextureConsumer
    public final SurfaceTexture getSurfaceTexture() {
        return this.f.b.surfaceTexture();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final int getWidth() {
        return this.b;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final boolean handlesCropAndRotation() {
        return true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final long id() {
        return this.a;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void release() {
        this.f.release();
        this.e.release();
        this.e = null;
        this.d = true;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void scheduleFrame() {
        this.h.markTextureFrameAvailable(this.a);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void setSize(int i, int i2) {
        this.b = i;
        this.c = i2;
        this.f.b.surfaceTexture().setDefaultBufferSize(i, i2);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public final void setCallback(fe0 fe0Var) {
    }
}
