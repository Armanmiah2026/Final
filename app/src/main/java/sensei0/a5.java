package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class a5 {
    public z4 d;
    public ab0 a = null;
    public float b = 0.0f;
    public ArrayList c = new ArrayList();
    public boolean e = false;

    public a5(j1 j1Var) {
        this.d = new s4(this, j1Var);
    }

    public final void a(eu euVar, int i) {
        this.d.g(euVar.i(i), 1.0f);
        this.d.g(euVar.i(i), -1.0f);
    }

    public final void b(ab0 ab0Var, ab0 ab0Var2, ab0 ab0Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.g(ab0Var, 1.0f);
            this.d.g(ab0Var2, -1.0f);
            this.d.g(ab0Var3, -1.0f);
        } else {
            this.d.g(ab0Var, -1.0f);
            this.d.g(ab0Var2, 1.0f);
            this.d.g(ab0Var3, 1.0f);
        }
    }

    public final void c(ab0 ab0Var, ab0 ab0Var2, ab0 ab0Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.g(ab0Var, 1.0f);
            this.d.g(ab0Var2, -1.0f);
            this.d.g(ab0Var3, 1.0f);
        } else {
            this.d.g(ab0Var, -1.0f);
            this.d.g(ab0Var2, 1.0f);
            this.d.g(ab0Var3, -1.0f);
        }
    }

    public ab0 d(boolean[] zArr) {
        return e(zArr, null);
    }

    public final ab0 e(boolean[] zArr, ab0 ab0Var) {
        int i;
        int iE = this.d.e();
        ab0 ab0Var2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < iE; i2++) {
            float fA = this.d.a(i2);
            if (fA < 0.0f) {
                ab0 ab0VarI = this.d.i(i2);
                if ((zArr == null || !zArr[ab0VarI.b]) && ab0VarI != ab0Var && (((i = ab0VarI.l) == 3 || i == 4) && fA < f)) {
                    f = fA;
                    ab0Var2 = ab0VarI;
                }
            }
        }
        return ab0Var2;
    }

    public final void f(ab0 ab0Var) {
        ab0 ab0Var2 = this.a;
        if (ab0Var2 != null) {
            this.d.g(ab0Var2, -1.0f);
            this.a = null;
        }
        float fC = this.d.c(ab0Var, true) * (-1.0f);
        this.a = ab0Var;
        if (fC == 1.0f) {
            return;
        }
        this.b /= fC;
        this.d.j(fC);
    }

    public final void g(ab0 ab0Var, boolean z) {
        if (ab0Var.f) {
            float fD = this.d.d(ab0Var);
            this.b = (ab0Var.e * fD) + this.b;
            this.d.c(ab0Var, z);
            if (z) {
                ab0Var.b(this);
            }
        }
    }

    public void h(a5 a5Var, boolean z) {
        float f = this.d.f(a5Var, z);
        this.b = (a5Var.b * f) + this.b;
        if (z) {
            a5Var.a.b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            sensei0.ab0 r0 = r10.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            sensei0.ab0 r1 = r10.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = sensei0.za0.k(r0, r1)
            float r1 = r10.b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L3a
        L39:
            r1 = r3
        L3a:
            sensei0.z4 r5 = r10.d
            int r5 = r5.e()
        L40:
            if (r3 >= r5) goto La0
            sensei0.z4 r6 = r10.d
            sensei0.ab0 r6 = r6.i(r3)
            if (r6 != 0) goto L4b
            goto L9d
        L4b:
            sensei0.z4 r7 = r10.d
            float r7 = r7.a(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L9d
        L56:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L6a
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7a
            java.lang.String r1 = "- "
            java.lang.String r0 = sensei0.za0.k(r0, r1)
        L68:
            float r7 = r7 * r9
            goto L7a
        L6a:
            if (r8 <= 0) goto L73
            java.lang.String r1 = " + "
            java.lang.String r0 = sensei0.za0.k(r0, r1)
            goto L7a
        L73:
            java.lang.String r1 = " - "
            java.lang.String r0 = sensei0.za0.k(r0, r1)
            goto L68
        L7a:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L85
            java.lang.String r0 = sensei0.za0.k(r0, r6)
            goto L9c
        L85:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9c:
            r1 = r4
        L9d:
            int r3 = r3 + 1
            goto L40
        La0:
            if (r1 != 0) goto La8
            java.lang.String r1 = "0.0"
            java.lang.String r0 = sensei0.za0.k(r0, r1)
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.a5.toString():java.lang.String");
    }
}
