package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class iy extends et implements fp {
    public final /* synthetic */ int b;
    public final /* synthetic */ ky c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ iy(ky kyVar, jy jyVar, int i) {
        super(1);
        this.b = i;
        this.c = kyVar;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        switch (this.b) {
            case 0:
                this.c.e(null);
                break;
            default:
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ky.g;
                ky kyVar = this.c;
                atomicReferenceFieldUpdater.set(kyVar, null);
                kyVar.e(null);
                break;
        }
        return mg0.a;
    }
}
