package com.trilead.ssh2.signature;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RSAPrivateKey {
    private final BigInteger d;
    private final BigInteger e;
    private final BigInteger n;

    public RSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.d = bigInteger;
        this.e = bigInteger2;
        this.n = bigInteger3;
    }

    public BigInteger getD() {
        return this.d;
    }

    public BigInteger getE() {
        return this.e;
    }

    public BigInteger getN() {
        return this.n;
    }

    public RSAPublicKey getPublicKey() {
        return new RSAPublicKey(this.e, this.n);
    }

    public KeyPair toJCEKeyPair() throws NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return new KeyPair(keyFactory.generatePublic(new RSAPublicKeySpec(getN(), getE())), keyFactory.generatePrivate(new RSAPrivateKeySpec(getN(), getD())));
    }
}
