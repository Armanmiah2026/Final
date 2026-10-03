package sensei0;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a70 {
    public final z60 a;

    public a70(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.a = new y60(nestedScrollView);
        } else {
            this.a = new mz(11);
        }
    }
}
