package sensei0;

import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y90 {
    public static int a(SidecarDeviceState sidecarDeviceState) {
        pr.j("sidecarDeviceState", sidecarDeviceState);
        try {
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                pr.g("null cannot be cast to non-null type kotlin.Int", objInvoke);
                return ((Integer) objInvoke).intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            return 0;
        }
    }

    public static int b(SidecarDeviceState sidecarDeviceState) {
        pr.j("sidecarDeviceState", sidecarDeviceState);
        int iA = a(sidecarDeviceState);
        if (iA < 0 || iA > 4) {
            return 0;
        }
        return iA;
    }

    public static List c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        List list;
        qi qiVar = qi.a;
        pr.j("info", sidecarWindowLayoutInfo);
        try {
            try {
                list = sidecarWindowLayoutInfo.displayFeatures;
            } catch (NoSuchFieldError unused) {
                Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                pr.g("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>", objInvoke);
                return (List) objInvoke;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return list == null ? qiVar : list;
    }

    public static void d(SidecarDeviceState sidecarDeviceState, int i) {
        try {
            try {
                sidecarDeviceState.posture = i;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } catch (NoSuchFieldError unused2) {
            SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i));
        }
    }
}
