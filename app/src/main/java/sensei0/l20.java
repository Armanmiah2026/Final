package sensei0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l20 extends a5 {
    public ab0[] f;
    public ab0[] g;
    public int h;
    public k20 i;

    @Override // sensei0.a5
    public final ab0 d(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.h; i2++) {
            ab0[] ab0VarArr = this.f;
            ab0 ab0Var = ab0VarArr[i2];
            if (!zArr[ab0Var.b]) {
                k20 k20Var = this.i;
                k20Var.a = ab0Var;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = k20Var.a.h[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    ab0 ab0Var2 = ab0VarArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = ab0Var2.h[i3];
                            float f3 = k20Var.a.h[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 < f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // sensei0.a5
    public final void h(a5 a5Var, boolean z) {
        ab0 ab0Var = a5Var.a;
        if (ab0Var == null) {
            return;
        }
        float[] fArr = ab0Var.h;
        z4 z4Var = a5Var.d;
        int iE = z4Var.e();
        for (int i = 0; i < iE; i++) {
            ab0 ab0VarI = z4Var.i(i);
            float fA = z4Var.a(i);
            k20 k20Var = this.i;
            k20Var.a = ab0VarI;
            if (ab0VarI.a) {
                boolean z2 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = k20Var.a.h;
                    float f = (fArr[i2] * fA) + fArr2[i2];
                    fArr2[i2] = f;
                    if (Math.abs(f) < 1.0E-4f) {
                        k20Var.a.h[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    k20Var.b.j(k20Var.a);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f2 = fArr[i3];
                    if (f2 != 0.0f) {
                        float f3 = f2 * fA;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        k20Var.a.h[i3] = f3;
                    } else {
                        k20Var.a.h[i3] = 0.0f;
                    }
                }
                i(ab0VarI);
            }
            this.b = (a5Var.b * fA) + this.b;
        }
        j(ab0Var);
    }

    public final void i(ab0 ab0Var) {
        int i;
        int i2 = this.h + 1;
        ab0[] ab0VarArr = this.f;
        if (i2 > ab0VarArr.length) {
            ab0[] ab0VarArr2 = (ab0[]) Arrays.copyOf(ab0VarArr, ab0VarArr.length * 2);
            this.f = ab0VarArr2;
            this.g = (ab0[]) Arrays.copyOf(ab0VarArr2, ab0VarArr2.length * 2);
        }
        ab0[] ab0VarArr3 = this.f;
        int i3 = this.h;
        ab0VarArr3[i3] = ab0Var;
        int i4 = i3 + 1;
        this.h = i4;
        if (i4 > 1 && ab0VarArr3[i3].b > ab0Var.b) {
            int i5 = 0;
            while (true) {
                i = this.h;
                if (i5 >= i) {
                    break;
                }
                this.g[i5] = this.f[i5];
                i5++;
            }
            Arrays.sort(this.g, 0, i, new hc(4));
            for (int i6 = 0; i6 < this.h; i6++) {
                this.f[i6] = this.g[i6];
            }
        }
        ab0Var.a = true;
        ab0Var.a(this);
    }

    public final void j(ab0 ab0Var) {
        int i = 0;
        while (i < this.h) {
            if (this.f[i] == ab0Var) {
                while (true) {
                    int i2 = this.h;
                    if (i >= i2 - 1) {
                        this.h = i2 - 1;
                        ab0Var.a = false;
                        return;
                    } else {
                        ab0[] ab0VarArr = this.f;
                        int i3 = i + 1;
                        ab0VarArr[i] = ab0VarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // sensei0.a5
    public final String toString() {
        k20 k20Var = this.i;
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.h; i++) {
            k20Var.a = this.f[i];
            str = str + k20Var + " ";
        }
        return str;
    }
}
