package sensei0;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yh implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = cf0.a;
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (uh.k != null) {
                uh.a().c();
            }
            Trace.endSection();
        } catch (Throwable th) {
            int i2 = cf0.a;
            Trace.endSection();
            throw th;
        }
    }
}
