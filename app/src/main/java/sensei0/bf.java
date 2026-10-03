package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bf {
    public static final /* synthetic */ int a = 0;

    static {
        String property;
        int i = ed0.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            af afVar = af.r;
            return;
        }
        nf nfVar = kg.a;
        jq jqVar = qv.a;
        jq jqVar2 = jqVar.f;
        if (jqVar == null) {
            af afVar2 = af.r;
        }
    }
}
