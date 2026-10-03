package com.trilead.ssh2.crypto.cipher;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface BlockCipher {
    int getBlockSize();

    void init(boolean z, byte[] bArr);

    void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2);
}
