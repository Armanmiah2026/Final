package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fl0 {
    public final rl0 a;
    public hr[] b;

    public fl0() {
        this(new rl0());
    }

    public final void a() {
        hr[] hrVarArr = this.b;
        if (hrVarArr != null) {
            hr hrVarF = hrVarArr[0];
            hr hrVarF2 = hrVarArr[1];
            rl0 rl0Var = this.a;
            if (hrVarF2 == null) {
                hrVarF2 = rl0Var.a.f(2);
            }
            if (hrVarF == null) {
                hrVarF = rl0Var.a.f(1);
            }
            g(hr.a(hrVarF, hrVarF2));
            hr hrVar = this.b[ri0.c(16)];
            if (hrVar != null) {
                f(hrVar);
            }
            hr hrVar2 = this.b[ri0.c(32)];
            if (hrVar2 != null) {
                d(hrVar2);
            }
            hr hrVar3 = this.b[ri0.c(64)];
            if (hrVar3 != null) {
                h(hrVar3);
            }
        }
    }

    public abstract rl0 b();

    public void c(int i, hr hrVar) {
        if (this.b == null) {
            this.b = new hr[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.b[ri0.c(i2)] = hrVar;
            }
        }
    }

    public abstract void e(hr hrVar);

    public abstract void g(hr hrVar);

    public fl0(rl0 rl0Var) {
        this.a = rl0Var;
    }

    public void d(hr hrVar) {
    }

    public void f(hr hrVar) {
    }

    public void h(hr hrVar) {
    }
}
