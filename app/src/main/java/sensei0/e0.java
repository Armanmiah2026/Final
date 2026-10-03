package sensei0;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ AccessibilityManager a;
    public final /* synthetic */ io.flutter.view.b b;

    public e0(io.flutter.view.b bVar, AccessibilityManager accessibilityManager) {
        this.b = bVar;
        this.a = accessibilityManager;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        io.flutter.view.b bVar = this.b;
        if (bVar.u) {
            return;
        }
        boolean z2 = false;
        if (!z) {
            bVar.k(false);
            m0 m0Var = bVar.p;
            if (m0Var != null) {
                bVar.h(m0Var.b, 256);
                bVar.p = null;
            }
        }
        sv svVar = bVar.s;
        if (svVar != null) {
            boolean zIsEnabled = this.a.isEnabled();
            nn nnVar = (nn) svVar.b;
            if (nnVar.q.b.a.getIsSoftwareRenderingEnabled()) {
                nnVar.setWillNotDraw(false);
                return;
            }
            if (!zIsEnabled && !z) {
                z2 = true;
            }
            nnVar.setWillNotDraw(z2);
        }
    }
}
