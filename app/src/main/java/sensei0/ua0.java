package sensei0;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ua0 extends AbstractMap {
    public static final /* synthetic */ int h = 0;
    public List a;
    public Map b;
    public boolean c;
    public volatile t4 d;
    public Map f;

    public static ua0 f() {
        ua0 ua0Var = new ua0();
        ua0Var.a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        ua0Var.b = map;
        ua0Var.f = map;
        return ua0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.a
            java.lang.Object r2 = r2.get(r1)
            sensei0.va0 r2 = (sensei0.va0) r2
            java.lang.Comparable r2 = r2.a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.a
            java.lang.Object r3 = r3.get(r2)
            sensei0.va0 r3 = (sensei0.va0) r3
            java.lang.Comparable r3 = r3.a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ua0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.a.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        if (this.b.isEmpty()) {
            return;
        }
        this.b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.b.containsKey(comparable);
    }

    public final Set d() {
        return this.b.isEmpty() ? Collections.EMPTY_SET : this.b.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.b.isEmpty() && !(this.b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.b = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.d == null) {
            this.d = new t4(1, this);
        }
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ua0)) {
            return super.equals(obj);
        }
        ua0 ua0Var = (ua0) obj;
        int size = size();
        if (size == ua0Var.size()) {
            int size2 = this.a.size();
            if (size2 != ua0Var.a.size()) {
                return ((AbstractSet) entrySet()).equals(ua0Var.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(ua0Var.c(i))) {
                }
            }
            if (size2 != size) {
                return this.b.equals(ua0Var.b);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((va0) this.a.get(iA)).setValue(obj);
        }
        b();
        if (this.a.isEmpty() && !(this.a instanceof ArrayList)) {
            this.a = new ArrayList(16);
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        if (this.a.size() == 16) {
            va0 va0Var = (va0) this.a.remove(15);
            e().put(va0Var.a, va0Var.b);
        }
        this.a.add(i, new va0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((va0) this.a.get(iA)).b : this.b.get(comparable);
    }

    public final Object h(int i) {
        b();
        Object obj = ((va0) this.a.remove(i)).b;
        if (!this.b.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new va0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.a.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((va0) this.a.get(i)).hashCode();
        }
        return this.b.size() > 0 ? this.b.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.b.size() + this.a.size();
    }
}
