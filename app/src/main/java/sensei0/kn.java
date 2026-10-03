package sensei0;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kn extends ContentObserver {
    public final /* synthetic */ nn a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn(nn nnVar, Handler handler) {
        super(handler);
        this.a = nnVar;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        nn nnVar = this.a;
        if (nnVar.q == null) {
            return;
        }
        nnVar.d();
    }
}
