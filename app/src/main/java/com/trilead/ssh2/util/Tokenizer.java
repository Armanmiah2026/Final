package com.trilead.ssh2.util;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Tokenizer {
    public static String[] parseTokens(String str, char c) {
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (i3 >= str.length()) {
                strArr[i4] = "";
            } else {
                int iIndexOf = str.indexOf(c, i3);
                if (iIndexOf == -1) {
                    iIndexOf = str.length();
                }
                strArr[i4] = str.substring(i3, iIndexOf);
                i3 = iIndexOf + 1;
            }
        }
        return strArr;
    }
}
