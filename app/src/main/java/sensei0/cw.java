package sensei0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cw {
    public final MaterialButton a;
    public d80 b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public kw m;
    public boolean q;
    public RippleDrawable s;
    public int t;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean r = true;

    public cw(MaterialButton materialButton, d80 d80Var) {
        this.a = materialButton;
        this.b = d80Var;
    }

    public final o80 a() {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (o80) this.s.getDrawable(2) : (o80) this.s.getDrawable(1);
    }

    public final kw b(boolean z) {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (kw) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void c(d80 d80Var) {
        this.b = d80Var;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(d80Var);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(d80Var);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(d80Var);
        }
    }

    public final void d(int i, int i2) {
        Field field = ai0.a;
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void e() {
        kw kwVar = new kw(this.b);
        MaterialButton materialButton = this.a;
        kwVar.h(materialButton.getContext());
        kwVar.setTintList(this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            kwVar.setTintMode(mode);
        }
        float f = this.h;
        ColorStateList colorStateList = this.k;
        kwVar.a.j = f;
        kwVar.invalidateSelf();
        jw jwVar = kwVar.a;
        if (jwVar.d != colorStateList) {
            jwVar.d = colorStateList;
            kwVar.onStateChange(kwVar.getState());
        }
        kw kwVar2 = new kw(this.b);
        kwVar2.setTint(0);
        float f2 = this.h;
        int iT = this.n ? mm0.t(materialButton, R.attr.colorSurface) : 0;
        kwVar2.a.j = f2;
        kwVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iT);
        jw jwVar2 = kwVar2.a;
        if (jwVar2.d != colorStateListValueOf) {
            jwVar2.d = colorStateListValueOf;
            kwVar2.onStateChange(kwVar2.getState());
        }
        kw kwVar3 = new kw(this.b);
        this.m = kwVar3;
        kwVar3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(x50.a(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{kwVar2, kwVar}), this.c, this.e, this.d, this.f), this.m);
        this.s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        kw kwVarB = b(false);
        if (kwVarB != null) {
            kwVarB.i(this.t);
            kwVarB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        kw kwVarB = b(false);
        kw kwVarB2 = b(true);
        if (kwVarB != null) {
            float f = this.h;
            ColorStateList colorStateList = this.k;
            kwVarB.a.j = f;
            kwVarB.invalidateSelf();
            jw jwVar = kwVarB.a;
            if (jwVar.d != colorStateList) {
                jwVar.d = colorStateList;
                kwVarB.onStateChange(kwVarB.getState());
            }
            if (kwVarB2 != null) {
                float f2 = this.h;
                int iT = this.n ? mm0.t(this.a, R.attr.colorSurface) : 0;
                kwVarB2.a.j = f2;
                kwVarB2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iT);
                jw jwVar2 = kwVarB2.a;
                if (jwVar2.d != colorStateListValueOf) {
                    jwVar2.d = colorStateListValueOf;
                    kwVarB2.onStateChange(kwVarB2.getState());
                }
            }
        }
    }
}
