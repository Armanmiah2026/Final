package sensei0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ri0 {
    public static void a(Context context, ni0 ni0Var) throws Exception {
        Rect rect;
        rl0 rl0VarB;
        Activity activityB = b(context);
        if (activityB != null) {
            zl0.a.getClass();
            int i = am0.b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                rect = ((WindowManager) activityB.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
                pr.i("wm.maximumWindowMetrics.bounds", rect);
            } else {
                Object systemService = activityB.getSystemService("window");
                pr.g("null cannot be cast to non-null type android.view.WindowManager", systemService);
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                pr.i("display", defaultDisplay);
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                rect = new Rect(0, 0, point.x, point.y);
            }
            if (i2 < 30) {
                rl0VarB = (i2 >= 34 ? new el0() : i2 >= 31 ? new dl0() : i2 >= 30 ? new cl0() : i2 >= 29 ? new bl0() : new al0()).b();
                pr.i("{\n            WindowInse…ilder().build()\n        }", rl0VarB);
            } else {
                if (i2 < 30) {
                    throw new Exception("Incompatible SDK version");
                }
                rl0VarB = ub.a.a(activityB);
            }
            int i3 = rect.left;
            int i4 = rect.top;
            int i5 = rect.right;
            int i6 = rect.bottom;
            if (i3 > i5) {
                throw new IllegalArgumentException(za0.j("Left must be less than or equal to right, left: ", i3, ", right: ", i5).toString());
            }
            if (i4 > i6) {
                throw new IllegalArgumentException(za0.j("top must be less than or equal to bottom, top: ", i4, ", bottom: ", i6).toString());
            }
            pr.j("_windowInsetsCompat", rl0VarB);
            ((em) ni0Var).a.updateDisplayMetrics(0, new Rect(i3, i4, i5, i6).width(), new Rect(i3, i4, i5, i6).height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int c(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        throw new IllegalArgumentException(za0.h(i, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static boolean d(View view, oi0 oi0Var) {
        if (view != null) {
            if (oi0Var.b(view)) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (d(viewGroup.getChildAt(i), oi0Var)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
