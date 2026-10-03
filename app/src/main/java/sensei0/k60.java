package sensei0;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class k60 implements Iterable {
    public h60 a;
    public h60 b;
    public final WeakHashMap c = new WeakHashMap();
    public int d = 0;

    public h60 a(Object obj) {
        h60 h60Var = this.a;
        while (h60Var != null && !h60Var.a.equals(obj)) {
            h60Var = h60Var.c;
        }
        return h60Var;
    }

    public Object b(Object obj) {
        h60 h60VarA = a(obj);
        if (h60VarA == null) {
            return null;
        }
        this.d--;
        WeakHashMap weakHashMap = this.c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((j60) it.next()).a(h60VarA);
            }
        }
        h60 h60Var = h60VarA.d;
        if (h60Var != null) {
            h60Var.c = h60VarA.c;
        } else {
            this.a = h60VarA.c;
        }
        h60 h60Var2 = h60VarA.c;
        if (h60Var2 != null) {
            h60Var2.d = h60Var;
        } else {
            this.b = h60Var;
        }
        h60VarA.c = null;
        h60VarA.d = null;
        return h60VarA.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((sensei0.g60) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof sensei0.k60
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            sensei0.k60 r7 = (sensei0.k60) r7
            int r1 = r6.d
            int r3 = r7.d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            sensei0.g60 r3 = (sensei0.g60) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            sensei0.g60 r4 = (sensei0.g60) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            sensei0.g60 r7 = (sensei0.g60) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.k60.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            g60 g60Var = (g60) it;
            if (!g60Var.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) g60Var.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        g60 g60Var = new g60(this.a, this.b, 0);
        this.c.put(g60Var, Boolean.FALSE);
        return g60Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            g60 g60Var = (g60) it;
            if (!g60Var.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) g60Var.next()).toString());
            if (g60Var.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
