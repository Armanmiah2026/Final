package sensei0;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cd0 extends mm0 {
    public int l;
    public int m = -1;
    public final /* synthetic */ SwipeDismissBehavior n;

    public cd0(SwipeDismissBehavior swipeDismissBehavior) {
        this.n = swipeDismissBehavior;
    }

    @Override // sensei0.mm0
    public final int D(View view) {
        return view.getWidth();
    }

    @Override // sensei0.mm0
    public final void T(View view, int i) {
        this.m = i;
        this.l = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.n;
            swipeDismissBehavior.c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.c = false;
        }
    }

    @Override // sensei0.mm0
    public final void V(View view, int i, int i2) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.n;
        float f = width * swipeDismissBehavior.e;
        float width2 = view.getWidth() * swipeDismissBehavior.f;
        float fAbs = Math.abs(i - this.l);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    @Override // sensei0.mm0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.m = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.n
            r4 = 1
            if (r1 == 0) goto L39
            java.lang.reflect.Field r5 = sensei0.ai0.a
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L1a
            r5 = r4
            goto L1b
        L1a:
            r5 = r2
        L1b:
            int r6 = r3.d
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L2a:
            if (r1 <= 0) goto L67
            goto L52
        L2d:
            if (r6 != r4) goto L67
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L67
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L67
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.l
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L67
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.l
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L65
        L61:
            int r10 = r8.l
            int r0 = r10 - r11
        L65:
            r2 = r4
            goto L69
        L67:
            int r0 = r8.l
        L69:
            sensei0.ci0 r10 = r3.a
            int r11 = r9.getTop()
            boolean r10 = r10.o(r0, r11)
            if (r10 == 0) goto L7f
            sensei0.e2 r10 = new sensei0.e2
            r10.<init>(r3, r9, r2)
            java.lang.reflect.Field r11 = sensei0.ai0.a
            r9.postOnAnimation(r10)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.cd0.W(android.view.View, float, float):void");
    }

    @Override // sensei0.mm0
    public final int j(View view, int i) {
        int width;
        int width2;
        int width3;
        Field field = ai0.a;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.n.d;
        if (i2 == 0) {
            if (z) {
                width = this.l - view.getWidth();
                width2 = this.l;
            } else {
                width = this.l;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i2 != 1) {
            width = this.l - view.getWidth();
            width2 = view.getWidth() + this.l;
        } else if (z) {
            width = this.l;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.l - view.getWidth();
            width2 = this.l;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // sensei0.mm0
    public final int k(View view, int i) {
        return view.getTop();
    }

    @Override // sensei0.mm0
    public final boolean m0(View view, int i) {
        int i2 = this.m;
        return (i2 == -1 || i2 == i) && this.n.r(view);
    }

    @Override // sensei0.mm0
    public final void U(int i) {
    }
}
