package sensei0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class sk implements tx, xm, l2 {
    public static String q = null;
    public static boolean r = false;
    public static boolean s = false;
    public static int t;
    public static boolean u;
    public af0 a;
    public pk b;
    public Application c;
    public j1 d;
    public nt f;
    public qk h;
    public Activity o;
    public aj p;

    @Override // sensei0.l2
    public final void b() {
        af0 af0Var = this.a;
        ((HashSet) af0Var.d).remove(this.b);
        this.a = null;
        qk qkVar = this.h;
        if (qkVar != null) {
            this.f.b(qkVar);
            this.c.unregisterActivityLifecycleCallbacks(this.h);
        }
        this.f = null;
        this.b.q = null;
        this.b = null;
        this.p.b(null);
        this.p = null;
        this.c = null;
    }

    @Override // sensei0.l2
    public final void c(af0 af0Var) {
        d(af0Var);
    }

    @Override // sensei0.l2
    public final void d(af0 af0Var) {
        this.a = af0Var;
        j1 j1Var = this.d;
        a6 a6Var = (a6) j1Var.b;
        Application application = (Application) ((Context) j1Var.a);
        Activity activity = (Activity) af0Var.a;
        this.o = activity;
        this.c = application;
        this.b = new pk(activity);
        aj ajVar = new aj(a6Var, "miguelruivo.flutter.plugins.filepicker", 1);
        this.p = ajVar;
        ajVar.b(this);
        new aj(a6Var, "miguelruivo.flutter.plugins.filepickerevent", 0).c(new sv(22, this));
        this.h = new qk(activity);
        ((HashSet) af0Var.d).add(this.b);
        nt lifecycle = ((HiddenLifecycleReference) af0Var.b).getLifecycle();
        this.f = lifecycle;
        lifecycle.a(this.h);
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        this.d = null;
    }

    @Override // sensei0.l2
    public final void f() {
        b();
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        this.d = j1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ad  */
    @Override // sensei0.tx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(sensei0.i3 r34, sensei0.rk r35) {
        /*
            Method dump skipped, instruction units count: 974
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.sk.l(sensei0.i3, sensei0.rk):void");
    }
}
