package sensei0;

import android.view.SurfaceHolder;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dn implements SurfaceHolder.Callback {
    public final /* synthetic */ en a;

    public dn(en enVar) {
        this.a = enVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        en enVar = this.a;
        io.flutter.embedding.engine.renderer.e eVar = enVar.c;
        if (eVar == null || enVar.b) {
            return;
        }
        if (eVar == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        eVar.a.onSurfaceChanged(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        en enVar = this.a;
        enVar.a = true;
        if (enVar.c == null || enVar.b) {
            return;
        }
        enVar.e();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        en enVar = this.a;
        enVar.a = false;
        io.flutter.embedding.engine.renderer.e eVar = enVar.c;
        if (eVar == null || enVar.b) {
            return;
        }
        if (eVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        eVar.j();
    }
}
