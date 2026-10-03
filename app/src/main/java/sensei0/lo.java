package sensei0;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class lo implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ a2 b;

    public /* synthetic */ lo(a2 a2Var, int i) {
        this.a = i;
        this.b = a2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ViewParent parent = this.b.d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                a2 a2Var = this.b;
                a2Var.a();
                View view = a2Var.d;
                if (view.isEnabled() && !view.isLongClickable() && a2Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    a2Var.o = true;
                    break;
                }
                break;
        }
    }
}
