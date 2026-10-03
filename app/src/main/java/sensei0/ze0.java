package sensei0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ze0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static ze0 s;
    public static ze0 t;
    public final View a;
    public final CharSequence b;
    public final int c;
    public final ye0 d;
    public final ye0 f;
    public int h;
    public int o;
    public af0 p;
    public boolean q;
    public boolean r;

    /* JADX WARN: Type inference failed for: r0v0, types: [sensei0.ye0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [sensei0.ye0] */
    public ze0(View view, CharSequence charSequence) {
        final int i = 0;
        this.d = new Runnable(this) { // from class: sensei0.ye0
            public final /* synthetic */ ze0 b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.b.c(false);
                        break;
                    default:
                        this.b.a();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f = new Runnable(this) { // from class: sensei0.ye0
            public final /* synthetic */ ze0 b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.b.c(false);
                        break;
                    default:
                        this.b.a();
                        break;
                }
            }
        };
        this.a = view;
        this.b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = bi0.a;
        this.c = Build.VERSION.SDK_INT >= 28 ? tb.h(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.r = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(ze0 ze0Var) {
        ze0 ze0Var2 = s;
        if (ze0Var2 != null) {
            ze0Var2.a.removeCallbacks(ze0Var2.d);
        }
        s = ze0Var;
        if (ze0Var != null) {
            ze0Var.a.postDelayed(ze0Var.d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        ze0 ze0Var = t;
        View view = this.a;
        if (ze0Var == this) {
            t = null;
            af0 af0Var = this.p;
            if (af0Var != null) {
                View view2 = (View) af0Var.b;
                if (view2.getParent() != null) {
                    ((WindowManager) af0Var.a.getSystemService("window")).removeView(view2);
                }
                this.p = null;
                this.r = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (s == this) {
            b(null);
        }
        view.removeCallbacks(this.f);
    }

    public final void c(boolean z) {
        int height;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.a;
        if (view.isAttachedToWindow()) {
            b(null);
            ze0 ze0Var = t;
            if (ze0Var != null) {
                ze0Var.a();
            }
            t = this;
            this.q = z;
            af0 af0Var = new af0(view.getContext());
            View view2 = (View) af0Var.b;
            this.p = af0Var;
            int width = this.h;
            int i5 = this.o;
            boolean z3 = this.q;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) af0Var.d;
            ViewParent parent = view2.getParent();
            Context context = af0Var.a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) af0Var.c).setText(this.b);
            int[] iArr = (int[]) af0Var.g;
            int[] iArr2 = (int[]) af0Var.f;
            Rect rect = (Rect) af0Var.e;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i5 + dimensionPixelOffset2;
                i = i5 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z3 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            int i6 = width;
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i4 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = i;
                    z2 = z3;
                    i3 = 0;
                    i4 = 1;
                } else {
                    Resources resources = context.getResources();
                    i4 = 1;
                    i2 = i;
                    z2 = z3;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i3 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i7 = iArr2[i3] - iArr[i3];
                iArr2[i3] = i7;
                iArr2[i4] = iArr2[i4] - iArr[i4];
                layoutParams.x = (i7 + i6) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i8 = iArr2[i4];
                int i9 = ((i8 + i2) - dimensionPixelOffset3) - measuredHeight;
                int i10 = i8 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i9 >= 0) {
                        layoutParams.y = i9;
                    } else {
                        layoutParams.y = i10;
                    }
                } else if (measuredHeight + i10 <= rect.height()) {
                    layoutParams.y = i10;
                } else {
                    layoutParams.y = i9;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.q) {
                j2 = 2500;
            } else {
                Field field = ai0.a;
                if ((view.getWindowSystemUiVisibility() & 1) == i4) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            ye0 ye0Var = this.f;
            view.removeCallbacks(ye0Var);
            view.postDelayed(ye0Var, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            sensei0.af0 r4 = r3.p
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.q
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.a
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.r = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            sensei0.af0 r4 = r3.p
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.r
            if (r1 != 0) goto L66
            int r1 = r3.h
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.c
            if (r1 > r2) goto L66
            int r1 = r3.o
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.h = r4
            r3.o = r5
            r3.r = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ze0.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.h = view.getWidth() / 2;
        this.o = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
