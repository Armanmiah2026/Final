package sensei0;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l7 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l7(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.a) {
            case 1:
                wi wiVar = (wi) this.b;
                AccessibilityManager accessibilityManager = wiVar.B;
                if (wiVar.C != null && accessibilityManager != null) {
                    Field field = ai0.a;
                    if (wiVar.isAttachedToWindow()) {
                        accessibilityManager.addTouchExplorationStateChangeListener(new r0(wiVar.C));
                    }
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.a) {
            case 0:
                o7 o7Var = (o7) this.b;
                ViewTreeObserver viewTreeObserver = o7Var.F;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        o7Var.F = view.getViewTreeObserver();
                    }
                    o7Var.F.removeGlobalOnLayoutListener(o7Var.q);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                wi wiVar = (wi) this.b;
                x2 x2Var = wiVar.C;
                if (x2Var != null && (accessibilityManager = wiVar.B) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new r0(x2Var));
                    break;
                }
                break;
            default:
                pb0 pb0Var = (pb0) this.b;
                ViewTreeObserver viewTreeObserver2 = pb0Var.w;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        pb0Var.w = view.getViewTreeObserver();
                    }
                    pb0Var.w.removeGlobalOnLayoutListener(pb0Var.q);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
