package sensei0;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tz extends xi {
    public final int e;
    public EditText f;
    public final x8 g;

    public tz(wi wiVar, int i) {
        super(wiVar);
        this.e = R.drawable.design_password_eye;
        this.g = new x8(3, this);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // sensei0.xi
    public final void b() {
        p();
    }

    @Override // sensei0.xi
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // sensei0.xi
    public final int d() {
        return this.e;
    }

    @Override // sensei0.xi
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // sensei0.xi
    public final boolean j() {
        return true;
    }

    @Override // sensei0.xi
    public final boolean k() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // sensei0.xi
    public final void l(EditText editText) {
        this.f = editText;
        p();
    }

    @Override // sensei0.xi
    public final void q() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // sensei0.xi
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
