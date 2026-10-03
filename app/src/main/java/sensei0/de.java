package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class de extends bd0 implements jp {
    public /* synthetic */ Object f;

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        return ((de) j((vb0) obj, (xb) obj2)).n(mg0.a);
    }

    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        de deVar = new de(2, xbVar);
        deVar.f = obj;
        return deVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        wf0.H(obj);
        return Boolean.valueOf(!(((vb0) this.f) instanceof dl));
    }
}
