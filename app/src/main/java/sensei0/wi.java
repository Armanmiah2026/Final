package sensei0;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wi extends LinearLayout {
    public EditText A;
    public final AccessibilityManager B;
    public x2 C;
    public final ti D;
    public final TextInputLayout a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode f;
    public View.OnLongClickListener h;
    public final CheckableImageButton o;
    public final vi p;
    public int q;
    public final LinkedHashSet r;
    public ColorStateList s;
    public PorterDuff.Mode t;
    public int u;
    public ImageView.ScaleType v;
    public View.OnLongClickListener w;
    public CharSequence x;
    public final i4 y;
    public boolean z;

    public wi(TextInputLayout textInputLayout, o4 o4Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.q = 0;
        this.r = new LinkedHashSet();
        this.D = new ti(this);
        ui uiVar = new ui(this);
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.o = checkableImageButtonA2;
        this.p = new vi(this, o4Var);
        i4 i4Var = new i4(getContext(), null);
        this.y = i4Var;
        TypedArray typedArray = (TypedArray) o4Var.b;
        if (typedArray.hasValue(38)) {
            this.d = k6.u(getContext(), o4Var, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f = qi0.b(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(o4Var.F(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        Field field = ai0.a;
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.s = k6.u(getContext(), o4Var, 32);
            }
            if (typedArray.hasValue(33)) {
                this.t = qi0.b(typedArray.getInt(33, -1), null);
            }
        }
        int i = 1;
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.s = k6.u(getContext(), o4Var, 54);
            }
            if (typedArray.hasValue(55)) {
                this.t = qi0.b(typedArray.getInt(55, -1), null);
            }
            g(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.u) {
            this.u = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeQ = mm0.q(typedArray.getInt(31, -1));
            this.v = scaleTypeQ;
            checkableImageButtonA2.setScaleType(scaleTypeQ);
            checkableImageButtonA.setScaleType(scaleTypeQ);
        }
        i4Var.setVisibility(8);
        i4Var.setId(R.id.textinput_suffix_text);
        i4Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        i4Var.setAccessibilityLiveRegion(1);
        i4Var.setTextAppearance(typedArray.getResourceId(72, 0));
        if (typedArray.hasValue(73)) {
            i4Var.setTextColor(o4Var.E(73));
        }
        CharSequence text3 = typedArray.getText(71);
        this.x = TextUtils.isEmpty(text3) ? null : text3;
        i4Var.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(i4Var);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.m0.add(uiVar);
        if (textInputLayout.d != null) {
            uiVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new l7(i, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (k6.F(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final xi b() {
        xi cdVar;
        int i = this.q;
        vi viVar = this.p;
        SparseArray sparseArray = viVar.a;
        xi xiVar = (xi) sparseArray.get(i);
        if (xiVar != null) {
            return xiVar;
        }
        wi wiVar = viVar.b;
        if (i == -1) {
            cdVar = new cd(wiVar, 0);
        } else if (i == 0) {
            cdVar = new cd(wiVar, 1);
        } else if (i == 1) {
            cdVar = new tz(wiVar, viVar.d);
        } else if (i == 2) {
            cdVar = new b9(wiVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(za0.h(i, "Invalid end icon mode: "));
            }
            cdVar = new jh(wiVar);
        }
        sparseArray.append(i, cdVar);
        return cdVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.o;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        Field field = ai0.a;
        return this.y.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.b.getVisibility() == 0 && this.o.getVisibility() == 0;
    }

    public final boolean e() {
        return this.c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z3;
        xi xiVarB = b();
        boolean zJ = xiVarB.j();
        CheckableImageButton checkableImageButton = this.o;
        boolean z4 = true;
        if (!zJ || (z3 = checkableImageButton.d) == xiVarB.k()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(xiVarB instanceof jh) || (zIsActivated = checkableImageButton.isActivated()) == ((jh) xiVarB).l) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z4) {
            mm0.Z(this.a, checkableImageButton, this.s);
        }
    }

    public final void g(int i) {
        if (this.q == i) {
            return;
        }
        xi xiVarB = b();
        x2 x2Var = this.C;
        AccessibilityManager accessibilityManager = this.B;
        if (x2Var != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new r0(x2Var));
        }
        this.C = null;
        xiVarB.r();
        this.q = i;
        Iterator it = this.r.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        h(i != 0);
        xi xiVarB2 = b();
        int iD = this.p.c;
        if (iD == 0) {
            iD = xiVarB2.d();
        }
        Drawable drawableM = iD != 0 ? wf0.m(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.o;
        checkableImageButton.setImageDrawable(drawableM);
        TextInputLayout textInputLayout = this.a;
        if (drawableM != null) {
            mm0.d(textInputLayout, checkableImageButton, this.s, this.t);
            mm0.Z(textInputLayout, checkableImageButton, this.s);
        }
        int iC = xiVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(xiVarB2.j());
        if (!xiVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        xiVarB2.q();
        x2 x2VarH = xiVarB2.h();
        this.C = x2VarH;
        if (x2VarH != null && accessibilityManager != null) {
            Field field = ai0.a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new r0(this.C));
            }
        }
        View.OnClickListener onClickListenerF = xiVarB2.f();
        View.OnLongClickListener onLongClickListener = this.w;
        checkableImageButton.setOnClickListener(onClickListenerF);
        mm0.d0(checkableImageButton, onLongClickListener);
        EditText editText = this.A;
        if (editText != null) {
            xiVarB2.l(editText);
            j(xiVarB2);
        }
        mm0.d(textInputLayout, checkableImageButton, this.s, this.t);
        f(true);
    }

    public final void h(boolean z) {
        if (d() != z) {
            this.o.setVisibility(z ? 0 : 8);
            k();
            m();
            this.a.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        mm0.d(this.a, checkableImageButton, this.d, this.f);
    }

    public final void j(xi xiVar) {
        if (this.A == null) {
            return;
        }
        if (xiVar.e() != null) {
            this.A.setOnFocusChangeListener(xiVar.e());
        }
        if (xiVar.g() != null) {
            this.o.setOnFocusChangeListener(xiVar.g());
        }
    }

    public final void k() {
        this.b.setVisibility((this.o.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.x == null || this.z) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.r.q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.q != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int paddingEnd;
        TextInputLayout textInputLayout = this.a;
        if (textInputLayout.d == null) {
            return;
        }
        if (d() || e()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.d;
            Field field = ai0.a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.d.getPaddingTop();
        int paddingBottom = textInputLayout.d.getPaddingBottom();
        Field field2 = ai0.a;
        this.y.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void n() {
        i4 i4Var = this.y;
        int visibility = i4Var.getVisibility();
        int i = (this.x == null || this.z) ? 8 : 0;
        if (visibility != i) {
            b().o(i == 0);
        }
        k();
        i4Var.setVisibility(i);
        this.a.q();
    }
}
