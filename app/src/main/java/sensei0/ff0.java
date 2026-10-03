package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ff0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public ff0(zk0 zk0Var, View view) {
        this.b = zk0Var;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 0:
                ((y4) this.b).remove(animator);
                ((mf0) this.c).v.remove(animator);
                break;
            default:
                ((zk0) this.b).a.d(1.0f);
                vk0.e((View) this.c);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                ((mf0) this.c).v.add(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public ff0(mf0 mf0Var, y4 y4Var) {
        this.c = mf0Var;
        this.b = y4Var;
    }
}
