package sensei0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l3 extends Button {
    public final k3 a;
    public final e4 b;
    public s3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialButtonStyle);
        me0.a(context);
        ge0.a(this, getContext());
        k3 k3Var = new k3(this);
        this.a = k3Var;
        k3Var.d(attributeSet, R.attr.materialButtonStyle);
        e4 e4Var = new e4(this);
        this.b = e4Var;
        e4Var.d(attributeSet, R.attr.materialButtonStyle);
        e4Var.b();
        getEmojiTextViewHelper().a(attributeSet, R.attr.materialButtonStyle);
    }

    private s3 getEmojiTextViewHelper() {
        if (this.c == null) {
            this.c = new s3(this);
        }
        return this.c;
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e4 e4Var = this.b;
        if (e4Var == null || si0.a) {
            return;
        }
        e4Var.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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

    public void setSupportAllCaps(boolean z) {
        e4 e4Var = this.b;
        if (e4Var != null) {
            e4Var.a.setAllCaps(z);
        }
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
}
