package sensei0;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class am0 implements zl0 {
    public static final /* synthetic */ int b = 0;

    static {
        p9.d0(1, 2, 4, 8, 16, 32, 64, 128);
    }

    public static yl0 a(Activity activity) throws Exception {
        Rect rect;
        rl0 rl0VarB;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            rect = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
            pr.i("wm.currentWindowMetrics.bounds", rect);
        } else if (i >= 29) {
            Configuration configuration = activity.getResources().getConfiguration();
            try {
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(configuration);
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                pr.g("null cannot be cast to non-null type android.graphics.Rect", objInvoke);
                rect = new Rect((Rect) objInvoke);
            } catch (IllegalAccessException e) {
                Log.w("am0", e);
                rect = b(activity);
            } catch (NoSuchFieldException e2) {
                Log.w("am0", e2);
                rect = b(activity);
            } catch (NoSuchMethodException e3) {
                Log.w("am0", e3);
                rect = b(activity);
            } catch (InvocationTargetException e4) {
                Log.w("am0", e4);
                rect = b(activity);
            }
        } else if (i >= 28) {
            rect = b(activity);
        } else {
            rect = new Rect();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getRectSize(rect);
            if (!activity.isInMultiWindowMode()) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
                int i2 = rect.bottom + dimensionPixelSize;
                if (i2 == point.y) {
                    rect.bottom = i2;
                } else {
                    int i3 = rect.right + dimensionPixelSize;
                    if (i3 == point.x) {
                        rect.right = i3;
                    }
                }
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 30) {
            rl0VarB = (i4 >= 34 ? new el0() : i4 >= 31 ? new dl0() : i4 >= 30 ? new cl0() : i4 >= 29 ? new bl0() : new al0()).b();
            pr.i("{\n            WindowInse…ilder().build()\n        }", rl0VarB);
        } else {
            if (i4 < 30) {
                throw new Exception("Incompatible SDK version");
            }
            rl0VarB = ub.a.a(activity);
        }
        return new yl0(new l6(rect), rl0VarB);
    }

    public static Rect b(Activity activity) {
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        DisplayCutout displayCutoutH = null;
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                pr.g("null cannot be cast to non-null type android.graphics.Rect", objInvoke);
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                pr.g("null cannot be cast to non-null type android.graphics.Rect", objInvoke2);
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e) {
            Log.w("am0", e);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchFieldException e2) {
            Log.w("am0", e2);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchMethodException e3) {
            Log.w("am0", e3);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (InvocationTargetException e4) {
            Log.w("am0", e4);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        pr.i("currentDisplay", defaultDisplay);
        defaultDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            int i = rect.bottom + dimensionPixelSize;
            if (i == point.y) {
                rect.bottom = i;
            } else {
                int i2 = rect.right + dimensionPixelSize;
                if (i2 == point.x) {
                    rect.right = i2;
                } else if (rect.left == dimensionPixelSize) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode()) {
            try {
                Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                constructor.setAccessible(true);
                Object objNewInstance = constructor.newInstance(null);
                Method declaredMethod = defaultDisplay.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(defaultDisplay, objNewInstance);
                Field declaredField2 = objNewInstance.getClass().getDeclaredField("displayCutout");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(objNewInstance);
                if (u10.l(obj2)) {
                    displayCutoutH = u10.h(obj2);
                }
            } catch (ClassNotFoundException e5) {
                Log.w("am0", e5);
            } catch (IllegalAccessException e6) {
                Log.w("am0", e6);
            } catch (InstantiationException e7) {
                Log.w("am0", e7);
            } catch (NoSuchFieldException e8) {
                Log.w("am0", e8);
            } catch (NoSuchMethodException e9) {
                Log.w("am0", e9);
            } catch (InvocationTargetException e10) {
                Log.w("am0", e10);
            }
            if (displayCutoutH != null) {
                if (rect.left == displayCutoutH.getSafeInsetLeft()) {
                    rect.left = 0;
                }
                if (point.x - rect.right == displayCutoutH.getSafeInsetRight()) {
                    rect.right = displayCutoutH.getSafeInsetRight() + rect.right;
                }
                if (rect.top == displayCutoutH.getSafeInsetTop()) {
                    rect.top = 0;
                }
                if (point.y - rect.bottom == displayCutoutH.getSafeInsetBottom()) {
                    rect.bottom = displayCutoutH.getSafeInsetBottom() + rect.bottom;
                }
            }
        }
        return rect;
    }
}
