package sensei0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class uw {
    public final Context a;
    public final pw b;
    public final boolean c;
    public final int d;
    public View e;
    public boolean g;
    public zw h;
    public sw i;
    public PopupWindow.OnDismissListener j;
    public int f = 8388611;
    public final tw k = new tw(this);

    public uw(Context context, pw pwVar, View view, boolean z, int i, int i2) {
        this.a = context;
        this.b = pwVar;
        this.e = view;
        this.c = z;
        this.d = i;
    }

    public final sw a() {
        sw pb0Var;
        if (this.i == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                pb0Var = new o7(context, this.e, this.d, this.c);
            } else {
                pb0Var = new pb0(this.a, this.b, this.e, this.d, this.c);
            }
            pb0Var.l(this.b);
            pb0Var.r(this.k);
            pb0Var.n(this.e);
            pb0Var.i(this.h);
            pb0Var.o(this.g);
            pb0Var.p(this.f);
            this.i = pb0Var;
        }
        return this.i;
    }

    public final boolean b() {
        sw swVar = this.i;
        return swVar != null && swVar.h();
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        sw swVarA = a();
        swVarA.s(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            swVarA.q(i);
            swVarA.t(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            swVarA.a = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        swVarA.b();
    }
}
