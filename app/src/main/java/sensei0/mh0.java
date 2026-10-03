package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mh0 extends ok0 {
    public wf k;
    public r5 l;

    @Override // sensei0.uf
    public final void a(uf ufVar) {
        float f;
        float f2;
        float f3;
        int i;
        if (za0.u(this.j) == 3) {
            hb hbVar = this.b;
            l(hbVar.y, hbVar.A, 1);
            return;
        }
        gg ggVar = this.e;
        if (ggVar.c && !ggVar.j && this.d == 3) {
            hb hbVar2 = this.b;
            int i2 = hbVar2.k;
            if (i2 == 2) {
                hb hbVar3 = hbVar2.I;
                if (hbVar3 != null) {
                    if (hbVar3.e.e.j) {
                        ggVar.d((int) ((r5.g * hbVar2.r) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                gg ggVar2 = hbVar2.d.e;
                if (ggVar2.j) {
                    int i3 = hbVar2.M;
                    if (i3 == -1) {
                        f = ggVar2.g;
                        f2 = hbVar2.L;
                    } else if (i3 == 0) {
                        f3 = ggVar2.g * hbVar2.L;
                        i = (int) (f3 + 0.5f);
                        ggVar.d(i);
                    } else if (i3 != 1) {
                        i = 0;
                        ggVar.d(i);
                    } else {
                        f = ggVar2.g;
                        f2 = hbVar2.L;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    ggVar.d(i);
                }
            }
        }
        wf wfVar = this.h;
        boolean z = wfVar.c;
        ArrayList arrayList = wfVar.l;
        if (z) {
            wf wfVar2 = this.i;
            boolean z2 = wfVar2.c;
            ArrayList arrayList2 = wfVar2.l;
            if (z2) {
                if (wfVar.j && wfVar2.j && ggVar.j) {
                    return;
                }
                if (!ggVar.j && this.d == 3) {
                    hb hbVar4 = this.b;
                    if (hbVar4.j == 0 && !hbVar4.r()) {
                        wf wfVar3 = (wf) arrayList.get(0);
                        wf wfVar4 = (wf) arrayList2.get(0);
                        int i4 = wfVar3.g + wfVar.f;
                        int i5 = wfVar4.g + wfVar2.f;
                        wfVar.d(i4);
                        wfVar2.d(i5);
                        ggVar.d(i5 - i4);
                        return;
                    }
                }
                if (!ggVar.j && this.d == 3 && this.a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    wf wfVar5 = (wf) arrayList.get(0);
                    int i6 = (((wf) arrayList2.get(0)).g + wfVar2.f) - (wfVar5.g + wfVar.f);
                    int i7 = ggVar.m;
                    if (i6 < i7) {
                        ggVar.d(i6);
                    } else {
                        ggVar.d(i7);
                    }
                }
                if (ggVar.j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    wf wfVar6 = (wf) arrayList.get(0);
                    wf wfVar7 = (wf) arrayList2.get(0);
                    int i8 = wfVar6.g;
                    int i9 = wfVar.f + i8;
                    int i10 = wfVar7.g;
                    int i11 = wfVar2.f + i10;
                    float f4 = this.b.T;
                    if (wfVar6 == wfVar7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    wfVar.d((int) ((((i10 - i8) - ggVar.g) * f4) + i8 + 0.5f));
                    wfVar2.d(wfVar.g + ggVar.g);
                }
            }
        }
    }

    @Override // sensei0.ok0
    public final void d() {
        hb hbVar;
        hb hbVar2;
        hb hbVar3;
        hb hbVar4;
        wf wfVar = this.k;
        hb hbVar5 = this.b;
        boolean z = hbVar5.a;
        gg ggVar = this.e;
        if (z) {
            ggVar.d(hbVar5.i());
        }
        boolean z2 = ggVar.j;
        ArrayList arrayList = ggVar.k;
        ArrayList arrayList2 = ggVar.l;
        wf wfVar2 = this.i;
        wf wfVar3 = this.h;
        if (!z2) {
            hb hbVar6 = this.b;
            this.d = hbVar6.c0[1];
            if (hbVar6.w) {
                this.l = new r5(this);
            }
            int i = this.d;
            if (i != 3) {
                if (i == 4 && (hbVar4 = this.b.I) != null) {
                    mh0 mh0Var = hbVar4.e;
                    if (hbVar4.c0[1] == 1) {
                        int i2 = (hbVar4.i() - this.b.y.c()) - this.b.A.c();
                        ok0.b(wfVar3, mh0Var.h, this.b.y.c());
                        ok0.b(wfVar2, mh0Var.i, -this.b.A.c());
                        ggVar.d(i2);
                        return;
                    }
                }
                if (i == 1) {
                    ggVar.d(this.b.i());
                }
            }
        } else if (this.d == 4 && (hbVar2 = (hbVar = this.b).I) != null) {
            mh0 mh0Var2 = hbVar2.e;
            if (hbVar2.c0[1] == 1) {
                ok0.b(wfVar3, mh0Var2.h, hbVar.y.c());
                ok0.b(wfVar2, mh0Var2.i, -this.b.A.c());
                return;
            }
        }
        boolean z3 = ggVar.j;
        if (z3) {
            hb hbVar7 = this.b;
            if (hbVar7.a) {
                ta[] taVarArr = hbVar7.F;
                ta taVar = taVarArr[2];
                ta taVar2 = taVar.d;
                if (taVar2 != null && taVarArr[3].d != null) {
                    if (hbVar7.r()) {
                        wfVar3.f = this.b.F[2].c();
                        wfVar2.f = -this.b.F[3].c();
                    } else {
                        wf wfVarH = ok0.h(this.b.F[2]);
                        if (wfVarH != null) {
                            ok0.b(wfVar3, wfVarH, this.b.F[2].c());
                        }
                        wf wfVarH2 = ok0.h(this.b.F[3]);
                        if (wfVarH2 != null) {
                            ok0.b(wfVar2, wfVarH2, -this.b.F[3].c());
                        }
                        wfVar3.b = true;
                        wfVar2.b = true;
                    }
                    hb hbVar8 = this.b;
                    if (hbVar8.w) {
                        ok0.b(wfVar, wfVar3, hbVar8.P);
                        return;
                    }
                    return;
                }
                if (taVar2 != null) {
                    wf wfVarH3 = ok0.h(taVar);
                    if (wfVarH3 != null) {
                        ok0.b(wfVar3, wfVarH3, this.b.F[2].c());
                        ok0.b(wfVar2, wfVar3, ggVar.g);
                        hb hbVar9 = this.b;
                        if (hbVar9.w) {
                            ok0.b(wfVar, wfVar3, hbVar9.P);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ta taVar3 = taVarArr[3];
                if (taVar3.d != null) {
                    wf wfVarH4 = ok0.h(taVar3);
                    if (wfVarH4 != null) {
                        ok0.b(wfVar2, wfVarH4, -this.b.F[3].c());
                        ok0.b(wfVar3, wfVar2, -ggVar.g);
                    }
                    hb hbVar10 = this.b;
                    if (hbVar10.w) {
                        ok0.b(wfVar, wfVar3, hbVar10.P);
                        return;
                    }
                    return;
                }
                ta taVar4 = taVarArr[4];
                if (taVar4.d != null) {
                    wf wfVarH5 = ok0.h(taVar4);
                    if (wfVarH5 != null) {
                        ok0.b(wfVar, wfVarH5, 0);
                        ok0.b(wfVar3, wfVar, -this.b.P);
                        ok0.b(wfVar2, wfVar3, ggVar.g);
                        return;
                    }
                    return;
                }
                if ((hbVar7 instanceof nq) || hbVar7.I == null || hbVar7.g(7).d != null) {
                    return;
                }
                hb hbVar11 = this.b;
                ok0.b(wfVar3, hbVar11.I.e.h, hbVar11.n());
                ok0.b(wfVar2, wfVar3, ggVar.g);
                hb hbVar12 = this.b;
                if (hbVar12.w) {
                    ok0.b(wfVar, wfVar3, hbVar12.P);
                    return;
                }
                return;
            }
        }
        if (z3 || this.d != 3) {
            ggVar.b(this);
        } else {
            hb hbVar13 = this.b;
            int i3 = hbVar13.k;
            if (i3 == 2) {
                hb hbVar14 = hbVar13.I;
                if (hbVar14 != null) {
                    gg ggVar2 = hbVar14.e.e;
                    arrayList2.add(ggVar2);
                    ggVar2.k.add(ggVar);
                    ggVar.b = true;
                    arrayList.add(wfVar3);
                    arrayList.add(wfVar2);
                }
            } else if (i3 == 3 && !hbVar13.r()) {
                hb hbVar15 = this.b;
                if (hbVar15.j != 3) {
                    gg ggVar3 = hbVar15.d.e;
                    arrayList2.add(ggVar3);
                    ggVar3.k.add(ggVar);
                    ggVar.b = true;
                    arrayList.add(wfVar3);
                    arrayList.add(wfVar2);
                }
            }
        }
        hb hbVar16 = this.b;
        ta[] taVarArr2 = hbVar16.F;
        ta taVar5 = taVarArr2[2];
        ta taVar6 = taVar5.d;
        if (taVar6 != null && taVarArr2[3].d != null) {
            if (hbVar16.r()) {
                wfVar3.f = this.b.F[2].c();
                wfVar2.f = -this.b.F[3].c();
            } else {
                wf wfVarH6 = ok0.h(this.b.F[2]);
                wf wfVarH7 = ok0.h(this.b.F[3]);
                wfVarH6.b(this);
                wfVarH7.b(this);
                this.j = 4;
            }
            if (this.b.w) {
                c(wfVar, wfVar3, 1, this.l);
            }
        } else if (taVar6 != null) {
            wf wfVarH8 = ok0.h(taVar5);
            if (wfVarH8 != null) {
                ok0.b(wfVar3, wfVarH8, this.b.F[2].c());
                c(wfVar2, wfVar3, 1, ggVar);
                if (this.b.w) {
                    c(wfVar, wfVar3, 1, this.l);
                }
                if (this.d == 3) {
                    hb hbVar17 = this.b;
                    if (hbVar17.L > 0.0f) {
                        oq oqVar = hbVar17.d;
                        if (oqVar.d == 3) {
                            oqVar.e.k.add(ggVar);
                            arrayList2.add(this.b.d.e);
                            ggVar.a = this;
                        }
                    }
                }
            }
        } else {
            ta taVar7 = taVarArr2[3];
            if (taVar7.d != null) {
                wf wfVarH9 = ok0.h(taVar7);
                if (wfVarH9 != null) {
                    ok0.b(wfVar2, wfVarH9, -this.b.F[3].c());
                    c(wfVar3, wfVar2, -1, ggVar);
                    if (this.b.w) {
                        c(wfVar, wfVar3, 1, this.l);
                    }
                }
            } else {
                ta taVar8 = taVarArr2[4];
                if (taVar8.d != null) {
                    wf wfVarH10 = ok0.h(taVar8);
                    if (wfVarH10 != null) {
                        ok0.b(wfVar, wfVarH10, 0);
                        c(wfVar3, wfVar, -1, this.l);
                        c(wfVar2, wfVar3, 1, ggVar);
                    }
                } else if (!(hbVar16 instanceof nq) && (hbVar3 = hbVar16.I) != null) {
                    ok0.b(wfVar3, hbVar3.e.h, hbVar16.n());
                    c(wfVar2, wfVar3, 1, ggVar);
                    if (this.b.w) {
                        c(wfVar, wfVar3, 1, this.l);
                    }
                    if (this.d == 3) {
                        hb hbVar18 = this.b;
                        if (hbVar18.L > 0.0f) {
                            oq oqVar2 = hbVar18.d;
                            if (oqVar2.d == 3) {
                                oqVar2.e.k.add(ggVar);
                                arrayList2.add(this.b.d.e);
                                ggVar.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            ggVar.c = true;
        }
    }

    @Override // sensei0.ok0
    public final void e() {
        wf wfVar = this.h;
        if (wfVar.j) {
            this.b.O = wfVar.g;
        }
    }

    @Override // sensei0.ok0
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // sensei0.ok0
    public final boolean k() {
        return this.d != 3 || this.b.k == 0;
    }

    public final void m() {
        this.g = false;
        wf wfVar = this.h;
        wfVar.c();
        wfVar.j = false;
        wf wfVar2 = this.i;
        wfVar2.c();
        wfVar2.j = false;
        wf wfVar3 = this.k;
        wfVar3.c();
        wfVar3.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.b.W;
    }
}
