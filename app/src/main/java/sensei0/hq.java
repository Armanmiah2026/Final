package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hq extends hb {
    public float d0 = -1.0f;
    public int e0 = -1;
    public int f0 = -1;
    public ta g0 = this.y;
    public int h0 = 0;

    public hq() {
        this.G.clear();
        this.G.add(this.g0);
        int length = this.F.length;
        for (int i = 0; i < length; i++) {
            this.F[i] = this.g0;
        }
    }

    @Override // sensei0.hb
    public final void A(eu euVar) {
        if (this.I == null) {
            return;
        }
        ta taVar = this.g0;
        euVar.getClass();
        int iM = eu.m(taVar);
        if (this.h0 == 1) {
            this.N = iM;
            this.O = 0;
            v(this.I.i());
            y(0);
            return;
        }
        this.N = 0;
        this.O = iM;
        y(this.I.l());
        v(0);
    }

    public final void B(int i) {
        if (this.h0 == i) {
            return;
        }
        this.h0 = i;
        ArrayList arrayList = this.G;
        arrayList.clear();
        if (this.h0 == 1) {
            this.g0 = this.x;
        } else {
            this.g0 = this.y;
        }
        arrayList.add(this.g0);
        ta[] taVarArr = this.F;
        int length = taVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            taVarArr[i2] = this.g0;
        }
    }

    @Override // sensei0.hb
    public final void a(eu euVar) {
        ib ibVar = (ib) this.I;
        if (ibVar == null) {
            return;
        }
        ta taVarG = ibVar.g(2);
        ta taVarG2 = ibVar.g(4);
        hb hbVar = this.I;
        boolean z = hbVar != null && hbVar.c0[0] == 2;
        if (this.h0 == 0) {
            taVarG = ibVar.g(3);
            taVarG2 = ibVar.g(5);
            hb hbVar2 = this.I;
            z = hbVar2 != null && hbVar2.c0[1] == 2;
        }
        if (this.e0 != -1) {
            ab0 ab0VarJ = euVar.j(this.g0);
            euVar.e(ab0VarJ, euVar.j(taVarG), this.e0, 8);
            if (z) {
                euVar.f(euVar.j(taVarG2), ab0VarJ, 0, 5);
                return;
            }
            return;
        }
        if (this.f0 != -1) {
            ab0 ab0VarJ2 = euVar.j(this.g0);
            ab0 ab0VarJ3 = euVar.j(taVarG2);
            euVar.e(ab0VarJ2, ab0VarJ3, -this.f0, 8);
            if (z) {
                euVar.f(ab0VarJ2, euVar.j(taVarG), 0, 5);
                euVar.f(ab0VarJ3, ab0VarJ2, 0, 5);
                return;
            }
            return;
        }
        if (this.d0 != -1.0f) {
            ab0 ab0VarJ4 = euVar.j(this.g0);
            ab0 ab0VarJ5 = euVar.j(taVarG2);
            float f = this.d0;
            a5 a5VarK = euVar.k();
            a5VarK.d.g(ab0VarJ4, -1.0f);
            a5VarK.d.g(ab0VarJ5, f);
            euVar.c(a5VarK);
        }
    }

    @Override // sensei0.hb
    public final boolean b() {
        return true;
    }

    @Override // sensei0.hb
    public final ta g(int i) {
        switch (za0.u(i)) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.h0 == 1) {
                    return this.g0;
                }
                break;
            case 2:
            case 4:
                if (this.h0 == 0) {
                    return this.g0;
                }
                break;
        }
        throw new AssertionError(za0.t(i));
    }
}
