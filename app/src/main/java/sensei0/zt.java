package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zt extends ViewGroup {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int f;
    public int h;
    public float o;
    public boolean p;
    public int[] q;
    public int[] r;
    public Drawable s;
    public int t;
    public int u;
    public int v;
    public int w;

    public zt(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.f = 8388659;
        int[] iArr = p30.k;
        o4 o4VarQ = o4.Q(context, attributeSet, iArr, 0);
        ai0.j(this, context, iArr, attributeSet, (TypedArray) o4VarQ.b, 0);
        TypedArray typedArray = (TypedArray) o4VarQ.b;
        int i2 = typedArray.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = typedArray.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.o = typedArray.getFloat(4, -1.0f);
        this.b = typedArray.getInt(3, -1);
        this.p = typedArray.getBoolean(7, false);
        setDividerDrawable(o4VarQ.F(5));
        this.v = typedArray.getInt(8, 0);
        this.w = typedArray.getDimensionPixelSize(6, 0);
        o4VarQ.V();
    }

    public final void c(Canvas canvas, int i) {
        this.s.setBounds(getPaddingLeft() + this.w, i, (getWidth() - getPaddingRight()) - this.w, this.u + i);
        this.s.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof yt;
    }

    public final void d(Canvas canvas, int i) {
        this.s.setBounds(i, getPaddingTop() + this.w, this.t + i, (getHeight() - getPaddingBottom()) - this.w);
        this.s.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public yt generateDefaultLayoutParams() {
        int i = this.d;
        if (i == 0) {
            return new yt(-2, -2);
        }
        if (i == 1) {
            return new yt(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public yt generateLayoutParams(AttributeSet attributeSet) {
        return new yt(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public yt generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof yt ? new yt((yt) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new yt((ViewGroup.MarginLayoutParams) layoutParams) : new yt(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.b;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.c;
        if (this.d == 1 && (i = this.f & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.h) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.h;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((yt) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.s;
    }

    public int getDividerPadding() {
        return this.w;
    }

    public int getDividerWidth() {
        return this.t;
    }

    public int getGravity() {
        return this.f;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.v;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.o;
    }

    public final boolean h(int i) {
        if (i == 0) {
            return (this.v & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.v & 4) != 0;
        }
        if ((this.v & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.s == null) {
            return;
        }
        int i2 = 0;
        if (this.d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && h(i2)) {
                    c(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((yt) childAt.getLayoutParams())).topMargin) - this.u);
                }
                i2++;
            }
            if (h(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                c(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.u : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((yt) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = si0.a;
        boolean z2 = getLayoutDirection() == 1;
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && h(i2)) {
                yt ytVar = (yt) childAt3.getLayoutParams();
                d(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) ytVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) ytVar).leftMargin) - this.t);
            }
            i2++;
        }
        if (h(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                yt ytVar2 = (yt) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) ytVar2).leftMargin;
                    i = this.t;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) ytVar2).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.t;
                right = left - i;
            }
            d(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.zt.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 2150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.zt.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.s) {
            return;
        }
        this.s = drawable;
        if (drawable != null) {
            this.t = drawable.getIntrinsicWidth();
            this.u = drawable.getIntrinsicHeight();
        } else {
            this.t = 0;
            this.u = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.w = i;
    }

    public void setGravity(int i) {
        if (this.f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f;
        if ((8388615 & i3) != i2) {
            this.f = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.p = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.v) {
            requestLayout();
        }
        this.v = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f;
        if ((i3 & 112) != i2) {
            this.f = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.o = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
