package com.trilead.ssh2.packets;

import com.trilead.ssh2.util.Tokenizer;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class TypesReader {
    byte[] arr;
    int max;
    int pos;

    public TypesReader(byte[] bArr) {
        this.max = 0;
        this.arr = bArr;
        this.pos = 0;
        this.max = bArr.length;
    }

    public boolean readBoolean() throws IOException {
        int i = this.pos;
        if (i >= this.max) {
            throw new IOException("Packet too short.");
        }
        byte[] bArr = this.arr;
        this.pos = i + 1;
        return bArr[i] != 0;
    }

    public int readByte() throws IOException {
        int i = this.pos;
        if (i >= this.max) {
            throw new IOException("Packet too short.");
        }
        byte[] bArr = this.arr;
        this.pos = i + 1;
        return bArr[i] & 255;
    }

    public byte[] readByteString() throws IOException {
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i > this.max) {
            throw new IOException("Malformed SSH byte string.");
        }
        byte[] bArr = new byte[uint32];
        System.arraycopy(this.arr, i, bArr, 0, uint32);
        this.pos += uint32;
        return bArr;
    }

    public byte[] readBytes(int i) throws IOException {
        int i2 = this.pos;
        if (i2 + i > this.max) {
            throw new IOException("Packet too short.");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.arr, i2, bArr, 0, i);
        this.pos += i;
        return bArr;
    }

    public BigInteger readMPINT() throws IOException {
        byte[] byteString = readByteString();
        return byteString.length == 0 ? BigInteger.ZERO : new BigInteger(byteString);
    }

    public String[] readNameList() {
        return Tokenizer.parseTokens(readString(), ',');
    }

    public String readString(String str) throws IOException {
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i > this.max) {
            throw new IOException("Malformed SSH string.");
        }
        String str2 = str == null ? new String(this.arr, i, uint32) : new String(this.arr, i, uint32, str);
        this.pos += uint32;
        return str2;
    }

    public int readUINT32() throws IOException {
        int i = this.pos;
        if (i + 4 > this.max) {
            throw new IOException("Packet too short.");
        }
        byte[] bArr = this.arr;
        int i2 = i + 1;
        this.pos = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i + 2;
        this.pos = i4;
        int i5 = ((bArr[i2] & 255) << 16) | i3;
        int i6 = i + 3;
        this.pos = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.pos = i + 4;
        return (bArr[i6] & 255) | i7;
    }

    public long readUINT64() throws IOException {
        int i = this.pos;
        if (i + 8 > this.max) {
            throw new IOException("Packet too short.");
        }
        byte[] bArr = this.arr;
        int i2 = i + 1;
        this.pos = i2;
        long j = ((long) (bArr[i] & 255)) << 24;
        int i3 = i + 2;
        this.pos = i3;
        long j2 = j | ((long) ((bArr[i2] & 255) << 16));
        int i4 = i + 3;
        this.pos = i4;
        long j3 = j2 | ((long) ((bArr[i3] & 255) << 8));
        int i5 = i + 4;
        this.pos = i5;
        long j4 = j3 | ((long) (bArr[i4] & 255));
        int i6 = i + 5;
        this.pos = i6;
        long j5 = ((long) (bArr[i5] & 255)) << 24;
        int i7 = i + 6;
        this.pos = i7;
        long j6 = j5 | ((long) ((bArr[i6] & 255) << 16));
        int i8 = i + 7;
        this.pos = i8;
        long j7 = j6 | ((long) ((bArr[i7] & 255) << 8));
        this.pos = i + 8;
        return ((((long) (bArr[i8] & 255)) | j7) & 4294967295L) | (j4 << 32);
    }

    public int remain() {
        return this.max - this.pos;
    }

    public TypesReader(byte[] bArr, int i) {
        this.max = 0;
        this.arr = bArr;
        this.pos = i;
        this.max = bArr.length;
        if (i < 0 || i > bArr.length) {
            throw new IllegalArgumentException("Illegal offset.");
        }
    }

    public void readBytes(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.pos;
        if (i3 + i2 <= this.max) {
            System.arraycopy(this.arr, i3, bArr, i, i2);
            this.pos += i2;
            return;
        }
        throw new IOException("Packet too short.");
    }

    public String readString() throws IOException {
        int uint32 = readUINT32();
        int i = this.pos;
        if (uint32 + i <= this.max) {
            String str = new String(this.arr, i, uint32, StandardCharsets.ISO_8859_1);
            this.pos += uint32;
            return str;
        }
        throw new IOException("Malformed SSH string.");
    }

    public TypesReader(byte[] bArr, int i, int i2) {
        this.arr = bArr;
        this.pos = i;
        int i3 = i2 + i;
        this.max = i3;
        if (i >= 0 && i <= bArr.length) {
            if (i3 < 0 || i3 > bArr.length) {
                throw new IllegalArgumentException("Illegal length.");
            }
            return;
        }
        throw new IllegalArgumentException("Illegal offset.");
    }
}
