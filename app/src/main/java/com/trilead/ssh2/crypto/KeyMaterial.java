package com.trilead.ssh2.crypto;

import com.trilead.ssh2.crypto.digest.HashForSSH2Types;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyMaterial {
    public byte[] enc_key_client_to_server;
    public byte[] enc_key_server_to_client;
    public byte[] initial_iv_client_to_server;
    public byte[] initial_iv_server_to_client;
    public byte[] integrity_key_client_to_server;
    public byte[] integrity_key_server_to_client;

    private static byte[] calculateKey(HashForSSH2Types hashForSSH2Types, BigInteger bigInteger, byte[] bArr, byte b, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[i];
        int digestLength = hashForSSH2Types.getDigestLength();
        int i2 = ((i + digestLength) - 1) / digestLength;
        byte[][] bArr4 = new byte[i2][];
        hashForSSH2Types.reset();
        hashForSSH2Types.updateBigInt(bigInteger);
        hashForSSH2Types.updateBytes(bArr);
        hashForSSH2Types.updateByte(b);
        hashForSSH2Types.updateBytes(bArr2);
        bArr4[0] = hashForSSH2Types.getDigest();
        int iMin = Math.min(digestLength, i);
        System.arraycopy(bArr4[0], 0, bArr3, 0, iMin);
        int i3 = i - iMin;
        for (int i4 = 1; i4 < i2; i4++) {
            hashForSSH2Types.updateBigInt(bigInteger);
            hashForSSH2Types.updateBytes(bArr);
            for (int i5 = 0; i5 < i4; i5++) {
                hashForSSH2Types.updateBytes(bArr4[i5]);
            }
            bArr4[i4] = hashForSSH2Types.getDigest();
            int iMin2 = Math.min(digestLength, i3);
            System.arraycopy(bArr4[i4], 0, bArr3, iMin, iMin2);
            i3 -= iMin2;
            iMin += iMin2;
        }
        return bArr3;
    }

    public static KeyMaterial create(String str, byte[] bArr, BigInteger bigInteger, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        KeyMaterial keyMaterial = new KeyMaterial();
        HashForSSH2Types hashForSSH2Types = new HashForSSH2Types(str);
        keyMaterial.initial_iv_client_to_server = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 65, bArr2, i2);
        keyMaterial.initial_iv_server_to_client = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 66, bArr2, i5);
        keyMaterial.enc_key_client_to_server = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 67, bArr2, i);
        keyMaterial.enc_key_server_to_client = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 68, bArr2, i4);
        keyMaterial.integrity_key_client_to_server = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 69, bArr2, i3);
        keyMaterial.integrity_key_server_to_client = calculateKey(hashForSSH2Types, bigInteger, bArr, (byte) 70, bArr2, i6);
        return keyMaterial;
    }
}
