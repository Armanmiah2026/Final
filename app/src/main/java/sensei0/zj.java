package sensei0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zj {
    public static lq a(yl0 yl0Var, FoldingFeature foldingFeature) {
        tn tnVar;
        tn tnVar2;
        int type = foldingFeature.getType();
        if (type == 1) {
            tnVar = tn.o;
        } else {
            if (type != 2) {
                return null;
            }
            tnVar = tn.p;
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            tnVar2 = tn.f;
        } else {
            if (state != 2) {
                return null;
            }
            tnVar2 = tn.h;
        }
        Rect bounds = foldingFeature.getBounds();
        pr.i("oemFeature.bounds", bounds);
        int i = bounds.left;
        int i2 = bounds.top;
        int i3 = bounds.right;
        int i4 = bounds.bottom;
        if (i > i3) {
            throw new IllegalArgumentException(za0.j("Left must be less than or equal to right, left: ", i, ", right: ", i3).toString());
        }
        if (i2 > i4) {
            throw new IllegalArgumentException(za0.j("top must be less than or equal to bottom, top: ", i2, ", bottom: ", i4).toString());
        }
        Rect rectA = yl0Var.a.a();
        int i5 = i4 - i2;
        if (i5 == 0 && i3 - i == 0) {
            return null;
        }
        int i6 = i3 - i;
        if (i6 != rectA.width() && i5 != rectA.height()) {
            return null;
        }
        if (i6 < rectA.width() && i5 < rectA.height()) {
            return null;
        }
        if (i6 == rectA.width() && i5 == rectA.height()) {
            return null;
        }
        Rect bounds2 = foldingFeature.getBounds();
        pr.i("oemFeature.bounds", bounds2);
        return new lq(new l6(bounds2), tnVar, tnVar2);
    }

    public static wl0 b(Context context, WindowLayoutInfo windowLayoutInfo) throws Exception {
        yl0 yl0Var;
        pr.j("info", windowLayoutInfo);
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            if (i < 29 || !(context instanceof Activity)) {
                throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
            }
            int i2 = am0.b;
            return c(am0.a((Activity) context), windowLayoutInfo);
        }
        int i3 = am0.b;
        if (i < 30) {
            Context baseContext = context;
            while (baseContext instanceof ContextWrapper) {
                boolean z = baseContext instanceof Activity;
                if (!z && !(baseContext instanceof InputMethodService)) {
                    ContextWrapper contextWrapper = (ContextWrapper) baseContext;
                    if (contextWrapper.getBaseContext() != null) {
                        baseContext = contextWrapper.getBaseContext();
                        pr.i("iterator.baseContext", baseContext);
                    }
                }
                if (z) {
                    yl0Var = am0.a((Activity) context);
                } else {
                    if (!(baseContext instanceof InputMethodService)) {
                        throw new IllegalArgumentException(context + " is not a UiContext");
                    }
                    Object systemService = context.getSystemService("window");
                    pr.g("null cannot be cast to non-null type android.view.WindowManager", systemService);
                    Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                    pr.i("wm.defaultDisplay", defaultDisplay);
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    Rect rect = new Rect(0, 0, point.x, point.y);
                    int i4 = Build.VERSION.SDK_INT;
                    rl0 rl0VarB = (i4 >= 34 ? new el0() : i4 >= 31 ? new dl0() : i4 >= 30 ? new cl0() : i4 >= 29 ? new bl0() : new al0()).b();
                    pr.i("Builder().build()", rl0VarB);
                    yl0Var = new yl0(new l6(rect), rl0VarB);
                }
            }
            throw new IllegalArgumentException("Context " + context + " is not a UiContext");
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        rl0 rl0VarD = rl0.d(null, windowManager.getCurrentWindowMetrics().getWindowInsets());
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        pr.i("wm.currentWindowMetrics.bounds", bounds);
        yl0Var = new yl0(new l6(bounds), rl0VarD);
        return c(yl0Var, windowLayoutInfo);
    }

    public static wl0 c(yl0 yl0Var, WindowLayoutInfo windowLayoutInfo) {
        lq lqVarA;
        pr.j("info", windowLayoutInfo);
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        pr.i("info.displayFeatures", displayFeatures);
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                pr.i("feature", foldingFeature);
                lqVarA = a(yl0Var, foldingFeature);
            } else {
                lqVarA = null;
            }
            if (lqVarA != null) {
                arrayList.add(lqVarA);
            }
        }
        return new wl0(arrayList);
    }
}
