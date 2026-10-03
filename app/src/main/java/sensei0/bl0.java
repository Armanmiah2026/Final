package sensei0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class bl0 extends fl0 {
    public final WindowInsets.Builder c;

    public bl0() {
        this.c = xi0.b();
    }

    @Override // sensei0.fl0
    public rl0 b() {
        a();
        rl0 rl0VarD = rl0.d(null, this.c.build());
        rl0VarD.a.p(this.b);
        return rl0VarD;
    }

    @Override // sensei0.fl0
    public void d(hr hrVar) {
        this.c.setMandatorySystemGestureInsets(hrVar.d());
    }

    @Override // sensei0.fl0
    public void e(hr hrVar) {
        this.c.setStableInsets(hrVar.d());
    }

    @Override // sensei0.fl0
    public void f(hr hrVar) {
        this.c.setSystemGestureInsets(hrVar.d());
    }

    @Override // sensei0.fl0
    public void g(hr hrVar) {
        this.c.setSystemWindowInsets(hrVar.d());
    }

    @Override // sensei0.fl0
    public void h(hr hrVar) {
        this.c.setTappableElementInsets(hrVar.d());
    }

    public bl0(rl0 rl0Var) {
        WindowInsets.Builder builderB;
        super(rl0Var);
        WindowInsets windowInsetsC = rl0Var.c();
        if (windowInsetsC != null) {
            builderB = xi0.c(windowInsetsC);
        } else {
            builderB = xi0.b();
        }
        this.c = builderB;
    }
}
