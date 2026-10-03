package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bl extends uk {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.Object r6, sensei0.yb r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sensei0.al
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.al r0 = (sensei0.al) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.al r0 = new sensei0.al
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.h
            int r1 = r0.p
            sensei0.mg0 r2 = sensei0.mg0.a
            r3 = 1
            if (r1 == 0) goto L35
            if (r1 != r3) goto L2d
            java.io.FileOutputStream r6 = r0.f
            java.io.FileOutputStream r0 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L2b
            goto L5e
        L2b:
            r6 = move-exception
            goto L6c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            sensei0.wf0.H(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.b
            boolean r7 = r7.get()
            if (r7 != 0) goto L72
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r1 = r5.a
            r7.<init>(r1)
            sensei0.mh r1 = sensei0.mh.r     // Catch: java.lang.Throwable -> L6a
            sensei0.hg0 r4 = new sensei0.hg0     // Catch: java.lang.Throwable -> L6a
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L6a
            r0.d = r7     // Catch: java.lang.Throwable -> L6a
            r0.f = r7     // Catch: java.lang.Throwable -> L6a
            r0.p = r3     // Catch: java.lang.Throwable -> L6a
            r1.B(r6, r4)     // Catch: java.lang.Throwable -> L6a
            sensei0.vc r6 = sensei0.vc.a
            if (r2 != r6) goto L5c
            return r6
        L5c:
            r6 = r7
            r0 = r6
        L5e:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L2b
            r6.sync()     // Catch: java.lang.Throwable -> L2b
            r6 = 0
            sensei0.mm0.l(r0, r6)
            return r2
        L6a:
            r6 = move-exception
            r0 = r7
        L6c:
            throw r6     // Catch: java.lang.Throwable -> L6d
        L6d:
            r7 = move-exception
            sensei0.mm0.l(r0, r6)
            throw r7
        L72:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "This scope has already been closed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.bl.b(java.lang.Object, sensei0.yb):java.lang.Object");
    }
}
