package net.i2p.crypto.eddsa.math;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface ScalarOps {
    byte[] multiplyAndAdd(byte[] bArr, byte[] bArr2, byte[] bArr3);

    byte[] reduce(byte[] bArr);
}
