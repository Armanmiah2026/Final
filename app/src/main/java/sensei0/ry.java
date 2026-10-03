package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ry {
    public static final qy a;
    public static final qy b;

    static {
        e30 e30Var = e30.c;
        qy qyVar = null;
        try {
            qyVar = (qy) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = qyVar;
        b = new qy();
    }
}
