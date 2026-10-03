package sensei0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ru implements View.OnTouchListener {
    public static final int z = ViewConfiguration.getTapTimeout();
    public final e5 a;
    public final AccelerateInterpolator b;
    public final gh c;
    public f5 d;
    public final float[] f;
    public final float[] h;
    public final int o;
    public final int p;
    public final float[] q;
    public final float[] r;
    public final float[] s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final gh y;

    public ru(gh ghVar) {
        e5 e5Var = new e5();
        e5Var.e = Long.MIN_VALUE;
        e5Var.g = -1L;
        e5Var.f = 0L;
        this.a = e5Var;
        this.b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.h = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.q = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.r = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.s = fArr5;
        this.c = ghVar;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.o = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.p = z;
        e5Var.a = 500;
        e5Var.b = 500;
        this.y = ghVar;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f
            r0 = r0[r4]
            float[] r1 = r3.h
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.q
            r0 = r0[r4]
            float[] r1 = r3.r
            r1 = r1[r4]
            float[] r2 = r3.s
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ru.a(int, float, float, float):float");
    }

    public final float c(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.o;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.w && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.u) {
            this.w = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        e5 e5Var = this.a;
        int i2 = (int) (jCurrentAnimationTimeMillis - e5Var.e);
        int i3 = e5Var.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        e5Var.i = i;
        e5Var.h = e5Var.a(jCurrentAnimationTimeMillis);
        e5Var.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        gh ghVar;
        int count;
        e5 e5Var = this.a;
        float f = e5Var.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(e5Var.c);
        if (iAbs != 0 && (count = (ghVar = this.y).getCount()) != 0) {
            int childCount = ghVar.getChildCount();
            int firstVisiblePosition = ghVar.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && ghVar.getChildAt(0).getTop() >= 0)) : !(i >= count && ghVar.getChildAt(childCount - 1).getBottom() <= ghVar.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.x
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.v = r2
            r7.t = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            sensei0.gh r4 = r7.c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            sensei0.e5 r9 = r7.a
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.w
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            sensei0.f5 r8 = r7.d
            if (r8 != 0) goto L60
            sensei0.f5 r8 = new sensei0.f5
            r8.<init>(r1, r7)
            r7.d = r8
        L60:
            r7.w = r2
            r7.u = r2
            boolean r8 = r7.t
            if (r8 != 0) goto L75
            int r8 = r7.p
            if (r8 <= 0) goto L75
            sensei0.f5 r9 = r7.d
            long r5 = (long) r8
            java.lang.reflect.Field r8 = sensei0.ai0.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            sensei0.f5 r8 = r7.d
            r8.run()
        L7a:
            r7.t = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ru.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
