package sensei0;

import android.graphics.Insets;
import android.view.WindowInsetsAnimation;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class u0 {
    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo C(int i) {
        return new AccessibilityNodeInfo.CollectionInfo(1, i, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo D(int i, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(0, 1, i, 1, z);
    }

    public static /* synthetic */ WindowInsetsAnimation.Bounds k(Insets insets, Insets insets2) {
        return new WindowInsetsAnimation.Bounds(insets, insets2);
    }

    public static /* synthetic */ WindowInsetsAnimation l(int i, Interpolator interpolator, long j) {
        return new WindowInsetsAnimation(i, interpolator, j);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimation m(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionInfo p(int i) {
        return new AccessibilityNodeInfo.CollectionInfo(i, 1, false);
    }

    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo q(int i, boolean z) {
        return new AccessibilityNodeInfo.CollectionItemInfo(i, 1, 0, 1, z);
    }

    public static /* synthetic */ void r() {
    }
}
