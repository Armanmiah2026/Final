package sensei0;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zc0 implements g10 {
    public final an a;
    public SurfaceTexture b;
    public Surface c;
    public int d = 0;
    public int f = 0;
    public boolean h = false;

    public zc0(an anVar) {
        yc0 yc0Var = new yc0(this);
        this.a = anVar;
        this.b = anVar.b.surfaceTexture();
        anVar.d = yc0Var;
    }

    @Override // sensei0.g10
    public final void c(int i, int i2) {
        this.d = i;
        this.f = i2;
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    @Override // sensei0.g10
    public final int getHeight() {
        return this.f;
    }

    @Override // sensei0.g10
    public final long getId() {
        return this.a.a;
    }

    @Override // sensei0.g10
    public final Surface getSurface() {
        Surface surface = this.c;
        if (surface == null || this.h) {
            if (surface != null) {
                surface.release();
                this.c = null;
            }
            this.c = new Surface(this.b);
            this.h = false;
        }
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            return null;
        }
        return this.c;
    }

    @Override // sensei0.g10
    public final int getWidth() {
        return this.d;
    }

    @Override // sensei0.g10
    public final void release() {
        this.b = null;
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
            this.c = null;
        }
    }
}
