package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k5 extends nq {
    public int f0;
    public boolean g0;
    public int h0;

    @Override // sensei0.hb
    public final void a(eu euVar) {
        boolean z;
        int i;
        int i2;
        ta[] taVarArr = this.F;
        ta taVar = this.x;
        taVarArr[0] = taVar;
        int i3 = 2;
        ta taVar2 = this.y;
        taVarArr[2] = taVar2;
        ta taVar3 = this.z;
        taVarArr[1] = taVar3;
        ta taVar4 = this.A;
        taVarArr[3] = taVar4;
        for (ta taVar5 : taVarArr) {
            taVar5.g = euVar.j(taVar5);
        }
        int i4 = this.f0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ta taVar6 = taVarArr[i4];
        for (int i5 = 0; i5 < this.e0; i5++) {
            hb hbVar = this.d0[i5];
            if ((this.g0 || hbVar.b()) && ((((i2 = this.f0) == 0 || i2 == 1) && hbVar.c0[0] == 3 && hbVar.x.d != null && hbVar.z.d != null) || ((i2 == 2 || i2 == 3) && hbVar.c0[1] == 3 && hbVar.y.d != null && hbVar.A.d != null))) {
                z = true;
                break;
            }
        }
        z = false;
        boolean z2 = taVar.e() || taVar3.e();
        boolean z3 = taVar2.e() || taVar4.e();
        int i6 = !(!z && (((i = this.f0) == 0 && z2) || ((i == 2 && z3) || ((i == 1 && z2) || (i == 3 && z3))))) ? 4 : 5;
        int i7 = 0;
        while (i7 < this.e0) {
            hb hbVar2 = this.d0[i7];
            if (this.g0 || hbVar2.b()) {
                ab0 ab0VarJ = euVar.j(hbVar2.F[this.f0]);
                ta[] taVarArr2 = hbVar2.F;
                int i8 = this.f0;
                ta taVar7 = taVarArr2[i8];
                taVar7.g = ab0VarJ;
                ta taVar8 = taVar7.d;
                int i9 = (taVar8 == null || taVar8.b != this) ? 0 : taVar7.e;
                if (i8 == 0 || i8 == i3) {
                    ab0 ab0Var = taVar6.g;
                    int i10 = this.h0 - i9;
                    a5 a5VarK = euVar.k();
                    ab0 ab0VarL = euVar.l();
                    ab0VarL.d = 0;
                    a5VarK.c(ab0Var, ab0VarJ, ab0VarL, i10);
                    euVar.c(a5VarK);
                } else {
                    ab0 ab0Var2 = taVar6.g;
                    int i11 = this.h0 + i9;
                    a5 a5VarK2 = euVar.k();
                    ab0 ab0VarL2 = euVar.l();
                    ab0VarL2.d = 0;
                    a5VarK2.b(ab0Var2, ab0VarJ, ab0VarL2, i11);
                    euVar.c(a5VarK2);
                }
                euVar.e(taVar6.g, ab0VarJ, this.h0 + i9, i6);
            }
            i7++;
            i3 = 2;
        }
        int i12 = this.f0;
        if (i12 == 0) {
            euVar.e(taVar3.g, taVar.g, 0, 8);
            euVar.e(taVar.g, this.I.z.g, 0, 4);
            euVar.e(taVar.g, this.I.x.g, 0, 0);
            return;
        }
        if (i12 == 1) {
            euVar.e(taVar.g, taVar3.g, 0, 8);
            euVar.e(taVar.g, this.I.x.g, 0, 4);
            euVar.e(taVar.g, this.I.z.g, 0, 0);
        } else if (i12 == 2) {
            euVar.e(taVar4.g, taVar2.g, 0, 8);
            euVar.e(taVar2.g, this.I.A.g, 0, 4);
            euVar.e(taVar2.g, this.I.y.g, 0, 0);
        } else if (i12 == 3) {
            euVar.e(taVar2.g, taVar4.g, 0, 8);
            euVar.e(taVar2.g, this.I.y.g, 0, 4);
            euVar.e(taVar2.g, this.I.A.g, 0, 0);
        }
    }

    @Override // sensei0.hb
    public final boolean b() {
        return true;
    }

    @Override // sensei0.hb
    public final String toString() {
        String strO = za0.o(new StringBuilder("[Barrier] "), this.W, " {");
        for (int i = 0; i < this.e0; i++) {
            hb hbVar = this.d0[i];
            if (i > 0) {
                strO = za0.k(strO, ", ");
            }
            strO = strO + hbVar.W;
        }
        return za0.k(strO, "}");
    }
}
