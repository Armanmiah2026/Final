package sensei0;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.SystemClock;
import android.system.Os;
import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cz {
    public final ArrayList A;
    public volatile long B;
    public volatile long C;
    public final b50 D;
    public final SenseiTunnelVpnService a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final AtomicReference g;
    public final AtomicBoolean h;
    public final AtomicReference i;
    public final AtomicReference j;
    public final AtomicBoolean k;
    public Process l;
    public Thread m;
    public Thread n;
    public LocalServerSocket o;
    public LocalSocket p;
    public LocalSocket q;
    public OutputStream r;
    public final r4 s;
    public String t;
    public int u;
    public String v;
    public int w;
    public final ArrayList x;
    public final ArrayList y;
    public final ArrayList z;

    public cz(SenseiTunnelVpnService senseiTunnelVpnService, String str, String str2, int i, String str3, String str4) {
        pr.j("profileText", str);
        pr.j("dnsPrimary", str3);
        pr.j("dnsSecondary", str4);
        this.a = senseiTunnelVpnService;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = new AtomicReference(null);
        this.h = new AtomicBoolean(false);
        this.i = new AtomicReference(null);
        this.j = new AtomicReference(null);
        this.k = new AtomicBoolean(false);
        this.s = new r4();
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.D = new b50("^\\d+\\.\\d+ [0-9a-f]+ ");
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"' || cCharAt == '\\') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        String string = sb.toString();
        pr.i("toString(...)", string);
        return string;
    }

    public static Integer b(String str) {
        int iIntValue;
        List listT0 = fc0.t0(str, new String[]{"."}, 6);
        if (listT0.size() != 4) {
            return null;
        }
        Iterator it = listT0.iterator();
        int i = 0;
        while (it.hasNext()) {
            Integer numX = mc0.X((String) it.next());
            if (numX == null || (iIntValue = numX.intValue()) < 0 || iIntValue > 255) {
                return null;
            }
            i = (i << 8) | iIntValue;
        }
        return Integer.valueOf(i);
    }

    public static int c(String str, String str2, String str3) {
        Integer numB = b(str);
        if (numB == null) {
            return 32;
        }
        long j = ~numB.intValue();
        if ((j & (1 + j)) == 0) {
            return Integer.bitCount(numB.intValue());
        }
        Integer numB2 = b(str2);
        if (numB2 == null) {
            return 32;
        }
        int iIntValue = numB2.intValue();
        if (str3.equalsIgnoreCase("net30") && (numB.intValue() & (-4)) == (iIntValue & (-4))) {
            return 30;
        }
        if (str3.equalsIgnoreCase("p2p") && (numB.intValue() & (-2)) == (iIntValue & (-2))) {
            return 31;
        }
        if ((numB.intValue() & (-4)) == (iIntValue & (-4))) {
            return 30;
        }
        return (numB.intValue() & (-2)) == (iIntValue & (-2)) ? 31 : 32;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03ef, code lost:
    
        if (r6.equals("NEED-CERT") == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03f2, code lost:
    
        android.util.Log.w("OpenVpn2Engine", "unexpected external-PKI request: ".concat(r28));
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x088d, code lost:
    
        if (r2.equals("DNSSERVER") == false) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x08ab, code lost:
    
        if (r2.equals("HTTPPROXY") == false) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b0, code lost:
    
        if (r6.equals("PK_SIGN") == false) goto L179;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0882  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(java.lang.String r28) {
        /*
            Method dump skipped, instruction units count: 2640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.cz.d(java.lang.String):void");
    }

    public final void e(FileDescriptor fileDescriptor) {
        try {
            try {
                Object objInvoke = FileDescriptor.class.getDeclaredMethod("getInt$", null).invoke(fileDescriptor, null);
                pr.g("null cannot be cast to non-null type kotlin.Int", objInvoke);
                int iIntValue = ((Integer) objInvoke).intValue();
                if (!this.a.protect(iIntValue)) {
                    boolean z = SenseiTunnelVpnService.J0;
                    xe.i("ovpn2: could not protect socket fd=" + iIntValue);
                }
            } finally {
                try {
                    Os.close(fileDescriptor);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e) {
            Log.w("OpenVpn2Engine", "protectFd: " + e.getMessage());
        }
    }

    public final void f(String str) {
        OutputStream outputStream;
        try {
            LocalSocket localSocket = this.q;
            if (localSocket != null && (outputStream = localSocket.getOutputStream()) != null) {
                byte[] bytes = str.getBytes(e8.a);
                pr.i("getBytes(...)", bytes);
                outputStream.write(bytes);
                outputStream.flush();
            }
        } catch (Exception unused) {
        }
    }

    public final void g() throws InterruptedException, IOException {
        AtomicReference atomicReference;
        String strConcat;
        String strConcat2;
        SenseiTunnelVpnService senseiTunnelVpnService = this.a;
        String str = senseiTunnelVpnService.getApplicationInfo().nativeLibraryDir;
        File file = new File(str, "libovpnexec.so");
        if (!file.exists()) {
            throw new IOException(za0.l("libovpnexec.so missing from ", str, " — the OpenVPN 2.x native libs are not packaged in this build"));
        }
        String absolutePath = new File(senseiTunnelVpnService.getCacheDir(), "ovpn2-mgmt").getAbsolutePath();
        pr.f(absolutePath);
        try {
            new File(absolutePath).delete();
        } catch (Exception unused) {
        }
        LocalSocket localSocket = new LocalSocket();
        for (int i = 8; i > 0 && !localSocket.isBound(); i--) {
            try {
                localSocket.bind(new LocalSocketAddress(absolutePath, LocalSocketAddress.Namespace.FILESYSTEM));
            } catch (IOException unused2) {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException unused3) {
                }
            }
        }
        if (!localSocket.isBound()) {
            throw new IOException("Could not bind OpenVPN2 management socket at ".concat(absolutePath));
        }
        this.p = localSocket;
        this.o = new LocalServerSocket(localSocket.getFileDescriptor());
        String strC0 = nc0.c0(nc0.c0(this.b, "\r\n", "\n", false), "\r", "\n", false);
        StringBuilder sb = new StringBuilder("# Sensei Tunnel — OpenVPN 2.x (management-driven)\nmanagement ");
        sb.append(absolutePath);
        sb.append(" unix\nmanagement-client\nmanagement-query-passwords\nmanagement-hold\nmachine-readable-output\nifconfig-nowarn\nverb 4\n");
        List<String> listO0 = fc0.o0(strC0);
        ArrayList arrayList = new ArrayList();
        for (String str2 : listO0) {
            String lowerCase = fc0.z0(str2).toString().toLowerCase(Locale.ROOT);
            pr.i("toLowerCase(...)", lowerCase);
            if (!nc0.d0(lowerCase, "management", false) && !nc0.d0(lowerCase, "machine-readable-output", false) && !nc0.d0(lowerCase, "verb ", false) && !nc0.d0(lowerCase, "route-noexec", false) && !nc0.d0(lowerCase, "dev-node", false) && !nc0.d0(lowerCase, "user ", false) && !nc0.d0(lowerCase, "group ", false) && !nc0.d0(lowerCase, "chroot", false) && !nc0.d0(lowerCase, "daemon", false) && !nc0.d0(lowerCase, "script-security", false) && !nc0.d0(lowerCase, "up ", false) && !nc0.d0(lowerCase, "down ", false) && !nc0.d0(lowerCase, "route-up", false) && !nc0.d0(lowerCase, "route-pre-down", false) && !nc0.d0(lowerCase, "ifconfig-noexec", false) && !nc0.d0(lowerCase, "block-outside-dns", false) && !nc0.d0(lowerCase, "register-dns", false) && !nc0.d0(lowerCase, "log ", false) && !nc0.d0(lowerCase, "log-append", false) && !nc0.d0(lowerCase, "status ", false) && !nc0.d0(lowerCase, "mute ", false) && (lowerCase.equals("dev tun") || !nc0.d0(lowerCase, "dev ", false) || nc0.d0(lowerCase, "dev tun", false))) {
                sb.append(str2);
                sb.append('\n');
            } else if (lowerCase.length() > 0 && !nc0.d0(lowerCase, "#", false) && !nc0.d0(lowerCase, ";", false)) {
                arrayList.add(fc0.z0(str2).toString());
            }
        }
        Pattern patternCompile = Pattern.compile("(?im)^\\s*dev\\s+tun");
        pr.i("compile(...)", patternCompile);
        if (!patternCompile.matcher(strC0).find()) {
            sb.append("dev tun\n");
        }
        Pattern patternCompile2 = Pattern.compile("(?im)^\\s*allow-compression\\b");
        pr.i("compile(...)", patternCompile2);
        if (!patternCompile2.matcher(strC0).find()) {
            sb.append("allow-compression asym\n");
        }
        Pattern patternCompile3 = Pattern.compile("(?im)^\\s*(cipher|auth)\\s+none\\b");
        pr.i("compile(...)", patternCompile3);
        if (patternCompile3.matcher(strC0).find()) {
            sb.append("allow-deprecated-insecure-static-crypto\n");
        }
        String str3 = "";
        if (!arrayList.isEmpty()) {
            Log.i("OpenVpn2Engine", "ovpn2 dropped " + arrayList.size() + " unsupported directives: " + arrayList);
            boolean z = SenseiTunnelVpnService.J0;
            xe.i("ovpn2: ignored " + arrayList.size() + " Android-incompatible option(s): " + o9.m0(o9.o0(6, arrayList), ", ", null, null, null, 62) + (arrayList.size() > 6 ? ", …" : ""));
        }
        String string = sb.toString();
        pr.i("toString(...)", string);
        this.k.set(true);
        pr.f(str);
        ProcessBuilder processBuilder = new ProcessBuilder((List<String>) p9.f0(file.getAbsolutePath(), "--config", "stdin"));
        Map<String, String> mapEnvironment = processBuilder.environment();
        pr.i("environment(...)", mapEnvironment);
        mapEnvironment.put("LD_LIBRARY_PATH", str);
        Map<String, String> mapEnvironment2 = processBuilder.environment();
        pr.i("environment(...)", mapEnvironment2);
        mapEnvironment2.put("TMPDIR", senseiTunnelVpnService.getCacheDir().getAbsolutePath());
        processBuilder.redirectErrorStream(true);
        Process processStart = processBuilder.start();
        this.l = processStart;
        this.r = processStart.getOutputStream();
        try {
            OutputStream outputStream = processStart.getOutputStream();
            byte[] bytes = string.getBytes(e8.a);
            pr.i("getBytes(...)", bytes);
            outputStream.write(bytes);
            processStart.getOutputStream().flush();
            processStart.getOutputStream().close();
            Thread thread = new Thread(new qg(10, processStart, this));
            thread.setDaemon(true);
            thread.setName("ovpn2-stdout");
            thread.start();
            this.m = thread;
            Thread thread2 = new Thread(new u2(9, this));
            thread2.setDaemon(true);
            thread2.setName("ovpn2-mgmt");
            thread2.start();
            this.n = thread2;
            long jElapsedRealtime = SystemClock.elapsedRealtime() + 40000;
            boolean z2 = SenseiTunnelVpnService.J0;
            xe.i("ovpn2 waiting up to 40s for the tunnel…");
            long j = 0;
            while (true) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                atomicReference = this.i;
                if (jElapsedRealtime2 >= jElapsedRealtime) {
                    String str4 = (String) atomicReference.get();
                    if (str4 != null && (strConcat = "; last error: ".concat(str4)) != null) {
                        str3 = strConcat;
                    }
                    throw new IOException("OpenVPN2 tunnel never established (no OPENTUN within 40s)".concat(str3));
                }
                Integer num = (Integer) this.j.get();
                if (num != null) {
                    Log.i("OpenVpn2Engine", "OpenVPN2 TUN established, fd=" + num.intValue());
                    return;
                }
                String str5 = (String) atomicReference.get();
                if (str5 != null) {
                    throw new IOException("OpenVPN2 failed: ".concat(str5));
                }
                Process process = this.l;
                if (process == null || !process.isAlive()) {
                    break;
                }
                long jElapsedRealtime3 = 40000 - (jElapsedRealtime - SystemClock.elapsedRealtime());
                if (jElapsedRealtime3 - j >= 8000) {
                    boolean z3 = SenseiTunnelVpnService.J0;
                    xe.i("ovpn2 still connecting (t=" + (jElapsedRealtime3 / ((long) 1000)) + "s)");
                    j = jElapsedRealtime3;
                }
                Thread.sleep(50L);
            }
            String str6 = (String) atomicReference.get();
            if (str6 != null && (strConcat2 = "; ".concat(str6)) != null) {
                str3 = strConcat2;
            }
            throw new IOException("OpenVPN2 process exited early".concat(str3));
        } catch (Exception e) {
            throw new IOException(za0.s("Could not write profile to OpenVPN2 stdin: ", e.getMessage()), e);
        }
    }

    public final void h() {
        this.k.set(false);
        f("signal SIGINT\n");
        try {
            Thread.sleep(120L);
        } catch (InterruptedException unused) {
        }
        try {
            LocalSocket localSocket = this.q;
            if (localSocket != null) {
                localSocket.close();
            }
        } catch (Exception unused2) {
        }
        try {
            LocalServerSocket localServerSocket = this.o;
            if (localServerSocket != null) {
                localServerSocket.close();
            }
        } catch (Exception unused3) {
        }
        try {
            LocalSocket localSocket2 = this.p;
            if (localSocket2 != null) {
                localSocket2.close();
            }
        } catch (Exception unused4) {
        }
        try {
            OutputStream outputStream = this.r;
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception unused5) {
        }
        try {
            Process process = this.l;
            if (process != null) {
                process.destroy();
            }
        } catch (Exception unused6) {
        }
        Thread thread = this.n;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = this.m;
        if (thread2 != null) {
            thread2.interrupt();
        }
        this.n = null;
        this.m = null;
        this.l = null;
        this.g.set(null);
    }
}
