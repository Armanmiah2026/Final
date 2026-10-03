package sensei0;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xi {
    public final TextInputLayout a;
    public final wi b;
    public final Context c;
    public final CheckableImageButton d;

    public xi(wi wiVar) {
        this.a = wiVar.a;
        this.b = wiVar;
        this.c = wiVar.getContext();
        this.d = wiVar.o;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public x2 h() {
        return null;
    }

    public boolean i(int i) {
        return true;
    }

    public boolean j() {
        return this instanceof jh;
    }

    public boolean k() {
        return false;
    }

    public final void p() {
        this.b.f(false);
    }

    public void l(EditText editText) {
    }

    public void m(d1 d1Var) {
    }

    public void n(AccessibilityEvent accessibilityEvent) {
    }

    public void o(boolean z) {
    }

    public void a() {
    }

    public void b() {
    }

    public void q() {
    }

    public void r() {
    }
}
