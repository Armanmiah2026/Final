package sensei0;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qa0 extends FrameLayout {
    public final q0 a;
    public final View b;

    public qa0(Context context, q0 q0Var, View view) {
        super(context);
        this.a = q0Var;
        this.b = view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.b bVar = this.a.a;
        if (bVar == null) {
            return false;
        }
        return bVar.a(this.b, view, accessibilityEvent);
    }
}
