package com.trilead.ssh2.crypto.cipher;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class CipherOutputStream {
    int blockSize;
    OutputStream bo;
    byte[] buffer;
    BlockCipher currentCipher;
    byte[] enc;
    int pos;
    final int BUFF_SIZE = 2048;
    byte[] out_buffer = new byte[2048];
    int out_buffer_pos = 0;

    public CipherOutputStream(BlockCipher blockCipher, OutputStream outputStream) {
        this.bo = outputStream;
        changeCipher(blockCipher);
    }

    private void internal_write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = this.out_buffer_pos;
            int i4 = 2048 - i3;
            if (i2 <= i4) {
                i4 = i2;
            }
            System.arraycopy(bArr, i, this.out_buffer, i3, i4);
            i += i4;
            int i5 = this.out_buffer_pos + i4;
            this.out_buffer_pos = i5;
            i2 -= i4;
            if (i5 >= 2048) {
                this.bo.write(this.out_buffer, 0, 2048);
                this.out_buffer_pos = 0;
            }
        }
    }

    private void writeBlock() throws IOException {
        try {
            this.currentCipher.transformBlock(this.buffer, 0, this.enc, 0);
            internal_write(this.enc, 0, this.blockSize);
            this.pos = 0;
        } catch (Exception e) {
            throw new IOException("Error while decrypting block.", e);
        }
    }

    public void changeCipher(BlockCipher blockCipher) {
        this.currentCipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new byte[blockSize];
        this.enc = new byte[blockSize];
        this.pos = 0;
    }

    public void flush() throws IOException {
        if (this.pos != 0) {
            throw new IOException("FATAL: cannot flush since crypto buffer is not aligned.");
        }
        int i = this.out_buffer_pos;
        if (i > 0) {
            this.bo.write(this.out_buffer, 0, i);
            this.out_buffer_pos = 0;
        }
        this.bo.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int iMin = Math.min(this.blockSize - this.pos, i2);
            System.arraycopy(bArr, i, this.buffer, this.pos, iMin);
            int i3 = this.pos + iMin;
            this.pos = i3;
            i += iMin;
            i2 -= iMin;
            if (i3 >= this.blockSize) {
                writeBlock();
            }
        }
    }

    public void writePlain(int i) throws IOException {
        if (this.pos != 0) {
            throw new IOException("Cannot write plain since crypto buffer is not aligned.");
        }
        internal_write(i);
    }

    public void writePlain(byte[] bArr, int i, int i2) throws IOException {
        if (this.pos == 0) {
            internal_write(bArr, i, i2);
            return;
        }
        throw new IOException("Cannot write plain since crypto buffer is not aligned.");
    }

    private void internal_write(int i) throws IOException {
        byte[] bArr = this.out_buffer;
        int i2 = this.out_buffer_pos;
        int i3 = i2 + 1;
        this.out_buffer_pos = i3;
        bArr[i2] = (byte) i;
        if (i3 >= 2048) {
            this.bo.write(bArr, 0, 2048);
            this.out_buffer_pos = 0;
        }
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) i;
        if (i3 >= this.blockSize) {
            writeBlock();
        }
    }
}
