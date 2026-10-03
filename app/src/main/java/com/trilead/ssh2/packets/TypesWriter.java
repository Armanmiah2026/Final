package com.trilead.ssh2.packets;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class TypesWriter {
    byte[] arr = new byte[256];
    int pos = 0;

    private void resize(int i) {
        byte[] bArr = new byte[i];
        byte[] bArr2 = this.arr;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.arr = bArr;
    }

    public byte[] getBytes() {
        int i = this.pos;
        byte[] bArr = new byte[i];
        System.arraycopy(this.arr, 0, bArr, 0, i);
        return bArr;
    }

    public int length() {
        return this.pos;
    }

    public void writeBoolean(boolean z) {
        int i = this.pos + 1;
        byte[] bArr = this.arr;
        if (i > bArr.length) {
            resize(bArr.length + 32);
        }
        byte[] bArr2 = this.arr;
        int i2 = this.pos;
        this.pos = i2 + 1;
        bArr2[i2] = z ? (byte) 1 : (byte) 0;
    }

    public void writeByte(int i, int i2) {
        if (i2 + 1 > this.arr.length) {
            resize(i2 + 32);
        }
        this.arr[i2] = (byte) i;
    }

    public void writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
    }

    public void writeMPInt(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == 1 && byteArray[0] == 0) {
            writeUINT32(0);
        } else {
            writeString(byteArray, 0, byteArray.length);
        }
    }

    public void writeNameList(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append(strArr[i]);
        }
        writeString(stringBuffer.toString());
    }

    public void writeString(byte[] bArr, int i, int i2) {
        writeUINT32(i2);
        writeBytes(bArr, i, i2);
    }

    public void writeUINT32(int i, int i2) {
        if (i2 + 4 > this.arr.length) {
            resize(i2 + 32);
        }
        byte[] bArr = this.arr;
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public void writeUINT64(long j) {
        int i = this.pos + 8;
        byte[] bArr = this.arr;
        if (i > bArr.length) {
            resize(bArr.length + 32);
        }
        byte[] bArr2 = this.arr;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr2[i2] = (byte) (j >> 56);
        int i4 = i2 + 2;
        this.pos = i4;
        bArr2[i3] = (byte) (j >> 48);
        int i5 = i2 + 3;
        this.pos = i5;
        bArr2[i4] = (byte) (j >> 40);
        int i6 = i2 + 4;
        this.pos = i6;
        bArr2[i5] = (byte) (j >> 32);
        int i7 = i2 + 5;
        this.pos = i7;
        bArr2[i6] = (byte) (j >> 24);
        int i8 = i2 + 6;
        this.pos = i8;
        bArr2[i7] = (byte) (j >> 16);
        int i9 = i2 + 7;
        this.pos = i9;
        bArr2[i8] = (byte) (j >> 8);
        this.pos = i2 + 8;
        bArr2[i9] = (byte) j;
    }

    public void writeBytes(byte[] bArr, int i, int i2) {
        int i3 = this.pos + i2;
        byte[] bArr2 = this.arr;
        if (i3 > bArr2.length) {
            resize(bArr2.length + i2 + 32);
        }
        System.arraycopy(bArr, i, this.arr, this.pos, i2);
        this.pos += i2;
    }

    public void getBytes(byte[] bArr) {
        System.arraycopy(this.arr, 0, bArr, 0, this.pos);
    }

    public void writeString(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        writeUINT32(bytes.length);
        writeBytes(bytes, 0, bytes.length);
    }

    public void writeByte(int i) {
        writeByte(i, this.pos);
        this.pos++;
    }

    public void writeString(String str, String str2) {
        byte[] bytes = str2 == null ? str.getBytes() : str.getBytes(str2);
        writeUINT32(bytes.length);
        writeBytes(bytes, 0, bytes.length);
    }

    public void writeUINT32(int i) {
        writeUINT32(i, this.pos);
        this.pos += 4;
    }
}
