package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class z6 implements il {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ z6(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.il
    public final Object d(Object obj, yb ybVar) {
        Object objE;
        switch (this.a) {
            case 0:
                ((kb) this.b).accept(obj);
                return mg0.a;
            case 1:
                ve veVar = (ve) this.b;
                return ((veVar.p.B() instanceof dl) || (objE = ve.e(veVar, true, ybVar)) != vc.a) ? mg0.a : objE;
            default:
                ((x40) this.b).a = obj;
                throw new a(this);
        }
    }
}
