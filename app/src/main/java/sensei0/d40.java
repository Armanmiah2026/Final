package sensei0;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d40 {
    public z30 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public final void a(s40 s40Var) {
        z30 z30Var = this.a;
        if (z30Var != null) {
            RecyclerView recyclerView = z30Var.a;
            boolean z = true;
            s40Var.m(true);
            if ((s40Var.b & 16) != 0) {
                return;
            }
            m40 m40Var = recyclerView.a;
            recyclerView.C();
            o4 o4Var = recyclerView.d;
            k8 k8Var = (k8) o4Var.c;
            z30 z30Var2 = (z30) o4Var.b;
            int iIndexOfChild = z30Var2.a.indexOfChild(null);
            if (iIndexOfChild == -1) {
                o4Var.a0(null);
            } else if (k8Var.d(iIndexOfChild)) {
                k8Var.e(iIndexOfChild);
                o4Var.a0(null);
                z30Var2.a(iIndexOfChild);
            } else {
                z = false;
            }
            if (z) {
                s40 s40VarR = RecyclerView.r(null);
                m40Var.h(s40VarR);
                m40Var.f(s40VarR);
            }
            recyclerView.D(!z);
            if (z || !s40Var.j()) {
                return;
            }
            recyclerView.removeDetachedView(null, false);
        }
    }

    public abstract void b(s40 s40Var);

    public abstract void c();

    public abstract boolean d();
}
