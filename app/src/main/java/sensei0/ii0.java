package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ii0 implements wy, sk0 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ ii0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public o60 a(Class cls, String str) {
        pr.j("key", str);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    @Override // sensei0.wy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public sensei0.rl0 l(android.view.View r18, sensei0.rl0 r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r3 = r0.b
            sensei0.g6 r3 = (sensei0.g6) r3
            java.lang.Object r4 = r0.c
            sensei0.vp r4 = (sensei0.vp) r4
            int r5 = r4.a
            int r6 = r4.b
            int r4 = r4.c
            sensei0.ol0 r7 = r2.a
            r8 = 519(0x207, float:7.27E-43)
            sensei0.hr r8 = r7.f(r8)
            r9 = 32
            sensei0.hr r9 = r7.f(r9)
            java.lang.Object r10 = r3.b
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r10
            int r11 = r8.b
            int r12 = r8.c
            int r13 = r8.a
            r10.w = r11
            boolean r11 = sensei0.qi0.a(r1)
            int r14 = r1.getPaddingBottom()
            int r15 = r1.getPaddingLeft()
            int r16 = r1.getPaddingRight()
            boolean r0 = r10.o
            if (r0 == 0) goto L4c
            sensei0.hr r7 = r7.j()
            int r7 = r7.d
            r10.v = r7
            int r14 = r4 + r7
        L4c:
            boolean r4 = r10.p
            if (r4 == 0) goto L57
            if (r11 == 0) goto L54
            r4 = r6
            goto L55
        L54:
            r4 = r5
        L55:
            int r15 = r4 + r13
        L57:
            boolean r4 = r10.q
            if (r4 == 0) goto L61
            if (r11 == 0) goto L5e
            goto L5f
        L5e:
            r5 = r6
        L5f:
            int r16 = r5 + r12
        L61:
            r4 = r16
            android.view.ViewGroup$LayoutParams r5 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            boolean r6 = r10.s
            r7 = 1
            if (r6 == 0) goto L76
            int r6 = r5.leftMargin
            if (r6 == r13) goto L76
            r5.leftMargin = r13
            r6 = r7
            goto L77
        L76:
            r6 = 0
        L77:
            boolean r11 = r10.t
            if (r11 == 0) goto L82
            int r11 = r5.rightMargin
            if (r11 == r12) goto L82
            r5.rightMargin = r12
            r6 = r7
        L82:
            boolean r11 = r10.u
            if (r11 == 0) goto L8f
            int r11 = r5.topMargin
            int r8 = r8.b
            if (r11 == r8) goto L8f
            r5.topMargin = r8
            goto L90
        L8f:
            r7 = r6
        L90:
            if (r7 == 0) goto L95
            r1.setLayoutParams(r5)
        L95:
            int r5 = r1.getPaddingTop()
            r1.setPadding(r15, r5, r4, r14)
            boolean r1 = r3.a
            if (r1 == 0) goto La4
            int r3 = r9.d
            r10.m = r3
        La4:
            if (r0 != 0) goto Laa
            if (r1 == 0) goto La9
            goto Laa
        La9:
            return r2
        Laa:
            r10.I()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ii0.l(android.view.View, sensei0.rl0):sensei0.rl0");
    }

    public String toString() {
        switch (this.a) {
            case 4:
                return "Bounds{lower=" + ((hr) this.b) + " upper=" + ((hr) this.c) + "}";
            default:
                return super.toString();
        }
    }

    public ii0() {
        this.a = 0;
        this.b = new ka0(0);
        this.c = new cv();
    }

    public ii0(fb0 fb0Var) {
        this.a = 3;
        i3 i3Var = new i3(5);
        this.b = fb0Var;
        this.c = i3Var;
    }

    public ii0(ji0 ji0Var, mz mzVar, bd bdVar) {
        this.a = 1;
        pr.j("store", ji0Var);
        pr.j("defaultCreationExtras", bdVar);
        this.b = mzVar;
        this.c = bdVar;
    }
}
