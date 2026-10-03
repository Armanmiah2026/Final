package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yv extends m {
    public final /* synthetic */ zv a;

    public yv(zv zvVar) {
        this.a = zvVar;
    }

    @Override // sensei0.m
    public final int a() {
        return this.a.a.groupCount() + 1;
    }

    @Override // sensei0.m, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        String strGroup = this.a.a.group(i);
        return strGroup == null ? "" : strGroup;
    }

    @Override // sensei0.m, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // sensei0.m, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
