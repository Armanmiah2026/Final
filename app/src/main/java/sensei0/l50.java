package sensei0;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l50 implements Runnable {
    public final /* synthetic */ int a = 0;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ l50() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        switch (this.a) {
            case 0:
                try {
                    objCall = ((ao) this.b).call();
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.d).post(new e2((bo) this.c, objCall, 5, false));
                break;
            default:
                vk0.h((View) this.b, (ii0) this.c);
                ((ValueAnimator) this.d).start();
                break;
        }
    }

    public l50(View view, zk0 zk0Var, ii0 ii0Var, ValueAnimator valueAnimator) {
        this.b = view;
        this.c = ii0Var;
        this.d = valueAnimator;
    }
}
