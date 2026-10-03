package com.trilead.ssh2.signature;

import com.trilead.ssh2.crypto.CertificateDecoder;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class KeyAlgorithm<U extends PublicKey, R extends PrivateKey> {
    private final String keyFormat;
    private final Class<R> keyType;
    private final Provider provider;
    private final String signatureAlgorithm;

    public KeyAlgorithm(String str, String str2, Class<R> cls) {
        this(str, str2, cls, null);
    }

    public abstract U decodePublicKey(byte[] bArr);

    public abstract byte[] decodeSignature(byte[] bArr);

    public abstract byte[] encodePublicKey(U u);

    public abstract byte[] encodeSignature(byte[] bArr);

    public byte[] generateSignature(byte[] bArr, R r, SecureRandom secureRandom) throws IOException {
        try {
            Provider provider = this.provider;
            Signature signature = provider == null ? Signature.getInstance(this.signatureAlgorithm) : Signature.getInstance(this.signatureAlgorithm, provider);
            signature.initSign(r, secureRandom);
            signature.update(bArr);
            return signature.sign();
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not generate signature", e);
        }
    }

    public abstract List<CertificateDecoder> getCertificateDecoders();

    public String getKeyFormat() {
        return this.keyFormat;
    }

    public boolean supportsKey(PrivateKey privateKey) {
        return this.keyType.isAssignableFrom(privateKey.getClass());
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, U u) throws IOException {
        try {
            Provider provider = this.provider;
            Signature signature = provider == null ? Signature.getInstance(this.signatureAlgorithm) : Signature.getInstance(this.signatureAlgorithm, provider);
            signature.initVerify(u);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not verify signature", e);
        }
    }

    public KeyAlgorithm(String str, String str2, Class<R> cls, Provider provider) {
        this.signatureAlgorithm = str;
        this.keyFormat = str2;
        this.keyType = cls;
        this.provider = provider;
    }
}
