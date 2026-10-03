package sensei0;

import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d00 {
    public static final AtomicInteger C = new AtomicInteger(1);
    public static final b50 D = new b50("\\[[^\\[\\]\\r\\n]{1,64}\\]", 0);
    public static final b50 E = new b50("\\[rotate=([^\\[\\]]+)]", 0);
    public static final ConcurrentHashMap F = new ConcurrentHashMap();
    public static final ConcurrentHashMap G = new ConcurrentHashMap();
    public static final b50 H = new b50("\\[(cr|lf|crlf|lfcr)\\*(\\d{1,3})]", 0);
    public static final b50 I = new b50("\\\\r\\\\n");
    public static final b50 J = new b50("\\\\n");
    public static final b50 K = new b50("\\\\r");
    public static final List L = p9.f0("CONNECT ", "GET ", "POST ", "PUT ", "HEAD ", "OPTIONS ", "PATCH ", "DELETE ", "TRACE ", "PURGE ");
    public final boolean A;
    public final AtomicReference B;
    public final zz a;
    public final String b;
    public final int c;
    public final String d;
    public final int e;
    public final String f;
    public final boolean g;
    public final a00 h;
    public final boolean i;
    public final int j;
    public final yz k;
    public final boolean l;
    public final fp m;
    public final AtomicBoolean n;
    public ServerSocket o;
    public final Set p;
    public final ExecutorService q;
    public final String r;
    public final String s;
    public final AtomicInteger t;
    public final AtomicInteger u;
    public final Object v;
    public final int w;
    public final boolean x;
    public final int y;
    public final String z;

    /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.Iterable, java.lang.Object] */
    public d00(zz zzVar, String str, int i, String str2, int i2, String str3, String str4, boolean z, int i3, boolean z2, fp fpVar, int i4) {
        String upperCase;
        String string;
        a00 a00Var = (i4 & 256) != 0 ? a00.a : a00.b;
        boolean z3 = true;
        boolean z4 = (i4 & 512) == 0;
        int i5 = i4 & 2048;
        yz yzVar = yz.a;
        yz yzVar2 = i5 != 0 ? yzVar : yz.b;
        boolean z5 = (i4 & AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE) != 0 ? false : z2;
        pr.j("targetHost", str);
        pr.j("proxyHost", str2);
        pr.j("sni", str3);
        pr.j("payloadTemplate", str4);
        this.a = zzVar;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = i2;
        this.f = str3;
        this.g = z;
        this.h = a00Var;
        this.i = z4;
        this.j = i3;
        this.k = yzVar2;
        this.l = z5;
        this.m = fpVar;
        this.n = new AtomicBoolean(false);
        Set setSynchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        pr.i("synchronizedSet(...)", setSynchronizedSet);
        this.p = setSynchronizedSet;
        this.q = Executors.newCachedThreadPool(new of(2));
        this.r = fc0.l0(str3) ? str : str3;
        this.s = str4;
        this.t = new AtomicInteger(0);
        this.u = new AtomicInteger(0);
        List listB = b(str4, null);
        this.v = listB;
        cl clVar = new cl(new v9(0, listB), new a3(8), 2);
        a3 a3Var = new a3(9);
        y70 y70Var = y70.p;
        Iterator it = new cl(clVar, a3Var).iterator();
        int i6 = 0;
        while (true) {
            boolean zHasNext = it.hasNext();
            List list = L;
            if (!zHasNext) {
                this.w = i6;
                this.x = this.k == yzVar && fc0.l0(str4) && !j() && this.a == zz.b && !fc0.l0(this.f) && !nc0.a0(this.f, this.b);
                Iterator it2 = this.v.iterator();
                int length = 0;
                while (it2.hasNext()) {
                    length += ((b00) it2.next()).a.length;
                }
                this.y = length;
                b00 b00Var = (b00) o9.j0(this.v);
                if (b00Var == null || (string = fc0.B0(new String(b00Var.a, e8.b)).toString()) == null) {
                    upperCase = null;
                } else {
                    upperCase = string.toUpperCase(Locale.ROOT);
                    pr.i("toUpperCase(...)", upperCase);
                }
                this.z = upperCase == null ? "" : upperCase;
                if (list == null || !list.isEmpty()) {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (nc0.d0(this.z, (String) it3.next(), false)) {
                            break;
                        }
                    }
                    z3 = false;
                } else {
                    z3 = false;
                }
                this.A = z3;
                nc0.d0(this.z, "HTTP/", false);
                this.B = new AtomicReference(null);
                return;
            }
            String str5 = (String) it.next();
            pr.j("it", str5);
            String string2 = fc0.B0(str5).toString();
            if (!nc0.d0(string2, "[method]", true)) {
                if (list == null || !list.isEmpty()) {
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        if (nc0.d0(string2, (String) it4.next(), true)) {
                        }
                    }
                }
            }
            i6++;
            if (i6 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
    }

    public static boolean a(int i, PushbackInputStream pushbackInputStream, Socket socket) {
        int soTimeout;
        ArrayList arrayList = new ArrayList(512);
        try {
            soTimeout = socket.getSoTimeout();
        } catch (Exception unused) {
            soTimeout = 0;
        }
        try {
            try {
                socket.setSoTimeout(3000);
                byte[] bArr = new byte[1];
                int i2 = 0;
                while (arrayList.size() < 16384) {
                    if (pushbackInputStream.read(bArr) <= 0) {
                        pushbackInputStream.unread(o9.p0(arrayList));
                        boolean z = SenseiTunnelVpnService.J0;
                        xe.i("Injector[" + i + "]: upstream closed before handshake accept (" + arrayList.size() + "B)");
                        break;
                    }
                    arrayList.add(Byte.valueOf(bArr[0]));
                    char c = (char) bArr[0];
                    i2 = (i2 >= 4 || c != "\r\n\r\n".charAt(i2)) ? c == "\r\n\r\n".charAt(0) ? 1 : 0 : i2 + 1;
                    if (i2 == 4) {
                        break;
                    }
                }
                String str = (String) v70.c0(fc0.n0(new String(o9.p0(arrayList), e8.b)));
                String string = str != null ? fc0.z0(str).toString() : null;
                if (string == null) {
                    string = "";
                }
                if (nc0.d0(string, "HTTP/", true)) {
                    boolean z2 = SenseiTunnelVpnService.J0;
                    xe.i("Injector[" + i + "]: handshake accept: " + string);
                    if (!fc0.e0(string, "101", false)) {
                        xe.i("Injector[" + i + "]: backend refused the tunnel handshake — check path/protocol");
                        return false;
                    }
                    pushbackInputStream.unread(o9.p0(arrayList));
                } else {
                    pushbackInputStream.unread(o9.p0(arrayList));
                }
            } catch (Exception e) {
                try {
                    pushbackInputStream.unread(o9.p0(arrayList));
                } catch (Exception unused2) {
                }
                boolean z3 = SenseiTunnelVpnService.J0;
                xe.i("Injector[" + i + "]: no handshake accept (" + e.getClass().getSimpleName() + "); relaying raw");
            }
            try {
                socket.setSoTimeout(soTimeout);
            } catch (Exception unused3) {
            }
            return true;
        } finally {
            try {
                socket.setSoTimeout(soTimeout);
            } catch (Exception unused4) {
            }
        }
    }

    public static String d(PushbackInputStream pushbackInputStream, Socket socket, int i, boolean z) throws SocketException {
        ArrayList arrayList = new ArrayList(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
        int soTimeout = socket.getSoTimeout();
        socket.setSoTimeout(10000);
        try {
            try {
                byte[] bArr = new byte[1];
                char c = 0;
                char c2 = 0;
                char c3 = 0;
                while (arrayList.size() < 16384) {
                    if (pushbackInputStream.read(bArr) <= 0) {
                        boolean z2 = SenseiTunnelVpnService.J0;
                        xe.i("Injector[" + i + "]: upstream closed during HTTP response after " + arrayList.size() + "B");
                        return null;
                    }
                    arrayList.add(Byte.valueOf(bArr[0]));
                    char c4 = (char) bArr[0];
                    boolean z3 = c == '\r' && c2 == '\n' && c3 == '\r' && c4 == '\n';
                    boolean z4 = c3 == '\n' && c4 == '\n';
                    if (!z3 && !z4) {
                        c = c2;
                        c2 = c3;
                        c3 = c4;
                    }
                    String str = (String) v70.c0(fc0.n0(new String(o9.p0(arrayList), e8.b)));
                    String string = str != null ? fc0.z0(str).toString() : null;
                    if (string == null) {
                        string = "";
                    }
                    if (z && !fc0.e0(string, "101", false)) {
                        boolean z5 = SenseiTunnelVpnService.J0;
                        xe.i("Injector[" + i + "]: upstream refused the upgrade: " + string);
                        h(o9.p0(arrayList), i);
                        try {
                            socket.setSoTimeout(soTimeout);
                        } catch (Exception unused) {
                        }
                        return null;
                    }
                    boolean z6 = SenseiTunnelVpnService.J0;
                    xe.i("Injector[" + i + "]: consumed HTTP response " + arrayList.size() + "B; status: " + string);
                    try {
                        socket.setSoTimeout(soTimeout);
                    } catch (Exception unused2) {
                    }
                    return string;
                }
                boolean z7 = SenseiTunnelVpnService.J0;
                xe.i("Injector[" + i + "]: HTTP response exceeded 16384B without header end");
                try {
                    socket.setSoTimeout(soTimeout);
                } catch (Exception unused3) {
                }
                return null;
            } catch (Exception e) {
                boolean z8 = SenseiTunnelVpnService.J0;
                xe.i("Injector[" + i + "]: HTTP response read failed after " + arrayList.size() + "B " + e.getClass().getSimpleName() + ": " + e.getMessage());
                try {
                    socket.setSoTimeout(soTimeout);
                } catch (Exception unused4) {
                }
                return null;
            }
        } finally {
            try {
                socket.setSoTimeout(soTimeout);
            } catch (Exception unused5) {
            }
        }
    }

    public static boolean e(PushbackInputStream pushbackInputStream, Socket socket, int i, int i2) {
        String strD;
        Integer numX;
        if (i2 < 1) {
            i2 = 1;
        }
        if (1 <= i2) {
            int i3 = 1;
            while (true) {
                strD = d(pushbackInputStream, socket, i, false);
                if (strD != null) {
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                } else {
                    return false;
                }
            }
        } else {
            strD = null;
        }
        String str = (String) o9.k0(1, fc0.t0(strD == null ? "" : strD, new String[]{" "}, 6));
        int iIntValue = (str == null || (numX = mc0.X(str)) == null) ? 0 : numX.intValue();
        if (400 > iIntValue || iIntValue >= 600) {
            return true;
        }
        boolean z = SenseiTunnelVpnService.J0;
        xe.i("Injector[" + i + "]: backend refused the tunnel handshake after " + i2 + " response(s): " + strD);
        return false;
    }

    public static boolean f(int i, PushbackInputStream pushbackInputStream, Socket socket) {
        ArrayList arrayList = new ArrayList(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        try {
            int soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(10000);
            try {
                byte[] bArr = new byte[1];
                int i2 = 0;
                boolean z = false;
                while (arrayList.size() < 16384) {
                    if (pushbackInputStream.read(bArr) <= 0) {
                        k(i, "eof", arrayList);
                        return false;
                    }
                    arrayList.add(Byte.valueOf(bArr[0]));
                    int i3 = i(arrayList);
                    if (i3 >= 0) {
                        List listSubList = arrayList.subList(i3, arrayList.size());
                        pr.i("subList(...)", listSubList);
                        pushbackInputStream.unread(o9.p0(listSubList));
                        List listSubList2 = arrayList.subList(0, i3);
                        pr.i("subList(...)", listSubList2);
                        int size = arrayList.size();
                        int size2 = i3;
                        while (true) {
                            if (size2 >= size) {
                                size2 = -1;
                                break;
                            }
                            if (((char) ((Number) arrayList.get(size2)).byteValue()) == '\n') {
                                break;
                            }
                            size2++;
                        }
                        if (size2 < 0) {
                            size2 = arrayList.size();
                        }
                        String strY0 = fc0.y0(120, nc0.c0(new String(o9.p0(arrayList.subList(i3, size2)), e8.b), "\r", "", false));
                        boolean z2 = SenseiTunnelVpnService.J0;
                        xe.i("Injector[" + i + "]: discarded prelude " + listSubList2.size() + "B; SSH starts: " + strY0);
                        if (!listSubList2.isEmpty()) {
                            h(o9.p0(listSubList2), i);
                        }
                        try {
                            socket.setSoTimeout(soTimeout);
                        } catch (Exception unused) {
                        }
                        return true;
                    }
                    char c = (char) bArr[0];
                    i2 = (((i2 == 0 || i2 == 2) && c == '\r') || ((i2 == 1 || i2 == 3) && c == '\n')) ? i2 + 1 : 0;
                    if (!z && i2 == 4) {
                        boolean z3 = SenseiTunnelVpnService.J0;
                        xe.i("Injector[" + i + "]: HTTP/WS headers ended after " + arrayList.size() + "B; waiting for real SSH banner");
                        z = true;
                    }
                }
                k(i, "limit 16384B", arrayList);
                try {
                    socket.setSoTimeout(soTimeout);
                } catch (Exception unused2) {
                }
                return false;
            } finally {
                try {
                    socket.setSoTimeout(soTimeout);
                } catch (Exception unused3) {
                }
            }
        } catch (Exception e) {
            k(i, e.getClass().getSimpleName() + ": " + e.getMessage(), arrayList);
            return false;
        }
    }

    public static void h(byte[] bArr, int i) {
        String strReplace = nc0.c0(new String(bArr, e8.c), "\r\n", "\n", false).replace('\r', '\n');
        pr.i("replace(...)", strReplace);
        String string = fc0.z0(strReplace).toString();
        if (string.length() == 0) {
            return;
        }
        if (string.length() > 2000) {
            string = fc0.y0(2000, string) + "… (" + string.length() + "B total)";
        }
        boolean z = SenseiTunnelVpnService.J0;
        xe.i("Injector[" + i + "]: upstream replied:\n" + string);
    }

    public static int i(ArrayList arrayList) {
        int size;
        int i;
        if (arrayList.size() >= 8 && (size = arrayList.size() - 8) >= 0) {
            int i2 = 0;
            while (true) {
                if (i2 == 0 || ((char) ((Number) arrayList.get(i2 - 1)).byteValue()) == '\n') {
                    boolean zL = l(i2, "SSH-2.0-", arrayList);
                    boolean z = arrayList.size() - i2 >= 9 && l(i2, "SSH-1.99-", arrayList);
                    if (zL || z) {
                        int size2 = arrayList.size();
                        int i3 = i2;
                        while (true) {
                            if (i3 >= size2) {
                                i3 = -1;
                                break;
                            }
                            if (((char) ((Number) arrayList.get(i3)).byteValue()) == '\n') {
                                break;
                            }
                            i3++;
                        }
                        if (i3 >= 0) {
                            if (i3 > i2) {
                                int i4 = i3 - 1;
                                if (((char) ((Number) arrayList.get(i4)).byteValue()) == '\r') {
                                    i3 = i4;
                                }
                            }
                            int i5 = i3 - i2;
                            if (8 <= i5 && i5 < 256) {
                                if (l(i2, "SSH-2.0-", arrayList)) {
                                    i = i2 + 8;
                                } else if (l(i2, "SSH-1.99-", arrayList)) {
                                    i = i2 + 9;
                                }
                                if (i <= i3) {
                                    while (i < i3) {
                                        int iByteValue = ((Number) arrayList.get(i)).byteValue() & 255;
                                        if (32 <= iByteValue && iByteValue < 127) {
                                            i++;
                                        }
                                    }
                                    return i2;
                                }
                            }
                        }
                    }
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return -1;
    }

    public static void k(int i, String str, ArrayList arrayList) {
        boolean z = SenseiTunnelVpnService.J0;
        xe.i("Injector[" + i + "]: no complete SSH banner after discarding " + arrayList.size() + "B (" + str + ")");
        if (arrayList.isEmpty()) {
            return;
        }
        h(o9.p0(arrayList), i);
    }

    public static boolean l(int i, String str, ArrayList arrayList) {
        if (arrayList.size() - i >= str.length()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (((char) ((Number) arrayList.get(i + i2)).byteValue()) == str.charAt(i2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static qz m(String str) {
        String string;
        if (str == null || (string = fc0.z0(str).toString()) == null) {
            return null;
        }
        List listE = new b50("\\s+").e(0, string);
        if (listE.size() < 2 || !nc0.a0((String) listE.get(0), "CONNECT")) {
            return null;
        }
        String str2 = (String) listE.get(1);
        try {
            if (!nc0.d0(str2, "[", false)) {
                int iM0 = fc0.m0(str2, ':');
                if (iM0 > 0) {
                    String strSubstring = str2.substring(0, iM0);
                    pr.i("substring(...)", strSubstring);
                    if (!fc0.f0(strSubstring)) {
                        String strSubstring2 = str2.substring(0, iM0);
                        pr.i("substring(...)", strSubstring2);
                        String strSubstring3 = str2.substring(iM0 + 1);
                        pr.i("substring(...)", strSubstring3);
                        Integer numX = mc0.X(strSubstring3);
                        return new qz(strSubstring2, Integer.valueOf(numX != null ? numX.intValue() : 443));
                    }
                }
                return new qz(str2, 443);
            }
            int iI0 = fc0.i0(str2, ']', 0, 6);
            if (iI0 <= 0) {
                return null;
            }
            String strSubstring4 = str2.substring(1, iI0);
            pr.i("substring(...)", strSubstring4);
            int i = iI0 + 1;
            if (i < str2.length() && str2.charAt(i) == ':') {
                String strSubstring5 = str2.substring(iI0 + 2);
                pr.i("substring(...)", strSubstring5);
                Integer numX2 = mc0.X(strSubstring5);
                if (numX2 != null) {
                    iIntValue = numX2.intValue();
                }
            }
            return new qz(strSubstring4, Integer.valueOf(iIntValue));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void o(int i, int i2, byte[] bArr) {
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 & 255);
    }

    public static String p(PushbackInputStream pushbackInputStream, int i) {
        ArrayList arrayList = new ArrayList(512);
        byte[] bArr = new byte[1];
        char c = 0;
        char c2 = 0;
        char c3 = 0;
        while (arrayList.size() < 16384) {
            try {
                if (pushbackInputStream.read(bArr) <= 0) {
                    boolean z = SenseiTunnelVpnService.J0;
                    xe.i("Injector[" + i + "]: client closed before sending CONNECT (" + arrayList.size() + "B)");
                    return null;
                }
                arrayList.add(Byte.valueOf(bArr[0]));
                char c4 = (char) bArr[0];
                boolean z2 = c == '\r' && c2 == '\n' && c3 == '\r' && c4 == '\n';
                boolean z3 = c3 == '\n' && c4 == '\n';
                if (z2 || z3) {
                    break;
                }
                c = c2;
                c2 = c3;
                c3 = c4;
            } catch (Exception e) {
                boolean z4 = SenseiTunnelVpnService.J0;
                xe.i("Injector[" + i + "]: client CONNECT read failed: " + e.getClass().getSimpleName());
                return null;
            }
        }
        String str = (String) v70.c0(fc0.n0(new String(o9.p0(arrayList), e8.c)));
        String string = str != null ? fc0.z0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        String upperCase = string.toUpperCase(Locale.ROOT);
        pr.i("toUpperCase(...)", upperCase);
        if (nc0.d0(upperCase, "CONNECT ", false)) {
            boolean z5 = SenseiTunnelVpnService.J0;
            xe.i("Injector[" + i + "]: client CONNECT: " + string);
            return string;
        }
        boolean z6 = SenseiTunnelVpnService.J0;
        xe.i("Injector[" + i + "]: expected CONNECT from local client, got: " + fc0.y0(80, string));
        return null;
    }

    public static byte[] q(byte[] bArr, String str) {
        byte[] bArr2;
        int iW;
        int i;
        int i2;
        int iW2;
        int i3;
        byte b = 0;
        try {
        } catch (Exception e) {
            e = e;
            bArr2 = null;
        }
        if (bArr.length >= 5 && bArr[0] == 22 && w(bArr, 3) + 5 <= bArr.length && bArr[5] == 1) {
            char c = '\b';
            int i4 = (((bArr[6] & 255) << 16) | ((bArr[7] & 255) << 8) | (bArr[8] & 255)) + 9;
            if (i4 <= bArr.length) {
                byte[] bArrZ = c5.Z(9, i4, bArr);
                int i5 = 2;
                if (2 < bArrZ.length) {
                    int i6 = bArrZ[2] & 255;
                    int i7 = i6 + 3;
                    bArr2 = null;
                    try {
                        if (i6 + 5 <= bArrZ.length && (iW = w(bArrZ, i7) + 2 + i7) < bArrZ.length && (i2 = (i = (bArrZ[iW] & 255) + 1 + iW) + 2) <= bArrZ.length && (iW2 = w(bArrZ, i) + i2) <= bArrZ.length) {
                            byte[] bytes = str.getBytes(e8.b);
                            pr.i("getBytes(...)", bytes);
                            ArrayList arrayList = new ArrayList();
                            boolean z = false;
                            int i8 = i2;
                            while (i8 < iW2) {
                                char c2 = c;
                                int i9 = i8 + 4;
                                if (i9 > iW2) {
                                    return null;
                                }
                                int iW3 = w(bArrZ, i8);
                                int iW4 = w(bArrZ, i8 + 2);
                                int i10 = i9 + iW4;
                                if (i10 > iW2) {
                                    return null;
                                }
                                byte[] bArrZ2 = c5.Z(i9, i10, bArrZ);
                                if (iW3 == 0) {
                                    int length = bytes.length;
                                    int i11 = length + 3;
                                    byte b2 = b;
                                    byte[] bArr3 = new byte[i11];
                                    bArr3[b2] = b2;
                                    bArr3[1] = b2;
                                    o(i5, bytes.length, bArr3);
                                    i3 = i2;
                                    System.arraycopy(bytes, b2, bArr3, 3, bytes.length);
                                    int i12 = length + 5;
                                    byte[] bArr4 = new byte[i12];
                                    o(b2, i11, bArr4);
                                    System.arraycopy(bArr3, b2, bArr4, 2, i11);
                                    byte[] bArr5 = new byte[length + 7];
                                    o(b2, i12, bArr5);
                                    System.arraycopy(bArr4, b2, bArr5, 2, i12);
                                    arrayList.add(new qz(0, bArr5));
                                    z = true;
                                } else {
                                    i3 = i2;
                                    arrayList.add(new qz(Integer.valueOf(iW3), bArrZ2));
                                }
                                i8 += iW4 + 4;
                                c = c2;
                                i2 = i3;
                                b = 0;
                                i5 = 2;
                            }
                            int i13 = i2;
                            char c3 = c;
                            if (!z) {
                                int length2 = bytes.length;
                                int i14 = length2 + 3;
                                byte[] bArr6 = new byte[i14];
                                bArr6[0] = 0;
                                bArr6[1] = 0;
                                o(2, bytes.length, bArr6);
                                System.arraycopy(bytes, 0, bArr6, 3, bytes.length);
                                int i15 = length2 + 5;
                                byte[] bArr7 = new byte[i15];
                                o(0, i14, bArr7);
                                System.arraycopy(bArr6, 0, bArr7, 2, i14);
                                byte[] bArr8 = new byte[length2 + 7];
                                o(0, i15, bArr8);
                                System.arraycopy(bArr7, 0, bArr8, 2, i15);
                                arrayList.add(new qz(0, bArr8));
                            }
                            Iterator it = arrayList.iterator();
                            pr.i("iterator(...)", it);
                            int length3 = 0;
                            while (it.hasNext()) {
                                Object next = it.next();
                                pr.i("next(...)", next);
                                length3 += ((byte[]) ((qz) next).b).length + 4;
                            }
                            int i16 = i13 + length3;
                            byte[] bArr9 = new byte[i16];
                            System.arraycopy(bArrZ, 0, bArr9, 0, i);
                            o(i, length3, bArr9);
                            Iterator it2 = arrayList.iterator();
                            pr.i("iterator(...)", it2);
                            int length4 = i13;
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                pr.i("next(...)", next2);
                                qz qzVar = (qz) next2;
                                int iIntValue = ((Number) qzVar.a).intValue();
                                byte[] bArr10 = (byte[]) qzVar.b;
                                o(length4, iIntValue, bArr9);
                                o(length4 + 2, bArr10.length, bArr9);
                                System.arraycopy(bArr10, 0, bArr9, length4 + 4, bArr10.length);
                                length4 += bArr10.length + 4;
                            }
                            byte[] bArr11 = new byte[i16 + 9];
                            System.arraycopy(bArr, 0, bArr11, 0, 5);
                            bArr11[5] = 1;
                            bArr11[6] = (byte) (i16 >> 16);
                            bArr11[7] = (byte) (i16 >> 8);
                            bArr11[c3] = (byte) (i16 & 255);
                            System.arraycopy(bArr9, 0, bArr11, 9, i16);
                            o(3, i16 + 4, bArr11);
                            return bArr11;
                        }
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                Log.w("PayloadInjector", "rewriteSni failed: " + e.getMessage());
                return bArr2;
            }
        }
        return null;
    }

    public static void r(int i, Socket socket) {
        Method method;
        try {
            socket.setKeepAlive(true);
            try {
                method = Socket.class.getDeclaredMethod("getFileDescriptor", null);
            } catch (NoSuchMethodException unused) {
                method = Socket.class.getMethod("getFileDescriptor", null);
            }
            method.setAccessible(true);
            Object objInvoke = method.invoke(socket, null);
            FileDescriptor fileDescriptor = objInvoke instanceof FileDescriptor ? (FileDescriptor) objInvoke : null;
            if (fileDescriptor == null) {
                return;
            }
            Class<?> cls = Class.forName("libcore.io.Os");
            Class cls2 = Integer.TYPE;
            Method method2 = cls.getMethod("setsockoptInt", FileDescriptor.class, cls2, cls2, cls2);
            Class<?> cls3 = Class.forName("libcore.io.OsConstants");
            int i2 = cls3.getField("SOL_TCP").getInt(null);
            int i3 = cls3.getField("TCP_KEEPIDLE").getInt(null);
            int i4 = cls3.getField("TCP_KEEPINTVL").getInt(null);
            int i5 = cls3.getField("TCP_KEEPCNT").getInt(null);
            method2.invoke(null, fileDescriptor, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            method2.invoke(null, fileDescriptor, Integer.valueOf(i2), Integer.valueOf(i4), 3);
            method2.invoke(null, fileDescriptor, Integer.valueOf(i2), Integer.valueOf(i5), 3);
        } catch (Throwable th) {
            Log.d("PayloadInjector", "keepalive tuning skipped: " + th.getMessage());
        }
    }

    public static int w(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static void y(Socket socket, String str) {
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = za0.l("HTTP/1.0 ", str, "\r\n\r\n").getBytes(e8.b);
        pr.i("getBytes(...)", bytes);
        outputStream.write(bytes);
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0470 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0471  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List b(java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instruction units count: 1269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.d00.b(java.lang.String, java.lang.String):java.util.List");
    }

    public final void c(Socket socket) {
        if (socket == null) {
            return;
        }
        this.p.remove(socket);
        try {
            socket.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r0 = com.sensei.tunnel.SenseiTunnelVpnService.J0;
        sensei0.xe.i("Injector[" + r21 + "]: " + r20 + " EOF after " + r9 + "B");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(java.io.PushbackInputStream r16, java.io.OutputStream r17, java.net.Socket r18, java.net.Socket r19, java.lang.String r20, int r21) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.d00.g(java.io.PushbackInputStream, java.io.OutputStream, java.net.Socket, java.net.Socket, java.lang.String, int):void");
    }

    public final boolean j() {
        zz zzVar = zz.c;
        zz zzVar2 = this.a;
        return zzVar2 == zzVar || zzVar2 == zz.d;
    }

    public final boolean n(Socket socket, int i, boolean z) {
        boolean zBooleanValue;
        fp fpVar = this.m;
        if (fpVar == null) {
            return true;
        }
        try {
            zBooleanValue = ((Boolean) fpVar.g(socket)).booleanValue();
        } catch (Exception e) {
            Log.w("PayloadInjector", "protect failed: " + e.getMessage());
            zBooleanValue = false;
        }
        if (!zBooleanValue && z) {
            boolean z2 = SenseiTunnelVpnService.J0;
            xe.i("Injector[" + i + "]: VpnService.protect() refused the upstream socket — traffic may loop into the tunnel");
        }
        return zBooleanValue;
    }

    public final boolean s(int i, PushbackInputStream pushbackInputStream, Socket socket) {
        AtomicReference atomicReference = this.B;
        Boolean bool = (Boolean) atomicReference.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        int soTimeout = socket.getSoTimeout();
        boolean zBooleanValue = false;
        try {
            socket.setSoTimeout(1500);
            byte[] bArr = new byte[5];
            int i2 = pushbackInputStream.read(bArr);
            if (i2 > 0) {
                pushbackInputStream.unread(bArr, 0, i2);
                zBooleanValue = nc0.d0(new String(bArr, 0, i2, e8.b), "HTTP/", true);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                socket.setSoTimeout(soTimeout);
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            socket.setSoTimeout(soTimeout);
        } catch (Exception unused3) {
        }
        Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
        while (!atomicReference.compareAndSet(null, boolValueOf) && atomicReference.get() == null) {
        }
        Boolean bool2 = (Boolean) atomicReference.get();
        if (bool2 != null) {
            zBooleanValue = bool2.booleanValue();
        }
        boolean z = SenseiTunnelVpnService.J0;
        xe.i("Injector[" + i + "]: upstream httpReply=" + zBooleanValue + " (sniffed once)");
        return zBooleanValue;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.List] */
    public final int t(int i) {
        ServerSocket serverSocket = new ServerSocket();
        boolean z = true;
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress("127.0.0.1", i));
        this.o = serverSocket;
        this.n.set(true);
        Thread thread = new Thread(new qg(12, this, serverSocket));
        thread.setDaemon(true);
        thread.start();
        int localPort = serverSocket.getLocalPort();
        int size = this.v.size();
        zz zzVar = zz.b;
        zz zzVar2 = this.a;
        if (zzVar2 != zzVar && zzVar2 != zz.d && !this.l) {
            z = false;
        }
        Log.i("PayloadInjector", "Injector listening on 127.0.0.1:" + localPort + " mode=" + zzVar2 + " front=" + this.r + " payload=" + this.y + "B segments=" + size + " tls=" + z);
        return serverSocket.getLocalPort();
    }

    public final void u() {
        List listR0;
        this.n.set(false);
        try {
            ServerSocket serverSocket = this.o;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        this.o = null;
        synchronized (this.p) {
            listR0 = o9.r0(this.p);
        }
        Iterator it = listR0.iterator();
        while (it.hasNext()) {
            c((Socket) it.next());
        }
        this.p.clear();
        this.q.shutdownNow();
    }

    public final void v(Socket socket) {
        this.p.add(socket);
        if (this.n.get()) {
            return;
        }
        c(socket);
    }

    public final Socket x(Socket socket, String str, int i, int i2) {
        SSLSocketFactory socketFactory;
        zz zzVar = zz.b;
        boolean z = this.l;
        zz zzVar2 = this.a;
        if (zzVar2 != zzVar && zzVar2 != zz.d && !z) {
            return socket;
        }
        String str2 = this.f;
        boolean zL0 = fc0.l0(str2);
        String str3 = this.b;
        String str4 = zL0 ? str3 : str2;
        boolean z2 = z || !(fc0.l0(str2) || str2.equalsIgnoreCase(str3));
        try {
            if (z2) {
                c00 c00Var = new c00(0);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{c00Var}, new SecureRandom());
                socketFactory = sSLContext.getSocketFactory();
            } else {
                SocketFactory socketFactory2 = SSLSocketFactory.getDefault();
                pr.g("null cannot be cast to non-null type javax.net.ssl.SSLSocketFactory", socketFactory2);
                socketFactory = (SSLSocketFactory) socketFactory2;
            }
            Socket socketCreateSocket = socketFactory.createSocket(socket, str, i, true);
            pr.g("null cannot be cast to non-null type javax.net.ssl.SSLSocket", socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (sSLParameters == null) {
                sSLParameters = new SSLParameters();
            }
            try {
                sSLParameters.setServerNames(k6.G(new SNIHostName(str4)));
            } catch (IllegalArgumentException unused) {
                Log.d("PayloadInjector", "SNI skipped (IP address or invalid): " + str4);
            }
            sSLSocket.setSSLParameters(sSLParameters);
            sSLSocket.startHandshake();
            boolean z3 = SenseiTunnelVpnService.J0;
            xe.i("Injector[" + i2 + "]: TLS established to " + str + ":" + i + " sni=" + str4 + (z2 ? " (trust-all: spoofed SNI)" : ""));
            return sSLSocket;
        } catch (Exception e) {
            String str5 = "Injector[" + i2 + "]: TLS handshake to " + str + ":" + i + " failed (" + e.getClass().getSimpleName() + ": " + e.getMessage() + ") — refusing to fall back to cleartext";
            Log.w("PayloadInjector", str5);
            boolean z4 = SenseiTunnelVpnService.J0;
            xe.i(str5);
            c(socket);
            throw new IOException(str5, e);
        }
    }

    public final int z(OutputStream outputStream, int i, String str) {
        boolean z;
        List listB = b(this.s, str);
        if (listB.isEmpty()) {
            boolean z2 = SenseiTunnelVpnService.J0;
            xe.i("Injector[" + i + "]: no payload (pass-through)");
            return 0;
        }
        char c = 2;
        cl clVar = new cl(new v9(0, listB), new a3(12), 2);
        a3 a3Var = new a3(7);
        y70 y70Var = y70.p;
        Iterator it = new cl(clVar, a3Var).iterator();
        int i2 = 0;
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                Iterator it2 = listB.iterator();
                int length = 0;
                while (it2.hasNext()) {
                    length += ((b00) it2.next()).a.length;
                }
                Iterator it3 = listB.iterator();
                int i3 = 0;
                while (true) {
                    boolean zHasNext = it3.hasNext();
                    z = this.g;
                    if (!zHasNext) {
                        break;
                    }
                    int i4 = i3 + 1;
                    b00 b00Var = (b00) it3.next();
                    byte[] bArr = b00Var.a;
                    char c2 = c;
                    boolean z4 = z3;
                    long j = b00Var.b;
                    boolean z5 = i3 == listB.size() + (-1) ? z4 : false;
                    if (!z || bArr.length <= 4) {
                        outputStream.write(bArr);
                        outputStream.flush();
                    } else {
                        int length2 = bArr.length / 2;
                        outputStream.write(bArr, 0, length2);
                        outputStream.flush();
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException unused) {
                        }
                        outputStream.write(bArr, length2, bArr.length - length2);
                        outputStream.flush();
                    }
                    if ((!z5 || j > 0) && j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (InterruptedException unused2) {
                        }
                    }
                    z3 = z4;
                    i3 = i4;
                    c = c2;
                }
                boolean z6 = SenseiTunnelVpnService.J0;
                xe.i("Injector[" + i + "]: payload sent " + length + "B in " + listB.size() + " segment(s), " + i2 + " request line(s) enhanced=" + z + (this.x ? " (auto WSS upgrade)" : ""));
                return i2;
            }
            String str2 = (String) it.next();
            pr.j("it", str2);
            String string = fc0.B0(str2).toString();
            if (!nc0.d0(string, "[method]", true)) {
                List list = L;
                if (list == null || !list.isEmpty()) {
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        if (nc0.d0(string, (String) it4.next(), true)) {
                        }
                    }
                }
            }
            i2++;
            if (i2 < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
    }
}
