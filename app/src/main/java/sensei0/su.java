package sensei0;

import android.text.Editable;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class su extends BaseInputConnection {
    public final /* synthetic */ uu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su(View view, uu uuVar) {
        super(view, true);
        this.a = uuVar;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public final Editable getEditable() {
        return this.a;
    }
}
