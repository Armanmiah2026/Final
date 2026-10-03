package sensei0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fn implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ gn a;

    public fn(gn gnVar) {
        this.a = gnVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        gn gnVar = this.a;
        gnVar.a = true;
        if (gnVar.c == null || gnVar.b) {
            return;
        }
        gnVar.e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        gn gnVar = this.a;
        gnVar.a = false;
        io.flutter.embedding.engine.renderer.e eVar = gnVar.c;
        if (eVar != null && !gnVar.b) {
            if (eVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            eVar.j();
            Surface surface = gnVar.d;
            if (surface != null) {
                surface.release();
                gnVar.d = null;
            }
        }
        Surface surface2 = gnVar.d;
        if (surface2 == null) {
            return true;
        }
        surface2.release();
        gnVar.d = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        gn gnVar = this.a;
        io.flutter.embedding.engine.renderer.e eVar = gnVar.c;
        if (eVar == null || gnVar.b) {
            return;
        }
        if (eVar == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        eVar.a.onSurfaceChanged(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
