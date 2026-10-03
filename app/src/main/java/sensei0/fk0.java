package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fk0 extends g3 {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fk0(int i, String str, String str2) {
        super(2, str, str2);
        this.e = i;
    }

    @Override // sensei0.h3
    public final boolean b() {
        switch (this.e) {
            case 0:
                if (!super.b() || !fi0.a("MULTI_PROCESS")) {
                    return false;
                }
                int i = dk0.a;
                if (gk0.c.b()) {
                    return jk0.a.getStatics().isMultiProcessEnabled();
                }
                throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
            default:
                if (fi0.a("MULTI_PROFILE")) {
                    return super.b();
                }
                return false;
        }
    }
}
