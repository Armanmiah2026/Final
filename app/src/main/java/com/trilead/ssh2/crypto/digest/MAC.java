package com.trilead.ssh2.crypto.digest;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class MAC {

    @Deprecated
    Digest mac;

    @Deprecated
    int size;

    @Deprecated
    public MAC(String str, byte[] bArr) {
        if (str.equals("hmac-sha1")) {
            this.mac = new HMAC(new SHA1(), bArr, 20);
        } else if (str.equals("hmac-sha1-96")) {
            this.mac = new HMAC(new SHA1(), bArr, 12);
        } else if (str.equals("hmac-md5")) {
            this.mac = new HMAC(new MD5(), bArr, 16);
        } else if (!str.equals("hmac-md5-96")) {
            return;
        } else {
            this.mac = new HMAC(new MD5(), bArr, 12);
        }
        this.size = this.mac.getDigestLength();
    }

    @Deprecated
    public static void checkMacList(String[] strArr) {
        for (String str : strArr) {
            getKeyLen(str);
        }
    }

    @Deprecated
    public static int getKeyLen(String str) {
        if (str.equals("hmac-sha1") || str.equals("hmac-sha1-96")) {
            return 20;
        }
        if (str.equals("hmac-md5") || str.equals("hmac-md5-96")) {
            return 16;
        }
        throw new IllegalArgumentException("Unkown algorithm ".concat(str));
    }

    @Deprecated
    public static String[] getMacList() {
        return new String[]{"hmac-sha1-96", "hmac-sha1", "hmac-md5-96", "hmac-md5"};
    }

    public void getMac(byte[] bArr, int i) {
        this.mac.digest(bArr, i);
    }

    public void initMac(int i) {
        this.mac.reset();
        this.mac.update((byte) (i >> 24));
        this.mac.update((byte) (i >> 16));
        this.mac.update((byte) (i >> 8));
        this.mac.update((byte) i);
    }

    public int size() {
        return this.size;
    }

    public void update(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}
