package sensei0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wm extends FrameLayout {
    public FlutterMutatorsStack a;
    public final float b;
    public int c;
    public int d;
    public final s2 f;
    public final Paint h;
    public vm o;

    public wm(vl vlVar, float f, s2 s2Var) {
        super(vlVar, null);
        this.b = f;
        this.f = s2Var;
        this.h = new Paint();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.a.getFinalMatrix());
        float f = this.b;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate(-this.c, -this.d);
        return matrix;
    }

    public final void a() {
        vm vmVar;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (vmVar = this.o) == null) {
            return;
        }
        this.o = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(vmVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.c, -this.d);
            canvas.clipPath(path);
        }
        int finalOpacity = (int) (this.a.getFinalOpacity() * 255.0f);
        Paint paint = this.h;
        if (paint.getAlpha() != finalOpacity) {
            paint.setAlpha((int) (this.a.getFinalOpacity() * 255.0f));
            setLayerType(2, paint);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        s2 s2Var = this.f;
        if (s2Var == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(getLeft(), getTop());
        s2Var.d(motionEvent, matrix);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        a();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.o == null) {
            vm vmVar = new vm(onFocusChangeListener, this);
            this.o = vmVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(vmVar);
        }
    }
}
