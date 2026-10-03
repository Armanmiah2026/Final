package sensei0;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xa0 implements Handler.Callback {
    public final /* synthetic */ c1 a;

    public xa0(c1 c1Var) {
        this.a = c1Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        c1 c1Var = this.a;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (c1Var.a) {
            throw null;
        }
    }
}
