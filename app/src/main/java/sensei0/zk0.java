package sensei0;

import android.os.Build;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zk0 {
    public yk0 a;

    public zk0(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new xk0(u0.l(i, interpolator, j));
        } else {
            this.a = new vk0(i, interpolator, j);
        }
    }
}
