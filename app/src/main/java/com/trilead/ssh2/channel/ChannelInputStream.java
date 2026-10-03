package com.trilead.ssh2.channel;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelInputStream extends InputStream {
    Channel c;
    boolean extendedFlag;
    boolean isClosed = false;
    boolean isEOF = false;

    public ChannelInputStream(Channel channel, boolean z) {
        this.c = channel;
        this.extendedFlag = z;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.isEOF) {
            return 0;
        }
        Channel channel = this.c;
        return Math.max(channel.cm.getAvailable(channel, this.extendedFlag), 0);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.isClosed = true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        bArr.getClass();
        if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0 || i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.isEOF) {
            return -1;
        }
        Channel channel = this.c;
        int channelData = channel.cm.getChannelData(channel, this.extendedFlag, bArr, i, i2);
        if (channelData == -1) {
            this.isEOF = true;
        }
        return channelData;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) != 1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
