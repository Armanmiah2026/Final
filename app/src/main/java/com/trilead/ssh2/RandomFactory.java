package com.trilead.ssh2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
class RandomFactory {
    public static SecureRandom create() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            return new SecureRandom();
        }
    }
}
