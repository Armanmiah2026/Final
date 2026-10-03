package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mi implements wq {
    public final boolean a;

    public mi(boolean z) {
        this.a = z;
    }

    @Override // sensei0.wq
    public final boolean a() {
        return this.a;
    }

    @Override // sensei0.wq
    public final sy e() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
