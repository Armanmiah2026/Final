package sensei0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class di implements InputFilter {
    public final TextView a;
    public ci b;

    public di(TextView textView) {
        this.a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = uh.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i != 0 || i2 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return uh.a().e(charSequence, 0, charSequence.length());
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        uh uhVarA = uh.a();
        if (this.b == null) {
            this.b = new ci(textView, this);
        }
        uhVarA.f(this.b);
        return charSequence;
    }
}
