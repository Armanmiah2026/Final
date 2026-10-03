package sensei0;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b5 implements Collection, Set, os {
    public int[] a;
    public Object[] b;
    public int c;

    public final Object a(int i) {
        int i2 = this.c;
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i3 = i2 - 1;
        int[] iArr = this.a;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i3) {
                int i4 = i + 1;
                c5.W(i, i4, i2, iArr, iArr);
                Object[] objArr2 = this.b;
                c5.X(objArr2, objArr2, i, i4, i2);
            }
            this.b[i3] = null;
        } else {
            int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArr2 = new int[i5];
            this.a = iArr2;
            this.b = new Object[i5];
            if (i > 0) {
                c5.W(0, 0, i, iArr, iArr2);
                c5.Y(objArr, this.b, 0, i, 6);
            }
            if (i < i3) {
                int i6 = i + 1;
                c5.W(i, i6, i2, iArr, this.a);
                c5.X(objArr, this.b, i, i6, i2);
            }
        }
        if (i2 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i3;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iC;
        int i2 = this.c;
        if (obj == null) {
            iC = k6.C(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = k6.C(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i3 = ~iC;
        int[] iArr = this.a;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.b;
            int[] iArr2 = new int[i4];
            this.a = iArr2;
            this.b = new Object[i4];
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                c5.W(0, 0, iArr.length, iArr, iArr2);
                c5.Y(objArr, this.b, 0, objArr.length, 6);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.a;
            int i5 = i3 + 1;
            c5.W(i5, i3, i2, iArr3, iArr3);
            Object[] objArr2 = this.b;
            c5.X(objArr2, objArr2, i5, i3, i2);
        }
        int i6 = this.c;
        if (i2 == i6) {
            int[] iArr4 = this.a;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.b[i3] = obj;
                this.c = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        pr.j("elements", collection);
        int size = collection.size() + this.c;
        int i = this.c;
        int[] iArr = this.a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.b;
            int[] iArr2 = new int[size];
            this.a = iArr2;
            this.b = new Object[size];
            if (i > 0) {
                c5.W(0, 0, i, iArr, iArr2);
                c5.Y(objArr, this.b, 0, this.c, 6);
            }
        }
        if (this.c != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.c != 0) {
            this.a = xe.e;
            this.b = xe.f;
            this.c = 0;
        }
        if (this.c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? k6.C(this, null, 0) : k6.C(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        pr.j("elements", collection);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.b[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.a;
        int i = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new u4(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iC = obj == null ? k6.C(this, null, 0) : k6.C(this, obj, obj.hashCode());
        if (iC < 0) {
            return false;
        }
        a(iC);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        pr.j("elements", collection);
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        pr.j("elements", collection);
        boolean z = false;
        for (int i = this.c - 1; -1 < i; i--) {
            if (!collection.contains(this.b[i])) {
                a(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = this.b;
        int i = this.c;
        pr.j("<this>", objArr);
        xe.f(i, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, 0, i);
        pr.i("copyOfRange(...)", objArrCopyOfRange);
        return objArrCopyOfRange;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 14);
        sb.append('{');
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.b[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        pr.i("StringBuilder(capacity).…builderAction).toString()", string);
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        pr.j("array", objArr);
        int i = this.c;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        c5.X(this.b, objArr, 0, 0, this.c);
        return objArr;
    }
}
