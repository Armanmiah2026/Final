package sensei0;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uh0 {
    public static rl0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        rl0 rl0VarD = rl0.d(null, rootWindowInsets);
        ol0 ol0Var = rl0VarD.a;
        ol0Var.q(rl0VarD);
        ol0Var.d(view.getRootView());
        return rl0VarD;
    }
}
