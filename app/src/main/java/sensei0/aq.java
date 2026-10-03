package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aq implements Cloneable {
    public final cq a;
    public cq b;

    public aq(cq cqVar) {
        this.a = cqVar;
        if (cqVar.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.b = cqVar.i();
    }

    public final cq a() {
        cq cqVarB = b();
        cqVarB.getClass();
        if (cq.f(cqVarB, true)) {
            return cqVarB;
        }
        throw new lg0();
    }

    public final cq b() {
        if (!this.b.g()) {
            return this.b;
        }
        cq cqVar = this.b;
        cqVar.getClass();
        e30 e30Var = e30.c;
        e30Var.getClass();
        e30Var.a(cqVar.getClass()).e(cqVar);
        cqVar.h();
        return this.b;
    }

    public final void c() {
        if (this.b.g()) {
            return;
        }
        cq cqVarI = this.a.i();
        cq cqVar = this.b;
        e30 e30Var = e30.c;
        e30Var.getClass();
        e30Var.a(cqVarI.getClass()).a(cqVarI, cqVar);
        this.b = cqVarI;
    }

    public final Object clone() {
        aq aqVar = (aq) this.a.c(5);
        aqVar.b = b();
        return aqVar;
    }
}
