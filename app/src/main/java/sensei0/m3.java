package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m3 extends CheckBox {
    public final n3 a;
    public final k3 b;
    public final e4 c;
    public s3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.chipStyle);
        me0.a(context);
        ge0.a(this, getContext());
        n3 n3Var = new n3();
        n3Var.e = null;
        n3Var.f = null;
        n3Var.a = false;
        n3Var.b = false;
        n3Var.d = this;
        this.a = n3Var;
        Context context2 = getContext();
        int[] iArr = p30.j;
        o4 o4VarQ = o4.Q(context2, attributeSet, iArr, R.attr.chipStyle);
        TypedArray typedArray = (TypedArray) o4VarQ.b;
        ai0.j(this, getContext(), iArr, attributeSet, (TypedArray) o4VarQ.b, R.attr.chipStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setButtonDrawable(wf0.m(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setButtonDrawable(wf0.m(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setButtonDrawable(wf0.m(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setButtonTintList(o4VarQ.E(2));
            }
            if (typedArray.hasValue(3)) {
                setButtonTintMode(ah.c(typedArray.getInt(3, -1), null));
            }
            o4VarQ.V();
            k3 k3Var = new k3(this);
            this.b = k3Var;
            k3Var.d(attributeSet, R.attr.chipStyle);
            e4 e4Var = new e4(this);
            this.c = e4Var;
            e4Var.d(attributeSet, R.attr.chipStyle);
            getEmojiTextViewHelper().a(attributeSet, R.attr.chipStyle);
        } catch (Throwable th) {
            o4VarQ.V();
            throw th;
        }
    }

    private s3 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new s3(this);
        }
        return this.d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.a();
        }
        e4 e4Var = this.c;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        k3 k3Var = this.b;
        if (k3Var != null) {
            return k3Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k3 k3Var = this.b;
        if (k3Var != null) {
            return k3Var.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        n3 n3Var = this.a;
        if (n3Var != null) {
            return (ColorStateList) n3Var.e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        n3 n3Var = this.a;
        if (n3Var != null) {
            return (PorterDuff.Mode) n3Var.f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        r60 r60Var = this.c.h;
        if (r60Var != null) {
            return (ColorStateList) r60Var.c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        r60 r60Var = this.c.h;
        if (r60Var != null) {
            return (PorterDuff.Mode) r60Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        ((xe) getEmojiTextViewHelper().b.b).E(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        n3 n3Var = this.a;
        if (n3Var != null) {
            if (n3Var.c) {
                n3Var.c = false;
            } else {
                n3Var.c = true;
                n3Var.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.c;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        e4 e4Var = this.c;
        if (e4Var != null) {
            e4Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        ((xe) getEmojiTextViewHelper().b.b).F(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((xe) getEmojiTextViewHelper().b.b).n(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.i(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        n3 n3Var = this.a;
        if (n3Var != null) {
            n3Var.e = colorStateList;
            n3Var.a = true;
            n3Var.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        n3 n3Var = this.a;
        if (n3Var != null) {
            n3Var.f = mode;
            n3Var.b = true;
            n3Var.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        e4 e4Var = this.c;
        e4Var.j(colorStateList);
        e4Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        e4 e4Var = this.c;
        e4Var.k(mode);
        e4Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(wf0.m(getContext(), i));
    }
}
