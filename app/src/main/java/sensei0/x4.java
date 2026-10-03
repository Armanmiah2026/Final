package sensei0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class x4 implements Collection {
    public final /* synthetic */ y4 a;

    public x4(y4 y4Var) {
        this.a = y4Var;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new u4(this.a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        y4 y4Var = this.a;
        int iA = y4Var.a(obj);
        if (iA < 0) {
            return false;
        }
        y4Var.g(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        y4 y4Var = this.a;
        int i = y4Var.c;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (collection.contains(y4Var.i(i2))) {
                y4Var.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        y4 y4Var = this.a;
        int i = y4Var.c;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (!collection.contains(y4Var.i(i2))) {
                y4Var.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.a.c;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        y4 y4Var = this.a;
        int i = y4Var.c;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = y4Var.i(i2);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        y4 y4Var = this.a;
        int i = y4Var.c;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = y4Var.i(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
