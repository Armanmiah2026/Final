package sensei0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sh0 implements View.OnApplyWindowInsetsListener {
    public rl0 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ wy c;

    public sh0(View view, wy wyVar) {
        this.b = view;
        this.c = wyVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        rl0 rl0VarD = rl0.d(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        wy wyVar = this.c;
        if (i < 30) {
            th0.a(windowInsets, this.b);
            if (rl0VarD.equals(this.a)) {
                return wyVar.l(view, rl0VarD).c();
            }
        }
        this.a = rl0VarD;
        rl0 rl0VarL = wyVar.l(view, rl0VarD);
        if (i >= 30) {
            return rl0VarL.c();
        }
        Field field = ai0.a;
        rh0.c(view);
        return rl0VarL.c();
    }
}
