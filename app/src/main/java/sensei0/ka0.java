package sensei0;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ka0 {
    public int[] a;
    public Object[] b;
    public int c;

    public ka0(int i) {
        this.a = i == 0 ? xe.e : new int[i];
        this.b = i == 0 ? xe.f : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            pr.i("copyOf(this, newSize)", iArrCopyOf);
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i * 2);
            pr.i("copyOf(this, newSize)", objArrCopyOf);
            this.b = objArrCopyOf;
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int iD = xe.d(i2, i, this.a);
        if (iD < 0 || pr.b(obj, this.b[iD << 1])) {
            return iD;
        }
        int i3 = iD + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (pr.b(obj, this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iD - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (pr.b(obj, this.b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void clear() {
        if (this.c > 0) {
            this.a = xe.e;
            this.b = xe.f;
            this.c = 0;
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int iD = xe.d(i, 0, this.a);
        if (iD < 0 || this.b[iD << 1] == null) {
            return iD;
        }
        int i2 = iD + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iD - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof ka0) {
                int i = this.c;
                if (i != ((ka0) obj).c) {
                    return false;
                }
                ka0 ka0Var = (ka0) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objF = f(i2);
                    Object objI = i(i2);
                    Object obj2 = ka0Var.get(objF);
                    if (objI == null) {
                        if (obj2 != null || !ka0Var.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objI.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.c != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.c;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objF2 = f(i4);
                Object objI2 = i(i4);
                Object obj3 = ((Map) obj).get(objF2);
                if (objI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objI2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        if (i < 0 || i >= this.c) {
            throw new IllegalArgumentException(za0.h(i, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.b[i << 1];
    }

    public final Object g(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.c)) {
            throw new IllegalArgumentException(za0.h(i, "Expected index to be within 0..size()-1, but was ").toString());
        }
        Object[] objArr = this.b;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i4 = i2 - 1;
        int[] iArr = this.a;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                c5.W(i, i5, i2, iArr, iArr);
                Object[] objArr2 = this.b;
                c5.X(objArr2, objArr2, i3, i5 << 1, i2 << 1);
            }
            Object[] objArr3 = this.b;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            pr.i("copyOf(this, newSize)", iArrCopyOf);
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i7 << 1);
            pr.i("copyOf(this, newSize)", objArrCopyOf);
            this.b = objArrCopyOf;
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                c5.W(0, 0, i, iArr, this.a);
                c5.X(objArr, this.b, 0, 0, i3);
            }
            if (i < i4) {
                int i8 = i + 1;
                c5.W(i, i8, i2, iArr, this.a);
                c5.X(objArr, this.b, i3, i8 << 1, i2 << 1);
            }
        }
        if (i2 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i4;
        return obj;
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.b[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.b[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i, Object obj) {
        if (i < 0 || i >= this.c) {
            throw new IllegalArgumentException(za0.h(i, "Expected index to be within 0..size()-1, but was ").toString());
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i) {
        if (i < 0 || i >= this.c) {
            throw new IllegalArgumentException(za0.h(i, "Expected index to be within 0..size()-1, but was ").toString());
        }
        return this.b[(i << 1) + 1];
    }

    public final boolean isEmpty() {
        return this.c <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i2 = (iC << 1) + 1;
            Object[] objArr = this.b;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iC;
        int[] iArr = this.a;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            pr.i("copyOf(this, newSize)", iArrCopyOf);
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i4 << 1);
            pr.i("copyOf(this, newSize)", objArrCopyOf);
            this.b = objArrCopyOf;
            if (i != this.c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.a;
            int i5 = i3 + 1;
            c5.W(i5, i3, i, iArr2, iArr2);
            Object[] objArr2 = this.b;
            c5.X(objArr2, objArr2, i5 << 1, i3 << 1, this.c << 1);
        }
        int i6 = this.c;
        if (i == i6) {
            int[] iArr3 = this.a;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.b;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.c = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objI = i(i2);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        pr.i("StringBuilder(capacity).…builderAction).toString()", string);
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !pr.b(obj2, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !pr.b(obj2, i(iD))) {
            return false;
        }
        h(iD, obj3);
        return true;
    }
}
