package com.trilead.ssh2.crypto;

import java.security.KeyPair;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CertificateDecoder {
    public abstract KeyPair createKeyPair(PEMStructure pEMStructure);

    public KeyPair createKeyPair(PEMStructure pEMStructure, String str) {
        return createKeyPair(pEMStructure);
    }

    public abstract String getEndLine();

    public abstract String getStartLine();
}
