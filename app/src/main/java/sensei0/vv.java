package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vv {
    public static uv a(Object obj, Object obj2) {
        uv uvVarB = (uv) obj;
        uv uvVar = (uv) obj2;
        if (!uvVar.isEmpty()) {
            if (!uvVarB.a) {
                uvVarB = uvVarB.b();
            }
            uvVarB.a();
            if (!uvVar.isEmpty()) {
                uvVarB.putAll(uvVar);
            }
        }
        return uvVarB;
    }
}
