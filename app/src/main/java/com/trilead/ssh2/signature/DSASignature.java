package com.trilead.ssh2.signature;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DSASignature {
    private final BigInteger r;
    private final BigInteger s;

    public DSASignature(BigInteger bigInteger, BigInteger bigInteger2) {
        this.r = bigInteger;
        this.s = bigInteger2;
    }

    public BigInteger getR() {
        return this.r;
    }

    public BigInteger getS() {
        return this.s;
    }
}
