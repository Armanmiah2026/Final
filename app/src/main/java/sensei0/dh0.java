package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dh0 extends k6 {
    public final Object j;
    public final int k;
    public final mh l;

    public dh0(Object obj, int i, mh mhVar) {
        pr.j("value", obj);
        za0.p(i, "verificationMode");
        this.j = obj;
        this.k = i;
        this.l = mhVar;
    }

    @Override // sensei0.k6
    public final k6 S(String str, fp fpVar) {
        Object obj = this.j;
        return ((Boolean) fpVar.g(obj)).booleanValue() ? this : new ck(obj, str, this.l, this.k);
    }

    @Override // sensei0.k6
    public final Object i() {
        return this.j;
    }
}
