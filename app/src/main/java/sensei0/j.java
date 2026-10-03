package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class j implements Iterator, os {
    public final /* synthetic */ int a;
    public int b;
    public final Object c;

    public /* synthetic */ j(int i, Object obj) {
        this.a = i;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                if (this.b < ((m) this.c).a()) {
                }
                break;
            default:
                if (this.b < ((Object[]) this.c).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                m mVar = (m) this.c;
                int i = this.b;
                this.b = i + 1;
                return mVar.get(i);
            default:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
