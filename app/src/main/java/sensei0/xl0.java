package sensei0;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xl0 implements WindowManager {
    public final WindowManager a;
    public final pa0 b;

    public xl0(WindowManager windowManager, pa0 pa0Var) {
        this.a = windowManager;
        this.b = pa0Var;
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Consumer consumer) {
        this.a.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        pa0 pa0Var = this.b;
        if (pa0Var == null) {
            Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            pa0Var.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getCurrentWindowMetrics() {
        return this.a.getCurrentWindowMetrics();
    }

    @Override // android.view.WindowManager
    public final Display getDefaultDisplay() {
        return this.a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getMaximumWindowMetrics() {
        return this.a.getMaximumWindowMetrics();
    }

    @Override // android.view.WindowManager
    public final boolean isCrossWindowBlurEnabled() {
        return this.a.isCrossWindowBlurEnabled();
    }

    @Override // android.view.WindowManager
    public final void removeCrossWindowBlurEnabledListener(Consumer consumer) {
        this.a.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void removeView(View view) {
        pa0 pa0Var = this.b;
        if (pa0Var == null) {
            Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            pa0Var.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View view) {
        pa0 pa0Var = this.b;
        if (pa0Var == null) {
            Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            pa0Var.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        pa0 pa0Var = this.b;
        if (pa0Var == null) {
            Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            pa0Var.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Executor executor, Consumer consumer) {
        this.a.addCrossWindowBlurEnabledListener(executor, consumer);
    }
}
