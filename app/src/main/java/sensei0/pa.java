package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pa extends o6 {
    public final m6 s;

    public pa(int i, m6 m6Var) {
        super(i);
        this.s = m6Var;
        if (m6Var != m6.a) {
            if (i < 1) {
                throw new IllegalArgumentException(za0.i(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + y40.a(o6.class).b() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            sensei0.m6 r1 = r15.s
            sensei0.m6 r2 = sensei0.m6.c
            sensei0.mg0 r8 = sensei0.mg0.a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.k(r16)
            boolean r2 = r1 instanceof sensei0.c8
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof sensei0.b8
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            sensei0.tn r6 = sensei0.q6.d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sensei0.o6.h
            java.lang.Object r1 = r1.get(r15)
            sensei0.d8 r1 = (sensei0.d8) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sensei0.o6.b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.r(r2, r7)
            int r9 = sensei0.q6.b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            sensei0.d8 r2 = sensei0.o6.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = sensei0.o6.d(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sensei0.o6.c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.h()
            java.lang.Throwable r1 = r15.o()
            sensei0.b8 r2 = new sensei0.b8
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof sensei0.kj0
            if (r3 == 0) goto La6
            sensei0.kj0 r6 = (sensei0.kj0) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lae:
            long r3 = r1.c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.h(r3)
        Lb6:
            return r8
        Lb7:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pa.D(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // sensei0.o6, sensei0.j70
    public final Object i(Object obj, yb ybVar) throws Throwable {
        if (D(obj, true) instanceof b8) {
            throw o();
        }
        return mg0.a;
    }

    @Override // sensei0.o6, sensei0.j70
    public final Object k(Object obj) {
        return D(obj, false);
    }

    @Override // sensei0.o6
    public final boolean t() {
        return this.s == m6.b;
    }
}
