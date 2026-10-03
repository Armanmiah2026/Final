package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hl extends nq {
    public float A0;
    public float B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public ArrayList J0;
    public hb[] K0;
    public hb[] L0;
    public int[] M0;
    public hb[] N0;
    public int O0;
    public int f0;
    public int g0;
    public int h0;
    public int i0;
    public int j0;
    public int k0;
    public boolean l0;
    public int m0;
    public int n0;
    public s5 o0;
    public ya p0;
    public int q0;
    public int r0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public float w0;
    public float x0;
    public float y0;
    public float z0;

    @Override // sensei0.nq
    public final void B() {
        for (int i = 0; i < this.e0; i++) {
            hb hbVar = this.d0[i];
        }
    }

    public final int C(hb hbVar, int i) {
        hb hbVar2;
        if (hbVar != null) {
            int[] iArr = hbVar.c0;
            if (iArr[1] == 3) {
                int i2 = hbVar.k;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (hbVar.r * i);
                        if (i3 != hbVar.i()) {
                            E(iArr[0], hbVar.l(), 1, i3, hbVar);
                        }
                        return i3;
                    }
                    hbVar2 = hbVar;
                    if (i2 == 1) {
                        return hbVar2.i();
                    }
                    if (i2 == 3) {
                        return (int) ((hbVar2.l() * hbVar2.L) + 0.5f);
                    }
                }
            } else {
                hbVar2 = hbVar;
            }
            return hbVar2.i();
        }
        return 0;
    }

    public final int D(hb hbVar, int i) {
        hb hbVar2;
        if (hbVar != null) {
            int[] iArr = hbVar.c0;
            if (iArr[0] == 3) {
                int i2 = hbVar.j;
                if (i2 != 0) {
                    if (i2 == 2) {
                        int i3 = (int) (hbVar.o * i);
                        if (i3 != hbVar.l()) {
                            E(1, i3, iArr[1], hbVar.i(), hbVar);
                        }
                        return i3;
                    }
                    hbVar2 = hbVar;
                    if (i2 == 1) {
                        return hbVar2.l();
                    }
                    if (i2 == 3) {
                        return (int) ((hbVar2.i() * hbVar2.L) + 0.5f);
                    }
                }
            } else {
                hbVar2 = hbVar;
            }
            return hbVar2.l();
        }
        return 0;
    }

    public final void E(int i, int i2, int i3, int i4, hb hbVar) {
        ya yaVar;
        hb hbVar2;
        s5 s5Var = this.o0;
        while (true) {
            yaVar = this.p0;
            if (yaVar != null || (hbVar2 = this.I) == null) {
                break;
            } else {
                this.p0 = ((ib) hbVar2).g0;
            }
        }
        s5Var.a = i;
        s5Var.b = i3;
        s5Var.c = i2;
        s5Var.d = i4;
        yaVar.a(hbVar, s5Var);
        hbVar.y(s5Var.e);
        hbVar.v(s5Var.f);
        hbVar.w = s5Var.h;
        int i5 = s5Var.g;
        hbVar.P = i5;
        hbVar.w = i5 > 0;
    }

    @Override // sensei0.hb
    public final void a(eu euVar) {
        hb hbVar;
        ArrayList arrayList = this.J0;
        super.a(euVar);
        hb hbVar2 = this.I;
        boolean z = hbVar2 != null ? ((ib) hbVar2).h0 : false;
        int i = this.G0;
        if (i != 0) {
            if (i == 1) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    ((fl) arrayList.get(i2)).b(i2, z, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2 && this.M0 != null && this.L0 != null && this.K0 != null) {
                for (int i3 = 0; i3 < this.O0; i3++) {
                    this.N0[i3].t();
                }
                int[] iArr = this.M0;
                int i4 = iArr[0];
                int i5 = iArr[1];
                hb hbVar3 = null;
                for (int i6 = 0; i6 < i4; i6++) {
                    hb hbVar4 = this.L0[z ? (i4 - i6) - 1 : i6];
                    if (hbVar4 != null) {
                        ta taVar = hbVar4.x;
                        if (hbVar4.V != 8) {
                            if (i6 == 0) {
                                hbVar4.e(taVar, this.x, this.j0);
                                hbVar4.X = this.q0;
                                hbVar4.S = this.w0;
                            }
                            if (i6 == i4 - 1) {
                                hbVar4.e(hbVar4.z, this.z, this.k0);
                            }
                            if (i6 > 0) {
                                hbVar4.e(taVar, hbVar3.z, this.C0);
                                hbVar3.e(hbVar3.z, taVar, 0);
                            }
                            hbVar3 = hbVar4;
                        }
                    }
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    hb hbVar5 = this.K0[i7];
                    if (hbVar5 != null) {
                        ta taVar2 = hbVar5.y;
                        if (hbVar5.V != 8) {
                            if (i7 == 0) {
                                hbVar5.e(taVar2, this.y, this.f0);
                                hbVar5.Y = this.r0;
                                hbVar5.T = this.x0;
                            }
                            if (i7 == i5 - 1) {
                                hbVar5.e(hbVar5.A, this.A, this.g0);
                            }
                            if (i7 > 0) {
                                hbVar5.e(taVar2, hbVar3.A, this.D0);
                                hbVar3.e(hbVar3.A, taVar2, 0);
                            }
                            hbVar3 = hbVar5;
                        }
                    }
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    for (int i9 = 0; i9 < i5; i9++) {
                        int i10 = (i9 * i4) + i8;
                        if (this.I0 == 1) {
                            i10 = (i8 * i5) + i9;
                        }
                        hb[] hbVarArr = this.N0;
                        if (i10 < hbVarArr.length && (hbVar = hbVarArr[i10]) != null && hbVar.V != 8) {
                            hb hbVar6 = this.L0[i8];
                            hb hbVar7 = this.K0[i9];
                            if (hbVar != hbVar6) {
                                hbVar.e(hbVar.x, hbVar6.x, 0);
                                hbVar.e(hbVar.z, hbVar6.z, 0);
                            }
                            if (hbVar != hbVar7) {
                                hbVar.e(hbVar.y, hbVar7.y, 0);
                                hbVar.e(hbVar.A, hbVar7.A, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((fl) arrayList.get(0)).b(0, z, true);
        }
        this.l0 = false;
    }
}
