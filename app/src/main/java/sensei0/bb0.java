package sensei0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bb0 implements z4 {
    public int a = 16;
    public final int[] b = new int[16];
    public int[] c = new int[16];
    public int[] d = new int[16];
    public float[] e = new float[16];
    public int[] f = new int[16];
    public int[] g = new int[16];
    public int h = 0;
    public int i = -1;
    public final du j;
    public final j1 k;

    public bb0(du duVar, j1 j1Var) {
        this.j = duVar;
        this.k = j1Var;
        clear();
    }

    @Override // sensei0.z4
    public final float a(int i) {
        int i2 = this.h;
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.e[i3];
            }
            i3 = this.g[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // sensei0.z4
    public final void b(ab0 ab0Var, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int iN = n(ab0Var);
            if (iN == -1) {
                g(ab0Var, f);
                return;
            }
            float[] fArr = this.e;
            float f2 = fArr[iN] + f;
            fArr[iN] = f2;
            if (f2 <= -0.001f || f2 >= 0.001f) {
                return;
            }
            fArr[iN] = 0.0f;
            c(ab0Var, z);
        }
    }

    @Override // sensei0.z4
    public final float c(ab0 ab0Var, boolean z) {
        int[] iArr;
        int i;
        int iN = n(ab0Var);
        if (iN == -1) {
            return 0.0f;
        }
        int i2 = ab0Var.b;
        int i3 = i2 % 16;
        int[] iArr2 = this.b;
        int i4 = iArr2[i3];
        if (i4 != -1) {
            if (this.d[i4] == i2) {
                int[] iArr3 = this.c;
                iArr2[i3] = iArr3[i4];
                iArr3[i4] = -1;
            } else {
                while (true) {
                    iArr = this.c;
                    i = iArr[i4];
                    if (i == -1 || this.d[i] == i2) {
                        break;
                    }
                    i4 = i;
                }
                if (i != -1 && this.d[i] == i2) {
                    iArr[i4] = iArr[i];
                    iArr[i] = -1;
                }
            }
        }
        float f = this.e[iN];
        if (this.i == iN) {
            this.i = this.g[iN];
        }
        this.d[iN] = -1;
        int[] iArr4 = this.f;
        int i5 = iArr4[iN];
        if (i5 != -1) {
            int[] iArr5 = this.g;
            iArr5[i5] = iArr5[iN];
        }
        int i6 = this.g[iN];
        if (i6 != -1) {
            iArr4[i6] = iArr4[iN];
        }
        this.h--;
        ab0Var.k--;
        if (z) {
            ab0Var.b(this.j);
        }
        return f;
    }

    @Override // sensei0.z4
    public final void clear() {
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            ab0 ab0VarI = i(i2);
            if (ab0VarI != null) {
                ab0VarI.b(this.j);
            }
        }
        for (int i3 = 0; i3 < this.a; i3++) {
            this.d[i3] = -1;
            this.c[i3] = -1;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            this.b[i4] = -1;
        }
        this.h = 0;
        this.i = -1;
    }

    @Override // sensei0.z4
    public final float d(ab0 ab0Var) {
        int iN = n(ab0Var);
        if (iN != -1) {
            return this.e[iN];
        }
        return 0.0f;
    }

    @Override // sensei0.z4
    public final int e() {
        return this.h;
    }

    @Override // sensei0.z4
    public final float f(a5 a5Var, boolean z) {
        float fD = d(a5Var.a);
        c(a5Var.a, z);
        bb0 bb0Var = (bb0) a5Var.d;
        int i = bb0Var.h;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = bb0Var.d[i3];
            if (i4 != -1) {
                b(((ab0[]) this.k.d)[i4], bb0Var.e[i3] * fD, z);
                i2++;
            }
            i3++;
        }
        return fD;
    }

    @Override // sensei0.z4
    public final void g(ab0 ab0Var, float f) {
        if (f > -0.001f && f < 0.001f) {
            c(ab0Var, true);
            return;
        }
        int i = 0;
        if (this.h == 0) {
            m(0, ab0Var, f);
            l(ab0Var, 0);
            this.i = 0;
            return;
        }
        int iN = n(ab0Var);
        if (iN != -1) {
            this.e[iN] = f;
            return;
        }
        int i2 = this.h + 1;
        int i3 = this.a;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            this.d = Arrays.copyOf(this.d, i4);
            this.e = Arrays.copyOf(this.e, i4);
            this.f = Arrays.copyOf(this.f, i4);
            this.g = Arrays.copyOf(this.g, i4);
            this.c = Arrays.copyOf(this.c, i4);
            for (int i5 = this.a; i5 < i4; i5++) {
                this.d[i5] = -1;
                this.c[i5] = -1;
            }
            this.a = i4;
        }
        int i6 = this.h;
        int i7 = this.i;
        int i8 = -1;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = this.d[i7];
            int i11 = ab0Var.b;
            if (i10 == i11) {
                this.e[i7] = f;
                return;
            }
            if (i10 < i11) {
                i8 = i7;
            }
            i7 = this.g[i7];
            if (i7 == -1) {
                break;
            }
        }
        while (true) {
            if (i >= this.a) {
                i = -1;
                break;
            } else if (this.d[i] == -1) {
                break;
            } else {
                i++;
            }
        }
        m(i, ab0Var, f);
        if (i8 != -1) {
            this.f[i] = i8;
            int[] iArr = this.g;
            iArr[i] = iArr[i8];
            iArr[i8] = i;
        } else {
            this.f[i] = -1;
            if (this.h > 0) {
                this.g[i] = this.i;
                this.i = i;
            } else {
                this.g[i] = -1;
            }
        }
        int i12 = this.g[i];
        if (i12 != -1) {
            this.f[i12] = i;
        }
        l(ab0Var, i);
    }

    @Override // sensei0.z4
    public final boolean h(ab0 ab0Var) {
        return n(ab0Var) != -1;
    }

    @Override // sensei0.z4
    public final ab0 i(int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.i;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return ((ab0[]) this.k.d)[this.d[i3]];
            }
            i3 = this.g[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // sensei0.z4
    public final void j(float f) {
        int i = this.h;
        int i2 = this.i;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.e;
            fArr[i2] = fArr[i2] / f;
            i2 = this.g[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // sensei0.z4
    public final void k() {
        int i = this.h;
        int i2 = this.i;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.e;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.g[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    public final void l(ab0 ab0Var, int i) {
        int[] iArr;
        int i2 = ab0Var.b % 16;
        int[] iArr2 = this.b;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.c;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.c[i] = -1;
    }

    public final void m(int i, ab0 ab0Var, float f) {
        this.d[i] = ab0Var.b;
        this.e[i] = f;
        this.f[i] = -1;
        this.g[i] = -1;
        ab0Var.a(this.j);
        ab0Var.k++;
        this.h++;
    }

    public final int n(ab0 ab0Var) {
        if (this.h == 0) {
            return -1;
        }
        int i = ab0Var.b;
        int i2 = this.b[i % 16];
        if (i2 == -1) {
            return -1;
        }
        if (this.d[i2] == i) {
            return i2;
        }
        do {
            i2 = this.c[i2];
            if (i2 == -1) {
                break;
            }
        } while (this.d[i2] != i);
        if (i2 != -1 && this.d[i2] == i) {
            return i2;
        }
        return -1;
    }

    public final String toString() {
        String strK = hashCode() + " { ";
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            ab0 ab0VarI = i(i2);
            if (ab0VarI != null) {
                String str = strK + ab0VarI + " = " + a(i2) + " ";
                int iN = n(ab0VarI);
                String strK2 = za0.k(str, "[p: ");
                int i3 = this.f[iN];
                j1 j1Var = this.k;
                String strK3 = za0.k(i3 != -1 ? strK2 + ((ab0[]) j1Var.d)[this.d[this.f[iN]]] : za0.k(strK2, "none"), ", n: ");
                strK = za0.k(this.g[iN] != -1 ? strK3 + ((ab0[]) j1Var.d)[this.d[this.g[iN]]] : za0.k(strK3, "none"), "]");
            }
        }
        return za0.k(strK, " }");
    }
}
