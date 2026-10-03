package sensei0;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class hb {
    public final ta A;
    public final ta B;
    public final ta C;
    public final ta D;
    public final ta E;
    public final ta[] F;
    public final ArrayList G;
    public final boolean[] H;
    public hb I;
    public int J;
    public int K;
    public float L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public float S;
    public float T;
    public View U;
    public int V;
    public String W;
    public int X;
    public int Y;
    public final float[] Z;
    public boolean a = false;
    public final hb[] a0;
    public q7 b;
    public final hb[] b0;
    public q7 c;
    public final int[] c0;
    public final oq d;
    public final mh0 e;
    public final boolean[] f;
    public final int[] g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final int[] l;
    public int m;
    public int n;
    public float o;
    public int p;
    public int q;
    public float r;
    public int s;
    public float t;
    public final int[] u;
    public float v;
    public boolean w;
    public final ta x;
    public final ta y;
    public final ta z;

    public hb() {
        oq oqVar = new oq(this);
        oqVar.h.e = 4;
        oqVar.i.e = 5;
        oqVar.f = 0;
        this.d = oqVar;
        mh0 mh0Var = new mh0(this);
        wf wfVar = new wf(mh0Var);
        mh0Var.k = wfVar;
        mh0Var.l = null;
        mh0Var.h.e = 6;
        mh0Var.i.e = 7;
        wfVar.e = 8;
        mh0Var.f = 1;
        this.e = mh0Var;
        this.f = new boolean[]{true, true};
        this.g = new int[]{0, 0, 0, 0};
        this.h = -1;
        this.i = -1;
        this.j = 0;
        this.k = 0;
        this.l = new int[2];
        this.m = 0;
        this.n = 0;
        this.o = 1.0f;
        this.p = 0;
        this.q = 0;
        this.r = 1.0f;
        this.s = -1;
        this.t = 1.0f;
        this.u = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.v = 0.0f;
        this.w = false;
        ta taVar = new ta(this, 2);
        this.x = taVar;
        ta taVar2 = new ta(this, 3);
        this.y = taVar2;
        ta taVar3 = new ta(this, 4);
        this.z = taVar3;
        ta taVar4 = new ta(this, 5);
        this.A = taVar4;
        ta taVar5 = new ta(this, 6);
        this.B = taVar5;
        ta taVar6 = new ta(this, 8);
        this.C = taVar6;
        ta taVar7 = new ta(this, 9);
        this.D = taVar7;
        ta taVar8 = new ta(this, 7);
        this.E = taVar8;
        this.F = new ta[]{taVar, taVar3, taVar2, taVar4, taVar5, taVar8};
        ArrayList arrayList = new ArrayList();
        this.G = arrayList;
        this.H = new boolean[2];
        this.c0 = new int[]{1, 1};
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.S = 0.5f;
        this.T = 0.5f;
        this.V = 0;
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.Z = new float[]{-1.0f, -1.0f};
        this.a0 = new hb[]{null, null};
        this.b0 = new hb[]{null, null};
        arrayList.add(taVar);
        arrayList.add(taVar2);
        arrayList.add(taVar3);
        arrayList.add(taVar4);
        arrayList.add(taVar6);
        arrayList.add(taVar7);
        arrayList.add(taVar8);
        arrayList.add(taVar5);
    }

    public void A(eu euVar) {
        int i;
        int i2;
        euVar.getClass();
        int iM = eu.m(this.x);
        int iM2 = eu.m(this.y);
        int iM3 = eu.m(this.z);
        int iM4 = eu.m(this.A);
        oq oqVar = this.d;
        wf wfVar = oqVar.h;
        if (wfVar.j) {
            wf wfVar2 = oqVar.i;
            if (wfVar2.j) {
                iM = wfVar.g;
                iM3 = wfVar2.g;
            }
        }
        mh0 mh0Var = this.e;
        wf wfVar3 = mh0Var.h;
        if (wfVar3.j) {
            wf wfVar4 = mh0Var.i;
            if (wfVar4.j) {
                iM2 = wfVar3.g;
                iM4 = wfVar4.g;
            }
        }
        int i3 = iM4 - iM2;
        if (iM3 - iM < 0 || i3 < 0 || iM == Integer.MIN_VALUE || iM == Integer.MAX_VALUE || iM2 == Integer.MIN_VALUE || iM2 == Integer.MAX_VALUE || iM3 == Integer.MIN_VALUE || iM3 == Integer.MAX_VALUE || iM4 == Integer.MIN_VALUE || iM4 == Integer.MAX_VALUE) {
            iM = 0;
            iM2 = 0;
            iM3 = 0;
            iM4 = 0;
        }
        int i4 = iM3 - iM;
        int i5 = iM4 - iM2;
        this.N = iM;
        this.O = iM2;
        if (this.V == 8) {
            this.J = 0;
            this.K = 0;
            return;
        }
        int[] iArr = this.c0;
        if (iArr[0] == 1 && i4 < (i2 = this.J)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.K)) {
            i5 = i;
        }
        this.J = i4;
        this.K = i5;
        int i6 = this.R;
        if (i5 < i6) {
            this.K = i6;
        }
        int i7 = this.Q;
        if (i4 < i7) {
            this.J = i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:303:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(sensei0.eu r60) {
        /*
            Method dump skipped, instruction units count: 1554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.hb.a(sensei0.eu):void");
    }

    public boolean b() {
        return this.V != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0365 A[PHI: r4
      0x0365: PHI (r4v25 int) = (r4v24 int), (r4v29 int), (r4v29 int), (r4v29 int) binds: [B:221:0x0355, B:223:0x035b, B:224:0x035d, B:226:0x0361] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:284:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(sensei0.eu r28, boolean r29, boolean r30, boolean r31, boolean r32, sensei0.ab0 r33, sensei0.ab0 r34, int r35, boolean r36, sensei0.ta r37, sensei0.ta r38, int r39, int r40, int r41, int r42, float r43, boolean r44, boolean r45, boolean r46, boolean r47, int r48, int r49, int r50, int r51, float r52, boolean r53) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.hb.c(sensei0.eu, boolean, boolean, boolean, boolean, sensei0.ab0, sensei0.ab0, int, boolean, sensei0.ta, sensei0.ta, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void d(int i, hb hbVar, int i2, int i3) {
        boolean z;
        if (i == 7) {
            if (i2 != 7) {
                if (i2 == 2 || i2 == 4) {
                    d(2, hbVar, i2, 0);
                    d(4, hbVar, i2, 0);
                    g(7).a(hbVar.g(i2), 0);
                    return;
                } else {
                    if (i2 == 3 || i2 == 5) {
                        d(3, hbVar, i2, 0);
                        d(5, hbVar, i2, 0);
                        g(7).a(hbVar.g(i2), 0);
                        return;
                    }
                    return;
                }
            }
            ta taVarG = g(2);
            ta taVarG2 = g(4);
            ta taVarG3 = g(3);
            ta taVarG4 = g(5);
            boolean z2 = true;
            if ((taVarG == null || !taVarG.f()) && (taVarG2 == null || !taVarG2.f())) {
                d(2, hbVar, 2, 0);
                d(4, hbVar, 4, 0);
                z = true;
            } else {
                z = false;
            }
            if ((taVarG3 == null || !taVarG3.f()) && (taVarG4 == null || !taVarG4.f())) {
                d(3, hbVar, 3, 0);
                d(5, hbVar, 5, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                g(7).a(hbVar.g(7), 0);
                return;
            } else if (z) {
                g(8).a(hbVar.g(8), 0);
                return;
            } else {
                if (z2) {
                    g(9).a(hbVar.g(9), 0);
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i2 == 2 || i2 == 4)) {
            ta taVarG5 = g(2);
            ta taVarG6 = hbVar.g(i2);
            ta taVarG7 = g(4);
            taVarG5.a(taVarG6, 0);
            taVarG7.a(taVarG6, 0);
            g(8).a(taVarG6, 0);
            return;
        }
        if (i == 9 && (i2 == 3 || i2 == 5)) {
            ta taVarG8 = hbVar.g(i2);
            g(3).a(taVarG8, 0);
            g(5).a(taVarG8, 0);
            g(9).a(taVarG8, 0);
            return;
        }
        if (i == 8 && i2 == 8) {
            g(2).a(hbVar.g(2), 0);
            g(4).a(hbVar.g(4), 0);
            g(8).a(hbVar.g(i2), 0);
            return;
        }
        if (i == 9 && i2 == 9) {
            g(3).a(hbVar.g(3), 0);
            g(5).a(hbVar.g(5), 0);
            g(9).a(hbVar.g(i2), 0);
            return;
        }
        ta taVarG9 = g(i);
        ta taVarG10 = hbVar.g(i2);
        if (taVarG9.g(taVarG10)) {
            if (i == 6) {
                ta taVarG11 = g(3);
                ta taVarG12 = g(5);
                if (taVarG11 != null) {
                    taVarG11.h();
                }
                if (taVarG12 != null) {
                    taVarG12.h();
                }
                i3 = 0;
            } else if (i == 3 || i == 5) {
                ta taVarG13 = g(6);
                if (taVarG13 != null) {
                    taVarG13.h();
                }
                ta taVarG14 = g(7);
                if (taVarG14.d != taVarG10) {
                    taVarG14.h();
                }
                ta taVarD = g(i).d();
                ta taVarG15 = g(9);
                if (taVarG15.f()) {
                    taVarD.h();
                    taVarG15.h();
                }
            } else if (i == 2 || i == 4) {
                ta taVarG16 = g(7);
                if (taVarG16.d != taVarG10) {
                    taVarG16.h();
                }
                ta taVarD2 = g(i).d();
                ta taVarG17 = g(8);
                if (taVarG17.f()) {
                    taVarD2.h();
                    taVarG17.h();
                }
            }
            taVarG9.a(taVarG10, i3);
        }
    }

    public final void e(ta taVar, ta taVar2, int i) {
        if (taVar.b == this) {
            d(taVar.c, taVar2.b, taVar2.c, i);
        }
    }

    public final void f(eu euVar) {
        euVar.j(this.x);
        euVar.j(this.y);
        euVar.j(this.z);
        euVar.j(this.A);
        if (this.P > 0) {
            euVar.j(this.B);
        }
    }

    public ta g(int i) {
        switch (za0.u(i)) {
            case 0:
                return null;
            case 1:
                return this.x;
            case 2:
                return this.y;
            case 3:
                return this.z;
            case 4:
                return this.A;
            case 5:
                return this.B;
            case 6:
                return this.E;
            case 7:
                return this.C;
            case 8:
                return this.D;
            default:
                throw new AssertionError(za0.t(i));
        }
    }

    public final int h(int i) {
        int[] iArr = this.c0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int i() {
        if (this.V == 8) {
            return 0;
        }
        return this.K;
    }

    public final hb j(int i) {
        ta taVar;
        ta taVar2;
        if (i != 0) {
            if (i == 1 && (taVar2 = (taVar = this.A).d) != null && taVar2.d == taVar) {
                return taVar2.b;
            }
            return null;
        }
        ta taVar3 = this.z;
        ta taVar4 = taVar3.d;
        if (taVar4 == null || taVar4.d != taVar3) {
            return null;
        }
        return taVar4.b;
    }

    public final hb k(int i) {
        ta taVar;
        ta taVar2;
        if (i != 0) {
            if (i == 1 && (taVar2 = (taVar = this.y).d) != null && taVar2.d == taVar) {
                return taVar2.b;
            }
            return null;
        }
        ta taVar3 = this.x;
        ta taVar4 = taVar3.d;
        if (taVar4 == null || taVar4.d != taVar3) {
            return null;
        }
        return taVar4.b;
    }

    public final int l() {
        if (this.V == 8) {
            return 0;
        }
        return this.J;
    }

    public final int m() {
        hb hbVar = this.I;
        return (hbVar == null || !(hbVar instanceof ib)) ? this.N : ((ib) hbVar).j0 + this.N;
    }

    public final int n() {
        hb hbVar = this.I;
        return (hbVar == null || !(hbVar instanceof ib)) ? this.O : ((ib) hbVar).k0 + this.O;
    }

    public final void o(int i, int i2, int i3, int i4, hb hbVar) {
        g(i).b(hbVar.g(i2), i3, i4, true);
    }

    public final boolean p(int i) {
        ta taVar;
        ta taVar2;
        int i2 = i * 2;
        ta[] taVarArr = this.F;
        ta taVar3 = taVarArr[i2];
        ta taVar4 = taVar3.d;
        return (taVar4 == null || taVar4.d == taVar3 || (taVar2 = (taVar = taVarArr[i2 + 1]).d) == null || taVar2.d != taVar) ? false : true;
    }

    public final boolean q() {
        ta taVar = this.x;
        ta taVar2 = taVar.d;
        if (taVar2 != null && taVar2.d == taVar) {
            return true;
        }
        ta taVar3 = this.z;
        ta taVar4 = taVar3.d;
        return taVar4 != null && taVar4.d == taVar3;
    }

    public final boolean r() {
        ta taVar = this.y;
        ta taVar2 = taVar.d;
        if (taVar2 != null && taVar2.d == taVar) {
            return true;
        }
        ta taVar3 = this.A;
        ta taVar4 = taVar3.d;
        return taVar4 != null && taVar4.d == taVar3;
    }

    public void s() {
        this.x.h();
        this.y.h();
        this.z.h();
        this.A.h();
        this.B.h();
        this.C.h();
        this.D.h();
        this.E.h();
        this.I = null;
        this.v = 0.0f;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = -1;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0.5f;
        this.T = 0.5f;
        int[] iArr = this.c0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.U = null;
        this.V = 0;
        this.X = 0;
        this.Y = 0;
        float[] fArr = this.Z;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.h = -1;
        this.i = -1;
        int[] iArr2 = this.u;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.j = 0;
        this.k = 0;
        this.o = 1.0f;
        this.r = 1.0f;
        this.n = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.m = 0;
        this.p = 0;
        this.s = -1;
        this.t = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.H;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public final void t() {
        hb hbVar = this.I;
        if (hbVar != null && (hbVar instanceof ib)) {
            ((ib) hbVar).getClass();
        }
        ArrayList arrayList = this.G;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((ta) arrayList.get(i)).h();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.W != null ? za0.o(new StringBuilder("id: "), this.W, " ") : "");
        sb.append("(");
        sb.append(this.N);
        sb.append(", ");
        sb.append(this.O);
        sb.append(") - (");
        sb.append(this.J);
        sb.append(" x ");
        return za0.n(sb, this.K, ")");
    }

    public void u(j1 j1Var) {
        this.x.i();
        this.y.i();
        this.z.i();
        this.A.i();
        this.B.i();
        this.E.i();
        this.C.i();
        this.D.i();
    }

    public final void v(int i) {
        this.K = i;
        int i2 = this.R;
        if (i < i2) {
            this.K = i2;
        }
    }

    public final void w(int i) {
        this.c0[0] = i;
    }

    public final void x(int i) {
        this.c0[1] = i;
    }

    public final void y(int i) {
        this.J = i;
        int i2 = this.Q;
        if (i < i2) {
            this.J = i2;
        }
    }

    public void z(boolean z, boolean z2) {
        int i;
        int i2;
        oq oqVar = this.d;
        boolean z3 = z & oqVar.g;
        mh0 mh0Var = this.e;
        boolean z4 = z2 & mh0Var.g;
        int i3 = oqVar.h.g;
        int i4 = mh0Var.h.g;
        int i5 = oqVar.i.g;
        int i6 = mh0Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.N = i3;
        }
        if (z4) {
            this.O = i4;
        }
        if (this.V == 8) {
            this.J = 0;
            this.K = 0;
            return;
        }
        int[] iArr = this.c0;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.J)) {
                i8 = i2;
            }
            this.J = i8;
            int i10 = this.Q;
            if (i8 < i10) {
                this.J = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.K)) {
                i9 = i;
            }
            this.K = i9;
            int i11 = this.R;
            if (i9 < i11) {
                this.K = i11;
            }
        }
    }
}
