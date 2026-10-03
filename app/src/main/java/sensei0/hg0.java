package sensei0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hg0 extends OutputStream {
    public final FileOutputStream a;

    public hg0(FileOutputStream fileOutputStream) {
        this.a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.a.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        pr.j("b", bArr);
        this.a.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        pr.j("bytes", bArr);
        this.a.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
