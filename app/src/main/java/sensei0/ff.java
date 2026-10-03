package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ff extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewPropertyAnimator c;
    public final /* synthetic */ kf d;

    public /* synthetic */ ff(kf kfVar, Object obj, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.a = i;
        this.d = kfVar;
        this.c = viewPropertyAnimator;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 1:
                this.b.setAlpha(1.0f);
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
                this.c.setListener(null);
                this.b.setAlpha(1.0f);
                kf kfVar = this.d;
                kfVar.a(null);
                kfVar.q.remove((Object) null);
                kfVar.f();
                break;
            case 1:
                this.c.setListener(null);
                kf kfVar2 = this.d;
                kfVar2.a(null);
                kfVar2.o.remove((Object) null);
                kfVar2.f();
                break;
            case 2:
                this.c.setListener(null);
                View view = this.b;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                kf kfVar3 = this.d;
                kfVar3.a(null);
                kfVar3.r.remove((Object) null);
                kfVar3.f();
                break;
            default:
                this.c.setListener(null);
                View view2 = this.b;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                kf kfVar4 = this.d;
                kfVar4.a(null);
                kfVar4.r.remove((Object) null);
                kfVar4.f();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                this.d.getClass();
                break;
            case 1:
                this.d.getClass();
                break;
            case 2:
                this.d.getClass();
                break;
            default:
                this.d.getClass();
                break;
        }
    }

    public ff(kf kfVar, s40 s40Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.a = 1;
        this.d = kfVar;
        this.b = view;
        this.c = viewPropertyAnimator;
    }
}
