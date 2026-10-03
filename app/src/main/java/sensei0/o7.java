package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.sensei.tunnel.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o7 extends sw implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public int B;
    public boolean D;
    public zw E;
    public ViewTreeObserver F;
    public PopupWindow.OnDismissListener G;
    public boolean H;
    public final Context b;
    public final int c;
    public final int d;
    public final boolean f;
    public final Handler h;
    public final k7 q;
    public final l7 r;
    public View v;
    public View w;
    public int x;
    public boolean y;
    public boolean z;
    public final ArrayList o = new ArrayList();
    public final ArrayList p = new ArrayList();
    public final sv s = new sv(9, this);
    public int t = 0;
    public int u = 0;
    public boolean C = false;

    public o7(Context context, View view, int i, boolean z) {
        int i2 = 0;
        this.q = new k7(this, i2);
        this.r = new l7(i2, this);
        this.b = context;
        this.v = view;
        this.d = i;
        this.f = z;
        this.x = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    @Override // sensei0.ax
    public final void a(pw pwVar, boolean z) {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (pwVar == ((n7) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((n7) arrayList.get(i2)).b.c(false);
        }
        n7 n7Var = (n7) arrayList.remove(i);
        pw pwVar2 = n7Var.b;
        yw ywVar = n7Var.a;
        w3 w3Var = ywVar.D;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = pwVar2.r;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ax axVar = (ax) weakReference.get();
            if (axVar == null || axVar == this) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        if (this.H) {
            vw.b(w3Var, null);
            w3Var.setAnimationStyle(0);
        }
        ywVar.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.x = ((n7) arrayList.get(size2 - 1)).c;
        } else {
            this.x = this.v.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((n7) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        zw zwVar = this.E;
        if (zwVar != null) {
            zwVar.a(pwVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.F;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.F.removeGlobalOnLayoutListener(this.q);
            }
            this.F = null;
        }
        this.w.removeOnAttachStateChangeListener(this.r);
        this.G.onDismiss();
    }

    @Override // sensei0.v90
    public final void b() {
        if (h()) {
            return;
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            u((pw) obj);
        }
        arrayList.clear();
        View view = this.v;
        this.w = view;
        if (view != null) {
            boolean z = this.F == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.F = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.q);
            }
            this.w.addOnAttachStateChangeListener(this.r);
        }
    }

    @Override // sensei0.ax
    public final void c() {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((n7) obj).a.c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((nw) adapter).notifyDataSetChanged();
        }
    }

    @Override // sensei0.v90
    public final ListView d() {
        ArrayList arrayList = this.p;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((n7) arrayList.get(arrayList.size() - 1)).a.c;
    }

    @Override // sensei0.v90
    public final void dismiss() {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        if (size > 0) {
            n7[] n7VarArr = (n7[]) arrayList.toArray(new n7[size]);
            for (int i = size - 1; i >= 0; i--) {
                n7 n7Var = n7VarArr[i];
                if (n7Var.a.D.isShowing()) {
                    n7Var.a.dismiss();
                }
            }
        }
    }

    @Override // sensei0.ax
    public final boolean e() {
        return false;
    }

    @Override // sensei0.v90
    public final boolean h() {
        ArrayList arrayList = this.p;
        return arrayList.size() > 0 && ((n7) arrayList.get(0)).a.D.isShowing();
    }

    @Override // sensei0.ax
    public final void i(zw zwVar) {
        this.E = zwVar;
    }

    @Override // sensei0.ax
    public final boolean j(qc0 qc0Var) {
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            n7 n7Var = (n7) obj;
            if (qc0Var == n7Var.b) {
                n7Var.a.c.requestFocus();
                return true;
            }
        }
        if (!qc0Var.hasVisibleItems()) {
            return false;
        }
        l(qc0Var);
        zw zwVar = this.E;
        if (zwVar != null) {
            zwVar.k(qc0Var);
        }
        return true;
    }

    @Override // sensei0.sw
    public final void l(pw pwVar) {
        pwVar.b(this, this.b);
        if (h()) {
            u(pwVar);
        } else {
            this.o.add(pwVar);
        }
    }

    @Override // sensei0.sw
    public final void n(View view) {
        if (this.v != view) {
            this.v = view;
            this.u = Gravity.getAbsoluteGravity(this.t, view.getLayoutDirection());
        }
    }

    @Override // sensei0.sw
    public final void o(boolean z) {
        this.C = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        n7 n7Var;
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                n7Var = null;
                break;
            }
            n7Var = (n7) arrayList.get(i);
            if (!n7Var.a.D.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (n7Var != null) {
            n7Var.b.c(false);
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
        if (this.t != i) {
            this.t = i;
            this.u = Gravity.getAbsoluteGravity(i, this.v.getLayoutDirection());
        }
    }

    @Override // sensei0.sw
    public final void q(int i) {
        this.y = true;
        this.A = i;
    }

    @Override // sensei0.sw
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.G = onDismissListener;
    }

    @Override // sensei0.sw
    public final void s(boolean z) {
        this.D = z;
    }

    @Override // sensei0.sw
    public final void t(int i) {
        this.z = true;
        this.B = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(sensei0.pw r18) {
        /*
            Method dump skipped, instruction units count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o7.u(sensei0.pw):void");
    }
}
