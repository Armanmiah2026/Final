package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ok0 implements uf {
    public int a;
    public hb b;
    public a60 c;
    public int d;
    public final gg e = new gg(this);
    public int f = 0;
    public boolean g = false;
    public final wf h = new wf(this);
    public final wf i = new wf(this);
    public int j = 1;

    public ok0(hb hbVar) {
        this.b = hbVar;
    }

    public static void b(wf wfVar, wf wfVar2, int i) {
        wfVar.l.add(wfVar2);
        wfVar.f = i;
        wfVar2.k.add(wfVar);
    }

    public static wf h(ta taVar) {
        ta taVar2 = taVar.d;
        if (taVar2 == null) {
            return null;
        }
        hb hbVar = taVar2.b;
        oq oqVar = hbVar.d;
        mh0 mh0Var = hbVar.e;
        int iU = za0.u(taVar2.c);
        if (iU == 1) {
            return oqVar.h;
        }
        if (iU == 2) {
            return mh0Var.h;
        }
        if (iU == 3) {
            return oqVar.i;
        }
        if (iU == 4) {
            return mh0Var.i;
        }
        if (iU != 5) {
            return null;
        }
        return mh0Var.k;
    }

    public static wf i(ta taVar, int i) {
        ta taVar2 = taVar.d;
        if (taVar2 == null) {
            return null;
        }
        hb hbVar = taVar2.b;
        ok0 ok0Var = i == 0 ? hbVar.d : hbVar.e;
        int iU = za0.u(taVar2.c);
        if (iU == 1 || iU == 2) {
            return ok0Var.h;
        }
        if (iU == 3 || iU == 4) {
            return ok0Var.i;
        }
        return null;
    }

    public final void c(wf wfVar, wf wfVar2, int i, gg ggVar) {
        wfVar.l.add(wfVar2);
        wfVar.l.add(this.e);
        wfVar.h = i;
        wfVar.i = ggVar;
        wfVar2.k.add(wfVar);
        ggVar.k.add(wfVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        if (i2 == 0) {
            hb hbVar = this.b;
            int i3 = hbVar.n;
            int iMax = Math.max(hbVar.m, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            hb hbVar2 = this.b;
            int i4 = hbVar2.q;
            int iMax2 = Math.max(hbVar2.p, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public abstract boolean k();

    public final void l(ta taVar, ta taVar2, int i) {
        wf wfVarH = h(taVar);
        wf wfVarH2 = h(taVar2);
        if (wfVarH.j && wfVarH2.j) {
            int iC = taVar.c() + wfVarH.g;
            int iC2 = wfVarH2.g - taVar2.c();
            int i2 = iC2 - iC;
            gg ggVar = this.e;
            if (!ggVar.j && this.d == 3) {
                int i3 = this.a;
                if (i3 == 0) {
                    ggVar.d(g(i2, i));
                } else if (i3 == 1) {
                    ggVar.d(Math.min(g(ggVar.m, i), i2));
                } else if (i3 == 2) {
                    hb hbVar = this.b;
                    hb hbVar2 = hbVar.I;
                    if (hbVar2 != null) {
                        if ((i == 0 ? hbVar2.d : hbVar2.e).e.j) {
                            ggVar.d(g((int) ((r6.g * (i == 0 ? hbVar.o : hbVar.r)) + 0.5f), i));
                        }
                    }
                } else if (i3 == 3) {
                    hb hbVar3 = this.b;
                    ok0 ok0Var = hbVar3.d;
                    mh0 mh0Var = hbVar3.e;
                    if (ok0Var.d != 3 || ok0Var.a != 3 || mh0Var.d != 3 || mh0Var.a != 3) {
                        if (i == 0) {
                            ok0Var = mh0Var;
                        }
                        if (ok0Var.e.j) {
                            float f = hbVar3.L;
                            ggVar.d(i == 1 ? (int) ((r6.g / f) + 0.5f) : (int) ((f * r6.g) + 0.5f));
                        }
                    }
                }
            }
            if (ggVar.j) {
                int i4 = ggVar.g;
                wf wfVar = this.i;
                wf wfVar2 = this.h;
                if (i4 == i2) {
                    wfVar2.d(iC);
                    wfVar.d(iC2);
                    return;
                }
                hb hbVar4 = this.b;
                float f2 = i == 0 ? hbVar4.S : hbVar4.T;
                if (wfVarH == wfVarH2) {
                    iC = wfVarH.g;
                    iC2 = wfVarH2.g;
                    f2 = 0.5f;
                }
                wfVar2.d((int) ((((iC2 - iC) - i4) * f2) + iC + 0.5f));
                wfVar.d(wfVar2.g + ggVar.g);
            }
        }
    }
}
