package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ik extends AnimatorListenerAdapter {
    public boolean a = false;
    public final /* synthetic */ jk b;

    public ik(jk jkVar) {
        this.b = jkVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.a) {
            this.a = false;
            return;
        }
        jk jkVar = this.b;
        if (((Float) jkVar.u.getAnimatedValue()).floatValue() == 0.0f) {
            jkVar.v = 0;
            jkVar.f(0);
        } else {
            jkVar.v = 2;
            jkVar.n.invalidate();
        }
    }
}
