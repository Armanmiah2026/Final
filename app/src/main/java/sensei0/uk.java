package sensei0;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class uk implements e9 {
    public final File a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public uk(File file) {
        this.a = file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [sensei0.uk] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, sensei0.uk] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [sensei0.uk] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(sensei0.uk r9, sensei0.yb r10) {
        /*
            sensei0.mh r0 = sensei0.mh.r
            boolean r1 = r10 instanceof sensei0.tk
            if (r1 == 0) goto L15
            r1 = r10
            sensei0.tk r1 = (sensei0.tk) r1
            int r2 = r1.p
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.p = r2
            goto L1a
        L15:
            sensei0.tk r1 = new sensei0.tk
            r1.<init>(r9, r10)
        L1a:
            java.lang.Object r10 = r1.h
            int r2 = r1.p
            r3 = 2
            r4 = 1
            r5 = 0
            sensei0.vc r6 = sensei0.vc.a
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r9 = r1.d
            java.io.Closeable r9 = (java.io.Closeable) r9
            sensei0.wf0.H(r10)     // Catch: java.lang.Throwable -> L32
            goto L9c
        L32:
            r10 = move-exception
            goto La4
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            java.io.FileInputStream r9 = r1.f
            java.lang.Object r2 = r1.d
            sensei0.uk r2 = (sensei0.uk) r2
            sensei0.wf0.H(r10)     // Catch: java.lang.Throwable -> L47
            goto L6c
        L47:
            r10 = move-exception
            goto L77
        L49:
            sensei0.wf0.H(r10)
            java.util.concurrent.atomic.AtomicBoolean r10 = r9.b
            boolean r10 = r10.get()
            if (r10 != 0) goto Lb0
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7d
            java.io.File r2 = r9.a     // Catch: java.io.FileNotFoundException -> L7d
            r10.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7d
            r1.d = r9     // Catch: java.lang.Throwable -> L72
            r1.f = r10     // Catch: java.lang.Throwable -> L72
            r1.p = r4     // Catch: java.lang.Throwable -> L72
            sensei0.gy r2 = r0.x(r10)     // Catch: java.lang.Throwable -> L72
            if (r2 != r6) goto L68
            goto L98
        L68:
            r8 = r2
            r2 = r9
            r9 = r10
            r10 = r8
        L6c:
            sensei0.mm0.l(r9, r5)     // Catch: java.io.FileNotFoundException -> L70
            return r10
        L70:
            r9 = r2
            goto L7d
        L72:
            r2 = move-exception
            r8 = r2
            r2 = r9
            r9 = r10
            r10 = r8
        L77:
            throw r10     // Catch: java.lang.Throwable -> L78
        L78:
            r7 = move-exception
            sensei0.mm0.l(r9, r10)     // Catch: java.io.FileNotFoundException -> L70
            throw r7     // Catch: java.io.FileNotFoundException -> L70
        L7d:
            java.io.File r10 = r9.a
            boolean r10 = r10.exists()
            if (r10 == 0) goto Laa
            java.io.FileInputStream r10 = new java.io.FileInputStream
            java.io.File r9 = r9.a
            r10.<init>(r9)
            r1.d = r10     // Catch: java.lang.Throwable -> La0
            r1.f = r5     // Catch: java.lang.Throwable -> La0
            r1.p = r3     // Catch: java.lang.Throwable -> La0
            sensei0.gy r9 = r0.x(r10)     // Catch: java.lang.Throwable -> La0
            if (r9 != r6) goto L99
        L98:
            return r6
        L99:
            r8 = r10
            r10 = r9
            r9 = r8
        L9c:
            sensei0.mm0.l(r9, r5)
            return r10
        La0:
            r9 = move-exception
            r8 = r10
            r10 = r9
            r9 = r8
        La4:
            throw r10     // Catch: java.lang.Throwable -> La5
        La5:
            r0 = move-exception
            sensei0.mm0.l(r9, r10)
            throw r0
        Laa:
            sensei0.gy r9 = new sensei0.gy
            r9.<init>(r4)
            return r9
        Lb0:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "This scope has already been closed."
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.uk.a(sensei0.uk, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.e9
    public final void close() {
        this.b.set(true);
    }
}
