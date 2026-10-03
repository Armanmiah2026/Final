package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rv implements ex {
    public ex[] a;

    @Override // sensei0.ex
    public final t30 a(Class cls) {
        for (ex exVar : this.a) {
            if (exVar.b(cls)) {
                return exVar.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // sensei0.ex
    public final boolean b(Class cls) {
        for (ex exVar : this.a) {
            if (exVar.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
