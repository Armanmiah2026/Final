package com.trilead.ssh2.signature;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DSAPrivateKey {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger x;
    private final BigInteger y;

    public DSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        this.p = bigInteger;
        this.q = bigInteger2;
        this.g = bigInteger3;
        this.y = bigInteger4;
        this.x = bigInteger5;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public DSAPublicKey getPublicKey() {
        return new DSAPublicKey(this.p, this.q, this.g, this.y);
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getX() {
        return this.x;
    }

    public BigInteger getY() {
        return this.y;
    }
}
