package sensei0;

import android.graphics.Rect;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p10 implements SurfaceHolder.Callback {
    public final /* synthetic */ SurfaceView a;
    public final /* synthetic */ float b;
    public final /* synthetic */ Rect c;
    public final /* synthetic */ int d;
    public final /* synthetic */ q10 e;

    public p10(q10 q10Var, SurfaceView surfaceView, float f, Rect rect, int i) {
        this.e = q10Var;
        this.a = surfaceView;
        this.b = f;
        this.c = rect;
        this.d = i;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceView surfaceView = this.a;
        SurfaceControl surfaceControl = surfaceView.getSurfaceControl();
        q10 q10Var = this.e;
        if (surfaceControl == null || !surfaceControl.isValid()) {
            surfaceView.getId();
        } else {
            q10Var.getClass();
            SurfaceControl.Transaction transactionJ = o10.j();
            q10Var.t.add(transactionJ);
            transactionJ.setAlpha(surfaceControl, this.b).setCrop(surfaceControl, this.c);
        }
        q10Var.f.scheduleFrame();
        q10Var.x.remove(Integer.valueOf(this.d));
        surfaceView.getHolder().removeCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e.x.remove(Integer.valueOf(this.d));
        this.a.getHolder().removeCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }
}
