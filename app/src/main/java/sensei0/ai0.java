package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ai0 {
    public static Field a = null;
    public static boolean b = false;
    public static final int[] c = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final oh0 d = new oh0();
    public static final qh0 e = new qh0();

    public static void a(View view, rl0 rl0Var) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsC = rl0Var.c();
        if (windowInsetsC != null) {
            WindowInsets windowInsetsA = i >= 30 ? yh0.a(view, windowInsetsC) : rh0.a(view, windowInsetsC);
            if (windowInsetsA.equals(windowInsetsC)) {
                return;
            }
            rl0.d(view, windowInsetsA);
        }
    }

    public static View.AccessibilityDelegate b(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return xh0.a(view);
        }
        if (b) {
            return null;
        }
        if (a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                b = true;
                return null;
            }
        }
        try {
            Object obj = a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            b = true;
            return null;
        }
    }

    public static CharSequence c(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = wh0.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList d(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] e(r3 r3Var) {
        return Build.VERSION.SDK_INT >= 31 ? zh0.a(r3Var) : (String[]) r3Var.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void f(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = c(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(c(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(c(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static sb g(View view, sb sbVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + sbVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return zh0.b(view, sbVar);
        }
        be0 be0Var = (be0) view.getTag(R.id.tag_on_receive_content_listener);
        zy zyVar = d;
        if (be0Var == null) {
            if (view instanceof zy) {
                zyVar = (zy) view;
            }
            return zyVar.a(sbVar);
        }
        sb sbVarA = be0.a(view, sbVar);
        if (sbVarA == null) {
            return null;
        }
        if (view instanceof zy) {
            zyVar = (zy) view;
        }
        return zyVar.a(sbVarA);
    }

    public static void h(View view, int i) {
        ArrayList arrayListD = d(view);
        for (int i2 = 0; i2 < arrayListD.size(); i2++) {
            if (((x0) arrayListD.get(i2)).a() == i) {
                arrayListD.remove(i2);
                return;
            }
        }
    }

    public static void i(View view, x0 x0Var, r1 r1Var) {
        x0 x0Var2 = new x0(null, x0Var.b, null, r1Var, x0Var.c);
        View.AccessibilityDelegate accessibilityDelegateB = b(view);
        p0 p0Var = accessibilityDelegateB == null ? null : accessibilityDelegateB instanceof o0 ? ((o0) accessibilityDelegateB).a : new p0(accessibilityDelegateB);
        if (p0Var == null) {
            p0Var = new p0();
        }
        k(view, p0Var);
        h(view, x0Var2.a());
        d(view).add(x0Var2);
        f(view, 0);
    }

    public static void j(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            xh0.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void k(View view, p0 p0Var) {
        if (p0Var == null && (b(view) instanceof o0)) {
            p0Var = new p0();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(p0Var == null ? null : p0Var.b);
    }

    public static void l(View view, CharSequence charSequence) {
        new ph0(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 0).d(view, charSequence);
        qh0 qh0Var = e;
        if (charSequence == null) {
            qh0Var.a.remove(view);
            view.removeOnAttachStateChangeListener(qh0Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(qh0Var);
        } else {
            qh0Var.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(qh0Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(qh0Var);
            }
        }
    }
}
