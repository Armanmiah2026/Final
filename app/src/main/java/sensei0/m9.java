package sensei0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m9 extends mm0 {
    public static final Logger q = Logger.getLogger(m9.class.getName());
    public static final boolean r = wg0.e;
    public sv l;
    public final byte[] m;
    public final int n;
    public int o;
    public final hg0 p;

    public m9(hg0 hg0Var, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.m = new byte[iMax];
        this.n = iMax;
        this.p = hg0Var;
    }

    public static int A0(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int B0(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int x0(int i, u6 u6Var) {
        int iZ0 = z0(i);
        int size = u6Var.size();
        return A0(size) + size + iZ0;
    }

    public static int y0(String str) {
        int length;
        try {
            length = ch0.a(str);
        } catch (bh0 unused) {
            length = str.getBytes(mr.a).length;
        }
        return A0(length) + length;
    }

    public static int z0(int i) {
        return A0(i << 3);
    }

    public final void C0() {
        this.p.write(this.m, 0, this.o);
        this.o = 0;
    }

    public final void D0(int i) {
        if (this.n - this.o < i) {
            C0();
        }
    }

    public final void E0(byte b) {
        if (this.o == this.n) {
            C0();
        }
        int i = this.o;
        this.o = i + 1;
        this.m[i] = b;
    }

    public final void F0(byte[] bArr, int i, int i2) {
        int i3 = this.o;
        int i4 = this.n;
        int i5 = i4 - i3;
        byte[] bArr2 = this.m;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.o += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i3, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.o = i4;
        C0();
        if (i7 > i4) {
            this.p.write(bArr, i6, i7);
        } else {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.o = i7;
        }
    }

    public final void G0(int i, boolean z) {
        D0(11);
        u0(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        int i2 = this.o;
        this.o = i2 + 1;
        this.m[i2] = b;
    }

    public final void H0(int i, u6 u6Var) {
        S0(i, 2);
        I0(u6Var);
    }

    public final void I0(u6 u6Var) {
        U0(u6Var.size());
        q0(u6Var.e(), u6Var.size(), u6Var.b);
    }

    public final void J0(int i, int i2) {
        D0(14);
        u0(i, 5);
        s0(i2);
    }

    public final void K0(int i) {
        D0(4);
        s0(i);
    }

    public final void L0(int i, long j) {
        D0(18);
        u0(i, 1);
        t0(j);
    }

    public final void M0(long j) {
        D0(8);
        t0(j);
    }

    public final void N0(int i, int i2) {
        D0(20);
        u0(i, 0);
        if (i2 >= 0) {
            v0(i2);
        } else {
            w0(i2);
        }
    }

    public final void O0(int i) {
        if (i >= 0) {
            U0(i);
        } else {
            W0(i);
        }
    }

    public final void P0(int i, n nVar, v60 v60Var) {
        S0(i, 2);
        U0(nVar.a(v60Var));
        v60Var.b(nVar, this.l);
    }

    public final void Q0(int i, String str) throws l9 {
        S0(i, 2);
        R0(str);
    }

    public final void R0(String str) throws l9 {
        try {
            int length = str.length() * 3;
            int iA0 = A0(length);
            int i = iA0 + length;
            int i2 = this.n;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iU = ch0.a.u(str, bArr, 0, length);
                U0(iU);
                F0(bArr, 0, iU);
                return;
            }
            if (i > i2 - this.o) {
                C0();
            }
            int iA02 = A0(str.length());
            int i3 = this.o;
            byte[] bArr2 = this.m;
            try {
                try {
                    if (iA02 == iA0) {
                        int i4 = i3 + iA02;
                        this.o = i4;
                        int iU2 = ch0.a.u(str, bArr2, i4, i2 - i4);
                        this.o = i3;
                        v0((iU2 - i3) - iA02);
                        this.o = iU2;
                    } else {
                        int iA = ch0.a(str);
                        v0(iA);
                        this.o = ch0.a.u(str, bArr2, this.o, iA);
                    }
                } catch (bh0 e) {
                    this.o = i3;
                    throw e;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new l9(e2);
            }
        } catch (bh0 e3) {
            q.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e3);
            byte[] bytes = str.getBytes(mr.a);
            try {
                U0(bytes.length);
                q0(0, bytes.length, bytes);
            } catch (IndexOutOfBoundsException e4) {
                throw new l9(e4);
            }
        }
    }

    public final void S0(int i, int i2) {
        U0((i << 3) | i2);
    }

    public final void T0(int i, int i2) {
        D0(20);
        u0(i, 0);
        v0(i2);
    }

    public final void U0(int i) {
        D0(5);
        v0(i);
    }

    public final void V0(int i, long j) {
        D0(20);
        u0(i, 0);
        w0(j);
    }

    public final void W0(long j) {
        D0(10);
        w0(j);
    }

    @Override // sensei0.mm0
    public final void q0(int i, int i2, byte[] bArr) {
        F0(bArr, i, i2);
    }

    public final void s0(int i) {
        int i2 = this.o;
        int i3 = i2 + 1;
        this.o = i3;
        byte[] bArr = this.m;
        bArr[i2] = (byte) (i & 255);
        int i4 = i2 + 2;
        this.o = i4;
        bArr[i3] = (byte) ((i >> 8) & 255);
        int i5 = i2 + 3;
        this.o = i5;
        bArr[i4] = (byte) ((i >> 16) & 255);
        this.o = i2 + 4;
        bArr[i5] = (byte) ((i >> 24) & 255);
    }

    public final void t0(long j) {
        int i = this.o;
        int i2 = i + 1;
        this.o = i2;
        byte[] bArr = this.m;
        bArr[i] = (byte) (j & 255);
        int i3 = i + 2;
        this.o = i3;
        bArr[i2] = (byte) ((j >> 8) & 255);
        int i4 = i + 3;
        this.o = i4;
        bArr[i3] = (byte) ((j >> 16) & 255);
        int i5 = i + 4;
        this.o = i5;
        bArr[i4] = (byte) (255 & (j >> 24));
        int i6 = i + 5;
        this.o = i6;
        bArr[i5] = (byte) (((int) (j >> 32)) & 255);
        int i7 = i + 6;
        this.o = i7;
        bArr[i6] = (byte) (((int) (j >> 40)) & 255);
        int i8 = i + 7;
        this.o = i8;
        bArr[i7] = (byte) (((int) (j >> 48)) & 255);
        this.o = i + 8;
        bArr[i8] = (byte) (((int) (j >> 56)) & 255);
    }

    public final void u0(int i, int i2) {
        v0((i << 3) | i2);
    }

    public final void v0(int i) {
        boolean z = r;
        byte[] bArr = this.m;
        if (z) {
            while ((i & (-128)) != 0) {
                int i2 = this.o;
                this.o = i2 + 1;
                wg0.j(bArr, i2, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            int i3 = this.o;
            this.o = i3 + 1;
            wg0.j(bArr, i3, (byte) i);
            return;
        }
        while ((i & (-128)) != 0) {
            int i4 = this.o;
            this.o = i4 + 1;
            bArr[i4] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        int i5 = this.o;
        this.o = i5 + 1;
        bArr[i5] = (byte) i;
    }

    public final void w0(long j) {
        boolean z = r;
        byte[] bArr = this.m;
        if (z) {
            while ((j & (-128)) != 0) {
                int i = this.o;
                this.o = i + 1;
                wg0.j(bArr, i, (byte) ((((int) j) | 128) & 255));
                j >>>= 7;
            }
            int i2 = this.o;
            this.o = i2 + 1;
            wg0.j(bArr, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            int i3 = this.o;
            this.o = i3 + 1;
            bArr[i3] = (byte) ((((int) j) | 128) & 255);
            j >>>= 7;
        }
        int i4 = this.o;
        this.o = i4 + 1;
        bArr[i4] = (byte) j;
    }
}
