package sensei0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i10 extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public s2 f;
    public g10 h;
    public vm o;

    public i10(vl vlVar) {
        super(vlVar);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        g10 g10Var = this.h;
        if (g10Var == null) {
            super.draw(canvas);
            Log.e("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Surface surface = g10Var.getSurface();
        if (!surface.isValid()) {
            Log.e("PlatformViewWrapper", "Platform view cannot be composed without a valid RenderTarget surface.");
            return;
        }
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        if (canvasLockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(canvasLockHardwareCanvas);
        } finally {
            this.h.scheduleFrame();
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.o;
    }

    public int getRenderTargetHeight() {
        g10 g10Var = this.h;
        if (g10Var != null) {
            return g10Var.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        g10 g10Var = this.h;
        if (g10Var != null) {
            return g10Var.getWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.c;
            this.a = i;
            int i2 = this.d;
            this.b = i2;
            matrix.postTranslate(i, i2);
        } else if (action != 2) {
            matrix.postTranslate(this.c, this.d);
        } else {
            matrix.postTranslate(this.a, this.b);
            this.a = this.c;
            this.b = this.d;
        }
        this.f.d(motionEvent, matrix);
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

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.c = layoutParams.leftMargin;
        this.d = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        vm vmVar;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (vmVar = this.o) != null) {
            this.o = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(vmVar);
        }
        ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
        if (viewTreeObserver2.isAlive() && this.o == null) {
            vm vmVar2 = new vm(this, onFocusChangeListener);
            this.o = vmVar2;
            viewTreeObserver2.addOnGlobalFocusChangeListener(vmVar2);
        }
    }

    public void setTouchProcessor(s2 s2Var) {
        this.f = s2Var;
    }
}
