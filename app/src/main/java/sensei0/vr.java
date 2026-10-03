package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vr extends gs {
    public final /* synthetic */ int e;
    public final Object f;

    public /* synthetic */ vr(int i, Object obj) {
        this.e = i;
        this.f = obj;
    }

    @Override // sensei0.or
    public final void d(Throwable th) {
        switch (this.e) {
            case 0:
                ((or) this.f).d(th);
                break;
            default:
                hs hsVar = (hs) this.f;
                Object objD = k().D();
                if (!(objD instanceof ga)) {
                    hsVar.h(xe.O(objD));
                } else {
                    hsVar.h(wf0.i(((ga) objD).a));
                }
                break;
        }
    }
}
