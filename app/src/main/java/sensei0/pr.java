package sensei0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.icu.text.DecimalFormatSymbols;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ClientCertRequest;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pr {
    public static final tn a;
    public static final tn b;
    public static final tn c;
    public static final tn d;
    public static final tn e;
    public static final aa f = new aa(2);
    public static final aa g = new aa(0);
    public static final aa h = new aa(1);
    public static final s8 i = new s8("android.widget.ListView");
    public static final s8 j = new s8("android.widget.RadioGroup");
    public static final s8 k = new s8("android.view.MenuItem");
    public static final mh l = new mh(19);
    public static final hc m = new hc(5);

    static {
        int i2 = 4;
        a = new tn("RESUME_TOKEN", i2);
        b = new tn("UNDEFINED", i2);
        c = new tn("REUSABLE_CLAIMED", i2);
        d = new tn("CONDITION_FALSE", i2);
        e = new tn("NULL", i2);
    }

    public pr() {
        new ConcurrentHashMap();
    }

    public static v10 A(i4 i4Var) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new v10(tb.i(i4Var));
        }
        TextPaint textPaint = new TextPaint(i4Var.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = i4Var.getBreakStrategy();
        int hyphenationFrequency = i4Var.getHyphenationFrequency();
        if (i4Var.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i2 < 28 || (i4Var.getInputType() & 15) != 3) {
            boolean z = i4Var.getLayoutDirection() == 1;
            switch (i4Var.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(tb.a(DecimalFormatSymbols.getInstance(i4Var.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new v10(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static ArrayList B(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < materialToolbar.getChildCount(); i2++) {
            View childAt = materialToolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static final void C(Throwable th, lc lcVar) {
        Throwable runtimeException;
        Iterator it = qc.a.iterator();
        while (it.hasNext()) {
            try {
                ((r2) it.next()).e(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    wf0.a(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            wf0.a(th, new bg(lcVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static xb D(xb xbVar) {
        j("<this>", xbVar);
        yb ybVar = xbVar instanceof yb ? (yb) xbVar : null;
        if (ybVar == null || (xbVar = ybVar.c) != null) {
            return xbVar;
        }
        zb zbVar = (zb) ybVar.f().n(mh.c);
        xb hgVar = zbVar != null ? new hg((pc) zbVar, ybVar) : ybVar;
        ybVar.c = hgVar;
        return hgVar;
    }

    public static boolean E(Context context) {
        Bundle bundle;
        Context applicationContext = context.getApplicationContext();
        try {
            bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("ContentSizingFlag", "Could not get metadata", e2);
            bundle = null;
        }
        if (bundle != null) {
            return bundle.getBoolean("io.flutter.embedding.android.EnableContentSizing", false);
        }
        return false;
    }

    public static final boolean F(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static void G(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static byte[] J(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                throw new IllegalStateException(za0.h(i2, "Not enough bytes to read: "));
            }
            i3 += i4;
        }
        return bArr;
    }

    public static byte[] K(FileInputStream fileInputStream, int i2, int i3) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i2) {
                int i5 = fileInputStream.read(bArr2);
                if (i5 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i2 + " bytes");
                }
                inflater.setInput(bArr2, 0, i5);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i3 - iInflate);
                    i4 += i5;
                } catch (DataFormatException e2) {
                    throw new IllegalStateException(e2.getMessage());
                }
            }
            if (i4 == i2) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw new IllegalStateException("Inflater did not finish");
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i2 + " actual=" + i4);
        } finally {
            inflater.end();
        }
    }

    public static long L(InputStream inputStream, int i2) throws IOException {
        byte[] bArrJ = J(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += ((long) (bArrJ[i3] & 255)) << (i3 * 8);
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009a A[Catch: all -> 0x0079, DONT_GENERATE, TryCatch #2 {all -> 0x0079, blocks: (B:19:0x0054, B:21:0x0062, B:23:0x0068, B:36:0x009d, B:26:0x007b, B:28:0x0089, B:33:0x0094, B:35:0x009a, B:41:0x00aa, B:44:0x00b3, B:43:0x00b0, B:31:0x008f), top: B:57:0x0054, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void M(java.lang.Object r9, sensei0.xb r10) {
        /*
            boolean r0 = r10 instanceof sensei0.hg
            if (r0 == 0) goto Lbe
            sensei0.hg r10 = (sensei0.hg) r10
            sensei0.pc r0 = r10.d
            sensei0.yb r1 = r10.f
            java.lang.Throwable r2 = sensei0.v50.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            sensei0.ga r3 = new sensei0.ga
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            r1.f()
            boolean r2 = r0.f()
            r4 = 1
            if (r2 == 0) goto L2e
            r10.h = r3
            r10.c = r4
            sensei0.lc r9 = r1.f()
            r0.e(r9, r10)
            return
        L2e:
            sensei0.dj r0 = sensei0.ie0.a()
            long r5 = r0.c
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L50
            r10.h = r3
            r10.c = r4
            sensei0.r4 r9 = r0.f
            if (r9 != 0) goto L4c
            sensei0.r4 r9 = new sensei0.r4
            r9.<init>()
            r0.f = r9
        L4c:
            r9.addLast(r10)
            goto Lb8
        L50:
            r0.i(r4)
            r2 = 0
            sensei0.lc r5 = r1.f()     // Catch: java.lang.Throwable -> L79
            sensei0.mh r6 = sensei0.mh.p     // Catch: java.lang.Throwable -> L79
            sensei0.jc r5 = r5.n(r6)     // Catch: java.lang.Throwable -> L79
            sensei0.bs r5 = (sensei0.bs) r5     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L7b
            boolean r6 = r5.a()     // Catch: java.lang.Throwable -> L79
            if (r6 != 0) goto L7b
            sensei0.ls r5 = (sensei0.ls) r5     // Catch: java.lang.Throwable -> L79
            java.util.concurrent.CancellationException r9 = r5.z()     // Catch: java.lang.Throwable -> L79
            r10.b(r3, r9)     // Catch: java.lang.Throwable -> L79
            sensei0.u50 r9 = sensei0.wf0.i(r9)     // Catch: java.lang.Throwable -> L79
            r10.h(r9)     // Catch: java.lang.Throwable -> L79
            goto L9d
        L79:
            r9 = move-exception
            goto Lb4
        L7b:
            java.lang.Object r3 = r10.o     // Catch: java.lang.Throwable -> L79
            sensei0.lc r5 = r1.f()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r3 = sensei0.xe.P(r5, r3)     // Catch: java.lang.Throwable -> L79
            sensei0.tn r6 = sensei0.xe.v     // Catch: java.lang.Throwable -> L79
            if (r3 == r6) goto L8e
            sensei0.jg0 r6 = sensei0.xe.Q(r1, r5, r3)     // Catch: java.lang.Throwable -> L79
            goto L8f
        L8e:
            r6 = r2
        L8f:
            r1.h(r9)     // Catch: java.lang.Throwable -> La7
            if (r6 == 0) goto L9a
            boolean r9 = r6.W()     // Catch: java.lang.Throwable -> L79
            if (r9 == 0) goto L9d
        L9a:
            sensei0.xe.C(r5, r3)     // Catch: java.lang.Throwable -> L79
        L9d:
            boolean r9 = r0.l()     // Catch: java.lang.Throwable -> L79
            if (r9 != 0) goto L9d
        La3:
            r0.g(r4)
            goto Lb8
        La7:
            r9 = move-exception
            if (r6 == 0) goto Lb0
            boolean r1 = r6.W()     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto Lb3
        Lb0:
            sensei0.xe.C(r5, r3)     // Catch: java.lang.Throwable -> L79
        Lb3:
            throw r9     // Catch: java.lang.Throwable -> L79
        Lb4:
            r10.i(r9, r2)     // Catch: java.lang.Throwable -> Lb9
            goto La3
        Lb8:
            return
        Lb9:
            r9 = move-exception
            r0.g(r4)
            throw r9
        Lbe:
            r10.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pr.M(java.lang.Object, sensei0.xb):void");
    }

    public static void N(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
    }

    public static void O(TextView textView, int i2) {
        e(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            tb.j(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void P(TextView textView, int i2) {
        e(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void Q(TextView textView, int i2) {
        e(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void R(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.cancel", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.f00
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj2);
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c9Var2.getClass();
                                clientCertRequest.cancel();
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
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj3);
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c9Var3.getClass();
                                clientCertRequest2.ignore();
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj4);
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type java.security.PrivateKey", obj5);
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>", obj6);
                            List list2 = (List) obj6;
                            try {
                                c9Var4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
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
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.ignore", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.f00
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj2);
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c9Var2.getClass();
                                clientCertRequest.cancel();
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
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj3);
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c9Var3.getClass();
                                clientCertRequest2.ignore();
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj4);
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type java.security.PrivateKey", obj5);
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>", obj6);
                            List list2 = (List) obj6;
                            try {
                                c9Var4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
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
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.proceed", lxVar, null);
        if (c9Var == null) {
            j1Var3.l(null);
        } else {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.f00
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj2);
                            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
                            try {
                                c9Var2.getClass();
                                clientCertRequest.cancel();
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
                            Object obj3 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj3);
                            ClientCertRequest clientCertRequest2 = (ClientCertRequest) obj3;
                            try {
                                c9Var3.getClass();
                                clientCertRequest2.ignore();
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
                            pr.g("null cannot be cast to non-null type android.webkit.ClientCertRequest", obj4);
                            ClientCertRequest clientCertRequest3 = (ClientCertRequest) obj4;
                            Object obj5 = list.get(1);
                            pr.g("null cannot be cast to non-null type java.security.PrivateKey", obj5);
                            PrivateKey privateKey = (PrivateKey) obj5;
                            Object obj6 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>", obj6);
                            List list2 = (List) obj6;
                            try {
                                c9Var4.getClass();
                                clientCertRequest3.proceed(privateKey, (X509Certificate[]) list2.toArray(new X509Certificate[0]));
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

    public static void S(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getCName", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.l00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj2);
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(dName.getCName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj3);
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(dName2.getDName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj4);
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(dName3.getOName());
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
                        default:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj5);
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c9Var5.getClass();
                                listF04 = k6.G(dName4.getUName());
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
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getDName", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.l00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj2);
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(dName.getCName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj3);
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(dName2.getDName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj4);
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(dName3.getOName());
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
                        default:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj5);
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c9Var5.getClass();
                                listF04 = k6.G(dName4.getUName());
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
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getOName", lxVar, null);
        if (c9Var != null) {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.l00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj2);
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(dName.getCName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj3);
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(dName2.getDName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj4);
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(dName3.getOName());
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
                        default:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj5);
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c9Var5.getClass();
                                listF04 = k6.G(dName4.getUName());
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
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.getUName", lxVar, null);
        if (c9Var == null) {
            j1Var4.l(null);
        } else {
            final int i5 = 3;
            j1Var4.l(new u5() { // from class: sensei0.l00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj2);
                            SslCertificate.DName dName = (SslCertificate.DName) obj2;
                            try {
                                c9Var2.getClass();
                                listF0 = k6.G(dName.getCName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj3);
                            SslCertificate.DName dName2 = (SslCertificate.DName) obj3;
                            try {
                                c9Var3.getClass();
                                listF02 = k6.G(dName2.getDName());
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
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj4);
                            SslCertificate.DName dName3 = (SslCertificate.DName) obj4;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(dName3.getOName());
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
                        default:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj5 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.net.http.SslCertificate.DName", obj5);
                            SslCertificate.DName dName4 = (SslCertificate.DName) obj5;
                            try {
                                c9Var5.getClass();
                                listF04 = k6.G(dName4.getUName());
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
                    }
                }
            });
        }
    }

    public static final long T(String str, long j2, long j3, long j4) {
        String property;
        int i2 = ed0.a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lY = mc0.Y(property);
        if (lY == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lY.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int U(int i2, String str, int i3) {
        return (int) T(str, i2, 1, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static void V(String str) {
        ia iaVar = new ia(za0.l("lateinit property ", str, " has not been initialized"));
        N(iaVar, pr.class.getName());
        throw iaVar;
    }

    public static ActionMode.Callback W(ActionMode.Callback callback) {
        return (!(callback instanceof ae0) || Build.VERSION.SDK_INT < 26) ? callback : ((ae0) callback).a;
    }

    public static ActionMode.Callback X(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof ae0) || callback == null) ? callback : new ae0(callback, textView);
    }

    public static Object Y(jp jpVar, Object obj, xb xbVar) {
        Object rrVar;
        j("<this>", jpVar);
        lc lcVarF = xbVar.f();
        if (lcVarF == oi.a) {
            rrVar = new qr(xbVar);
            if (xbVar.f() != oi.a) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
            }
        } else {
            rrVar = new rr(xbVar, lcVarF);
        }
        wf0.c(2, jpVar);
        return jpVar.c(obj, rrVar);
    }

    public static void Z(ByteArrayOutputStream byteArrayOutputStream, long j2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((j2 >> (i3 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static final List a(Throwable th) {
        return p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
    }

    public static void a0(ByteArrayOutputStream byteArrayOutputStream, int i2) throws IOException {
        Z(byteArrayOutputStream, i2, 2);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static ArrayList b0(DisplayManager displayManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new ArrayList();
        }
        try {
            Field declaredField = DisplayManager.class.getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(displayManager);
            Field declaredField2 = obj.getClass().getDeclaredField("mDisplayListeners");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(obj);
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            Field field = null;
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                if (field == null) {
                    field = obj2.getClass().getField("mListener");
                    field.setAccessible(true);
                }
                arrayList2.add((DisplayManager.DisplayListener) field.get(obj2));
            }
            return arrayList2;
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            Log.w("DisplayListenerProxy", "Could not extract WebView's display listeners. " + e2);
            return new ArrayList();
        }
    }

    public static void d(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void e(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void f(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        N(nullPointerException, pr.class.getName());
        throw nullPointerException;
    }

    public static void g(String str, Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        N(nullPointerException, pr.class.getName());
        throw nullPointerException;
    }

    public static void h(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void i(String str, Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        N(nullPointerException, pr.class.getName());
        throw nullPointerException;
    }

    public static void j(String str, Object obj) {
        if (obj == null) {
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
            N(nullPointerException, pr.class.getName());
            throw nullPointerException;
        }
    }

    public static void k(int i2) {
        if (2 > i2 || i2 >= 37) {
            throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new kr(2, 36, 1));
        }
    }

    public static int l(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static byte[] m(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static boolean t(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = t(file2) && z;
        }
        return z;
    }

    public static final boolean v(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object x(sensei0.gl r4, sensei0.yb r5) {
        /*
            boolean r0 = r5 instanceof sensei0.sl
            if (r0 == 0) goto L13
            r0 = r5
            sensei0.sl r0 = (sensei0.sl) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            sensei0.sl r0 = new sensei0.sl
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.h
            int r1 = r0.o
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            sensei0.z6 r4 = r0.f
            sensei0.x40 r0 = r0.d
            sensei0.wf0.H(r5)     // Catch: sensei0.a -> L29
            goto L5a
        L29:
            r5 = move-exception
            goto L56
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            sensei0.wf0.H(r5)
            sensei0.x40 r5 = new sensei0.x40
            r5.<init>()
            sensei0.z6 r1 = new sensei0.z6
            r3 = 2
            r1.<init>(r3, r5)
            r0.d = r5     // Catch: sensei0.a -> L52
            r0.f = r1     // Catch: sensei0.a -> L52
            r0.o = r2     // Catch: sensei0.a -> L52
            java.lang.Object r4 = r4.e(r1, r0)     // Catch: sensei0.a -> L52
            sensei0.vc r0 = sensei0.vc.a
            if (r4 != r0) goto L50
            return r0
        L50:
            r0 = r5
            goto L5a
        L52:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r1
        L56:
            java.lang.Object r1 = r5.a
            if (r1 != r4) goto L5d
        L5a:
            java.lang.Object r4 = r0.a
            return r4
        L5d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pr.x(sensei0.gl, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sensei0.gl y(sensei0.y6 r4, sensei0.jq r5, int r6, sensei0.m6 r7, int r8) {
        /*
            r0 = r8 & 1
            if (r0 == 0) goto L6
            sensei0.oi r5 = sensei0.oi.a
        L6:
            r0 = r8 & 2
            r1 = -3
            if (r0 == 0) goto Lc
            r6 = r1
        Lc:
            r8 = r8 & 4
            sensei0.m6 r0 = sensei0.m6.a
            if (r8 == 0) goto L13
            r7 = r0
        L13:
            sensei0.m6 r8 = r4.c
            int r2 = r4.b
            sensei0.lc r3 = r4.a
            sensei0.lc r5 = r5.j(r3)
            if (r7 == r0) goto L20
            goto L36
        L20:
            if (r2 != r1) goto L23
            goto L35
        L23:
            if (r6 != r1) goto L27
        L25:
            r6 = r2
            goto L35
        L27:
            r7 = -2
            if (r2 != r7) goto L2b
            goto L35
        L2b:
            if (r6 != r7) goto L2e
            goto L25
        L2e:
            int r6 = r6 + r2
            if (r6 < 0) goto L32
            goto L35
        L32:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L35:
            r7 = r8
        L36:
            boolean r0 = b(r5, r3)
            if (r0 == 0) goto L41
            if (r6 != r2) goto L41
            if (r7 != r8) goto L41
            return r4
        L41:
            sensei0.y6 r8 = new sensei0.y6
            sensei0.y7 r4 = r4.f
            r8.<init>(r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pr.y(sensei0.y6, sensei0.jq, int, sensei0.m6, int):sensei0.gl");
    }

    public static final f7 z(xb xbVar) {
        f7 f7Var;
        f7 f7Var2;
        if (!(xbVar instanceof hg)) {
            return new f7(1, xbVar);
        }
        hg hgVar = (hg) xbVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = hg.p;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(hgVar);
            f7Var = null;
            tn tnVar = c;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hgVar, tnVar);
                f7Var2 = null;
                break;
            }
            if (obj instanceof f7) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hgVar, obj, tnVar)) {
                    if (atomicReferenceFieldUpdater.get(hgVar) != obj) {
                        break;
                    }
                }
                f7Var2 = (f7) obj;
                break loop0;
            }
            if (obj != tnVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (f7Var2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f7.o;
            Object obj2 = atomicReferenceFieldUpdater2.get(f7Var2);
            if (!(obj2 instanceof ea) || ((ea) obj2).d == null) {
                f7.h.set(f7Var2, 536870911);
                atomicReferenceFieldUpdater2.set(f7Var2, k2.a);
                f7Var = f7Var2;
            } else {
                f7Var2.q();
            }
            if (f7Var != null) {
                return f7Var;
            }
        }
        return new f7(2, xbVar);
    }

    public abstract void H(int i2);

    public abstract void I(Typeface typeface);

    public void c(int i2) {
        new Handler(Looper.getMainLooper()).post(new jv(this, i2, 3));
    }

    public abstract Typeface n(Context context, go goVar, Resources resources, int i2);

    public abstract Typeface o(Context context, jo[] joVarArr, int i2);

    public Typeface p(Context context, List list, int i2) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface q(Context context, InputStream inputStream) {
        File fileN = wf0.n(context);
        if (fileN == null) {
            return null;
        }
        try {
            if (wf0.h(fileN, inputStream)) {
                return Typeface.createFromFile(fileN.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileN.delete();
        }
    }

    public Typeface r(Context context, Resources resources, int i2, String str, int i3) {
        File fileN = wf0.n(context);
        if (fileN == null) {
            return null;
        }
        try {
            if (wf0.g(fileN, resources, i2)) {
                return Typeface.createFromFile(fileN.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileN.delete();
        }
    }

    public abstract String s(int i2, int i3, byte[] bArr);

    public abstract int u(String str, byte[] bArr, int i2, int i3);

    public jo w(jo[] joVarArr, int i2) {
        new mz(20);
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        jo joVar = null;
        int i4 = Integer.MAX_VALUE;
        for (jo joVar2 : joVarArr) {
            int iAbs = (Math.abs(joVar2.c - i3) * 2) + (joVar2.d == z ? 0 : 1);
            if (joVar == null || i4 > iAbs) {
                joVar = joVar2;
                i4 = iAbs;
            }
        }
        return joVar;
    }
}
