package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nc0 extends mc0 {
    public static boolean Z(String str, String str2) {
        pr.j("<this>", str);
        return str.endsWith(str2);
    }

    public static boolean a0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final boolean b0(int i, int i2, int i3, String str, String str2, boolean z) {
        pr.j("<this>", str);
        pr.j("other", str2);
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String c0(String str, String str2, String str3, boolean z) {
        pr.j("<this>", str);
        pr.j("newValue", str3);
        int i = 0;
        int iH0 = fc0.h0(0, str, str2, z);
        if (iH0 < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iH0);
            sb.append(str3);
            i = iH0 + length;
            if (iH0 >= str.length()) {
                break;
            }
            iH0 = fc0.h0(iH0 + i2, str, str2, z);
        } while (iH0 > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        pr.i("toString(...)", string);
        return string;
    }

    public static boolean d0(String str, String str2, boolean z) {
        pr.j("<this>", str);
        pr.j("prefix", str2);
        return !z ? str.startsWith(str2) : b0(0, 0, str2.length(), str, str2, z);
    }
}
