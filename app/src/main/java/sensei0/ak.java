package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ak extends AnimatorListenerAdapter implements jf0 {
    public final View a;
    public boolean b = false;

    public ak(View view) {
        this.a = view;
    }

    @Override // sensei0.jf0
    public final void b() {
        View view = this.a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? pi0.a.a(view) : 0.0f));
    }

    @Override // sensei0.jf0
    public final void e() {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        pi0.a.d(this.a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.b;
        View view = this.a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        zi0 zi0Var = pi0.a;
        zi0Var.d(view, 1.0f);
        zi0Var.getClass();
    }

    @Override // sensei0.jf0
    public final void a(mf0 mf0Var) {
    }

    @Override // sensei0.jf0
    public final void c(mf0 mf0Var) {
    }

    @Override // sensei0.jf0
    public final void d(mf0 mf0Var) {
    }

    @Override // sensei0.jf0
    public final void f(mf0 mf0Var) {
    }
}
