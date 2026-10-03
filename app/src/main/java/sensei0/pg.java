package sensei0;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pg implements Iterator, os {
    public final /* synthetic */ int a;
    public final Iterator b;
    public int c;
    public Object d;
    public final Object f;

    public pg(Iterator it, a3 a3Var) {
        this.a = 0;
        pr.j("source", it);
        this.b = it;
        this.f = new HashSet();
    }

    public void a() {
        Object next;
        cl clVar = (cl) this.f;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) ((a3) clVar.c).g(next)).booleanValue());
        this.d = next;
        this.c = 1;
    }

    public boolean b() {
        Iterator it;
        cl clVar = (cl) this.f;
        Iterator it2 = (Iterator) this.d;
        if (it2 != null && it2.hasNext()) {
            this.c = 1;
            return true;
        }
        do {
            Iterator it3 = this.b;
            if (!it3.hasNext()) {
                this.c = 2;
                this.d = null;
                return false;
            }
            Object next = it3.next();
            clVar.getClass();
            it = (Iterator) y70.p.g(clVar.c.g(next));
        } while (!it.hasNext());
        this.d = it;
        this.c = 1;
        return true;
    }

    public boolean c() {
        this.c = 3;
        while (true) {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 2;
                break;
            }
            Object next = it.next();
            if (((HashSet) this.f).add(next)) {
                this.d = next;
                this.c = 1;
                break;
            }
        }
        return this.c == 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                int i = this.c;
                if (i == 0) {
                    return c();
                }
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    return false;
                }
                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
            case 1:
                if (this.c == -1) {
                    a();
                }
                return this.c == 1;
            default:
                int i2 = this.c;
                if (i2 == 1) {
                    return true;
                }
                if (i2 == 2) {
                    return false;
                }
                return b();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                int i = this.c;
                if (i == 1) {
                    this.c = 0;
                    return this.d;
                }
                if (i == 2 || !c()) {
                    throw new NoSuchElementException();
                }
                this.c = 0;
                return this.d;
            case 1:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.d;
                this.d = null;
                this.c = -1;
                return obj;
            default:
                int i2 = this.c;
                if (i2 == 2) {
                    throw new NoSuchElementException();
                }
                if (i2 == 0 && !b()) {
                    throw new NoSuchElementException();
                }
                this.c = 0;
                Iterator it = (Iterator) this.d;
                pr.f(it);
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public pg(cl clVar) {
        this.a = 1;
        this.f = clVar;
        this.b = new ef0((cl) clVar.b);
        this.c = -1;
    }

    public pg(cl clVar, byte b) {
        this.a = 2;
        this.f = clVar;
        this.b = new ef0((cl) clVar.b);
    }
}
