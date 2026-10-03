package sensei0;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ta {
    public final hb b;
    public final int c;
    public ta d;
    public ab0 g;
    public HashSet a = null;
    public int e = 0;
    public int f = -1;

    public ta(hb hbVar, int i) {
        this.b = hbVar;
        this.c = i;
    }

    public final void a(ta taVar, int i) {
        b(taVar, i, -1, false);
    }

    public final boolean b(ta taVar, int i, int i2, boolean z) {
        if (taVar == null) {
            h();
            return true;
        }
        if (!z && !g(taVar)) {
            return false;
        }
        this.d = taVar;
        if (taVar.a == null) {
            taVar.a = new HashSet();
        }
        this.d.a.add(this);
        if (i > 0) {
            this.e = i;
        } else {
            this.e = 0;
        }
        this.f = i2;
        return true;
    }

    public final int c() {
        ta taVar;
        if (this.b.V == 8) {
            return 0;
        }
        int i = this.f;
        return (i <= -1 || (taVar = this.d) == null || taVar.b.V != 8) ? this.e : i;
    }

    public final ta d() {
        int i = this.c;
        int iU = za0.u(i);
        hb hbVar = this.b;
        switch (iU) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return hbVar.z;
            case 2:
                return hbVar.A;
            case 3:
                return hbVar.x;
            case 4:
                return hbVar.y;
            default:
                throw new AssertionError(za0.t(i));
        }
    }

    public final boolean e() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ta) it.next()).d().f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.d != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(sensei0.ta r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L5
            goto L60
        L5:
            sensei0.hb r1 = r9.b
            int r9 = r9.c
            r2 = 6
            int r3 = r8.c
            r4 = 1
            if (r9 != r3) goto L1c
            if (r3 != r2) goto L5e
            boolean r9 = r1.w
            if (r9 == 0) goto L60
            sensei0.hb r9 = r8.b
            boolean r9 = r9.w
            if (r9 != 0) goto L5e
            goto L60
        L1c:
            int r5 = sensei0.za0.u(r3)
            r6 = 8
            r7 = 9
            switch(r5) {
                case 0: goto L60;
                case 1: goto L4c;
                case 2: goto L38;
                case 3: goto L4c;
                case 4: goto L38;
                case 5: goto L60;
                case 6: goto L31;
                case 7: goto L60;
                case 8: goto L60;
                default: goto L27;
            }
        L27:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r0 = sensei0.za0.t(r3)
            r9.<init>(r0)
            throw r9
        L31:
            if (r9 == r2) goto L60
            if (r9 == r6) goto L60
            if (r9 == r7) goto L60
            goto L5e
        L38:
            r2 = 3
            if (r9 == r2) goto L41
            r2 = 5
            if (r9 != r2) goto L3f
            goto L41
        L3f:
            r2 = r0
            goto L42
        L41:
            r2 = r4
        L42:
            boolean r1 = r1 instanceof sensei0.hq
            if (r1 == 0) goto L4b
            if (r2 != 0) goto L5e
            if (r9 != r7) goto L60
            goto L5e
        L4b:
            return r2
        L4c:
            r2 = 2
            if (r9 == r2) goto L55
            r2 = 4
            if (r9 != r2) goto L53
            goto L55
        L53:
            r2 = r0
            goto L56
        L55:
            r2 = r4
        L56:
            boolean r1 = r1 instanceof sensei0.hq
            if (r1 == 0) goto L5f
            if (r2 != 0) goto L5e
            if (r9 != r6) goto L60
        L5e:
            return r4
        L5f:
            return r2
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ta.g(sensei0.ta):boolean");
    }

    public final void h() {
        HashSet hashSet;
        ta taVar = this.d;
        if (taVar != null && (hashSet = taVar.a) != null) {
            hashSet.remove(this);
        }
        this.d = null;
        this.e = 0;
        this.f = -1;
    }

    public final void i() {
        ab0 ab0Var = this.g;
        if (ab0Var == null) {
            this.g = new ab0(1);
        } else {
            ab0Var.c();
        }
    }

    public final String toString() {
        return this.b.W + ":" + za0.t(this.c);
    }
}
