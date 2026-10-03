package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dq implements Iterator, os {
    public Object a;
    public int b = -2;
    public final /* synthetic */ v9 c;

    public dq(v9 v9Var) {
        this.c = v9Var;
    }

    public final void a() {
        Object objG;
        if (this.b == -2) {
            objG = ((dz) this.c.b).a();
        } else {
            a50 a50Var = a50.p;
            Object obj = this.a;
            pr.f(obj);
            objG = a50Var.g(obj);
        }
        this.a = objG;
        this.b = objG == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b < 0) {
            a();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b < 0) {
            a();
        }
        if (this.b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.a;
        pr.g("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence", obj);
        this.b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
