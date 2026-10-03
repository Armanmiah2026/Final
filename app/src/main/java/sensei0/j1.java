package sensei0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.util.SparseArray;
import com.trilead.ssh2.sftp.AttribFlags;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {
    public Object a;
    public Object b;
    public Object c;
    public Object d;

    public j1(int i) {
        switch (i) {
            case 8:
                mz mzVar = new mz(18);
                mh mhVar = new mh(17);
                this.a = new HashSet();
                this.b = mzVar;
                this.c = mhVar;
                break;
            case 11:
                this.a = new y4(0);
                this.b = new SparseArray();
                this.c = new cv();
                this.d = new y4(0);
                break;
            default:
                this.a = new s10(10);
                this.b = new ka0(0);
                this.c = new ArrayList();
                this.d = new HashSet();
                break;
        }
    }

    public static i3 h(InputStream inputStream) {
        int i;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (byteArrayOutputStream.size() < 65536 && (i = inputStream.read(bArr)) >= 0) {
            byteArrayOutputStream.write(bArr, 0, i);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            pr.f(byteArray);
            String str = new String(byteArray, e8.c);
            int iJ0 = fc0.j0(str, "\r\n\r\n", 0, false, 6);
            if (iJ0 >= 0) {
                String strSubstring = str.substring(0, iJ0);
                pr.i("substring(...)", strSubstring);
                return new i3(strSubstring, c5.Z(iJ0 + 4, byteArray.length, byteArray), 13, false);
            }
        }
        return null;
    }

    public static void i(Socket socket, String str) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = str.getBytes(e8.a);
            pr.i("getBytes(...)", bytes);
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception unused) {
        }
        try {
            socket.close();
        } catch (Exception unused2) {
        }
    }

    public static qz m(int i, String str) {
        int iI0;
        Integer numX;
        String string = fc0.z0(str).toString();
        if (nc0.d0(string, "[", false) && (iI0 = fc0.i0(string, ']', 0, 6)) > 0) {
            String strSubstring = string.substring(1, iI0);
            pr.i("substring(...)", strSubstring);
            String strSubstring2 = string.substring(iI0 + 1);
            pr.i("substring(...)", strSubstring2);
            if (nc0.d0(strSubstring2, ":", false)) {
                String strSubstring3 = strSubstring2.substring(1);
                pr.i("substring(...)", strSubstring3);
                numX = mc0.X(strSubstring3);
            } else {
                numX = null;
            }
            if (numX != null) {
                i = numX.intValue();
            }
            return new qz(strSubstring, Integer.valueOf(i));
        }
        int iM0 = fc0.m0(string, ':');
        if (iM0 > 0) {
            String strSubstring4 = string.substring(0, iM0);
            pr.i("substring(...)", strSubstring4);
            if (!fc0.f0(strSubstring4)) {
                String strSubstring5 = string.substring(iM0 + 1);
                pr.i("substring(...)", strSubstring5);
                Integer numX2 = mc0.X(strSubstring5);
                if (numX2 != null) {
                    String strSubstring6 = string.substring(0, iM0);
                    pr.i("substring(...)", strSubstring6);
                    return new qz(strSubstring6, numX2);
                }
            }
        }
        return new qz(string, Integer.valueOf(i));
    }

    public SpannableString a() {
        if (((String) this.a) == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString((String) this.a);
        List<i1> list = (List) this.d;
        if (list != null) {
            for (i1 i1Var : list) {
                int iU = za0.u(i1Var.c);
                if (iU == 0) {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), i1Var.a, i1Var.b, 0);
                } else if (iU == 1) {
                    spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((g1) i1Var).d)), i1Var.a, i1Var.b, 0);
                }
            }
        }
        String str = (String) this.c;
        if (str != null && !str.isEmpty()) {
            spannableString.setSpan(new URLSpan((String) this.c), 0, ((String) this.a).length(), 0);
        }
        String str2 = (String) this.b;
        if (str2 != null && !str2.isEmpty()) {
            spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag((String) this.b)), 0, ((String) this.a).length(), 0);
        }
        return spannableString;
    }

    public void b(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((ka0) this.b).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                b(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public Socket c(int i, String str) throws IOException {
        InetSocketAddress inetSocketAddressCreateUnresolved;
        InetAddress inetAddress;
        Socket socket = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 10808)));
        socket.setTcpNoDelay(true);
        if (str.length() == 0) {
            inetSocketAddressCreateUnresolved = InetSocketAddress.createUnresolved(str, i);
            pr.i("createUnresolved(...)", inetSocketAddressCreateUnresolved);
        } else {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                pr.i("getAllByName(...)", allByName);
                int length = allByName.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        inetAddress = null;
                        break;
                    }
                    inetAddress = allByName[i2];
                    if (inetAddress instanceof Inet4Address) {
                        break;
                    }
                    i2++;
                }
                InetSocketAddress inetSocketAddress = inetAddress != null ? new InetSocketAddress(inetAddress, i) : InetSocketAddress.createUnresolved(str, i);
                pr.f(inetSocketAddress);
                inetSocketAddressCreateUnresolved = inetSocketAddress;
            } catch (Exception unused) {
                inetSocketAddressCreateUnresolved = InetSocketAddress.createUnresolved(str, i);
                pr.f(inetSocketAddressCreateUnresolved);
            }
        }
        socket.connect(inetSocketAddressCreateUnresolved, 12000);
        return socket;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(sensei0.yb r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.c
            sensei0.ve r0 = (sensei0.ve) r0
            boolean r1 = r7 instanceof sensei0.xd
            if (r1 == 0) goto L17
            r1 = r7
            sensei0.xd r1 = (sensei0.xd) r1
            int r2 = r1.o
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.o = r2
            goto L1c
        L17:
            sensei0.xd r1 = new sensei0.xd
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f
            int r2 = r1.o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            sensei0.j1 r0 = r1.d
            sensei0.wf0.H(r7)
            goto L64
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            sensei0.j1 r0 = r1.d
            sensei0.wf0.H(r7)
            goto L74
        L3c:
            sensei0.wf0.H(r7)
            java.lang.Object r7 = r6.d
            java.util.List r7 = (java.util.List) r7
            sensei0.vc r2 = sensei0.vc.a
            if (r7 == 0) goto L67
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L67
        L4e:
            sensei0.oa0 r7 = r0.g()
            sensei0.ae r4 = new sensei0.ae
            r5 = 0
            r4.<init>(r0, r6, r5)
            r1.d = r6
            r1.o = r3
            java.lang.Object r7 = r7.b(r4, r1)
            if (r7 != r2) goto L63
            goto L72
        L63:
            r0 = r6
        L64:
            sensei0.sd r7 = (sensei0.sd) r7
            goto L76
        L67:
            r1.d = r6
            r1.o = r4
            r7 = 0
            java.lang.Object r7 = sensei0.ve.f(r0, r7, r1)
            if (r7 != r2) goto L73
        L72:
            return r2
        L73:
            r0 = r6
        L74:
            sensei0.sd r7 = (sensei0.sd) r7
        L76:
            java.lang.Object r0 = r0.c
            sensei0.ve r0 = (sensei0.ve) r0
            sensei0.sv r0 = r0.p
            r0.F(r7)
            sensei0.mg0 r7 = sensei0.mg0.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.j1.d(sensei0.yb):java.lang.Object");
    }

    public File e(Context context) {
        ((mz) this.b).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("flutter"));
    }

    public void f(String str, Object... objArr) {
        String str2 = String.format(Locale.US, str, objArr);
        if (((b0) this.d) != null) {
            FlutterJNI.lambda$loadLibrary$0(str2);
        }
    }

    public void g(Socket socket, Socket socket2) throws IOException {
        byte[] bArr;
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.d;
        copyOnWriteArraySet.add(socket);
        copyOnWriteArraySet.add(socket2);
        Thread thread = new Thread(new qg(this, socket, socket2), "sensei-bridge-pump");
        thread.setDaemon(true);
        thread.start();
        InputStream inputStream = socket2.getInputStream();
        pr.i("getInputStream(...)", inputStream);
        OutputStream outputStream = socket.getOutputStream();
        pr.i("getOutputStream(...)", outputStream);
        try {
            bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME];
        } catch (Exception unused) {
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i >= 0) {
                outputStream.write(bArr, 0, i);
                outputStream.flush();
            }
            try {
                break;
            } catch (Exception unused2) {
            }
        }
        socket.close();
        try {
            socket2.close();
        } catch (Exception unused3) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object j(sensei0.yb r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof sensei0.b60
            if (r0 == 0) goto L13
            r0 = r8
            sensei0.b60 r0 = (sensei0.b60) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            sensei0.b60 r0 = new sensei0.b60
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.h
            int r1 = r0.p
            r2 = 2
            r3 = 1
            sensei0.mg0 r4 = sensei0.mg0.a
            r5 = 0
            sensei0.vc r6 = sensei0.vc.a
            if (r1 == 0) goto L43
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            sensei0.hy r1 = r0.f
            sensei0.j1 r0 = r0.d
            sensei0.wf0.H(r8)     // Catch: java.lang.Throwable -> L31
            goto L86
        L31:
            r8 = move-exception
            goto L8e
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            sensei0.hy r1 = r0.f
            sensei0.j1 r3 = r0.d
            sensei0.wf0.H(r8)
            goto L66
        L43:
            sensei0.wf0.H(r8)
            java.lang.Object r8 = r7.b
            sensei0.da r8 = (sensei0.da) r8
            java.lang.Object r8 = r8.D()
            boolean r8 = r8 instanceof sensei0.wq
            if (r8 != 0) goto L53
            return r4
        L53:
            java.lang.Object r8 = r7.a
            sensei0.ky r8 = (sensei0.ky) r8
            r0.d = r7
            r0.f = r8
            r0.p = r3
            java.lang.Object r1 = r8.c(r0)
            if (r1 != r6) goto L64
            goto L84
        L64:
            r3 = r7
            r1 = r8
        L66:
            java.lang.Object r8 = r3.b     // Catch: java.lang.Throwable -> L31
            sensei0.da r8 = (sensei0.da) r8     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r8.D()     // Catch: java.lang.Throwable -> L31
            boolean r8 = r8 instanceof sensei0.wq     // Catch: java.lang.Throwable -> L31
            if (r8 != 0) goto L78
        L72:
            sensei0.ky r1 = (sensei0.ky) r1
            r1.e(r5)
            return r4
        L78:
            r0.d = r3     // Catch: java.lang.Throwable -> L31
            r0.f = r1     // Catch: java.lang.Throwable -> L31
            r0.p = r2     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r3.d(r0)     // Catch: java.lang.Throwable -> L31
            if (r8 != r6) goto L85
        L84:
            return r6
        L85:
            r0 = r3
        L86:
            java.lang.Object r8 = r0.b     // Catch: java.lang.Throwable -> L31
            sensei0.da r8 = (sensei0.da) r8     // Catch: java.lang.Throwable -> L31
            r8.J(r4)     // Catch: java.lang.Throwable -> L31
            goto L72
        L8e:
            sensei0.ky r1 = (sensei0.ky) r1
            r1.e(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.j1.j(sensei0.yb):java.lang.Object");
    }

    public void k(Object obj, v5 v5Var) {
        ((a6) this.b).p((String) this.a, ((dx) this.c).a(obj), v5Var == null ? null : new t5(0, this, v5Var));
    }

    public void l(u5 u5Var) {
        String str = (String) this.a;
        a6 a6Var = (a6) this.b;
        mh mhVar = (mh) this.d;
        if (mhVar != null) {
            a6Var.t(str, u5Var != null ? new i3(4, this, u5Var) : null, mhVar);
        } else {
            a6Var.b(str, u5Var != null ? new i3(4, this, u5Var) : null);
        }
    }

    public void n() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress((String) this.a, 10809), 64);
        this.b = serverSocket;
        Thread thread = new Thread(new qg(1, serverSocket, this), "sensei-http-bridge-accept");
        thread.setDaemon(true);
        thread.start();
    }

    public j1(a6 a6Var, String str, dx dxVar, mh mhVar) {
        this.b = a6Var;
        this.a = str;
        this.c = dxVar;
        this.d = mhVar;
    }

    public j1(Typeface typeface, rx rxVar) {
        int i;
        int i2;
        int i3;
        int i4;
        this.d = typeface;
        this.a = rxVar;
        this.c = new sx(1024);
        int iA = rxVar.a(6);
        if (iA != 0) {
            int i5 = iA + rxVar.a;
            i = ((ByteBuffer) rxVar.d).getInt(((ByteBuffer) rxVar.d).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.b = new char[i * 2];
        int iA2 = rxVar.a(6);
        if (iA2 != 0) {
            int i6 = iA2 + rxVar.a;
            i2 = ((ByteBuffer) rxVar.d).getInt(((ByteBuffer) rxVar.d).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            eg0 eg0Var = new eg0(this, i7);
            qx qxVarB = eg0Var.b();
            int iA3 = qxVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) qxVarB.d).getInt(iA3 + qxVarB.a) : 0, (char[]) this.b, i7 * 2);
            qx qxVarB2 = eg0Var.b();
            int iA4 = qxVarB2.a(16);
            if (iA4 != 0) {
                int i8 = iA4 + qxVarB2.a;
                i3 = ((ByteBuffer) qxVarB2.d).getInt(((ByteBuffer) qxVarB2.d).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            pr.d("invalid metadata codepoint length", i3 > 0);
            sx sxVar = (sx) this.c;
            qx qxVarB3 = eg0Var.b();
            int iA5 = qxVarB3.a(16);
            if (iA5 != 0) {
                int i9 = iA5 + qxVarB3.a;
                i4 = ((ByteBuffer) qxVarB3.d).getInt(((ByteBuffer) qxVarB3.d).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            sxVar.a(eg0Var, 0, i4 - 1);
        }
    }
}
