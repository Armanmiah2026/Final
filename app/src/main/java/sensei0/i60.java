package sensei0;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i60 extends j60 implements Iterator {
    public h60 a;
    public boolean b = true;
    public final /* synthetic */ k60 c;

    public i60(k60 k60Var) {
        this.c = k60Var;
    }

    @Override // sensei0.j60
    public final void a(h60 h60Var) {
        h60 h60Var2 = this.a;
        if (h60Var == h60Var2) {
            h60 h60Var3 = h60Var2.d;
            this.a = h60Var3;
            this.b = h60Var3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b) {
            return this.c.a != null;
        }
        h60 h60Var = this.a;
        return (h60Var == null || h60Var.c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b) {
            this.b = false;
            this.a = this.c.a;
        } else {
            h60 h60Var = this.a;
            this.a = h60Var != null ? h60Var.c : null;
        }
        return this.a;
    }
}
