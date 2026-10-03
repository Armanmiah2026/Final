package sensei0;

import android.util.Log;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ul implements OnBackAnimationCallback {
    public final /* synthetic */ vl a;

    public ul(vl vlVar) {
        this.a = vlVar;
    }

    public final void onBackCancelled() {
        vl vlVar = this.a;
        if (vlVar.l("cancelBackGesture")) {
            zl zlVar = vlVar.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                emVar.j.a.a("cancelBackGesture", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    public final void onBackInvoked() {
        vl vlVar = this.a;
        if (vlVar.l("commitBackGesture")) {
            zl zlVar = vlVar.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                emVar.j.a.a("commitBackGesture", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    public final void onBackProgressed(BackEvent backEvent) {
        vl vlVar = this.a;
        if (vlVar.l("updateBackGestureProgress")) {
            zl zlVar = vlVar.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                emVar.j.a.a("updateBackGestureProgress", h5.a(backEvent), null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        vl vlVar = this.a;
        if (vlVar.l("startBackGesture")) {
            zl zlVar = vlVar.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                emVar.j.a.a("startBackGesture", h5.a(backEvent), null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
            }
        }
    }
}
