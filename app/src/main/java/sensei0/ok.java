package sensei0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ok extends Handler {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ pk b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ok(pk pkVar, Looper looper, boolean z) {
        super(looper);
        this.b = pkVar;
        this.a = z;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.b.q.a(Boolean.valueOf(this.a));
    }
}
