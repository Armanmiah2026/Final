package sensei0;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d8 extends d70 {
    public final o6 e;
    public final /* synthetic */ AtomicReferenceArray f;

    public d8(long j, d8 d8Var, o6 o6Var, int i) {
        super(j, d8Var, i);
        this.e = o6Var;
        this.f = new AtomicReferenceArray(q6.b * 2);
    }

    @Override // sensei0.d70
    public final int f() {
        return q6.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        sensei0.pr.f(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // sensei0.d70
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(int r5, sensei0.lc r6) {
        /*
            r4 = this;
            int r6 = sensei0.q6.b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof sensei0.kj0
            sensei0.o6 r2 = r4.e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof sensei0.lj0
            if (r1 == 0) goto L21
            goto L62
        L21:
            sensei0.tn r1 = sensei0.q6.j
            if (r6 == r1) goto L59
            sensei0.tn r1 = sensei0.q6.k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            sensei0.tn r1 = sensei0.q6.g
            if (r6 == r1) goto L11
            sensei0.tn r1 = sensei0.q6.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            sensei0.tn r5 = sensei0.q6.i
            if (r6 == r5) goto L7c
            sensei0.tn r5 = sensei0.q6.d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            sensei0.tn r5 = sensei0.q6.l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.m(r5, r3)
            if (r0 == 0) goto L7c
            sensei0.pr.f(r2)
            return
        L62:
            if (r0 == 0) goto L67
            sensei0.tn r1 = sensei0.q6.j
            goto L69
        L67:
            sensei0.tn r1 = sensei0.q6.k
        L69:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            sensei0.pr.f(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.d8.g(int, sensei0.lc):void");
    }

    public final boolean j(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i2 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.f;
            if (atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i2) == obj);
        return false;
    }

    public final Object k(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void l(int i, boolean z) {
        if (z) {
            o6 o6Var = this.e;
            pr.f(o6Var);
            o6Var.C((this.c * ((long) q6.b)) + ((long) i));
        }
        h();
    }

    public final void m(int i, Object obj) {
        this.f.set(i * 2, obj);
    }

    public final void n(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }
}
