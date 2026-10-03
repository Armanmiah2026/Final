package sensei0;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hj extends MediaDataSource {
    public long a;
    public final /* synthetic */ mj b;

    public hj(mj mjVar) {
        this.b = mjVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.a;
            mj mjVar = this.b;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + ((long) mjVar.a.available())) {
                    return -1;
                }
                mjVar.b(j);
                this.a = j;
            }
            if (i2 > mjVar.a.available()) {
                i2 = mjVar.a.available();
            }
            int i3 = mjVar.read(bArr, i, i2);
            if (i3 >= 0) {
                this.a += (long) i3;
                return i3;
            }
        } catch (IOException unused) {
        }
        this.a = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
