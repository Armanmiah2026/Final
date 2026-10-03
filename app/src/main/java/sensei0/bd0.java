package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bd0 extends yb implements sp {
    public final int d;

    public bd0(int i, xb xbVar) {
        super(xbVar);
        this.d = i;
    }

    @Override // sensei0.sp
    public final int b() {
        return this.d;
    }

    @Override // sensei0.l5
    public final String toString() {
        if (this.a != null) {
            return super.toString();
        }
        y40.a.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        pr.i("renderLambdaToString(...)", string);
        return string;
    }
}
