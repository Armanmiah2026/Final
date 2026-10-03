package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class iu {
    public static final hu a;
    public static final hu b;

    static {
        e30 e30Var = e30.c;
        hu huVar = null;
        try {
            huVar = (hu) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        a = huVar;
        b = new hu();
    }
}
