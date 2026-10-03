package sensei0;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b10 {
    public final Activity a;
    public final i3 b;
    public final yl c;
    public v00 d;
    public int e;
    public boolean f = false;

    public b10(vl vlVar, i3 i3Var, vl vlVar2) {
        ws wsVar = new ws(13, this);
        this.a = vlVar;
        this.b = i3Var;
        i3Var.c = wsVar;
        this.c = vlVar2;
        this.e = 1280;
    }

    public final void a(v00 v00Var) {
        ui0 tl0Var;
        Window window = this.a.getWindow();
        mz mzVar = new mz(window.getDecorView());
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            vl0 vl0Var = new vl0(window.getInsetsController(), mzVar);
            vl0Var.e = window;
            tl0Var = vl0Var;
        } else if (i >= 30) {
            ul0 ul0Var = new ul0(window.getInsetsController(), mzVar);
            ul0Var.e = window;
            tl0Var = ul0Var;
        } else {
            tl0Var = i >= 26 ? new tl0(window, mzVar) : new sl0(window, mzVar);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
            window.clearFlags(201326592);
        }
        int i3 = v00Var.b;
        if (i3 != 0) {
            int iU = za0.u(i3);
            if (iU == 0) {
                tl0Var.c(false);
            } else if (iU == 1) {
                tl0Var.c(true);
            }
        }
        Integer num = v00Var.a;
        if (num != null && i2 < 35) {
            window.setStatusBarColor(num.intValue());
        }
        Boolean bool = v00Var.c;
        if (bool != null && i2 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i2 >= 26) {
            int i4 = v00Var.e;
            if (i4 != 0) {
                int iU2 = za0.u(i4);
                if (iU2 == 0) {
                    tl0Var.b(false);
                } else if (iU2 == 1) {
                    tl0Var.b(true);
                }
            }
            Integer num2 = v00Var.d;
            if (num2 != null && i2 < 35) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = v00Var.f;
        if (num3 != null && i2 >= 28 && i2 < 35) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = v00Var.g;
        if (bool2 != null && i2 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.d = v00Var;
    }

    public final void b() {
        boolean z = this.f;
        Activity activity = this.a;
        if (z) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
            qi0.c(activity.getWindow(), false);
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(this.e);
        }
        v00 v00Var = this.d;
        if (v00Var != null) {
            a(v00Var);
        }
    }
}
