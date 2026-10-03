package sensei0;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zk implements e9 {
    public final File a;
    public final oa0 b;
    public final vk c;
    public final AtomicBoolean d;
    public final ky e;

    public zk(File file, oa0 oa0Var, vk vkVar) {
        pr.j("coordinator", oa0Var);
        this.a = file;
        this.b = oa0Var;
        this.c = vkVar;
        this.d = new AtomicBoolean(false);
        this.e = new ky();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0078, blocks: (B:34:0x0077, B:43:0x0087, B:42:0x0084, B:39:0x007f), top: B:55:0x001e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [sensei0.zk] */
    /* JADX WARN: Type inference failed for: r0v14, types: [sensei0.zk] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [sensei0.xk, sensei0.yb] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [sensei0.zk] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [sensei0.fe] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sensei0.fe r6, sensei0.yb r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sensei0.xk
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.xk r0 = (sensei0.xk) r0
            int r1 = r0.q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.q = r1
            goto L18
        L13:
            sensei0.xk r0 = new sensei0.xk
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.o
            int r1 = r0.q
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            boolean r6 = r0.h
            sensei0.uk r1 = r0.f
            sensei0.zk r0 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L2c
            goto L67
        L2c:
            r7 = move-exception
            goto L7f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            sensei0.wf0.H(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.d
            boolean r7 = r7.get()
            if (r7 != 0) goto L95
            sensei0.ky r7 = r5.e
            boolean r7 = r7.d()
            sensei0.uk r1 = new sensei0.uk     // Catch: java.lang.Throwable -> L88
            java.io.File r4 = r5.a     // Catch: java.lang.Throwable -> L88
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L7a
            r0.d = r5     // Catch: java.lang.Throwable -> L7a
            r0.f = r1     // Catch: java.lang.Throwable -> L7a
            r0.h = r7     // Catch: java.lang.Throwable -> L7a
            r0.q = r2     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r6 = r6.i(r1, r4, r0)     // Catch: java.lang.Throwable -> L7a
            sensei0.vc r0 = sensei0.vc.a
            if (r6 != r0) goto L63
            return r0
        L63:
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L67:
            r1.close()     // Catch: java.lang.Throwable -> L6c
            r1 = r3
            goto L6d
        L6c:
            r1 = move-exception
        L6d:
            if (r1 != 0) goto L77
            if (r6 == 0) goto L76
            sensei0.ky r6 = r0.e
            r6.e(r3)
        L76:
            return r7
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78
        L78:
            r7 = move-exception
            goto L8d
        L7a:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L7f:
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r1 = move-exception
            sensei0.wf0.a(r7, r1)     // Catch: java.lang.Throwable -> L78
        L87:
            throw r7     // Catch: java.lang.Throwable -> L78
        L88:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r0
            r0 = r5
        L8d:
            if (r6 == 0) goto L94
            sensei0.ky r6 = r0.e
            r6.e(r3)
        L94:
            throw r7
        L95:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "StorageConnection has already been disposed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.zk.a(sensei0.fe, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[Catch: all -> 0x0114, IOException -> 0x0117, TRY_ENTER, TryCatch #8 {IOException -> 0x0117, all -> 0x0114, blocks: (B:43:0x00d9, B:45:0x00df, B:47:0x00e7, B:51:0x00f3, B:52:0x0113, B:48:0x00ec, B:59:0x0122, B:66:0x012f, B:65:0x012c), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0122 A[Catch: all -> 0x0114, IOException -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x0117, all -> 0x0114, blocks: (B:43:0x00d9, B:45:0x00df, B:47:0x00e7, B:51:0x00f3, B:52:0x0113, B:48:0x00ec, B:59:0x0122, B:66:0x012f, B:65:0x012c), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.File, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sensei0.ue r10, sensei0.yb r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.zk.b(sensei0.ue, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.e9
    public final void close() throws NoSuchMethodException, ClassNotFoundException {
        this.d.set(true);
        this.c.a();
    }
}
