package sensei0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.webkit.HttpAuthHandler;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import com.sensei.tunnel.R;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k6 {
    public static final o4 d;
    public static o4 e;
    public static final tn a = new tn("NO_DECISION", 4);
    public static final tn b = new tn("CLOSED", 4);
    public static final tn c = new tn("CLOSED_EMPTY", 4);
    public static final byte[] f = {112, 114, 111, 0};
    public static final byte[] g = {112, 114, 109, 0};
    public static final int[] h = {R.attr.colorPrimary};
    public static final int[] i = {R.attr.colorPrimaryVariant};

    static {
        Object obj = null;
        d = new o4(obj, obj, obj, 13);
    }

    public static String[] A(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String) arrayList.get(i2));
            if (mimeTypeFromExtension == null) {
                Log.w("FilePickerUtils", "Custom file type " + ((String) arrayList.get(i2)) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        Log.d("FilePickerUtils", "Allowed file extensions mimes: " + arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static final d70 B(Object obj) {
        if (obj != b) {
            return (d70) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final int C(b5 b5Var, Object obj, int i2) {
        int i3 = b5Var.c;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iD = xe.d(i3, i2, b5Var.a);
            if (iD < 0 || pr.b(obj, b5Var.b[iD])) {
                return iD;
            }
            int i4 = iD + 1;
            while (i4 < i3 && b5Var.a[i4] == i2) {
                if (pr.b(obj, b5Var.b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iD - 1; i5 >= 0 && b5Var.a[i5] == i2; i5--) {
                if (pr.b(obj, b5Var.b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static boolean D(int i2, Rect rect, Rect rect2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        }
        if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
    }

    public static final boolean E(Object obj) {
        return obj == b;
    }

    public static boolean F(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static List G(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        pr.i("singletonList(...)", listSingletonList);
        return listSingletonList;
    }

    public static int H(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static int I(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static lc J(jc jcVar, kc kcVar) {
        pr.j("key", kcVar);
        return pr.b(jcVar.getKey(), kcVar) ? oi.a : jcVar;
    }

    public static nk K(Context context, Uri uri, boolean z) {
        Exception exc;
        FileOutputStream fileOutputStream;
        Log.i("FilePickerUtils", "Caching from URI: " + uri.toString());
        String strY = y(context, uri);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getAbsolutePath());
        sb.append("/file_picker/");
        sb.append(System.currentTimeMillis());
        sb.append("/");
        sb.append(strY != null ? strY : "unamed");
        String string = sb.toString();
        File file = new File(string);
        byte[] bArr = null;
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(string);
                try {
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        byte[] bArr2 = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
                        while (true) {
                            int i2 = inputStreamOpenInputStream.read(bArr2);
                            if (i2 < 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr2, 0, i2);
                        }
                        bufferedOutputStream.flush();
                        fileOutputStream.getFD().sync();
                    } catch (Exception e2) {
                        exc = e2;
                        try {
                            fileOutputStream.close();
                            Log.e("FilePickerUtils", "Failed to retrieve path: " + exc.getMessage(), null);
                            return null;
                        } catch (IOException | NullPointerException unused) {
                            Log.e("FilePickerUtils", "Failed to close file streams: " + exc.getMessage(), null);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream.getFD().sync();
                    throw th;
                }
            } catch (Exception e3) {
                exc = e3;
                fileOutputStream = null;
            }
        }
        Log.d("FilePickerUtils", "File loaded and cached at:" + string);
        if (z) {
            try {
                int length = (int) file.length();
                byte[] bArr3 = new byte[length];
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    bufferedInputStream.read(bArr3, 0, length);
                    bufferedInputStream.close();
                } catch (FileNotFoundException e4) {
                    Log.e("FilePickerUtils", "File not found: " + e4.getMessage(), null);
                } catch (IOException e5) {
                    Log.e("FilePickerUtils", "Failed to close file streams: " + e5.getMessage(), null);
                }
                bArr = bArr3;
            } catch (Exception e6) {
                Log.e("FilePickerUtils", "Failed to load bytes into memory with error " + e6.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
            }
        }
        return new nk(string, strY, uri, Long.parseLong(String.valueOf(file.length())), bArr);
    }

    public static int[] L(ByteArrayInputStream byteArrayInputStream, int i2) {
        int[] iArr = new int[i2];
        int iL = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iL += (int) pr.L(byteArrayInputStream, 2);
            iArr[i3] = iL;
        }
        return iArr;
    }

    public static ag[] M(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, ag[] agVarArr) throws IOException {
        byte[] bArr3 = xe.t;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, xe.u)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iL = (int) pr.L(fileInputStream, 2);
            byte[] bArrK = pr.K(fileInputStream, (int) pr.L(fileInputStream, 4), (int) pr.L(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrK);
            try {
                ag[] agVarArrO = O(byteArrayInputStream, bArr2, iL, agVarArr);
                byteArrayInputStream.close();
                return agVarArrO;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(xe.o, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iL2 = (int) pr.L(fileInputStream, 1);
        byte[] bArrK2 = pr.K(fileInputStream, (int) pr.L(fileInputStream, 4), (int) pr.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrK2);
        try {
            ag[] agVarArrN = N(byteArrayInputStream2, iL2, agVarArr);
            byteArrayInputStream2.close();
            return agVarArrN;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static ag[] N(ByteArrayInputStream byteArrayInputStream, int i2, ag[] agVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new ag[0];
        }
        if (i2 != agVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iL = (int) pr.L(byteArrayInputStream, 2);
            iArr[i3] = (int) pr.L(byteArrayInputStream, 2);
            strArr[i3] = new String(pr.J(byteArrayInputStream, iL), StandardCharsets.UTF_8);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ag agVar = agVarArr[i4];
            if (!agVar.b.equals(strArr[i4])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i5 = iArr[i4];
            agVar.e = i5;
            agVar.h = L(byteArrayInputStream, i5);
        }
        return agVarArr;
    }

    public static ag[] O(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, ag[] agVarArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new ag[0];
        }
        if (i2 != agVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            pr.L(byteArrayInputStream, 2);
            String str = new String(pr.J(byteArrayInputStream, (int) pr.L(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jL = pr.L(byteArrayInputStream, 4);
            int iL = (int) pr.L(byteArrayInputStream, 2);
            ag agVar = null;
            if (agVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                int i4 = 0;
                while (true) {
                    if (i4 >= agVarArr.length) {
                        break;
                    }
                    if (agVarArr[i4].b.equals(strSubstring)) {
                        agVar = agVarArr[i4];
                        break;
                    }
                    i4++;
                }
            }
            if (agVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            agVar.d = jL;
            int[] iArrL = L(byteArrayInputStream, iL);
            if (Arrays.equals(bArr, xe.s)) {
                agVar.e = iL;
                agVar.h = iArrL;
            }
        }
        return agVarArr;
    }

    public static ag[] P(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, xe.p)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iL = (int) pr.L(fileInputStream, 1);
        byte[] bArrK = pr.K(fileInputStream, (int) pr.L(fileInputStream, 4), (int) pr.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrK);
        try {
            ag[] agVarArrQ = Q(byteArrayInputStream, str, iL);
            byteArrayInputStream.close();
            return agVarArrQ;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static ag[] Q(ByteArrayInputStream byteArrayInputStream, String str, int i2) throws IOException {
        int i3 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new ag[0];
        }
        ag[] agVarArr = new ag[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            int iL = (int) pr.L(byteArrayInputStream, 2);
            int iL2 = (int) pr.L(byteArrayInputStream, 2);
            agVarArr[i4] = new ag(str, new String(pr.J(byteArrayInputStream, iL), StandardCharsets.UTF_8), pr.L(byteArrayInputStream, 4), iL2, (int) pr.L(byteArrayInputStream, 4), (int) pr.L(byteArrayInputStream, 4), new int[iL2], new TreeMap());
        }
        int i5 = 0;
        while (i5 < i2) {
            ag agVar = agVarArr[i5];
            int iAvailable = byteArrayInputStream.available();
            int i6 = agVar.f;
            int i7 = agVar.g;
            TreeMap treeMap = agVar.i;
            int i8 = iAvailable - i6;
            int iL3 = i3;
            while (byteArrayInputStream.available() > i8) {
                iL3 += (int) pr.L(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iL3), 1);
                int iL4 = (int) pr.L(byteArrayInputStream, 2);
                while (iL4 > 0) {
                    pr.L(byteArrayInputStream, 2);
                    int iL5 = (int) pr.L(byteArrayInputStream, 1);
                    if (iL5 != 6 && iL5 != 7) {
                        while (iL5 > 0) {
                            pr.L(byteArrayInputStream, 1);
                            int i9 = i3;
                            int i10 = i5;
                            for (int iL6 = (int) pr.L(byteArrayInputStream, 1); iL6 > 0; iL6--) {
                                pr.L(byteArrayInputStream, 2);
                            }
                            iL5--;
                            i3 = i9;
                            i5 = i10;
                        }
                    }
                    iL4--;
                    i3 = i3;
                    i5 = i5;
                }
            }
            int i11 = i3;
            int i12 = i5;
            if (byteArrayInputStream.available() != i8) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            agVar.h = L(byteArrayInputStream, agVar.e);
            BitSet bitSetValueOf = BitSet.valueOf(pr.J(byteArrayInputStream, (((i7 * 2) + 7) & (-8)) / 8));
            for (int i13 = i11; i13 < i7; i13++) {
                int i14 = bitSetValueOf.get(i13) ? 2 : i11;
                if (bitSetValueOf.get(i13 + i7)) {
                    i14 |= 4;
                }
                if (i14 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i13));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i11);
                    }
                    treeMap.put(Integer.valueOf(i13), Integer.valueOf(i14 | numValueOf.intValue()));
                }
            }
            i5 = i12 + 1;
            i3 = i11;
        }
        return agVarArr;
    }

    public static void R(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                R(file2);
            }
        }
        file.delete();
    }

    public static void T(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.useHttpAuthUsernamePassword", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.j00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj2);
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj3);
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c9Var3.getClass();
                                httpAuthHandler2.cancel();
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj4);
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                httpAuthHandler3.proceed(str, str2);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.cancel", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.j00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj2);
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj3);
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c9Var3.getClass();
                                httpAuthHandler2.cancel();
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj4);
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                httpAuthHandler3.proceed(str, str2);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.proceed", lxVar, null);
        if (c9Var == null) {
            j1Var3.l(null);
        } else {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.j00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj2);
                            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(Boolean.valueOf(httpAuthHandler.useHttpAuthUsernamePassword()));
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj3);
                            HttpAuthHandler httpAuthHandler2 = (HttpAuthHandler) obj3;
                            try {
                                c9Var3.getClass();
                                httpAuthHandler2.cancel();
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.HttpAuthHandler", obj4);
                            HttpAuthHandler httpAuthHandler3 = (HttpAuthHandler) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str = (String) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                httpAuthHandler3.proceed(str, str2);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                    }
                }
            });
        }
    }

    public static void U(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDomStorageEnabled", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptCanOpenWindowsAutomatically", lxVar, null);
        if (c9Var != null) {
            final int i3 = 15;
            j1Var2.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportMultipleWindows", lxVar, null);
        if (c9Var != null) {
            final int i4 = 16;
            j1Var3.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptEnabled", lxVar, null);
        if (c9Var != null) {
            final int i5 = 1;
            j1Var4.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUserAgentString", lxVar, null);
        if (c9Var != null) {
            final int i6 = 2;
            j1Var5.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i6) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMediaPlaybackRequiresUserGesture", lxVar, null);
        if (c9Var != null) {
            final int i7 = 3;
            j1Var6.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i7) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var6.l(null);
        }
        j1 j1Var7 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportZoom", lxVar, null);
        if (c9Var != null) {
            final int i8 = 4;
            j1Var7.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i8) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var7.l(null);
        }
        j1 j1Var8 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setLoadWithOverviewMode", lxVar, null);
        if (c9Var != null) {
            final int i9 = 5;
            j1Var8.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i9) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var8.l(null);
        }
        j1 j1Var9 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUseWideViewPort", lxVar, null);
        if (c9Var != null) {
            final int i10 = 6;
            j1Var9.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i10) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var9.l(null);
        }
        j1 j1Var10 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDisplayZoomControls", lxVar, null);
        if (c9Var != null) {
            final int i11 = 7;
            j1Var10.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i11) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var10.l(null);
        }
        j1 j1Var11 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setBuiltInZoomControls", lxVar, null);
        if (c9Var != null) {
            final int i12 = 8;
            j1Var11.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i12) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var11.l(null);
        }
        j1 j1Var12 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowFileAccess", lxVar, null);
        if (c9Var != null) {
            final int i13 = 9;
            j1Var12.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i13) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var12.l(null);
        }
        j1 j1Var13 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowContentAccess", lxVar, null);
        if (c9Var != null) {
            final int i14 = 10;
            j1Var13.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i14) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var13.l(null);
        }
        j1 j1Var14 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setGeolocationEnabled", lxVar, null);
        if (c9Var != null) {
            final int i15 = 11;
            j1Var14.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i15) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var14.l(null);
        }
        j1 j1Var15 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setTextZoom", lxVar, null);
        if (c9Var != null) {
            final int i16 = 12;
            j1Var15.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i16) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var15.l(null);
        }
        j1 j1Var16 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.getUserAgentString", lxVar, null);
        if (c9Var != null) {
            final int i17 = 13;
            j1Var16.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i17) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        } else {
            j1Var16.l(null);
        }
        j1 j1Var17 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMixedContentMode", lxVar, null);
        if (c9Var == null) {
            j1Var17.l(null);
        } else {
            final int i18 = 14;
            j1Var17.l(new u5() { // from class: sensei0.q00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    List listF07;
                    List listF08;
                    List listF09;
                    List listF010;
                    List listF011;
                    List listF012;
                    List listF013;
                    List listF014;
                    List listF015;
                    List listF016;
                    List listF017;
                    switch (i18) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj2);
                            WebSettings webSettings = (WebSettings) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj3);
                            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                            try {
                                c9Var2.getClass();
                                webSettings.setDomStorageEnabled(zBooleanValue);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                            WebSettings webSettings2 = (WebSettings) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                            boolean zBooleanValue2 = ((Boolean) obj5).booleanValue();
                            try {
                                c9Var3.getClass();
                                webSettings2.setJavaScriptEnabled(zBooleanValue2);
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj6);
                            WebSettings webSettings3 = (WebSettings) obj6;
                            String str = (String) list3.get(1);
                            try {
                                c9Var4.getClass();
                                webSettings3.setUserAgentString(str);
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj7);
                            WebSettings webSettings4 = (WebSettings) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                webSettings4.setMediaPlaybackRequiresUserGesture(zBooleanValue3);
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj9 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj9);
                            WebSettings webSettings5 = (WebSettings) obj9;
                            Object obj10 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                webSettings5.setSupportZoom(zBooleanValue4);
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        case 5:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj11 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj11);
                            WebSettings webSettings6 = (WebSettings) obj11;
                            Object obj12 = list6.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                webSettings6.setLoadWithOverviewMode(zBooleanValue5);
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                        case 6:
                            c9 c9Var8 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj13 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj13);
                            WebSettings webSettings7 = (WebSettings) obj13;
                            Object obj14 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj14);
                            boolean zBooleanValue6 = ((Boolean) obj14).booleanValue();
                            try {
                                c9Var8.getClass();
                                webSettings7.setUseWideViewPort(zBooleanValue6);
                                listF07 = k6.G(null);
                                break;
                            } catch (Throwable th7) {
                                if (th7 instanceof t2) {
                                    t2 t2Var7 = th7;
                                    listF07 = p9.f0(t2Var7.a, t2Var7.b, t2Var7.c);
                                } else {
                                    listF07 = p9.f0(th7.getClass().getSimpleName(), th7.toString(), za0.m("Cause: ", th7.getCause(), ", Stacktrace: ", Log.getStackTraceString(th7)));
                                }
                            }
                            i3Var.s(listF07);
                            break;
                        case 7:
                            c9 c9Var9 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj15 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj15);
                            WebSettings webSettings8 = (WebSettings) obj15;
                            Object obj16 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj16);
                            boolean zBooleanValue7 = ((Boolean) obj16).booleanValue();
                            try {
                                c9Var9.getClass();
                                webSettings8.setDisplayZoomControls(zBooleanValue7);
                                listF08 = k6.G(null);
                                break;
                            } catch (Throwable th8) {
                                if (th8 instanceof t2) {
                                    t2 t2Var8 = th8;
                                    listF08 = p9.f0(t2Var8.a, t2Var8.b, t2Var8.c);
                                } else {
                                    listF08 = p9.f0(th8.getClass().getSimpleName(), th8.toString(), za0.m("Cause: ", th8.getCause(), ", Stacktrace: ", Log.getStackTraceString(th8)));
                                }
                            }
                            i3Var.s(listF08);
                            break;
                        case 8:
                            c9 c9Var10 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj17 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj17);
                            WebSettings webSettings9 = (WebSettings) obj17;
                            Object obj18 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj18);
                            boolean zBooleanValue8 = ((Boolean) obj18).booleanValue();
                            try {
                                c9Var10.getClass();
                                webSettings9.setBuiltInZoomControls(zBooleanValue8);
                                listF09 = k6.G(null);
                                break;
                            } catch (Throwable th9) {
                                if (th9 instanceof t2) {
                                    t2 t2Var9 = th9;
                                    listF09 = p9.f0(t2Var9.a, t2Var9.b, t2Var9.c);
                                } else {
                                    listF09 = p9.f0(th9.getClass().getSimpleName(), th9.toString(), za0.m("Cause: ", th9.getCause(), ", Stacktrace: ", Log.getStackTraceString(th9)));
                                }
                            }
                            i3Var.s(listF09);
                            break;
                        case 9:
                            c9 c9Var11 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj19 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj19);
                            WebSettings webSettings10 = (WebSettings) obj19;
                            Object obj20 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj20);
                            boolean zBooleanValue9 = ((Boolean) obj20).booleanValue();
                            try {
                                c9Var11.getClass();
                                webSettings10.setAllowFileAccess(zBooleanValue9);
                                listF010 = k6.G(null);
                                break;
                            } catch (Throwable th10) {
                                if (th10 instanceof t2) {
                                    t2 t2Var10 = th10;
                                    listF010 = p9.f0(t2Var10.a, t2Var10.b, t2Var10.c);
                                } else {
                                    listF010 = p9.f0(th10.getClass().getSimpleName(), th10.toString(), za0.m("Cause: ", th10.getCause(), ", Stacktrace: ", Log.getStackTraceString(th10)));
                                }
                            }
                            i3Var.s(listF010);
                            break;
                        case 10:
                            c9 c9Var12 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj21 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj21);
                            WebSettings webSettings11 = (WebSettings) obj21;
                            Object obj22 = list11.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj22);
                            boolean zBooleanValue10 = ((Boolean) obj22).booleanValue();
                            try {
                                c9Var12.getClass();
                                webSettings11.setAllowContentAccess(zBooleanValue10);
                                listF011 = k6.G(null);
                                break;
                            } catch (Throwable th11) {
                                if (th11 instanceof t2) {
                                    t2 t2Var11 = th11;
                                    listF011 = p9.f0(t2Var11.a, t2Var11.b, t2Var11.c);
                                } else {
                                    listF011 = p9.f0(th11.getClass().getSimpleName(), th11.toString(), za0.m("Cause: ", th11.getCause(), ", Stacktrace: ", Log.getStackTraceString(th11)));
                                }
                            }
                            i3Var.s(listF011);
                            break;
                        case 11:
                            c9 c9Var13 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj23 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj23);
                            WebSettings webSettings12 = (WebSettings) obj23;
                            Object obj24 = list12.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj24);
                            boolean zBooleanValue11 = ((Boolean) obj24).booleanValue();
                            try {
                                c9Var13.getClass();
                                webSettings12.setGeolocationEnabled(zBooleanValue11);
                                listF012 = k6.G(null);
                                break;
                            } catch (Throwable th12) {
                                if (th12 instanceof t2) {
                                    t2 t2Var12 = th12;
                                    listF012 = p9.f0(t2Var12.a, t2Var12.b, t2Var12.c);
                                } else {
                                    listF012 = p9.f0(th12.getClass().getSimpleName(), th12.toString(), za0.m("Cause: ", th12.getCause(), ", Stacktrace: ", Log.getStackTraceString(th12)));
                                }
                            }
                            i3Var.s(listF012);
                            break;
                        case 12:
                            c9 c9Var14 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj25 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj25);
                            WebSettings webSettings13 = (WebSettings) obj25;
                            Object obj26 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj26);
                            long jLongValue = ((Long) obj26).longValue();
                            try {
                                c9Var14.getClass();
                                webSettings13.setTextZoom((int) jLongValue);
                                listF013 = k6.G(null);
                                break;
                            } catch (Throwable th13) {
                                if (th13 instanceof t2) {
                                    t2 t2Var13 = th13;
                                    listF013 = p9.f0(t2Var13.a, t2Var13.b, t2Var13.c);
                                } else {
                                    listF013 = p9.f0(th13.getClass().getSimpleName(), th13.toString(), za0.m("Cause: ", th13.getCause(), ", Stacktrace: ", Log.getStackTraceString(th13)));
                                }
                            }
                            i3Var.s(listF013);
                            break;
                        case 13:
                            c9 c9Var15 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj27 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj27);
                            WebSettings webSettings14 = (WebSettings) obj27;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(webSettings14.getUserAgentString());
                                break;
                            } catch (Throwable th14) {
                                if (th14 instanceof t2) {
                                    t2 t2Var14 = th14;
                                    listF014 = p9.f0(t2Var14.a, t2Var14.b, t2Var14.c);
                                } else {
                                    listF014 = p9.f0(th14.getClass().getSimpleName(), th14.toString(), za0.m("Cause: ", th14.getCause(), ", Stacktrace: ", Log.getStackTraceString(th14)));
                                }
                            }
                            i3Var.s(listF014);
                            break;
                        case 14:
                            c9 c9Var16 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list14 = (List) obj;
                            Object obj28 = list14.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj28);
                            WebSettings webSettings15 = (WebSettings) obj28;
                            Object obj29 = list14.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode", obj29);
                            vx vxVar = (vx) obj29;
                            try {
                                c9Var16.getClass();
                                int iOrdinal = vxVar.ordinal();
                                if (iOrdinal == 0) {
                                    webSettings15.setMixedContentMode(0);
                                } else if (iOrdinal == 1) {
                                    webSettings15.setMixedContentMode(2);
                                } else if (iOrdinal == 2) {
                                    webSettings15.setMixedContentMode(1);
                                }
                                listF015 = k6.G(null);
                                break;
                            } catch (Throwable th15) {
                                if (th15 instanceof t2) {
                                    t2 t2Var15 = th15;
                                    listF015 = p9.f0(t2Var15.a, t2Var15.b, t2Var15.c);
                                } else {
                                    listF015 = p9.f0(th15.getClass().getSimpleName(), th15.toString(), za0.m("Cause: ", th15.getCause(), ", Stacktrace: ", Log.getStackTraceString(th15)));
                                }
                            }
                            i3Var.s(listF015);
                            break;
                        case 15:
                            c9 c9Var17 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            Object obj30 = list15.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj30);
                            WebSettings webSettings16 = (WebSettings) obj30;
                            Object obj31 = list15.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue12 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var17.getClass();
                                webSettings16.setJavaScriptCanOpenWindowsAutomatically(zBooleanValue12);
                                listF016 = k6.G(null);
                                break;
                            } catch (Throwable th16) {
                                if (th16 instanceof t2) {
                                    t2 t2Var16 = th16;
                                    listF016 = p9.f0(t2Var16.a, t2Var16.b, t2Var16.c);
                                } else {
                                    listF016 = p9.f0(th16.getClass().getSimpleName(), th16.toString(), za0.m("Cause: ", th16.getCause(), ", Stacktrace: ", Log.getStackTraceString(th16)));
                                }
                            }
                            i3Var.s(listF016);
                            break;
                        default:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list16 = (List) obj;
                            Object obj32 = list16.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj32);
                            WebSettings webSettings17 = (WebSettings) obj32;
                            Object obj33 = list16.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj33);
                            boolean zBooleanValue13 = ((Boolean) obj33).booleanValue();
                            try {
                                c9Var18.getClass();
                                webSettings17.setSupportMultipleWindows(zBooleanValue13);
                                listF017 = k6.G(null);
                                break;
                            } catch (Throwable th17) {
                                if (th17 instanceof t2) {
                                    t2 t2Var17 = th17;
                                    listF017 = p9.f0(t2Var17.a, t2Var17.b, t2Var17.c);
                                } else {
                                    listF017 = p9.f0(th17.getClass().getSimpleName(), th17.toString(), za0.m("Cause: ", th17.getCause(), ", Stacktrace: ", Log.getStackTraceString(th17)));
                                }
                            }
                            i3Var.s(listF017);
                            break;
                    }
                }
            });
        }
    }

    public static final Object V(x60 x60Var, x60 x60Var2, jp jpVar) throws Throwable {
        Object gaVar;
        Object objK;
        try {
            wf0.c(2, jpVar);
            gaVar = jpVar.c(x60Var2, x60Var);
        } catch (Throwable th) {
            gaVar = new ga(th, false);
        }
        vc vcVar = vc.a;
        if (gaVar == vcVar || (objK = x60Var.K(gaVar)) == xe.h) {
            return vcVar;
        }
        if (objK instanceof ga) {
            throw ((ga) objK).a;
        }
        return xe.O(objK);
    }

    /* JADX WARN: Finally extract failed */
    public static boolean W(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, ag[] agVarArr) throws IOException {
        long j;
        int length;
        byte[] bArr2 = xe.s;
        byte[] bArr3 = xe.r;
        byte[] bArr4 = xe.o;
        int i2 = 0;
        if (Arrays.equals(bArr, bArr4)) {
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                pr.a0(byteArrayOutputStream2, agVarArr.length);
                int i3 = 2;
                int i4 = 2;
                for (ag agVar : agVarArr) {
                    pr.Z(byteArrayOutputStream2, agVar.c, 4);
                    pr.Z(byteArrayOutputStream2, agVar.d, 4);
                    pr.Z(byteArrayOutputStream2, agVar.g, 4);
                    String strR = r(agVar.a, agVar.b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = strR.getBytes(charset).length;
                    pr.a0(byteArrayOutputStream2, length2);
                    i4 = i4 + 14 + length2;
                    byteArrayOutputStream2.write(strR.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i4 != byteArray.length) {
                    throw new IllegalStateException("Expected size " + i4 + ", does not match actual size " + byteArray.length);
                }
                lm0 lm0Var = new lm0(false, byteArray, 1);
                byteArrayOutputStream2.close();
                arrayList.add(lm0Var);
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                int i5 = 0;
                int i6 = 0;
                while (i5 < agVarArr.length) {
                    try {
                        ag agVar2 = agVarArr[i5];
                        pr.a0(byteArrayOutputStream3, i5);
                        pr.a0(byteArrayOutputStream3, agVar2.e);
                        i6 = i6 + 4 + (agVar2.e * i3);
                        int[] iArr = agVar2.h;
                        int length3 = iArr.length;
                        int i7 = i2;
                        int i8 = i3;
                        int i9 = i7;
                        while (i9 < length3) {
                            int i10 = iArr[i9];
                            pr.a0(byteArrayOutputStream3, i10 - i7);
                            i9++;
                            i7 = i10;
                        }
                        i5++;
                        i3 = i8;
                        i2 = 0;
                    } catch (Throwable th) {
                    }
                }
                byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                if (i6 != byteArray2.length) {
                    throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray2.length);
                }
                lm0 lm0Var2 = new lm0(true, byteArray2, 3);
                byteArrayOutputStream3.close();
                arrayList.add(lm0Var2);
                byteArrayOutputStream3 = new ByteArrayOutputStream();
                int i11 = 0;
                int i12 = 0;
                while (i11 < agVarArr.length) {
                    try {
                        ag agVar3 = agVarArr[i11];
                        Iterator it = agVar3.i.entrySet().iterator();
                        int iIntValue = 0;
                        while (it.hasNext()) {
                            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
                        }
                        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            b0(byteArrayOutputStream4, agVar3);
                            byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            byteArrayOutputStream4 = new ByteArrayOutputStream();
                            try {
                                c0(byteArrayOutputStream4, agVar3);
                                byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                                byteArrayOutputStream4.close();
                                pr.a0(byteArrayOutputStream3, i11);
                                int length4 = byteArray3.length + 2 + byteArray4.length;
                                int i13 = i12 + 6;
                                int i14 = i11;
                                pr.Z(byteArrayOutputStream3, length4, 4);
                                pr.a0(byteArrayOutputStream3, iIntValue);
                                byteArrayOutputStream3.write(byteArray3);
                                byteArrayOutputStream3.write(byteArray4);
                                i12 = i13 + length4;
                                i11 = i14 + 1;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                        try {
                            byteArrayOutputStream3.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                }
                byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                if (i12 != byteArray5.length) {
                    throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray5.length);
                }
                lm0 lm0Var3 = new lm0(true, byteArray5, 4);
                byteArrayOutputStream3.close();
                arrayList.add(lm0Var3);
                long j2 = 4;
                long size = j2 + j2 + 4 + ((long) (arrayList.size() * 16));
                pr.Z(byteArrayOutputStream, arrayList.size(), 4);
                for (int i15 = 0; i15 < arrayList.size(); i15++) {
                    lm0 lm0Var4 = (lm0) arrayList.get(i15);
                    int i16 = lm0Var4.a;
                    byte[] bArr5 = lm0Var4.b;
                    if (i16 == 1) {
                        j = 0;
                    } else if (i16 == 2) {
                        j = 1;
                    } else if (i16 == 3) {
                        j = 2;
                    } else if (i16 == 4) {
                        j = 3;
                    } else {
                        if (i16 != 5) {
                            throw null;
                        }
                        j = 4;
                    }
                    pr.Z(byteArrayOutputStream, j, 4);
                    pr.Z(byteArrayOutputStream, size, 4);
                    if (lm0Var4.c) {
                        long length5 = bArr5.length;
                        byte[] bArrM = pr.m(bArr5);
                        arrayList2.add(bArrM);
                        pr.Z(byteArrayOutputStream, bArrM.length, 4);
                        pr.Z(byteArrayOutputStream, length5, 4);
                        length = bArrM.length;
                    } else {
                        arrayList2.add(bArr5);
                        pr.Z(byteArrayOutputStream, bArr5.length, 4);
                        pr.Z(byteArrayOutputStream, 0L, 4);
                        length = bArr5.length;
                    }
                    size += (long) length;
                }
                for (int i17 = 0; i17 < arrayList2.size(); i17++) {
                    byteArrayOutputStream.write((byte[]) arrayList2.get(i17));
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream2.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } else {
            byte[] bArr6 = xe.p;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] bArrL = l(agVarArr, bArr6);
                pr.Z(byteArrayOutputStream, agVarArr.length, 1);
                pr.Z(byteArrayOutputStream, bArrL.length, 4);
                byte[] bArrM2 = pr.m(bArrL);
                pr.Z(byteArrayOutputStream, bArrM2.length, 4);
                byteArrayOutputStream.write(bArrM2);
                return true;
            }
            if (Arrays.equals(bArr, bArr3)) {
                pr.Z(byteArrayOutputStream, agVarArr.length, 1);
                for (ag agVar4 : agVarArr) {
                    int size2 = agVar4.i.size() * 4;
                    String strR2 = r(agVar4.a, agVar4.b, bArr3);
                    Charset charset2 = StandardCharsets.UTF_8;
                    pr.a0(byteArrayOutputStream, strR2.getBytes(charset2).length);
                    pr.a0(byteArrayOutputStream, agVar4.h.length);
                    pr.Z(byteArrayOutputStream, size2, 4);
                    pr.Z(byteArrayOutputStream, agVar4.c, 4);
                    byteArrayOutputStream.write(strR2.getBytes(charset2));
                    Iterator it2 = agVar4.i.keySet().iterator();
                    while (it2.hasNext()) {
                        pr.a0(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                        pr.a0(byteArrayOutputStream, 0);
                    }
                    for (int i18 : agVar4.h) {
                        pr.a0(byteArrayOutputStream, i18);
                    }
                }
            } else {
                byte[] bArr7 = xe.q;
                if (Arrays.equals(bArr, bArr7)) {
                    byte[] bArrL2 = l(agVarArr, bArr7);
                    pr.Z(byteArrayOutputStream, agVarArr.length, 1);
                    pr.Z(byteArrayOutputStream, bArrL2.length, 4);
                    byte[] bArrM3 = pr.m(bArrL2);
                    pr.Z(byteArrayOutputStream, bArrM3.length, 4);
                    byteArrayOutputStream.write(bArrM3);
                    return true;
                }
                if (!Arrays.equals(bArr, bArr2)) {
                    return false;
                }
                pr.a0(byteArrayOutputStream, agVarArr.length);
                for (ag agVar5 : agVarArr) {
                    String str = agVar5.a;
                    TreeMap treeMap = agVar5.i;
                    String strR3 = r(str, agVar5.b, bArr2);
                    Charset charset3 = StandardCharsets.UTF_8;
                    pr.a0(byteArrayOutputStream, strR3.getBytes(charset3).length);
                    pr.a0(byteArrayOutputStream, treeMap.size());
                    pr.a0(byteArrayOutputStream, agVar5.h.length);
                    pr.Z(byteArrayOutputStream, agVar5.c, 4);
                    byteArrayOutputStream.write(strR3.getBytes(charset3));
                    Iterator it3 = treeMap.keySet().iterator();
                    while (it3.hasNext()) {
                        pr.a0(byteArrayOutputStream, ((Integer) it3.next()).intValue());
                    }
                    for (int i19 : agVar5.h) {
                        pr.a0(byteArrayOutputStream, i19);
                    }
                }
            }
        }
        return true;
    }

    public static final boolean X(String str, uo uoVar) {
        try {
            boolean zBooleanValue = ((Boolean) uoVar.a()).booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "ClassNotFound: ".concat(str));
            return false;
        } catch (NoSuchMethodException unused2) {
            if (str == null) {
                str = "";
            }
            Log.e("ReflectionGuard", "NoSuchMethod: ".concat(str));
            return false;
        }
    }

    public static final Object Y(lc lcVar, Object obj, Object obj2, jp jpVar, yb ybVar) {
        Object objC;
        Object objP = xe.P(lcVar, obj2);
        try {
            ib0 ib0Var = new ib0(ybVar, lcVar);
            if (jpVar == null) {
                objC = pr.Y(jpVar, obj, ib0Var);
            } else {
                wf0.c(2, jpVar);
                objC = jpVar.c(obj, ib0Var);
            }
            xe.C(lcVar, objP);
            return objC;
        } catch (Throwable th) {
            xe.C(lcVar, objP);
            throw th;
        }
    }

    public static ArrayList Z(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof jx) {
            jx jxVar = (jx) th;
            arrayList.add(jxVar.a);
            arrayList.add(jxVar.getMessage());
            arrayList.add(null);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        if (bitmap != null) {
            switch (i2) {
                case 1:
                case 3:
                case 6:
                case 8:
                    break;
                case 2:
                case 4:
                case 5:
                case 7:
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    Matrix matrix = new Matrix();
                    if (i2 == 2 || i2 == 7) {
                        matrix.setScale(-1.0f, 1.0f, width / 2.0f, height / 2.0f);
                    } else if (i2 == 4 || i2 == 5) {
                        matrix.setScale(1.0f, -1.0f, width / 2.0f, height / 2.0f);
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                    if (bitmapCreateBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    break;
                default:
                    Log.e("ImageUtils", "Unknown EXIF orientation: " + i2);
                    break;
            }
            return bitmap;
        }
        return bitmap;
    }

    public static void a0(ByteArrayOutputStream byteArrayOutputStream, ag agVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        pr.a0(byteArrayOutputStream, str.getBytes(charset).length);
        pr.a0(byteArrayOutputStream, agVar.e);
        pr.Z(byteArrayOutputStream, agVar.f, 4);
        pr.Z(byteArrayOutputStream, agVar.c, 4);
        pr.Z(byteArrayOutputStream, agVar.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = c(r8, r9, r10)
            boolean r1 = c(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = H(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.k6.b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static void b0(ByteArrayOutputStream byteArrayOutputStream, ag agVar) throws IOException {
        byte[] bArr = new byte[(((agVar.g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : agVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i2 = iIntValue / 8;
                bArr[i2] = (byte) (bArr[i2] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i3 = iIntValue + agVar.g;
                int i4 = i3 / 8;
                bArr[i4] = (byte) ((1 << (i3 % 8)) | bArr[i4]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static boolean c(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void c0(ByteArrayOutputStream byteArrayOutputStream, ag agVar) throws IOException {
        int i2 = 0;
        for (Map.Entry entry : agVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                pr.a0(byteArrayOutputStream, iIntValue - i2);
                pr.a0(byteArrayOutputStream, 0);
                i2 = iIntValue;
            }
        }
    }

    public static Object d(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(k6.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static void e(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o30.v, i2, i3);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                g(context, i, "Theme.MaterialComponents");
            }
        }
        g(context, h, "Theme.AppCompat");
    }

    public static void f(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o30.v, i2, i3);
        boolean z = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i4 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i4, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void g(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(za0.l("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static Uri h(Uri uri, int i2, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                File fileCreateTempFile = File.createTempFile(za0.l("JPEG_", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), "_"), ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Uri uriFromFile = Uri.fromFile(fileCreateTempFile);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return uriFromFile;
            } finally {
            }
        } catch (FileNotFoundException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void j(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        int i2 = inputStream.read(bArr);
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            i2 = inputStream.read(bArr);
        }
    }

    public static zn k(Context context) {
        ProviderInfo providerInfo;
        xn xnVar;
        ApplicationInfo applicationInfo;
        mh zeVar = Build.VERSION.SDK_INT >= 28 ? new ze(29) : new mh(29);
        PackageManager packageManager = context.getPackageManager();
        pr.h("Package manager required to locate emoji font provider", packageManager);
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            xnVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrS = zeVar.s(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrS) {
                    arrayList.add(signature.toByteArray());
                }
                xnVar = new xn(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                xnVar = null;
            }
        }
        if (xnVar == null) {
            return null;
        }
        return new zn(new yn(context, xnVar));
    }

    public static byte[] l(ag[] agVarArr, byte[] bArr) throws IOException {
        int length = 0;
        for (ag agVar : agVarArr) {
            length += ((((agVar.g * 2) + 7) & (-8)) / 8) + (agVar.e * 2) + r(agVar.a, agVar.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + agVar.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, xe.q)) {
            for (ag agVar2 : agVarArr) {
                a0(byteArrayOutputStream, agVar2, r(agVar2.a, agVar2.b, bArr));
                c0(byteArrayOutputStream, agVar2);
                int[] iArr = agVar2.h;
                int length2 = iArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length2) {
                    int i4 = iArr[i2];
                    pr.a0(byteArrayOutputStream, i4 - i3);
                    i2++;
                    i3 = i4;
                }
                b0(byteArrayOutputStream, agVar2);
            }
        } else {
            for (ag agVar3 : agVarArr) {
                a0(byteArrayOutputStream, agVar3, r(agVar3.a, agVar3.b, bArr));
            }
            for (ag agVar4 : agVarArr) {
                c0(byteArrayOutputStream, agVar4);
                int[] iArr2 = agVar4.h;
                int length3 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length3) {
                    int i7 = iArr2[i5];
                    pr.a0(byteArrayOutputStream, i7 - i6);
                    i5++;
                    i6 = i7;
                }
                b0(byteArrayOutputStream, agVar4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static String m(String str, Object obj) {
        pr.j("value", obj);
        return str + " value: " + obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:54:0x00b6, B:56:0x00b9, B:57:0x00c5, B:58:0x00ca, B:59:0x00cb, B:60:0x00d0), top: B:74:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:54:0x00b6, B:56:0x00b9, B:57:0x00c5, B:58:0x00ca, B:59:0x00cb, B:60:0x00d0), top: B:74:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:54:0x00b6, B:56:0x00b9, B:57:0x00c5, B:58:0x00ca, B:59:0x00cb, B:60:0x00d0), top: B:74:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sensei0.uz[] n(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.k6.n(java.lang.String):sensei0.uz[]");
    }

    public static boolean o(Method method, t8 t8Var) {
        Class clsA = t8Var.a();
        pr.g("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>", clsA);
        return method.getReturnType().equals(clsA);
    }

    public static String p(u6 u6Var) {
        StringBuilder sb = new StringBuilder(u6Var.size());
        for (int i2 = 0; i2 < u6Var.size(); i2++) {
            byte bA = u6Var.a(i2);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final Object q(d70 d70Var, long j, jp jpVar) {
        while (true) {
            if (d70Var.c >= j && !d70Var.c()) {
                return d70Var;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.a;
            Object obj = atomicReferenceFieldUpdater.get(d70Var);
            tn tnVar = b;
            if (obj == tnVar) {
                return tnVar;
            }
            d70 d70Var2 = (d70) ((na) obj);
            if (d70Var2 == null) {
                d70Var2 = (d70) jpVar.c(Long.valueOf(d70Var.c + 1), d70Var);
                while (!atomicReferenceFieldUpdater.compareAndSet(d70Var, null, d70Var2)) {
                    if (atomicReferenceFieldUpdater.get(d70Var) != null) {
                        break;
                    }
                }
                if (d70Var.c()) {
                    d70Var.d();
                }
            }
            d70Var = d70Var2;
        }
    }

    public static String r(String str, String str2, byte[] bArr) {
        byte[] bArr2 = xe.r;
        byte[] bArr3 = xe.s;
        String str3 = (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                return za0.o(sb, (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static jc s(jc jcVar, kc kcVar) {
        pr.j("key", kcVar);
        if (pr.b(jcVar.getKey(), kcVar)) {
            return jcVar;
        }
        return null;
    }

    public static ColorStateList t(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList colorStateListK;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListK = wf0.k(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : colorStateListK;
    }

    public static ColorStateList u(Context context, o4 o4Var, int i2) {
        int resourceId;
        ColorStateList colorStateListK;
        TypedArray typedArray = (TypedArray) o4Var.b;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListK = wf0.k(context, resourceId)) == null) ? o4Var.E(i2) : colorStateListK;
    }

    public static String v(Class cls, Object obj) {
        if (Build.VERSION.SDK_INT < 30) {
            return (String) cls.getMethod("getPath", null).invoke(obj, null);
        }
        File file = (File) cls.getMethod("getDirectory", null).invoke(obj, null);
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static Drawable w(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable drawableM;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawableM = wf0.m(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawableM;
    }

    public static Set x() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static String y(Context context, Uri uri) {
        Uri uri2;
        int iLastIndexOf;
        String path = null;
        try {
            if (uri.getScheme().equals("content")) {
                uri2 = uri;
                Cursor cursorQuery = context.getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            path = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
            } else {
                uri2 = uri;
            }
            return (path != null || (iLastIndexOf = (path = uri2.getPath()).lastIndexOf(47)) == -1) ? path : path.substring(iLastIndexOf + 1);
        } catch (Exception e2) {
            Log.e("FilePickerUtils", "Failed to handle file name: " + e2.toString());
            return path;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class z(ns nsVar) {
        pr.j("<this>", nsVar);
        Class clsA = ((r8) nsVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public abstract k6 S(String str, fp fpVar);

    public abstract Object i();
}
