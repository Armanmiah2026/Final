package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ v1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.b;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.q = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.b;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.q = false;
                break;
            case 1:
                jh jhVar = (jh) this.b;
                jhVar.p();
                jhVar.r.start();
                break;
            case 2:
                ((HideBottomViewOnScrollBehavior) this.b).h = null;
                break;
            default:
                ((mf0) this.b).m();
                animator.removeListener(this);
                break;
        }
    }
}
