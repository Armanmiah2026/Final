package sensei0;

import android.os.Build;
import android.view.SurfaceHolder;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xc0 implements SurfaceHolder.Callback2 {
    public final en a;
    public io.flutter.embedding.engine.renderer.e b;
    public final dn c;
    public final wl d = new wl(3, this);
    public final wc0 e;

    public xc0(dn dnVar, en enVar, io.flutter.embedding.engine.renderer.e eVar) {
        boolean z = Build.VERSION.SDK_INT < 26;
        this.e = z ? new wc0(this, 1) : new wc0(this, 0);
        this.c = dnVar;
        this.b = eVar;
        this.a = enVar;
        if (z) {
            enVar.setAlpha(0.0f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        dn dnVar = this.c;
        if (dnVar != null) {
            dnVar.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        dn dnVar = this.c;
        if (dnVar != null) {
            dnVar.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        dn dnVar = this.c;
        if (dnVar != null) {
            dnVar.surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        io.flutter.embedding.engine.renderer.e eVar = this.b;
        if (eVar == null) {
            return;
        }
        eVar.a(new vc0(this, runnable));
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}
