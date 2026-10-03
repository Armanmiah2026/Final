package sensei0;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b9 extends xi {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final x8 j;
    public final y8 k;
    public AnimatorSet l;
    public ValueAnimator m;

    public b9(wi wiVar) {
        super(wiVar);
        this.j = new x8(0, this);
        this.k = new y8(this, 0);
        this.e = mm0.a0(wiVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f = mm0.a0(wiVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = mm0.b0(wiVar.getContext(), R.attr.motionEasingLinearInterpolator, d3.a);
        this.h = mm0.b0(wiVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, d3.d);
    }

    @Override // sensei0.xi
    public final void a() {
        if (this.b.x != null) {
            return;
        }
        s(t());
    }

    @Override // sensei0.xi
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // sensei0.xi
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // sensei0.xi
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // sensei0.xi
    public final View.OnClickListener f() {
        return this.j;
    }

    @Override // sensei0.xi
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // sensei0.xi
    public final void l(EditText editText) {
        this.i = editText;
        this.a.setEndIconVisible(t());
    }

    @Override // sensei0.xi
    public final void o(boolean z) {
        if (this.b.x == null) {
            return;
        }
        s(z);
    }

    @Override // sensei0.xi
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f);
        valueAnimatorOfFloat.addUpdateListener(new z8(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i = this.e;
        valueAnimatorOfFloat2.setDuration(i);
        valueAnimatorOfFloat2.addUpdateListener(new z8(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.l.addListener(new a9(this, 0));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i);
        valueAnimatorOfFloat3.addUpdateListener(new z8(this, 0));
        this.m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new a9(this, 1));
    }

    @Override // sensei0.xi
    public final void r() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new u2(2, this));
        }
    }

    public final void s(boolean z) {
        boolean z2 = this.b.d() == z;
        if (z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z2) {
                this.l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z2) {
            this.m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
