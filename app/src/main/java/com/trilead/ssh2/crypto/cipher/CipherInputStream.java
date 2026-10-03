package com.trilead.ssh2.crypto.cipher;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class CipherInputStream {
    InputStream bi;
    int blockSize;
    byte[] buffer;
    BlockCipher currentCipher;
    byte[] enc;
    int pos;
    final int BUFF_SIZE = 2048;
    byte[] input_buffer = new byte[2048];
    int input_buffer_pos = 0;
    int input_buffer_size = 0;

    public CipherInputStream(BlockCipher blockCipher, InputStream inputStream) {
        this.bi = inputStream;
        changeCipher(blockCipher);
    }

    private int fill_buffer() throws IOException {
        this.input_buffer_pos = 0;
        int i = this.bi.read(this.input_buffer, 0, 2048);
        this.input_buffer_size = i;
        return i;
    }

    private void getBlock() throws IOException {
        int i = 0;
        while (true) {
            int i2 = this.blockSize;
            if (i >= i2) {
                try {
                    this.currentCipher.transformBlock(this.enc, 0, this.buffer, 0);
                    this.pos = 0;
                    return;
                } catch (Exception unused) {
                    throw new IOException("Error while decrypting block.");
                }
            } else {
                int iInternal_read = internal_read(this.enc, i, i2 - i);
                if (iInternal_read < 0) {
                    throw new IOException("Cannot read full block, EOF reached.");
                }
                i += iInternal_read;
            }
        }
    }

    private int internal_read(byte[] bArr, int i, int i2) {
        int i3 = this.input_buffer_size;
        if (i3 < 0) {
            return -1;
        }
        if (this.input_buffer_pos >= i3 && fill_buffer() <= 0) {
            return -1;
        }
        int i4 = this.input_buffer_size;
        int i5 = this.input_buffer_pos;
        int i6 = i4 - i5;
        if (i2 > i6) {
            i2 = i6;
        }
        System.arraycopy(this.input_buffer, i5, bArr, i, i2);
        this.input_buffer_pos += i2;
        return i2;
    }

    public void changeCipher(BlockCipher blockCipher) {
        this.currentCipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new byte[blockSize];
        this.enc = new byte[blockSize];
        this.pos = blockSize;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int readPlain(byte[] bArr, int i, int i2) throws IOException {
        if (this.pos != this.blockSize) {
            throw new IOException("Cannot read plain since crypto buffer is not aligned.");
        }
        int i3 = 0;
        while (i3 < i2) {
            int iInternal_read = internal_read(bArr, i + i3, i2 - i3);
            if (iInternal_read < 0) {
                throw new IOException("Cannot fill buffer, EOF reached.");
            }
            i3 += iInternal_read;
        }
        return i3;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i2 > 0) {
            if (this.pos >= this.blockSize) {
                getBlock();
            }
            int iMin = Math.min(this.blockSize - this.pos, i2);
            System.arraycopy(this.buffer, this.pos, bArr, i, iMin);
            this.pos += iMin;
            i += iMin;
            i2 -= iMin;
            i3 += iMin;
        }
        return i3;
    }

    public int read() throws IOException {
        if (this.pos >= this.blockSize) {
            getBlock();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i] & 255;
    }
}
