package sensei0;

import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 {
    public final Method a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Field e;
    public final Method f;

    /* JADX WARN: Multi-variable type inference failed */
    public s1() throws NoSuchMethodException {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Field field;
        Method method5;
        Method method6 = null;
        try {
            method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", null);
        } catch (NoSuchMethodException unused) {
            Log.w("AccessibilityBridge", "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
            method = null;
        }
        try {
            method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", null);
        } catch (NoSuchMethodException unused2) {
            Log.w("AccessibilityBridge", "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
            method2 = null;
        }
        int i = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        if (i > 26) {
            try {
                Field declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                declaredField.setAccessible(true);
                method5 = Class.forName("android.util.LongArray").getMethod("get", cls);
                field = declaredField;
                method4 = null;
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused3) {
                Log.w("AccessibilityBridge", "can't access childNodeIdsField with reflection");
                method4 = null;
                field = null;
                method5 = field;
            }
            this.a = method;
            this.b = method6;
            this.c = method2;
            this.d = method4;
            this.e = field;
            this.f = method5;
        }
        try {
            method3 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", null);
        } catch (NoSuchMethodException unused4) {
            Log.w("AccessibilityBridge", "can't invoke getParentNodeId with reflection");
            method3 = null;
        }
        try {
            method4 = AccessibilityNodeInfo.class.getMethod("getChildId", cls);
            field = null;
        } catch (NoSuchMethodException unused5) {
            Log.w("AccessibilityBridge", "can't invoke getChildId with reflection");
            method4 = null;
            field = null;
        }
        method6 = method3;
        method5 = field;
        this.a = method;
        this.b = method6;
        this.c = method2;
        this.d = method4;
        this.e = field;
        this.f = method5;
    }

    public static Long a(s1 s1Var, AccessibilityRecord accessibilityRecord) {
        Method method = s1Var.c;
        if (method != null) {
            try {
                return (Long) method.invoke(accessibilityRecord, null);
            } catch (IllegalAccessException e) {
                Log.w("AccessibilityBridge", "Failed to access the getRecordSourceNodeId method.", e);
            } catch (InvocationTargetException e2) {
                Log.w("AccessibilityBridge", "The getRecordSourceNodeId method threw an exception when invoked.", e2);
            }
        }
        return null;
    }

    public static boolean b(int i, long j) {
        return (j & (1 << i)) != 0;
    }
}
