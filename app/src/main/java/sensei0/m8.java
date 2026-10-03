package sensei0;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m8 extends mm0 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Object m;

    public /* synthetic */ m8(int i, Object obj) {
        this.l = i;
        this.m = obj;
    }

    @Override // sensei0.mm0
    public final void Q(int i) {
        switch (this.l) {
            case 0:
                break;
            default:
                od0 od0Var = (od0) this.m;
                od0Var.d = true;
                nd0 nd0Var = (nd0) od0Var.e.get();
                if (nd0Var != null) {
                    q8 q8Var = (q8) nd0Var;
                    q8Var.u();
                    q8Var.invalidateSelf();
                }
                break;
        }
    }

    @Override // sensei0.mm0
    public final void R(Typeface typeface, boolean z) {
        switch (this.l) {
            case 0:
                Chip chip = (Chip) this.m;
                q8 q8Var = chip.f;
                chip.setText(q8Var.K0 ? q8Var.M : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    od0 od0Var = (od0) this.m;
                    od0Var.d = true;
                    nd0 nd0Var = (nd0) od0Var.e.get();
                    if (nd0Var != null) {
                        q8 q8Var2 = (q8) nd0Var;
                        q8Var2.u();
                        q8Var2.invalidateSelf();
                    }
                    break;
                }
                break;
        }
    }

    private final void s0(int i) {
    }
}
