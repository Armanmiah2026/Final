package sensei0;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s8 extends mh {
    public final String x;

    public s8(String str) {
        super(19);
        this.x = str;
    }

    @Override // sensei0.mh
    public final void o(AccessibilityNodeInfo accessibilityNodeInfo, m0 m0Var) {
        accessibilityNodeInfo.setClassName(this.x);
    }
}
