package sensei0;

import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tw implements PopupWindow.OnDismissListener {
    public final /* synthetic */ uw a;

    public tw(uw uwVar) {
        this.a = uwVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.c();
    }
}
