package sensei0;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i70 extends d70 {
    public final /* synthetic */ AtomicReferenceArray e;

    public i70(long j, i70 i70Var, int i) {
        super(j, i70Var, i);
        this.e = new AtomicReferenceArray(h70.f);
    }

    @Override // sensei0.d70
    public final int f() {
        return h70.f;
    }

    @Override // sensei0.d70
    public final void g(int i, lc lcVar) {
        this.e.set(i, h70.e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }
}
