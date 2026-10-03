package sensei0;

import android.graphics.Region;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class en extends SurfaceView implements f50 {
    public boolean a;
    public boolean b;
    public io.flutter.embedding.engine.renderer.e c;
    public final boolean d;
    public final xc0 f;

    public en(vl vlVar, boolean z) {
        super(vlVar, null);
        this.a = false;
        this.b = false;
        this.d = false;
        xc0 xc0Var = new xc0(new dn(this), this, this.c);
        this.f = xc0Var;
        if (z) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        this.d = pr.E(getContext());
        getHolder().addCallback(xc0Var);
    }

    @Override // sensei0.f50
    public final void a() {
        if (this.c == null) {
            Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            io.flutter.embedding.engine.renderer.e eVar = this.c;
            if (eVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            eVar.j();
        }
        wc0 wc0Var = this.f.e;
        switch (wc0Var.a) {
            case 0:
                wc0Var.b.b = null;
                break;
            default:
                xc0 xc0Var = wc0Var.b;
                xc0Var.a.setAlpha(0.0f);
                io.flutter.embedding.engine.renderer.e eVar2 = xc0Var.b;
                if (eVar2 != null) {
                    eVar2.g(xc0Var.d);
                }
                xc0Var.b = null;
                break;
        }
        this.c = null;
    }

    @Override // sensei0.f50
    public final void b() {
        if (this.c == null) {
            Log.w("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        wc0 wc0Var = this.f.e;
        switch (wc0Var.a) {
            case 0:
                break;
            default:
                xc0 xc0Var = wc0Var.b;
                io.flutter.embedding.engine.renderer.e eVar = xc0Var.b;
                if (eVar != null) {
                    eVar.a(xc0Var.d);
                }
                break;
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
        wc0 wc0Var = this.f.e;
        switch (wc0Var.a) {
            case 0:
                wc0Var.b.b = eVar;
                break;
            default:
                xc0 xc0Var = wc0Var.b;
                io.flutter.embedding.engine.renderer.e eVar3 = xc0Var.b;
                if (eVar3 != null) {
                    eVar3.g(xc0Var.d);
                }
                xc0Var.b = eVar;
                break;
        }
        b();
    }

    @Override // sensei0.f50
    public final void d() {
        if (this.c == null) {
            Log.w("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.b = true;
        }
    }

    public final void e() {
        if (this.c == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        io.flutter.embedding.engine.renderer.e eVar = this.c;
        Surface surface = getHolder().getSurface();
        boolean z = this.b;
        FlutterJNI flutterJNI = eVar.a;
        if (!z) {
            eVar.j();
        }
        eVar.c = surface;
        if (z) {
            flutterJNI.onSurfaceWindowChanged(surface);
        } else {
            flutterJNI.onSurfaceCreated(surface);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i = iArr[0];
        region.op(i, iArr[1], (getRight() + i) - getLeft(), (getBottom() + iArr[1]) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // sensei0.f50
    public io.flutter.embedding.engine.renderer.e getAttachedRenderer() {
        return this.c;
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.d) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i), mode == 0 ? 1 : 0), Math.max(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2) == 0 ? 1 : 0));
    }
}
