package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tj {
    public static final sj a = new sj();
    public static final sj b;

    static {
        e30 e30Var = e30.c;
        sj sjVar = null;
        try {
            sjVar = (sj) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = sjVar;
    }
}
