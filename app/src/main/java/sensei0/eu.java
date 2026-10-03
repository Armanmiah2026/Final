package sensei0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class eu {
    public static int o = 1000;
    public static boolean p = true;
    public final l20 b;
    public a5[] e;
    public final j1 k;
    public a5 n;
    public int a = 0;
    public int c = 32;
    public int d = 32;
    public boolean f = false;
    public boolean[] g = new boolean[32];
    public int h = 1;
    public int i = 0;
    public int j = 32;
    public ab0[] l = new ab0[o];
    public int m = 0;

    public eu() {
        this.e = null;
        this.e = new a5[32];
        q();
        j1 j1Var = new j1();
        j1Var.a = new s10();
        j1Var.b = new s10();
        j1Var.c = new s10();
        j1Var.d = new ab0[32];
        this.k = j1Var;
        l20 l20Var = new l20(j1Var);
        l20Var.f = new ab0[128];
        l20Var.g = new ab0[128];
        l20Var.h = 0;
        l20Var.i = new k20(l20Var);
        this.b = l20Var;
        if (p) {
            this.n = new du(j1Var);
        } else {
            this.n = new a5(j1Var);
        }
    }

    public static int m(Object obj) {
        ab0 ab0Var = ((ta) obj).g;
        if (ab0Var != null) {
            return (int) (ab0Var.e + 0.5f);
        }
        return 0;
    }

    public final ab0 a(int i) {
        ab0 ab0Var = (ab0) ((s10) this.k.c).a();
        if (ab0Var == null) {
            ab0Var = new ab0(i);
            ab0Var.l = i;
        } else {
            ab0Var.c();
            ab0Var.l = i;
        }
        int i2 = this.m;
        int i3 = o;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            o = i4;
            this.l = (ab0[]) Arrays.copyOf(this.l, i4);
        }
        ab0[] ab0VarArr = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        ab0VarArr[i5] = ab0Var;
        return ab0Var;
    }

    public final void b(ab0 ab0Var, ab0 ab0Var2, int i, float f, ab0 ab0Var3, ab0 ab0Var4, int i2, int i3) {
        a5 a5VarK = k();
        if (ab0Var2 == ab0Var3) {
            a5VarK.d.g(ab0Var, 1.0f);
            a5VarK.d.g(ab0Var4, 1.0f);
            a5VarK.d.g(ab0Var2, -2.0f);
        } else if (f == 0.5f) {
            a5VarK.d.g(ab0Var, 1.0f);
            a5VarK.d.g(ab0Var2, -1.0f);
            a5VarK.d.g(ab0Var3, -1.0f);
            a5VarK.d.g(ab0Var4, 1.0f);
            if (i > 0 || i2 > 0) {
                a5VarK.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            a5VarK.d.g(ab0Var, -1.0f);
            a5VarK.d.g(ab0Var2, 1.0f);
            a5VarK.b = i;
        } else if (f >= 1.0f) {
            a5VarK.d.g(ab0Var4, -1.0f);
            a5VarK.d.g(ab0Var3, 1.0f);
            a5VarK.b = -i2;
        } else {
            float f2 = 1.0f - f;
            a5VarK.d.g(ab0Var, f2 * 1.0f);
            a5VarK.d.g(ab0Var2, f2 * (-1.0f));
            a5VarK.d.g(ab0Var3, (-1.0f) * f);
            a5VarK.d.g(ab0Var4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                a5VarK.b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            a5VarK.a(this, i3);
        }
        c(a5VarK);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(sensei0.a5 r18) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.eu.c(sensei0.a5):void");
    }

    public final void d(ab0 ab0Var, int i) {
        int i2 = ab0Var.c;
        if (i2 == -1) {
            ab0Var.e = i;
            ab0Var.f = true;
            int i3 = ab0Var.j;
            for (int i4 = 0; i4 < i3; i4++) {
                ab0Var.i[i4].g(ab0Var, false);
            }
            ab0Var.j = 0;
            return;
        }
        if (i2 == -1) {
            a5 a5VarK = k();
            a5VarK.a = ab0Var;
            float f = i;
            ab0Var.e = f;
            a5VarK.b = f;
            a5VarK.e = true;
            c(a5VarK);
            return;
        }
        a5 a5Var = this.e[i2];
        if (a5Var.e) {
            a5Var.b = i;
            return;
        }
        if (a5Var.d.e() == 0) {
            a5Var.e = true;
            a5Var.b = i;
            return;
        }
        a5 a5VarK2 = k();
        if (i < 0) {
            a5VarK2.b = i * (-1);
            a5VarK2.d.g(ab0Var, 1.0f);
        } else {
            a5VarK2.b = i;
            a5VarK2.d.g(ab0Var, -1.0f);
        }
        c(a5VarK2);
    }

    public final void e(ab0 ab0Var, ab0 ab0Var2, int i, int i2) {
        boolean z = false;
        if (i2 == 8 && ab0Var2.f && ab0Var.c == -1) {
            ab0Var.e = ab0Var2.e + i;
            ab0Var.f = true;
            int i3 = ab0Var.j;
            for (int i4 = 0; i4 < i3; i4++) {
                ab0Var.i[i4].g(ab0Var, false);
            }
            ab0Var.j = 0;
            return;
        }
        a5 a5VarK = k();
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            a5VarK.b = i;
        }
        if (z) {
            a5VarK.d.g(ab0Var, 1.0f);
            a5VarK.d.g(ab0Var2, -1.0f);
        } else {
            a5VarK.d.g(ab0Var, -1.0f);
            a5VarK.d.g(ab0Var2, 1.0f);
        }
        if (i2 != 8) {
            a5VarK.a(this, i2);
        }
        c(a5VarK);
    }

    public final void f(ab0 ab0Var, ab0 ab0Var2, int i, int i2) {
        a5 a5VarK = k();
        ab0 ab0VarL = l();
        ab0VarL.d = 0;
        a5VarK.b(ab0Var, ab0Var2, ab0VarL, i);
        if (i2 != 8) {
            a5VarK.d.g(i(i2), (int) (a5VarK.d.d(ab0VarL) * (-1.0f)));
        }
        c(a5VarK);
    }

    public final void g(ab0 ab0Var, ab0 ab0Var2, int i, int i2) {
        a5 a5VarK = k();
        ab0 ab0VarL = l();
        ab0VarL.d = 0;
        a5VarK.c(ab0Var, ab0Var2, ab0VarL, i);
        if (i2 != 8) {
            a5VarK.d.g(i(i2), (int) (a5VarK.d.d(ab0VarL) * (-1.0f)));
        }
        c(a5VarK);
    }

    public final void h(a5 a5Var) {
        boolean z = p;
        j1 j1Var = this.k;
        if (z) {
            a5 a5Var2 = this.e[this.i];
            if (a5Var2 != null) {
                ((s10) j1Var.a).b(a5Var2);
            }
        } else {
            a5 a5Var3 = this.e[this.i];
            if (a5Var3 != null) {
                ((s10) j1Var.b).b(a5Var3);
            }
        }
        a5[] a5VarArr = this.e;
        int i = this.i;
        a5VarArr[i] = a5Var;
        ab0 ab0Var = a5Var.a;
        ab0Var.c = i;
        this.i = i + 1;
        ab0Var.d(a5Var);
    }

    public final ab0 i(int i) {
        if (this.h + 1 >= this.d) {
            n();
        }
        ab0 ab0VarA = a(4);
        float[] fArr = ab0VarA.h;
        int i2 = this.a + 1;
        this.a = i2;
        this.h++;
        ab0VarA.b = i2;
        ab0VarA.d = i;
        ((ab0[]) this.k.d)[i2] = ab0VarA;
        l20 l20Var = this.b;
        l20Var.i.a = ab0VarA;
        Arrays.fill(fArr, 0.0f);
        fArr[ab0VarA.d] = 1.0f;
        l20Var.i(ab0VarA);
        return ab0VarA;
    }

    public final ab0 j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.h + 1 >= this.d) {
            n();
        }
        if (!(obj instanceof ta)) {
            return null;
        }
        ta taVar = (ta) obj;
        ab0 ab0Var = taVar.g;
        if (ab0Var == null) {
            taVar.i();
            ab0Var = taVar.g;
        }
        int i = ab0Var.b;
        j1 j1Var = this.k;
        if (i != -1 && i <= this.a && ((ab0[]) j1Var.d)[i] != null) {
            return ab0Var;
        }
        if (i != -1) {
            ab0Var.c();
        }
        int i2 = this.a + 1;
        this.a = i2;
        this.h++;
        ab0Var.b = i2;
        ab0Var.l = 1;
        ((ab0[]) j1Var.d)[i2] = ab0Var;
        return ab0Var;
    }

    public final a5 k() {
        boolean z = p;
        j1 j1Var = this.k;
        if (z) {
            a5 a5Var = (a5) ((s10) j1Var.a).a();
            if (a5Var == null) {
                return new du(j1Var);
            }
            a5Var.a = null;
            a5Var.d.clear();
            a5Var.b = 0.0f;
            a5Var.e = false;
            return a5Var;
        }
        a5 a5Var2 = (a5) ((s10) j1Var.b).a();
        if (a5Var2 == null) {
            return new a5(j1Var);
        }
        a5Var2.a = null;
        a5Var2.d.clear();
        a5Var2.b = 0.0f;
        a5Var2.e = false;
        return a5Var2;
    }

    public final ab0 l() {
        if (this.h + 1 >= this.d) {
            n();
        }
        ab0 ab0VarA = a(3);
        int i = this.a + 1;
        this.a = i;
        this.h++;
        ab0VarA.b = i;
        ((ab0[]) this.k.d)[i] = ab0VarA;
        return ab0VarA;
    }

    public final void n() {
        int i = this.c * 2;
        this.c = i;
        this.e = (a5[]) Arrays.copyOf(this.e, i);
        j1 j1Var = this.k;
        j1Var.d = (ab0[]) Arrays.copyOf((ab0[]) j1Var.d, this.c);
        int i2 = this.c;
        this.g = new boolean[i2];
        this.d = i2;
        this.j = i2;
    }

    public final void o(l20 l20Var) {
        j1 j1Var;
        int i = 0;
        while (true) {
            if (i >= this.i) {
                break;
            }
            a5 a5Var = this.e[i];
            int i2 = 1;
            if (a5Var.a.l != 1) {
                float f = 0.0f;
                if (a5Var.b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            int i8 = this.i;
                            j1Var = this.k;
                            if (i6 >= i8) {
                                break;
                            }
                            a5 a5Var2 = this.e[i6];
                            if (a5Var2.a.l != i2 && !a5Var2.e && a5Var2.b < f) {
                                int i9 = i2;
                                while (i9 < this.h) {
                                    ab0 ab0Var = ((ab0[]) j1Var.d)[i9];
                                    float fD = a5Var2.d.d(ab0Var);
                                    if (fD > f) {
                                        for (int i10 = 0; i10 < 9; i10++) {
                                            float f3 = ab0Var.g[i10] / fD;
                                            if ((f3 < f2 && i10 == i7) || i10 > i7) {
                                                i7 = i10;
                                                f2 = f3;
                                                i4 = i6;
                                                i5 = i9;
                                            }
                                        }
                                    }
                                    i9++;
                                    f = 0.0f;
                                }
                            }
                            i6++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i4 != -1) {
                            a5 a5Var3 = this.e[i4];
                            a5Var3.a.c = -1;
                            a5Var3.f(((ab0[]) j1Var.d)[i5]);
                            ab0 ab0Var2 = a5Var3.a;
                            ab0Var2.c = i4;
                            ab0Var2.d(a5Var3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.h / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        p(l20Var);
        for (int i11 = 0; i11 < this.i; i11++) {
            a5 a5Var4 = this.e[i11];
            a5Var4.a.e = a5Var4.b;
        }
    }

    public final void p(a5 a5Var) {
        for (int i = 0; i < this.h; i++) {
            this.g[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.h * 2) {
                return;
            }
            ab0 ab0Var = a5Var.a;
            if (ab0Var != null) {
                this.g[ab0Var.b] = true;
            }
            ab0 ab0VarD = a5Var.d(this.g);
            if (ab0VarD != null) {
                boolean[] zArr = this.g;
                int i3 = ab0VarD.b;
                if (zArr[i3]) {
                    return;
                } else {
                    zArr[i3] = true;
                }
            }
            if (ab0VarD != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.i; i5++) {
                    a5 a5Var2 = this.e[i5];
                    if (a5Var2.a.l != 1 && !a5Var2.e && a5Var2.d.h(ab0VarD)) {
                        float fD = a5Var2.d.d(ab0VarD);
                        if (fD < 0.0f) {
                            float f2 = (-a5Var2.b) / fD;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    a5 a5Var3 = this.e[i4];
                    a5Var3.a.c = -1;
                    a5Var3.f(ab0VarD);
                    ab0 ab0Var2 = a5Var3.a;
                    ab0Var2.c = i4;
                    ab0Var2.d(a5Var3);
                }
            } else {
                z = true;
            }
        }
    }

    public final void q() {
        boolean z = p;
        j1 j1Var = this.k;
        int i = 0;
        if (z) {
            while (true) {
                a5[] a5VarArr = this.e;
                if (i >= a5VarArr.length) {
                    return;
                }
                a5 a5Var = a5VarArr[i];
                if (a5Var != null) {
                    ((s10) j1Var.a).b(a5Var);
                }
                this.e[i] = null;
                i++;
            }
        } else {
            while (true) {
                a5[] a5VarArr2 = this.e;
                if (i >= a5VarArr2.length) {
                    return;
                }
                a5 a5Var2 = a5VarArr2[i];
                if (a5Var2 != null) {
                    ((s10) j1Var.b).b(a5Var2);
                }
                this.e[i] = null;
                i++;
            }
        }
    }

    public final void r() {
        j1 j1Var;
        int i = 0;
        while (true) {
            j1Var = this.k;
            ab0[] ab0VarArr = (ab0[]) j1Var.d;
            if (i >= ab0VarArr.length) {
                break;
            }
            ab0 ab0Var = ab0VarArr[i];
            if (ab0Var != null) {
                ab0Var.c();
            }
            i++;
        }
        s10 s10Var = (s10) j1Var.c;
        ab0[] ab0VarArr2 = this.l;
        int length = this.m;
        s10Var.getClass();
        if (length > ab0VarArr2.length) {
            length = ab0VarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            ab0 ab0Var2 = ab0VarArr2[i2];
            int i3 = s10Var.c;
            Object[] objArr = s10Var.b;
            if (i3 < objArr.length) {
                objArr[i3] = ab0Var2;
                s10Var.c = i3 + 1;
            }
        }
        this.m = 0;
        Arrays.fill((ab0[]) j1Var.d, (Object) null);
        this.a = 0;
        l20 l20Var = this.b;
        l20Var.h = 0;
        l20Var.b = 0.0f;
        this.h = 1;
        for (int i4 = 0; i4 < this.i; i4++) {
            this.e[i4].getClass();
        }
        q();
        this.i = 0;
        if (p) {
            this.n = new du(j1Var);
        } else {
            this.n = new a5(j1Var);
        }
    }
}
