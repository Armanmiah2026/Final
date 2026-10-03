package sensei0;

import android.media.MediaDataSource;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mw extends MediaDataSource {
    public final /* synthetic */ byte[] a;

    public mw(byte[] bArr) {
        this.a = bArr;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.a.length;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.a;
        if (j >= bArr2.length) {
            return -1;
        }
        if (((long) i2) + j > bArr2.length) {
            i2 = (int) (((long) bArr2.length) - j);
        }
        System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
