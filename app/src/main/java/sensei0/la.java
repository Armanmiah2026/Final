package sensei0;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class la {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
