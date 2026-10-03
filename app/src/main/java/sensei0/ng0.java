package sensei0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ng0 {
    public static final ng0 f = new ng0(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public ng0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public final void a(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final int b() {
        int iZ0;
        int iB0;
        int iZ02;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.a; i3++) {
            int i4 = this.b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.c[i3]).getClass();
                    iZ02 = m9.z0(i5) + 8;
                } else if (i6 == 2) {
                    iZ02 = m9.x0(i5, (u6) this.c[i3]);
                } else if (i6 == 3) {
                    iZ0 = m9.z0(i5) * 2;
                    iB0 = ((ng0) this.c[i3]).b();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(tr.b());
                    }
                    ((Integer) this.c[i3]).getClass();
                    iZ02 = m9.z0(i5) + 4;
                }
                i2 = iZ02 + i2;
            } else {
                long jLongValue = ((Long) this.c[i3]).longValue();
                iZ0 = m9.z0(i5);
                iB0 = m9.B0(jLongValue);
            }
            i2 = iB0 + iZ0 + i2;
        }
        this.d = i2;
        return i2;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        a(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void d(sv svVar) {
        if (this.a == 0) {
            return;
        }
        svVar.getClass();
        m9 m9Var = (m9) svVar.b;
        for (int i = 0; i < this.a; i++) {
            int i2 = this.b[i];
            Object obj = this.c[i];
            int i3 = i2 >>> 3;
            int i4 = i2 & 7;
            if (i4 == 0) {
                m9Var.V0(i3, ((Long) obj).longValue());
            } else if (i4 == 1) {
                m9Var.L0(i3, ((Long) obj).longValue());
            } else if (i4 == 2) {
                m9Var.H0(i3, (u6) obj);
            } else if (i4 == 3) {
                m9Var.S0(i3, 3);
                ((ng0) obj).d(svVar);
                m9Var.S0(i3, 4);
            } else {
                if (i4 != 5) {
                    throw new RuntimeException(tr.b());
                }
                m9Var.J0(i3, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ng0)) {
            return false;
        }
        ng0 ng0Var = (ng0) obj;
        int i = this.a;
        if (i == ng0Var.a) {
            int[] iArr = this.b;
            int[] iArr2 = ng0Var.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.c;
                    Object[] objArr2 = ng0Var.c;
                    int i3 = this.a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.c;
        int i6 = this.a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }
}
