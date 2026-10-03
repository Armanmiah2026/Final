package sensei0;

import androidx.lifecycle.DefaultLifecycleObserver;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mf implements rt {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;

    public mf(DefaultLifecycleObserver defaultLifecycleObserver, rt rtVar) {
        pr.j("defaultLifecycleObserver", defaultLifecycleObserver);
        this.b = defaultLifecycleObserver;
        this.c = rtVar;
    }

    @Override // sensei0.rt
    public final void f(tt ttVar, lt ltVar) {
        switch (this.a) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.b;
                switch (lf.a[ltVar.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.e(ttVar);
                        break;
                    case 2:
                        defaultLifecycleObserver.a(ttVar);
                        break;
                    case 3:
                        defaultLifecycleObserver.b(ttVar);
                        break;
                    case 4:
                        defaultLifecycleObserver.d(ttVar);
                        break;
                    case 5:
                        defaultLifecycleObserver.g(ttVar);
                        break;
                    case 6:
                        defaultLifecycleObserver.c(ttVar);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                rt rtVar = (rt) this.c;
                if (rtVar != null) {
                    rtVar.f(ttVar, ltVar);
                    return;
                }
                return;
            default:
                HashMap map = ((u8) this.c).a;
                List list = (List) map.get(ltVar);
                Object obj = this.b;
                u8.a(list, ttVar, ltVar, obj);
                u8.a((List) map.get(lt.ON_ANY), ttVar, ltVar, obj);
                return;
        }
    }

    public mf(st stVar) {
        this.b = stVar;
        w8 w8Var = w8.c;
        Class<?> cls = stVar.getClass();
        u8 u8Var = (u8) w8Var.a.get(cls);
        this.c = u8Var == null ? w8Var.a(cls, null) : u8Var;
    }
}
