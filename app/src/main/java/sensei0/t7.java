package sensei0;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t7 extends nf0 {
    public boolean a = false;
    public final ViewGroup b;

    public t7(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    @Override // sensei0.nf0, sensei0.jf0
    public final void a(mf0 mf0Var) {
        if (!this.a) {
            fi0.b(this.b, false);
        }
        mf0Var.z(this);
    }

    @Override // sensei0.nf0, sensei0.jf0
    public final void b() {
        fi0.b(this.b, false);
    }

    @Override // sensei0.nf0, sensei0.jf0
    public final void c(mf0 mf0Var) {
        fi0.b(this.b, false);
        this.a = true;
    }

    @Override // sensei0.nf0, sensei0.jf0
    public final void e() {
        fi0.b(this.b, true);
    }
}
