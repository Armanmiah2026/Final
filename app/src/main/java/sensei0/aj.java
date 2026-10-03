package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class aj {
    public final a6 a;
    public final String b;
    public final ux c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public aj(a6 a6Var, String str, int i) {
        this(a6Var, str, sb0.a);
        switch (i) {
            case 1:
                break;
            default:
                sb0 sb0Var = sb0.a;
                this.a = a6Var;
                this.b = str;
                this.c = sb0Var;
                break;
        }
    }

    public void a(String str, Object obj, rk rkVar) {
        this.a.p(this.b, this.c.i(new i3(str, obj, 17, false)), rkVar == null ? null : new t5(1, this, rkVar));
    }

    public void b(tx txVar) {
        this.a.b(this.b, txVar == null ? null : new i3(18, this, txVar));
    }

    public void c(zi ziVar) {
        this.a.b(this.b, new o4(this, ziVar));
    }

    public aj(a6 a6Var, String str, ux uxVar) {
        this.a = a6Var;
        this.b = str;
        this.c = uxVar;
    }
}
