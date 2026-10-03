package sensei0;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ti extends ce0 {
    public final /* synthetic */ wi a;

    public ti(wi wiVar) {
        this.a = wiVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.a.b().a();
    }

    @Override // sensei0.ce0, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.b().b();
    }
}
