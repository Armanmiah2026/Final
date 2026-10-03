package sensei0;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c5 extends xe {
    public static void W(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        pr.j("<this>", iArr);
        pr.j("destination", iArr2);
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void X(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        pr.j("<this>", objArr);
        pr.j("destination", objArr2);
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static /* synthetic */ void Y(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        X(objArr, objArr2, 0, i, i2);
    }

    public static byte[] Z(int i, int i2, byte[] bArr) {
        xe.f(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        pr.i("copyOfRange(...)", bArrCopyOfRange);
        return bArrCopyOfRange;
    }

    public static String a0(byte[] bArr, String str, fp fpVar, int i) {
        String str2 = (i & 2) != 0 ? "" : "[";
        String str3 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            fpVar = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) str);
            }
            if (fpVar != null) {
                sb.append((CharSequence) fpVar.g(Byte.valueOf(b)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b));
            }
        }
        sb.append((CharSequence) str3);
        return sb.toString();
    }

    public static byte[] b0(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        pr.f(bArrCopyOf);
        return bArrCopyOf;
    }

    public static List c0(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return qi.a;
        }
        if (length == 1) {
            return k6.G(objArr[0]);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        pr.i("copyOf(...)", objArrCopyOf);
        List listAsList = Arrays.asList(objArrCopyOf);
        pr.i("asList(...)", listAsList);
        return listAsList;
    }
}
