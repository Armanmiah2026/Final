package sensei0;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vd0 extends p0 {
    public final TextInputLayout d;

    public vd0(TextInputLayout textInputLayout) {
        this.d = textInputLayout;
    }

    @Override // sensei0.p0
    public final void d(View view, d1 d1Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z = textInputLayout.C0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        tb0 tb0Var = textInputLayout.b;
        i4 i4Var = tb0Var.b;
        if (i4Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(i4Var);
            accessibilityNodeInfo.setTraversalAfter(i4Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(tb0Var.d);
        }
        if (!zIsEmpty) {
            d1Var.j(text);
        } else if (!TextUtils.isEmpty(string)) {
            d1Var.j(string);
            if (!z && placeholderText != null) {
                d1Var.j(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            d1Var.j(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                d1Var.j(string);
            } else if (i >= 26) {
                accessibilityNodeInfo.setHintText(string);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", string);
            }
            if (i >= 26) {
                accessibilityNodeInfo.setShowingHintText(zIsEmpty);
            } else {
                d1Var.h(4, zIsEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z2) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        i4 i4Var2 = textInputLayout.r.y;
        if (i4Var2 != null) {
            accessibilityNodeInfo.setLabelFor(i4Var2);
        }
        textInputLayout.c.b().m(d1Var);
    }

    @Override // sensei0.p0
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.d.c.b().n(accessibilityEvent);
    }
}
