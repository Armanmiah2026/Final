package sensei0;

import android.animation.ObjectAnimator;
import android.view.View;
import com.sensei.tunnel.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bk extends mf0 {
    public static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    public final int K;

    public bk(int i) {
        this();
        this.K = i;
    }

    public static void L(uf0 uf0Var) {
        View view = uf0Var.b;
        int visibility = view.getVisibility();
        HashMap map = uf0Var.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float N(uf0 uf0Var, float f) {
        Float f2;
        return (uf0Var == null || (f2 = (Float) uf0Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sensei0.hj0 O(sensei0.uf0 r8, sensei0.uf0 r9) {
        /*
            sensei0.hj0 r0 = new sensei0.hj0
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.c = r3
            r0.e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.b = r1
            r0.a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            r0.b = r1
            r0.a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.d
            if (r8 != 0) goto L95
            r0.b = r2
            r0.a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.c
            if (r8 != 0) goto L9f
            r0.b = r1
            r0.a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.bk.O(sensei0.uf0, sensei0.uf0):sensei0.hj0");
    }

    public final ObjectAnimator M(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        pi0.a.d(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, pi0.b, f2);
        ak akVar = new ak(view);
        objectAnimatorOfFloat.addListener(akVar);
        o().a(akVar);
        return objectAnimatorOfFloat;
    }

    @Override // sensei0.mf0
    public final void d(uf0 uf0Var) {
        L(uf0Var);
    }

    @Override // sensei0.mf0
    public final void g(uf0 uf0Var) {
        L(uf0Var);
        View view = uf0Var.b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(pi0.a.a(view)) : Float.valueOf(0.0f);
        }
        uf0Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (O(n(r3, false), r(r3, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0214  */
    @Override // sensei0.mf0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator k(android.view.ViewGroup r24, sensei0.uf0 r25, sensei0.uf0 r26) {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.bk.k(android.view.ViewGroup, sensei0.uf0, sensei0.uf0):android.animation.Animator");
    }

    @Override // sensei0.mf0
    public final String[] q() {
        return L;
    }

    @Override // sensei0.mf0
    public final boolean t(uf0 uf0Var, uf0 uf0Var2) {
        if (uf0Var == null && uf0Var2 == null) {
            return false;
        }
        if (uf0Var != null && uf0Var2 != null && uf0Var2.a.containsKey("android:visibility:visibility") != uf0Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        hj0 hj0VarO = O(uf0Var, uf0Var2);
        if (hj0VarO.a) {
            return hj0VarO.c == 0 || hj0VarO.d == 0;
        }
        return false;
    }

    public bk() {
        this.K = 3;
    }
}
