package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r6 implements Iterator {
    public int a = 0;
    public final int b;
    public final /* synthetic */ u6 c;

    public r6(u6 u6Var) {
        this.c = u6Var;
        this.b = u6Var.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return Byte.valueOf(this.c.f(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
