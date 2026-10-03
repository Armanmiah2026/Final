package sensei0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b50 implements Serializable {
    public final Pattern a;

    public b50(String str) {
        Pattern patternCompile = Pattern.compile(str);
        pr.i("compile(...)", patternCompile);
        this.a = patternCompile;
    }

    public static v9 b(b50 b50Var, CharSequence charSequence) {
        b50Var.getClass();
        pr.j("input", charSequence);
        if (charSequence.length() >= 0) {
            dz dzVar = new dz(3, b50Var, charSequence);
            a50 a50Var = a50.p;
            return new v9(dzVar);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: 0, input length: " + charSequence.length());
    }

    public final zv a(CharSequence charSequence) {
        pr.j("input", charSequence);
        Matcher matcher = this.a.matcher(charSequence);
        pr.i("matcher(...)", matcher);
        return xe.b(matcher, 0, charSequence);
    }

    public final String c(String str, String str2) {
        pr.j("input", str);
        String strReplaceAll = this.a.matcher(str).replaceAll(str2);
        pr.i("replaceAll(...)", strReplaceAll);
        return strReplaceAll;
    }

    public final String d(String str, fp fpVar) {
        pr.j("input", str);
        zv zvVarA = a(str);
        if (zvVarA == null) {
            return str.toString();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        do {
            Matcher matcher = zvVarA.a;
            int iStart = matcher.start();
            int iEnd = matcher.end();
            sb.append((CharSequence) str, i, (iEnd <= Integer.MIN_VALUE ? kr.d : new kr(iStart, iEnd - 1, 1)).a);
            sb.append((CharSequence) fpVar.g(zvVarA));
            int iStart2 = matcher.start();
            int iEnd2 = matcher.end();
            i = (iEnd2 <= Integer.MIN_VALUE ? kr.d : new kr(iStart2, iEnd2 - 1, 1)).b + 1;
            zvVarA = zvVarA.b();
            if (i >= length) {
                break;
            }
        } while (zvVarA != null);
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        String string = sb.toString();
        pr.i("toString(...)", string);
        return string;
    }

    public final List e(int i, String str) {
        pr.j("input", str);
        fc0.r0(i);
        Matcher matcher = this.a.matcher(str);
        if (i == 1 || !matcher.find()) {
            return k6.G(str.toString());
        }
        int i2 = 10;
        if (i > 0 && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = i - 1;
        int iEnd = 0;
        do {
            arrayList.add(str.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(str.subSequence(iEnd, str.length()).toString());
        return arrayList;
    }

    public final String toString() {
        String string = this.a.toString();
        pr.i("toString(...)", string);
        return string;
    }

    public b50(String str, int i) {
        Pattern patternCompile = Pattern.compile(str, 66);
        pr.i("compile(...)", patternCompile);
        this.a = patternCompile;
    }
}
