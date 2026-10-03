package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kr extends ir {
    public static final kr d = new kr(1, 0, 1);

    @Override // sensei0.ir
    public final boolean equals(Object obj) {
        if (!(obj instanceof kr)) {
            return false;
        }
        if (isEmpty() && ((kr) obj).isEmpty()) {
            return true;
        }
        kr krVar = (kr) obj;
        return this.a == krVar.a && this.b == krVar.b;
    }

    @Override // sensei0.ir
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.b;
    }

    @Override // sensei0.ir
    public final boolean isEmpty() {
        return this.a > this.b;
    }

    @Override // sensei0.ir
    public final String toString() {
        return this.a + ".." + this.b;
    }
}
