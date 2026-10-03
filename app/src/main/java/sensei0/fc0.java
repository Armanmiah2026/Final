package sensei0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class fc0 extends nc0 {
    public static CharSequence A0(String str) {
        pr.j("<this>", str);
        int length = str.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i = length - 1;
            if (!pr.F(str.charAt(length))) {
                return str.subSequence(0, length + 1);
            }
            if (i < 0) {
                return "";
            }
            length = i;
        }
    }

    public static CharSequence B0(String str) {
        pr.j("<this>", str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!pr.F(str.charAt(i))) {
                return str.subSequence(i, str.length());
            }
        }
        return "";
    }

    public static boolean e0(CharSequence charSequence, String str, boolean z) {
        pr.j("<this>", charSequence);
        return j0(charSequence, str, 0, z, 2) >= 0;
    }

    public static boolean f0(String str) {
        pr.j("<this>", str);
        return i0(str, ':', 0, 2) >= 0;
    }

    public static final int g0(CharSequence charSequence) {
        pr.j("<this>", charSequence);
        return charSequence.length() - 1;
    }

    public static final int h0(int i, CharSequence charSequence, String str, boolean z) {
        pr.j("<this>", charSequence);
        pr.j("string", str);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        kr krVar = new kr(i, length, 1);
        boolean z2 = charSequence instanceof String;
        int i2 = krVar.c;
        int i3 = krVar.b;
        int i4 = krVar.a;
        if (!z2 || !(str instanceof String)) {
            boolean z3 = z;
            if ((i2 <= 0 || i4 > i3) && (i2 >= 0 || i3 > i4)) {
                return -1;
            }
            while (true) {
                CharSequence charSequence2 = charSequence;
                boolean z4 = z3;
                z3 = z4;
                if (p0(str, 0, charSequence2, i4, str.length(), z4)) {
                    return i4;
                }
                if (i4 == i3) {
                    return -1;
                }
                i4 += i2;
                charSequence = charSequence2;
            }
        } else {
            if ((i2 <= 0 || i4 > i3) && (i2 >= 0 || i3 > i4)) {
                return -1;
            }
            int i5 = i4;
            while (true) {
                String str2 = str;
                boolean z5 = z;
                if (nc0.b0(0, i5, str.length(), str2, (String) charSequence, z5)) {
                    return i5;
                }
                if (i5 == i3) {
                    return -1;
                }
                i5 += i2;
                str = str2;
                z = z5;
            }
        }
    }

    public static int i0(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        pr.j("<this>", charSequence);
        return !(charSequence instanceof String) ? k0(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int j0(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return h0(i, charSequence, str, z);
    }

    public static final int k0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        pr.j("<this>", charSequence);
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int iG0 = g0(charSequence);
        if (i > iG0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (pr.v(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == iG0) {
                return -1;
            }
            i++;
        }
    }

    public static boolean l0(CharSequence charSequence) {
        pr.j("<this>", charSequence);
        for (int i = 0; i < charSequence.length(); i++) {
            if (!pr.F(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int m0(String str, char c) {
        int iG0 = g0(str);
        pr.j("<this>", str);
        return str.lastIndexOf(c, iG0);
    }

    public static v9 n0(CharSequence charSequence) {
        pr.j("<this>", charSequence);
        return new v9(4, charSequence);
    }

    public static List o0(CharSequence charSequence) {
        pr.j("<this>", charSequence);
        return v70.d0(n0(charSequence));
    }

    public static final boolean p0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        pr.j("<this>", charSequence);
        pr.j("other", charSequence2);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!pr.v(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String q0(String str, String str2) {
        pr.j("<this>", str);
        if (!nc0.d0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        pr.i("substring(...)", strSubstring);
        return strSubstring;
    }

    public static final void r0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(za0.h(i, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List s0(int i, CharSequence charSequence, String str, boolean z) {
        r0(i);
        int length = 0;
        int iH0 = h0(0, charSequence, str, z);
        if (iH0 == -1 || i == 1) {
            return k6.G(charSequence.toString());
        }
        boolean z2 = i > 0;
        int i2 = 10;
        if (z2 && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        do {
            arrayList.add(charSequence.subSequence(length, iH0).toString());
            length = str.length() + iH0;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iH0 = h0(length, charSequence, str, z);
        } while (iH0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List t0(String str, String[] strArr, int i) {
        final boolean z = (i & 2) == 0;
        int i2 = (i & 4) != 0 ? 0 : 3;
        pr.j("<this>", str);
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() > 0) {
                return s0(i2, str, str2, z);
            }
        }
        r0(i2);
        final List listAsList = Arrays.asList(strArr);
        pr.i("asList(...)", listAsList);
        x70 x70Var = new x70(new tf(str, i2, new jp() { // from class: sensei0.oc0
            /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[EDGE_INSN: B:59:0x0032->B:11:0x0032 BREAK  A[LOOP:0: B:25:0x0066->B:37:0x009c], EDGE_INSN: B:63:0x0032->B:11:0x0032 BREAK  A[LOOP:2: B:42:0x00a5->B:53:0x00d4]] */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[EDGE_INSN: B:59:0x0032->B:11:0x0032 BREAK  A[LOOP:0: B:25:0x0066->B:37:0x009c]] */
            @Override // sensei0.jp
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object c(java.lang.Object r12, java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 238
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sensei0.oc0.c(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }));
        ArrayList arrayList = new ArrayList(q9.h0(x70Var));
        Iterator it = x70Var.iterator();
        while (true) {
            sf sfVar = (sf) it;
            if (!sfVar.hasNext()) {
                return arrayList;
            }
            kr krVar = (kr) sfVar.next();
            pr.j("range", krVar);
            arrayList.add(str.subSequence(krVar.a, krVar.b + 1).toString());
        }
    }

    public static List u0(final char[] cArr, String str) {
        pr.j("<this>", str);
        if (cArr.length == 1) {
            return s0(0, str, String.valueOf(cArr[0]), false);
        }
        r0(0);
        x70 x70Var = new x70(new tf(str, 0, new jp() { // from class: sensei0.pc0
            @Override // sensei0.jp
            public final Object c(Object obj, Object obj2) {
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                pr.j("$this$DelimitedRangesSequence", charSequence);
                int iK0 = fc0.k0(charSequence, cArr, iIntValue, false);
                if (iK0 < 0) {
                    return null;
                }
                return new qz(Integer.valueOf(iK0), 1);
            }
        }));
        ArrayList arrayList = new ArrayList(q9.h0(x70Var));
        Iterator it = x70Var.iterator();
        while (true) {
            sf sfVar = (sf) it;
            if (!sfVar.hasNext()) {
                return arrayList;
            }
            kr krVar = (kr) sfVar.next();
            pr.j("range", krVar);
            arrayList.add(str.subSequence(krVar.a, krVar.b + 1).toString());
        }
    }

    public static String v0(String str, char c, String str2) {
        int iI0 = i0(str, c, 0, 6);
        if (iI0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iI0 + 1, str.length());
        pr.i("substring(...)", strSubstring);
        return strSubstring;
    }

    public static String w0(String str, String str2, String str3) {
        pr.j("<this>", str);
        pr.j("delimiter", str2);
        pr.j("missingDelimiterValue", str3);
        int iJ0 = j0(str, str2, 0, false, 6);
        if (iJ0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iJ0, str.length());
        pr.i("substring(...)", strSubstring);
        return strSubstring;
    }

    public static String x0(String str, String str2) {
        pr.j("<this>", str);
        pr.j("missingDelimiterValue", str);
        int iJ0 = j0(str, str2, 0, false, 6);
        if (iJ0 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iJ0);
        pr.i("substring(...)", strSubstring);
        return strSubstring;
    }

    public static String y0(int i, String str) {
        pr.j("<this>", str);
        if (i < 0) {
            throw new IllegalArgumentException(za0.i(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        pr.i("substring(...)", strSubstring);
        return strSubstring;
    }

    public static CharSequence z0(CharSequence charSequence) {
        pr.j("<this>", charSequence);
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zF = pr.F(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zF) {
                    break;
                }
                length--;
            } else if (zF) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
