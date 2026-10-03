package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wv {
    public static final vv a;
    public static final vv b;

    static {
        e30 e30Var = e30.c;
        vv vvVar = null;
        try {
            vvVar = (vv) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = vvVar;
        b = new vv();
    }
}
