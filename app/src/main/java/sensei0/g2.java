package sensei0;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.sensei.tunnel.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements ax {
    public c2 A;
    public e2 B;
    public d2 C;
    public final Context a;
    public Context b;
    public pw c;
    public final LayoutInflater d;
    public zw f;
    public ActionMenuView o;
    public f2 p;
    public Drawable q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public c2 z;
    public final int h = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray y = new SparseBooleanArray();
    public final sv D = new sv(3, this);

    public g2(Context context) {
        this.a = context;
        this.d = LayoutInflater.from(context);
    }

    @Override // sensei0.ax
    public final void a(pw pwVar, boolean z) {
        d();
        c2 c2Var = this.A;
        if (c2Var != null && c2Var.b()) {
            c2Var.i.dismiss();
        }
        zw zwVar = this.f;
        if (zwVar != null) {
            zwVar.a(pwVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(rw rwVar, View view, ActionMenuView actionMenuView) {
        View view2 = rwVar.z;
        View view3 = view2 != null ? view2 : null;
        if (view3 == null || ((rwVar.y & 8) != 0 && view2 != null)) {
            bx bxVar = view instanceof bx ? (bx) view : (bx) this.d.inflate(this.h, (ViewGroup) actionMenuView, false);
            bxVar.b(rwVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) bxVar;
            actionMenuItemView.setItemInvoker(this.o);
            if (this.C == null) {
                this.C = new d2(this);
            }
            actionMenuItemView.setPopupCallback(this.C);
            view3 = (View) bxVar;
        }
        view3.setVisibility(rwVar.B ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        actionMenuView.getClass();
        if (!(layoutParams instanceof i2)) {
            view3.setLayoutParams(ActionMenuView.j(layoutParams));
        }
        return view3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sensei0.ax
    public final void c() {
        int i;
        ActionMenuView actionMenuView = this.o;
        ArrayList arrayList = null;
        boolean z = false;
        if (actionMenuView != null) {
            pw pwVar = this.c;
            if (pwVar != null) {
                pwVar.i();
                ArrayList arrayListK = this.c.k();
                int size = arrayListK.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    rw rwVar = (rw) arrayListK.get(i2);
                    if ((rwVar.x & 32) == 32) {
                        View childAt = actionMenuView.getChildAt(i);
                        rw itemData = childAt instanceof bx ? ((bx) childAt).getItemData() : null;
                        View viewB = b(rwVar, childAt, actionMenuView);
                        if (rwVar != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(viewB);
                            }
                            this.o.addView(viewB, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < actionMenuView.getChildCount()) {
                if (actionMenuView.getChildAt(i) == this.p) {
                    i++;
                } else {
                    actionMenuView.removeViewAt(i);
                }
            }
        }
        this.o.requestLayout();
        pw pwVar2 = this.c;
        if (pwVar2 != null) {
            pwVar2.i();
            ArrayList arrayList2 = pwVar2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((rw) arrayList2.get(i3)).getClass();
            }
        }
        pw pwVar3 = this.c;
        if (pwVar3 != null) {
            pwVar3.i();
            arrayList = pwVar3.j;
        }
        if (this.s && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((rw) arrayList.get(0)).B;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.p == null) {
                this.p = new f2(this, this.a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.p.getParent();
            if (viewGroup2 != this.o) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.p);
                }
                ActionMenuView actionMenuView2 = this.o;
                f2 f2Var = this.p;
                actionMenuView2.getClass();
                i2 i2VarI = ActionMenuView.i();
                i2VarI.a = true;
                actionMenuView2.addView(f2Var, i2VarI);
            }
        } else {
            f2 f2Var2 = this.p;
            if (f2Var2 != null) {
                ViewParent parent = f2Var2.getParent();
                ActionMenuView actionMenuView3 = this.o;
                if (parent == actionMenuView3) {
                    actionMenuView3.removeView(this.p);
                }
            }
        }
        this.o.setOverflowReserved(this.s);
    }

    public final boolean d() {
        ActionMenuView actionMenuView;
        e2 e2Var = this.B;
        if (e2Var != null && (actionMenuView = this.o) != null) {
            actionMenuView.removeCallbacks(e2Var);
            this.B = null;
            return true;
        }
        c2 c2Var = this.z;
        if (c2Var == null) {
            return false;
        }
        if (c2Var.b()) {
            c2Var.i.dismiss();
        }
        return true;
    }

    @Override // sensei0.ax
    public final boolean e() {
        int size;
        ArrayList arrayListK;
        int i;
        boolean z;
        g2 g2Var = this;
        pw pwVar = g2Var.c;
        if (pwVar != null) {
            arrayListK = pwVar.k();
            size = arrayListK.size();
        } else {
            size = 0;
            arrayListK = null;
        }
        int i2 = g2Var.w;
        int i3 = g2Var.v;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ActionMenuView actionMenuView = g2Var.o;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            rw rwVar = (rw) arrayListK.get(i4);
            int i7 = rwVar.y;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (g2Var.x && rwVar.B) {
                i2 = 0;
            }
            i4++;
        }
        if (g2Var.s && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = g2Var.y;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            rw rwVar2 = (rw) arrayListK.get(i9);
            int i11 = rwVar2.y;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = rwVar2.b;
            if (z3) {
                View viewB = g2Var.b(rwVar2, null, actionMenuView);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                rwVar2.d(z);
            } else if ((i11 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i12);
                boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                if (z5) {
                    View viewB2 = g2Var.b(rwVar2, null, actionMenuView);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z5 &= i3 + i10 > 0;
                }
                if (z5 && i12 != 0) {
                    sparseBooleanArray.put(i12, true);
                } else if (z4) {
                    sparseBooleanArray.put(i12, false);
                    for (int i13 = 0; i13 < i9; i13++) {
                        rw rwVar3 = (rw) arrayListK.get(i13);
                        if (rwVar3.b == i12) {
                            if ((rwVar3.x & 32) == 32) {
                                i8++;
                            }
                            rwVar3.d(false);
                        }
                    }
                }
                if (z5) {
                    i8--;
                }
                rwVar2.d(z5);
            } else {
                rwVar2.d(false);
                i9++;
                i = 2;
                g2Var = this;
                z = true;
            }
            i9++;
            i = 2;
            g2Var = this;
            z = true;
        }
        return z;
    }

    @Override // sensei0.ax
    public final boolean f(rw rwVar) {
        return false;
    }

    @Override // sensei0.ax
    public final boolean g(rw rwVar) {
        return false;
    }

    public final boolean h() {
        pw pwVar;
        if (!this.s) {
            return false;
        }
        c2 c2Var = this.z;
        if ((c2Var != null && c2Var.b()) || (pwVar = this.c) == null || this.o == null || this.B != null) {
            return false;
        }
        pwVar.i();
        if (pwVar.j.isEmpty()) {
            return false;
        }
        e2 e2Var = new e2(0, this, new c2(this, this.b, this.c, this.p));
        this.B = e2Var;
        this.o.post(e2Var);
        return true;
    }

    @Override // sensei0.ax
    public final void i(zw zwVar) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sensei0.ax
    public final boolean j(qc0 qc0Var) {
        boolean z;
        if (qc0Var.hasVisibleItems()) {
            qc0 qc0Var2 = qc0Var;
            while (true) {
                pw pwVar = qc0Var2.v;
                if (pwVar == this.c) {
                    break;
                }
                qc0Var2 = (qc0) pwVar;
            }
            rw rwVar = qc0Var2.w;
            ActionMenuView actionMenuView = this.o;
            View view = null;
            view = null;
            if (actionMenuView != null) {
                int childCount = actionMenuView.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = actionMenuView.getChildAt(i);
                    if ((childAt instanceof bx) && ((bx) childAt).getItemData() == rwVar) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                qc0Var.w.getClass();
                int size = qc0Var.f.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = qc0Var.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                c2 c2Var = new c2(this, this.b, qc0Var, view);
                this.A = c2Var;
                c2Var.g = z;
                sw swVar = c2Var.i;
                if (swVar != null) {
                    swVar.o(z);
                }
                c2 c2Var2 = this.A;
                if (!c2Var2.b()) {
                    if (c2Var2.e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    c2Var2.d(0, 0, false, false);
                }
                zw zwVar = this.f;
                if (zwVar != null) {
                    zwVar.k(qc0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // sensei0.ax
    public final void k(Context context, pw pwVar) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = pwVar;
        Resources resources = context.getResources();
        if (!this.t) {
            this.s = true;
        }
        int i = 2;
        this.u = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.w = i;
        int measuredWidth = this.u;
        if (this.s) {
            if (this.p == null) {
                f2 f2Var = new f2(this, this.a);
                this.p = f2Var;
                if (this.r) {
                    f2Var.setImageDrawable(this.q);
                    this.q = null;
                    this.r = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.p.getMeasuredWidth();
        } else {
            this.p = null;
        }
        this.v = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }
}
