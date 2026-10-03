package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 {
    public final View a;
    public final p3 b;
    public int c = -1;
    public r60 d;
    public r60 e;
    public r60 f;

    public k3(View view) {
        p3 p3Var;
        this.a = view;
        PorterDuff.Mode mode = p3.b;
        synchronized (p3.class) {
            try {
                if (p3.c == null) {
                    p3.c();
                }
                p3Var = p3.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b = p3Var;
    }

    public final void a() {
        View view = this.a;
        Drawable background = view.getBackground();
        if (background != null) {
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new r60();
                }
                r60 r60Var = this.f;
                r60Var.c = null;
                r60Var.b = false;
                r60Var.d = null;
                r60Var.a = false;
                Field field = ai0.a;
                ColorStateList colorStateListC = th0.c(view);
                if (colorStateListC != null) {
                    r60Var.b = true;
                    r60Var.c = colorStateListC;
                }
                PorterDuff.Mode modeD = th0.d(view);
                if (modeD != null) {
                    r60Var.a = true;
                    r60Var.d = modeD;
                }
                if (r60Var.b || r60Var.a) {
                    p3.d(background, r60Var, view.getDrawableState());
                    return;
                }
            }
            r60 r60Var2 = this.e;
            if (r60Var2 != null) {
                p3.d(background, r60Var2, view.getDrawableState());
                return;
            }
            r60 r60Var3 = this.d;
            if (r60Var3 != null) {
                p3.d(background, r60Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        r60 r60Var = this.e;
        if (r60Var != null) {
            return (ColorStateList) r60Var.c;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        r60 r60Var = this.e;
        if (r60Var != null) {
            return (PorterDuff.Mode) r60Var.d;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListF;
        View view = this.a;
        Context context = view.getContext();
        int[] iArr = p30.u;
        o4 o4VarQ = o4.Q(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) o4VarQ.b;
        View view2 = this.a;
        ai0.j(view2, view2.getContext(), iArr, attributeSet, (TypedArray) o4VarQ.b, i);
        try {
            if (typedArray.hasValue(0)) {
                this.c = typedArray.getResourceId(0, -1);
                p3 p3Var = this.b;
                Context context2 = view.getContext();
                int i2 = this.c;
                synchronized (p3Var) {
                    colorStateListF = p3Var.a.f(context2, i2);
                }
                if (colorStateListF != null) {
                    g(colorStateListF);
                }
            }
            if (typedArray.hasValue(1)) {
                th0.i(view, o4VarQ.E(1));
            }
            if (typedArray.hasValue(2)) {
                th0.j(view, ah.c(typedArray.getInt(2, -1), null));
            }
            o4VarQ.V();
        } catch (Throwable th) {
            o4VarQ.V();
            throw th;
        }
    }

    public final void e() {
        this.c = -1;
        g(null);
        a();
    }

    public final void f(int i) {
        ColorStateList colorStateListF;
        this.c = i;
        p3 p3Var = this.b;
        if (p3Var != null) {
            Context context = this.a.getContext();
            synchronized (p3Var) {
                colorStateListF = p3Var.a.f(context, i);
            }
        } else {
            colorStateListF = null;
        }
        g(colorStateListF);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new r60();
            }
            r60 r60Var = this.d;
            r60Var.c = colorStateList;
            r60Var.b = true;
        } else {
            this.d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new r60();
        }
        r60 r60Var = this.e;
        r60Var.c = colorStateList;
        r60Var.b = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new r60();
        }
        r60 r60Var = this.e;
        r60Var.d = mode;
        r60Var.a = true;
        a();
    }
}
