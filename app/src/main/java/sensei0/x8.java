package sensei0;

import android.app.Dialog;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.sensei.tunnel.MainActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x8 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x8(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                b9 b9Var = (b9) this.b;
                EditText editText = b9Var.i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    b9Var.p();
                    break;
                }
                break;
            case 1:
                ((jh) this.b).t();
                break;
            case 2:
                MainActivity mainActivity = (MainActivity) this.b;
                Dialog dialog = mainActivity.x;
                if (dialog != null) {
                    dialog.dismiss();
                }
                mainActivity.x = null;
                break;
            default:
                tz tzVar = (tz) this.b;
                EditText editText2 = tzVar.f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = tzVar.f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        tzVar.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        tzVar.f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        tzVar.f.setSelection(selectionEnd);
                    }
                    tzVar.p();
                    break;
                }
                break;
        }
    }
}
