package sensei0;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tl implements OnBackInvokedCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ tl(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void onBackInvoked() {
        switch (this.a) {
            case 0:
                ((vl) this.b).onBackPressed();
                break;
            default:
                ((Runnable) this.b).run();
                break;
        }
    }
}
