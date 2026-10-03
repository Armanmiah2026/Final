package sensei0;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class jw extends Drawable.ConstantState {
    public d80 a;
    public ph b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public Rect g;
    public final float h;
    public float i;
    public float j;
    public int k;
    public float l;
    public float m;
    public int n;
    public int o;
    public final Paint.Style p;

    public jw(d80 d80Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = 255;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = Paint.Style.FILL_AND_STROKE;
        this.a = d80Var;
        this.b = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        kw kwVar = new kw(this);
        kwVar.f = true;
        return kwVar;
    }

    public jw(jw jwVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = 255;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = Paint.Style.FILL_AND_STROKE;
        this.a = jwVar.a;
        this.b = jwVar.b;
        this.j = jwVar.j;
        this.c = jwVar.c;
        this.d = jwVar.d;
        this.f = jwVar.f;
        this.e = jwVar.e;
        this.k = jwVar.k;
        this.h = jwVar.h;
        this.o = jwVar.o;
        this.i = jwVar.i;
        this.l = jwVar.l;
        this.m = jwVar.m;
        this.n = jwVar.n;
        this.p = jwVar.p;
        if (jwVar.g != null) {
            this.g = new Rect(jwVar.g);
        }
    }
}
