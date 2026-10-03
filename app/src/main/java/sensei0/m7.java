package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m7 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object f;

    public /* synthetic */ m7(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.f = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                o7 o7Var = (o7) ((sv) this.f).b;
                rw rwVar = (rw) this.c;
                n7 n7Var = (n7) this.b;
                if (n7Var != null) {
                    o7Var.H = true;
                    n7Var.b.c(false);
                    o7Var.H = false;
                }
                if (rwVar.isEnabled() && rwVar.hasSubMenu()) {
                    ((pw) this.d).p(rwVar, null, 4);
                    break;
                }
                break;
            default:
                ((rk) ((rk) this.f).b).a((String) this.b, (String) this.c, this.d);
                break;
        }
    }
}
