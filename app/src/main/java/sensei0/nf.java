package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nf extends u60 {
    public static final nf d;

    static {
        int i = id0.c;
        int i2 = id0.d;
        long j = id0.e;
        String str = id0.a;
        nf nfVar = new nf();
        nfVar.c = new tc(i, i2, j, str);
        d = nfVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // sensei0.pc
    public final String toString() {
        return "Dispatchers.Default";
    }
}
