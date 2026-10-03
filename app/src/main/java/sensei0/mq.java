package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mq extends ok0 {
    @Override // sensei0.uf
    public final void a(uf ufVar) {
        k5 k5Var = (k5) this.b;
        int i = k5Var.f0;
        wf wfVar = this.h;
        ArrayList arrayList = wfVar.l;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            int i5 = ((wf) obj).g;
            if (i3 == -1 || i5 < i3) {
                i3 = i5;
            }
            if (i2 < i5) {
                i2 = i5;
            }
        }
        if (i == 0 || i == 2) {
            wfVar.d(i3 + k5Var.h0);
        } else {
            wfVar.d(i2 + k5Var.h0);
        }
    }

    @Override // sensei0.ok0
    public final void d() {
        hb hbVar = this.b;
        if (hbVar instanceof k5) {
            wf wfVar = this.h;
            wfVar.b = true;
            ArrayList arrayList = wfVar.l;
            k5 k5Var = (k5) hbVar;
            int i = k5Var.f0;
            boolean z = k5Var.g0;
            int i2 = 0;
            if (i == 0) {
                wfVar.e = 4;
                while (i2 < k5Var.e0) {
                    hb hbVar2 = k5Var.d0[i2];
                    if (z || hbVar2.V != 8) {
                        wf wfVar2 = hbVar2.d.h;
                        wfVar2.k.add(wfVar);
                        arrayList.add(wfVar2);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 1) {
                wfVar.e = 5;
                while (i2 < k5Var.e0) {
                    hb hbVar3 = k5Var.d0[i2];
                    if (z || hbVar3.V != 8) {
                        wf wfVar3 = hbVar3.d.i;
                        wfVar3.k.add(wfVar);
                        arrayList.add(wfVar3);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 2) {
                wfVar.e = 6;
                while (i2 < k5Var.e0) {
                    hb hbVar4 = k5Var.d0[i2];
                    if (z || hbVar4.V != 8) {
                        wf wfVar4 = hbVar4.e.h;
                        wfVar4.k.add(wfVar);
                        arrayList.add(wfVar4);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            wfVar.e = 7;
            while (i2 < k5Var.e0) {
                hb hbVar5 = k5Var.d0[i2];
                if (z || hbVar5.V != 8) {
                    wf wfVar5 = hbVar5.e.i;
                    wfVar5.k.add(wfVar);
                    arrayList.add(wfVar5);
                }
                i2++;
            }
            m(this.b.e.h);
            m(this.b.e.i);
        }
    }

    @Override // sensei0.ok0
    public final void e() {
        hb hbVar = this.b;
        if (hbVar instanceof k5) {
            int i = ((k5) hbVar).f0;
            wf wfVar = this.h;
            if (i == 0 || i == 1) {
                hbVar.N = wfVar.g;
            } else {
                hbVar.O = wfVar.g;
            }
        }
    }

    @Override // sensei0.ok0
    public final void f() {
        this.c = null;
        this.h.c();
    }

    @Override // sensei0.ok0
    public final boolean k() {
        return false;
    }

    public final void m(wf wfVar) {
        wf wfVar2 = this.h;
        wfVar2.k.add(wfVar);
        wfVar.l.add(wfVar2);
    }
}
