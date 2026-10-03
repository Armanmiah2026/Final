package sensei0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gj0 extends AnimatorListenerAdapter implements jf0 {
    public final ViewGroup a;
    public final View b;
    public final View c;
    public boolean d = true;
    public final /* synthetic */ bk e;

    public gj0(bk bkVar, ViewGroup viewGroup, View view, View view2) {
        this.e = bkVar;
        this.a = viewGroup;
        this.b = view;
        this.c = view2;
    }

    @Override // sensei0.jf0
    public final void a(mf0 mf0Var) {
        mf0Var.z(this);
    }

    @Override // sensei0.jf0
    public final void c(mf0 mf0Var) {
        if (this.d) {
            g();
        }
    }

    public final void g() {
        this.c.setTag(R.id.save_overlay_view, null);
        this.a.getOverlay().remove(this.b);
        this.d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.a.getOverlay().remove(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.b;
        if (view.getParent() == null) {
            this.a.getOverlay().add(view);
        } else {
            this.e.c();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.c;
            View view2 = this.b;
            view.setTag(R.id.save_overlay_view, view2);
            this.a.getOverlay().add(view2);
            this.d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        g();
    }

    @Override // sensei0.jf0
    public final void d(mf0 mf0Var) {
    }

    @Override // sensei0.jf0
    public final void b() {
    }

    @Override // sensei0.jf0
    public final void e() {
    }
}
