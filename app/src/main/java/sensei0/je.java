package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class je extends bd0 implements fp {
    public int f;
    public final /* synthetic */ re h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je(re reVar, xb xbVar) {
        super(1, xbVar);
        this.h = reVar;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        return new je(this.h, (xb) obj).n(mg0.a);
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        int i = this.f;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            wf0.H(obj);
            return obj;
        }
        wf0.H(obj);
        this.f = 1;
        Object objG = this.h.g(this);
        vc vcVar = vc.a;
        return objG == vcVar ? vcVar : objG;
    }
}
