package sensei0;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yg0 implements xm, l2 {
    public o4 a;

    @Override // sensei0.l2
    public final void b() {
        o4 o4Var = this.a;
        if (o4Var == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            o4Var.c = null;
        }
    }

    @Override // sensei0.l2
    public final void c(af0 af0Var) {
        d(af0Var);
    }

    @Override // sensei0.l2
    public final void d(af0 af0Var) {
        o4 o4Var = this.a;
        if (o4Var == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            o4Var.c = (Activity) af0Var.a;
        }
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        if (this.a == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
        } else {
            o4.X((a6) j1Var.b, null);
            this.a = null;
        }
    }

    @Override // sensei0.l2
    public final void f() {
        b();
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        o4 o4Var = new o4((Context) j1Var.a, 19);
        this.a = o4Var;
        o4.X((a6) j1Var.b, o4Var);
    }
}
