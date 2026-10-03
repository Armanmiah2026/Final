package sensei0;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class i4 extends TextView {
    public final k3 a;
    public final e4 b;
    public final i3 c;
    public s3 d;
    public boolean f;
    public sv h;
    public Future o;

    public i4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private s3 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new s3(this);
        }
        return this.d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.a();
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (si0.a) {
            return super.getAutoSizeMaxTextSize();
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            return Math.round(e4Var.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (si0.a) {
            return super.getAutoSizeMinTextSize();
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            return Math.round(e4Var.i.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (si0.a) {
            return super.getAutoSizeStepGranularity();
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            return Math.round(e4Var.i.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (si0.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        e4 e4Var = this.b;
        return e4Var != null ? e4Var.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (si0.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            return e4Var.i.a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return pr.W(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public f4 getSuperCaller() {
        if (this.h == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.h = new h4(this);
            } else if (i >= 28) {
                this.h = new g4(this);
            } else if (i >= 26) {
                this.h = new sv(6, this);
            }
        }
        return this.h;
    }

    public ColorStateList getSupportBackgroundTintList() {
        k3 k3Var = this.a;
        if (k3Var != null) {
            return k3Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k3 k3Var = this.a;
        if (k3Var != null) {
            return k3Var.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        r60 r60Var = this.b.h;
        if (r60Var != null) {
            return (ColorStateList) r60Var.c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        r60 r60Var = this.b.h;
        if (r60Var != null) {
            return (PorterDuff.Mode) r60Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.o;
        if (future != null) {
            try {
                this.o = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                pr.A(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        i3 i3Var;
        if (Build.VERSION.SDK_INT >= 28 || (i3Var = this.c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) i3Var.c;
        return textClassifier == null ? y3.a((TextView) i3Var.b) : textClassifier;
    }

    public v10 getTextMetricsParamsCompat() {
        return pr.A(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.b.getClass();
        e4.f(editorInfo, inputConnectionOnCreateInputConnection, this);
        pr.G(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e4 e4Var = this.b;
        if (e4Var == null || si0.a) {
            return;
        }
        e4Var.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future future = this.o;
        if (future != null) {
            try {
                this.o = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                pr.A(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        e4 e4Var = this.b;
        if (e4Var != null) {
            n4 n4Var = e4Var.i;
            if (si0.a || !n4Var.f()) {
                return;
            }
            n4Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        ((xe) getEmojiTextViewHelper().b.b).E(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (si0.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (si0.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.h(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (si0.a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.i(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(pr.X(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        ((xe) getEmojiTextViewHelper().b.b).F(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((xe) getEmojiTextViewHelper().b.b).n(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().q(i);
        } else {
            pr.O(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i);
        } else {
            pr.P(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        pr.Q(this, i);
    }

    public void setPrecomputedText(w10 w10Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        pr.A(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e4 e4Var = this.b;
        e4Var.j(colorStateList);
        e4Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e4 e4Var = this.b;
        e4Var.k(mode);
        e4Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.e(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        i3 i3Var;
        if (Build.VERSION.SDK_INT >= 28 || (i3Var = this.c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            i3Var.c = textClassifier;
        }
    }

    public void setTextFuture(Future<w10> future) {
        this.o = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(v10 v10Var) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = v10Var.b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(v10Var.a);
        setBreakStrategy(v10Var.c);
        setHyphenationFrequency(v10Var.d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = si0.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        e4 e4Var = this.b;
        if (e4Var != null) {
            n4 n4Var = e4Var.i;
            if (z || n4Var.f()) {
                return;
            }
            n4Var.g(i, f);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.f) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            pr prVar = xf0.a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.f = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        me0.a(context);
        this.f = false;
        this.h = null;
        ge0.a(this, getContext());
        k3 k3Var = new k3(this);
        this.a = k3Var;
        k3Var.d(attributeSet, i);
        e4 e4Var = new e4(this);
        this.b = e4Var;
        e4Var.d(attributeSet, i);
        e4Var.b();
        i3 i3Var = new i3(2, false);
        i3Var.b = this;
        this.c = i3Var;
        getEmojiTextViewHelper().a(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            getSuperCaller().v(i, f);
        } else if (i2 >= 34) {
            a1.h(this, i, f);
        } else {
            pr.Q(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? wf0.m(context, i) : null, i2 != 0 ? wf0.m(context, i2) : null, i3 != 0 ? wf0.m(context, i3) : null, i4 != 0 ? wf0.m(context, i4) : null);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? wf0.m(context, i) : null, i2 != 0 ? wf0.m(context, i2) : null, i3 != 0 ? wf0.m(context, i3) : null, i4 != 0 ? wf0.m(context, i4) : null);
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.b();
        }
    }
}
