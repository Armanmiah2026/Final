package sensei0;

import android.content.Context;
import android.view.View;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 extends uw {
    public final /* synthetic */ int l = 1;
    public final /* synthetic */ g2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(g2 g2Var, Context context, pw pwVar, View view) {
        super(context, pwVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.m = g2Var;
        this.f = 8388613;
        sv svVar = g2Var.D;
        this.h = svVar;
        sw swVar = this.i;
        if (swVar != null) {
            swVar.i(svVar);
        }
    }

    @Override // sensei0.uw
    public final void c() {
        switch (this.l) {
            case 0:
                g2 g2Var = this.m;
                g2Var.A = null;
                g2Var.getClass();
                super.c();
                break;
            default:
                g2 g2Var2 = this.m;
                pw pwVar = g2Var2.c;
                if (pwVar != null) {
                    pwVar.c(true);
                }
                g2Var2.z = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(g2 g2Var, Context context, qc0 qc0Var, View view) {
        super(context, qc0Var, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.m = g2Var;
        if ((qc0Var.w.x & 32) != 32) {
            View view2 = g2Var.p;
            this.e = view2 == null ? g2Var.o : view2;
        }
        sv svVar = g2Var.D;
        this.h = svVar;
        sw swVar = this.i;
        if (swVar != null) {
            swVar.i(svVar);
        }
    }
}
