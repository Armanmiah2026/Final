package sensei0;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m implements RandomAccess {
    public final m a;
    public final int b;
    public final int c;

    public l(m mVar, int i, int i2) {
        this.a = mVar;
        this.b = i;
        wf0.d(i, i2, mVar.a());
        this.c = i2 - i;
    }

    @Override // sensei0.m
    public final int a() {
        return this.c;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(za0.j("index: ", i, ", size: ", i2));
        }
        return this.a.get(this.b + i);
    }

    @Override // sensei0.m, java.util.List
    public final List subList(int i, int i2) {
        wf0.d(i, i2, this.c);
        int i3 = this.b;
        return new l(this.a, i + i3, i3 + i2);
    }
}
