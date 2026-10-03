package sensei0;

import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class da0 {
    public static final /* synthetic */ int b = 0;
    public final int a;

    public da0() {
        za0.p(3, "verificationMode");
        this.a = 3;
    }

    public static boolean a(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (pr.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return pr.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public static boolean b(List list, List list2) {
        if (list == list2) {
            return true;
        }
        if (list.size() == list2.size()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (a((SidecarDisplayFeature) list.get(i), (SidecarDisplayFeature) list2.get(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public final ArrayList c(List list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            lq lqVarE = e((SidecarDisplayFeature) it.next(), sidecarDeviceState);
            if (lqVarE != null) {
                arrayList.add(lqVarE);
            }
        }
        return arrayList;
    }

    public final wl0 d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new wl0(qi.a);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        y90.d(sidecarDeviceState2, y90.b(sidecarDeviceState));
        return new wl0(c(y90.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final lq e(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        tn tnVar;
        tn tnVar2 = tn.f;
        pr.j("feature", sidecarDisplayFeature);
        mh mhVar = mh.b;
        int i = this.a;
        za0.p(i, "verificationMode");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) new dh0(sidecarDisplayFeature, i, mhVar).S("Type must be either TYPE_FOLD or TYPE_HINGE", z90.b).S("Feature bounds must not be 0", aa0.b).S("TYPE_FOLD must have 0 area", ba0.b).S("Feature be pinned to either left or top", ca0.b).i();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            tnVar = tn.o;
        } else {
            if (type != 2) {
                return null;
            }
            tnVar = tn.p;
        }
        int iB = y90.b(sidecarDeviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            tnVar2 = tn.h;
        } else if (iB != 3 && iB == 4) {
            return null;
        }
        Rect rect = sidecarDisplayFeature.getRect();
        pr.i("feature.rect", rect);
        return new lq(new l6(rect), tnVar, tnVar2);
    }
}
