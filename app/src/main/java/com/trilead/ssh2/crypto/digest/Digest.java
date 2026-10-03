package com.trilead.ssh2.crypto.digest;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface Digest {
    void digest(byte[] bArr);

    void digest(byte[] bArr, int i);

    int getDigestLength();

    void reset();

    void update(byte b);

    void update(byte[] bArr);

    void update(byte[] bArr, int i, int i2);
}
