package sensei0;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class h6 extends mm0 {
    public final /* synthetic */ int l;
    public final /* synthetic */ bc m;

    public /* synthetic */ h6(bc bcVar, int i) {
        this.l = i;
        this.m = bcVar;
    }

    @Override // sensei0.mm0
    public int D(View view) {
        switch (this.l) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.m;
                return sideSheetBehavior.l + sideSheetBehavior.o;
            default:
                return super.D(view);
        }
    }

    @Override // sensei0.mm0
    public int E() {
        switch (this.l) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.m;
                return bottomSheetBehavior.I ? bottomSheetBehavior.T : bottomSheetBehavior.G;
            default:
                return super.E();
        }
    }

    @Override // sensei0.mm0
    public final void U(int i) {
        switch (this.l) {
            case 0:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.m;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.C(1);
                    }
                }
                break;
            default:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.m;
                    if (sideSheetBehavior.g) {
                        sideSheetBehavior.r(1);
                    }
                }
                break;
        }
    }

    @Override // sensei0.mm0
    public final void V(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.l) {
            case 0:
                ((BottomSheetBehavior) this.m).u(i2);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.m;
                WeakReference weakReference = sideSheetBehavior.q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.a.n0(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.a.f(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e9  */
    @Override // sensei0.mm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.h6.W(android.view.View, float, float):void");
    }

    @Override // sensei0.mm0
    public final int j(View view, int i) {
        switch (this.l) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.m;
                return pr.l(i, sideSheetBehavior.a.z(), sideSheetBehavior.a.y());
        }
    }

    @Override // sensei0.mm0
    public final int k(View view, int i) {
        switch (this.l) {
            case 0:
                return pr.l(i, ((BottomSheetBehavior) this.m).x(), E());
            default:
                return view.getTop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    @Override // sensei0.mm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m0(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.l
            switch(r0) {
                case 0: goto L1c;
                default: goto L5;
            }
        L5:
            sensei0.bc r6 = r4.m
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.h
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L10
            goto L1b
        L10:
            java.lang.ref.WeakReference r6 = r6.p
            if (r6 == 0) goto L1b
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L1b
            r1 = r2
        L1b:
            return r1
        L1c:
            sensei0.bc r0 = r4.m
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.L
            r2 = 1
            if (r1 != r2) goto L26
            goto L56
        L26:
            boolean r3 = r0.a0
            if (r3 == 0) goto L2b
            goto L56
        L2b:
            r3 = 3
            if (r1 != r3) goto L48
            int r1 = r0.Y
            if (r1 != r6) goto L48
            java.lang.ref.WeakReference r6 = r0.V
            if (r6 == 0) goto L3d
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L3e
        L3d:
            r6 = 0
        L3e:
            if (r6 == 0) goto L48
            r1 = -1
            boolean r6 = r6.canScrollVertically(r1)
            if (r6 == 0) goto L48
            goto L56
        L48:
            java.lang.System.currentTimeMillis()
            java.lang.ref.WeakReference r6 = r0.U
            if (r6 == 0) goto L56
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L56
            goto L57
        L56:
            r2 = 0
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.h6.m0(android.view.View, int):boolean");
    }
}
