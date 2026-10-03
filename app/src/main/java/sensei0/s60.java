package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s60 {
    public boolean a;
    public final Object b;
    public final Object c;

    public s60(t60 t60Var) {
        this.b = t60Var;
        r60 r60Var = new r60();
        r60Var.c = new k60();
        this.c = r60Var;
    }

    public void a(double d, double d2) {
        double[] dArr = (double[]) this.b;
        double d3 = 1.0d;
        if (!this.a) {
            d3 = 1.0d / (((dArr[7] * d2) + (dArr[3] * d)) + dArr[15]);
        }
        double d4 = ((dArr[4] * d2) + (dArr[0] * d) + dArr[12]) * d3;
        double d5 = ((dArr[5] * d2) + (dArr[1] * d) + dArr[13]) * d3;
        double[] dArr2 = (double[]) this.c;
        if (d4 < dArr2[0]) {
            dArr2[0] = d4;
        } else if (d4 > dArr2[1]) {
            dArr2[1] = d4;
        }
        if (d5 < dArr2[2]) {
            dArr2[2] = d5;
        } else if (d5 > dArr2[3]) {
            dArr2[3] = d5;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, sensei0.tt] */
    public void b() {
        tt r0 = this.b;
        vt vtVarB = r0.b();
        if (vtVarB.c != mt.b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        vtVarB.a(new x30(0, r0));
        final r60 r60Var = (r60) this.c;
        r60Var.getClass();
        if (r60Var.a) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        vtVarB.a(new rt() { // from class: sensei0.p60
            @Override // sensei0.rt
            public final void f(tt ttVar, lt ltVar) {
                pr.j("this$0", r60Var);
            }
        });
        r60Var.a = true;
        this.a = true;
    }

    public s60(boolean z, double[] dArr, double[] dArr2) {
        this.a = z;
        this.b = dArr;
        this.c = dArr2;
    }
}
