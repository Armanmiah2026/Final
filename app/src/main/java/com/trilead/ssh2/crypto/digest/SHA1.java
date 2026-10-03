package com.trilead.ssh2.crypto.digest;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SHA1 implements Digest {
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private long currentLen;
    private int currentPos;
    private final int[] w = new int[80];

    public SHA1() {
        reset();
    }

    private void perform() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.w;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.H0;
        int i4 = this.H1;
        int i5 = this.H2;
        int i6 = this.H3;
        int i7 = this.H4;
        int i8 = ((i3 << 5) | (i3 >>> 27)) + ((i4 & i5) | ((~i4) & i6));
        int[] iArr2 = this.w;
        int iF = za0.f(i8, iArr2[0], 1518500249, i7);
        int i9 = (i4 << 30) | (i4 >>> 2);
        int iF2 = za0.f(((iF << 5) | (iF >>> 27)) + ((i3 & i9) | ((~i3) & i5)), iArr2[1], 1518500249, i6);
        int i10 = (i3 << 30) | (i3 >>> 2);
        int iF3 = za0.f(((iF2 << 5) | (iF2 >>> 27)) + (((~iF) & i9) | (iF & i10)), iArr2[2], 1518500249, i5);
        int i11 = (iF >>> 2) | (iF << 30);
        int iF4 = za0.f(((iF3 << 5) | (iF3 >>> 27)) + ((iF2 & i11) | ((~iF2) & i10)), iArr2[3], 1518500249, i9);
        int i12 = (iF2 << 30) | (iF2 >>> 2);
        int iF5 = za0.f(((iF4 << 5) | (iF4 >>> 27)) + (((~iF3) & i11) | (iF3 & i12)), iArr2[4], 1518500249, i10);
        int i13 = (iF3 << 30) | (iF3 >>> 2);
        int iF6 = za0.f(((iF5 << 5) | (iF5 >>> 27)) + ((iF4 & i13) | ((~iF4) & i12)), iArr2[5], 1518500249, i11);
        int i14 = (iF4 >>> 2) | (iF4 << 30);
        int iF7 = za0.f(((iF6 << 5) | (iF6 >>> 27)) + ((iF5 & i14) | ((~iF5) & i13)), iArr2[6], 1518500249, i12);
        int i15 = (iF5 >>> 2) | (iF5 << 30);
        int iF8 = za0.f(((iF7 << 5) | (iF7 >>> 27)) + ((iF6 & i15) | ((~iF6) & i14)), iArr2[7], 1518500249, i13);
        int i16 = (iF6 >>> 2) | (iF6 << 30);
        int iF9 = za0.f(((iF8 << 5) | (iF8 >>> 27)) + ((iF7 & i16) | ((~iF7) & i15)), iArr2[8], 1518500249, i14);
        int i17 = (iF7 >>> 2) | (iF7 << 30);
        int iF10 = za0.f(((iF9 << 5) | (iF9 >>> 27)) + ((iF8 & i17) | ((~iF8) & i16)), iArr2[9], 1518500249, i15);
        int i18 = (iF8 >>> 2) | (iF8 << 30);
        int iF11 = za0.f(((iF10 << 5) | (iF10 >>> 27)) + ((iF9 & i18) | ((~iF9) & i17)), iArr2[10], 1518500249, i16);
        int i19 = (iF9 >>> 2) | (iF9 << 30);
        int iF12 = za0.f(((iF11 << 5) | (iF11 >>> 27)) + ((iF10 & i19) | ((~iF10) & i18)), iArr2[11], 1518500249, i17);
        int i20 = (iF10 >>> 2) | (iF10 << 30);
        int iF13 = za0.f(((iF12 << 5) | (iF12 >>> 27)) + ((iF11 & i20) | ((~iF11) & i19)), iArr2[12], 1518500249, i18);
        int i21 = (iF11 >>> 2) | (iF11 << 30);
        int iF14 = za0.f(((iF13 << 5) | (iF13 >>> 27)) + ((iF12 & i21) | ((~iF12) & i20)), iArr2[13], 1518500249, i19);
        int i22 = (iF12 >>> 2) | (iF12 << 30);
        int iF15 = za0.f(((iF14 << 5) | (iF14 >>> 27)) + ((iF13 & i22) | ((~iF13) & i21)), iArr2[14], 1518500249, i20);
        int i23 = (iF13 >>> 2) | (iF13 << 30);
        int iF16 = za0.f(((iF15 << 5) | (iF15 >>> 27)) + ((iF14 & i23) | ((~iF14) & i22)), iArr2[15], 1518500249, i21);
        int i24 = (iF14 >>> 2) | (iF14 << 30);
        int iF17 = za0.f(((iF16 << 5) | (iF16 >>> 27)) + ((iF15 & i24) | ((~iF15) & i23)), iArr2[16], 1518500249, i22);
        int i25 = (iF15 >>> 2) | (iF15 << 30);
        int iF18 = za0.f(((iF17 << 5) | (iF17 >>> 27)) + ((iF16 & i25) | ((~iF16) & i24)), iArr2[17], 1518500249, i23);
        int i26 = (iF16 >>> 2) | (iF16 << 30);
        int iF19 = za0.f(((iF18 << 5) | (iF18 >>> 27)) + ((iF17 & i26) | ((~iF17) & i25)), iArr2[18], 1518500249, i24);
        int i27 = (iF17 >>> 2) | (iF17 << 30);
        int iF20 = za0.f(((iF19 << 5) | (iF19 >>> 27)) + ((iF18 & i27) | ((~iF18) & i26)), iArr2[19], 1518500249, i25);
        int i28 = (iF18 << 30) | (iF18 >>> 2);
        int iF21 = za0.f(((iF20 << 5) | (iF20 >>> 27)) + ((iF19 ^ i28) ^ i27), iArr2[20], 1859775393, i26);
        int i29 = (iF19 >>> 2) | (iF19 << 30);
        int iF22 = za0.f(((iF21 << 5) | (iF21 >>> 27)) + ((iF20 ^ i29) ^ i28), iArr2[21], 1859775393, i27);
        int i30 = (iF20 >>> 2) | (iF20 << 30);
        int iF23 = za0.f(((iF22 << 5) | (iF22 >>> 27)) + ((iF21 ^ i30) ^ i29), iArr2[22], 1859775393, i28);
        int i31 = (iF21 >>> 2) | (iF21 << 30);
        int iF24 = za0.f(((iF23 << 5) | (iF23 >>> 27)) + ((iF22 ^ i31) ^ i30), iArr2[23], 1859775393, i29);
        int i32 = (iF22 >>> 2) | (iF22 << 30);
        int iF25 = za0.f(((iF24 << 5) | (iF24 >>> 27)) + ((iF23 ^ i32) ^ i31), iArr2[24], 1859775393, i30);
        int i33 = (iF23 >>> 2) | (iF23 << 30);
        int iF26 = za0.f(((iF25 << 5) | (iF25 >>> 27)) + ((iF24 ^ i33) ^ i32), iArr2[25], 1859775393, i31);
        int i34 = (iF24 >>> 2) | (iF24 << 30);
        int iF27 = za0.f(((iF26 << 5) | (iF26 >>> 27)) + ((iF25 ^ i34) ^ i33), iArr2[26], 1859775393, i32);
        int i35 = (iF25 >>> 2) | (iF25 << 30);
        int iF28 = za0.f(((iF27 << 5) | (iF27 >>> 27)) + ((iF26 ^ i35) ^ i34), iArr2[27], 1859775393, i33);
        int i36 = (iF26 >>> 2) | (iF26 << 30);
        int iF29 = za0.f(((iF28 << 5) | (iF28 >>> 27)) + ((iF27 ^ i36) ^ i35), iArr2[28], 1859775393, i34);
        int i37 = (iF27 >>> 2) | (iF27 << 30);
        int iF30 = za0.f(((iF29 << 5) | (iF29 >>> 27)) + ((iF28 ^ i37) ^ i36), iArr2[29], 1859775393, i35);
        int i38 = (iF28 >>> 2) | (iF28 << 30);
        int iF31 = za0.f(((iF30 << 5) | (iF30 >>> 27)) + ((iF29 ^ i38) ^ i37), iArr2[30], 1859775393, i36);
        int i39 = (iF29 >>> 2) | (iF29 << 30);
        int iF32 = za0.f(((iF31 << 5) | (iF31 >>> 27)) + ((iF30 ^ i39) ^ i38), iArr2[31], 1859775393, i37);
        int i40 = (iF30 >>> 2) | (iF30 << 30);
        int iF33 = za0.f(((iF32 << 5) | (iF32 >>> 27)) + ((iF31 ^ i40) ^ i39), iArr2[32], 1859775393, i38);
        int i41 = (iF31 >>> 2) | (iF31 << 30);
        int iF34 = za0.f(((iF33 << 5) | (iF33 >>> 27)) + ((iF32 ^ i41) ^ i40), iArr2[33], 1859775393, i39);
        int i42 = (iF32 >>> 2) | (iF32 << 30);
        int iF35 = za0.f(((iF34 << 5) | (iF34 >>> 27)) + ((iF33 ^ i42) ^ i41), iArr2[34], 1859775393, i40);
        int i43 = (iF33 >>> 2) | (iF33 << 30);
        int iF36 = za0.f(((iF35 << 5) | (iF35 >>> 27)) + ((iF34 ^ i43) ^ i42), iArr2[35], 1859775393, i41);
        int i44 = (iF34 >>> 2) | (iF34 << 30);
        int iF37 = za0.f(((iF36 << 5) | (iF36 >>> 27)) + ((iF35 ^ i44) ^ i43), iArr2[36], 1859775393, i42);
        int i45 = (iF35 >>> 2) | (iF35 << 30);
        int iF38 = za0.f(((iF37 << 5) | (iF37 >>> 27)) + ((iF36 ^ i45) ^ i44), iArr2[37], 1859775393, i43);
        int i46 = (iF36 >>> 2) | (iF36 << 30);
        int iF39 = za0.f(((iF38 << 5) | (iF38 >>> 27)) + ((iF37 ^ i46) ^ i45), iArr2[38], 1859775393, i44);
        int i47 = (iF37 >>> 2) | (iF37 << 30);
        int iF40 = za0.f(((iF39 << 5) | (iF39 >>> 27)) + ((iF38 ^ i47) ^ i46), iArr2[39], 1859775393, i45);
        int i48 = (iF38 >>> 2) | (iF38 << 30);
        int iF41 = za0.f(((iF40 << 5) | (iF40 >>> 27)) + (((i48 | i47) & iF39) | (i48 & i47)), iArr2[40], -1894007588, i46);
        int i49 = (iF39 >>> 2) | (iF39 << 30);
        int iF42 = za0.f(((iF41 << 5) | (iF41 >>> 27)) + (((i49 | i48) & iF40) | (i49 & i48)), iArr2[41], -1894007588, i47);
        int i50 = (iF40 >>> 2) | (iF40 << 30);
        int iF43 = za0.f(((iF42 << 5) | (iF42 >>> 27)) + (((i50 | i49) & iF41) | (i50 & i49)), iArr2[42], -1894007588, i48);
        int i51 = (iF41 >>> 2) | (iF41 << 30);
        int iF44 = za0.f(((iF43 << 5) | (iF43 >>> 27)) + (((i51 | i50) & iF42) | (i51 & i50)), iArr2[43], -1894007588, i49);
        int i52 = (iF42 >>> 2) | (iF42 << 30);
        int iF45 = za0.f(((iF44 << 5) | (iF44 >>> 27)) + (((i52 | i51) & iF43) | (i52 & i51)), iArr2[44], -1894007588, i50);
        int i53 = (iF43 >>> 2) | (iF43 << 30);
        int iF46 = za0.f(((iF45 << 5) | (iF45 >>> 27)) + (((i53 | i52) & iF44) | (i53 & i52)), iArr2[45], -1894007588, i51);
        int i54 = (iF44 >>> 2) | (iF44 << 30);
        int iF47 = za0.f(((iF46 << 5) | (iF46 >>> 27)) + (((i54 | i53) & iF45) | (i54 & i53)), iArr2[46], -1894007588, i52);
        int i55 = (iF45 >>> 2) | (iF45 << 30);
        int iF48 = za0.f(((iF47 << 5) | (iF47 >>> 27)) + (((i55 | i54) & iF46) | (i55 & i54)), iArr2[47], -1894007588, i53);
        int i56 = (iF46 >>> 2) | (iF46 << 30);
        int iF49 = za0.f(((iF48 << 5) | (iF48 >>> 27)) + (((i56 | i55) & iF47) | (i56 & i55)), iArr2[48], -1894007588, i54);
        int i57 = (iF47 >>> 2) | (iF47 << 30);
        int iF50 = za0.f(((iF49 << 5) | (iF49 >>> 27)) + (((i57 | i56) & iF48) | (i57 & i56)), iArr2[49], -1894007588, i55);
        int i58 = (iF48 >>> 2) | (iF48 << 30);
        int iF51 = za0.f(((iF50 << 5) | (iF50 >>> 27)) + (((i58 | i57) & iF49) | (i58 & i57)), iArr2[50], -1894007588, i56);
        int i59 = (iF49 >>> 2) | (iF49 << 30);
        int iF52 = za0.f(((iF51 << 5) | (iF51 >>> 27)) + (((i59 | i58) & iF50) | (i59 & i58)), iArr2[51], -1894007588, i57);
        int i60 = (iF50 >>> 2) | (iF50 << 30);
        int iF53 = za0.f(((iF52 << 5) | (iF52 >>> 27)) + (((i60 | i59) & iF51) | (i60 & i59)), iArr2[52], -1894007588, i58);
        int i61 = (iF51 >>> 2) | (iF51 << 30);
        int iF54 = za0.f(((iF53 << 5) | (iF53 >>> 27)) + (((i61 | i60) & iF52) | (i61 & i60)), iArr2[53], -1894007588, i59);
        int i62 = (iF52 >>> 2) | (iF52 << 30);
        int iF55 = za0.f(((iF54 << 5) | (iF54 >>> 27)) + (((i62 | i61) & iF53) | (i62 & i61)), iArr2[54], -1894007588, i60);
        int i63 = (iF53 >>> 2) | (iF53 << 30);
        int i64 = (((i61 + ((iF55 << 5) | (iF55 >>> 27))) + (((i63 | i62) & iF54) | (i63 & i62))) + iArr2[55]) - 1894007588;
        int i65 = (iF54 >>> 2) | (iF54 << 30);
        int iF56 = za0.f(((i64 << 5) | (i64 >>> 27)) + (((i65 | i63) & iF55) | (i65 & i63)), iArr2[56], -1894007588, i62);
        int i66 = (iF55 >>> 2) | (iF55 << 30);
        int iF57 = za0.f(((iF56 << 5) | (iF56 >>> 27)) + (((i66 | i65) & i64) | (i66 & i65)), iArr2[57], -1894007588, i63);
        int i67 = (i64 >>> 2) | (i64 << 30);
        int iF58 = za0.f(((iF57 << 5) | (iF57 >>> 27)) + (((i67 | i66) & iF56) | (i67 & i66)), iArr2[58], -1894007588, i65);
        int i68 = (iF56 >>> 2) | (iF56 << 30);
        int iF59 = za0.f(((iF58 << 5) | (iF58 >>> 27)) + (((i68 | i67) & iF57) | (i68 & i67)), iArr2[59], -1894007588, i66);
        int i69 = (iF57 >>> 2) | (iF57 << 30);
        int iF60 = za0.f(((iF59 << 5) | (iF59 >>> 27)) + ((iF58 ^ i69) ^ i68), iArr2[60], -899497514, i67);
        int i70 = (iF58 >>> 2) | (iF58 << 30);
        int iF61 = za0.f(((iF60 << 5) | (iF60 >>> 27)) + ((iF59 ^ i70) ^ i69), iArr2[61], -899497514, i68);
        int i71 = (iF59 >>> 2) | (iF59 << 30);
        int iF62 = za0.f(((iF61 << 5) | (iF61 >>> 27)) + ((iF60 ^ i71) ^ i70), iArr2[62], -899497514, i69);
        int i72 = (iF60 >>> 2) | (iF60 << 30);
        int iF63 = za0.f(((iF62 << 5) | (iF62 >>> 27)) + ((iF61 ^ i72) ^ i71), iArr2[63], -899497514, i70);
        int i73 = (iF61 >>> 2) | (iF61 << 30);
        int iF64 = za0.f(((iF63 << 5) | (iF63 >>> 27)) + ((iF62 ^ i73) ^ i72), iArr2[64], -899497514, i71);
        int i74 = (iF62 >>> 2) | (iF62 << 30);
        int iF65 = za0.f(((iF64 << 5) | (iF64 >>> 27)) + ((iF63 ^ i74) ^ i73), iArr2[65], -899497514, i72);
        int i75 = (iF63 >>> 2) | (iF63 << 30);
        int iF66 = za0.f(((iF65 << 5) | (iF65 >>> 27)) + ((iF64 ^ i75) ^ i74), iArr2[66], -899497514, i73);
        int i76 = (iF64 >>> 2) | (iF64 << 30);
        int iF67 = za0.f(((iF66 << 5) | (iF66 >>> 27)) + ((iF65 ^ i76) ^ i75), iArr2[67], -899497514, i74);
        int i77 = (iF65 >>> 2) | (iF65 << 30);
        int iF68 = za0.f(((iF67 << 5) | (iF67 >>> 27)) + ((iF66 ^ i77) ^ i76), iArr2[68], -899497514, i75);
        int i78 = (iF66 >>> 2) | (iF66 << 30);
        int iF69 = za0.f(((iF68 << 5) | (iF68 >>> 27)) + ((iF67 ^ i78) ^ i77), iArr2[69], -899497514, i76);
        int i79 = (iF67 >>> 2) | (iF67 << 30);
        int iF70 = za0.f(((iF69 << 5) | (iF69 >>> 27)) + ((iF68 ^ i79) ^ i78), iArr2[70], -899497514, i77);
        int i80 = (iF68 >>> 2) | (iF68 << 30);
        int iF71 = za0.f(((iF70 << 5) | (iF70 >>> 27)) + ((iF69 ^ i80) ^ i79), iArr2[71], -899497514, i78);
        int i81 = (iF69 >>> 2) | (iF69 << 30);
        int iF72 = za0.f(((iF71 << 5) | (iF71 >>> 27)) + ((iF70 ^ i81) ^ i80), iArr2[72], -899497514, i79);
        int i82 = (iF70 >>> 2) | (iF70 << 30);
        int iF73 = za0.f(((iF72 << 5) | (iF72 >>> 27)) + ((iF71 ^ i82) ^ i81), iArr2[73], -899497514, i80);
        int i83 = (iF71 >>> 2) | (iF71 << 30);
        int iF74 = za0.f(((iF73 << 5) | (iF73 >>> 27)) + ((iF72 ^ i83) ^ i82), iArr2[74], -899497514, i81);
        int i84 = (iF72 >>> 2) | (iF72 << 30);
        int iF75 = za0.f(((iF74 << 5) | (iF74 >>> 27)) + ((iF73 ^ i84) ^ i83), iArr2[75], -899497514, i82);
        int i85 = (iF73 >>> 2) | (iF73 << 30);
        int iF76 = za0.f(((iF75 << 5) | (iF75 >>> 27)) + ((iF74 ^ i85) ^ i84), iArr2[76], -899497514, i83);
        int i86 = (iF74 >>> 2) | (iF74 << 30);
        int iF77 = za0.f(((iF76 << 5) | (iF76 >>> 27)) + ((iF75 ^ i86) ^ i85), iArr2[77], -899497514, i84);
        int i87 = (iF75 >>> 2) | (iF75 << 30);
        int iF78 = za0.f(((iF77 << 5) | (iF77 >>> 27)) + ((iF76 ^ i87) ^ i86), iArr2[78], -899497514, i85);
        int i88 = (iF76 >>> 2) | (iF76 << 30);
        this.H0 = i3 + za0.f(((iF78 << 5) | (iF78 >>> 27)) + ((iF77 ^ i88) ^ i87), iArr2[79], -899497514, i86);
        this.H1 = i4 + iF78;
        this.H2 = i5 + ((iF77 << 30) | (iF77 >>> 2));
        this.H3 = i6 + i88;
        this.H4 = i7 + i87;
    }

    private void putInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i] & 15));
        }
        return stringBuffer.toString();
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr) {
        digest(bArr, 0);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public int getDigestLength() {
        return 20;
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void reset() {
        this.H0 = 1732584193;
        this.H1 = -271733879;
        this.H2 = -1732584194;
        this.H3 = 271733878;
        this.H4 = -1009589776;
        this.currentPos = 0;
        this.currentLen = 0L;
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr, int i) {
        int i2 = this.currentPos;
        int i3 = i2 >> 2;
        int[] iArr = this.w;
        iArr[i3] = ((iArr[i3] << 8) | 128) << ((3 - (i2 & 3)) << 3);
        int i4 = (i2 & (-4)) + 4;
        this.currentPos = i4;
        if (i4 == 64) {
            this.currentPos = 0;
            perform();
        } else if (i4 == 60) {
            this.currentPos = 0;
            iArr[15] = 0;
            perform();
        }
        for (int i5 = this.currentPos >> 2; i5 < 14; i5++) {
            this.w[i5] = 0;
        }
        int[] iArr2 = this.w;
        long j = this.currentLen;
        iArr2[14] = (int) (j >> 32);
        iArr2[15] = (int) j;
        perform();
        putInt(bArr, i, this.H0);
        putInt(bArr, i + 4, this.H1);
        putInt(bArr, i + 8, this.H2);
        putInt(bArr, i + 12, this.H3);
        putInt(bArr, i + 16, this.H4);
        reset();
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr, int i, int i2) {
        long j;
        int i3;
        int i4 = i2;
        if (i4 >= 4) {
            int i5 = this.currentPos;
            int i6 = i5 >> 2;
            int i7 = i5 & 3;
            if (i7 == 0) {
                j = 8;
                int i8 = i + 4;
                this.w[i6] = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
                i4 -= 4;
                int i9 = i5 + 4;
                this.currentPos = i9;
                this.currentLen += 32;
                if (i9 == 64) {
                    perform();
                    this.currentPos = 0;
                }
                i3 = i8;
            } else if (i7 == 1) {
                j = 8;
                int[] iArr = this.w;
                i3 = i + 3;
                iArr[i6] = (iArr[i6] << 24) | (bArr[i + 2] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                i4 -= 3;
                int i10 = i5 + 3;
                this.currentPos = i10;
                this.currentLen += 24;
                if (i10 == 64) {
                    perform();
                    this.currentPos = 0;
                }
            } else if (i7 == 2) {
                j = 8;
                int[] iArr2 = this.w;
                int i11 = i + 2;
                iArr2[i6] = (iArr2[i6] << 16) | (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
                i4 -= 2;
                int i12 = i5 + 2;
                this.currentPos = i12;
                this.currentLen += 16;
                if (i12 == 64) {
                    perform();
                    this.currentPos = 0;
                }
                i3 = i11;
            } else if (i7 != 3) {
                i3 = i;
                j = 8;
            } else {
                int[] iArr3 = this.w;
                i3 = i + 1;
                j = 8;
                iArr3[i6] = (bArr[i] & 255) | (iArr3[i6] << 8);
                i4--;
                int i13 = i5 + 1;
                this.currentPos = i13;
                this.currentLen += 8;
                if (i13 == 64) {
                    perform();
                    this.currentPos = 0;
                }
            }
            while (i4 >= 8) {
                int[] iArr4 = this.w;
                int i14 = this.currentPos;
                int i15 = i3 + 4;
                iArr4[i14 >> 2] = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8) | (bArr[i3 + 3] & 255);
                int i16 = i14 + 4;
                this.currentPos = i16;
                if (i16 == 64) {
                    perform();
                    this.currentPos = 0;
                }
                int[] iArr5 = this.w;
                int i17 = this.currentPos;
                int i18 = i3 + 7;
                int i19 = ((bArr[i3 + 5] & 255) << 16) | ((bArr[i15] & 255) << 24) | ((bArr[i3 + 6] & 255) << 8);
                i3 += 8;
                iArr5[i17 >> 2] = i19 | (bArr[i18] & 255);
                int i20 = i17 + 4;
                this.currentPos = i20;
                if (i20 == 64) {
                    perform();
                    this.currentPos = 0;
                }
                this.currentLen += 64;
                i4 -= 8;
            }
            while (i4 < 0) {
                int[] iArr6 = this.w;
                int i21 = this.currentPos;
                int i22 = i3 + 3;
                int i23 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8);
                i3 += 4;
                iArr6[i21 >> 2] = i23 | (bArr[i22] & 255);
                i4 -= 4;
                int i24 = i21 + 4;
                this.currentPos = i24;
                this.currentLen += 32;
                if (i24 == 64) {
                    perform();
                    this.currentPos = 0;
                }
            }
        } else {
            j = 8;
            i3 = i;
        }
        while (i4 > 0) {
            int i25 = this.currentPos;
            int i26 = i25 >> 2;
            int[] iArr7 = this.w;
            int i27 = i3 + 1;
            iArr7[i26] = (iArr7[i26] << 8) | (bArr[i3] & 255);
            this.currentLen += j;
            int i28 = i25 + 1;
            this.currentPos = i28;
            if (i28 == 64) {
                perform();
                this.currentPos = 0;
            }
            i4--;
            i3 = i27;
        }
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte b) {
        int i = this.currentPos;
        int i2 = i >> 2;
        int[] iArr = this.w;
        iArr[i2] = (b & 255) | (iArr[i2] << 8);
        this.currentLen += 8;
        int i3 = i + 1;
        this.currentPos = i3;
        if (i3 == 64) {
            perform();
            this.currentPos = 0;
        }
    }
}
