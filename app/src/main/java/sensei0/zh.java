package sensei0;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zh extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile zh b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new db0(cls, charSequence) : super.newEditable(charSequence);
    }
}
