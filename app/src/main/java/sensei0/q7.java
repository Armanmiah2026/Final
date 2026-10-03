package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q7 extends ok0 {
    public final ArrayList k;
    public int l;

    public q7(hb hbVar, int i) {
        hb hbVar2;
        super(hbVar);
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.f = i;
        hb hbVar3 = this.b;
        hb hbVarK = hbVar3.k(i);
        while (true) {
            hbVar2 = hbVar3;
            hbVar3 = hbVarK;
            if (hbVar3 == null) {
                break;
            } else {
                hbVarK = hbVar3.k(this.f);
            }
        }
        this.b = hbVar2;
        int i2 = this.f;
        arrayList.add(i2 == 0 ? hbVar2.d : i2 == 1 ? hbVar2.e : null);
        hb hbVarJ = hbVar2.j(this.f);
        while (hbVarJ != null) {
            int i3 = this.f;
            arrayList.add(i3 == 0 ? hbVarJ.d : i3 == 1 ? hbVarJ.e : null);
            hbVarJ = hbVarJ.j(this.f);
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ok0 ok0Var = (ok0) obj;
            int i5 = this.f;
            if (i5 == 0) {
                ok0Var.b.b = this;
            } else if (i5 == 1) {
                ok0Var.b.c = this;
            }
        }
        if (this.f == 0 && ((ib) this.b.I).h0 && arrayList.size() > 1) {
            this.b = ((ok0) arrayList.get(arrayList.size() - 1)).b;
        }
        this.l = this.f == 0 ? this.b.X : this.b.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01bc A[PHI: r1 r26
      0x01bc: PHI (r1v57 int) = (r1v55 int), (r1v60 int) binds: [B:120:0x01ba, B:111:0x019a] A[DONT_GENERATE, DONT_INLINE]
      0x01bc: PHI (r26v1 int) = (r26v0 int), (r26v3 int) binds: [B:120:0x01ba, B:111:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    @Override // sensei0.uf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sensei0.uf r28) {
        /*
            Method dump skipped, instruction units count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.q7.a(sensei0.uf):void");
    }

    @Override // sensei0.ok0
    public final void d() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ok0) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        hb hbVar = ((ok0) arrayList.get(0)).b;
        hb hbVar2 = ((ok0) arrayList.get(size2 - 1)).b;
        int i2 = this.f;
        wf wfVar = this.i;
        wf wfVar2 = this.h;
        if (i2 == 0) {
            ta taVar = hbVar.x;
            ta taVar2 = hbVar2.z;
            wf wfVarI = ok0.i(taVar, 0);
            int iC = taVar.c();
            hb hbVarM = m();
            if (hbVarM != null) {
                iC = hbVarM.x.c();
            }
            if (wfVarI != null) {
                ok0.b(wfVar2, wfVarI, iC);
            }
            wf wfVarI2 = ok0.i(taVar2, 0);
            int iC2 = taVar2.c();
            hb hbVarN = n();
            if (hbVarN != null) {
                iC2 = hbVarN.z.c();
            }
            if (wfVarI2 != null) {
                ok0.b(wfVar, wfVarI2, -iC2);
            }
        } else {
            ta taVar3 = hbVar.y;
            ta taVar4 = hbVar2.A;
            wf wfVarI3 = ok0.i(taVar3, 1);
            int iC3 = taVar3.c();
            hb hbVarM2 = m();
            if (hbVarM2 != null) {
                iC3 = hbVarM2.y.c();
            }
            if (wfVarI3 != null) {
                ok0.b(wfVar2, wfVarI3, iC3);
            }
            wf wfVarI4 = ok0.i(taVar4, 1);
            int iC4 = taVar4.c();
            hb hbVarN2 = n();
            if (hbVarN2 != null) {
                iC4 = hbVarN2.A.c();
            }
            if (wfVarI4 != null) {
                ok0.b(wfVar, wfVarI4, -iC4);
            }
        }
        wfVar2.a = this;
        wfVar.a = this;
    }

    @Override // sensei0.ok0
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((ok0) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // sensei0.ok0
    public final void f() {
        this.c = null;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ok0) obj).f();
        }
    }

    @Override // sensei0.ok0
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            ok0 ok0Var = (ok0) arrayList.get(i);
            j = ((long) ok0Var.i.f) + ok0Var.j() + j + ((long) ok0Var.h.f);
        }
        return j;
    }

    @Override // sensei0.ok0
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((ok0) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final hb m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            hb hbVar = ((ok0) arrayList.get(i)).b;
            if (hbVar.V != 8) {
                return hbVar;
            }
            i++;
        }
    }

    public final hb n() {
        ArrayList arrayList = this.k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            hb hbVar = ((ok0) arrayList.get(size)).b;
            if (hbVar.V != 8) {
                return hbVar;
            }
        }
        return null;
    }

    public final String toString() {
        String strConcat = "ChainRun ".concat(this.f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            strConcat = za0.k(za0.k(strConcat, "<") + ((ok0) obj), "> ");
        }
        return strConcat;
    }
}
