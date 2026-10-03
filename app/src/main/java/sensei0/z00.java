package sensei0;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class z00 extends nm {
    public q0 p;

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        q0 q0Var = this.p;
        if (q0Var != null) {
            io.flutter.view.b bVar = q0Var.a;
            if (bVar == null ? false : bVar.f(motionEvent, true)) {
                return true;
            }
        }
        return super.onHoverEvent(motionEvent);
    }
}
