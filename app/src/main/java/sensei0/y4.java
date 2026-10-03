package sensei0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class y4 extends ka0 implements Map {
    public t4 d;
    public v4 f;
    public x4 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(ka0 ka0Var) {
        super(0);
        int i = ka0Var.c;
        b(this.c + i);
        if (this.c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(ka0Var.f(i2), ka0Var.i(i2));
            }
        } else if (i > 0) {
            c5.W(0, 0, i, ka0Var.a, this.a);
            c5.X(ka0Var.b, this.b, 0, 0, i << 1);
            this.c = i;
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        t4 t4Var = this.d;
        if (t4Var != null) {
            return t4Var;
        }
        t4 t4Var2 = new t4(0, this);
        this.d = t4Var2;
        return t4Var2;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i = this.c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.c;
    }

    @Override // java.util.Map
    public final Set keySet() {
        v4 v4Var = this.f;
        if (v4Var != null) {
            return v4Var;
        }
        v4 v4Var2 = new v4(this);
        this.f = v4Var2;
        return v4Var2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        x4 x4Var = this.h;
        if (x4Var != null) {
            return x4Var;
        }
        x4 x4Var2 = new x4(this);
        this.h = x4Var2;
        return x4Var2;
    }
}
