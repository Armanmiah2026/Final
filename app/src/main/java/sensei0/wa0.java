package sensei0;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wa0 implements Iterator {
    public int a = -1;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ ua0 d;

    public wa0(ua0 ua0Var) {
        this.d = ua0Var;
    }

    public final Iterator a() {
        if (this.c == null) {
            this.c = this.d.b.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a + 1;
        ua0 ua0Var = this.d;
        return i < ua0Var.a.size() || (!ua0Var.b.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        ua0 ua0Var = this.d;
        return i < ua0Var.a.size() ? (Map.Entry) ua0Var.a.get(this.a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        int i = ua0.h;
        ua0 ua0Var = this.d;
        ua0Var.b();
        if (this.a >= ua0Var.a.size()) {
            a().remove();
            return;
        }
        int i2 = this.a;
        this.a = i2 - 1;
        ua0Var.h(i2);
    }
}
