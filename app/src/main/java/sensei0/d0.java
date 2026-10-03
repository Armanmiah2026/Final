package sensei0;

import android.view.accessibility.AccessibilityManager;
import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements AccessibilityManager.AccessibilityStateChangeListener {
    public final /* synthetic */ io.flutter.view.b a;

    public d0(io.flutter.view.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        io.flutter.view.b bVar = this.a;
        o4 o4Var = bVar.b;
        if (bVar.u) {
            return;
        }
        if (z) {
            ((FlutterJNI) o4Var.c).setSemanticsEnabled(true);
        } else {
            bVar.k(false);
            ((FlutterJNI) o4Var.c).setSemanticsEnabled(false);
        }
        sv svVar = bVar.s;
        if (svVar != null) {
            boolean zIsTouchExplorationEnabled = bVar.c.isTouchExplorationEnabled();
            nn nnVar = (nn) svVar.b;
            if (nnVar.q.b.a.getIsSoftwareRenderingEnabled()) {
                nnVar.setWillNotDraw(false);
            } else {
                nnVar.setWillNotDraw((z || zIsTouchExplorationEnabled) ? false : true);
            }
        }
    }
}
