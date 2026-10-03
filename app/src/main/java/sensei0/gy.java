package sensei0;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gy {
    public final LinkedHashMap a;
    public final sv b;

    public gy(LinkedHashMap linkedHashMap, boolean z) {
        this.a = linkedHashMap;
        this.b = new sv(z);
    }

    public final Map a() {
        qz qzVar;
        Set<Map.Entry> setEntrySet = this.a.entrySet();
        int iC0 = xv.c0(q9.h0(setEntrySet));
        if (iC0 < 16) {
            iC0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iC0);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                pr.i("copyOf(this, size)", bArrCopyOf);
                qzVar = new qz(key, bArrCopyOf);
            } else {
                qzVar = new qz(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(qzVar.a, qzVar.b);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        pr.i("unmodifiableMap(map)", mapUnmodifiableMap);
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (((AtomicBoolean) this.b.b).get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final Object c(a20 a20Var) {
        pr.j("key", a20Var);
        Object obj = this.a.get(a20Var);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        pr.i("copyOf(this, size)", bArrCopyOf);
        return bArrCopyOf;
    }

    public final void d(a20 a20Var, Object obj) {
        b();
        LinkedHashMap linkedHashMap = this.a;
        if (obj == null) {
            b();
            linkedHashMap.remove(a20Var);
            return;
        }
        if (obj instanceof Set) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(o9.t0((Set) obj));
            pr.i("unmodifiableSet(set.toSet())", setUnmodifiableSet);
            linkedHashMap.put(a20Var, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(a20Var, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            pr.i("copyOf(this, size)", bArrCopyOf);
            linkedHashMap.put(a20Var, bArrCopyOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sensei0.gy
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            sensei0.gy r7 = (sensei0.gy) r7
            java.util.LinkedHashMap r7 = r7.a
            java.util.LinkedHashMap r0 = r6.a
            r2 = 1
            if (r7 != r0) goto L10
            goto L61
        L10:
            int r3 = r7.size()
            int r4 = r0.size()
            if (r3 == r4) goto L1b
            goto L60
        L1b:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L22
            goto L61
        L22:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2a:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L61
            java.lang.Object r3 = r7.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r4 = r0.get(r4)
            if (r4 == 0) goto L5d
            java.lang.Object r3 = r3.getValue()
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L58
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5d
            byte[] r3 = (byte[]) r3
            byte[] r4 = (byte[]) r4
            boolean r3 = java.util.Arrays.equals(r3, r4)
            if (r3 == 0) goto L5d
            r3 = r2
            goto L5e
        L58:
            boolean r3 = sensei0.pr.b(r3, r4)
            goto L5e
        L5d:
            r3 = r1
        L5e:
            if (r3 != 0) goto L2a
        L60:
            return r1
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.gy.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return o9.m0(this.a.entrySet(), ",\n", "{\n", "\n}", nc.f, 24);
    }

    public /* synthetic */ gy(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
