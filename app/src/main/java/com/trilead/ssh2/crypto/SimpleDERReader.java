package com.trilead.ssh2.crypto;

import java.io.IOException;
import java.math.BigInteger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleDERReader {
    byte[] buffer;
    int count;
    int pos;

    public SimpleDERReader(byte[] bArr) {
        resetInput(bArr);
    }

    private byte readByte() throws IOException {
        int i = this.count;
        if (i <= 0) {
            throw new IOException("DER byte array: out of data");
        }
        this.count = i - 1;
        byte[] bArr = this.buffer;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return bArr[i2];
    }

    private byte[] readBytes(int i) throws IOException {
        if (i > this.count) {
            throw new IOException("DER byte array: out of data");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, this.pos, bArr, 0, i);
        this.pos += i;
        this.count -= i;
        return bArr;
    }

    private int readLength() throws IOException {
        byte b = readByte();
        int i = b & 255;
        if ((b & 128) == 0) {
            return i;
        }
        int i2 = b & 127;
        if (i2 == 0 || i2 > 4) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            i3 = (i3 << 8) | (readByte() & 255);
            i2--;
        }
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    public int available() {
        return this.count;
    }

    public int ignoreNextObject() throws IOException {
        int i = readByte() & 255;
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(za0.i(length, "Illegal len in DER object (", ")"));
        }
        readBytes(length);
        return i;
    }

    public SimpleDERReader readConstructed() throws IOException {
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(za0.i(length, "Illegal length in DER object (", ")"));
        }
        SimpleDERReader simpleDERReader = new SimpleDERReader(this.buffer, this.pos, length);
        this.pos += length;
        this.count -= length;
        return simpleDERReader;
    }

    public int readConstructedType() throws IOException {
        byte b = readByte();
        int i = b & 255;
        if ((b & 32) == 32) {
            return b & 31;
        }
        throw new IOException(za0.h(i, "Expected constructed type, but was "));
    }

    public BigInteger readInt() throws IOException {
        int i = readByte() & 255;
        if (i != 2) {
            throw new IOException(za0.h(i, "Expected DER Integer, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(za0.i(length, "Illegal len in DER object (", ")"));
        }
        return new BigInteger(1, readBytes(length));
    }

    public byte[] readOctetString() throws IOException {
        int i = readByte() & 255;
        if (i != 4 && i != 3) {
            throw new IOException(za0.h(i, "Expected DER Octetstring, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(za0.i(length, "Illegal len in DER object (", ")"));
        }
        return readBytes(length);
    }

    public String readOid() throws IOException {
        int i = readByte() & 255;
        if (i != 6) {
            throw new IOException(za0.h(i, "Expected DER OID, but found type "));
        }
        int length = readLength();
        if (length < 1 || length > available()) {
            throw new IOException(za0.i(length, "Illegal len in DER object (", ")"));
        }
        byte[] bytes = readBytes(length);
        StringBuilder sb = new StringBuilder(64);
        int i2 = bytes[0] / 40;
        if (i2 == 0) {
            sb.append('0');
        } else if (i2 != 1) {
            sb.append('2');
            bytes[0] = (byte) (bytes[0] - 80);
        } else {
            sb.append('1');
            bytes[0] = (byte) (bytes[0] - 40);
        }
        long j = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b = bytes[i3];
            j = (j << 7) + ((long) (b & 127));
            if ((b & 128) == 0) {
                sb.append('.');
                sb.append(j);
                j = 0;
            }
        }
        return sb.toString();
    }

    public byte[] readSequenceAsByteArray() throws IOException {
        int i = readByte() & 255;
        if (i != 48) {
            throw new IOException(za0.h(i, "Expected DER Sequence, but found type "));
        }
        int length = readLength();
        if (length < 0 || length > available()) {
            throw new IOException(za0.i(length, "Illegal len in DER object (", ")"));
        }
        return readBytes(length);
    }

    public void resetInput(byte[] bArr) {
        resetInput(bArr, 0, bArr.length);
    }

    public void resetInput(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.pos = i;
        this.count = i2;
    }

    public SimpleDERReader(byte[] bArr, int i, int i2) {
        resetInput(bArr, i, i2);
    }
}
