package sensei0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c10 implements nd {
    public final Handler a;

    public c10() {
        Looper mainLooper = Looper.getMainLooper();
        this.a = Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(mainLooper) : new Handler(mainLooper);
    }

    @Override // sensei0.nd
    public final void a(ld ldVar) {
        this.a.post(ldVar);
    }
}
