package com.trilead.ssh2.channel;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelOutputStream extends OutputStream {
    Channel c;
    boolean isClosed = false;

    public ChannelOutputStream(Channel channel) {
        this.c = channel;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        Channel channel = this.c;
        channel.cm.sendEOF(channel);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.isClosed) {
            throw new IOException("This OutputStream is closed.");
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (!this.isClosed) {
            bArr.getClass();
            if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0 || i > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            Channel channel = this.c;
            channel.cm.sendData(channel, bArr, i, i2);
            return;
        }
        throw new IOException("This OutputStream is closed.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
