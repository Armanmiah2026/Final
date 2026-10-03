package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class of0 extends nf0 {
    public final /* synthetic */ y4 a;
    public final /* synthetic */ pf0 b;

    public of0(pf0 pf0Var, y4 y4Var) {
        this.b = pf0Var;
        this.a = y4Var;
    }

    @Override // sensei0.nf0, sensei0.jf0
    public final void a(mf0 mf0Var) {
        ((ArrayList) this.a.get(this.b.b)).remove(mf0Var);
        mf0Var.z(this);
    }
}
