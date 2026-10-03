package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pb0 extends sw implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public boolean B;
    public final Context b;
    public final pw c;
    public final nw d;
    public final boolean f;
    public final int h;
    public final int o;
    public final yw p;
    public PopupWindow.OnDismissListener s;
    public View t;
    public View u;
    public zw v;
    public ViewTreeObserver w;
    public boolean x;
    public boolean y;
    public int z;
    public final k7 q = new k7(this, 1);
    public final l7 r = new l7(2, this);
    public int A = 0;

    public pb0(Context context, pw pwVar, View view, int i, boolean z) {
        this.b = context;
        this.c = pwVar;
        this.f = z;
        this.d = new nw(pwVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.o = i;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.t = view;
        this.p = new yw(context, i);
        pwVar.b(this, context);
    }

    @Override // sensei0.ax
    public final void a(pw pwVar, boolean z) {
        if (pwVar != this.c) {
            return;
        }
        dismiss();
        zw zwVar = this.v;
        if (zwVar != null) {
            zwVar.a(pwVar, z);
        }
    }

    @Override // sensei0.v90
    public final void b() {
        View view;
        if (h()) {
            return;
        }
        if (this.x || (view = this.t) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.u = view;
        yw ywVar = this.p;
        w3 w3Var = ywVar.D;
        w3 w3Var2 = ywVar.D;
        w3Var.setOnDismissListener(this);
        ywVar.u = this;
        ywVar.C = true;
        w3Var2.setFocusable(true);
        View view2 = this.u;
        boolean z = this.w == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.w = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.q);
        }
        view2.addOnAttachStateChangeListener(this.r);
        ywVar.t = view2;
        ywVar.r = this.A;
        boolean z2 = this.y;
        Context context = this.b;
        nw nwVar = this.d;
        if (!z2) {
            this.z = sw.m(nwVar, context, this.h);
            this.y = true;
        }
        int i = this.z;
        Rect rect = ywVar.A;
        Drawable background = w3Var2.getBackground();
        if (background != null) {
            background.getPadding(rect);
            ywVar.d = rect.left + rect.right + i;
        } else {
            ywVar.d = i;
        }
        w3Var2.setInputMethodMode(2);
        Rect rect2 = this.a;
        ywVar.B = rect2 != null ? new Rect(rect2) : null;
        ywVar.b();
        xw xwVar = ywVar.c;
        xwVar.setOnKeyListener(this);
        if (this.B) {
            pw pwVar = this.c;
            if (pwVar.l != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) xwVar, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(pwVar.l);
                }
                frameLayout.setEnabled(false);
                xwVar.addHeaderView(frameLayout, null, false);
            }
        }
        ywVar.a(nwVar);
        ywVar.b();
    }

    @Override // sensei0.ax
    public final void c() {
        this.y = false;
        nw nwVar = this.d;
        if (nwVar != null) {
            nwVar.notifyDataSetChanged();
        }
    }

    @Override // sensei0.v90
    public final ListView d() {
        return this.p.c;
    }

    @Override // sensei0.v90
    public final void dismiss() {
        if (h()) {
            this.p.dismiss();
        }
    }

    @Override // sensei0.ax
    public final boolean e() {
        return false;
    }

    @Override // sensei0.v90
    public final boolean h() {
        return !this.x && this.p.D.isShowing();
    }

    @Override // sensei0.ax
    public final void i(zw zwVar) {
        this.v = zwVar;
    }

    @Override // sensei0.ax
    public final boolean j(qc0 qc0Var) {
        boolean z;
        if (qc0Var.hasVisibleItems()) {
            uw uwVar = new uw(this.b, qc0Var, this.u, this.f, this.o, 0);
            zw zwVar = this.v;
            uwVar.h = zwVar;
            sw swVar = uwVar.i;
            if (swVar != null) {
                swVar.i(zwVar);
            }
            int size = qc0Var.f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = qc0Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            uwVar.g = z;
            sw swVar2 = uwVar.i;
            if (swVar2 != null) {
                swVar2.o(z);
            }
            uwVar.j = this.s;
            this.s = null;
            this.c.c(false);
            yw ywVar = this.p;
            int width = ywVar.f;
            int i2 = !ywVar.o ? 0 : ywVar.h;
            if ((Gravity.getAbsoluteGravity(this.A, this.t.getLayoutDirection()) & 7) == 5) {
                width += this.t.getWidth();
            }
            if (!uwVar.b()) {
                if (uwVar.e != null) {
                    uwVar.d(width, i2, true, true);
                }
            }
            zw zwVar2 = this.v;
            if (zwVar2 != null) {
                zwVar2.k(qc0Var);
            }
            return true;
        }
        return false;
    }

    @Override // sensei0.sw
    public final void n(View view) {
        this.t = view;
    }

    @Override // sensei0.sw
    public final void o(boolean z) {
        this.d.c = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.x = true;
        this.c.c(true);
        ViewTreeObserver viewTreeObserver = this.w;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.w = this.u.getViewTreeObserver();
            }
            this.w.removeGlobalOnLayoutListener(this.q);
            this.w = null;
        }
        this.u.removeOnAttachStateChangeListener(this.r);
        PopupWindow.OnDismissListener onDismissListener = this.s;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // sensei0.sw
    public final void p(int i) {
        this.A = i;
    }

    @Override // sensei0.sw
    public final void q(int i) {
        this.p.f = i;
    }

    @Override // sensei0.sw
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.s = onDismissListener;
    }

    @Override // sensei0.sw
    public final void s(boolean z) {
        this.B = z;
    }

    @Override // sensei0.sw
    public final void t(int i) {
        yw ywVar = this.p;
        ywVar.h = i;
        ywVar.o = true;
    }

    @Override // sensei0.sw
    public final void l(pw pwVar) {
    }
}
