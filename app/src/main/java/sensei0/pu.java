package sensei0;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pu implements View.OnTouchListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pu(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                qu quVar = (qu) this.b;
                mu muVar = quVar.v;
                Handler handler = quVar.z;
                w3 w3Var = quVar.D;
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0 && w3Var != null && w3Var.isShowing() && x >= 0 && x < w3Var.getWidth() && y >= 0 && y < w3Var.getHeight()) {
                    handler.postDelayed(muVar, 250L);
                    return false;
                }
                if (action != 1) {
                    return false;
                }
                handler.removeCallbacks(muVar);
                return false;
            default:
                if (((Checkable) view).isChecked()) {
                    return ((GestureDetector) this.b).onTouchEvent(motionEvent);
                }
                return false;
        }
    }
}
