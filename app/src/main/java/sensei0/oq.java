package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class oq extends ok0 {
    public static final int[] k = new int[2];

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    @Override // sensei0.uf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sensei0.uf r24) {
        /*
            Method dump skipped, instruction units count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.oq.a(sensei0.uf):void");
    }

    @Override // sensei0.ok0
    public final void d() {
        hb hbVar;
        hb hbVar2;
        hb hbVar3;
        hb hbVar4;
        hb hbVar5 = this.b;
        boolean z = hbVar5.a;
        gg ggVar = this.e;
        if (z) {
            ggVar.d(hbVar5.l());
        }
        boolean z2 = ggVar.j;
        ArrayList arrayList = ggVar.k;
        ArrayList arrayList2 = ggVar.l;
        wf wfVar = this.i;
        wf wfVar2 = this.h;
        if (!z2) {
            hb hbVar6 = this.b;
            int i = hbVar6.c0[0];
            this.d = i;
            if (i != 3) {
                if (i == 4 && (((hbVar4 = hbVar6.I) != null && hbVar4.c0[0] == 1) || hbVar4.c0[0] == 4)) {
                    int iL = hbVar4.l();
                    oq oqVar = hbVar4.d;
                    int iC = (iL - this.b.x.c()) - this.b.z.c();
                    ok0.b(wfVar2, oqVar.h, this.b.x.c());
                    ok0.b(wfVar, oqVar.i, -this.b.z.c());
                    ggVar.d(iC);
                    return;
                }
                if (i == 1) {
                    ggVar.d(hbVar6.l());
                }
            }
        } else if (this.d == 4 && (((hbVar2 = (hbVar = this.b).I) != null && hbVar2.c0[0] == 1) || hbVar2.c0[0] == 4)) {
            ok0.b(wfVar2, hbVar2.d.h, hbVar.x.c());
            ok0.b(wfVar, hbVar2.d.i, -this.b.z.c());
            return;
        }
        if (ggVar.j) {
            hb hbVar7 = this.b;
            if (hbVar7.a) {
                ta[] taVarArr = hbVar7.F;
                ta taVar = taVarArr[0];
                ta taVar2 = taVar.d;
                if (taVar2 != null && taVarArr[1].d != null) {
                    if (hbVar7.q()) {
                        wfVar2.f = this.b.F[0].c();
                        wfVar.f = -this.b.F[1].c();
                        return;
                    }
                    wf wfVarH = ok0.h(this.b.F[0]);
                    if (wfVarH != null) {
                        ok0.b(wfVar2, wfVarH, this.b.F[0].c());
                    }
                    wf wfVarH2 = ok0.h(this.b.F[1]);
                    if (wfVarH2 != null) {
                        ok0.b(wfVar, wfVarH2, -this.b.F[1].c());
                    }
                    wfVar2.b = true;
                    wfVar.b = true;
                    return;
                }
                if (taVar2 != null) {
                    wf wfVarH3 = ok0.h(taVar);
                    if (wfVarH3 != null) {
                        ok0.b(wfVar2, wfVarH3, this.b.F[0].c());
                        ok0.b(wfVar, wfVar2, ggVar.g);
                        return;
                    }
                    return;
                }
                ta taVar3 = taVarArr[1];
                if (taVar3.d != null) {
                    wf wfVarH4 = ok0.h(taVar3);
                    if (wfVarH4 != null) {
                        ok0.b(wfVar, wfVarH4, -this.b.F[1].c());
                        ok0.b(wfVar2, wfVar, -ggVar.g);
                        return;
                    }
                    return;
                }
                if ((hbVar7 instanceof nq) || hbVar7.I == null || hbVar7.g(7).d != null) {
                    return;
                }
                hb hbVar8 = this.b;
                ok0.b(wfVar2, hbVar8.I.d.h, hbVar8.m());
                ok0.b(wfVar, wfVar2, ggVar.g);
                return;
            }
        }
        if (this.d == 3) {
            hb hbVar9 = this.b;
            int i2 = hbVar9.j;
            mh0 mh0Var = hbVar9.e;
            if (i2 == 2) {
                hb hbVar10 = hbVar9.I;
                if (hbVar10 != null) {
                    gg ggVar2 = hbVar10.e.e;
                    arrayList2.add(ggVar2);
                    ggVar2.k.add(ggVar);
                    ggVar.b = true;
                    arrayList.add(wfVar2);
                    arrayList.add(wfVar);
                }
            } else if (i2 == 3) {
                if (hbVar9.k == 3) {
                    wfVar2.a = this;
                    wfVar.a = this;
                    mh0Var.h.a = this;
                    mh0Var.i.a = this;
                    ggVar.a = this;
                    if (hbVar9.r()) {
                        arrayList2.add(this.b.e.e);
                        this.b.e.e.k.add(ggVar);
                        mh0 mh0Var2 = this.b.e;
                        mh0Var2.e.a = this;
                        arrayList2.add(mh0Var2.h);
                        arrayList2.add(this.b.e.i);
                        this.b.e.h.k.add(ggVar);
                        this.b.e.i.k.add(ggVar);
                    } else if (this.b.q()) {
                        this.b.e.e.l.add(ggVar);
                        arrayList.add(this.b.e.e);
                    } else {
                        this.b.e.e.l.add(ggVar);
                    }
                } else {
                    gg ggVar3 = mh0Var.e;
                    arrayList2.add(ggVar3);
                    ggVar3.k.add(ggVar);
                    this.b.e.h.k.add(ggVar);
                    this.b.e.i.k.add(ggVar);
                    ggVar.b = true;
                    arrayList.add(wfVar2);
                    arrayList.add(wfVar);
                    wfVar2.l.add(ggVar);
                    wfVar.l.add(ggVar);
                }
            }
        }
        hb hbVar11 = this.b;
        ta[] taVarArr2 = hbVar11.F;
        ta taVar4 = taVarArr2[0];
        ta taVar5 = taVar4.d;
        if (taVar5 != null && taVarArr2[1].d != null) {
            if (hbVar11.q()) {
                wfVar2.f = this.b.F[0].c();
                wfVar.f = -this.b.F[1].c();
                return;
            }
            wf wfVarH5 = ok0.h(this.b.F[0]);
            wf wfVarH6 = ok0.h(this.b.F[1]);
            wfVarH5.b(this);
            wfVarH6.b(this);
            this.j = 4;
            return;
        }
        if (taVar5 != null) {
            wf wfVarH7 = ok0.h(taVar4);
            if (wfVarH7 != null) {
                ok0.b(wfVar2, wfVarH7, this.b.F[0].c());
                c(wfVar, wfVar2, 1, ggVar);
                return;
            }
            return;
        }
        ta taVar6 = taVarArr2[1];
        if (taVar6.d != null) {
            wf wfVarH8 = ok0.h(taVar6);
            if (wfVarH8 != null) {
                ok0.b(wfVar, wfVarH8, -this.b.F[1].c());
                c(wfVar2, wfVar, -1, ggVar);
                return;
            }
            return;
        }
        if ((hbVar11 instanceof nq) || (hbVar3 = hbVar11.I) == null) {
            return;
        }
        ok0.b(wfVar2, hbVar3.d.h, hbVar11.m());
        c(wfVar, wfVar2, 1, ggVar);
    }

    @Override // sensei0.ok0
    public final void e() {
        wf wfVar = this.h;
        if (wfVar.j) {
            this.b.N = wfVar.g;
        }
    }

    @Override // sensei0.ok0
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // sensei0.ok0
    public final boolean k() {
        return this.d != 3 || this.b.j == 0;
    }

    public final void n() {
        this.g = false;
        wf wfVar = this.h;
        wfVar.c();
        wfVar.j = false;
        wf wfVar2 = this.i;
        wfVar2.c();
        wfVar2.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.b.W;
    }
}
