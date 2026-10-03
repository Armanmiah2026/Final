package sensei0;

import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h00 implements fp {
    public final /* synthetic */ int a;
    public final /* synthetic */ i3 b;

    public /* synthetic */ h00(i3 i3Var, int i) {
        this.a = i;
        this.b = i3Var;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        List listF0;
        List listF02;
        v50 v50Var = (v50) obj;
        switch (this.a) {
            case 0:
                Throwable thA = v50.a(v50Var.a);
                i3 i3Var = this.b;
                if (thA != null) {
                    if (thA instanceof t2) {
                        t2 t2Var = (t2) thA;
                        listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                    } else {
                        listF0 = p9.f0(thA.getClass().getSimpleName(), thA.toString(), za0.m("Cause: ", thA.getCause(), ", Stacktrace: ", Log.getStackTraceString(thA)));
                    }
                    i3Var.s(listF0);
                } else {
                    Object obj2 = v50Var.a;
                    if (obj2 instanceof u50) {
                        obj2 = null;
                    }
                    i3Var.s(k6.G((Boolean) obj2));
                }
                break;
            default:
                Throwable thA2 = v50.a(v50Var.a);
                i3 i3Var2 = this.b;
                if (thA2 != null) {
                    if (thA2 instanceof t2) {
                        t2 t2Var2 = (t2) thA2;
                        listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                    } else {
                        listF02 = p9.f0(thA2.getClass().getSimpleName(), thA2.toString(), za0.m("Cause: ", thA2.getCause(), ", Stacktrace: ", Log.getStackTraceString(thA2)));
                    }
                    i3Var2.s(listF02);
                } else {
                    Object obj3 = v50Var.a;
                    if (obj3 instanceof u50) {
                        obj3 = null;
                    }
                    i3Var2.s(k6.G((String) obj3));
                }
                break;
        }
        return mg0.a;
    }
}
