package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g40 {
    public o4 a;
    public RecyclerView b;
    public final i3 c;
    public final i3 d;
    public boolean e;
    public int f;
    public int g;

    public g40() {
        f40 f40Var = new f40(this, 0);
        f40 f40Var2 = new f40(this, 1);
        this.c = new i3(f40Var);
        this.d = new i3(f40Var2);
        this.e = false;
    }

    public static int e(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    public static int x(View view) {
        ((h40) view.getLayoutParams()).getClass();
        throw null;
    }

    public static au y(Context context, AttributeSet attributeSet, int i, int i2) {
        au auVar = new au(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n30.a, i, i2);
        auVar.b = typedArrayObtainStyledAttributes.getInt(0, 1);
        auVar.c = typedArrayObtainStyledAttributes.getInt(10, 1);
        auVar.d = typedArrayObtainStyledAttributes.getBoolean(9, false);
        auVar.e = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return auVar;
    }

    public abstract boolean A();

    public abstract void C(RecyclerView recyclerView);

    public void D(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.b;
        m40 m40Var = recyclerView.a;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        this.b.getClass();
    }

    public final void E(View view, d1 d1Var) {
        RecyclerView.r(view);
    }

    public void F(m40 m40Var, p40 p40Var, View view, d1 d1Var) {
        d1Var.i(c1.a(false, c() ? x(view) : 0, 1, b() ? x(view) : 0, 1));
    }

    public Parcelable H() {
        return null;
    }

    public final void J(m40 m40Var) {
        for (int iP = p() - 1; iP >= 0; iP--) {
            if (!RecyclerView.r(o(iP)).n()) {
                View viewO = o(iP);
                if (o(iP) != null) {
                    o4 o4Var = this.a;
                    int I = o4Var.I(iP);
                    z30 z30Var = (z30) o4Var.b;
                    View childAt = z30Var.a.getChildAt(I);
                    if (childAt != null) {
                        if (((k8) o4Var.c).e(I)) {
                            o4Var.a0(childAt);
                        }
                        z30Var.a(I);
                    }
                }
                m40Var.e(viewO);
            }
        }
    }

    public final void K(m40 m40Var) {
        ArrayList arrayList = m40Var.a;
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            ((s40) arrayList.get(i)).getClass();
            s40 s40VarR = RecyclerView.r(null);
            if (!s40VarR.n()) {
                s40VarR.m(false);
                if (s40VarR.j()) {
                    this.b.removeDetachedView(null, false);
                }
                d40 d40Var = this.b.L;
                if (d40Var != null) {
                    d40Var.b(s40VarR);
                }
                s40VarR.m(true);
                s40 s40VarR2 = RecyclerView.r(null);
                s40VarR2.c = null;
                s40VarR2.d = false;
                s40VarR2.b &= -33;
                m40Var.f(s40VarR2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = m40Var.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.b.invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean L(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.u()
            int r1 = r8.w()
            int r2 = r8.f
            int r3 = r8.v()
            int r2 = r2 - r3
            int r3 = r8.g
            int r4 = r8.t()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.s()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.u()
            int r2 = r8.w()
            int r3 = r8.f
            int r4 = r8.v()
            int r3 = r3 - r4
            int r4 = r8.g
            int r5 = r8.t()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.b
            android.graphics.Rect r5 = r5.o
            r8.r(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.B(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.g40.L(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void M() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void N(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.b = null;
            this.a = null;
            this.f = 0;
            this.g = 0;
            return;
        }
        this.b = recyclerView;
        this.a = recyclerView.d;
        this.f = recyclerView.getWidth();
        this.g = recyclerView.getHeight();
    }

    public void a(String str) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.c(str);
        }
    }

    public abstract boolean b();

    public abstract boolean c();

    public boolean d(h40 h40Var) {
        return h40Var != null;
    }

    public abstract int f(p40 p40Var);

    public abstract int g(p40 p40Var);

    public abstract int h(p40 p40Var);

    public abstract int i(p40 p40Var);

    public abstract int j(p40 p40Var);

    public abstract int k(p40 p40Var);

    public abstract h40 l();

    public h40 m(Context context, AttributeSet attributeSet) {
        return new h40(context, attributeSet);
    }

    public h40 n(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof h40 ? new h40((h40) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new h40((ViewGroup.MarginLayoutParams) layoutParams) : new h40(layoutParams);
    }

    public final View o(int i) {
        o4 o4Var = this.a;
        if (o4Var == null) {
            return null;
        }
        return ((z30) o4Var.b).a.getChildAt(o4Var.I(i));
    }

    public final int p() {
        o4 o4Var = this.a;
        if (o4Var != null) {
            return ((z30) o4Var.b).a.getChildCount() - ((ArrayList) o4Var.d).size();
        }
        return 0;
    }

    public int q(m40 m40Var, p40 p40Var) {
        return 1;
    }

    public void r(View view, Rect rect) {
        int[] iArr = RecyclerView.q0;
        h40 h40Var = (h40) view.getLayoutParams();
        Rect rect2 = h40Var.a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) h40Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) h40Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) h40Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) h40Var).bottomMargin);
    }

    public final int s() {
        RecyclerView recyclerView = this.b;
        Field field = ai0.a;
        return recyclerView.getLayoutDirection();
    }

    public final int t() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int u() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int v() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int w() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int z(m40 m40Var, p40 p40Var) {
        return 1;
    }

    public void B(RecyclerView recyclerView) {
    }

    public void G(Parcelable parcelable) {
    }

    public void I(int i) {
    }
}
