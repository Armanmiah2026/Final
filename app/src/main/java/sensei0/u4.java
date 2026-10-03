package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u4 implements Iterator, os {
    public int a;
    public int b;
    public boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object f;

    public u4(int i) {
        this.a = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        switch (this.d) {
            case 0:
                objF = ((y4) this.f).f(i);
                break;
            case 1:
                objF = ((y4) this.f).i(i);
                break;
            default:
                objF = ((b5) this.f).b[i];
                break;
        }
        this.b++;
        this.c = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.b - 1;
        this.b = i;
        switch (this.d) {
            case 0:
                ((y4) this.f).g(i);
                break;
            case 1:
                ((y4) this.f).g(i);
                break;
            default:
                ((b5) this.f).a(i);
                break;
        }
        this.a--;
        this.c = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u4(b5 b5Var) {
        this(b5Var.c);
        this.d = 2;
        this.f = b5Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u4(y4 y4Var, int i) {
        this(y4Var.c);
        this.d = i;
        switch (i) {
            case 1:
                this.f = y4Var;
                this(y4Var.c);
                break;
            default:
                this.f = y4Var;
                break;
        }
    }
}
