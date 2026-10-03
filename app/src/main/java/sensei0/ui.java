package sensei0;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ui {
    public final /* synthetic */ wi a;

    public ui(wi wiVar) {
        this.a = wiVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        wi wiVar = this.a;
        ti tiVar = wiVar.D;
        if (wiVar.A == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = wiVar.A;
        if (editText != null) {
            editText.removeTextChangedListener(tiVar);
            if (wiVar.A.getOnFocusChangeListener() == wiVar.b().e()) {
                wiVar.A.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        wiVar.A = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(tiVar);
        }
        wiVar.b().l(wiVar.A);
        wiVar.j(wiVar.b());
    }
}
