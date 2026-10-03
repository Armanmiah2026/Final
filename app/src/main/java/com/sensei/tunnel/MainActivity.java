package com.sensei.tunnel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Base64;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;
import sensei0.a3;
import sensei0.aj;
import sensei0.c5;
import sensei0.e8;
import sensei0.fc0;
import sensei0.fp;
import sensei0.gv;
import sensei0.hc;
import sensei0.jv;
import sensei0.mc0;
import sensei0.mm0;
import sensei0.nc0;
import sensei0.o9;
import sensei0.ov;
import sensei0.p9;
import sensei0.pq;
import sensei0.pr;
import sensei0.pv;
import sensei0.q9;
import sensei0.qg;
import sensei0.qi;
import sensei0.qz;
import sensei0.rk;
import sensei0.vl;
import sensei0.w2;
import sensei0.xe;
import sensei0.xv;
import sensei0.yf;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends vl {
    public static boolean B;
    public aj u;
    public Map v;
    public rk w;
    public Dialog x;
    public boolean z;
    public final String h = "com.sensei.tunnel/vpn";
    public final String o = "com.sensei.tunnel/vpn_state";
    public final String p = "com.sensei.tunnel/vpn_stats";
    public final int q = 21588;
    public final int r = 21589;
    public final int s = 21590;
    public final String t = "SenseiTunnel:JubairSensei:2026:v2";
    public final ExecutorService y = Executors.newSingleThreadExecutor(new pq(1));
    public final ArrayList A = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /**
     * Scans /proc/net/tcp and /proc/net/tcp6 for the local tunnel ports used by
     * the app. This is reconstructed from the original APK bytecode because
     * JADX could not recover the Java body.
     */
    public static java.util.Map B() {
        java.util.Set<Integer> targetPorts = new java.util.HashSet<>();
        targetPorts.add(0x2a38); // 10808
        targetPorts.add(0x2a39); // 10809
        targetPorts.add(0x1cb9); // 7353

        java.util.LinkedHashSet<String> devices = new java.util.LinkedHashSet<>();
        int count = 0;
        String[] files = {"/proc/net/tcp", "/proc/net/tcp6"};
        for (String fileName : files) {
            try {
                java.util.ArrayList<String> lines = sensei0.xe.z(new java.io.File(fileName));
                for (String line : lines) {
                    try {
                        String[] parts = line.trim().split("\\s+");
                        if (parts.length < 4) continue;
                        String state = parts[3];
                        if (!state.startsWith("01")) continue;
                        int colon = parts[1].indexOf(':');
                        if (colon < 0) continue;
                        Integer port = Integer.valueOf(parts[1].substring(colon + 1), 16);
                        if (!targetPorts.contains(port)) continue;
                        count++;
                        String address = parts[2];
                        int addressColon = address.indexOf(':');
                        if (addressColon >= 0) address = address.substring(0, addressColon);
                        String host;
                        if (fileName.endsWith("6")) {
                            host = s(address);
                        } else {
                            try {
                                long value = Long.parseLong(address, 16);
                                host = ((value >>> 24) & 255) + "." + ((value >>> 16) & 255) + "."
                                        + ((value >>> 8) & 255) + "." + (value & 255);
                            } catch (Exception ignored) {
                                host = "";
                            }
                        }
                        if (!host.isEmpty() && !host.startsWith("127.") && !host.equals("::1")) {
                            devices.add(host);
                        }
                    } catch (Exception ignored) {
                        // Ignore malformed kernel rows.
                    }
                }
            } catch (Exception ignored) {
                // /proc files can be unavailable on restricted Android builds.
            }
        }
        java.util.LinkedHashMap<String, Object> result = new java.util.LinkedHashMap<>();
        result.put("count", Integer.valueOf(count));
        result.put("devices", new java.util.ArrayList<>(devices));
        return result;
    }

    public static LinkedHashMap D(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONObject) {
                objOpt = D((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) objOpt;
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    Object objOpt2 = jSONArray.opt(i);
                    if (objOpt2 instanceof JSONObject) {
                        objOpt2 = D((JSONObject) objOpt2);
                    }
                    arrayList.add(objOpt2);
                }
                objOpt = arrayList;
            }
            linkedHashMap.put(next, objOpt);
        }
        return linkedHashMap;
    }

    public static List n() {
        return p9.f0(new ov("APN settings", new w2(18)), new ov("mobile network list", new w2(19)), new ov("mobile network settings", new w2(20)), new ov("network operator settings", new w2(21)), new ov("data roaming settings", new w2(22)), new ov("data usage settings", new w2(23)), new ov("network dashboard", new w2(24)), new ov("wireless settings", new w2(25)), new ov("settings home", new w2(26)));
    }

    public static int o(int i, Object obj) {
        Integer numX;
        return obj instanceof Integer ? ((Number) obj).intValue() : obj instanceof Long ? (int) ((Number) obj).longValue() : (!(obj instanceof String) || (numX = mc0.X((String) obj)) == null) ? i : numX.intValue();
    }

    public static String s(String str) {
        try {
            int length = str.length();
            int i = 0;
            ArrayList arrayList = new ArrayList((length / 8) + (length % 8 == 0 ? 0 : 1));
            int i2 = 0;
            while (i2 >= 0 && i2 < length) {
                int i3 = i2 + 8;
                CharSequence charSequenceSubSequence = str.subSequence(i2, (i3 < 0 || i3 > length) ? length : i3);
                pr.j("it", charSequenceSubSequence);
                arrayList.add(charSequenceSubSequence.toString());
                i2 = i3;
            }
            if (arrayList.size() < 4) {
                return "";
            }
            ArrayList arrayList2 = new ArrayList(q9.h0(arrayList));
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                pr.k(16);
                arrayList2.add(Long.valueOf(Long.parseLong((String) obj, 16)));
            }
            if (((Number) arrayList2.get(2)).longValue() != 4294901760L) {
                return o9.m0(arrayList2, ":", null, null, new a3(5), 30);
            }
            long jLongValue = ((Number) arrayList2.get(3)).longValue();
            return (jLongValue & 255) + "." + ((jLongValue >> 8) & 255) + "." + ((jLongValue >> 16) & 255) + "." + ((jLongValue >> 24) & 255);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String u(Map map, String str) {
        Object obj = map.get(str);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? "" : str2;
    }

    public static List w() {
        return p9.f0(new ov("phone info (com.android.phone RadioInfo)", new w2(9)), new ov("testing menu (Settings$TestingSettingsActivity)", new w2(10)), new ov("testing menu (com.android.settings RadioInfo)", new w2(11)), new ov("testing menu (legacy TestingSettings)", new w2(12)), new ov("mobile network list", new w2(13)), new ov("mobile network page", new w2(14)), new ov("mobile network settings", new w2(15)), new ov("network operator settings", new w2(16)), new ov("network dashboard", new w2(17)));
    }

    public final void A() {
        ArrayList arrayList;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        List list = qi.a;
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) getSystemService(SubscriptionManager.class);
            if (subscriptionManager == null || (activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (Object obj : activeSubscriptionInfoList) {
                    if (((SubscriptionInfo) obj).getSimSlotIndex() >= 0) {
                        arrayList.add(obj);
                    }
                }
            }
            if (arrayList != null) {
                list = arrayList;
            }
        } catch (SecurityException unused) {
        }
        int size = list.size();
        if (size == 0) {
            boolean z = SenseiTunnelVpnService.J0;
            xe.i("Network settings: no active SIM — falling back to the general chain");
            x(false);
        } else if (size != 1) {
            runOnUiThread(new qg(9, this, o9.n0(list, new hc(2))));
        } else {
            new Thread(new jv(this, ((SubscriptionInfo) list.get(0)).getSubscriptionId(), 0)).start();
        }
    }

    public final void C(String str, boolean z) {
        if (fc0.l0(str)) {
            return;
        }
        try {
            runOnUiThread(new yf(this, str, z ? 1 : 0));
        } catch (Exception unused) {
        }
    }

    public final boolean E(Intent intent, String str) {
        boolean z;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        pv pvVar = new pv(this, atomicBoolean);
        try {
            getApplication().registerActivityLifecycleCallbacks(pvVar);
            try {
                startActivity(intent.addFlags(268435456));
                long jCurrentTimeMillis = System.currentTimeMillis() + ((long) 700);
                while (!atomicBoolean.get() && System.currentTimeMillis() < jCurrentTimeMillis) {
                    Thread.sleep(50L);
                }
                if (atomicBoolean.get()) {
                    boolean z2 = SenseiTunnelVpnService.J0;
                    xe.i("Network settings: opened via " + str);
                    z = true;
                } else {
                    boolean z3 = SenseiTunnelVpnService.J0;
                    xe.i("Network settings: " + str + " was accepted but nothing opened — trying the next target");
                    z = false;
                }
                getApplication().unregisterActivityLifecycleCallbacks(pvVar);
                return z;
            } catch (Throwable th) {
                getApplication().unregisterActivityLifecycleCallbacks(pvVar);
                throw th;
            }
        } catch (Exception e) {
            boolean z4 = SenseiTunnelVpnService.J0;
            xe.i("Network settings: " + str + " failed (" + e.getClass().getSimpleName() + ": " + e.getMessage() + ")");
            return false;
        }
    }

    public final SecretKeySpec m() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = this.t.getBytes(e8.a);
        pr.i("getBytes(...)", bytes);
        return new SecretKeySpec(messageDigest.digest(bytes), "AES");
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != this.q) {
            return;
        }
        boolean z = i2 == -1;
        Map map = this.v;
        rk rkVar = this.w;
        this.v = null;
        this.w = null;
        if (map != null) {
            if (!z) {
                if (rkVar != null) {
                    rkVar.d(Boolean.FALSE);
                }
            } else {
                t(map);
                if (rkVar != null) {
                    rkVar.d(Boolean.TRUE);
                }
            }
        }
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B = true;
        q(getIntent());
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onDestroy() {
        B = false;
        this.z = false;
        rk rkVar = this.w;
        if (rkVar != null) {
            try {
                rkVar.a("activity_destroyed", "Activity destroyed", null);
            } catch (Exception unused) {
            }
        }
        this.w = null;
        this.v = null;
        try {
            Dialog dialog = this.x;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception unused2) {
        }
        this.x = null;
        super.onDestroy();
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onNewIntent(Intent intent) {
        pr.j("intent", intent);
        super.onNewIntent(intent);
        q(intent);
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        pr.j("permissions", strArr);
        pr.j("grantResults", iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != this.s) {
            return;
        }
        boolean z = iArr.length != 0 && iArr[0] == 0;
        boolean z2 = SenseiTunnelVpnService.J0;
        xe.i("Network settings: phone permission ".concat(z ? "granted" : "denied"));
        if (z) {
            new Thread(new gv(this, 2)).start();
        } else {
            C("Phone permission is needed to pre-select the SIM — opening the general settings", true);
            x(false);
        }
    }

    @Override // sensei0.vl, android.app.Activity
    public final void onResume() {
        super.onResume();
        boolean z = SenseiTunnelVpnService.J0;
        WeakReference weakReference = SenseiTunnelVpnService.P0;
        SenseiTunnelVpnService senseiTunnelVpnService = weakReference != null ? (SenseiTunnelVpnService) weakReference.get() : null;
        if (senseiTunnelVpnService == null || !senseiTunnelVpnService.d.get()) {
            return;
        }
        senseiTunnelVpnService.B0 = true;
    }

    public final void p(String str, String str2) {
        if (!this.z) {
            this.A.add(new qz(str, str2));
        } else {
            aj ajVar = this.u;
            if (ajVar != null) {
                ajVar.a(str, str2, null);
            }
        }
    }

    public final void q(Intent intent) {
        String stringExtra;
        String dataString;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1173264947) {
                if (!action.equals("android.intent.action.SEND") || (stringExtra = intent.getStringExtra("android.intent.extra.TEXT")) == null || fc0.l0(stringExtra)) {
                    return;
                }
                p("onSharedText", stringExtra);
                return;
            }
            if (iHashCode == -1173171990 && action.equals("android.intent.action.VIEW") && (dataString = intent.getDataString()) != null) {
                List listF0 = p9.f0("darktunnel://", "vless://", "vmess://", "trojan://", "ss://");
                if (!listF0.isEmpty()) {
                    Iterator it = listF0.iterator();
                    while (it.hasNext()) {
                        if (nc0.d0(dataString, (String) it.next(), false)) {
                            p("onDeepLink", dataString);
                            return;
                        }
                    }
                }
                Uri data = intent.getData();
                if (data == null) {
                    return;
                }
                p("onConfigFile", data.toString());
            }
        }
    }

    public final ArrayList r() {
        List<ApplicationInfo> installedApplications;
        String string;
        String str;
        PackageManager packageManager = getPackageManager();
        HashSet hashSet = new HashSet();
        try {
            Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
            pr.i("addCategory(...)", intentAddCategory);
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intentAddCategory, 0).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (str = activityInfo.packageName) != null) {
                    hashSet.add(str);
                }
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            installedApplications = packageManager.getInstalledApplications(0);
            pr.f(installedApplications);
        } catch (Exception unused2) {
            installedApplications = qi.a;
        }
        Iterator<ApplicationInfo> it2 = installedApplications.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ApplicationInfo next = it2.next();
            String str2 = next.packageName;
            if (str2 != null && !str2.equals(getPackageName())) {
                boolean z = (next.flags & 1) != 0;
                if (!z || hashSet.contains(str2)) {
                    if (packageManager.checkPermission("android.permission.INTERNET", str2) == 0) {
                        try {
                            string = packageManager.getApplicationLabel(next).toString();
                        } catch (Exception unused3) {
                            string = str2;
                        }
                        arrayList.add(xv.e0(new qz("package", str2), new qz("name", string), new qz("system", Boolean.valueOf(z))));
                    }
                }
            }
        }
        final fp[] fpVarArr = {new a3(3), new a3(4)};
        Comparator comparator = new Comparator() { // from class: sensei0.ba
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                for (fp fpVar : fpVarArr) {
                    Comparable comparable = (Comparable) fpVar.g(obj);
                    Comparable comparable2 = (Comparable) fpVar.g(obj2);
                    int iCompareTo = comparable == null ? comparable2 == null ? 0 : -1 : comparable2 == null ? 1 : comparable.compareTo(comparable2);
                    if (iCompareTo != 0) {
                        return iCompareTo;
                    }
                }
                return 0;
            }
        };
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, comparator);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v83, types: [sensei0.qi] */
    /* JADX WARN: Type inference failed for: r2v84, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v85, types: [java.util.ArrayList] */
    public final void t(Map map) {
        ArrayList arrayList;
        Intent intent = new Intent(this, (Class<?>) SenseiTunnelVpnService.class);
        intent.setAction("com.sensei.tunnel.START");
        intent.putExtra("config", u(map, "config"));
        intent.putExtra("serverName", u(map, "serverName"));
        Object obj = map.get("isSsh");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        intent.putExtra("isSsh", bool != null ? bool.booleanValue() : false);
        Object obj2 = map.get("isOpenvpn");
        Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        intent.putExtra("isOpenvpn", bool2 != null ? bool2.booleanValue() : false);
        intent.putExtra("ovpnConfig", u(map, "ovpnConfig"));
        Object obj3 = map.get("ovpnUseOvpn3");
        Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        intent.putExtra("ovpnUseOvpn3", bool3 != null ? bool3.booleanValue() : false);
        intent.putExtra("mode", u(map, "mode"));
        intent.putExtra("sshUser", u(map, "sshUser"));
        intent.putExtra("sshPass", u(map, "sshPass"));
        intent.putExtra("sni", u(map, "sni"));
        intent.putExtra("injectMode", u(map, "injectMode"));
        intent.putExtra("payload", u(map, "payload"));
        intent.putExtra("injectHost", u(map, "injectHost"));
        intent.putExtra("injectPort", u(map, "injectPort"));
        intent.putExtra("dnsttServer", u(map, "dnsttServer"));
        intent.putExtra("dnsttKey", u(map, "dnsttKey"));
        intent.putExtra("dnsttResolver", u(map, "dnsttResolver"));
        String strU = u(map, "sshHost");
        if (fc0.l0(strU)) {
            strU = u(map, "address");
        }
        intent.putExtra("address", strU);
        Object obj4 = map.get("sshPort");
        if (obj4 == null) {
            obj4 = map.get("port");
        }
        intent.putExtra("port", o(443, obj4));
        Object obj5 = map.get("payloadEnhanced");
        Boolean bool4 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        intent.putExtra("payloadEnhanced", bool4 != null ? bool4.booleanValue() : false);
        Object obj6 = map.get("sshCompression");
        Boolean bool5 = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        intent.putExtra("sshCompression", bool5 != null ? bool5.booleanValue() : false);
        Object obj7 = map.get("v2rayInject");
        Boolean bool6 = obj7 instanceof Boolean ? (Boolean) obj7 : null;
        intent.putExtra("v2rayInject", bool6 != null ? bool6.booleanValue() : false);
        intent.putExtra("mtu", o(1500, map.get("mtu")));
        String strU2 = u(map, "dnsPrimary");
        if (fc0.l0(strU2)) {
            strU2 = "1.1.1.1";
        }
        intent.putExtra("dnsPrimary", strU2);
        String strU3 = u(map, "dnsSecondary");
        if (fc0.l0(strU3)) {
            strU3 = "1.0.0.1";
        }
        intent.putExtra("dnsSecondary", strU3);
        Object obj8 = map.get("bypassLan");
        Boolean bool7 = obj8 instanceof Boolean ? (Boolean) obj8 : null;
        intent.putExtra("bypassLan", bool7 != null ? bool7.booleanValue() : true);
        Object obj9 = map.get("wakeLock");
        Boolean bool8 = obj9 instanceof Boolean ? (Boolean) obj9 : null;
        intent.putExtra("wakeLock", bool8 != null ? bool8.booleanValue() : false);
        Object obj10 = map.get("autoReconnect");
        Boolean bool9 = obj10 instanceof Boolean ? (Boolean) obj10 : null;
        intent.putExtra("autoReconnect", bool9 != null ? bool9.booleanValue() : false);
        Object obj11 = map.get("killSwitch");
        Boolean bool10 = obj11 instanceof Boolean ? (Boolean) obj11 : null;
        intent.putExtra("killSwitch", bool10 != null ? bool10.booleanValue() : false);
        Object obj12 = map.get("hotspotShare");
        Boolean bool11 = obj12 instanceof Boolean ? (Boolean) obj12 : null;
        intent.putExtra("hotspotShare", bool11 != null ? bool11.booleanValue() : true);
        intent.putExtra("keepAliveMode", mm0.m(o(1, map.get("keepAliveMode")), 0, 2));
        String strU4 = u(map, "splitMode");
        if (fc0.l0(strU4)) {
            strU4 = "off";
        }
        intent.putExtra("splitMode", strU4);
        Object obj13 = map.get("splitApps");
        List list = obj13 instanceof List ? (List) obj13 : null;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj14 : list) {
                String str = obj14 instanceof String ? (String) obj14 : null;
                if (str != null) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList = qi.a;
        }
        intent.putStringArrayListExtra("splitApps", new ArrayList<>((Collection) arrayList));
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    public final SecretKeySpec v(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-256");
        String str2 = this.t + ":pin:" + str;
        Charset charset = e8.a;
        byte[] bytes = str2.getBytes(charset);
        pr.i("getBytes(...)", bytes);
        messageDigest.update(messageDigest2.digest(bytes));
        messageDigest.update(m().getEncoded());
        AppSecurity appSecurity = AppSecurity.a;
        Context applicationContext = getApplicationContext();
        pr.i("getApplicationContext(...)", applicationContext);
        byte[] bytes2 = appSecurity.b(applicationContext).getBytes(charset);
        pr.i("getBytes(...)", bytes2);
        messageDigest.update(bytes2);
        return new SecretKeySpec(messageDigest.digest(), "AES");
    }

    public final void x(final boolean z) {
        new Thread(new Runnable() { // from class: sensei0.lv
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity mainActivity;
                ov ovVar;
                boolean z2 = MainActivity.B;
                ArrayList arrayList = new ArrayList();
                boolean z3 = z;
                arrayList.addAll(z3 ? MainActivity.w() : MainActivity.n());
                int i = 4;
                if (!z3) {
                    arrayList.addAll(o9.o0(4, MainActivity.w()));
                }
                arrayList.add(new ov("dialer code *#*#4636#*#*", new w2(1)));
                arrayList.add(new ov("MTK engineering mode", new w2(2)));
                arrayList.addAll(p9.f0(new ov("Samsung hidden network settings", new w2(3)), new ov("Samsung service mode", new w2(i)), new ov("MIUI network settings", new w2(5))));
                arrayList.addAll(p9.f0(new ov("network dashboard", new w2(6)), new ov("wireless settings", new w2(7)), new ov("settings home", new w2(8))));
                int size = arrayList.size();
                int i2 = 0;
                do {
                    mainActivity = this;
                    if (i2 >= size) {
                        mainActivity.runOnUiThread(new gv(mainActivity, 3));
                        return;
                    } else {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ovVar = (ov) obj;
                    }
                } while (!mainActivity.E((Intent) ovVar.b.a(), ovVar.a));
            }
        }).start();
    }

    public final void y() {
        try {
            try {
                try {
                    try {
                        startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + getPackageName())).addFlags(268435456));
                    } catch (Exception unused) {
                        startActivity(new Intent("android.settings.SETTINGS").addFlags(268435456));
                    }
                } catch (Exception unused2) {
                    C("Could not open settings — please open your phone's settings manually", true);
                }
            } catch (Exception unused3) {
                startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS").addFlags(268435456));
            }
        } catch (Exception unused4) {
            startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + getPackageName())).addFlags(268435456));
        }
    }

    public final String z(String str, String str2) {
        try {
            if (!nc0.d0(str, "sensei:v2p:", false)) {
                if (!nc0.d0(str, "sensei:v2:", false)) {
                    return str;
                }
                byte[] bArrDecode = Base64.decode(fc0.q0(str, "sensei:v2:"), 0);
                if (bArrDecode.length <= 28) {
                    return null;
                }
                byte[] bArrZ = c5.Z(0, 12, bArrDecode);
                byte[] bArrZ2 = c5.Z(12, bArrDecode.length, bArrDecode);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, m(), new GCMParameterSpec(128, bArrZ));
                byte[] bArrDoFinal = cipher.doFinal(bArrZ2);
                pr.i("doFinal(...)", bArrDoFinal);
                return new String(bArrDoFinal, e8.a);
            }
            if (str2 != null && str2.length() != 0) {
                byte[] bArrDecode2 = Base64.decode(fc0.q0(str, "sensei:v2p:"), 0);
                if (bArrDecode2.length <= 28) {
                    return null;
                }
                byte[] bArrZ3 = c5.Z(0, 12, bArrDecode2);
                byte[] bArrZ4 = c5.Z(12, bArrDecode2.length, bArrDecode2);
                Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
                cipher2.init(2, v(str2), new GCMParameterSpec(128, bArrZ3));
                byte[] bArrDoFinal2 = cipher2.doFinal(bArrZ4);
                pr.i("doFinal(...)", bArrDoFinal2);
                return new String(bArrDoFinal2, e8.a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
