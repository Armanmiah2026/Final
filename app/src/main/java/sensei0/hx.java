package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hx implements v60 {
    public final n a;
    public final og0 b;
    public final sj c;

    public hx(og0 og0Var, sj sjVar, n nVar) {
        this.b = og0Var;
        sjVar.getClass();
        this.c = sjVar;
        this.a = nVar;
    }

    @Override // sensei0.v60
    public final void a(Object obj, Object obj2) {
        w60.k(this.b, obj, obj2);
    }

    @Override // sensei0.v60
    public final void b(Object obj, sv svVar) {
        this.c.getClass();
        za0.q(obj);
        throw null;
    }

    @Override // sensei0.v60
    public final int c(cq cqVar) {
        this.b.getClass();
        return cqVar.unknownFields.hashCode();
    }

    @Override // sensei0.v60
    public final void d(Object obj, k9 k9Var, rj rjVar) {
        this.b.getClass();
        og0.a(obj);
        this.c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // sensei0.v60
    public final void e(Object obj) {
        this.b.getClass();
        ng0 ng0Var = ((cq) obj).unknownFields;
        if (ng0Var.e) {
            ng0Var.e = false;
        }
        this.c.getClass();
        za0.q(obj);
        throw null;
    }

    @Override // sensei0.v60
    public final boolean f(cq cqVar, cq cqVar2) {
        this.b.getClass();
        return cqVar.unknownFields.equals(cqVar2.unknownFields);
    }

    @Override // sensei0.v60
    public final boolean g(Object obj) {
        this.c.getClass();
        za0.q(obj);
        throw null;
    }

    @Override // sensei0.v60
    public final int h(cq cqVar) {
        this.b.getClass();
        ng0 ng0Var = cqVar.unknownFields;
        int i = ng0Var.d;
        if (i != -1) {
            return i;
        }
        int iX0 = 0;
        for (int i2 = 0; i2 < ng0Var.a; i2++) {
            int i3 = ng0Var.b[i2] >>> 3;
            iX0 += m9.x0(3, (u6) ng0Var.c[i2]) + m9.A0(i3) + m9.z0(2) + (m9.z0(1) * 2);
        }
        ng0Var.d = iX0;
        return iX0;
    }

    @Override // sensei0.v60
    public final cq i() {
        n nVar = this.a;
        return nVar instanceof cq ? ((cq) nVar).i() : ((aq) ((cq) nVar).c(5)).b();
    }
}
