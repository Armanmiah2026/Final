package com.trilead.ssh2.crypto.cipher;

import android.R;
import com.trilead.ssh2.sftp.AttribFlags;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DES implements BlockCipher {
    private int[] workingKey = null;
    static short[] Df_Key = {1, 35, 69, 103, 137, 171, 205, 239, 254, 220, 186, 152, 118, 84, 50, 16, 137, 171, 205, 239, 1, 35, 69, 103};
    static short[] bytebit = {128, 64, 32, 16, 8, 4, 2, 1};
    static int[] bigbyte = {8388608, 4194304, 2097152, 1048576, Proxy.SOCKS_METHOD_NOTSUPPORTED, Proxy.SOCKS_AUTH_NOT_SUPPORTED, Proxy.SOCKS_PROXY_NO_CONNECT, Proxy.SOCKS_NO_PROXY, AttribFlags.SSH_FILEXFER_ATTR_CTIME, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    static byte[] pc1 = {56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3};
    static byte[] totrot = {1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28};
    static byte[] pc2 = {13, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31};
    static int[] SP1 = {R.attr.transitionName, 0, Proxy.SOCKS_NO_PROXY, R.attr.fillColor, R.attr.manageSpaceActivity, 66564, 4, Proxy.SOCKS_NO_PROXY, 1024, R.attr.transitionName, R.attr.fillColor, 1024, 16778244, R.attr.manageSpaceActivity, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, R.attr.theme, R.attr.theme, 16778244, 65540, 16777220, 16777220, 65540, 0, 1028, 66564, 16777216, Proxy.SOCKS_NO_PROXY, R.attr.fillColor, 4, R.attr.theme, R.attr.transitionName, 16777216, 16777216, 1024, R.attr.manageSpaceActivity, Proxy.SOCKS_NO_PROXY, 66560, 16777220, 1024, 4, 16778244, 66564, R.attr.fillColor, 65540, R.attr.theme, 16778244, 16777220, 1028, 66564, R.attr.transitionName, 1028, 16778240, 16778240, 0, 65540, 66560, 0, R.attr.manageSpaceActivity};
    static int[] SP2 = {-2146402272, -2147450880, AttribFlags.SSH_FILEXFER_ATTR_CTIME, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, AttribFlags.SSH_FILEXFER_ATTR_CTIME, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, AttribFlags.SSH_FILEXFER_ATTR_CTIME, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, AttribFlags.SSH_FILEXFER_ATTR_CTIME, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, -2146435040, -2146402272, 1081344};
    static int[] SP3 = {520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, Proxy.SOCKS_PROXY_NO_CONNECT, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, Proxy.SOCKS_PROXY_NO_CONNECT, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, Proxy.SOCKS_PROXY_NO_CONNECT, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, Proxy.SOCKS_PROXY_NO_CONNECT, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
    static int[] SP4 = {8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, 8396928};
    static int[] SP5 = {256, 34078976, 34078720, 1107296512, Proxy.SOCKS_METHOD_NOTSUPPORTED, 256, 1073741824, 34078720, 1074266368, Proxy.SOCKS_METHOD_NOTSUPPORTED, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, Proxy.SOCKS_METHOD_NOTSUPPORTED, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, Proxy.SOCKS_METHOD_NOTSUPPORTED, 0, 1074266112, 34078976, 1073742080};
    static int[] SP6 = {536870928, 541065216, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, 541065216, 4210704, AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
    static int[] SP7 = {2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
    static int[] SP8 = {268439616, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE, Proxy.SOCKS_AUTH_NOT_SUPPORTED, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, Proxy.SOCKS_AUTH_NOT_SUPPORTED, 266304, Proxy.SOCKS_AUTH_NOT_SUPPORTED, 268701696, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE, 64, 268697664, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, Proxy.SOCKS_AUTH_NOT_SUPPORTED, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};

    public void desFunc(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
        int i4 = ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8) | (bArr[i + 7] & 255);
        int i5 = ((i3 >>> 4) ^ i4) & 252645135;
        int i6 = i4 ^ i5;
        int i7 = i3 ^ (i5 << 4);
        int i8 = ((i7 >>> 16) ^ i6) & 65535;
        int i9 = i6 ^ i8;
        int i10 = i7 ^ (i8 << 16);
        int i11 = ((i9 >>> 2) ^ i10) & 858993459;
        int i12 = i10 ^ i11;
        int i13 = i9 ^ (i11 << 2);
        int i14 = ((i13 >>> 8) ^ i12) & 16711935;
        int i15 = i12 ^ i14;
        int i16 = i13 ^ (i14 << 8);
        int i17 = ((i16 >>> 31) & 1) | (i16 << 1);
        int i18 = (i15 ^ i17) & (-1431655766);
        int i19 = i15 ^ i18;
        int i20 = i17 ^ i18;
        int i21 = ((i19 >>> 31) & 1) | (i19 << 1);
        for (int i22 = 0; i22 < 8; i22++) {
            int i23 = i22 * 4;
            int i24 = ((i20 << 28) | (i20 >>> 4)) ^ iArr[i23];
            int[] iArr2 = SP7;
            int i25 = iArr2[i24 & 63];
            int[] iArr3 = SP5;
            int i26 = i25 | iArr3[(i24 >>> 8) & 63];
            int[] iArr4 = SP3;
            int i27 = i26 | iArr4[(i24 >>> 16) & 63];
            int[] iArr5 = SP1;
            int i28 = iArr5[(i24 >>> 24) & 63] | i27;
            int i29 = iArr[i23 + 1] ^ i20;
            int[] iArr6 = SP8;
            int i30 = i28 | iArr6[i29 & 63];
            int[] iArr7 = SP6;
            int i31 = i30 | iArr7[(i29 >>> 8) & 63];
            int[] iArr8 = SP4;
            int i32 = i31 | iArr8[(i29 >>> 16) & 63];
            int[] iArr9 = SP2;
            i21 ^= i32 | iArr9[(i29 >>> 24) & 63];
            int i33 = ((i21 << 28) | (i21 >>> 4)) ^ iArr[i23 + 2];
            int i34 = iArr5[(i33 >>> 24) & 63] | iArr2[i33 & 63] | iArr3[(i33 >>> 8) & 63] | iArr4[(i33 >>> 16) & 63];
            int i35 = iArr[i23 + 3] ^ i21;
            i20 ^= (((i34 | iArr6[i35 & 63]) | iArr7[(i35 >>> 8) & 63]) | iArr8[(i35 >>> 16) & 63]) | iArr9[(i35 >>> 24) & 63];
        }
        int i36 = (i20 >>> 1) | (i20 << 31);
        int i37 = (i21 ^ i36) & (-1431655766);
        int i38 = i21 ^ i37;
        int i39 = i36 ^ i37;
        int i40 = (i38 >>> 1) | (i38 << 31);
        int i41 = ((i40 >>> 8) ^ i39) & 16711935;
        int i42 = i39 ^ i41;
        int i43 = i40 ^ (i41 << 8);
        int i44 = ((i43 >>> 2) ^ i42) & 858993459;
        int i45 = i42 ^ i44;
        int i46 = i43 ^ (i44 << 2);
        int i47 = ((i45 >>> 16) ^ i46) & 65535;
        int i48 = i46 ^ i47;
        int i49 = i45 ^ (i47 << 16);
        int i50 = ((i49 >>> 4) ^ i48) & 252645135;
        int i51 = i48 ^ i50;
        int i52 = i49 ^ (i50 << 4);
        bArr2[i2] = (byte) ((i52 >>> 24) & 255);
        bArr2[i2 + 1] = (byte) ((i52 >>> 16) & 255);
        bArr2[i2 + 2] = (byte) ((i52 >>> 8) & 255);
        bArr2[i2 + 3] = (byte) (i52 & 255);
        bArr2[i2 + 4] = (byte) ((i51 >>> 24) & 255);
        bArr2[i2 + 5] = (byte) ((i51 >>> 16) & 255);
        bArr2[i2 + 6] = (byte) ((i51 >>> 8) & 255);
        bArr2[i2 + 7] = (byte) (i51 & 255);
    }

    public int[] generateWorkingKey(boolean z, byte[] bArr, int i) {
        int i2;
        int[] iArr = new int[32];
        boolean[] zArr = new boolean[56];
        boolean[] zArr2 = new boolean[56];
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i3 >= 56) {
                break;
            }
            byte b = pc1[i3];
            if ((bytebit[b & 7] & bArr[(b >>> 3) + i]) == 0) {
                z2 = false;
            }
            zArr[i3] = z2;
            i3++;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = z ? i4 << 1 : (15 - i4) << 1;
            int i6 = i5 + 1;
            iArr[i6] = 0;
            iArr[i5] = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= 28) {
                    break;
                }
                int i8 = totrot[i4] + i7;
                if (i8 < 28) {
                    zArr2[i7] = zArr[i8];
                } else {
                    zArr2[i7] = zArr[i8 - 28];
                }
                i7++;
            }
            for (i2 = 28; i2 < 56; i2++) {
                int i9 = totrot[i4] + i2;
                if (i9 < 56) {
                    zArr2[i2] = zArr[i9];
                } else {
                    zArr2[i2] = zArr[i9 - 28];
                }
            }
            for (int i10 = 0; i10 < 24; i10++) {
                byte[] bArr2 = pc2;
                if (zArr2[bArr2[i10]]) {
                    iArr[i5] = iArr[i5] | bigbyte[i10];
                }
                if (zArr2[bArr2[i10 + 24]]) {
                    iArr[i6] = iArr[i6] | bigbyte[i10];
                }
            }
        }
        for (int i11 = 0; i11 != 32; i11 += 2) {
            int i12 = iArr[i11];
            int i13 = i11 + 1;
            int i14 = iArr[i13];
            iArr[i11] = ((16515072 & i14) >>> 10) | ((i12 & 16515072) << 6) | ((i12 & 4032) << 10) | ((i14 & 4032) >>> 6);
            iArr[i13] = ((i12 & 63) << 16) | ((i12 & 258048) << 12) | ((258048 & i14) >>> 4) | (i14 & 63);
        }
        return iArr;
    }

    public String getAlgorithmName() {
        return "DES";
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void init(boolean z, byte[] bArr) {
        this.workingKey = generateWorkingKey(z, bArr, 0);
    }

    @Override // com.trilead.ssh2.crypto.cipher.BlockCipher
    public void transformBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("DES engine not initialised!");
        }
        desFunc(iArr, bArr, i, bArr2, i2);
    }

    public void reset() {
    }
}
