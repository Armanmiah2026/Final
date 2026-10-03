package sensei0;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gk extends k60 {
    public final HashMap f = new HashMap();

    @Override // sensei0.k60
    public final h60 a(Object obj) {
        return (h60) this.f.get(obj);
    }

    @Override // sensei0.k60
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.f.remove(obj);
        return objB;
    }
}
