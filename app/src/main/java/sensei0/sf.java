package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sf implements Iterator, os {
    public int a = -1;
    public int b;
    public int c;
    public kr d;
    public int f;
    public final /* synthetic */ tf h;

    public sf(tf tfVar) {
        this.h = tfVar;
        int iM = mm0.m(0, 0, tfVar.a.length());
        this.b = iM;
        this.c = iM;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r8 = this;
            sensei0.tf r0 = r8.h
            java.lang.CharSequence r1 = r0.a
            int r2 = r8.c
            r3 = 0
            if (r2 >= 0) goto Lf
            r8.a = r3
            r0 = 0
            r8.d = r0
            return
        Lf:
            int r4 = r0.b
            r5 = -1
            r6 = 1
            if (r4 <= 0) goto L1c
            int r7 = r8.f
            int r7 = r7 + r6
            r8.f = r7
            if (r7 >= r4) goto L22
        L1c:
            int r4 = r1.length()
            if (r2 <= r4) goto L32
        L22:
            sensei0.kr r0 = new sensei0.kr
            int r2 = r8.b
            int r1 = sensei0.fc0.g0(r1)
            r0.<init>(r2, r1, r6)
            r8.d = r0
            r8.c = r5
            goto L7e
        L32:
            sensei0.jp r0 = r0.c
            int r2 = r8.c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.c(r1, r2)
            sensei0.qz r0 = (sensei0.qz) r0
            if (r0 != 0) goto L52
            sensei0.kr r0 = new sensei0.kr
            int r2 = r8.b
            int r1 = sensei0.fc0.g0(r1)
            r0.<init>(r2, r1, r6)
            r8.d = r0
            r8.c = r5
            goto L7e
        L52:
            java.lang.Object r1 = r0.a
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.b
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r2 = r8.b
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 > r4) goto L6b
            sensei0.kr r2 = sensei0.kr.d
            goto L73
        L6b:
            sensei0.kr r4 = new sensei0.kr
            int r5 = r1 + (-1)
            r4.<init>(r2, r5, r6)
            r2 = r4
        L73:
            r8.d = r2
            int r1 = r1 + r0
            r8.b = r1
            if (r0 != 0) goto L7b
            r3 = r6
        L7b:
            int r1 = r1 + r3
            r8.c = r1
        L7e:
            r8.a = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.sf.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a == -1) {
            a();
        }
        return this.a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.a == -1) {
            a();
        }
        if (this.a == 0) {
            throw new NoSuchElementException();
        }
        kr krVar = this.d;
        pr.g("null cannot be cast to non-null type kotlin.ranges.IntRange", krVar);
        this.d = null;
        this.a = -1;
        return krVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
