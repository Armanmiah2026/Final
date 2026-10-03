package sensei0;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cd extends xi {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cd(wi wiVar, int i) {
        super(wiVar);
        this.e = i;
    }

    @Override // sensei0.xi
    public void q() {
        switch (this.e) {
            case 0:
                wi wiVar = this.b;
                wiVar.w = null;
                CheckableImageButton checkableImageButton = wiVar.o;
                checkableImageButton.setOnLongClickListener(null);
                mm0.d0(checkableImageButton, null);
                break;
        }
    }
}
