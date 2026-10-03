package sensei0;

import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yw extends qu implements qw {
    public static final Method H;
    public sv G;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                H = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // sensei0.qw
    public final void f(pw pwVar, MenuItem menuItem) {
        sv svVar = this.G;
        if (svVar != null) {
            svVar.f(pwVar, menuItem);
        }
    }

    @Override // sensei0.qw
    public final void w(pw pwVar, rw rwVar) {
        sv svVar = this.G;
        if (svVar != null) {
            svVar.w(pwVar, rwVar);
        }
    }
}
