package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class se extends et implements fp {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ se(int i, Object obj) {
        super(1);
        this.b = i;
        this.c = obj;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        switch (this.b) {
            case 0:
                Throwable th = (Throwable) obj;
                ve veVar = (ve) this.c;
                if (th != null) {
                    veVar.p.F(new dl(th));
                }
                if (veVar.r.b != mh.t) {
                    ((zk) veVar.r.a()).close();
                }
                return mg0.a;
            case 1:
                f7 f7Var = (f7) this.c;
                mg0 mg0Var = mg0.a;
                f7Var.h(mg0Var);
                return mg0Var;
            default:
                ((g70) this.c).b();
                return mg0.a;
        }
    }
}
