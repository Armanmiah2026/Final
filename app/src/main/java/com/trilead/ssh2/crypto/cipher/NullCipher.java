package com.trilead.ssh2.crypto.cipher;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class NullCipher implements BlockCipher {
    private int blockSize;

    public NullCipher() {
        this.blockSize = 8;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        System.arraycopy(bArr, i, bArr2, i2, this.blockSize);
    }

    public NullCipher(int i) {
        this.blockSize = i;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr) {
    }
}
