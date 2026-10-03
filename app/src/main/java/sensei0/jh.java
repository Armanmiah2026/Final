package sensei0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jh extends xi {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final x8 i;
    public final y8 j;
    public final x2 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    public jh(wi wiVar) {
        super(wiVar);
        int i = 1;
        this.i = new x8(i, this);
        this.j = new y8(this, i);
        this.k = new x2(i, this);
        this.o = Long.MAX_VALUE;
        this.f = mm0.a0(wiVar.getContext(), R.attr.motionDurationShort3, 67);
        this.e = mm0.a0(wiVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = mm0.b0(wiVar.getContext(), R.attr.motionEasingLinearInterpolator, d3.a);
    }

    @Override // sensei0.xi
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && this.h.getInputType() != 0 && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new u2(4, this));
    }

    @Override // sensei0.xi
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // sensei0.xi
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // sensei0.xi
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // sensei0.xi
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // sensei0.xi
    public final x2 h() {
        return this.k;
    }

    @Override // sensei0.xi
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // sensei0.xi
    public final boolean k() {
        return this.n;
    }

    @Override // sensei0.xi
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: sensei0.hh
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    jh jhVar = this.a;
                    long j = jCurrentTimeMillis - jhVar.o;
                    if (j < 0 || j > 300) {
                        jhVar.m = false;
                    }
                    jhVar.t();
                    jhVar.m = true;
                    jhVar.o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: sensei0.ih
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                jh jhVar = this.a;
                jhVar.m = true;
                jhVar.o = System.currentTimeMillis();
                jhVar.s(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.p.isTouchExplorationEnabled()) {
            Field field = ai0.a;
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // sensei0.xi
    public final void m(d1 d1Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        if (this.h.getInputType() == 0) {
            accessibilityNodeInfo.setClassName(Spinner.class.getName());
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 ? accessibilityNodeInfo.isShowingHintText() : d1Var.e(4)) {
            if (i >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    @Override // sensei0.xi
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.p.isEnabled() && this.h.getInputType() == 0) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                t();
                this.m = true;
                this.o = System.currentTimeMillis();
            }
        }
    }

    @Override // sensei0.xi
    public final void q() {
        int i = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f);
        valueAnimatorOfFloat.addUpdateListener(new z8(this, i));
        this.r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.e);
        valueAnimatorOfFloat2.addUpdateListener(new z8(this, i));
        this.q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new v1(1, this));
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // sensei0.xi
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void t() {
        if (this.h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        s(!this.n);
        if (!this.n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
