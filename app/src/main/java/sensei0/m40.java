package sensei0;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m40 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public l40 g;
    public final /* synthetic */ RecyclerView h;

    public m40(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(s40 s40Var, boolean z) {
        RecyclerView.d(s40Var);
        s40Var.getClass();
        RecyclerView recyclerView = this.h;
        u40 u40Var = recyclerView.j0;
        if (u40Var != null) {
            t40 t40Var = u40Var.e;
            ai0.k(null, t40Var != null ? (p0) t40Var.e.remove(null) : null);
        }
        if (z && recyclerView.f0 != null) {
            ii0 ii0Var = recyclerView.f;
            cv cvVar = (cv) ii0Var.c;
            int iE = cvVar.e() - 1;
            while (true) {
                if (iE < 0) {
                    break;
                }
                if (s40Var == cvVar.f(iE)) {
                    Object[] objArr = cvVar.c;
                    Object obj = objArr[iE];
                    Object obj2 = wf0.c;
                    if (obj != obj2) {
                        objArr[iE] = obj2;
                        cvVar.a = true;
                    }
                } else {
                    iE--;
                }
            }
            hi0 hi0Var = (hi0) ((ka0) ii0Var.b).remove(s40Var);
            if (hi0Var != null) {
                hi0Var.a = 0;
                hi0.b.c(hi0Var);
            }
        }
        s40Var.g = null;
        l40 l40VarB = b();
        l40VarB.getClass();
        ArrayList arrayList = l40VarB.a(0).a;
        if (((k40) l40VarB.a.get(0)).b <= arrayList.size()) {
            return;
        }
        s40Var.l();
        arrayList.add(s40Var);
    }

    public final l40 b() {
        if (this.g == null) {
            l40 l40Var = new l40();
            l40Var.a = new SparseArray();
            l40Var.b = 0;
            this.g = l40Var;
        }
        return this.g;
    }

    public final void c() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.q0;
        vp vpVar = this.h.e0;
        vpVar.getClass();
        vpVar.c = 0;
    }

    public final void d(int i) {
        ArrayList arrayList = this.c;
        a((s40) arrayList.get(i), true);
        arrayList.remove(i);
    }

    public final void e(View view) {
        s40 s40VarR = RecyclerView.r(view);
        boolean zJ = s40VarR.j();
        RecyclerView recyclerView = this.h;
        if (zJ) {
            recyclerView.removeDetachedView(view, false);
        }
        if (s40VarR.i()) {
            s40VarR.c.h(s40VarR);
        } else if (s40VarR.o()) {
            s40VarR.b &= -33;
        }
        f(s40VarR);
        if (recyclerView.L == null || s40VarR.g()) {
            return;
        }
        recyclerView.L.b(s40VarR);
    }

    public final void f(s40 s40Var) {
        if (!s40Var.i()) {
            throw null;
        }
        StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
        sb.append(s40Var.i());
        sb.append(" isAttached:");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.s40 g(int r9, long r10) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.m40.g(int, long):sensei0.s40");
    }

    public final void h(s40 s40Var) {
        if (s40Var.d) {
            this.b.remove(s40Var);
        } else {
            this.a.remove(s40Var);
        }
        s40Var.c = null;
        s40Var.d = false;
        s40Var.b &= -33;
    }

    public final void i() {
        this.f = this.e + 0;
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            d(size);
        }
    }
}
