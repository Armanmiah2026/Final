package sensei0;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class u6 implements Iterable, Serializable {
    public static final u6 c = new u6(mr.b);
    public static final t6 d;
    public int a = 0;
    public final byte[] b;

    static {
        d = p2.a() ? new mh(23) : new mh(22);
    }

    public u6(byte[] bArr) {
        bArr.getClass();
        this.b = bArr;
    }

    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(za0.i(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(za0.j("Beginning index larger than ending index: ", i, ", ", i2));
        }
        throw new IndexOutOfBoundsException(za0.j("End index: ", i2, " >= ", i3));
    }

    public static u6 c(int i, int i2, byte[] bArr) {
        b(i, i + i2, bArr.length);
        return new u6(d.d(i, i2, bArr));
    }

    public byte a(int i) {
        return this.b[i];
    }

    public void d(byte[] bArr, int i) {
        System.arraycopy(this.b, 0, bArr, 0, i);
    }

    public int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u6) || size() != ((u6) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof u6)) {
            return obj.equals(this);
        }
        u6 u6Var = (u6) obj;
        int i = this.a;
        int i2 = u6Var.a;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > u6Var.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > u6Var.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + u6Var.size());
        }
        byte[] bArr = u6Var.b;
        int iE = e() + size;
        int iE2 = e();
        int iE3 = u6Var.e();
        while (iE2 < iE) {
            if (this.b[iE2] != bArr[iE3]) {
                return false;
            }
            iE2++;
            iE3++;
        }
        return true;
    }

    public byte f(int i) {
        return this.b[i];
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iE = e();
        int i2 = size;
        for (int i3 = iE; i3 < iE + size; i3++) {
            i2 = (i2 * 31) + this.b[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.a = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new r6(this);
    }

    public int size() {
        return this.b.length;
    }

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = k6.p(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iB = b(0, 47, size());
            sb.append(k6.p(iB == 0 ? c : new s6(this.b, e(), iB)));
            sb.append("...");
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(size);
        sb2.append(" contents=\"");
        return za0.o(sb2, string, "\">");
    }
}
