package com.sensei.tunnel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.VpnService;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.util.Log;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.DynamicPortForwarder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import sensei0.a3;
import sensei0.b50;
import sensei0.c5;
import sensei0.cz;
import sensei0.d00;
import sensei0.dd0;
import sensei0.e8;
import sensei0.f5;
import sensei0.fc0;
import sensei0.hz;
import sensei0.j1;
import sensei0.jv;
import sensei0.k6;
import sensei0.kz;
import sensei0.l70;
import sensei0.m70;
import sensei0.mc0;
import sensei0.mm0;
import sensei0.n70;
import sensei0.nc0;
import sensei0.o9;
import sensei0.p9;
import sensei0.pq;
import sensei0.pr;
import sensei0.q70;
import sensei0.qg;
import sensei0.qi;
import sensei0.r70;
import sensei0.s0;
import sensei0.sg;
import sensei0.t70;
import sensei0.wh;
import sensei0.xe;
import sensei0.yi;
import sensei0.za0;
import sensei0.zz;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class SenseiTunnelVpnService extends VpnService {
    public static boolean J0 = false;
    public static long K0 = -1;
    public static String L0 = "";
    public static boolean M0;
    public static yi N0;
    public static yi O0;
    public static WeakReference P0;
    public static final b50 Q0 = new b50("(?<![\\w.-])((?:\\d{1,3}\\.){3}\\d{1,3}|(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,})(:\\d{2,5})?\\b");
    public static final ExecutorService R0;
    public volatile boolean A0;
    public volatile boolean B0;
    public long C0;
    public boolean D;
    public volatile int D0;
    public boolean E;
    public qg F0;
    public boolean G;
    public r70 G0;
    public volatile Network I;
    public boolean I0;
    public long L;
    public long M;
    public long N;
    public long O;
    public PowerManager.WakeLock S;
    public WifiManager.WifiLock T;
    public Intent U;
    public volatile int V;
    public boolean X;
    public boolean Z;
    public ParcelFileDescriptor a;
    public Process b;
    public Process c;
    public Process d0;
    public boolean e0;
    public boolean g0;
    public boolean h0;
    public boolean i0;
    public sg k0;
    public boolean n0;
    public boolean o;
    public kz p0;
    public cz q0;
    public int s;
    public Connection s0;
    public DynamicPortForwarder t0;
    public j1 u0;
    public File v0;
    public File w0;
    public File x0;
    public d00 y;
    public File y0;
    public Thread z0;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public String f = "";
    public String h = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String t = "";
    public int u = 443;
    public String v = "";
    public String w = "none";
    public String x = "";
    public int z = 1500;
    public String A = "1.1.1.1";
    public String B = "1.0.0.1";
    public boolean C = true;
    public int F = 1;
    public boolean H = true;
    public String J = "off";
    public List K = qi.a;
    public final dd0 P = new dd0(new hz(1, this));
    public final Handler Q = new Handler(Looper.getMainLooper());
    public final f5 R = new f5(10, this);
    public String W = "";
    public String Y = "";
    public String a0 = "";
    public String b0 = "";
    public String c0 = "";
    public final int f0 = 7301;
    public final int j0 = 8089;
    public final int l0 = 7353;
    public int m0 = 7353;
    public final AtomicBoolean o0 = new AtomicBoolean(false);
    public final StringBuilder r0 = new StringBuilder();
    public final Handler E0 = new Handler(Looper.getMainLooper());
    public volatile q70 H0 = new q70("", 0, "");

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new pq(2));
        pr.i("newSingleThreadExecutor(...)", executorServiceNewSingleThreadExecutor);
        R0 = executorServiceNewSingleThreadExecutor;
    }

    public static void g(String str) {
        if (nc0.d0(str, "error:", false)) {
            String strSubstring = str.substring(6);
            pr.i("substring(...)", strSubstring);
            str = za0.s("error:", Q0.d(strSubstring, new a3(17)));
        }
        new Handler(Looper.getMainLooper()).post(new m70(str, 0));
    }

    public static String i(long j) {
        if (j >= 1024) {
            return j < 1048576 ? String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1)).concat(" KB/s") : String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1)).concat(" MB/s");
        }
        return j + " B/s";
    }

    public static boolean k(ConnectivityManager connectivityManager) {
        List listC0;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null) {
            listC0 = k6.G(activeNetwork);
        } else {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            pr.i("getAllNetworks(...)", allNetworks);
            listC0 = c5.c0(allNetworks);
        }
        if (listC0.isEmpty()) {
            return false;
        }
        Iterator it = listC0.iterator();
        while (it.hasNext()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities((Network) it.next());
            if (networkCapabilities != null && networkCapabilities.hasCapability(12) && !networkCapabilities.hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(String str, String str2) throws Throwable {
        Socket socket;
        String string;
        Integer numX;
        boolean z = false;
        Socket socket2 = null;
        try {
            try {
                try {
                    socket = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 10808)));
                } catch (Exception unused) {
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            socket.setSoTimeout(5000);
            socket.connect(InetSocketAddress.createUnresolved(str, 80), 6000);
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = ("GET " + str2 + " HTTP/1.1\r\nHost: " + str + "\r\nUser-Agent: SenseiTunnel/1.0 probe\r\nConnection: close\r\n\r\n").getBytes(e8.a);
            pr.i("getBytes(...)", bytes);
            outputStream.write(bytes);
            outputStream.flush();
            String line = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
            if (line == null) {
                try {
                    socket.close();
                } catch (Exception unused2) {
                }
                return false;
            }
            String str3 = (String) o9.k0(1, fc0.t0(line, new String[]{" "}, 6));
            int iIntValue = (str3 == null || (string = fc0.z0(str3).toString()) == null || (numX = mc0.X(string)) == null) ? 0 : numX.intValue();
            Log.d("SenseiTunnelVPN", "probe[" + str + "] -> " + line);
            if (200 <= iIntValue && iIntValue < 400) {
                z = true;
            }
            socket.close();
        } catch (Exception e2) {
            e = e2;
            socket2 = socket;
            Log.d("SenseiTunnelVPN", "probe[" + str + "] failed: " + e.getMessage());
            if (socket2 != null) {
                socket2.close();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            socket2 = socket;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
        return z;
    }

    public final void A() throws InterruptedException, IOException {
        long j;
        File file = this.v0;
        if (file == null) {
            pr.V("xrayBin");
            throw null;
        }
        if (file.exists()) {
            File file2 = this.v0;
            if (file2 == null) {
                pr.V("xrayBin");
                throw null;
            }
            if (file2.length() != 0) {
                File file3 = this.y0;
                if (file3 == null) {
                    pr.V("configDir");
                    throw null;
                }
                String absolutePath = new File(file3, "config.json").getAbsolutePath();
                File file4 = this.v0;
                if (file4 == null) {
                    pr.V("xrayBin");
                    throw null;
                }
                String[] strArr = {file4.getAbsolutePath(), "run", "-c", absolutePath};
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "");
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    String str = strArr[i3];
                    i2++;
                    if (i2 > 1) {
                        sb.append((CharSequence) " ");
                    }
                    xe.c(sb, str, null);
                }
                sb.append((CharSequence) "");
                Log.i("SenseiTunnelVPN", "Starting xray: " + sb.toString());
                synchronized (this.r0) {
                    StringBuilder sb2 = this.r0;
                    pr.j("<this>", sb2);
                    sb2.setLength(0);
                }
                ProcessBuilder processBuilderRedirectErrorStream = new ProcessBuilder((String[]) Arrays.copyOf(strArr, 4)).redirectErrorStream(true);
                File file5 = this.y0;
                if (file5 == null) {
                    pr.V("configDir");
                    throw null;
                }
                ProcessBuilder processBuilderDirectory = processBuilderRedirectErrorStream.directory(file5);
                Map<String, String> mapEnvironment = processBuilderDirectory.environment();
                pr.f(mapEnvironment);
                File file6 = this.y0;
                if (file6 == null) {
                    pr.V("configDir");
                    throw null;
                }
                mapEnvironment.put("XRAY_LOCATION_ASSET", file6.getAbsolutePath());
                this.b = processBuilderDirectory.start();
                new Thread(new l70(this, 4)).start();
                while (i < 30) {
                    Thread.sleep(100L);
                    i++;
                    Process process = this.b;
                    pr.f(process);
                    if (!process.isAlive()) {
                        Process process2 = this.b;
                        pr.f(process2);
                        int iExitValue = process2.exitValue();
                        Thread.sleep(100L);
                        throw new IOException("xray failed (exit " + iExitValue + "): " + r());
                    }
                    try {
                        Socket socket = new Socket();
                        socket.connect(new InetSocketAddress("127.0.0.1", 10808), 100);
                        socket.close();
                        Log.i("SenseiTunnelVPN", "xray SOCKS5 port is ready");
                        break;
                    } catch (Exception unused) {
                    }
                }
                Process process3 = this.b;
                pr.f(process3);
                if (!process3.isAlive()) {
                    throw new IOException("xray died during startup: ".concat(r()));
                }
                Process process4 = this.b;
                pr.f(process4);
                try {
                    Field declaredField = Process.class.getDeclaredField("pid");
                    declaredField.setAccessible(true);
                    j = declaredField.getLong(process4);
                } catch (Exception unused2) {
                    j = -1;
                }
                Log.i("SenseiTunnelVPN", "xray started successfully (PID: " + j + ")");
                return;
            }
        }
        File file7 = this.v0;
        if (file7 == null) {
            pr.V("xrayBin");
            throw null;
        }
        Log.e("SenseiTunnelVPN", "xray binary not found or empty at " + file7.getAbsolutePath());
        throw new IOException("xray binary not available. Please rebuild the app with native binaries.");
    }

    public final void B() {
        Log.i("SenseiTunnelVPN", "Stopping VPN");
        g("disconnecting");
        qg qgVar = this.F0;
        if (qgVar != null) {
            this.E0.removeCallbacks(qgVar);
        }
        this.F0 = null;
        this.D0++;
        this.Q.removeCallbacks(this.R);
        try {
            r70 r70Var = this.G0;
            if (r70Var != null) {
                unregisterReceiver(r70Var);
            }
        } catch (Exception unused) {
        }
        this.G0 = null;
        this.N = 0L;
        this.H0 = new q70("", 0, "");
        this.B0 = false;
        this.A0 = false;
        this.d.set(false);
        J0 = false;
        M0 = false;
        d(false, false);
        stopForeground(1);
        stopSelf();
        g("disconnected");
        Log.i("SenseiTunnelVPN", "VPN stopped");
    }

    public final void C(boolean z) {
        String str;
        Object systemService = getSystemService("notification");
        pr.g("null cannot be cast to non-null type android.app.NotificationManager", systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            s0.C();
            NotificationChannel notificationChannelC = s0.c();
            notificationChannelC.setDescription("VPN connection status");
            notificationChannelC.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannelC);
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) MainActivity.class), 201326592);
        Intent intent = new Intent(this, (Class<?>) SenseiTunnelVpnService.class);
        intent.setAction("com.sensei.tunnel.STOP");
        PendingIntent service = PendingIntent.getService(this, 1, intent, 201326592);
        Intent intent2 = new Intent(this, (Class<?>) SenseiTunnelVpnService.class);
        intent2.setAction("com.sensei.tunnel.RECONNECT");
        PendingIntent service2 = PendingIntent.getService(this, 2, intent2, 201326592);
        String str2 = "↓ " + i(this.L) + "  ↑ " + i(this.M);
        String strL = "";
        if (this.N > 0) {
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.N) / ((long) 1000));
            int i2 = iCurrentTimeMillis / 3600;
            int i3 = (iCurrentTimeMillis % 3600) / 60;
            int i4 = iCurrentTimeMillis % 60;
            str = i2 > 0 ? String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3)) : String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
        } else {
            str = "";
        }
        if (z && str.length() > 0) {
            strL = za0.l("⏱ ", str, "  ");
        }
        String strS = za0.s(z ? "Connected to " : "Connecting to ", this.h);
        Notification.Builder ongoing = s0.b(this).setContentTitle("Sensei Tunnel").setContentText(z ? za0.k(strL, str2) : strS).setStyle(new Notification.BigTextStyle().bigText(strS + "\n" + strL + str2)).setSmallIcon(R.drawable.ic_notification).setContentIntent(activity).setOngoing(true);
        pr.i("setOngoing(...)", ongoing);
        if (z) {
            ongoing.addAction(new Notification.Action.Builder((Icon) null, "Stop", service).build());
            ongoing.addAction(new Notification.Action.Builder((Icon) null, "Reconnect", service2).build());
        }
        if (i >= 34) {
            startForeground(1, ongoing.build(), 1073741824);
        } else {
            startForeground(1, ongoing.build());
        }
    }

    public final void D() throws IOException {
        File file = this.v0;
        if (file == null) {
            pr.V("xrayBin");
            throw null;
        }
        boolean zExists = file.exists();
        File file2 = this.v0;
        if (file2 == null) {
            pr.V("xrayBin");
            throw null;
        }
        Log.i("SenseiTunnelVPN", "xray exists: " + zExists + ", size: " + file2.length());
        File file3 = this.w0;
        if (file3 == null) {
            pr.V("tun2socksBin");
            throw null;
        }
        boolean zExists2 = file3.exists();
        File file4 = this.w0;
        if (file4 == null) {
            pr.V("tun2socksBin");
            throw null;
        }
        Log.i("SenseiTunnelVPN", "tun2socks exists: " + zExists2 + ", size: " + file4.length());
        File file5 = this.v0;
        if (file5 == null) {
            pr.V("xrayBin");
            throw null;
        }
        if (file5.exists()) {
            File file6 = this.v0;
            if (file6 == null) {
                pr.V("xrayBin");
                throw null;
            }
            if (file6.length() != 0) {
                File file7 = this.w0;
                if (file7 == null) {
                    pr.V("tun2socksBin");
                    throw null;
                }
                if (file7.exists()) {
                    File file8 = this.w0;
                    if (file8 == null) {
                        pr.V("tun2socksBin");
                        throw null;
                    }
                    if (file8.length() != 0) {
                        return;
                    }
                }
                File file9 = this.w0;
                if (file9 != null) {
                    throw new IOException(za0.s("tun2socks binary missing at ", file9.getAbsolutePath()));
                }
                pr.V("tun2socksBin");
                throw null;
            }
        }
        File file10 = this.v0;
        if (file10 != null) {
            throw new IOException(za0.s("xray binary missing at ", file10.getAbsolutePath()));
        }
        pr.V("xrayBin");
        throw null;
    }

    public final boolean E() {
        AtomicBoolean atomicBoolean;
        t70 t70Var;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(ConnectivityManager.class);
        if (connectivityManager == null || k(connectivityManager)) {
            return true;
        }
        atomicBoolean = new AtomicBoolean(false);
        t70Var = new t70(atomicBoolean);
        try {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), t70Var);
            g("waiting:network");
            long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
            while (true) {
                if (this.d.get() && !atomicBoolean.get() && System.currentTimeMillis() < jCurrentTimeMillis) {
                    try {
                        Thread.sleep(200L);
                        if (k(connectivityManager)) {
                            atomicBoolean.set(true);
                            break;
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (Exception e) {
            Log.w("SenseiTunnelVPN", "registerNetworkCallback failed: " + e.getMessage());
            return k(connectivityManager);
        }
        try {
            connectivityManager.unregisterNetworkCallback(t70Var);
        } catch (Exception unused2) {
        }
        return atomicBoolean.get();
        return atomicBoolean.get();
    }

    public final void F() throws IOException {
        File file = this.y0;
        if (file == null) {
            pr.V("configDir");
            throw null;
        }
        File file2 = new File(file, "config.json");
        xe.T(file2, this.f);
        Log.i("SenseiTunnelVPN", "Xray config written to " + file2.getAbsolutePath());
        Log.d("SenseiTunnelVPN", "Config content: " + fc0.y0(500, this.f) + "...");
    }

    public final void a() {
        if (this.D || this.F == 2) {
            try {
                Object systemService = getSystemService("power");
                pr.g("null cannot be cast to non-null type android.os.PowerManager", systemService);
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, "sensei:tunnel");
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(36000000L);
                this.S = wakeLockNewWakeLock;
                Log.i("SenseiTunnelVPN", "WakeLock acquired");
            } catch (Exception e) {
                Log.w("SenseiTunnelVPN", "WakeLock failed: " + e.getMessage());
            }
        }
        if (this.D || this.F >= 1) {
            try {
                Object systemService2 = getApplicationContext().getSystemService("wifi");
                pr.g("null cannot be cast to non-null type android.net.wifi.WifiManager", systemService2);
                WifiManager wifiManager = (WifiManager) systemService2;
                int i = Build.VERSION.SDK_INT >= 29 ? 4 : 3;
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(i, "sensei:wifi");
                wifiLockCreateWifiLock.setReferenceCounted(false);
                wifiLockCreateWifiLock.acquire();
                this.T = wifiLockCreateWifiLock;
                Log.i("SenseiTunnelVPN", "WifiLock acquired (mode=" + i + ")");
            } catch (Exception e2) {
                Log.w("SenseiTunnelVPN", "WifiLock failed: " + e2.getMessage());
            }
        }
    }

    public final void b(VpnService.Builder builder) {
        List list = this.K;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String str = (String) obj;
            if (!fc0.l0(str) && !str.equals(getPackageName())) {
                arrayList.add(obj);
            }
        }
        int i = 0;
        if (pr.b(this.J, "include") && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                String str2 = (String) obj2;
                try {
                    builder.addAllowedApplication(str2);
                    i++;
                } catch (Exception e) {
                    Log.w("SenseiTunnelVPN", "Split include skip " + str2 + ": " + e.getMessage());
                }
            }
            if (i == 0) {
                f(builder);
                return;
            }
            xe.i("Split tunnel: only " + i + " app(s) routed");
            return;
        }
        f(builder);
        if (pr.b(this.J, "exclude")) {
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj3 = arrayList.get(i3);
                i3++;
                String str3 = (String) obj3;
                try {
                    builder.addDisallowedApplication(str3);
                    i++;
                } catch (Exception e2) {
                    Log.w("SenseiTunnelVPN", "Split exclude skip " + str3 + ": " + e2.getMessage());
                }
            }
            if (i > 0) {
                xe.i("Split tunnel: " + i + " app(s) bypass VPN");
            }
        }
    }

    public final void c() {
        Network network;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(ConnectivityManager.class);
        if (connectivityManager == null) {
            return;
        }
        int i = 1;
        while (true) {
            int i2 = 0;
            if (i >= 6) {
                this.A0 = false;
                Log.w("SenseiTunnelVPN", "Could not bind process to VPN network after retries");
                xe.i("App self-network bind refused — tunnel still serves other apps");
                return;
            }
            Network[] allNetworks = connectivityManager.getAllNetworks();
            pr.i("getAllNetworks(...)", allNetworks);
            int length = allNetworks.length;
            while (true) {
                if (i2 < length) {
                    network = allNetworks[i2];
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    network = null;
                    break;
                }
            }
            if (network != null) {
                try {
                    connectivityManager.bindProcessToNetwork(network);
                    this.I = network;
                    this.A0 = true;
                    Log.i("SenseiTunnelVPN", "App process bound to VPN network (attempt " + i + ")");
                    xe.i("App self-network → tunnel");
                    return;
                } catch (Exception e) {
                    Log.w("SenseiTunnelVPN", "bind attempt " + i + " failed: " + e.getMessage());
                }
            } else {
                Log.d("SenseiTunnelVPN", "VPN network not found yet (attempt " + i + ")");
            }
            try {
                Thread.sleep(300L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
    }

    public final void d(boolean z, boolean z2) {
        WifiManager.WifiLock wifiLock;
        PowerManager.WakeLock wakeLock;
        if (!z2) {
            ((SharedPreferences) this.P.a()).edit().remove("connectedAt").apply();
            this.O = 0L;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(ConnectivityManager.class);
            if (connectivityManager != null) {
                connectivityManager.bindProcessToNetwork(null);
            }
            this.I = null;
            this.A0 = false;
        } catch (Exception unused) {
        }
        try {
            Process process = this.c;
            if (process != null) {
                process.destroy();
            }
            this.c = null;
        } catch (Exception e) {
            Log.e("SenseiTunnelVPN", "Error stopping tun2socks", e);
        }
        try {
            j1 j1Var = this.u0;
            if (j1Var != null) {
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) j1Var.d;
                try {
                    ServerSocket serverSocket = (ServerSocket) j1Var.b;
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (Exception unused2) {
                }
                j1Var.b = null;
                Iterator it = copyOnWriteArraySet.iterator();
                pr.i("iterator(...)", it);
                while (it.hasNext()) {
                    try {
                        ((Socket) it.next()).close();
                    } catch (Exception unused3) {
                    }
                }
                copyOnWriteArraySet.clear();
                try {
                    ((ExecutorService) j1Var.c).shutdownNow();
                } catch (Exception unused4) {
                }
            }
            this.u0 = null;
            DynamicPortForwarder dynamicPortForwarder = this.t0;
            if (dynamicPortForwarder != null) {
                dynamicPortForwarder.close();
            }
            this.t0 = null;
            Connection connection = this.s0;
            if (connection != null) {
                connection.close();
            }
            this.s0 = null;
            this.o0.set(false);
            sg sgVar = this.k0;
            if (sgVar != null) {
                sgVar.c.set(false);
                try {
                    DatagramSocket datagramSocket = sgVar.d;
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                } catch (Exception unused5) {
                }
                sgVar.d = null;
                sgVar.e.shutdownNow();
            }
            this.k0 = null;
            this.n0 = false;
            d00 d00Var = this.y;
            if (d00Var != null) {
                d00Var.u();
            }
            this.y = null;
            Process process2 = this.d0;
            if (process2 != null) {
                process2.destroy();
            }
            this.d0 = null;
            this.e0 = false;
            try {
                cz czVar = this.q0;
                if (czVar != null) {
                    czVar.h();
                }
            } catch (Exception unused6) {
            }
            this.q0 = null;
            try {
                kz kzVar = this.p0;
                if (kzVar != null) {
                    kzVar.e();
                }
            } catch (Exception unused7) {
            }
            this.p0 = null;
            Process process3 = this.b;
            if (process3 != null) {
                process3.destroy();
            }
            this.b = null;
        } catch (Exception e2) {
            Log.e("SenseiTunnelVPN", "Error stopping xray", e2);
        }
        if (z) {
            Log.i("SenseiTunnelVPN", "Kill switch armed — TUN held open through reconnect");
        } else {
            try {
                ParcelFileDescriptor parcelFileDescriptor = this.a;
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                this.a = null;
            } catch (Exception e3) {
                Log.e("SenseiTunnelVPN", "Error closing VPN interface", e3);
            }
        }
        Thread thread = this.z0;
        if (thread != null) {
            thread.interrupt();
        }
        this.z0 = null;
        try {
            PowerManager.WakeLock wakeLock2 = this.S;
            if (wakeLock2 != null && wakeLock2.isHeld() && (wakeLock = this.S) != null) {
                wakeLock.release();
            }
        } catch (Exception unused8) {
        }
        this.S = null;
        try {
            WifiManager.WifiLock wifiLock2 = this.T;
            if (wifiLock2 != null && wifiLock2.isHeld() && (wifiLock = this.T) != null) {
                wifiLock.release();
            }
        } catch (Exception unused9) {
        }
        this.T = null;
    }

    public final void e() {
        for (String str : p9.f0("geoip.dat", "geosite.dat")) {
            File file = this.y0;
            if (file == null) {
                pr.V("configDir");
                throw null;
            }
            File file2 = new File(file, str);
            if (!file2.exists() || file2.length() <= 0) {
                try {
                    InputStream inputStreamOpen = getAssets().open("xray/" + str);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            pr.f(inputStreamOpen);
                            k6.j(inputStreamOpen, fileOutputStream);
                            fileOutputStream.close();
                            inputStreamOpen.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                    Log.i("SenseiTunnelVPN", "geo asset " + str + " not bundled, skipping");
                }
            }
        }
    }

    public final void f(VpnService.Builder builder) {
        try {
            pr.f(builder.addDisallowedApplication(getPackageName()));
        } catch (Exception e) {
            Log.w("SenseiTunnelVPN", "Failed to disallow self: " + e.getMessage());
        }
    }

    public final void h(final long j, final long j2, final long j3, final long j4) {
        this.L = j;
        this.M = j2;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: sensei0.p70
            @Override // java.lang.Runnable
            public final void run() {
                long j5 = j;
                long j6 = j2;
                long j7 = j3;
                long j8 = j4;
                try {
                    yi yiVar = SenseiTunnelVpnService.O0;
                    if (yiVar != null) {
                        yiVar.a(xv.e0(new qz("downloadSpeed", Integer.valueOf((int) j5)), new qz("uploadSpeed", Integer.valueOf((int) j6)), new qz("totalDownload", Long.valueOf(j7)), new qz("totalUpload", Long.valueOf(j8))));
                    }
                } catch (Exception e) {
                    Log.e("SenseiTunnelVPN", "Failed to emit stats", e);
                }
            }
        });
    }

    public final void j() {
        if (!this.E) {
            if (this.G) {
                g("error:tunnel down — kill switch blocking traffic");
                return;
            } else {
                B();
                return;
            }
        }
        if (this.V >= 6) {
            xe.i("Auto-reconnect gave up after 6 attempts");
            this.V = 0;
            if (this.G) {
                g("error:tunnel down — kill switch blocking traffic");
                return;
            } else {
                B();
                return;
            }
        }
        this.V++;
        int i = this.V - 1;
        if (i > 5) {
            i = 5;
        }
        final long j = 2500 << i;
        if (j > 60000) {
            j = 60000;
        }
        g("connecting");
        xe.i("Tunnel dropped — auto-reconnect attempt " + this.V + "/6 in " + (j / ((long) 1000)) + "s");
        d(this.G, true);
        this.d.set(false);
        J0 = false;
        M0 = false;
        this.D0 = this.D0 + 1;
        final int i2 = this.D0;
        Thread thread = new Thread(new Runnable() { // from class: sensei0.o70
            @Override // java.lang.Runnable
            public final void run() {
                Intent intent;
                long j2 = j;
                int i3 = i2;
                SenseiTunnelVpnService senseiTunnelVpnService = this;
                for (long j3 = 0; j3 < j2 && i3 == senseiTunnelVpnService.D0; j3 += (long) 250) {
                    try {
                        Thread.sleep(250L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (i3 != senseiTunnelVpnService.D0 || senseiTunnelVpnService.d.get() || (intent = senseiTunnelVpnService.U) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    senseiTunnelVpnService.startForegroundService(intent);
                } else {
                    senseiTunnelVpnService.startService(intent);
                }
            }
        });
        thread.setDaemon(true);
        thread.setName("sensei-reconnect");
        thread.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /** Returns whether the tunnel/direct connection is currently producing traffic. */
    public final boolean m() {
        if (!this.X) {
            return l("connectivitycheck.gstatic.com", "/generate_204");
        }
        if (this.A0) {
            try {
                java.net.HttpURLConnection connection = (java.net.HttpURLConnection)
                        new java.net.URL("http://connectivitycheck.gstatic.com/generate_204").openConnection();
                connection.setConnectTimeout(6000);
                connection.setReadTimeout(5000);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestProperty("User-Agent", "SenseiTunnel/1.0 probe");
                int code;
                try {
                    code = connection.getResponseCode();
                } finally {
                    connection.disconnect();
                }
                android.util.Log.d("SenseiTunnelVPN", "probe-direct -> " + code);
                if (code > 0) return true;
            } catch (Exception e) {
                android.util.Log.d("SenseiTunnelVPN", "probe-direct failed: " + e.getMessage());
            }
        }
        sensei0.cz stats = this.q0;
        if (stats == null) return !this.A0;
        long total = stats.B + stats.C;
        boolean active = total - this.C0 > 2000L;
        this.C0 = total;
        return active;
    }

    public final void n(String str) {
        try {
            xe.T(p(), str + "|" + this.h + "|" + System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    public final void o() {
        boolean z = false;
        if (!fc0.l0(this.r) && this.s > 0) {
            String lowerCase = this.w.toLowerCase(Locale.ROOT);
            pr.i("toLowerCase(...)", lowerCase);
            if (nc0.d0(lowerCase, "proxy", false)) {
                z = true;
            }
        }
        String str = z ? this.r : this.t;
        int i = z ? this.s : this.u;
        if (fc0.l0(str) || i <= 0) {
            K0 = -1L;
        } else {
            new Thread(new jv(str, i, 4)).start();
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        P0 = new WeakReference(this);
        File filesDir = getApplicationContext().getFilesDir();
        pr.i("getFilesDir(...)", filesDir);
        this.x0 = filesDir;
        File file = this.x0;
        if (file == null) {
            pr.V("filesDir");
            throw null;
        }
        File file2 = new File(file, "xray");
        this.y0 = file2;
        file2.mkdirs();
        File file3 = new File(getApplicationInfo().nativeLibraryDir);
        this.v0 = new File(file3, "libxray.so");
        this.w0 = new File(file3, "libtun2socks.so");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (this.d.get()) {
            Log.w("SenseiTunnelVPN", "Service destroyed while VPN running; Android/OEM killed foreground service");
        }
        P0 = null;
        super.onDestroy();
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        Log.w("SenseiTunnelVPN", "VPN permission revoked");
        B();
        super.onRevoke();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Integer numX;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1187409950) {
                if (iHashCode != -592492446) {
                    if (iHashCode == 441622231 && action.equals("com.sensei.tunnel.RECONNECT")) {
                        Intent intent2 = this.U;
                        if (intent2 == null) {
                            B();
                            return 3;
                        }
                        B();
                        qg qgVar = new qg(15, this, intent2);
                        this.F0 = qgVar;
                        this.E0.postDelayed(qgVar, 300L);
                        return 3;
                    }
                } else if (action.equals("com.sensei.tunnel.STOP")) {
                    B();
                    return 3;
                }
            } else if (action.equals("com.sensei.tunnel.START")) {
                if (!MainActivity.B) {
                    long j = ((SharedPreferences) this.P.a()).getLong("connectedAt", 0L);
                    if (j > 0) {
                        this.O = j;
                        Log.i("SenseiTunnelVPN", "Redelivered restart: continuing session started at " + j);
                    }
                }
                String stringExtra = intent.getStringExtra("address");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                int intExtra = intent.getIntExtra("port", 443);
                String stringExtra2 = intent.getStringExtra("mode");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                q70 q70Var = new q70(stringExtra, intExtra, stringExtra2);
                if (this.d.get()) {
                    if (q70Var.equals(this.H0)) {
                        Log.i("SenseiTunnelVPN", "START for the live target — already running, ignored");
                        return 3;
                    }
                    Log.i("SenseiTunnelVPN", "Server switched while live — tearing the old session down first");
                    B();
                }
                this.H0 = q70Var;
                String stringExtra3 = intent.getStringExtra("config");
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                this.f = stringExtra3;
                String stringExtra4 = intent.getStringExtra("serverName");
                if (stringExtra4 == null) {
                    stringExtra4 = "";
                }
                this.h = stringExtra4;
                this.o = intent.getBooleanExtra("isSsh", false);
                String stringExtra5 = intent.getStringExtra("sshUser");
                if (stringExtra5 == null) {
                    stringExtra5 = "";
                }
                this.p = stringExtra5;
                String stringExtra6 = intent.getStringExtra("sshPass");
                if (stringExtra6 == null) {
                    stringExtra6 = "";
                }
                this.q = stringExtra6;
                String stringExtra7 = intent.getStringExtra("injectHost");
                if (stringExtra7 == null) {
                    stringExtra7 = "";
                }
                this.r = stringExtra7;
                String stringExtra8 = intent.getStringExtra("injectPort");
                this.s = (stringExtra8 == null || (numX = mc0.X(stringExtra8)) == null) ? 0 : numX.intValue();
                String stringExtra9 = intent.getStringExtra("address");
                if (stringExtra9 == null) {
                    stringExtra9 = "";
                }
                this.t = stringExtra9;
                this.u = intent.getIntExtra("port", 443);
                String stringExtra10 = intent.getStringExtra("sni");
                if (stringExtra10 == null) {
                    stringExtra10 = "";
                }
                this.v = stringExtra10;
                String stringExtra11 = intent.getStringExtra("injectMode");
                if (stringExtra11 == null) {
                    stringExtra11 = "none";
                }
                this.w = stringExtra11;
                String stringExtra12 = intent.getStringExtra("payload");
                if (stringExtra12 == null) {
                    stringExtra12 = "";
                }
                this.x = stringExtra12;
                this.z = intent.getIntExtra("mtu", 1500);
                String stringExtra13 = intent.getStringExtra("dnsPrimary");
                if (stringExtra13 == null) {
                    stringExtra13 = "1.1.1.1";
                }
                this.A = stringExtra13;
                String stringExtra14 = intent.getStringExtra("dnsSecondary");
                if (stringExtra14 == null) {
                    stringExtra14 = "1.0.0.1";
                }
                this.B = stringExtra14;
                this.C = intent.getBooleanExtra("bypassLan", true);
                this.D = intent.getBooleanExtra("wakeLock", false);
                this.E = intent.getBooleanExtra("autoReconnect", false);
                this.F = mm0.m(intent.getIntExtra("keepAliveMode", 1), 0, 2);
                this.G = intent.getBooleanExtra("killSwitch", false);
                this.H = intent.getBooleanExtra("hotspotShare", true);
                String stringExtra15 = intent.getStringExtra("splitMode");
                if (stringExtra15 == null) {
                    stringExtra15 = "off";
                }
                this.J = stringExtra15;
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("splitApps");
                this.K = stringArrayListExtra != null ? o9.r0(stringArrayListExtra) : qi.a;
                this.U = new Intent(intent);
                String stringExtra16 = intent.getStringExtra("mode");
                if (stringExtra16 == null) {
                    stringExtra16 = "";
                }
                this.W = stringExtra16;
                boolean booleanExtra = intent.getBooleanExtra("isOpenvpn", false);
                this.X = booleanExtra;
                M0 = booleanExtra;
                String stringExtra17 = intent.getStringExtra("ovpnConfig");
                if (stringExtra17 == null) {
                    stringExtra17 = "";
                }
                this.Y = stringExtra17;
                this.Z = intent.getBooleanExtra("ovpnUseOvpn3", false);
                String stringExtra18 = intent.getStringExtra("dnsttServer");
                if (stringExtra18 == null) {
                    stringExtra18 = "";
                }
                this.a0 = stringExtra18;
                String stringExtra19 = intent.getStringExtra("dnsttKey");
                if (stringExtra19 == null) {
                    stringExtra19 = "";
                }
                this.b0 = stringExtra19;
                String stringExtra20 = intent.getStringExtra("dnsttResolver");
                this.c0 = stringExtra20 != null ? stringExtra20 : "";
                this.g0 = intent.getBooleanExtra("payloadEnhanced", false);
                this.h0 = intent.getBooleanExtra("sshCompression", false);
                this.i0 = intent.getBooleanExtra("v2rayInject", false);
                C(false);
                new Thread(new l70(this, 0)).start();
            }
        }
        return 3;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        if (this.d.get()) {
            Log.w("SenseiTunnelVPN", "App task removed while VPN running; keeping foreground VPN service alive");
            C(false);
        }
    }

    public final File p() {
        File file = this.x0;
        if (file != null) {
            return new File(file, "sensei_phase.txt");
        }
        pr.V("filesDir");
        throw null;
    }

    public final void q(String str) {
        if (this.I0) {
            return;
        }
        this.I0 = true;
        xe.i(str);
    }

    public final String r() {
        String string;
        synchronized (this.r0) {
            String string2 = this.r0.toString();
            pr.i("toString(...)", string2);
            string = fc0.z0(string2).toString();
            if (string.length() == 0) {
                string = "no xray output";
            }
        }
        return string;
    }

    public final void s() {
        if (this.G0 != null) {
            return;
        }
        r70 r70Var = new r70(this, 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        int i = Build.VERSION.SDK_INT;
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        try {
            if (i >= 33) {
                registerReceiver(r70Var, intentFilter, 4);
            } else {
                registerReceiver(r70Var, intentFilter);
            }
            this.G0 = r70Var;
        } catch (Exception e) {
            Log.w("SenseiTunnelVPN", "liveness receiver failed: " + e.getMessage());
        }
    }

    public final boolean t() {
        kz kzVar;
        Thread thread;
        Process process;
        long jCurrentTimeMillis = System.currentTimeMillis() + 8000;
        if (this.X) {
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                cz czVar = this.q0;
                if ((czVar != null && czVar.k.get() && (process = czVar.l) != null && process.isAlive()) || ((kzVar = this.p0) != null && (thread = kzVar.n) != null && thread.isAlive())) {
                    Log.i("SenseiTunnelVPN", "OpenVPN probe OK (engine alive)");
                    return true;
                }
                try {
                    Thread.sleep(200L);
                } catch (Exception unused) {
                    return false;
                }
            }
        } else {
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                try {
                    try {
                        Socket socket = new Socket();
                        socket.connect(new InetSocketAddress("127.0.0.1", 10808), 600);
                        socket.close();
                        Log.i("SenseiTunnelVPN", "Local SOCKS bind OK on 127.0.0.1:10808");
                        return true;
                    } catch (Exception unused2) {
                        Thread.sleep(200L);
                    }
                } catch (Exception unused3) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x037f A[LOOP:2: B:61:0x0129->B:141:0x037f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0343 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x034a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r19v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [int] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /**
     * Verifies that a tunnel has become usable. The original APK waits for the
     * native OpenVPN/tunnel state and then probes a small set of HTTPS endpoints.
     * This reconstruction keeps the same bounded-wait behaviour without blocking
     * indefinitely when a native component is unavailable.
     */
    public final boolean u() throws java.lang.Throwable {
        this.I0 = false;
        final long deadline = System.currentTimeMillis() + 30000L;
        while (System.currentTimeMillis() < deadline) {
            if (this.d.get()) return false;
            try {
                if (this.q0 != null && this.q0.h.get()) {
                    break;
                }
                if (this.p0 != null && this.p0.m.get()) {
                    break;
                }
            } catch (Throwable ignored) {
            }
            Thread.sleep(250L);
        }
        String[][] probes = {
                {"connectivitycheck.gstatic.com", "/generate_204"},
                {"www.google.com", "/generate_204"},
                {"cp.cloudflare.com", "/"}
        };
        for (String[] probe : probes) {
            if (this.d.get()) return false;
            try {
                if (l(probe[0], probe[1])) {
                    this.I0 = true;
                    Log.i("SenseiTunnelVPN", "Connectivity verified through tunnel (" + probe[0] + ")");
                    return true;
                }
            } catch (Throwable ignored) {
            }
        }
        return false;
    }

    public final void v() throws InterruptedException, IOException {
        File file = new File(new File(getApplicationInfo().nativeLibraryDir), "libh2.so");
        if (!file.exists() || file.length() == 0) {
            throw new IOException("dnstt (libh2) binary missing");
        }
        if (fc0.l0(this.a0)) {
            throw new IOException("DNSTT server (nameserver) is required");
        }
        String strK = this.c0;
        if (fc0.l0(strK)) {
            strK = za0.k(this.A, ":53");
        }
        String str = strK;
        String absolutePath = file.getAbsolutePath();
        String str2 = this.b0;
        String str3 = this.a0;
        int i = this.f0;
        ArrayList arrayListD0 = p9.d0(absolutePath, "-udp", str, "-pubkey", str2, str3, za0.h(i, "127.0.0.1:"));
        Object objValueOf = null;
        Log.i("SenseiTunnelVPN", "Starting dnstt: " + o9.m0(arrayListD0, " ", null, null, null, 62));
        ProcessBuilder processBuilderRedirectErrorStream = new ProcessBuilder(arrayListD0).redirectErrorStream(true);
        File file2 = this.x0;
        if (file2 == null) {
            pr.V("filesDir");
            throw null;
        }
        this.d0 = processBuilderRedirectErrorStream.directory(file2).start();
        new Thread(new l70(this, 3)).start();
        Thread.sleep(1200L);
        Process process = this.d0;
        if (process != null && process.isAlive()) {
            this.e0 = true;
            Log.i("SenseiTunnelVPN", "dnstt active on 127.0.0.1:" + i);
            return;
        }
        try {
            Process process2 = this.d0;
            if (process2 != null) {
                objValueOf = Integer.valueOf(process2.exitValue());
            }
        } catch (Exception unused) {
            objValueOf = "?";
        }
        throw new IOException("dnstt failed to start (exit " + objValueOf + ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04e1 A[EDGE_INSN: B:250:0x04e1->B:167:0x04e1 BREAK  A[LOOP:1: B:154:0x047f->B:166:0x04d7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /** Starts OpenVPN using the recovered OpenVPN2 management engine. */
    public final void w() throws java.io.IOException {
        if (fc0.l0(this.Y)) throw new java.io.IOException("OpenVPN profile is empty");
        File nativeDir = new File(getApplicationInfo().nativeLibraryDir);
        File ovpn2 = new File(nativeDir, "libovpnexec.so");
        if (!ovpn2.exists() || ovpn2.length() == 0L) {
            throw new java.io.IOException("OpenVPN engine library missing: " + ovpn2.getAbsolutePath());
        }
        if (this.Z) {
            Log.w("SenseiTunnelVPN", "OpenVPN3 requested; using recovered OpenVPN2 fallback");
        }
        cz engine = new cz(this, this.Y, this.h, this.u, this.A, this.B);
        this.q0 = engine;
        try {
            engine.g();
            Log.i("SenseiTunnelVPN", "OpenVPN engine started successfully");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.q0 = null;
            try { engine.h(); } catch (Throwable ignored) {}
            throw new java.io.IOException("OpenVPN startup interrupted", e);
        } catch (java.io.IOException e) {
            this.q0 = null;
            try { engine.h(); } catch (Throwable ignored) {}
            throw e;
        } catch (Throwable t) {
            this.q0 = null;
            try { engine.h(); } catch (Throwable ignored) {}
            throw new java.io.IOException("OpenVPN startup failed: " + t.getMessage(), t);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /**
     * Establishes the SSH transport and exposes it as a local SOCKS endpoint.
     * Payload injection is handled by d00 in the original binary; when a
     * recovered build cannot initialize that injector, we fail with a clear
     * message instead of the decompiler-generated UnsupportedOperationException.
     */
    public final void x() throws java.io.IOException {
        if (fc0.l0(this.t) || fc0.l0(this.p) || fc0.l0(this.q)) {
            throw new IOException("SSH host, username, and password are required");
        }
        boolean payloadRequested = !fc0.l0(this.w) &&
                !"none".equalsIgnoreCase(this.w) &&
                !"dnstt".equalsIgnoreCase(this.w);
        if (payloadRequested) {
            throw new IOException("Payload injector could not be reconstructed from the decompiled APK");
        }

        String host = this.t;
        int port = this.u;
        com.trilead.ssh2.Connection connection = new com.trilead.ssh2.Connection(host, port);
        connection.setCompression(this.h0);
        if (!this.e0 && !fc0.l0(this.r) && this.s > 0) {
            connection.setProxyData(new com.trilead.ssh2.HTTPProxyData(this.r, this.s));
        }
        try {
            connection.connect(null, 6000, 6000);
            if (!connection.authenticateWithPassword(this.p, this.q)) {
                connection.close();
                throw new IOException("SSH authentication failed");
            }
            String bindHost = this.H ? "0.0.0.0" : "127.0.0.1";
            this.t0 = connection.createDynamicPortForwarder(
                    new java.net.InetSocketAddress(bindHost, 10808));
            this.s0 = connection;
            Log.i("SenseiTunnelVPN", "SSH SOCKS started on 127.0.0.1:10808");

            try {
                sensei0.j1 bridge = new sensei0.j1();
                bridge.a = "127.0.0.1";
                bridge.c = java.util.concurrent.Executors.newFixedThreadPool(16, new sensei0.pq(0));
                bridge.d = new java.util.concurrent.CopyOnWriteArraySet();
                bridge.n();
                this.u0 = bridge;
                Log.i("SenseiTunnelVPN", "HTTP<->SOCKS bridge started on 127.0.0.1:10809");
            } catch (Exception bridgeError) {
                Log.w("SenseiTunnelVPN", "HTTP bridge failed: " + bridgeError.getMessage());
                xe.i("HTTP bridge failed: " + bridgeError.getMessage() + " — app self-traffic may bypass the tunnel");
            }
        } catch (java.io.IOException | RuntimeException error) {
            try { connection.close(); } catch (Exception ignored) { }
            String message = "SSH connect failed: " + error.getClass().getSimpleName() + ": " + error.getMessage();
            Log.e("SenseiTunnelVPN", message, error);
            xe.i(message);
            throw new IOException(message, error);
        }
    }

    public final void y() throws InterruptedException, IOException {
        FileDescriptor fileDescriptor;
        File file = this.w0;
        if (file == null) {
            pr.V("tun2socksBin");
            throw null;
        }
        if (file.exists()) {
            File file2 = this.w0;
            if (file2 == null) {
                pr.V("tun2socksBin");
                throw null;
            }
            if (file2.length() != 0) {
                File file3 = this.w0;
                if (file3 == null) {
                    pr.V("tun2socksBin");
                    throw null;
                }
                String absolutePath = file3.getAbsolutePath();
                String strValueOf = String.valueOf(this.z);
                File file4 = this.x0;
                if (file4 == null) {
                    pr.V("filesDir");
                    throw null;
                }
                ArrayList arrayListD0 = p9.d0(absolutePath, "--netif-ipaddr", "26.26.26.2", "--netif-netmask", "255.255.255.252", "--socks-server-addr", "127.0.0.1:10808", "--tunmtu", strValueOf, "--sock-path", new File(file4, "sock_path").getAbsolutePath(), "--enable-udprelay", "--loglevel", "notice");
                if (this.n0) {
                    arrayListD0.add("--dnsgw");
                    arrayListD0.add("127.0.0.1:" + this.m0);
                }
                Log.i("SenseiTunnelVPN", "Starting tun2socks: " + o9.m0(arrayListD0, " ", null, null, null, 62));
                ProcessBuilder processBuilderRedirectErrorStream = new ProcessBuilder(arrayListD0).redirectErrorStream(true);
                File file5 = this.x0;
                if (file5 == null) {
                    pr.V("filesDir");
                    throw null;
                }
                this.c = processBuilderRedirectErrorStream.directory(file5).start();
                new Thread(new l70(this, 2)).start();
                ParcelFileDescriptor parcelFileDescriptor = this.a;
                if (parcelFileDescriptor == null || (fileDescriptor = parcelFileDescriptor.getFileDescriptor()) == null) {
                    throw new IOException("VPN file descriptor not available");
                }
                File file6 = this.x0;
                if (file6 == null) {
                    pr.V("filesDir");
                    throw null;
                }
                new Thread(new wh(this, new File(file6, "sock_path").getAbsolutePath(), fileDescriptor, 3)).start();
                Thread.sleep(500L);
                Process process = this.c;
                pr.f(process);
                if (process.isAlive()) {
                    Log.i("SenseiTunnelVPN", "tun2socks started successfully");
                    return;
                } else {
                    Log.e("SenseiTunnelVPN", "tun2socks failed to start");
                    throw new IOException("tun2socks failed to start");
                }
            }
        }
        Log.e("SenseiTunnelVPN", "tun2socks binary not available - VPN will not route traffic");
        throw new IOException("tun2socks binary not available. Please rebuild the app with native binaries.");
    }

    public final void z() throws IOException {
        if (fc0.l0(this.t)) {
            throw new IOException("V2Ray inject needs a server address");
        }
        zz zzVar = (fc0.l0(this.r) || this.s <= 0) ? zz.a : zz.c;
        String str = this.t;
        int i = this.u;
        String str2 = this.r;
        int i2 = this.s;
        String str3 = this.v;
        String str4 = this.x;
        if (fc0.l0(str4)) {
            str4 = "HTTP/1.1 200 OK\r\n\r\n";
        }
        String str5 = str4;
        boolean z = this.g0;
        int i3 = this.F;
        d00 d00Var = new d00(zzVar, str, i, str2, i2, str3, str5, z, i3 != 0 ? i3 != 2 ? 30 : 5 : 0, false, new n70(this, 0), 6144);
        int i4 = this.j0;
        d00Var.t(i4);
        this.y = d00Var;
        Log.i("SenseiTunnelVPN", "V2Ray injector 127.0.0.1:" + i4 + " -> " + this.t + ":" + this.u + " mode=" + zzVar + " enhanced=" + this.g0);
    }
}
