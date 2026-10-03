package sensei0;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ActionBarOverlayLayout b;

    public /* synthetic */ w1(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.a = i;
        this.b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.b;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.B = actionBarOverlayLayout.c.animate().translationY(0.0f).setListener(actionBarOverlayLayout.C);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.b;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.B = actionBarOverlayLayout2.c.animate().translationY(-actionBarOverlayLayout2.c.getHeight()).setListener(actionBarOverlayLayout2.C);
                break;
        }
    }
}
