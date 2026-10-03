package sensei0;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {
    public static c1 b;
    public final Object a;

    public c1() {
        this.a = new Object();
        new Handler(Looper.getMainLooper(), new xa0(this));
    }

    public static c1 a(boolean z, int i, int i2, int i3, int i4) {
        return new c1(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }

    public c1(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
        this.a = collectionItemInfo;
    }
}
