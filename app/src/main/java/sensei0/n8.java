package sensei0;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n8 extends ViewOutlineProvider {
    public final /* synthetic */ Chip a;

    public n8(Chip chip) {
        this.a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        q8 q8Var = this.a.f;
        if (q8Var != null) {
            q8Var.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
