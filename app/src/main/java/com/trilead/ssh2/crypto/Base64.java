package com.trilead.ssh2.crypto;

import java.io.CharArrayWriter;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Base64 {
    static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ea A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decode(char[] r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.crypto.Base64.decode(char[]):byte[]");
    }

    public static char[] encode(byte[] bArr) {
        CharArrayWriter charArrayWriter = new CharArrayWriter((bArr.length * 4) / 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 = i == 0 ? (bArr[i3] & 255) << 16 : i2 | (i == 1 ? (bArr[i3] & 255) << 8 : bArr[i3] & 255);
            i++;
            if (i == 3) {
                char[] cArr = alphabet;
                charArrayWriter.write(cArr[i2 >> 18]);
                charArrayWriter.write(cArr[(i2 >> 12) & 63]);
                charArrayWriter.write(cArr[(i2 >> 6) & 63]);
                charArrayWriter.write(cArr[i2 & 63]);
                i = 0;
            }
        }
        if (i == 1) {
            char[] cArr2 = alphabet;
            charArrayWriter.write(cArr2[i2 >> 18]);
            charArrayWriter.write(cArr2[(i2 >> 12) & 63]);
            charArrayWriter.write(61);
            charArrayWriter.write(61);
        }
        if (i == 2) {
            char[] cArr3 = alphabet;
            charArrayWriter.write(cArr3[i2 >> 18]);
            charArrayWriter.write(cArr3[(i2 >> 12) & 63]);
            charArrayWriter.write(cArr3[(i2 >> 6) & 63]);
            charArrayWriter.write(61);
        }
        return charArrayWriter.toCharArray();
    }
}
