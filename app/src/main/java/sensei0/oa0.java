package sensei0;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class oa0 {
    public final ky a = new ky();
    public final sv b = new sv(8);
    public final ws c = new ws(new na0(2, null));

    public oa0(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.b.b).get());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sensei0.fp r8, sensei0.yb r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof sensei0.la0
            if (r0 == 0) goto L13
            r0 = r9
            sensei0.la0 r0 = (sensei0.la0) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.la0 r0 = new sensei0.la0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.h
            int r1 = r0.p
            r2 = 2
            r3 = 1
            r4 = 0
            sensei0.vc r5 = sensei0.vc.a
            if (r1 == 0) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r0.d
            sensei0.hy r8 = (sensei0.hy) r8
            sensei0.wf0.H(r9)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r9 = move-exception
            goto L71
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            sensei0.ky r8 = r0.f
            java.lang.Object r1 = r0.d
            sensei0.fp r1 = (sensei0.fp) r1
            sensei0.wf0.H(r9)
            r9 = r8
            r8 = r1
            goto L57
        L45:
            sensei0.wf0.H(r9)
            r0.d = r8
            sensei0.ky r9 = r7.a
            r0.f = r9
            r0.p = r3
            java.lang.Object r1 = r9.c(r0)
            if (r1 != r5) goto L57
            goto L63
        L57:
            r0.d = r9     // Catch: java.lang.Throwable -> L6d
            r0.f = r4     // Catch: java.lang.Throwable -> L6d
            r0.p = r2     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r8 = r8.g(r0)     // Catch: java.lang.Throwable -> L6d
            if (r8 != r5) goto L64
        L63:
            return r5
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            sensei0.ky r8 = (sensei0.ky) r8
            r8.e(r4)
            return r9
        L6d:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L71:
            sensei0.ky r8 = (sensei0.ky) r8
            r8.e(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.oa0.b(sensei0.fp, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(sensei0.jp r6, sensei0.yb r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sensei0.ma0
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.ma0 r0 = (sensei0.ma0) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.ma0 r0 = new sensei0.ma0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.h
            int r1 = r0.p
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            boolean r6 = r0.f
            sensei0.ky r0 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L2a
            goto L53
        L2a:
            r7 = move-exception
            goto L5d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            sensei0.wf0.H(r7)
            sensei0.ky r7 = r5.a
            boolean r1 = r7.d()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L59
            r0.d = r7     // Catch: java.lang.Throwable -> L59
            r0.f = r1     // Catch: java.lang.Throwable -> L59
            r0.p = r2     // Catch: java.lang.Throwable -> L59
            java.lang.Object r6 = r6.c(r4, r0)     // Catch: java.lang.Throwable -> L59
            sensei0.vc r0 = sensei0.vc.a
            if (r6 != r0) goto L50
            return r0
        L50:
            r0 = r7
            r7 = r6
            r6 = r1
        L53:
            if (r6 == 0) goto L58
            r0.e(r3)
        L58:
            return r7
        L59:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r1
        L5d:
            if (r6 == 0) goto L62
            r0.e(r3)
        L62:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.oa0.c(sensei0.jp, sensei0.yb):java.lang.Object");
    }
}
