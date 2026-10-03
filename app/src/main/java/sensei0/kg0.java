package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kg0 implements jc, kc {
    public static final kg0 a = new kg0();

    @Override // sensei0.lc
    public final lc c(kc kcVar) {
        return k6.J(this, kcVar);
    }

    @Override // sensei0.lc
    public final Object d(Object obj, jp jpVar) {
        return jpVar.c(obj, this);
    }

    @Override // sensei0.lc
    public final lc j(lc lcVar) {
        pr.j("context", lcVar);
        return lcVar == oi.a ? this : (lc) lcVar.d(this, new y9(1));
    }

    @Override // sensei0.lc
    public final jc n(kc kcVar) {
        return k6.s(this, kcVar);
    }

    @Override // sensei0.jc
    public final kc getKey() {
        return this;
    }
}
