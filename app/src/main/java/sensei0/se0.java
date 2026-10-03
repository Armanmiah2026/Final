package sensei0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class se0 implements ax {
    public pw a;
    public rw b;
    public final /* synthetic */ Toolbar c;

    public se0(Toolbar toolbar) {
        this.c = toolbar;
    }

    @Override // sensei0.ax
    public final void c() {
        if (this.b != null) {
            pw pwVar = this.a;
            if (pwVar != null) {
                int size = pwVar.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        return;
                    }
                }
            }
            g(this.b);
        }
    }

    @Override // sensei0.ax
    public final boolean e() {
        return false;
    }

    @Override // sensei0.ax
    public final boolean f(rw rwVar) {
        Toolbar toolbar = this.c;
        toolbar.c();
        ViewParent parent = toolbar.p.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.p);
            }
            toolbar.addView(toolbar.p);
        }
        View view = rwVar.z;
        if (view == null) {
            view = null;
        }
        toolbar.q = view;
        this.b = rwVar;
        ViewParent parent2 = view.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.q);
            }
            te0 te0VarG = Toolbar.g();
            te0VarG.a = (toolbar.v & 112) | 8388611;
            te0VarG.b = 2;
            toolbar.q.setLayoutParams(te0VarG);
            toolbar.addView(toolbar.q);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((te0) childAt.getLayoutParams()).b != 2 && childAt != toolbar.a) {
                toolbar.removeViewAt(childCount);
                toolbar.M.add(childAt);
            }
        }
        toolbar.requestLayout();
        rwVar.B = true;
        rwVar.n.o(false);
        toolbar.t();
        return true;
    }

    @Override // sensei0.ax
    public final boolean g(rw rwVar) {
        Toolbar toolbar = this.c;
        toolbar.removeView(toolbar.q);
        toolbar.removeView(toolbar.p);
        toolbar.q = null;
        ArrayList arrayList = toolbar.M;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.b = null;
        toolbar.requestLayout();
        rwVar.B = false;
        rwVar.n.o(false);
        toolbar.t();
        return true;
    }

    @Override // sensei0.ax
    public final boolean j(qc0 qc0Var) {
        return false;
    }

    @Override // sensei0.ax
    public final void k(Context context, pw pwVar) {
        rw rwVar;
        pw pwVar2 = this.a;
        if (pwVar2 != null && (rwVar = this.b) != null) {
            pwVar2.d(rwVar);
        }
        this.a = pwVar;
    }

    @Override // sensei0.ax
    public final void a(pw pwVar, boolean z) {
    }
}
