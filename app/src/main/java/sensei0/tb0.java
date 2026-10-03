package sensei0;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tb0 extends LinearLayout {
    public final TextInputLayout a;
    public final i4 b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList f;
    public PorterDuff.Mode h;
    public int o;
    public ImageView.ScaleType p;
    public View.OnLongClickListener q;
    public boolean r;

    public tb0(TextInputLayout textInputLayout, o4 o4Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        i4 i4Var = new i4(getContext(), null);
        this.b = i4Var;
        if (k6.F(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.q;
        checkableImageButton.setOnClickListener(null);
        mm0.d0(checkableImageButton, onLongClickListener);
        this.q = null;
        checkableImageButton.setOnLongClickListener(null);
        mm0.d0(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) o4Var.b;
        if (typedArray.hasValue(69)) {
            this.f = k6.u(getContext(), o4Var, 69);
        }
        if (typedArray.hasValue(70)) {
            this.h = qi0.b(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            b(o4Var.F(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.o) {
            this.o = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(68)) {
            ImageView.ScaleType scaleTypeQ = mm0.q(typedArray.getInt(68, -1));
            this.p = scaleTypeQ;
            checkableImageButton.setScaleType(scaleTypeQ);
        }
        i4Var.setVisibility(8);
        i4Var.setId(R.id.textinput_prefix_text);
        i4Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Field field = ai0.a;
        i4Var.setAccessibilityLiveRegion(1);
        i4Var.setTextAppearance(typedArray.getResourceId(60, 0));
        if (typedArray.hasValue(61)) {
            i4Var.setTextColor(o4Var.E(61));
        }
        CharSequence text2 = typedArray.getText(59);
        this.c = TextUtils.isEmpty(text2) ? null : text2;
        i4Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(i4Var);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        Field field = ai0.a;
        return this.b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f;
            PorterDuff.Mode mode = this.h;
            TextInputLayout textInputLayout = this.a;
            mm0.d(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            mm0.Z(textInputLayout, checkableImageButton, this.f);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.q;
        checkableImageButton.setOnClickListener(null);
        mm0.d0(checkableImageButton, onLongClickListener);
        this.q = null;
        checkableImageButton.setOnLongClickListener(null);
        mm0.d0(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        int paddingStart;
        EditText editText = this.a.d;
        if (editText == null) {
            return;
        }
        if (this.d.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            Field field = ai0.a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        Field field2 = ai0.a;
        this.b.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i = (this.c == null || this.r) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.a.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
    }
}
