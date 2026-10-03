package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jn implements kb {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ jn(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.kb
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                ((nn) this.b).setWindowInfoListenerDisplayFeatures((wl0) obj);
                break;
            default:
                ((r20) ((s20) this.b)).k((wl0) obj);
                break;
        }
    }
}
