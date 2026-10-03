package sensei0;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class aa extends mh {
    public final /* synthetic */ int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aa(int i) {
        super(19);
        this.x = i;
    }

    @Override // sensei0.mh
    public final void o(AccessibilityNodeInfo accessibilityNodeInfo, m0 m0Var) {
        float f;
        float f2;
        switch (this.x) {
            case 0:
                accessibilityNodeInfo.setClassName("android.widget.Spinner");
                accessibilityNodeInfo.setCanOpenPopup(true);
                break;
            case 1:
                accessibilityNodeInfo.setClassName("android.widget.Spinner");
                accessibilityNodeInfo.setCanOpenPopup(true);
                break;
            default:
                accessibilityNodeInfo.setClassName("android.widget.ProgressBar");
                if (m0Var.r != null) {
                    String str = m0Var.C;
                    if (str != null) {
                        try {
                            f = Float.parseFloat(str);
                        } catch (NumberFormatException unused) {
                            f = Float.NEGATIVE_INFINITY;
                        }
                    } else {
                        f = Float.NEGATIVE_INFINITY;
                    }
                    String str2 = m0Var.D;
                    if (str2 != null) {
                        try {
                            f2 = Float.parseFloat(str2);
                        } catch (NumberFormatException unused2) {
                            f2 = Float.POSITIVE_INFINITY;
                        }
                    } else {
                        f2 = Float.POSITIVE_INFINITY;
                    }
                    try {
                        accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, f, f2, Float.parseFloat(m0Var.r)));
                        break;
                    } catch (NumberFormatException unused3) {
                        if (Build.VERSION.SDK_INT >= 36) {
                            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(3, 0.0f, 0.0f, 0.0f));
                            return;
                        }
                        accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, 0.0f, 0.0f, 0.0f));
                    }
                }
                break;
        }
    }
}
