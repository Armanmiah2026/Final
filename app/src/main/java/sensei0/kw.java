package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class kw extends Drawable implements o80 {
    public static final Paint E;
    public PorterDuffColorFilter A;
    public PorterDuffColorFilter B;
    public final RectF C;
    public final boolean D;
    public jw a;
    public final m80[] b;
    public final m80[] c;
    public final BitSet d;
    public boolean f;
    public final Matrix h;
    public final Path o;
    public final Path p;
    public final RectF q;
    public final RectF r;
    public final Region s;
    public final Region t;
    public d80 u;
    public final Paint v;
    public final Paint w;
    public final b80 x;
    public final ws y;
    public final f80 z;

    static {
        Paint paint = new Paint(1);
        E = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public kw() {
        this(new d80());
    }

    public final void a(RectF rectF, Path path) {
        jw jwVar = this.a;
        this.z.a(jwVar.a, jwVar.i, rectF, this.y, path);
        if (this.a.h != 1.0f) {
            Matrix matrix = this.h;
            matrix.reset();
            float f = this.a.h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.C, true);
    }

    public final int b(int i) {
        int i2;
        jw jwVar = this.a;
        float f = jwVar.m + 0.0f + jwVar.l;
        ph phVar = jwVar.b;
        if (phVar == null || !phVar.a || x9.d(i, 255) != phVar.d) {
            return i;
        }
        float fMin = (phVar.e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iL = mm0.L(x9.d(i, 255), phVar.b, fMin);
        if (fMin > 0.0f && (i2 = phVar.c) != 0) {
            iL = x9.b(x9.d(i2, ph.f), iL);
        }
        return x9.d(iL, iAlpha);
    }

    public final void c(Canvas canvas) {
        if (this.d.cardinality() > 0) {
            Log.w("kw", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.a.o;
        Path path = this.o;
        b80 b80Var = this.x;
        if (i != 0) {
            canvas.drawPath(path, b80Var.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            m80 m80Var = this.b[i2];
            int i3 = this.a.n;
            Matrix matrix = m80.b;
            m80Var.a(matrix, b80Var, i3, canvas);
            this.c[i2].a(matrix, b80Var, this.a.n, canvas);
        }
        if (this.D) {
            double d = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d)) * ((double) this.a.o));
            int iCos = (int) (Math.cos(Math.toRadians(d)) * ((double) this.a.o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, E);
            canvas.translate(iSin, iCos);
        }
    }

    public final void d(Canvas canvas, Paint paint, Path path, d80 d80Var, RectF rectF) {
        if (!d80Var.c(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = d80Var.f.a(rectF) * this.a.i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter = this.A;
        Paint paint = this.v;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.a.k;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.B;
        Paint paint2 = this.w;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.a.j);
        int alpha2 = paint2.getAlpha();
        int i2 = this.a.k;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.f;
        Path path = this.o;
        if (z) {
            float f = -(g() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            d80 d80Var = this.a.a;
            c80 c80VarD = d80Var.d();
            ic n2Var = d80Var.e;
            if (!(n2Var instanceof d50)) {
                n2Var = new n2(f, n2Var);
            }
            c80VarD.e = n2Var;
            ic n2Var2 = d80Var.f;
            if (!(n2Var2 instanceof d50)) {
                n2Var2 = new n2(f, n2Var2);
            }
            c80VarD.f = n2Var2;
            ic n2Var3 = d80Var.h;
            if (!(n2Var3 instanceof d50)) {
                n2Var3 = new n2(f, n2Var3);
            }
            c80VarD.h = n2Var3;
            ic n2Var4 = d80Var.g;
            if (!(n2Var4 instanceof d50)) {
                n2Var4 = new n2(f, n2Var4);
            }
            c80VarD.g = n2Var4;
            d80 d80VarA = c80VarD.a();
            this.u = d80VarA;
            float f2 = this.a.i;
            RectF rectFF = f();
            RectF rectF = this.r;
            rectF.set(rectFF);
            float strokeWidth = g() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.z.a(d80VarA, f2, rectF, null, this.p);
            a(f(), path);
            this.f = false;
        }
        jw jwVar = this.a;
        jwVar.getClass();
        if (jwVar.n > 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (!this.a.a.c(f()) && !path.isConvex() && i3 < 29) {
                canvas.save();
                double d = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d)) * ((double) this.a.o)), (int) (Math.cos(Math.toRadians(d)) * ((double) this.a.o)));
                if (this.D) {
                    RectF rectF2 = this.C;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.a.n * 2) + ((int) rectF2.width()) + iWidth, (this.a.n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f3 = (getBounds().left - this.a.n) - iWidth;
                    float f4 = (getBounds().top - this.a.n) - iHeight;
                    canvas2.translate(-f3, -f4);
                    c(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    c(canvas);
                    canvas.restore();
                }
            }
        }
        jw jwVar2 = this.a;
        Paint.Style style = jwVar2.p;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            d(canvas, paint, path, jwVar2.a, f());
        }
        if (g()) {
            e(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public void e(Canvas canvas) {
        d80 d80Var = this.u;
        RectF rectFF = f();
        RectF rectF = this.r;
        rectF.set(rectFF);
        boolean zG = g();
        Paint paint = this.w;
        float strokeWidth = zG ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        d(canvas, paint, this.p, d80Var, rectF);
    }

    public final RectF f() {
        Rect bounds = getBounds();
        RectF rectF = this.q;
        rectF.set(bounds);
        return rectF;
    }

    public final boolean g() {
        Paint.Style style = this.a.p;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.w.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.a.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.a.getClass();
        if (this.a.a.c(f())) {
            outline.setRoundRect(getBounds(), this.a.a.e.a(f()) * this.a.i);
            return;
        }
        RectF rectFF = f();
        Path path = this.o;
        a(rectFF, path);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            zg.a(outline, path);
            return;
        }
        if (i >= 29) {
            try {
                yg.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            yg.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.a.g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.s;
        region.set(bounds);
        RectF rectFF = f();
        Path path = this.o;
        a(rectFF, path);
        Region region2 = this.t;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final void h(Context context) {
        this.a.b = new ph(context);
        m();
    }

    public final void i(float f) {
        jw jwVar = this.a;
        if (jwVar.m != f) {
            jwVar.m = f;
            m();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.a.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.a.getClass();
        ColorStateList colorStateList2 = this.a.d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.a.c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(ColorStateList colorStateList) {
        jw jwVar = this.a;
        if (jwVar.c != colorStateList) {
            jwVar.c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean k(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.a.c == null || color2 == (colorForState2 = this.a.c.getColorForState(iArr, (color2 = (paint2 = this.v).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.a.d == null || color == (colorForState = this.a.d.getColorForState(iArr, (color = (paint = this.w).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean l() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        PorterDuffColorFilter porterDuffColorFilter3 = this.B;
        jw jwVar = this.a;
        ColorStateList colorStateList = jwVar.e;
        PorterDuff.Mode mode = jwVar.f;
        if (colorStateList == null || mode == null) {
            int color = this.v.getColor();
            int iB = b(color);
            porterDuffColorFilter = iB != color ? new PorterDuffColorFilter(iB, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(b(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.A = porterDuffColorFilter;
        this.a.getClass();
        this.B = null;
        this.a.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.A) && Objects.equals(porterDuffColorFilter3, this.B)) ? false : true;
    }

    public final void m() {
        jw jwVar = this.a;
        float f = jwVar.m + 0.0f;
        jwVar.n = (int) Math.ceil(0.75f * f);
        this.a.o = (int) Math.ceil(f * 0.25f);
        l();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.a = new jw(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = k(iArr) || l();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        jw jwVar = this.a;
        if (jwVar.k != i) {
            jwVar.k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.getClass();
        super.invalidateSelf();
    }

    @Override // sensei0.o80
    public final void setShapeAppearanceModel(d80 d80Var) {
        this.a.a = d80Var;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.a.e = colorStateList;
        l();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        jw jwVar = this.a;
        if (jwVar.f != mode) {
            jwVar.f = mode;
            l();
            super.invalidateSelf();
        }
    }

    public kw(d80 d80Var) {
        this(new jw(d80Var));
    }

    public kw(jw jwVar) {
        f80 f80Var;
        this.b = new m80[4];
        this.c = new m80[4];
        this.d = new BitSet(8);
        this.h = new Matrix();
        this.o = new Path();
        this.p = new Path();
        this.q = new RectF();
        this.r = new RectF();
        this.s = new Region();
        this.t = new Region();
        Paint paint = new Paint(1);
        this.v = paint;
        Paint paint2 = new Paint(1);
        this.w = paint2;
        this.x = new b80();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            f80Var = e80.a;
        } else {
            f80Var = new f80();
        }
        this.z = f80Var;
        this.C = new RectF();
        this.D = true;
        this.a = jwVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l();
        k(getState());
        this.y = new ws(6, this);
    }
}
