package net.i2p.crypto.eddsa.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSAGenParameterSpec implements AlgorithmParameterSpec {
    private final String name;

    public EdDSAGenParameterSpec(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
