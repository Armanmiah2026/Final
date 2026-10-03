package com.trilead.ssh2.crypto.digest;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class MD5 implements Digest {
    private static final byte[] padding = {-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private long count;
    private int state0;
    private int state1;
    private int state2;
    private int state3;
    private final byte[] block = new byte[64];
    private final int[] x = new int[16];

    public MD5() {
        reset();
    }

    private static int FF(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int iF = za0.f((i3 & i2) | (i4 & (~i2)), i5, i7, i);
        return ((iF >>> (32 - i6)) | (iF << i6)) + i2;
    }

    private static int GG(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int iF = za0.f((i3 & (~i4)) | (i2 & i4), i5, i7, i);
        return ((iF >>> (32 - i6)) | (iF << i6)) + i2;
    }

    private static int HH(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int iF = za0.f((i3 ^ i2) ^ i4, i5, i7, i);
        return ((iF >>> (32 - i6)) | (iF << i6)) + i2;
    }

    private static int II(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int iF = za0.f(i3 ^ ((~i4) | i2), i5, i7, i);
        return ((iF >>> (32 - i6)) | (iF << i6)) + i2;
    }

    private static void encode(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private void transform(byte[] bArr, int i) {
        int i2 = this.state0;
        int i3 = this.state1;
        int i4 = this.state2;
        int i5 = this.state3;
        int i6 = i;
        int i7 = 0;
        while (i7 < 16) {
            this.x[i7] = ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255) | ((bArr[i6 + 3] & 255) << 24);
            i7++;
            i6 += 4;
        }
        int iFF = FF(i2, i3, i4, i5, this.x[0], 7, -680876936);
        int iFF2 = FF(i5, iFF, i3, i4, this.x[1], 12, -389564586);
        int iFF3 = FF(i4, iFF2, iFF, i3, this.x[2], 17, 606105819);
        int iFF4 = FF(i3, iFF3, iFF2, iFF, this.x[3], 22, -1044525330);
        int iFF5 = FF(iFF, iFF4, iFF3, iFF2, this.x[4], 7, -176418897);
        int iFF6 = FF(iFF2, iFF5, iFF4, iFF3, this.x[5], 12, 1200080426);
        int iFF7 = FF(iFF3, iFF6, iFF5, iFF4, this.x[6], 17, -1473231341);
        int iFF8 = FF(iFF4, iFF7, iFF6, iFF5, this.x[7], 22, -45705983);
        int iFF9 = FF(iFF5, iFF8, iFF7, iFF6, this.x[8], 7, 1770035416);
        int iFF10 = FF(iFF6, iFF9, iFF8, iFF7, this.x[9], 12, -1958414417);
        int iFF11 = FF(iFF7, iFF10, iFF9, iFF8, this.x[10], 17, -42063);
        int iFF12 = FF(iFF8, iFF11, iFF10, iFF9, this.x[11], 22, -1990404162);
        int iFF13 = FF(iFF9, iFF12, iFF11, iFF10, this.x[12], 7, 1804603682);
        int iFF14 = FF(iFF10, iFF13, iFF12, iFF11, this.x[13], 12, -40341101);
        int iFF15 = FF(iFF11, iFF14, iFF13, iFF12, this.x[14], 17, -1502002290);
        int iFF16 = FF(iFF12, iFF15, iFF14, iFF13, this.x[15], 22, 1236535329);
        int iGG = GG(iFF13, iFF16, iFF15, iFF14, this.x[1], 5, -165796510);
        int iGG2 = GG(iFF14, iGG, iFF16, iFF15, this.x[6], 9, -1069501632);
        int iGG3 = GG(iFF15, iGG2, iGG, iFF16, this.x[11], 14, 643717713);
        int iGG4 = GG(iFF16, iGG3, iGG2, iGG, this.x[0], 20, -373897302);
        int iGG5 = GG(iGG, iGG4, iGG3, iGG2, this.x[5], 5, -701558691);
        int iGG6 = GG(iGG2, iGG5, iGG4, iGG3, this.x[10], 9, 38016083);
        int iGG7 = GG(iGG3, iGG6, iGG5, iGG4, this.x[15], 14, -660478335);
        int iGG8 = GG(iGG4, iGG7, iGG6, iGG5, this.x[4], 20, -405537848);
        int iGG9 = GG(iGG5, iGG8, iGG7, iGG6, this.x[9], 5, 568446438);
        int iGG10 = GG(iGG6, iGG9, iGG8, iGG7, this.x[14], 9, -1019803690);
        int iGG11 = GG(iGG7, iGG10, iGG9, iGG8, this.x[3], 14, -187363961);
        int iGG12 = GG(iGG8, iGG11, iGG10, iGG9, this.x[8], 20, 1163531501);
        int iGG13 = GG(iGG9, iGG12, iGG11, iGG10, this.x[13], 5, -1444681467);
        int iGG14 = GG(iGG10, iGG13, iGG12, iGG11, this.x[2], 9, -51403784);
        int iGG15 = GG(iGG11, iGG14, iGG13, iGG12, this.x[7], 14, 1735328473);
        int iGG16 = GG(iGG12, iGG15, iGG14, iGG13, this.x[12], 20, -1926607734);
        int iHH = HH(iGG13, iGG16, iGG15, iGG14, this.x[5], 4, -378558);
        int iHH2 = HH(iGG14, iHH, iGG16, iGG15, this.x[8], 11, -2022574463);
        int iHH3 = HH(iGG15, iHH2, iHH, iGG16, this.x[11], 16, 1839030562);
        int iHH4 = HH(iGG16, iHH3, iHH2, iHH, this.x[14], 23, -35309556);
        int iHH5 = HH(iHH, iHH4, iHH3, iHH2, this.x[1], 4, -1530992060);
        int iHH6 = HH(iHH2, iHH5, iHH4, iHH3, this.x[4], 11, 1272893353);
        int iHH7 = HH(iHH3, iHH6, iHH5, iHH4, this.x[7], 16, -155497632);
        int iHH8 = HH(iHH4, iHH7, iHH6, iHH5, this.x[10], 23, -1094730640);
        int iHH9 = HH(iHH5, iHH8, iHH7, iHH6, this.x[13], 4, 681279174);
        int iHH10 = HH(iHH6, iHH9, iHH8, iHH7, this.x[0], 11, -358537222);
        int iHH11 = HH(iHH7, iHH10, iHH9, iHH8, this.x[3], 16, -722521979);
        int iHH12 = HH(iHH8, iHH11, iHH10, iHH9, this.x[6], 23, 76029189);
        int iHH13 = HH(iHH9, iHH12, iHH11, iHH10, this.x[9], 4, -640364487);
        int iHH14 = HH(iHH10, iHH13, iHH12, iHH11, this.x[12], 11, -421815835);
        int iHH15 = HH(iHH11, iHH14, iHH13, iHH12, this.x[15], 16, 530742520);
        int iHH16 = HH(iHH12, iHH15, iHH14, iHH13, this.x[2], 23, -995338651);
        int iII = II(iHH13, iHH16, iHH15, iHH14, this.x[0], 6, -198630844);
        int iII2 = II(iHH14, iII, iHH16, iHH15, this.x[7], 10, 1126891415);
        int iII3 = II(iHH15, iII2, iII, iHH16, this.x[14], 15, -1416354905);
        int iII4 = II(iHH16, iII3, iII2, iII, this.x[5], 21, -57434055);
        int iII5 = II(iII, iII4, iII3, iII2, this.x[12], 6, 1700485571);
        int iII6 = II(iII2, iII5, iII4, iII3, this.x[3], 10, -1894986606);
        int iII7 = II(iII3, iII6, iII5, iII4, this.x[10], 15, -1051523);
        int iII8 = II(iII4, iII7, iII6, iII5, this.x[1], 21, -2054922799);
        int iII9 = II(iII5, iII8, iII7, iII6, this.x[8], 6, 1873313359);
        int iII10 = II(iII6, iII9, iII8, iII7, this.x[15], 10, -30611744);
        int iII11 = II(iII7, iII10, iII9, iII8, this.x[6], 15, -1560198380);
        int iII12 = II(iII8, iII11, iII10, iII9, this.x[13], 21, 1309151649);
        int iII13 = II(iII9, iII12, iII11, iII10, this.x[4], 6, -145523070);
        int iII14 = II(iII10, iII13, iII12, iII11, this.x[11], 10, -1120210379);
        int iII15 = II(iII11, iII14, iII13, iII12, this.x[2], 15, 718787259);
        int iII16 = II(iII12, iII15, iII14, iII13, this.x[9], 21, -343485551);
        this.state0 += iII13;
        this.state1 += iII16;
        this.state2 += iII15;
        this.state3 += iII14;
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr, int i) {
        byte[] bArr2 = new byte[8];
        encode(bArr2, 0, (int) (this.count << 3));
        encode(bArr2, 4, (int) (this.count >> 29));
        int i2 = ((int) this.count) & 63;
        update(padding, 0, i2 < 56 ? 56 - i2 : 120 - i2);
        update(bArr2, 0, 8);
        encode(bArr, i, this.state0);
        encode(bArr, i + 4, this.state1);
        encode(bArr, i + 8, this.state2);
        encode(bArr, i + 12, this.state3);
        reset();
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public int getDigestLength() {
        return 16;
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void reset() {
        this.count = 0L;
        this.state0 = 1732584193;
        this.state1 = -271733879;
        this.state2 = -1732584194;
        this.state3 = 271733878;
        for (int i = 0; i < 16; i++) {
            this.x[i] = 0;
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte b) {
        long j = this.count;
        int i = 64 - ((int) (63 & j));
        this.count = j + 1;
        byte[] bArr = this.block;
        bArr[64 - i] = b;
        if (i == 1) {
            transform(bArr, 0);
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr, int i, int i2) {
        long j = this.count;
        int i3 = 64 - ((int) (63 & j));
        this.count = j + ((long) i2);
        while (i2 > 0) {
            if (i2 < i3) {
                System.arraycopy(bArr, i, this.block, 64 - i3, i2);
                return;
            }
            if (i3 == 64) {
                transform(bArr, i);
            } else {
                System.arraycopy(bArr, i, this.block, 64 - i3, i3);
                transform(this.block, 0);
            }
            i += i3;
            i2 -= i3;
            i3 = 64;
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr) {
        digest(bArr, 0);
    }
}
