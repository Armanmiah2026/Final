package sensei0;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ra0 extends ContextWrapper {
    public final InputMethodManager a;

    public ra0(Context context, InputMethodManager inputMethodManager) {
        super(context);
        this.a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createDisplayContext(Display display) {
        return new ra0(super.createDisplayContext(display), this.a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return "input_method".equals(str) ? this.a : super.getSystemService(str);
    }
}
