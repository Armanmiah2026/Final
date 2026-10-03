package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ud extends bd0 implements fp {
    public int f;

    @Override // sensei0.fp
    public final Object g(Object obj) {
        ud udVar = new ud(1, (xb) obj);
        mg0 mg0Var = mg0.a;
        udVar.n(mg0Var);
        return mg0Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        int i = this.f;
        if (i == 0) {
            wf0.H(obj);
            this.f = 1;
            throw null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        wf0.H(obj);
        return mg0.a;
    }
}
