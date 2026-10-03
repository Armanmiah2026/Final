package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fl {
    public int a;
    public ta d;
    public ta e;
    public ta f;
    public ta g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int q;
    public final /* synthetic */ hl r;
    public hb b = null;
    public int c = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;

    public fl(hl hlVar, int i, ta taVar, ta taVar2, ta taVar3, ta taVar4, int i2) {
        this.r = hlVar;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.q = 0;
        this.a = i;
        this.d = taVar;
        this.e = taVar2;
        this.f = taVar3;
        this.g = taVar4;
        this.h = hlVar.j0;
        this.i = hlVar.f0;
        this.j = hlVar.k0;
        this.k = hlVar.g0;
        this.q = i2;
    }

    public final void a(hb hbVar) {
        int i = this.a;
        hl hlVar = this.r;
        if (i == 0) {
            int iD = hlVar.D(hbVar, this.q);
            if (hbVar.c0[0] == 3) {
                this.p++;
                iD = 0;
            }
            this.l = iD + (hbVar.V != 8 ? hlVar.C0 : 0) + this.l;
            int iC = hlVar.C(hbVar, this.q);
            if (this.b == null || this.c < iC) {
                this.b = hbVar;
                this.c = iC;
                this.m = iC;
            }
        } else {
            int iD2 = hlVar.D(hbVar, this.q);
            int iC2 = hlVar.C(hbVar, this.q);
            if (hbVar.c0[1] == 3) {
                this.p++;
                iC2 = 0;
            }
            this.m = iC2 + (hbVar.V != 8 ? hlVar.D0 : 0) + this.m;
            if (this.b == null || this.c < iD2) {
                this.b = hbVar;
                this.c = iD2;
                this.l = iD2;
            }
        }
        this.o++;
    }

    public final void b(int i, boolean z, boolean z2) {
        hl hlVar;
        int i2;
        hb hbVar;
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.o;
        int i8 = 0;
        while (true) {
            hlVar = this.r;
            if (i8 >= i7 || (i6 = this.n + i8) >= hlVar.O0) {
                break;
            }
            hb hbVar2 = hlVar.N0[i6];
            if (hbVar2 != null) {
                hbVar2.t();
            }
            i8++;
        }
        if (i7 == 0 || this.b == null) {
            return;
        }
        boolean z3 = z2 && i == 0;
        int i9 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = this.n + (z ? (i7 - 1) - i11 : i11);
            if (i12 >= hlVar.O0) {
                break;
            }
            if (hlVar.N0[i12].V == 0) {
                if (i9 == -1) {
                    i9 = i11;
                }
                i10 = i11;
            }
        }
        if (this.a != 0) {
            hb hbVar3 = this.b;
            hbVar3.X = hlVar.q0;
            ta taVar = hbVar3.x;
            ta taVar2 = hbVar3.z;
            int i13 = this.h;
            if (i > 0) {
                i13 += hlVar.C0;
            }
            if (z) {
                taVar2.a(this.f, i13);
                if (z2) {
                    taVar.a(this.d, this.j);
                }
                if (i > 0) {
                    this.f.b.x.a(taVar2, 0);
                }
            } else {
                taVar.a(this.d, i13);
                if (z2) {
                    taVar2.a(this.f, this.j);
                }
                if (i > 0) {
                    this.d.b.z.a(taVar, 0);
                }
            }
            hb hbVar4 = null;
            int i14 = 0;
            while (i14 < i7) {
                int i15 = this.n + i14;
                if (i15 >= hlVar.O0) {
                    return;
                }
                hb hbVar5 = hlVar.N0[i15];
                if (i14 == 0) {
                    hbVar5.e(hbVar5.y, this.e, this.i);
                    int i16 = hlVar.r0;
                    float f = hlVar.x0;
                    if (this.n == 0) {
                        int i17 = hlVar.t0;
                        i2 = -1;
                        if (i17 != -1) {
                            f = hlVar.z0;
                        }
                        i16 = i17;
                        hbVar5.Y = i16;
                        hbVar5.T = f;
                    } else {
                        i2 = -1;
                    }
                    if (z2 && (i17 = hlVar.v0) != i2) {
                        f = hlVar.B0;
                        i16 = i17;
                    }
                    hbVar5.Y = i16;
                    hbVar5.T = f;
                }
                if (i14 == i7 - 1) {
                    hbVar5.e(hbVar5.A, this.g, this.k);
                }
                if (hbVar4 != null) {
                    ta taVar3 = hbVar4.A;
                    ta taVar4 = hbVar5.y;
                    taVar4.a(taVar3, hlVar.D0);
                    if (i14 == i9) {
                        int i18 = this.i;
                        if (taVar4.f()) {
                            taVar4.f = i18;
                        }
                    }
                    taVar3.a(taVar4, 0);
                    if (i14 == i10 + 1) {
                        int i19 = this.k;
                        if (taVar3.f()) {
                            taVar3.f = i19;
                        }
                    }
                }
                if (hbVar5 != hbVar3) {
                    if (z) {
                        int i20 = hlVar.E0;
                        if (i20 == 0) {
                            hbVar5.z.a(taVar2, 0);
                        } else if (i20 == 1) {
                            hbVar5.x.a(taVar, 0);
                        } else if (i20 == 2) {
                            hbVar5.x.a(taVar, 0);
                            hbVar5.z.a(taVar2, 0);
                        }
                    } else {
                        int i21 = hlVar.E0;
                        if (i21 == 0) {
                            hbVar5.x.a(taVar, 0);
                        } else if (i21 == 1) {
                            hbVar5.z.a(taVar2, 0);
                        } else if (i21 == 2) {
                            if (z3) {
                                hbVar5.x.a(this.d, this.h);
                                hbVar5.z.a(this.f, this.j);
                            } else {
                                hbVar5.x.a(taVar, 0);
                                hbVar5.z.a(taVar2, 0);
                            }
                        }
                    }
                }
                i14++;
                hbVar4 = hbVar5;
            }
            return;
        }
        hb hbVar6 = this.b;
        hbVar6.Y = hlVar.r0;
        ta taVar5 = hbVar6.A;
        ta taVar6 = hbVar6.y;
        int i22 = this.i;
        if (i > 0) {
            i22 += hlVar.D0;
        }
        taVar6.a(this.e, i22);
        if (z2) {
            taVar5.a(this.g, this.k);
        }
        if (i > 0) {
            this.e.b.A.a(taVar6, 0);
        }
        if (hlVar.F0 != 3 || hbVar6.w) {
            hbVar = hbVar6;
        } else {
            for (int i23 = 0; i23 < i7; i23++) {
                int i24 = this.n + (z ? (i7 - 1) - i23 : i23);
                if (i24 >= hlVar.O0) {
                    break;
                }
                hbVar = hlVar.N0[i24];
                if (hbVar.w) {
                    break;
                }
            }
            hbVar = hbVar6;
        }
        int i25 = 0;
        hb hbVar7 = null;
        while (i25 < i7) {
            int i26 = z ? (i7 - 1) - i25 : i25;
            int i27 = this.n + i26;
            if (i27 >= hlVar.O0) {
                return;
            }
            hb hbVar8 = hlVar.N0[i27];
            if (i25 == 0) {
                hbVar8.e(hbVar8.x, this.d, this.h);
            }
            if (i26 == 0) {
                int i28 = hlVar.q0;
                float f2 = hlVar.w0;
                if (this.n == 0) {
                    int i29 = hlVar.s0;
                    i3 = i28;
                    i4 = -1;
                    if (i29 != -1) {
                        f2 = hlVar.y0;
                    }
                    i5 = i29;
                    hbVar8.X = i5;
                    hbVar8.S = f2;
                } else {
                    i3 = i28;
                    i4 = -1;
                }
                if (!z2 || (i29 = hlVar.u0) == i4) {
                    i5 = i3;
                    hbVar8.X = i5;
                    hbVar8.S = f2;
                } else {
                    f2 = hlVar.A0;
                    i5 = i29;
                    hbVar8.X = i5;
                    hbVar8.S = f2;
                }
            }
            if (i25 == i7 - 1) {
                hbVar8.e(hbVar8.z, this.f, this.j);
            }
            if (hbVar7 != null) {
                ta taVar7 = hbVar7.z;
                ta taVar8 = hbVar8.x;
                taVar8.a(taVar7, hlVar.C0);
                if (i25 == i9) {
                    int i30 = this.h;
                    if (taVar8.f()) {
                        taVar8.f = i30;
                    }
                }
                taVar7.a(taVar8, 0);
                if (i25 == i10 + 1) {
                    int i31 = this.j;
                    if (taVar7.f()) {
                        taVar7.f = i31;
                    }
                }
            }
            if (hbVar8 != hbVar6) {
                int i32 = hlVar.F0;
                c = 3;
                if (i32 == 3 && hbVar.w && hbVar8 != hbVar && hbVar8.w) {
                    hbVar8.B.a(hbVar.B, 0);
                } else if (i32 == 0) {
                    hbVar8.y.a(taVar6, 0);
                } else if (i32 == 1) {
                    hbVar8.A.a(taVar5, 0);
                } else if (z3) {
                    hbVar8.y.a(this.e, this.i);
                    hbVar8.A.a(this.g, this.k);
                } else {
                    hbVar8.y.a(taVar6, 0);
                    hbVar8.A.a(taVar5, 0);
                }
            } else {
                c = 3;
            }
            i25++;
            hbVar7 = hbVar8;
        }
    }

    public final int c() {
        return this.a == 1 ? this.m - this.r.D0 : this.m;
    }

    public final int d() {
        return this.a == 0 ? this.l - this.r.C0 : this.l;
    }

    public final void e(int i) {
        hl hlVar;
        int i2;
        int i3 = this.p;
        if (i3 == 0) {
            return;
        }
        int i4 = this.o;
        int i5 = i / i3;
        int i6 = 0;
        while (true) {
            hlVar = this.r;
            if (i6 >= i4 || (i2 = this.n + i6) >= hlVar.O0) {
                break;
            }
            hb hbVar = hlVar.N0[i2];
            if (this.a == 0) {
                if (hbVar != null) {
                    int[] iArr = hbVar.c0;
                    if (iArr[0] == 3 && hbVar.j == 0) {
                        hlVar.E(1, i5, iArr[1], hbVar.i(), hbVar);
                    }
                }
            } else if (hbVar != null) {
                int[] iArr2 = hbVar.c0;
                if (iArr2[1] == 3 && hbVar.k == 0) {
                    int i7 = i5;
                    hlVar.E(iArr2[0], hbVar.l(), 1, i7, hbVar);
                    i5 = i7;
                }
            }
            i6++;
        }
        this.l = 0;
        this.m = 0;
        this.b = null;
        this.c = 0;
        int i8 = this.o;
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.n + i9;
            if (i10 >= hlVar.O0) {
                return;
            }
            hb hbVar2 = hlVar.N0[i10];
            if (this.a == 0) {
                int iL = hbVar2.l();
                int i11 = hlVar.C0;
                if (hbVar2.V == 8) {
                    i11 = 0;
                }
                this.l = iL + i11 + this.l;
                int iC = hlVar.C(hbVar2, this.q);
                if (this.b == null || this.c < iC) {
                    this.b = hbVar2;
                    this.c = iC;
                    this.m = iC;
                }
            } else {
                int iD = hlVar.D(hbVar2, this.q);
                int iC2 = hlVar.C(hbVar2, this.q);
                int i12 = hlVar.D0;
                if (hbVar2.V == 8) {
                    i12 = 0;
                }
                this.m = iC2 + i12 + this.m;
                if (this.b == null || this.c < iD) {
                    this.b = hbVar2;
                    this.c = iD;
                    this.l = iD;
                }
            }
        }
    }

    public final void f(int i, ta taVar, ta taVar2, ta taVar3, ta taVar4, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.d = taVar;
        this.e = taVar2;
        this.f = taVar3;
        this.g = taVar4;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.q = i6;
    }
}
