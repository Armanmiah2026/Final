package sensei0;

import android.content.Context;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ub {
    public static final ub a = new ub();

    public final rl0 a(Context context) {
        pr.j("context", context);
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        pr.i("context.getSystemService…indowMetrics.windowInsets", windowInsets);
        return rl0.d(null, windowInsets);
    }
}
