package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.security.keystore.KeyGenParameterSpec;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xe {
    public static final tn g;
    public static final tn h;
    public static final tn i;
    public static final tn j;
    public static final tn k;
    public static final tn n;
    public static final tn v;
    public static final float[][] a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final int[] e = new int[0];
    public static final Object[] f = new Object[0];
    public static final mi l = new mi(false);
    public static final mi m = new mi(true);
    public static final byte[] o = {48, 49, 53, 0};
    public static final byte[] p = {48, 49, 48, 0};
    public static final byte[] q = {48, 48, 57, 0};
    public static final byte[] r = {48, 48, 53, 0};
    public static final byte[] s = {48, 48, 49, 0};
    public static final byte[] t = {48, 48, 49, 0};
    public static final byte[] u = {48, 48, 50, 0};

    static {
        int i2 = 4;
        g = new tn("COMPLETING_ALREADY", i2);
        h = new tn("COMPLETING_WAITING_CHILDREN", i2);
        i = new tn("COMPLETING_RETRY", i2);
        j = new tn("TOO_LATE_TO_CANCEL", i2);
        k = new tn("SEALED", i2);
        n = new tn("NO_OWNER", i2);
        v = new tn("NO_THREAD_ELEMENTS", i2);
    }

    public static final String A(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        int i2 = reader.read(cArr);
        while (i2 >= 0) {
            stringWriter.write(cArr, 0, i2);
            i2 = reader.read(cArr);
        }
        String string = stringWriter.toString();
        pr.i("toString(...)", string);
        return string;
    }

    public static final Object B(Object obj) {
        return obj instanceof ga ? wf0.i(((ga) obj).a) : obj;
    }

    public static final void C(lc lcVar, Object obj) {
        if (obj == v) {
            return;
        }
        if (!(obj instanceof ke0)) {
            Object objD = lcVar.d(null, mc.o);
            pr.g("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>", objD);
            za0.q(objD);
            throw null;
        }
        ke0 ke0Var = (ke0) obj;
        he0[] he0VarArr = ke0Var.b;
        int length = he0VarArr.length - 1;
        if (length < 0) {
            return;
        }
        he0 he0Var = he0VarArr[length];
        pr.f(null);
        Object obj2 = ke0Var.a[length];
        throw null;
    }

    public static final void D(f7 f7Var, xb xbVar, boolean z) {
        Object obj = f7.o.get(f7Var);
        Throwable thD = f7Var.d(obj);
        Object objI = thD != null ? wf0.i(thD) : f7Var.g(obj);
        if (!z) {
            xbVar.h(objI);
            return;
        }
        pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>", xbVar);
        hg hgVar = (hg) xbVar;
        yb ybVar = hgVar.f;
        Object obj2 = hgVar.o;
        lc lcVarF = ybVar.f();
        Object objP = P(lcVarF, obj2);
        jg0 jg0VarQ = objP != v ? Q(ybVar, lcVarF, objP) : null;
        try {
            ybVar.h(objI);
            if (jg0VarQ == null || jg0VarQ.W()) {
                C(lcVarF, objP);
            }
        } catch (Throwable th) {
            if (jg0VarQ == null || jg0VarQ.W()) {
                C(lcVarF, objP);
            }
            throw th;
        }
    }

    public static void G(View view, kw kwVar) {
        ph phVar = kwVar.a.b;
        if (phVar == null || !phVar.a) {
            return;
        }
        float fE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            Field field = ai0.a;
            fE += th0.e((View) parent);
        }
        jw jwVar = kwVar.a;
        if (jwVar.l != fE) {
            jwVar.l = fE;
            kwVar.m();
        }
    }

    public static void H(a6 a6Var, final v2 v2Var) {
        pr.j("binaryMessenger", a6Var);
        dd0 dd0Var = z2.b;
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", (dx) dd0Var.a(), null);
        if (v2Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.y2
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    switch (i2) {
                        case 0:
                            v2 v2Var2 = v2Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            Long l2 = (Long) obj2;
                            long jLongValue = l2.longValue();
                            try {
                                v2Var2.f();
                                Object objE = v2Var2.e(jLongValue);
                                if (objE instanceof nk0) {
                                    ((nk0) objE).destroy();
                                }
                                v2Var2.d.remove(l2);
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
                        default:
                            v2 v2Var3 = v2Var;
                            try {
                                v2Var3.b.clear();
                                v2Var3.c.clear();
                                v2Var3.d.clear();
                                v2Var3.f.clear();
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
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.clear", (dx) dd0Var.a(), null);
        if (v2Var == null) {
            j1Var2.l(null);
        } else {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.y2
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    switch (i3) {
                        case 0:
                            v2 v2Var2 = v2Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            Long l2 = (Long) obj2;
                            long jLongValue = l2.longValue();
                            try {
                                v2Var2.f();
                                Object objE = v2Var2.e(jLongValue);
                                if (objE instanceof nk0) {
                                    ((nk0) objE).destroy();
                                }
                                v2Var2.d.remove(l2);
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
                        default:
                            v2 v2Var3 = v2Var;
                            try {
                                v2Var3.b.clear();
                                v2Var3.c.clear();
                                v2Var3.d.clear();
                                v2Var3.f.clear();
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
                    }
                }
            });
        }
    }

    public static void I(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getIssuedBy", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.k00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    X509Certificate x509Certificate;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj2);
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(sslCertificate.getIssuedBy());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj3);
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(sslCertificate2.getIssuedTo());
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
                            Object obj4 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj4);
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c9Var4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                listF03 = k6.G(validNotAfterDate != null ? Long.valueOf(validNotAfterDate.getTime()) : null);
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
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj5);
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c9Var5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                listF04 = k6.G(validNotBeforeDate != null ? Long.valueOf(validNotBeforeDate.getTime()) : null);
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
                        default:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj6);
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c9Var6.a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                listF05 = k6.G(x509Certificate);
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
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getIssuedTo", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.k00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    X509Certificate x509Certificate;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj2);
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(sslCertificate.getIssuedBy());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj3);
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(sslCertificate2.getIssuedTo());
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
                            Object obj4 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj4);
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c9Var4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                listF03 = k6.G(validNotAfterDate != null ? Long.valueOf(validNotAfterDate.getTime()) : null);
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
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj5);
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c9Var5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                listF04 = k6.G(validNotBeforeDate != null ? Long.valueOf(validNotBeforeDate.getTime()) : null);
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
                        default:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj6);
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c9Var6.a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                listF05 = k6.G(x509Certificate);
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
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getValidNotAfterMsSinceEpoch", lxVar, null);
        if (c9Var != null) {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.k00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    X509Certificate x509Certificate;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj2);
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(sslCertificate.getIssuedBy());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj3);
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(sslCertificate2.getIssuedTo());
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
                            Object obj4 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj4);
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c9Var4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                listF03 = k6.G(validNotAfterDate != null ? Long.valueOf(validNotAfterDate.getTime()) : null);
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
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj5);
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c9Var5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                listF04 = k6.G(validNotBeforeDate != null ? Long.valueOf(validNotBeforeDate.getTime()) : null);
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
                        default:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj6);
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c9Var6.a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                listF05 = k6.G(x509Certificate);
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
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getValidNotBeforeMsSinceEpoch", lxVar, null);
        if (c9Var != null) {
            final int i5 = 3;
            j1Var4.l(new u5() { // from class: sensei0.k00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    X509Certificate x509Certificate;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj2);
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(sslCertificate.getIssuedBy());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj3);
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(sslCertificate2.getIssuedTo());
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
                            Object obj4 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj4);
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c9Var4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                listF03 = k6.G(validNotAfterDate != null ? Long.valueOf(validNotAfterDate.getTime()) : null);
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
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj5);
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c9Var5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                listF04 = k6.G(validNotBeforeDate != null ? Long.valueOf(validNotBeforeDate.getTime()) : null);
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
                        default:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj6);
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c9Var6.a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                listF05 = k6.G(x509Certificate);
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
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.getX509Certificate", lxVar, null);
        if (c9Var == null) {
            j1Var5.l(null);
        } else {
            final int i6 = 4;
            j1Var5.l(new u5() { // from class: sensei0.k00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    X509Certificate x509Certificate;
                    switch (i6) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj2);
                            SslCertificate sslCertificate = (SslCertificate) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(sslCertificate.getIssuedBy());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj3);
                            SslCertificate sslCertificate2 = (SslCertificate) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(sslCertificate2.getIssuedTo());
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
                            Object obj4 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj4);
                            SslCertificate sslCertificate3 = (SslCertificate) obj4;
                            try {
                                c9Var4.getClass();
                                Date validNotAfterDate = sslCertificate3.getValidNotAfterDate();
                                listF03 = k6.G(validNotAfterDate != null ? Long.valueOf(validNotAfterDate.getTime()) : null);
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
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj5);
                            SslCertificate sslCertificate4 = (SslCertificate) obj5;
                            try {
                                c9Var5.getClass();
                                Date validNotBeforeDate = sslCertificate4.getValidNotBeforeDate();
                                listF04 = k6.G(validNotBeforeDate != null ? Long.valueOf(validNotBeforeDate.getTime()) : null);
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
                        default:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate", obj6);
                            SslCertificate sslCertificate5 = (SslCertificate) obj6;
                            try {
                                c9Var6.a.getClass();
                                if (Build.VERSION.SDK_INT >= 29) {
                                    x509Certificate = sslCertificate5.getX509Certificate();
                                } else {
                                    Log.d("SslCertificateProxyApi", "SslCertificate.getX509Certificate requires Build.VERSION_CODES.Q.");
                                    x509Certificate = null;
                                }
                                listF05 = k6.G(x509Certificate);
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
                    }
                }
            });
        }
    }

    public static void J(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_defaultConstructor", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i3 = 1;
                            h00 h00Var = new h00(i3Var, i3);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i3));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.settings", lxVar, null);
        if (c9Var != null) {
            final int i3 = 2;
            j1Var2.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.loadData", lxVar, null);
        if (c9Var != null) {
            final int i4 = 6;
            j1Var3.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.loadDataWithBaseUrl", lxVar, null);
        if (c9Var != null) {
            final int i5 = 7;
            j1Var4.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.loadUrl", lxVar, null);
        if (c9Var != null) {
            final int i6 = 8;
            j1Var5.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i6) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.postUrl", lxVar, null);
        if (c9Var != null) {
            final int i7 = 9;
            j1Var6.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i7) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var6.l(null);
        }
        j1 j1Var7 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.getUrl", lxVar, null);
        if (c9Var != null) {
            final int i8 = 10;
            j1Var7.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i8) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var7.l(null);
        }
        j1 j1Var8 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoBack", lxVar, null);
        if (c9Var != null) {
            final int i9 = 12;
            j1Var8.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i9) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var8.l(null);
        }
        j1 j1Var9 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoForward", lxVar, null);
        if (c9Var != null) {
            final int i10 = 13;
            j1Var9.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i10) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var9.l(null);
        }
        j1 j1Var10 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.goBack", lxVar, null);
        if (c9Var != null) {
            final int i11 = 14;
            j1Var10.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i11) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var10.l(null);
        }
        j1 j1Var11 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.goForward", lxVar, null);
        if (c9Var != null) {
            final int i12 = 11;
            j1Var11.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i12) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var11.l(null);
        }
        j1 j1Var12 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.reload", lxVar, null);
        if (c9Var != null) {
            final int i13 = 15;
            j1Var12.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i13) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var12.l(null);
        }
        j1 j1Var13 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.clearCache", lxVar, null);
        if (c9Var != null) {
            final int i14 = 16;
            j1Var13.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i14) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var13.l(null);
        }
        j1 j1Var14 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.evaluateJavascript", lxVar, null);
        if (c9Var != null) {
            final int i15 = 17;
            j1Var14.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i15) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var14.l(null);
        }
        j1 j1Var15 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.getTitle", lxVar, null);
        if (c9Var != null) {
            final int i16 = 18;
            j1Var15.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i16) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var15.l(null);
        }
        j1 j1Var16 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebContentsDebuggingEnabled", lxVar, null);
        if (c9Var != null) {
            final int i17 = 19;
            j1Var16.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i17) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var16.l(null);
        }
        j1 j1Var17 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebViewClient", lxVar, null);
        if (c9Var != null) {
            final int i18 = 20;
            j1Var17.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i18) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var17.l(null);
        }
        j1 j1Var18 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.addJavaScriptChannel", lxVar, null);
        if (c9Var != null) {
            final int i19 = 21;
            j1Var18.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i19) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var18.l(null);
        }
        j1 j1Var19 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.removeJavaScriptChannel", lxVar, null);
        if (c9Var != null) {
            final int i20 = 22;
            j1Var19.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i20) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var19.l(null);
        }
        j1 j1Var20 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.setDownloadListener", lxVar, null);
        if (c9Var != null) {
            final int i21 = 1;
            j1Var20.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i21) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var20.l(null);
        }
        j1 j1Var21 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebChromeClient", lxVar, null);
        if (c9Var != null) {
            final int i22 = 3;
            j1Var21.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i22) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var21.l(null);
        }
        j1 j1Var22 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.setBackgroundColor", lxVar, null);
        if (c9Var != null) {
            final int i23 = 4;
            j1Var22.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i23) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        } else {
            j1Var22.l(null);
        }
        j1 j1Var23 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.destroy", lxVar, null);
        if (c9Var == null) {
            j1Var23.l(null);
        } else {
            final int i24 = 5;
            j1Var23.l(new u5() { // from class: sensei0.r00
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
                    List listF018;
                    List listF019;
                    List listF020;
                    List listF021;
                    List listF022;
                    switch (i24) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), c9Var2.a());
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
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj3);
                            WebView webView = (WebView) obj3;
                            DownloadListener downloadListener = (DownloadListener) list.get(1);
                            try {
                                c9Var3.getClass();
                                webView.setDownloadListener(downloadListener);
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
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj4);
                            WebView webView2 = (WebView) obj4;
                            Object obj5 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj5);
                            try {
                                c9Var4.a.b.a(((Long) obj5).longValue(), webView2.getSettings());
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
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj6);
                            WebView webView3 = (WebView) obj6;
                            qj0 qj0Var = (qj0) list3.get(1);
                            try {
                                c9Var5.getClass();
                                webView3.setWebChromeClient(qj0Var);
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
                            List list4 = (List) obj;
                            Object obj7 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj7);
                            WebView webView4 = (WebView) obj7;
                            Object obj8 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj8);
                            long jLongValue = ((Long) obj8).longValue();
                            try {
                                c9Var6.getClass();
                                webView4.setBackgroundColor((int) jLongValue);
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
                            Object obj9 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj9);
                            WebView webView5 = (WebView) obj9;
                            try {
                                c9Var7.getClass();
                                webView5.destroy();
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
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj10);
                            WebView webView6 = (WebView) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                            String str = (String) obj11;
                            String str2 = (String) list5.get(2);
                            String str3 = (String) list5.get(3);
                            try {
                                c9Var8.getClass();
                                webView6.loadData(str, str2, str3);
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
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj12);
                            WebView webView7 = (WebView) obj12;
                            String str4 = (String) list6.get(1);
                            Object obj13 = list6.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                            String str5 = (String) obj13;
                            String str6 = (String) list6.get(3);
                            String str7 = (String) list6.get(4);
                            String str8 = (String) list6.get(5);
                            try {
                                c9Var9.getClass();
                                webView7.loadDataWithBaseURL(str4, str5, str6, str7, str8);
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
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj14);
                            WebView webView8 = (WebView) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                            String str9 = (String) obj15;
                            Object obj16 = list7.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>", obj16);
                            Map<String, String> map = (Map) obj16;
                            try {
                                c9Var10.getClass();
                                webView8.loadUrl(str9, map);
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
                            List list8 = (List) obj;
                            Object obj17 = list8.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj17);
                            WebView webView9 = (WebView) obj17;
                            Object obj18 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                            String str10 = (String) obj18;
                            Object obj19 = list8.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.ByteArray", obj19);
                            byte[] bArr = (byte[]) obj19;
                            try {
                                c9Var11.getClass();
                                webView9.postUrl(str10, bArr);
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
                            Object obj20 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj20);
                            WebView webView10 = (WebView) obj20;
                            try {
                                c9Var12.getClass();
                                listF011 = k6.G(webView10.getUrl());
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
                            Object obj21 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj21);
                            WebView webView11 = (WebView) obj21;
                            try {
                                c9Var13.getClass();
                                webView11.goForward();
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
                            Object obj22 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj22);
                            WebView webView12 = (WebView) obj22;
                            try {
                                c9Var14.getClass();
                                listF013 = k6.G(Boolean.valueOf(webView12.canGoBack()));
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
                            Object obj23 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj23);
                            WebView webView13 = (WebView) obj23;
                            try {
                                c9Var15.getClass();
                                listF014 = k6.G(Boolean.valueOf(webView13.canGoForward()));
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
                            Object obj24 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj24);
                            WebView webView14 = (WebView) obj24;
                            try {
                                c9Var16.getClass();
                                webView14.goBack();
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
                            Object obj25 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj25);
                            WebView webView15 = (WebView) obj25;
                            try {
                                c9Var17.getClass();
                                webView15.reload();
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
                        case 16:
                            c9 c9Var18 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj26 = list9.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj26);
                            WebView webView16 = (WebView) obj26;
                            Object obj27 = list9.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj27);
                            boolean zBooleanValue = ((Boolean) obj27).booleanValue();
                            try {
                                c9Var18.getClass();
                                webView16.clearCache(zBooleanValue);
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
                        case 17:
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj28 = list10.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj28);
                            Object obj29 = list10.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            int i32 = 1;
                            h00 h00Var = new h00(i3Var, i32);
                            c9Var.getClass();
                            ((WebView) obj28).evaluateJavascript((String) obj29, new ac(h00Var, i32));
                            break;
                        case 18:
                            c9 c9Var19 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj30 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj30);
                            WebView webView17 = (WebView) obj30;
                            try {
                                c9Var19.getClass();
                                listF018 = k6.G(webView17.getTitle());
                                break;
                            } catch (Throwable th18) {
                                if (th18 instanceof t2) {
                                    t2 t2Var18 = th18;
                                    listF018 = p9.f0(t2Var18.a, t2Var18.b, t2Var18.c);
                                } else {
                                    listF018 = p9.f0(th18.getClass().getSimpleName(), th18.toString(), za0.m("Cause: ", th18.getCause(), ", Stacktrace: ", Log.getStackTraceString(th18)));
                                }
                            }
                            i3Var.s(listF018);
                            break;
                        case 19:
                            c9 c9Var20 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj31 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj31);
                            boolean zBooleanValue2 = ((Boolean) obj31).booleanValue();
                            try {
                                c9Var20.getClass();
                                WebView.setWebContentsDebuggingEnabled(zBooleanValue2);
                                listF019 = k6.G(null);
                                break;
                            } catch (Throwable th19) {
                                if (th19 instanceof t2) {
                                    t2 t2Var19 = th19;
                                    listF019 = p9.f0(t2Var19.a, t2Var19.b, t2Var19.c);
                                } else {
                                    listF019 = p9.f0(th19.getClass().getSimpleName(), th19.toString(), za0.m("Cause: ", th19.getCause(), ", Stacktrace: ", Log.getStackTraceString(th19)));
                                }
                            }
                            i3Var.s(listF019);
                            break;
                        case 20:
                            c9 c9Var21 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            Object obj32 = list11.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj32);
                            WebView webView18 = (WebView) obj32;
                            WebViewClient webViewClient = (WebViewClient) list11.get(1);
                            try {
                                c9Var21.getClass();
                                webView18.setWebViewClient(webViewClient);
                                listF020 = k6.G(null);
                                break;
                            } catch (Throwable th20) {
                                if (th20 instanceof t2) {
                                    t2 t2Var20 = th20;
                                    listF020 = p9.f0(t2Var20.a, t2Var20.b, t2Var20.c);
                                } else {
                                    listF020 = p9.f0(th20.getClass().getSimpleName(), th20.toString(), za0.m("Cause: ", th20.getCause(), ", Stacktrace: ", Log.getStackTraceString(th20)));
                                }
                            }
                            i3Var.s(listF020);
                            break;
                        case 21:
                            c9 c9Var22 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list12 = (List) obj;
                            Object obj33 = list12.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj33);
                            WebView webView19 = (WebView) obj33;
                            Object obj34 = list12.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel", obj34);
                            zr zrVar = (zr) obj34;
                            try {
                                c9Var22.getClass();
                                webView19.addJavascriptInterface(zrVar, zrVar.a);
                                listF021 = k6.G(null);
                                break;
                            } catch (Throwable th21) {
                                if (th21 instanceof t2) {
                                    t2 t2Var21 = th21;
                                    listF021 = p9.f0(t2Var21.a, t2Var21.b, t2Var21.c);
                                } else {
                                    listF021 = p9.f0(th21.getClass().getSimpleName(), th21.toString(), za0.m("Cause: ", th21.getCause(), ", Stacktrace: ", Log.getStackTraceString(th21)));
                                }
                            }
                            i3Var.s(listF021);
                            break;
                        default:
                            c9 c9Var23 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            Object obj35 = list13.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj35);
                            WebView webView20 = (WebView) obj35;
                            Object obj36 = list13.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                            String str11 = (String) obj36;
                            try {
                                c9Var23.getClass();
                                webView20.removeJavascriptInterface(str11);
                                listF022 = k6.G(null);
                                break;
                            } catch (Throwable th22) {
                                if (th22 instanceof t2) {
                                    t2 t2Var22 = th22;
                                    listF022 = p9.f0(t2Var22.a, t2Var22.b, t2Var22.c);
                                } else {
                                    listF022 = p9.f0(th22.getClass().getSimpleName(), th22.toString(), za0.m("Cause: ", th22.getCause(), ", Stacktrace: ", Log.getStackTraceString(th22)));
                                }
                            }
                            i3Var.s(listF022);
                            break;
                    }
                }
            });
        }
    }

    public static void K(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static final Object M(lc lcVar) {
        Object objD = lcVar.d(0, mc.h);
        pr.f(objD);
        return objD;
    }

    public static final String N(xb xbVar) {
        Object objI;
        if (xbVar instanceof hg) {
            return xbVar.toString();
        }
        try {
            objI = xbVar + '@' + o(xbVar);
        } catch (Throwable th) {
            objI = wf0.i(th);
        }
        if (v50.a(objI) != null) {
            objI = xbVar.getClass().getName() + '@' + o(xbVar);
        }
        return (String) objI;
    }

    public static final Object O(Object obj) {
        wq wqVar;
        xq xqVar = obj instanceof xq ? (xq) obj : null;
        return (xqVar == null || (wqVar = xqVar.a) == null) ? obj : wqVar;
    }

    public static final Object P(lc lcVar, Object obj) {
        if (obj == null) {
            obj = M(lcVar);
        }
        if (obj == 0) {
            return v;
        }
        if (obj instanceof Integer) {
            return lcVar.d(new ke0(((Number) obj).intValue(), lcVar), mc.p);
        }
        za0.q(obj);
        throw null;
    }

    public static final jg0 Q(xb xbVar, lc lcVar, Object obj) {
        jg0 jg0Var = null;
        if ((xbVar instanceof wc) && lcVar.n(kg0.a) != null) {
            wc wcVarE = (wc) xbVar;
            while (true) {
                if ((wcVarE instanceof ig) || (wcVarE = wcVarE.e()) == null) {
                    break;
                }
                if (wcVarE instanceof jg0) {
                    jg0Var = (jg0) wcVarE;
                    break;
                }
            }
            if (jg0Var != null) {
                jg0Var.X(lcVar, obj);
            }
        }
        return jg0Var;
    }

    public static ArrayList R(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }

    public static void T(File file, String str) throws IOException {
        Charset charset = e8.a;
        pr.j("text", str);
        pr.j("charset", charset);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            U(fileOutputStream, str, charset);
            fileOutputStream.close();
        } finally {
        }
    }

    public static final void U(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        pr.j("text", str);
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            pr.i("getBytes(...)", bytes);
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        pr.f(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        pr.i("allocate(...)", byteBufferAllocate);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int iMin = Math.min(8192 - i3, str.length() - i2);
            int i4 = i2 + iMin;
            char[] cArrArray = charBufferAllocate.array();
            pr.i("array(...)", cArrArray);
            str.getChars(i2, i4, cArrArray, i3);
            charBufferAllocate.limit(iMin + i3);
            i3 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i4 == str.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i3 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i2 = i4;
        }
    }

    public static float V() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static o6 a(int i2, m6 m6Var, int i3) {
        int i4 = i3 & 2;
        m6 m6Var2 = m6.a;
        if (i4 != 0) {
            m6Var = m6Var2;
        }
        if (i2 == -2) {
            if (m6Var != m6Var2) {
                return new pa(1, m6Var);
            }
            x7.e.getClass();
            return new o6(w7.b);
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? m6Var == m6Var2 ? new o6(i2) : new pa(i2, m6Var) : new o6(Integer.MAX_VALUE) : m6Var == m6Var2 ? new o6(0) : new pa(1, m6Var);
        }
        if (m6Var == m6Var2) {
            return new pa(1, m6.b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static final zv b(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new zv(matcher, charSequence);
        }
        return null;
    }

    public static void c(StringBuilder sb, Object obj, fp fpVar) {
        if (fpVar != null) {
            sb.append((CharSequence) fpVar.g(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static final int d(int i2, int i3, int[] iArr) {
        pr.j("array", iArr);
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static final int e(long[] jArr, int i2, long j2) {
        pr.j("array", jArr);
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else {
                if (j3 <= j2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final void f(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    public static mm0 g(int i2) {
        return i2 != 0 ? i2 != 1 ? new y50() : new gd() : new y50();
    }

    public static SecretKey h() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("sensei_cache_v1", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(true).build());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        pr.i("generateKey(...)", secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    public static void i(String str) {
        pr.j("msg", str);
        String lowerCase = str.toLowerCase(Locale.ROOT);
        pr.i("toLowerCase(...)", lowerCase);
        if (fc0.e0(lowerCase, "locked", false) || fc0.e0(lowerCase, "admin", false) || fc0.e0(lowerCase, "server", false) || fc0.e0(lowerCase, "tweak", false) || fc0.e0(lowerCase, "auth failed", false) || fc0.e0(lowerCase, "authentication failed", false) || fc0.e0(lowerCase, "failed", false) || fc0.e0(lowerCase, "error", false) || fc0.e0(lowerCase, "connected", false) || fc0.e0(lowerCase, "disconnected", false) || fc0.e0(lowerCase, "reconnect", false)) {
            new Handler(Looper.getMainLooper()).post(new m70(str, 1));
        }
    }

    public static String j(Context context, String str) {
        try {
            SecretKey secretKeyP = p();
            if (secretKeyP == null) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeyP);
            byte[] bytes = str.getBytes(e8.a);
            pr.i("getBytes(...)", bytes);
            byte[] bArrDoFinal = cipher.doFinal(bytes);
            byte[] iv = cipher.getIV();
            if (iv.length != 12) {
                throw new IllegalArgumentException(("unexpected IV length " + iv.length).toString());
            }
            pr.f(bArrDoFinal);
            return "sek1:" + Base64.encodeToString(c5.b0(iv, bArrDoFinal), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final lc k(lc lcVar, lc lcVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        mc mcVar = mc.d;
        boolean zBooleanValue = ((Boolean) lcVar.d(bool, mcVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) lcVar2.d(bool, mcVar)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return lcVar.j(lcVar2);
        }
        mc mcVar2 = new mc(2, 6);
        oi oiVar = oi.a;
        lc lcVar3 = (lc) lcVar.d(oiVar, mcVar2);
        Object objD = lcVar2;
        if (zBooleanValue2) {
            objD = lcVar2.d(oiVar, mc.c);
        }
        return lcVar3.j((lc) objD);
    }

    public static final void l(BufferedReader bufferedReader, fp fpVar) throws IOException {
        try {
            Iterator it = new sa(new v9(2, bufferedReader)).iterator();
            while (it.hasNext()) {
                fpVar.g(it.next());
            }
            bufferedReader.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                mm0.l(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static int m(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }

    public static final String o(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static SecretKey p() {
        SecretKey secretKey;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                KeyStore.Entry entry = keyStore.getEntry("sensei_cache_v1", null);
                KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
                if (secretKeyEntry != null && (secretKey = secretKeyEntry.getSecretKey()) != null) {
                    return secretKey;
                }
                return h();
            } catch (Throwable unused) {
                return h();
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int q(float f2) {
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = c;
        return x9.a(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static boolean s(byte b2) {
        return b2 > -65;
    }

    public static float t(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r1.equals("direct_sni") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r1.equals("proxy_sni") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if (r1.equals("directsni") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        return sensei0.zz.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        if (r1.equals("proxysni") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
    
        return sensei0.zz.d;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sensei0.zz u(java.lang.String r1) {
        /*
            if (r1 == 0) goto Le
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            sensei0.pr.i(r0, r1)
            goto Lf
        Le:
            r1 = 0
        Lf:
            if (r1 == 0) goto L4f
            int r0 = r1.hashCode()
            switch(r0) {
                case -985156544: goto L43;
                case -962581275: goto L37;
                case -475672547: goto L2e;
                case 106941038: goto L22;
                case 224160792: goto L19;
                default: goto L18;
            }
        L18:
            goto L4f
        L19:
            java.lang.String r0 = "direct_sni"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L40
            goto L4f
        L22:
            java.lang.String r0 = "proxy"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L2b
            goto L4f
        L2b:
            sensei0.zz r1 = sensei0.zz.c
            return r1
        L2e:
            java.lang.String r0 = "proxy_sni"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4c
            goto L4f
        L37:
            java.lang.String r0 = "directsni"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L40
            goto L4f
        L40:
            sensei0.zz r1 = sensei0.zz.b
            return r1
        L43:
            java.lang.String r0 = "proxysni"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4c
            goto L4f
        L4c:
            sensei0.zz r1 = sensei0.zz.d
            return r1
        L4f:
            sensei0.zz r1 = sensei0.zz.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xe.u(java.lang.String):sensei0.zz");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sensei0.fo w(android.content.res.XmlResourceParser r25, android.content.res.Resources r26) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xe.w(android.content.res.XmlResourceParser, android.content.res.Resources):sensei0.fo");
    }

    public static final Object x(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static List y(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static ArrayList z(File file) throws IOException {
        Charset charset = e8.a;
        pr.j("charset", charset);
        ArrayList arrayList = new ArrayList();
        l(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), new f(1, arrayList));
        return arrayList;
    }

    public abstract void E(boolean z);

    public abstract void F(boolean z);

    public abstract void L();

    public abstract TransformationMethod S(TransformationMethod transformationMethod);

    public abstract InputFilter[] n(InputFilter[] inputFilterArr);

    public abstract boolean r();

    public abstract void v(int i2, int i3);
}
