package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d80 {
    public mm0 a = new y50();
    public mm0 b = new y50();
    public mm0 c = new y50();
    public mm0 d = new y50();
    public ic e = new e(0.0f);
    public ic f = new e(0.0f);
    public ic g = new e(0.0f);
    public ic h = new e(0.0f);
    public mh i;
    public mh j;
    public mh k;
    public mh l;

    public d80() {
        int i = 0;
        this.i = new mh(i);
        this.j = new mh(i);
        this.k = new mh(i);
        this.l = new mh(i);
    }

    public static c80 a(Context context, AttributeSet attributeSet, int i, int i2) {
        e eVar = new e(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o30.k, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, resourceId);
        if (resourceId2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, resourceId2);
        }
        TypedArray typedArrayObtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(o30.p);
        try {
            int i3 = typedArrayObtainStyledAttributes2.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes2.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes2.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes2.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes2.getInt(1, i3);
            ic icVarB = b(typedArrayObtainStyledAttributes2, 5, eVar);
            ic icVarB2 = b(typedArrayObtainStyledAttributes2, 8, icVarB);
            ic icVarB3 = b(typedArrayObtainStyledAttributes2, 9, icVarB);
            ic icVarB4 = b(typedArrayObtainStyledAttributes2, 7, icVarB);
            ic icVarB5 = b(typedArrayObtainStyledAttributes2, 6, icVarB);
            c80 c80Var = new c80();
            c80Var.a = xe.g(i4);
            c80Var.e = icVarB2;
            c80Var.b = xe.g(i5);
            c80Var.f = icVarB3;
            c80Var.c = xe.g(i6);
            c80Var.g = icVarB4;
            c80Var.d = xe.g(i7);
            c80Var.h = icVarB5;
            return c80Var;
        } finally {
            typedArrayObtainStyledAttributes2.recycle();
        }
    }

    public static ic b(TypedArray typedArray, int i, ic icVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new e(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new d50(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return icVar;
    }

    public final boolean c(RectF rectF) {
        boolean z = this.l.getClass().equals(mh.class) && this.j.getClass().equals(mh.class) && this.i.getClass().equals(mh.class) && this.k.getClass().equals(mh.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof y50) && (this.a instanceof y50) && (this.c instanceof y50) && (this.d instanceof y50));
    }

    public final c80 d() {
        c80 c80Var = new c80();
        c80Var.a = this.a;
        c80Var.b = this.b;
        c80Var.c = this.c;
        c80Var.d = this.d;
        c80Var.e = this.e;
        c80Var.f = this.f;
        c80Var.g = this.g;
        c80Var.h = this.h;
        c80Var.i = this.i;
        c80Var.j = this.j;
        c80Var.k = this.k;
        c80Var.l = this.l;
        return c80Var;
    }
}
