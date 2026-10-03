package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import sensei0.ai0;
import sensei0.qs;
import sensei0.rl0;
import sensei0.t0;
import sensei0.u0;
import sensei0.uh0;
import sensei0.uq;
import sensei0.xi0;
import sensei0.zd0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
@SuppressLint({"NewApi", "Override"})
class ImeSyncDeferringInsetsCallback {
    private uq imeVisibilityListener;
    private WindowInsets lastWindowInsets;
    private View view;
    private final int deferredInsetTypes = WindowInsets.Type.ime();
    private boolean animating = false;
    private boolean needsSave = false;
    private AnimationCallback animationCallback = new AnimationCallback();
    private a insetsListener = new a(this);

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    @qs
    public class AnimationCallback extends WindowInsetsAnimation$Callback {
        public AnimationCallback() {
            super(1);
        }

        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            if (ImeSyncDeferringInsetsCallback.this.animating && (windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                ImeSyncDeferringInsetsCallback.this.animating = false;
                if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null && ImeSyncDeferringInsetsCallback.this.view != null) {
                    ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                }
            }
            View view = ImeSyncDeferringInsetsCallback.this.view;
            Field field = ai0.a;
            rl0 rl0VarA = uh0.a(view);
            if (rl0VarA == null || ImeSyncDeferringInsetsCallback.this.imeVisibilityListener == null) {
                return;
            }
            boolean zO = rl0VarA.a.o(8);
            zd0 zd0Var = (zd0) ImeSyncDeferringInsetsCallback.this.imeVisibilityListener;
            if (zO) {
                zd0Var.getClass();
            } else {
                b bVar = zd0Var.a;
                bVar.b.restartInput(bVar.a);
            }
        }

        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            ImeSyncDeferringInsetsCallback.this.needsSave = true;
            if ((windowInsetsAnimation.getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                ImeSyncDeferringInsetsCallback.this.animating = true;
            }
        }

        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
                Iterator<WindowInsetsAnimation> it = list.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if ((u0.m(it.next()).getTypeMask() & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                        z = true;
                    }
                }
                if (z) {
                    int windowSystemUiVisibility = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
                    int i = (Build.VERSION.SDK_INT < 35 && (windowSystemUiVisibility & 512) == 0 && (windowSystemUiVisibility & 2) == 0) ? windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom : 0;
                    t0.m();
                    WindowInsets.Builder builderC = xi0.c(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                    builderC.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, Insets.of(0, 0, 0, Math.max(windowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes).bottom - i, 0)));
                    ImeSyncDeferringInsetsCallback.this.view.onApplyWindowInsets(builderC.build());
                }
            }
            return windowInsets;
        }
    }

    public ImeSyncDeferringInsetsCallback(View view) {
        this.view = view;
    }

    public WindowInsetsAnimation$Callback getAnimationCallback() {
        return this.animationCallback;
    }

    public uq getImeVisibilityListener() {
        return this.imeVisibilityListener;
    }

    public View.OnApplyWindowInsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public void install() {
        this.view.setWindowInsetsAnimationCallback(this.animationCallback);
        this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    }

    public void remove() {
        this.view.setWindowInsetsAnimationCallback(null);
        this.view.setOnApplyWindowInsetsListener(null);
    }

    public void setImeVisibilityListener(uq uqVar) {
        this.imeVisibilityListener = uqVar;
    }
}
