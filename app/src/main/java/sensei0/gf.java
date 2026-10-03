package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gf extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public gf(zq zqVar, int i, TextView textView, int i2, TextView textView2) {
        this.f = zqVar;
        this.b = i;
        this.d = textView;
        this.c = i2;
        this.e = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 0:
                int i = this.b;
                View view = this.d;
                if (i != 0) {
                    view.setTranslationX(0.0f);
                }
                if (this.c != 0) {
                    view.setTranslationY(0.0f);
                }
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        i4 i4Var;
        switch (this.a) {
            case 0:
                ((ViewPropertyAnimator) this.e).setListener(null);
                kf kfVar = (kf) this.f;
                kfVar.a(null);
                kfVar.p.remove((Object) null);
                kfVar.f();
                break;
            default:
                TextView textView = (TextView) this.e;
                zq zqVar = (zq) this.f;
                zqVar.n = this.b;
                zqVar.l = null;
                TextView textView2 = (TextView) this.d;
                if (textView2 != null) {
                    textView2.setVisibility(4);
                    if (this.c == 1 && (i4Var = zqVar.r) != null) {
                        i4Var.setText((CharSequence) null);
                    }
                }
                if (textView != null) {
                    textView.setTranslationY(0.0f);
                    textView.setAlpha(1.0f);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                ((kf) this.f).getClass();
                break;
            default:
                TextView textView = (TextView) this.e;
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setAlpha(0.0f);
                }
                break;
        }
    }

    public gf(kf kfVar, s40 s40Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = kfVar;
        this.b = i;
        this.d = view;
        this.c = i2;
        this.e = viewPropertyAnimator;
    }
}
