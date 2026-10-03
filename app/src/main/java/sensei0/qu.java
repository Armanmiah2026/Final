package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.trilead.ssh2.sftp.AttribFlags;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qu implements v90 {
    public static final Method E;
    public static final Method F;
    public Rect B;
    public boolean C;
    public final w3 D;
    public final Context a;
    public ListAdapter b;
    public xw c;
    public int f;
    public int h;
    public boolean o;
    public boolean p;
    public boolean q;
    public nu s;
    public View t;
    public sw u;
    public final Handler z;
    public int d = -2;
    public int r = 0;
    public final mu v = new mu(this, 1);
    public final pu w = new pu(0, this);
    public final ou x = new ou(this);
    public final mu y = new mu(this, 0);
    public final Rect A = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                E = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                F = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public qu(Context context, int i) {
        int resourceId;
        this.a = context;
        this.z = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, p30.l, i, 0);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.o = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        w3 w3Var = new w3(context, null, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, p30.p, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            w3Var.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        w3Var.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : wf0.m(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.D = w3Var;
        w3Var.setInputMethodMode(1);
    }

    public final void a(ListAdapter listAdapter) {
        nu nuVar = this.s;
        if (nuVar == null) {
            this.s = new nu(this);
        } else {
            ListAdapter listAdapter2 = this.b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(nuVar);
            }
        }
        this.b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.s);
        }
        xw xwVar = this.c;
        if (xwVar != null) {
            xwVar.setAdapter(this.b);
        }
    }

    @Override // sensei0.v90
    public final void b() {
        int i;
        xw xwVar;
        xw xwVar2 = this.c;
        Context context = this.a;
        w3 w3Var = this.D;
        if (xwVar2 == null) {
            xw xwVar3 = new xw(context, !this.C);
            xwVar3.setHoverListener((yw) this);
            this.c = xwVar3;
            xwVar3.setAdapter(this.b);
            this.c.setOnItemClickListener(this.u);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new ju(this));
            this.c.setOnScrollListener(this.x);
            w3Var.setContentView(this.c);
        }
        Drawable background = w3Var.getBackground();
        Rect rect = this.A;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.o) {
                this.h = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int iA = ku.a(w3Var, this.t, this.h, w3Var.getInputMethodMode() == 2);
        int i3 = this.d;
        int iA2 = this.c.a(i3 != -2 ? i3 != -1 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED), iA);
        int paddingBottom = iA2 + (iA2 > 0 ? this.c.getPaddingBottom() + this.c.getPaddingTop() + i : 0);
        w3Var.getInputMethodMode();
        w3Var.setWindowLayoutType(1002);
        if (w3Var.isShowing()) {
            if (this.t.isAttachedToWindow()) {
                int width = this.d;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.t.getWidth();
                }
                w3Var.setOutsideTouchable(true);
                w3Var.update(this.t, this.f, this.h, width < 0 ? -1 : width, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.d;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.t.getWidth();
        }
        w3Var.setWidth(width2);
        w3Var.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = E;
            if (method != null) {
                try {
                    method.invoke(w3Var, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            lu.b(w3Var, true);
        }
        w3Var.setOutsideTouchable(true);
        w3Var.setTouchInterceptor(this.w);
        if (this.q) {
            w3Var.setOverlapAnchor(this.p);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = F;
            if (method2 != null) {
                try {
                    method2.invoke(w3Var, this.B);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            lu.a(w3Var, this.B);
        }
        w3Var.showAsDropDown(this.t, this.f, this.h, this.r);
        this.c.setSelection(-1);
        if ((!this.C || this.c.isInTouchMode()) && (xwVar = this.c) != null) {
            xwVar.setListSelectionHidden(true);
            xwVar.requestLayout();
        }
        if (this.C) {
            return;
        }
        this.z.post(this.y);
    }

    @Override // sensei0.v90
    public final ListView d() {
        return this.c;
    }

    @Override // sensei0.v90
    public final void dismiss() {
        w3 w3Var = this.D;
        w3Var.dismiss();
        w3Var.setContentView(null);
        this.c = null;
        this.z.removeCallbacks(this.v);
    }

    @Override // sensei0.v90
    public final boolean h() {
        return this.D.isShowing();
    }
}
