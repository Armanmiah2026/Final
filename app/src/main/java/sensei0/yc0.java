package sensei0;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yc0 implements ee0 {
    public final /* synthetic */ zc0 a;

    public yc0(zc0 zc0Var) {
        this.a = zc0Var;
    }

    @Override // sensei0.ee0
    public final void onTrimMemory(int i) {
        if (i != 80 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        this.a.h = true;
    }
}
