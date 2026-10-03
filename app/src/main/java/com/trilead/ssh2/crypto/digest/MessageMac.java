package com.trilead.ssh2.crypto.digest;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class MessageMac extends MAC {
    private final Mac messageMac;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public enum Hmac {
        HMAC_MD5_96("hmac-md5-96", "HmacMD5", 16),
        HMAC_MD5("hmac-md5", "HmacMD5", 16),
        HMAC_SHA1_96("hmac-sha1-96", "HmacSHA1", 20),
        HMAC_SHA1("hmac-sha1", "HmacSHA1", 20),
        HMAC_SHA2_256("hmac-sha2-256", "HmacSHA256", 32),
        HMAC_SHA2_512("hmac-sha2-512", "HmacSHA512", 64);

        private final String algorithm;
        private final int length;
        private final String type;

        Hmac(String str, String str2, int i) {
            this.type = str;
            this.algorithm = str2;
            this.length = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Hmac getHmac(String str) {
            for (Hmac hmac : values()) {
                if (hmac.getType().equals(str)) {
                    return hmac;
                }
            }
            throw new IllegalArgumentException(za0.s("Invalid HMAC type: ", str));
        }

        public String getAlgorithm() {
            return this.algorithm;
        }

        public int getLength() {
            return this.length;
        }

        public String getType() {
            return this.type;
        }
    }

    public MessageMac(String str, byte[] bArr) {
        super(str, bArr);
        try {
            Mac mac = Mac.getInstance(Hmac.getHmac(str).getAlgorithm());
            this.messageMac = mac;
            mac.init(new SecretKeySpec(bArr, str));
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Could not create Mac", e);
        }
    }

    public static void checkMacs(String[] strArr) {
        for (String str : strArr) {
            Hmac.getHmac(str);
        }
    }

    public static int getKeyLength(String str) {
        return Hmac.getHmac(str).getLength();
    }

    public static String[] getMacs() {
        ArrayList arrayList = new ArrayList();
        for (Hmac hmac : Hmac.values()) {
            arrayList.add(0, hmac.getType());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public void getMac(byte[] bArr, int i) {
        byte[] bArrDoFinal = this.messageMac.doFinal();
        System.arraycopy(bArrDoFinal, i, bArr, 0, bArrDoFinal.length - i);
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public void initMac(int i) {
        this.messageMac.reset();
        this.messageMac.update((byte) (i >> 24));
        this.messageMac.update((byte) (i >> 16));
        this.messageMac.update((byte) (i >> 8));
        this.messageMac.update((byte) i);
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public int size() {
        return this.messageMac.getMacLength();
    }

    @Override // com.trilead.ssh2.crypto.digest.MAC
    public void update(byte[] bArr, int i, int i2) {
        this.messageMac.update(bArr, i, i2);
    }
}
