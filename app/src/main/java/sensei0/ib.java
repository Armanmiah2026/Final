package sensei0;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ib extends hb {
    public ArrayList d0 = new ArrayList();
    public final o4 e0 = new o4(this);
    public final vf f0;
    public ya g0;
    public boolean h0;
    public final eu i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public p7[] n0;
    public p7[] o0;
    public int p0;
    public boolean q0;
    public boolean r0;

    public ib() {
        vf vfVar = new vf();
        vfVar.b = true;
        vfVar.c = true;
        vfVar.e = new ArrayList();
        new ArrayList();
        vfVar.f = null;
        vfVar.g = new s5();
        vfVar.h = new ArrayList();
        vfVar.a = this;
        vfVar.d = this;
        this.f0 = vfVar;
        this.g0 = null;
        this.h0 = false;
        this.i0 = new eu();
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = new p7[4];
        this.o0 = new p7[4];
        this.p0 = 263;
        this.q0 = false;
        this.r0 = false;
    }

    public final void B(hb hbVar, int i) {
        if (i == 0) {
            int i2 = this.l0 + 1;
            p7[] p7VarArr = this.o0;
            if (i2 >= p7VarArr.length) {
                this.o0 = (p7[]) Arrays.copyOf(p7VarArr, p7VarArr.length * 2);
            }
            p7[] p7VarArr2 = this.o0;
            int i3 = this.l0;
            p7VarArr2[i3] = new p7(hbVar, 0, this.h0);
            this.l0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.m0 + 1;
            p7[] p7VarArr3 = this.n0;
            if (i4 >= p7VarArr3.length) {
                this.n0 = (p7[]) Arrays.copyOf(p7VarArr3, p7VarArr3.length * 2);
            }
            p7[] p7VarArr4 = this.n0;
            int i5 = this.m0;
            p7VarArr4[i5] = new p7(hbVar, 1, this.h0);
            this.m0 = i5 + 1;
        }
    }

    public final void C(eu euVar) {
        int i;
        int i2;
        a(euVar);
        int size = this.d0.size();
        char c = 0;
        int i3 = 0;
        boolean z = false;
        while (true) {
            i = 1;
            if (i3 >= size) {
                break;
            }
            hb hbVar = (hb) this.d0.get(i3);
            boolean[] zArr = hbVar.H;
            zArr[0] = false;
            zArr[1] = false;
            if (hbVar instanceof k5) {
                z = true;
            }
            i3++;
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                hb hbVar2 = (hb) this.d0.get(i4);
                if (hbVar2 instanceof k5) {
                    k5 k5Var = (k5) hbVar2;
                    for (int i5 = 0; i5 < k5Var.e0; i5++) {
                        hb hbVar3 = k5Var.d0[i5];
                        int i6 = k5Var.f0;
                        if (i6 == 0 || i6 == 1) {
                            hbVar3.H[0] = true;
                        } else if (i6 == 2 || i6 == 3) {
                            hbVar3.H[1] = true;
                        }
                    }
                }
            }
        }
        for (int i7 = 0; i7 < size; i7++) {
            hb hbVar4 = (hb) this.d0.get(i7);
            hbVar4.getClass();
            if ((hbVar4 instanceof hl) || (hbVar4 instanceof hq)) {
                hbVar4.a(euVar);
            }
        }
        int i8 = 0;
        while (i8 < size) {
            hb hbVar5 = (hb) this.d0.get(i8);
            if (hbVar5 instanceof ib) {
                int[] iArr = hbVar5.c0;
                int i9 = iArr[c];
                int i10 = iArr[i];
                if (i9 == 2) {
                    hbVar5.w(i);
                }
                if (i10 == 2) {
                    hbVar5.x(i);
                }
                hbVar5.a(euVar);
                if (i9 == 2) {
                    hbVar5.w(i9);
                }
                if (i10 == 2) {
                    hbVar5.x(i10);
                }
                i2 = i;
            } else {
                hbVar5.h = -1;
                ta taVar = hbVar5.B;
                int[] iArr2 = hbVar5.c0;
                ta taVar2 = hbVar5.A;
                ta taVar3 = hbVar5.y;
                ta taVar4 = hbVar5.z;
                ta taVar5 = hbVar5.x;
                hbVar5.i = -1;
                int[] iArr3 = this.c0;
                i2 = i;
                if (iArr3[c] != 2 && iArr2[c] == 4) {
                    int i11 = taVar5.e;
                    int iL = l() - taVar4.e;
                    taVar5.g = euVar.j(taVar5);
                    taVar4.g = euVar.j(taVar4);
                    euVar.d(taVar5.g, i11);
                    euVar.d(taVar4.g, iL);
                    hbVar5.h = 2;
                    hbVar5.N = i11;
                    int i12 = iL - i11;
                    hbVar5.J = i12;
                    int i13 = hbVar5.Q;
                    if (i12 < i13) {
                        hbVar5.J = i13;
                    }
                }
                if (iArr3[i2] != 2 && iArr2[i2] == 4) {
                    int i14 = taVar3.e;
                    int i15 = i() - taVar2.e;
                    taVar3.g = euVar.j(taVar3);
                    taVar2.g = euVar.j(taVar2);
                    euVar.d(taVar3.g, i14);
                    euVar.d(taVar2.g, i15);
                    if (hbVar5.P > 0 || hbVar5.V == 8) {
                        ab0 ab0VarJ = euVar.j(taVar);
                        taVar.g = ab0VarJ;
                        euVar.d(ab0VarJ, hbVar5.P + i14);
                    }
                    hbVar5.i = 2;
                    hbVar5.O = i14;
                    int i16 = i15 - i14;
                    hbVar5.K = i16;
                    int i17 = hbVar5.R;
                    if (i16 < i17) {
                        hbVar5.K = i17;
                    }
                }
                if (!(hbVar5 instanceof hl) && !(hbVar5 instanceof hq)) {
                    hbVar5.a(euVar);
                }
            }
            i8++;
            i = i2;
            c = 0;
        }
        int i18 = i;
        if (this.l0 > 0) {
            mm0.c(this, euVar, 0);
        }
        if (this.m0 > 0) {
            mm0.c(this, euVar, i18);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean D(int i, boolean z) {
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        vf vfVar = this.f0;
        ArrayList arrayList = vfVar.e;
        ib ibVar = vfVar.a;
        int i4 = 0;
        int iH = ibVar.h(0);
        int[] iArr = ibVar.c0;
        mh0 mh0Var = ibVar.e;
        oq oqVar = ibVar.d;
        int iH2 = ibVar.h(1);
        int iM = ibVar.m();
        int iN = ibVar.n();
        if (z && (iH == 2 || iH2 == 2)) {
            int size = arrayList.size();
            while (true) {
                if (i4 >= size) {
                    z4 = z;
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                ok0 ok0Var = (ok0) obj;
                if (ok0Var.f == i && !ok0Var.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && iH == 2) {
                    ibVar.w(1);
                    ibVar.y(vfVar.d(ibVar, 0));
                    oqVar.e.d(ibVar.l());
                }
            } else if (z4 && iH2 == 2) {
                ibVar.x(1);
                ibVar.v(vfVar.d(ibVar, 1));
                mh0Var.e.d(ibVar.i());
            }
        }
        if (i == 0) {
            i2 = 0;
            int i5 = iArr[0];
            if (i5 == 1 || i5 == 4) {
                int iL = ibVar.l() + iM;
                oqVar.i.d(iL);
                oqVar.e.d(iL - iM);
                z2 = true;
                i3 = 1;
            } else {
                z2 = true;
                i3 = i2;
            }
        } else {
            z2 = true;
            i2 = 0;
            int i6 = iArr[1];
            if (i6 == 1 || i6 == 4) {
                int i7 = ibVar.i() + iN;
                mh0Var.i.d(i7);
                mh0Var.e.d(i7 - iN);
                i3 = 1;
            } else {
                i3 = i2;
            }
        }
        vfVar.g();
        int size2 = arrayList.size();
        int i8 = i2;
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            ok0 ok0Var2 = (ok0) obj2;
            if (ok0Var2.f == i && (ok0Var2.b != ibVar || ok0Var2.g)) {
                ok0Var2.e();
            }
        }
        int size3 = arrayList.size();
        int i9 = i2;
        while (i9 < size3) {
            Object obj3 = arrayList.get(i9);
            i9++;
            ok0 ok0Var3 = (ok0) obj3;
            if (ok0Var3.f == i && (i3 != 0 || ok0Var3.b != ibVar)) {
                if (!ok0Var3.h.j || !ok0Var3.i.j || (!(ok0Var3 instanceof q7) && !ok0Var3.e.j)) {
                    z3 = i2;
                    break;
                }
            }
        }
        z3 = z2;
        ibVar.w(iH);
        ibVar.x(iH2);
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c7  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r8v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void E() {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ib.E():void");
    }

    @Override // sensei0.hb
    public final void s() {
        this.i0.r();
        this.j0 = 0;
        this.k0 = 0;
        this.d0.clear();
        super.s();
    }

    @Override // sensei0.hb
    public final void u(j1 j1Var) {
        super.u(j1Var);
        int size = this.d0.size();
        for (int i = 0; i < size; i++) {
            ((hb) this.d0.get(i)).u(j1Var);
        }
    }

    @Override // sensei0.hb
    public final void z(boolean z, boolean z2) {
        super.z(z, z2);
        int size = this.d0.size();
        for (int i = 0; i < size; i++) {
            ((hb) this.d0.get(i)).z(z, z2);
        }
    }
}
