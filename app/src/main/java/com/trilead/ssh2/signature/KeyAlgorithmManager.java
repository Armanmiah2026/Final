package com.trilead.ssh2.signature;

import com.trilead.ssh2.signature.ECDSAKeyAlgorithm;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyAlgorithmManager {
    private static final Collection<KeyAlgorithm<PublicKey, PrivateKey>> supportedAlgorithms = buildSupportAlgorithmsList();

    private KeyAlgorithmManager() {
    }

    private static Collection<KeyAlgorithm<PublicKey, PrivateKey>> buildSupportAlgorithmsList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ED25519KeyAlgorithm());
        try {
            KeyFactory.getInstance("EC");
            arrayList.add(new ECDSAKeyAlgorithm.ECDSASha2Nistp521());
            arrayList.add(new ECDSAKeyAlgorithm.ECDSASha2Nistp384());
            arrayList.add(new ECDSAKeyAlgorithm.ECDSASha2Nistp256());
        } catch (GeneralSecurityException unused) {
        }
        arrayList.add(new RSAKeyAlgorithm());
        arrayList.add(new DSAKeyAlgorithm());
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<KeyAlgorithm<PublicKey, PrivateKey>> getSupportedAlgorithms() {
        return supportedAlgorithms;
    }
}
