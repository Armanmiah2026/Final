package com.trilead.ssh2.signature;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RSAPublicKey {
    BigInteger e;
    BigInteger n;

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.e = bigInteger;
        this.n = bigInteger2;
    }

    public BigInteger getE() {
        return this.e;
    }

    public BigInteger getN() {
        return this.n;
    }
}
