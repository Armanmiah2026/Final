package sensei0;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tf implements u70 {
    public final CharSequence a;
    public final int b;
    public final jp c;

    public tf(CharSequence charSequence, int i, jp jpVar) {
        pr.j("input", charSequence);
        this.a = charSequence;
        this.b = i;
        this.c = jpVar;
    }

    @Override // sensei0.u70
    public final Iterator iterator() {
        return new sf(this);
    }
}
