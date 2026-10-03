package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class va extends View {
    public int[] a;
    public int b;
    public Context c;
    public nq d;
    public String f;
    public HashMap h;

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.c
            if (r6 == 0) goto La6
            int r1 = r6.length()
            if (r1 != 0) goto Lc
            goto La6
        Lc:
            if (r0 != 0) goto L10
            goto La6
        L10:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r1 == 0) goto L22
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
        L22:
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L32
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L33
        L32:
            r1 = r2
        L33:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L5a
            if (r1 == 0) goto L5a
            if (r6 == 0) goto L4e
            java.util.HashMap r3 = r1.u
            if (r3 == 0) goto L4e
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L4e
            java.util.HashMap r3 = r1.u
            java.lang.Object r3 = r3.get(r6)
            goto L4f
        L4e:
            r3 = r2
        L4f:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L5a
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L5b
        L5a:
            r3 = 0
        L5b:
            if (r3 != 0) goto L63
            if (r1 == 0) goto L63
            int r3 = r5.d(r1, r6)
        L63:
            if (r3 != 0) goto L6f
            java.lang.Class<sensei0.h30> r1 = sensei0.h30.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L6f
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L6f
        L6f:
            if (r3 != 0) goto L7f
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L7f:
            if (r3 == 0) goto L8e
            java.util.HashMap r0 = r5.h
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r6)
            r5.b(r3)
            goto La6
        L8e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not find id of \""
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = "\""
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "ConstraintHelper"
            android.util.Log.w(r0, r6)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.va.a(java.lang.String):void");
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.b + 1;
        int[] iArr = this.a;
        if (i2 > iArr.length) {
            this.a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.a;
        int i3 = this.b;
        iArr2[i3] = i;
        this.b = i3 + 1;
    }

    public final void c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.b; i++) {
            View view = (View) constraintLayout.a.get(this.a[i]);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.c.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i30.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 19) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(hb hbVar, boolean z);

    public final void g() {
        if (this.d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof xa) {
            ((xa) layoutParams).k0 = this.d;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f = null;
        this.b = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}
