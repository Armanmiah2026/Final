package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rf0 extends nf0 {
    public final /* synthetic */ int a;
    public mf0 b;

    public /* synthetic */ rf0() {
        this.a = 1;
    }

    @Override // sensei0.nf0, sensei0.jf0
    public void a(mf0 mf0Var) {
        switch (this.a) {
            case 1:
                g5 g5Var = (g5) this.b;
                int i = g5Var.M - 1;
                g5Var.M = i;
                if (i == 0) {
                    g5Var.N = false;
                    g5Var.m();
                }
                mf0Var.z(this);
                break;
            case 2:
                this.b.B();
                mf0Var.z(this);
                break;
        }
    }

    @Override // sensei0.nf0, sensei0.jf0
    public void c(mf0 mf0Var) {
        switch (this.a) {
            case 0:
                g5 g5Var = (g5) this.b;
                g5Var.K.remove(mf0Var);
                if (!g5Var.s()) {
                    g5Var.w(g5Var, lf0.k, false);
                    g5Var.z = true;
                    g5Var.w(g5Var, lf0.j, false);
                }
                break;
        }
    }

    @Override // sensei0.nf0, sensei0.jf0
    public void d(mf0 mf0Var) {
        switch (this.a) {
            case 1:
                g5 g5Var = (g5) this.b;
                if (!g5Var.N) {
                    g5Var.J();
                    g5Var.N = true;
                }
                break;
        }
    }

    public /* synthetic */ rf0(mf0 mf0Var, int i) {
        this.a = i;
        this.b = mf0Var;
    }
}
