package sensei0;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r3 extends EditText implements zy {
    public final k3 a;
    public final e4 b;
    public final i3 c;
    public final be0 d;
    public final i3 f;
    public q3 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        me0.a(context);
        ge0.a(this, getContext());
        k3 k3Var = new k3(this);
        this.a = k3Var;
        k3Var.d(attributeSet, R.attr.editTextStyle);
        e4 e4Var = new e4(this);
        this.b = e4Var;
        e4Var.d(attributeSet, R.attr.editTextStyle);
        e4Var.b();
        i3 i3Var = new i3(2, false);
        i3Var.b = this;
        this.c = i3Var;
        this.d = new be0();
        i3 i3Var2 = new i3(this, 1);
        this.f = i3Var2;
        i3Var2.E(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerD = i3Var2.D(keyListener);
        if (keyListenerD == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerD);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    private q3 getSuperCaller() {
        if (this.h == null) {
            this.h = new q3(this);
        }
        return this.h;
    }

    @Override // sensei0.zy
    public final sb a(sb sbVar) {
        this.d.getClass();
        return be0.a(this, sbVar);
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

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        i3 i3Var;
        if (Build.VERSION.SDK_INT >= 28 || (i3Var = this.c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) i3Var.c;
        return textClassifier == null ? y3.a((TextView) i3Var.b) : textClassifier;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[PHI: r1
      0x003b: PHI (r1v10 java.lang.String[]) = (r1v5 java.lang.String[]), (r1v11 java.lang.String[]) binds: [B:23:0x0052, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r6) {
        /*
            r5 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r6)
            sensei0.e4 r1 = r5.b
            r1.getClass()
            sensei0.e4.f(r6, r0, r5)
            sensei0.pr.G(r6, r0, r5)
            if (r0 == 0) goto L5f
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L5f
            java.lang.String[] r2 = sensei0.ai0.e(r5)
            if (r2 == 0) goto L5f
            sensei0.mm0.c0(r6, r2)
            sensei0.x2 r2 = new sensei0.x2
            r3 = 2
            r2.<init>(r3, r5)
            r3 = 25
            if (r1 < r3) goto L31
            sensei0.cr r1 = new sensei0.cr
            r1.<init>(r0, r2)
        L2f:
            r0 = r1
            goto L5f
        L31:
            java.lang.String[] r4 = sensei0.mm0.b
            if (r1 < r3) goto L3d
            java.lang.String[] r1 = sensei0.nh.e(r6)
            if (r1 == 0) goto L55
        L3b:
            r4 = r1
            goto L55
        L3d:
            android.os.Bundle r1 = r6.extras
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.lang.String r3 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
            if (r1 != 0) goto L52
            android.os.Bundle r1 = r6.extras
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
        L52:
            if (r1 == 0) goto L55
            goto L3b
        L55:
            int r1 = r4.length
            if (r1 != 0) goto L59
            goto L5f
        L59:
            sensei0.dr r1 = new sensei0.dr
            r1.<init>(r0, r2)
            goto L2f
        L5f:
            sensei0.i3 r1 = r5.f
            sensei0.bi r6 = r1.F(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.r3.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zA = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && ai0.e(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = x3.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        pb svVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || ai0.e(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                svVar = new sv(primaryClip, 1);
            } else {
                qb qbVar = new qb();
                qbVar.b = primaryClip;
                qbVar.c = 1;
                svVar = qbVar;
            }
            svVar.x(i == 16908322 ? 0 : 1);
            ai0.g(this, svVar.build());
        }
        return true;
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

    public void setEmojiCompatEnabled(boolean z) {
        this.f.J(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f.D(keyListener));
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

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
