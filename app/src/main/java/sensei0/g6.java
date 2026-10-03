package sensei0;

import android.view.KeyEvent;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g6 {
    public boolean a;
    public final Object b;

    public g6(mh mhVar, boolean z) {
        this.b = mhVar;
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.CharSequence r7, int r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L48
            if (r8 < 0) goto L48
            int r0 = r7.length()
            int r0 = r0 - r8
            if (r0 < 0) goto L48
            java.lang.Object r0 = r6.b
            sensei0.mh r0 = (sensei0.mh) r0
            if (r0 != 0) goto L16
            boolean r7 = r6.a()
            return r7
        L16:
            r0.getClass()
            r0 = 0
            r1 = 2
            r2 = r0
            r3 = r1
        L1d:
            r4 = 1
            if (r2 >= r8) goto L3d
            if (r3 != r1) goto L3d
            char r3 = r7.charAt(r2)
            byte r3 = java.lang.Character.getDirectionality(r3)
            sensei0.g6 r5 = sensei0.md0.a
            if (r3 == 0) goto L39
            if (r3 == r4) goto L37
            if (r3 == r1) goto L37
            switch(r3) {
                case 14: goto L39;
                case 15: goto L39;
                case 16: goto L37;
                case 17: goto L37;
                default: goto L35;
            }
        L35:
            r3 = r1
            goto L3a
        L37:
            r3 = r0
            goto L3a
        L39:
            r3 = r4
        L3a:
            int r2 = r2 + 1
            goto L1d
        L3d:
            if (r3 == 0) goto L47
            if (r3 == r4) goto L46
            boolean r7 = r6.a()
            return r7
        L46:
            return r0
        L47:
            return r4
        L48:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.g6.b(java.lang.CharSequence, int):boolean");
    }

    public void c(boolean z) {
        if (this.a) {
            throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
        }
        this.a = true;
        i5 i5Var = (i5) this.b;
        int i = i5Var.b - 1;
        i5Var.b = i;
        boolean z2 = z | i5Var.c;
        i5Var.c = z2;
        if (i != 0 || z2) {
            return;
        }
        ((o4) i5Var.e).R((KeyEvent) i5Var.d);
    }

    public g6(i5 i5Var) {
        this.b = i5Var;
        this.a = false;
    }

    public g6(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.b = bottomSheetBehavior;
        this.a = z;
    }
}
