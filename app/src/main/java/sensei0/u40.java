package sensei0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u40 extends p0 {
    public final RecyclerView d;
    public final t40 e;

    public u40(RecyclerView recyclerView) {
        this.d = recyclerView;
        t40 t40Var = this.e;
        if (t40Var != null) {
            this.e = t40Var;
        } else {
            this.e = new t40(this);
        }
    }

    @Override // sensei0.p0
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.d.s()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().D(accessibilityEvent);
        }
    }

    @Override // sensei0.p0
    public final void d(View view, d1 d1Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        RecyclerView recyclerView = this.d;
        if (recyclerView.s() || recyclerView.getLayoutManager() == null) {
            return;
        }
        g40 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.b;
        m40 m40Var = recyclerView2.a;
        p40 p40Var = recyclerView2.f0;
        if (recyclerView2.canScrollVertically(-1) || layoutManager.b.canScrollHorizontally(-1)) {
            d1Var.a(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (layoutManager.b.canScrollVertically(1) || layoutManager.b.canScrollHorizontally(1)) {
            d1Var.a(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(layoutManager.z(m40Var, p40Var), layoutManager.q(m40Var, p40Var), false, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[PHI: r0
      0x0056: PHI (r0v8 int) = (r0v4 int), (r0v12 int) binds: [B:27:0x0073, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // sensei0.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(android.view.View r4, int r5, android.os.Bundle r6) {
        /*
            r3 = this;
            boolean r4 = super.g(r4, r5, r6)
            r6 = 1
            if (r4 == 0) goto L8
            return r6
        L8:
            androidx.recyclerview.widget.RecyclerView r4 = r3.d
            boolean r0 = r4.s()
            r1 = 0
            if (r0 != 0) goto L8c
            sensei0.g40 r0 = r4.getLayoutManager()
            if (r0 == 0) goto L8c
            sensei0.g40 r4 = r4.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r0 = r4.b
            sensei0.m40 r2 = r0.a
            r2 = 4096(0x1000, float:5.74E-42)
            if (r5 == r2) goto L58
            r2 = 8192(0x2000, float:1.148E-41)
            if (r5 == r2) goto L2a
            r5 = r1
            r0 = r5
            goto L81
        L2a:
            r5 = -1
            boolean r0 = r0.canScrollVertically(r5)
            if (r0 == 0) goto L3f
            int r0 = r4.g
            int r2 = r4.w()
            int r0 = r0 - r2
            int r2 = r4.t()
            int r0 = r0 - r2
            int r0 = -r0
            goto L40
        L3f:
            r0 = r1
        L40:
            androidx.recyclerview.widget.RecyclerView r2 = r4.b
            boolean r5 = r2.canScrollHorizontally(r5)
            if (r5 == 0) goto L56
            int r5 = r4.f
            int r2 = r4.u()
            int r5 = r5 - r2
            int r2 = r4.v()
            int r5 = r5 - r2
            int r5 = -r5
            goto L81
        L56:
            r5 = r1
            goto L81
        L58:
            boolean r5 = r0.canScrollVertically(r6)
            if (r5 == 0) goto L6c
            int r5 = r4.g
            int r0 = r4.w()
            int r5 = r5 - r0
            int r0 = r4.t()
            int r5 = r5 - r0
            r0 = r5
            goto L6d
        L6c:
            r0 = r1
        L6d:
            androidx.recyclerview.widget.RecyclerView r5 = r4.b
            boolean r5 = r5.canScrollHorizontally(r6)
            if (r5 == 0) goto L56
            int r5 = r4.f
            int r2 = r4.u()
            int r5 = r5 - r2
            int r2 = r4.v()
            int r5 = r5 - r2
        L81:
            if (r0 != 0) goto L86
            if (r5 != 0) goto L86
            goto L8c
        L86:
            androidx.recyclerview.widget.RecyclerView r4 = r4.b
            r4.B(r5, r0, r6)
            return r6
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.u40.g(android.view.View, int, android.os.Bundle):boolean");
    }
}
