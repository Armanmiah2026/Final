package sensei0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import android.view.accessibility.AccessibilityNodeInfo;
import com.sensei.tunnel.AppSecurity;
import com.trilead.ssh2.sftp.AttribFlags;
import com.trilead.ssh2.sftp.ErrorCodes;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class mh implements kc, lk0, ux, zw, tx, t6, y5 {
    public static final mh b = new mh(1);
    public static final /* synthetic */ mh c = new mh(2);
    public static final /* synthetic */ mh d = new mh(3);
    public static final mh f = new mh(4);
    public static final String[] h = new String[0];
    public static final mh o = new mh(6);
    public static final /* synthetic */ mh p = new mh(7);
    public static final mh q = new mh(8);
    public static final mh r = new mh(9);
    public static final mh s = new mh(11);
    public static final mh t = new mh(12);
    public static final mh u = new mh(13);
    public static final mh v = new mh(14);
    public static final /* synthetic */ mh w = new mh(15);
    public final /* synthetic */ int a;

    public /* synthetic */ mh(int i) {
        this.a = i;
    }

    public static String[] A(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    public static byte[] j(String str) {
        byte[] bArrDecode = Base64.decode(str, 11);
        pr.i("decode(...)", bArrDecode);
        return bArrDecode;
    }

    public static String m(Context context, String str, Map map) {
        String string;
        Context context2;
        String strW;
        String string2;
        try {
            Object obj = map.get("lock");
            Boolean bool = Boolean.TRUE;
            boolean zB = pr.b(obj, bool);
            boolean zB2 = pr.b(map.get("hwid"), bool);
            Object obj2 = map.get("password");
            String str2 = (obj2 == null || (string2 = obj2.toString()) == null) ? "" : string2;
            Object obj3 = map.get("expiresAt");
            Number number = obj3 instanceof Number ? (Number) obj3 : null;
            long jLongValue = number != null ? number.longValue() : 0L;
            boolean zB3 = pr.b(map.get("blockRoot"), bool);
            Object obj4 = map.get("blockApps");
            try {
                List list = obj4 instanceof List ? (List) obj4 : null;
                if (list == null) {
                    list = qi.a;
                }
                Object obj5 = map.get("note");
                if (obj5 == null || (string = obj5.toString()) == null) {
                    string = "";
                }
                if (!zB && !zB2 && str2.length() <= 0 && jLongValue <= 0 && !zB3 && list.isEmpty()) {
                    byte[] bytes = str.getBytes(e8.a);
                    pr.i("getBytes(...)", bytes);
                    String strEncodeToString = Base64.encodeToString(bytes, 11);
                    pr.i("encodeToString(...)", strEncodeToString);
                    return "senseitunnel://base64/48/open/".concat(strEncodeToString);
                }
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                String strP = p(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("v", 48);
                jSONObject.put("lock", zB);
                jSONObject.put("hwid", zB2);
                jSONObject.put("hwidHash", zB2 ? z(strP) : "");
                jSONObject.put("pin", str2.length() > 0);
                if (str2.length() > 0) {
                    context2 = context;
                    strW = w(context2, str2, bArr, 120000);
                } else {
                    context2 = context;
                    strW = "";
                }
                jSONObject.put("pinChk", strW);
                jSONObject.put("exp", jLongValue);
                jSONObject.put("root", zB3);
                jSONObject.put("apps", new JSONArray((Collection) list));
                jSONObject.put("note", string);
                String strEncodeToString2 = Base64.encodeToString(bArr, 11);
                pr.i("encodeToString(...)", strEncodeToString2);
                jSONObject.put("salt", strEncodeToString2);
                jSONObject.put("iter", 120000);
                String string3 = jSONObject.toString();
                pr.i("toString(...)", string3);
                Charset charset = e8.a;
                byte[] bytes2 = string3.getBytes(charset);
                pr.i("getBytes(...)", bytes2);
                byte[] bArrQ = q(context2, str2, bArr, 120000, zB2, strP);
                byte[] bArr2 = new byte[12];
                new SecureRandom().nextBytes(bArr2);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, new SecretKeySpec(bArrQ, "AES"), new GCMParameterSpec(128, bArr2));
                cipher.updateAAD(bytes2);
                byte[] bytes3 = str.getBytes(charset);
                pr.i("getBytes(...)", bytes3);
                byte[] bArrDoFinal = cipher.doFinal(bytes3);
                pr.f(bArrDoFinal);
                byte[] bArrB0 = c5.b0(bArr2, bArrDoFinal);
                String strEncodeToString3 = Base64.encodeToString(bytes2, 11);
                pr.i("encodeToString(...)", strEncodeToString3);
                String strEncodeToString4 = Base64.encodeToString(bArrB0, 11);
                pr.i("encodeToString(...)", strEncodeToString4);
                return "senseitunnel://base64/48/lock/" + strEncodeToString3 + "." + strEncodeToString4;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String p(Context context) throws NoSuchAlgorithmException {
        String string;
        byte[] bytes;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (string == null) {
            string = "";
        }
        Charset charset = e8.a;
        byte[] bytes2 = string.getBytes(charset);
        pr.i("getBytes(...)", bytes2);
        messageDigest.update(bytes2);
        String str = Build.FINGERPRINT;
        if (str != null) {
            bytes = str.getBytes(charset);
            pr.i("getBytes(...)", bytes);
        } else {
            bytes = new byte[0];
        }
        messageDigest.update(bytes);
        byte[] bytes3 = AppSecurity.a.b(context).getBytes(charset);
        pr.i("getBytes(...)", bytes3);
        messageDigest.update(bytes3);
        byte[] bArrDigest = messageDigest.digest();
        pr.i("digest(...)", bArrDigest);
        return c5.a0(bArrDigest, "", new a3(20), 30);
    }

    public static byte[] q(Context context, String str, byte[] bArr, int i, boolean z, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        String strS = za0.s("SenseiTunnel:JubairSensei:2026:v2|", AppSecurity.a.b(context));
        if (str.length() != 0) {
            strS = strS + "|pin|" + str;
        }
        char[] charArray = strS.toCharArray();
        pr.i("toCharArray(...)", charArray);
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(charArray, bArr, i, 256)).getEncoded();
        pr.i("getEncoded(...)", encoded);
        if (!z) {
            return encoded;
        }
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(encoded, "HmacSHA256"));
        byte[] bytes = str2.getBytes(e8.a);
        pr.i("getBytes(...)", bytes);
        byte[] bArrDoFinal = mac.doFinal(bytes);
        pr.i("doFinal(...)", bArrDoFinal);
        return bArrDoFinal;
    }

    public static i3 r(Context context, String[] strArr, String str, j1 j1Var) {
        String[] strArrA = A(context);
        int length = strArrA.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = strArrA[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c2 = File.separatorChar;
                            sb.append(c2);
                            sb.append(str3);
                            sb.append(c2);
                            sb.append(str);
                            String string = sb.toString();
                            j1Var.f("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                i3 i3Var = new i3(0, false);
                                i3Var.b = zipFile;
                                i3Var.c = entry;
                                return i3Var;
                            }
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    public static String[] t(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c2 = File.separatorChar;
        sb.append(c2);
        sb.append("([^\\");
        sb.append(c2);
        sb.append("]*)");
        sb.append(c2);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : A(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static boolean v(Context context) {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/sbin/su", "/system/app/Superuser.apk", "/system/bin/magisk", "/system/xbin/magisk", "/data/adb/magisk"};
        int i = 0;
        while (true) {
            if (i >= 7) {
                String str = Build.TAGS;
                if (str == null || !fc0.e0(str, "test-keys", false)) {
                    try {
                        InputStream inputStream = Runtime.getRuntime().exec(new String[]{"which", "su"}).getInputStream();
                        pr.i("getInputStream(...)", inputStream);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, inputStream.available()));
                        k6.j(inputStream, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        pr.i("toByteArray(...)", byteArray);
                        return !(byteArray.length == 0);
                    } catch (Exception unused) {
                        return false;
                    }
                }
            } else {
                if (new File(strArr[i]).exists()) {
                    break;
                }
                i++;
            }
        }
        return true;
    }

    public static String w(Context context, String str, byte[] bArr, int i) {
        return fc0.y0(16, c5.a0(q(context, str, bArr, i, false, ""), "", new a3(21), 30));
    }

    public static Map y(boolean z, String str, String str2, Map map, String str3, int i) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        boolean z2 = (i & 8) == 0;
        if ((i & 16) != 0) {
            map = null;
        }
        if ((i & 32) != 0) {
            str3 = null;
        }
        return xv.e0(new qz("ok", Boolean.valueOf(z)), new qz("config", str), new qz("error", str2), new qz("needsPassword", Boolean.valueOf(z2)), new qz("flags", map), new qz("note", str3));
    }

    public static String z(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(e8.a);
        pr.i("getBytes(...)", bytes);
        byte[] bArrDigest = messageDigest.digest(bytes);
        pr.i("digest(...)", bArrDigest);
        return c5.a0(bArrDigest, "", new a3(22), 30);
    }

    public void B(Object obj, hg0 hg0Var) {
        cq cqVarA;
        Map mapA = ((gy) obj).a();
        d20 d20VarN = f20.n();
        for (Map.Entry entry : mapA.entrySet()) {
            a20 a20Var = (a20) entry.getKey();
            Object value = entry.getValue();
            String str = a20Var.a;
            if (value instanceof Boolean) {
                i20 i20VarD = j20.D();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                i20VarD.c();
                j20.q((j20) i20VarD.b, zBooleanValue);
                cqVarA = i20VarD.a();
            } else if (value instanceof Float) {
                i20 i20VarD2 = j20.D();
                float fFloatValue = ((Number) value).floatValue();
                i20VarD2.c();
                j20.r((j20) i20VarD2.b, fFloatValue);
                cqVarA = i20VarD2.a();
            } else if (value instanceof Double) {
                i20 i20VarD3 = j20.D();
                double dDoubleValue = ((Number) value).doubleValue();
                i20VarD3.c();
                j20.o((j20) i20VarD3.b, dDoubleValue);
                cqVarA = i20VarD3.a();
            } else if (value instanceof Integer) {
                i20 i20VarD4 = j20.D();
                int iIntValue = ((Number) value).intValue();
                i20VarD4.c();
                j20.s((j20) i20VarD4.b, iIntValue);
                cqVarA = i20VarD4.a();
            } else if (value instanceof Long) {
                i20 i20VarD5 = j20.D();
                long jLongValue = ((Number) value).longValue();
                i20VarD5.c();
                j20.l((j20) i20VarD5.b, jLongValue);
                cqVarA = i20VarD5.a();
            } else if (value instanceof String) {
                i20 i20VarD6 = j20.D();
                i20VarD6.c();
                j20.m((j20) i20VarD6.b, (String) value);
                cqVarA = i20VarD6.a();
            } else if (value instanceof Set) {
                i20 i20VarD7 = j20.D();
                g20 g20VarO = h20.o();
                g20VarO.c();
                h20.l((h20) g20VarO.b, (Set) value);
                i20VarD7.c();
                j20.n((j20) i20VarD7.b, (h20) g20VarO.a());
                cqVarA = i20VarD7.a();
            } else {
                if (!(value instanceof byte[])) {
                    throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                }
                i20 i20VarD8 = j20.D();
                byte[] bArr = (byte[]) value;
                u6 u6VarC = u6.c(0, bArr.length, bArr);
                i20VarD8.c();
                j20.p((j20) i20VarD8.b, u6VarC);
                cqVarA = i20VarD8.a();
            }
            d20VarN.getClass();
            str.getClass();
            d20VarN.c();
            f20.l((f20) d20VarN.b).put(str, (j20) cqVarA);
        }
        f20 f20Var = (f20) d20VarN.a();
        int iA = f20Var.a(null);
        Logger logger = m9.q;
        if (iA > 4096) {
            iA = 4096;
        }
        m9 m9Var = new m9(hg0Var, iA);
        f20Var.b(m9Var);
        if (m9Var.o > 0) {
            m9Var.C0();
        }
    }

    @Override // sensei0.lk0
    public String[] b() {
        return h;
    }

    @Override // sensei0.ux
    public ByteBuffer c(Object obj) {
        JSONArray jSONArrayPut = new JSONArray().put(wf0.J(obj));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objJ = wf0.J(jSONArrayPut);
        if (objJ instanceof String) {
            bc0 bc0Var = bc0.b;
            String strQuote = JSONObject.quote((String) objJ);
            bc0Var.getClass();
            return bc0.d(strQuote);
        }
        bc0 bc0Var2 = bc0.b;
        String string = objJ.toString();
        bc0Var2.getClass();
        return bc0.d(string);
    }

    @Override // sensei0.t6
    public byte[] d(int i, int i2, byte[] bArr) {
        switch (this.a) {
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                return Arrays.copyOfRange(bArr, i, i2 + i);
            default:
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                return bArr2;
        }
    }

    @Override // sensei0.ux
    public ByteBuffer e(String str, String str2) {
        JSONArray jSONArrayPut = new JSONArray().put("error").put(wf0.J(str)).put(JSONObject.NULL).put(wf0.J(str2));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objJ = wf0.J(jSONArrayPut);
        if (objJ instanceof String) {
            bc0 bc0Var = bc0.b;
            String strQuote = JSONObject.quote((String) objJ);
            bc0Var.getClass();
            return bc0.d(strQuote);
        }
        bc0 bc0Var2 = bc0.b;
        String string = objJ.toString();
        bc0Var2.getClass();
        return bc0.d(string);
    }

    @Override // sensei0.ux
    public ByteBuffer f(String str, String str2, Object obj) {
        JSONArray jSONArrayPut = new JSONArray().put(str).put(wf0.J(str2)).put(wf0.J(obj));
        if (jSONArrayPut == null) {
            return null;
        }
        Object objJ = wf0.J(jSONArrayPut);
        if (objJ instanceof String) {
            bc0 bc0Var = bc0.b;
            String strQuote = JSONObject.quote((String) objJ);
            bc0Var.getClass();
            return bc0.d(strQuote);
        }
        bc0 bc0Var2 = bc0.b;
        String string = objJ.toString();
        bc0Var2.getClass();
        return bc0.d(string);
    }

    @Override // sensei0.ux
    public i3 g(ByteBuffer byteBuffer) {
        Object objNextValue;
        Object obj = null;
        if (byteBuffer == null) {
            objNextValue = null;
        } else {
            try {
                try {
                    bc0.b.getClass();
                    JSONTokener jSONTokener = new JSONTokener(bc0.c(byteBuffer));
                    objNextValue = jSONTokener.nextValue();
                    if (jSONTokener.more()) {
                        throw new IllegalArgumentException("Invalid JSON");
                    }
                } catch (JSONException e) {
                    throw new IllegalArgumentException("Invalid JSON", e);
                }
            } catch (JSONException e2) {
                throw new IllegalArgumentException("Invalid JSON", e2);
            }
        }
        if (objNextValue instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) objNextValue;
            Object obj2 = jSONObject.get("method");
            Object objOpt = jSONObject.opt("args");
            if (objOpt != JSONObject.NULL) {
                obj = objOpt;
            }
            if (obj2 instanceof String) {
                return new i3((String) obj2, obj, 17, false);
            }
        }
        throw new IllegalArgumentException("Invalid method call: " + objNextValue);
    }

    @Override // sensei0.lk0
    public StaticsBoundaryInterface getStatics() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // sensei0.lk0
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // sensei0.ux
    public Object h(ByteBuffer byteBuffer) {
        try {
            try {
                bc0.b.getClass();
                JSONTokener jSONTokener = new JSONTokener(bc0.c(byteBuffer));
                Object objNextValue = jSONTokener.nextValue();
                if (jSONTokener.more()) {
                    throw new IllegalArgumentException("Invalid JSON");
                }
                if (objNextValue instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objNextValue;
                    Object obj = null;
                    if (jSONArray.length() == 1) {
                        Object objOpt = jSONArray.opt(0);
                        if (objOpt == JSONObject.NULL) {
                            return null;
                        }
                        return objOpt;
                    }
                    if (jSONArray.length() == 3) {
                        Object obj2 = jSONArray.get(0);
                        Object objOpt2 = jSONArray.opt(1);
                        Object obj3 = JSONObject.NULL;
                        if (objOpt2 == obj3) {
                            objOpt2 = null;
                        }
                        Object objOpt3 = jSONArray.opt(2);
                        if (objOpt3 != obj3) {
                            obj = objOpt3;
                        }
                        if ((obj2 instanceof String) && (objOpt2 == null || (objOpt2 instanceof String))) {
                            throw new mm((String) obj2, (String) objOpt2, obj);
                        }
                    }
                }
                throw new IllegalArgumentException("Invalid envelope: " + objNextValue);
            } catch (JSONException e) {
                throw new IllegalArgumentException("Invalid JSON", e);
            }
        } catch (JSONException e2) {
            throw new IllegalArgumentException("Invalid JSON", e2);
        }
    }

    @Override // sensei0.ux
    public ByteBuffer i(i3 i3Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", (String) i3Var.b);
            jSONObject.put("args", wf0.J(i3Var.c));
            Object objJ = wf0.J(jSONObject);
            if (objJ instanceof String) {
                bc0 bc0Var = bc0.b;
                String strQuote = JSONObject.quote((String) objJ);
                bc0Var.getClass();
                return bc0.d(strQuote);
            }
            bc0 bc0Var2 = bc0.b;
            String string = objJ.toString();
            bc0Var2.getClass();
            return bc0.d(string);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // sensei0.zw
    public boolean k(pw pwVar) {
        return false;
    }

    @Override // sensei0.tx
    public void l(i3 i3Var, rk rkVar) {
        rkVar.d(null);
    }

    public Signature[] s(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // sensei0.y5
    public void u(ByteBuffer byteBuffer, pd pdVar) {
        bc0.b.getClass();
        bc0.c(byteBuffer);
    }

    public gy x(FileInputStream fileInputStream) throws zc {
        byte[] bArr;
        try {
            f20 f20VarO = f20.o(fileInputStream);
            gy gyVar = new gy(false);
            b20[] b20VarArr = (b20[]) Arrays.copyOf(new b20[0], 0);
            pr.j("pairs", b20VarArr);
            gyVar.b();
            if (b20VarArr.length > 0) {
                b20 b20Var = b20VarArr[0];
                throw null;
            }
            Map mapM = f20VarO.m();
            pr.i("preferencesProto.preferencesMap", mapM);
            for (Map.Entry entry : mapM.entrySet()) {
                String str = (String) entry.getKey();
                j20 j20Var = (j20) entry.getValue();
                pr.i("name", str);
                pr.i("value", j20Var);
                int iC = j20Var.C();
                switch (iC == 0 ? -1 : c20.a[za0.u(iC)]) {
                    case -1:
                        throw new zc("Value case is null.", null);
                    case 0:
                    default:
                        throw new ia();
                    case 1:
                        gyVar.d(new a20(str), Boolean.valueOf(j20Var.t()));
                        break;
                    case 2:
                        gyVar.d(new a20(str), Float.valueOf(j20Var.x()));
                        break;
                    case 3:
                        gyVar.d(new a20(str), Double.valueOf(j20Var.w()));
                        break;
                    case 4:
                        gyVar.d(new a20(str), Integer.valueOf(j20Var.y()));
                        break;
                    case 5:
                        gyVar.d(new a20(str), Long.valueOf(j20Var.z()));
                        break;
                    case 6:
                        a20 a20Var = new a20(str);
                        String strA = j20Var.A();
                        pr.i("value.string", strA);
                        gyVar.d(a20Var, strA);
                        break;
                    case 7:
                        a20 a20Var2 = new a20(str);
                        lr lrVarN = j20Var.B().n();
                        pr.i("value.stringSet.stringsList", lrVarN);
                        gyVar.d(a20Var2, o9.t0(lrVarN));
                        break;
                    case 8:
                        a20 a20Var3 = new a20(str);
                        u6 u6VarU = j20Var.u();
                        int size = u6VarU.size();
                        if (size == 0) {
                            bArr = mr.b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            u6VarU.d(bArr2, size);
                            bArr = bArr2;
                        }
                        pr.i("value.bytes.toByteArray()", bArr);
                        gyVar.d(a20Var3, bArr);
                        break;
                    case 9:
                        throw new zc("Value not set.", null);
                }
            }
            return new gy(new LinkedHashMap(gyVar.a()), true);
        } catch (tr e) {
            throw new zc("Unable to parse preferences proto.", e);
        }
    }

    public mh(kd kdVar) {
        this.a = 27;
    }

    @Override // sensei0.zw
    public void a(pw pwVar, boolean z) {
    }

    public void o(AccessibilityNodeInfo accessibilityNodeInfo, m0 m0Var) {
    }
}
