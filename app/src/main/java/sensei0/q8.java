package sensei0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q8 extends kw implements Drawable.Callback, nd0 {
    public static final int[] N0 = {R.attr.state_enabled};
    public static final ShapeDrawable O0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public int B0;
    public ColorFilter C0;
    public PorterDuffColorFilter D0;
    public ColorStateList E0;
    public ColorStateList F;
    public PorterDuff.Mode F0;
    public ColorStateList G;
    public int[] G0;
    public float H;
    public ColorStateList H0;
    public float I;
    public WeakReference I0;
    public ColorStateList J;
    public TextUtils.TruncateAt J0;
    public float K;
    public boolean K0;
    public ColorStateList L;
    public int L0;
    public CharSequence M;
    public boolean M0;
    public boolean N;
    public Drawable O;
    public ColorStateList P;
    public float Q;
    public boolean R;
    public boolean S;
    public Drawable T;
    public RippleDrawable U;
    public ColorStateList V;
    public float W;
    public SpannableStringBuilder X;
    public boolean Y;
    public boolean Z;
    public Drawable a0;
    public ColorStateList b0;
    public yx c0;
    public yx d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public float j0;
    public float k0;
    public float l0;
    public final Context m0;
    public final Paint n0;
    public final Paint.FontMetrics o0;
    public final RectF p0;
    public final PointF q0;
    public final Path r0;
    public final od0 s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public int x0;
    public int y0;
    public boolean z0;

    public q8(Context context, AttributeSet attributeSet) {
        super(d80.a(context, attributeSet, com.google.android.material.R.attr.chipStyle, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Action).a());
        this.I = -1.0f;
        this.n0 = new Paint(1);
        this.o0 = new Paint.FontMetrics();
        this.p0 = new RectF();
        this.q0 = new PointF();
        this.r0 = new Path();
        this.B0 = 255;
        this.F0 = PorterDuff.Mode.SRC_IN;
        this.I0 = new WeakReference(null);
        h(context);
        this.m0 = context;
        od0 od0Var = new od0(this);
        this.s0 = od0Var;
        this.M = "";
        od0Var.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = N0;
        setState(iArr);
        if (!Arrays.equals(this.G0, iArr)) {
            this.G0 = iArr;
            if (T()) {
                v(getState(), iArr);
            }
        }
        this.K0 = true;
        int[] iArr2 = x50.a;
        O0.setTint(-1);
    }

    public static void U(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean s(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean t(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(float f) {
        if (this.I != f) {
            this.I = f;
            c80 c80VarD = this.a.a.d();
            c80VarD.e = new e(f);
            c80VarD.f = new e(f);
            c80VarD.g = new e(f);
            c80VarD.h = new e(f);
            setShapeAppearanceModel(c80VarD.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void B(Drawable drawable) {
        Drawable r0 = this.O instanceof jm0 ? null : this.O;
        if (r0 != drawable) {
            float fP = p();
            this.O = drawable != null ? drawable.mutate() : null;
            float fP2 = p();
            U(r0);
            if (S()) {
                n(this.O);
            }
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void C(float f) {
        if (this.Q != f) {
            float fP = p();
            this.Q = f;
            float fP2 = p();
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void D(ColorStateList colorStateList) {
        this.R = true;
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (S()) {
                this.O.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void E(boolean z) {
        if (this.N != z) {
            boolean zS = S();
            this.N = z;
            boolean zS2 = S();
            if (zS != zS2) {
                if (zS2) {
                    n(this.O);
                } else {
                    U(this.O);
                }
                invalidateSelf();
                u();
            }
        }
    }

    public final void F(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (this.M0) {
                jw jwVar = this.a;
                if (jwVar.d != colorStateList) {
                    jwVar.d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void G(float f) {
        if (this.K != f) {
            this.K = f;
            this.n0.setStrokeWidth(f);
            if (this.M0) {
                this.a.j = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void H(Drawable drawable) {
        Drawable r0 = this.T instanceof jm0 ? null : this.T;
        if (r0 != drawable) {
            float fQ = q();
            this.T = drawable != null ? drawable.mutate() : null;
            int[] iArr = x50.a;
            this.U = new RippleDrawable(x50.a(this.L), this.T, O0);
            float fQ2 = q();
            U(r0);
            if (T()) {
                n(this.T);
            }
            invalidateSelf();
            if (fQ != fQ2) {
                u();
            }
        }
    }

    public final void I(float f) {
        if (this.k0 != f) {
            this.k0 = f;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void J(float f) {
        if (this.W != f) {
            this.W = f;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void K(float f) {
        if (this.j0 != f) {
            this.j0 = f;
            invalidateSelf();
            if (T()) {
                u();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (T()) {
                this.T.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void M(boolean z) {
        if (this.S != z) {
            boolean zT = T();
            this.S = z;
            boolean zT2 = T();
            if (zT != zT2) {
                if (zT2) {
                    n(this.T);
                } else {
                    U(this.T);
                }
                invalidateSelf();
                u();
            }
        }
    }

    public final void N(float f) {
        if (this.g0 != f) {
            float fP = p();
            this.g0 = f;
            float fP2 = p();
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void O(float f) {
        if (this.f0 != f) {
            float fP = p();
            this.f0 = f;
            float fP2 = p();
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            this.H0 = null;
            onStateChange(getState());
        }
    }

    public final void Q(ld0 ld0Var) {
        od0 od0Var = this.s0;
        m8 m8Var = od0Var.b;
        TextPaint textPaint = od0Var.a;
        if (od0Var.f != ld0Var) {
            od0Var.f = ld0Var;
            if (ld0Var != null) {
                Context context = this.m0;
                ld0Var.f(context, textPaint, m8Var);
                nd0 nd0Var = (nd0) od0Var.e.get();
                if (nd0Var != null) {
                    textPaint.drawableState = nd0Var.getState();
                }
                ld0Var.e(context, textPaint, m8Var);
                od0Var.d = true;
            }
            nd0 nd0Var2 = (nd0) od0Var.e.get();
            if (nd0Var2 != null) {
                q8 q8Var = (q8) nd0Var2;
                q8Var.u();
                q8Var.invalidateSelf();
                q8Var.onStateChange(nd0Var2.getState());
            }
        }
    }

    public final boolean R() {
        return this.Z && this.a0 != null && this.z0;
    }

    public final boolean S() {
        return this.N && this.O != null;
    }

    public final boolean T() {
        return this.S && this.T != null;
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        int i2;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.B0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.M0;
        Paint paint = this.n0;
        RectF rectF = this.p0;
        if (!z) {
            paint.setColor(this.t0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, r(), r(), paint);
        }
        if (!this.M0) {
            paint.setColor(this.u0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.C0;
            if (colorFilter == null) {
                colorFilter = this.D0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, r(), r(), paint);
        }
        if (this.M0) {
            super.draw(canvas);
        }
        if (this.K > 0.0f && !this.M0) {
            paint.setColor(this.w0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.M0) {
                ColorFilter colorFilter2 = this.C0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.D0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f = bounds.left;
            float f2 = this.K / 2.0f;
            rectF.set(f + f2, bounds.top + f2, bounds.right - f2, bounds.bottom - f2);
            float f3 = this.I - (this.K / 2.0f);
            canvas2.drawRoundRect(rectF, f3, f3, paint);
        }
        paint.setColor(this.x0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.M0) {
            RectF rectF2 = new RectF(bounds);
            jw jwVar = this.a;
            d80 d80Var = jwVar.a;
            float f4 = jwVar.i;
            ws wsVar = this.y;
            f80 f80Var = this.z;
            Path path = this.r0;
            f80Var.a(d80Var, f4, rectF2, wsVar, path);
            d(canvas2, paint, path, this.a.a, f());
        } else {
            canvas2.drawRoundRect(rectF, r(), r(), paint);
        }
        if (S()) {
            o(bounds, rectF);
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas2.translate(f5, f6);
            this.O.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.O.draw(canvas2);
            canvas2.translate(-f5, -f6);
        }
        if (R()) {
            o(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas2.translate(f7, f8);
            this.a0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.a0.draw(canvas2);
            canvas2.translate(-f7, -f8);
        }
        if (this.K0 && this.M != null) {
            PointF pointF = this.q0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.M;
            od0 od0Var = this.s0;
            if (charSequence != null) {
                float fP = p() + this.e0 + this.h0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fP;
                } else {
                    pointF.x = bounds.right - fP;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = od0Var.a;
                Paint.FontMetrics fontMetrics = this.o0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.M != null) {
                float fP2 = p() + this.e0 + this.h0;
                float fQ = q() + this.l0 + this.i0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fP2;
                    rectF.right = bounds.right - fQ;
                } else {
                    rectF.left = bounds.left + fQ;
                    rectF.right = bounds.right - fP2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            ld0 ld0Var = od0Var.f;
            TextPaint textPaint2 = od0Var.a;
            if (ld0Var != null) {
                textPaint2.drawableState = getState();
                od0Var.f.e(this.m0, textPaint2, od0Var.b);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(od0Var.a(this.M.toString())) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i2 = iSave;
            } else {
                i2 = 0;
            }
            CharSequence charSequenceEllipsize = this.M;
            if (z2 && this.J0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.J0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i2);
            }
        }
        if (T()) {
            rectF.setEmpty();
            if (T()) {
                float f9 = this.l0 + this.k0;
                if (getLayoutDirection() == 0) {
                    float f10 = bounds.right - f9;
                    rectF.right = f10;
                    rectF.left = f10 - this.W;
                } else {
                    float f11 = bounds.left + f9;
                    rectF.left = f11;
                    rectF.right = f11 + this.W;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f12 = this.W;
                float f13 = fExactCenterY - (f12 / 2.0f);
                rectF.top = f13;
                rectF.bottom = f13 + f12;
            }
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.T.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = x50.a;
            this.U.setBounds(this.T.getBounds());
            this.U.jumpToCurrentState();
            this.U.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.B0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.C0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(q() + this.s0.a(this.M.toString()) + p() + this.e0 + this.h0 + this.i0 + this.l0), this.L0);
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.M0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.H, this.I);
        } else {
            outline.setRoundRect(bounds, this.I);
            outline2 = outline;
        }
        outline2.setAlpha(this.B0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (s(this.F) || s(this.G) || s(this.J)) {
            return true;
        }
        ld0 ld0Var = this.s0.f;
        if (ld0Var == null || (colorStateList = ld0Var.j) == null || !colorStateList.isStateful()) {
            return (this.Z && this.a0 != null && this.Y) || t(this.O) || t(this.a0) || s(this.E0);
        }
        return true;
    }

    public final void n(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.T) {
            if (drawable.isStateful()) {
                drawable.setState(this.G0);
            }
            drawable.setTintList(this.V);
            return;
        }
        Drawable drawable2 = this.O;
        if (drawable == drawable2 && this.R) {
            drawable2.setTintList(this.P);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void o(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (S() || R()) {
            float f = this.e0 + this.f0;
            Drawable drawable = this.z0 ? this.a0 : this.O;
            float intrinsicWidth = this.Q;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + intrinsicWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - intrinsicWidth;
            }
            Drawable drawable2 = this.z0 ? this.a0 : this.O;
            float fCeil = this.Q;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.m0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (S()) {
            zOnLayoutDirectionChanged |= this.O.setLayoutDirection(i);
        }
        if (R()) {
            zOnLayoutDirectionChanged |= this.a0.setLayoutDirection(i);
        }
        if (T()) {
            zOnLayoutDirectionChanged |= this.T.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (S()) {
            zOnLevelChange |= this.O.setLevel(i);
        }
        if (R()) {
            zOnLevelChange |= this.a0.setLevel(i);
        }
        if (T()) {
            zOnLevelChange |= this.T.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.M0) {
            super.onStateChange(iArr);
        }
        return v(iArr, this.G0);
    }

    public final float p() {
        if (!S() && !R()) {
            return 0.0f;
        }
        float f = this.f0;
        Drawable drawable = this.z0 ? this.a0 : this.O;
        float intrinsicWidth = this.Q;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.g0;
    }

    public final float q() {
        if (T()) {
            return this.j0 + this.W + this.k0;
        }
        return 0.0f;
    }

    public final float r() {
        return this.M0 ? this.a.a.e.a(f()) : this.I;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.B0 != i) {
            this.B0 = i;
            invalidateSelf();
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.C0 != colorFilter) {
            this.C0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.E0 != colorStateList) {
            this.E0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.F0 != mode) {
            this.F0 = mode;
            ColorStateList colorStateList = this.E0;
            this.D0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (S()) {
            visible |= this.O.setVisible(z, z2);
        }
        if (R()) {
            visible |= this.a0.setVisible(z, z2);
        }
        if (T()) {
            visible |= this.T.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void u() {
        p8 p8Var = (p8) this.I0.get();
        if (p8Var != null) {
            Chip chip = (Chip) p8Var;
            chip.b(chip.x);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final boolean v(int[] iArr, int[] iArr2) {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.F;
        int iB = b(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.t0) : 0);
        boolean state = true;
        if (this.t0 != iB) {
            this.t0 = iB;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.G;
        int iB2 = b(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.u0) : 0);
        if (this.u0 != iB2) {
            this.u0 = iB2;
            zOnStateChange = true;
        }
        int iB3 = x9.b(iB2, iB);
        if ((this.v0 != iB3) | (this.a.c == null)) {
            this.v0 = iB3;
            j(ColorStateList.valueOf(iB3));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.J;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.w0) : 0;
        if (this.w0 != colorForState) {
            this.w0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.H0 == null || !x50.b(iArr)) ? 0 : this.H0.getColorForState(iArr, this.x0);
        if (this.x0 != colorForState2) {
            this.x0 = colorForState2;
        }
        ld0 ld0Var = this.s0.f;
        int colorForState3 = (ld0Var == null || (colorStateList = ld0Var.j) == null) ? 0 : colorStateList.getColorForState(iArr, this.y0);
        if (this.y0 != colorForState3) {
            this.y0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z = false;
        } else {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (state2[i] != 16842912) {
                    i++;
                } else if (this.Y) {
                    z = true;
                }
            }
            z = false;
        }
        if (this.z0 == z || this.a0 == null) {
            z2 = false;
        } else {
            float fP = p();
            this.z0 = z;
            if (fP != p()) {
                zOnStateChange = true;
                z2 = true;
            } else {
                z2 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.E0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.A0) : 0;
        if (this.A0 != colorForState4) {
            this.A0 = colorForState4;
            ColorStateList colorStateList6 = this.E0;
            PorterDuff.Mode mode = this.F0;
            this.D0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (t(this.O)) {
            state |= this.O.setState(iArr);
        }
        if (t(this.a0)) {
            state |= this.a0.setState(iArr);
        }
        if (t(this.T)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.T.setState(iArr3);
        }
        int[] iArr4 = x50.a;
        if (t(this.U)) {
            state |= this.U.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z2) {
            u();
        }
        return state;
    }

    public final void w(boolean z) {
        if (this.Y != z) {
            this.Y = z;
            float fP = p();
            if (!z && this.z0) {
                this.z0 = false;
            }
            float fP2 = p();
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void x(Drawable drawable) {
        if (this.a0 != drawable) {
            float fP = p();
            this.a0 = drawable;
            float fP2 = p();
            U(this.a0);
            n(this.a0);
            invalidateSelf();
            if (fP != fP2) {
                u();
            }
        }
    }

    public final void y(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.b0 != colorStateList) {
            this.b0 = colorStateList;
            if (this.Z && (drawable = this.a0) != null && this.Y) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void z(boolean z) {
        if (this.Z != z) {
            boolean zR = R();
            this.Z = z;
            boolean zR2 = R();
            if (zR != zR2) {
                if (zR2) {
                    n(this.a0);
                } else {
                    U(this.a0);
                }
                invalidateSelf();
                u();
            }
        }
    }
}
