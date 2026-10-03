package sensei0;

import com.trilead.ssh2.packets.TypesWriter;
import com.trilead.ssh2.sftp.AttribFlags;
import com.trilead.ssh2.sftp.ErrorCodes;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class za0 {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};

    public static int a(String str) throws NoSuchFieldException {
        String str2;
        for (int i : v(2)) {
            if (i == 1) {
                str2 = "Brightness.light";
            } else {
                if (i != 2) {
                    throw null;
                }
                str2 = "Brightness.dark";
            }
            if (str2.equals(str)) {
                return i;
            }
        }
        throw new NoSuchFieldException(s("No such Brightness: ", str));
    }

    public static int b(String str) throws NoSuchFieldException {
        for (int i : v(8)) {
            String str2 = null;
            switch (i) {
                case 1:
                    break;
                case 2:
                    str2 = "HapticFeedbackType.lightImpact";
                    break;
                case 3:
                    str2 = "HapticFeedbackType.mediumImpact";
                    break;
                case 4:
                    str2 = "HapticFeedbackType.heavyImpact";
                    break;
                case 5:
                    str2 = "HapticFeedbackType.selectionClick";
                    break;
                case 6:
                    str2 = "HapticFeedbackType.successNotification";
                    break;
                case 7:
                    str2 = "HapticFeedbackType.warningNotification";
                    break;
                case 8:
                    str2 = "HapticFeedbackType.errorNotification";
                    break;
                default:
                    throw null;
            }
            if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                return i;
            }
        }
        throw new NoSuchFieldException(s("No such HapticFeedbackType: ", str));
    }

    public static int c(String str) throws NoSuchFieldException {
        String str2;
        for (int i : v(3)) {
            if (i == 1) {
                str2 = "SystemSoundType.click";
            } else if (i == 2) {
                str2 = "SystemSoundType.tick";
            } else {
                if (i != 3) {
                    throw null;
                }
                str2 = "SystemSoundType.alert";
            }
            if (str2.equals(str)) {
                return i;
            }
        }
        throw new NoSuchFieldException(s("No such SoundType: ", str));
    }

    public static /* synthetic */ int d(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            default:
                throw null;
        }
    }

    public static /* synthetic */ int e(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return 2048;
            case 13:
                return AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE;
            case 14:
                return AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
            case 15:
                return AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME;
            case 16:
                return AttribFlags.SSH_FILEXFER_ATTR_CTIME;
            case 17:
                return Proxy.SOCKS_NO_PROXY;
            case 18:
                return Proxy.SOCKS_PROXY_NO_CONNECT;
            case 19:
                return Proxy.SOCKS_AUTH_NOT_SUPPORTED;
            case 20:
                return Proxy.SOCKS_METHOD_NOTSUPPORTED;
            case 21:
                return 1048576;
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                return 2097152;
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                return 4194304;
            case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                return 8388608;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                return 16777216;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                return 33554432;
            case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                return 67108864;
            case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                return 134217728;
            case ErrorCodes.SSH_FX_OWNER_INVALID /* 29 */:
                return 268435456;
            case 30:
                return 536870912;
            case 31:
                return 1073741824;
            case 32:
                return AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            default:
                throw null;
        }
    }

    public static int f(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static TypesWriter g(int i) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeByte(i);
        return typesWriter;
    }

    public static String h(int i, String str) {
        return str + i;
    }

    public static String i(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String j(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(String str, Throwable th, String str2, String str3) {
        return str + th + str2 + str3;
    }

    public static String n(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static /* synthetic */ void p(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = pr.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            pr.N(nullPointerException, pr.class.getName());
            throw nullPointerException;
        }
    }

    public static /* synthetic */ void q(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void r(String str, String str2, String str3) {
        wf0.i(new t2(str, str2, str3));
    }

    public static String s(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ String t(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int u(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] v(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }
}
