package sensei0;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ev {
    public final int a;
    public final ws b;
    public final pf c;
    public int d;
    public int e;
    public int f;

    public ev(int i) {
        this.a = i;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = new ws(4);
        this.c = new pf(22);
    }

    public final Object a(Object obj) {
        pr.j("key", obj);
        synchronized (this.c) {
            ws wsVar = this.b;
            wsVar.getClass();
            Object obj2 = ((LinkedHashMap) wsVar.b).get(obj);
            if (obj2 != null) {
                this.e++;
                return obj2;
            }
            this.f++;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00be, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            sensei0.pr.j(r0, r6)
            sensei0.pf r0 = r5.c
            monitor-enter(r0)
            int r1 = r5.d     // Catch: java.lang.Throwable -> L24
            int r1 = r1 + 1
            r5.d = r1     // Catch: java.lang.Throwable -> L24
            sensei0.ws r1 = r5.b     // Catch: java.lang.Throwable -> L24
            r1.getClass()     // Catch: java.lang.Throwable -> L24
            java.lang.Object r1 = r1.b     // Catch: java.lang.Throwable -> L24
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r1.put(r6, r7)     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L27
            int r7 = r5.d     // Catch: java.lang.Throwable -> L24
            int r7 = r7 + (-1)
            r5.d = r7     // Catch: java.lang.Throwable -> L24
            goto L27
        L24:
            r6 = move-exception
            goto Lc1
        L27:
            monitor-exit(r0)
            int r7 = r5.a
        L2a:
            sensei0.pf r0 = r5.c
            monitor-enter(r0)
            int r1 = r5.d     // Catch: java.lang.Throwable -> L42
            if (r1 < 0) goto Lb7
            sensei0.ws r1 = r5.b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.b     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L45
            int r1 = r5.d     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto Lb7
            goto L45
        L42:
            r6 = move-exception
            goto Lbf
        L45:
            int r1 = r5.d     // Catch: java.lang.Throwable -> L42
            if (r1 <= r7) goto Lb5
            sensei0.ws r1 = r5.b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.b     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L56
            goto Lb5
        L56:
            sensei0.ws r1 = r5.b     // Catch: java.lang.Throwable -> L42
            java.lang.Object r1 = r1.b     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1     // Catch: java.lang.Throwable -> L42
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "map.entries"
            sensei0.pr.i(r2, r1)     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L42
            r3 = 0
            if (r2 == 0) goto L79
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L73
            goto L88
        L73:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L42
            goto L88
        L79:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L42
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L42
            if (r2 != 0) goto L84
            goto L88
        L84:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L42
        L88:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto L8e
            monitor-exit(r0)
            return r6
        L8e:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L42
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L42
            sensei0.ws r3 = r5.b     // Catch: java.lang.Throwable -> L42
            r3.getClass()     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = "key"
            sensei0.pr.j(r4, r1)     // Catch: java.lang.Throwable -> L42
            java.lang.Object r3 = r3.b     // Catch: java.lang.Throwable -> L42
            java.util.LinkedHashMap r3 = (java.util.LinkedHashMap) r3     // Catch: java.lang.Throwable -> L42
            r3.remove(r1)     // Catch: java.lang.Throwable -> L42
            int r1 = r5.d     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "value"
            sensei0.pr.j(r3, r2)     // Catch: java.lang.Throwable -> L42
            int r1 = r1 + (-1)
            r5.d = r1     // Catch: java.lang.Throwable -> L42
            monitor-exit(r0)
            goto L2a
        Lb5:
            monitor-exit(r0)
            return r6
        Lb7:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L42
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L42
            throw r7     // Catch: java.lang.Throwable -> L42
        Lbf:
            monitor-exit(r0)
            throw r6
        Lc1:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ev.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.e;
                int i2 = this.f + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.e + ",misses=" + this.f + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
