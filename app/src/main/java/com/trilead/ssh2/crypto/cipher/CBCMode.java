package com.trilead.ssh2.crypto.cipher;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class CBCMode implements BlockCipher {
    int blockSize;
    byte[] cbc_vector;
    boolean doEncrypt;
    BlockCipher tc;
    byte[] tmp_vector;

    public CBCMode(BlockCipher blockCipher, byte[] bArr, boolean z) {
        this.tc = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.doEncrypt = z;
        if (blockSize != bArr.length) {
            StringBuilder sb = new StringBuilder("IV must be ");
            sb.append(this.blockSize);
            sb.append(" bytes long! (currently ");
            throw new IllegalArgumentException(za0.n(sb, bArr.length, ")"));
        }
        byte[] bArr2 = new byte[blockSize];
        this.cbc_vector = bArr2;
        this.tmp_vector = new byte[blockSize];
        System.arraycopy(bArr, 0, bArr2, 0, blockSize);
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        System.arraycopy(bArr, i, this.tmp_vector, 0, this.blockSize);
        this.tc.transformBlock(bArr, i, bArr2, i2);
        for (int i3 = 0; i3 < this.blockSize; i3++) {
            int i4 = i2 + i3;
            bArr2[i4] = (byte) (bArr2[i4] ^ this.cbc_vector[i3]);
        }
        byte[] bArr3 = this.cbc_vector;
        this.cbc_vector = this.tmp_vector;
        this.tmp_vector = bArr3;
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < this.blockSize; i3++) {
            byte[] bArr3 = this.cbc_vector;
            bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
        }
        this.tc.transformBlock(this.cbc_vector, 0, bArr2, i2);
        System.arraycopy(bArr2, i2, this.cbc_vector, 0, this.blockSize);
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.doEncrypt) {
            encryptBlock(bArr, i, bArr2, i2);
        } else {
            decryptBlock(bArr, i, bArr2, i2);
        }
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr) {
    }
}
