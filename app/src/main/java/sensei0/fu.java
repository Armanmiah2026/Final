package sensei0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fu implements Iterator, os {
    public final CharSequence a;
    public int b;
    public int c;
    public int d;
    public int f;

    public fu(CharSequence charSequence) {
        pr.j("string", charSequence);
        this.a = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.b;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.f < 0) {
            this.b = 2;
            return false;
        }
        CharSequence charSequence = this.a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i4 = this.c; i4 < length2; i4++) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < charSequence.length() && charSequence.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.b = 1;
                this.f = i;
                this.d = length;
                return true;
            }
        }
        i = -1;
        this.b = 1;
        this.f = i;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = 0;
        int i = this.d;
        int i2 = this.c;
        this.c = this.f + i;
        return this.a.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
