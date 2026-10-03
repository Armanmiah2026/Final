package sensei0;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g60 extends j60 implements Iterator {
    public h60 a;
    public h60 b;
    public final /* synthetic */ int c;

    public g60(h60 h60Var, h60 h60Var2, int i) {
        this.c = i;
        this.a = h60Var2;
        this.b = h60Var;
    }

    @Override // sensei0.j60
    public final void a(h60 h60Var) {
        h60 h60Var2;
        h60 h60VarB = null;
        if (this.a == h60Var && h60Var == this.b) {
            this.b = null;
            this.a = null;
        }
        h60 h60Var3 = this.a;
        if (h60Var3 == h60Var) {
            switch (this.c) {
                case 0:
                    h60Var2 = h60Var3.d;
                    break;
                default:
                    h60Var2 = h60Var3.c;
                    break;
            }
            this.a = h60Var2;
        }
        h60 h60Var4 = this.b;
        if (h60Var4 == h60Var) {
            h60 h60Var5 = this.a;
            if (h60Var4 != h60Var5 && h60Var5 != null) {
                h60VarB = b(h60Var4);
            }
            this.b = h60VarB;
        }
    }

    public final h60 b(h60 h60Var) {
        switch (this.c) {
            case 0:
                return h60Var.c;
            default:
                return h60Var.d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        h60 h60Var = this.b;
        h60 h60Var2 = this.a;
        this.b = (h60Var == h60Var2 || h60Var2 == null) ? null : b(h60Var);
        return h60Var;
    }
}
