package sensei0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j3 extends AutoCompleteTextView {
    public static final int[] d = {R.attr.popupBackground};
    public final k3 a;
    public final e4 b;
    public final i3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        me0.a(context);
        ge0.a(this, getContext());
        o4 o4VarQ = o4.Q(getContext(), attributeSet, d, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) o4VarQ.b).hasValue(0)) {
            setDropDownBackgroundDrawable(o4VarQ.F(0));
        }
        o4VarQ.V();
        k3 k3Var = new k3(this);
        this.a = k3Var;
        k3Var.d(attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        e4 e4Var = new e4(this);
        this.b = e4Var;
        e4Var.d(attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        e4Var.b();
        i3 i3Var = new i3(this, 1);
        this.c = i3Var;
        i3Var.E(attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerD = i3Var.D(keyListener);
        if (keyListenerD == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerD);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        pr.G(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.c.F(inputConnectionOnCreateInputConnection, editorInfo);
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(pr.X(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(wf0.m(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.c.J(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.c.D(keyListener));
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
}
