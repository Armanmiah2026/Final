package sensei0;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gu implements Iterator, os {
    public String a;
    public boolean b;
    public final /* synthetic */ v9 c;

    public gu(v9 v9Var) {
        this.c = v9Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.a == null && !this.b) {
            String line = ((BufferedReader) this.c.b).readLine();
            this.a = line;
            if (line == null) {
                this.b = true;
            }
        }
        return this.a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.a;
        this.a = null;
        pr.f(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
