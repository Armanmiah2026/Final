package sensei0;

import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gn extends TextureView implements f50 {
    public boolean a;
    public boolean b;
    public io.flutter.embedding.engine.renderer.e c;
    public Surface d;
    public final boolean f;

    public gn(vl vlVar) {
        super(vlVar, null);
        this.a = false;
        this.b = false;
        this.f = false;
        setSurfaceTextureListener(new fn(this));
        this.f = pr.E(getContext());
    }

    @Override // sensei0.f50
    public final void a() {
        if (this.c == null) {
            Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            io.flutter.embedding.engine.renderer.e eVar = this.c;
            if (eVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            eVar.j();
            Surface surface = this.d;
            if (surface != null) {
                surface.release();
                this.d = null;
            }
        }
        this.c = null;
    }

    @Override // sensei0.f50
    public final void b() {
        if (this.c == null) {
            Log.w("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (this.a) {
            e();
        }
        this.b = false;
    }

    @Override // sensei0.f50
    public final void c(io.flutter.embedding.engine.renderer.e eVar) {
        io.flutter.embedding.engine.renderer.e eVar2 = this.c;
        if (eVar2 != null) {
            eVar2.j();
        }
        this.c = eVar;
        b();
    }

    @Override // sensei0.f50
    public final void d() {
        if (this.c == null) {
            Log.w("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.b = true;
        }
    }

    public final void e() {
        if (this.c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
            this.d = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.d = surface2;
        io.flutter.embedding.engine.renderer.e eVar = this.c;
        boolean z = this.b;
        FlutterJNI flutterJNI = eVar.a;
        if (!z) {
            eVar.j();
        }
        eVar.c = surface2;
        if (z) {
            flutterJNI.onSurfaceWindowChanged(surface2);
        } else {
            flutterJNI.onSurfaceCreated(surface2);
        }
    }

    @Override // sensei0.f50
    public io.flutter.embedding.engine.renderer.e getAttachedRenderer() {
        return this.c;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.f) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i), mode == 0 ? 1 : 0), Math.max(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2) == 0 ? 1 : 0));
    }

    public void setRenderSurface(Surface surface) {
        this.d = surface;
    }
}
