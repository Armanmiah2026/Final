package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.EdgeEffect;
import io.flutter.plugins.GeneratedPluginRegistrant;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wf0 {
    public static final c8 a = new c8();
    public static final String[] b = {"standard", "accelerate", "decelerate", "linear"};
    public static final Object c = new Object();
    public static final boolean[] d = new boolean[3];
    public static final Object e = new Object();

    public static Set A(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return si.a;
        }
        if (length == 1) {
            Set setSingleton = Collections.singleton(objArr[0]);
            pr.i("singleton(...)", setSingleton);
            return setSingleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(xv.c0(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static void B(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            xe0.a(view, charSequence);
            return;
        }
        ze0 ze0Var = ze0.s;
        if (ze0Var != null && ze0Var.a == view) {
            ze0.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new ze0(view, charSequence);
            return;
        }
        ze0 ze0Var2 = ze0.t;
        if (ze0Var2 != null && ze0Var2.a == view) {
            ze0Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void C(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CookieManager.instance", lxVar, null);
        if (c9Var != null) {
            final int i = 0;
            j1Var.l(new u5() { // from class: sensei0.g00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj3);
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str2 = (String) obj5;
                            try {
                                c9Var3.getClass();
                                cookieManager.setCookie(str, str2);
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
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj6);
                            int i2 = 0;
                            h00 h00Var = new h00(i3Var, i2);
                            c9Var.getClass();
                            ((CookieManager) obj6).removeAllCookies(new ac(h00Var, i2));
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj7);
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj8);
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj9);
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c9Var4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, zBooleanValue);
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
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setCookie", lxVar, null);
        if (c9Var != null) {
            final int i2 = 1;
            j1Var2.l(new u5() { // from class: sensei0.g00
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
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj3);
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str2 = (String) obj5;
                            try {
                                c9Var3.getClass();
                                cookieManager.setCookie(str, str2);
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
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj6);
                            int i22 = 0;
                            h00 h00Var = new h00(i3Var, i22);
                            c9Var.getClass();
                            ((CookieManager) obj6).removeAllCookies(new ac(h00Var, i22));
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj7);
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj8);
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj9);
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c9Var4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, zBooleanValue);
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
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CookieManager.removeAllCookies", lxVar, null);
        if (c9Var != null) {
            final int i3 = 2;
            j1Var3.l(new u5() { // from class: sensei0.g00
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
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj3);
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str2 = (String) obj5;
                            try {
                                c9Var3.getClass();
                                cookieManager.setCookie(str, str2);
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
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj6);
                            int i22 = 0;
                            h00 h00Var = new h00(i3Var, i22);
                            c9Var.getClass();
                            ((CookieManager) obj6).removeAllCookies(new ac(h00Var, i22));
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj7);
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj8);
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj9);
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c9Var4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, zBooleanValue);
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
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setAcceptThirdPartyCookies", lxVar, null);
        if (c9Var == null) {
            j1Var4.l(null);
        } else {
            final int i4 = 3;
            j1Var4.l(new u5() { // from class: sensei0.g00
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
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), CookieManager.getInstance());
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
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj3);
                            CookieManager cookieManager = (CookieManager) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            Object obj5 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str2 = (String) obj5;
                            try {
                                c9Var3.getClass();
                                cookieManager.setCookie(str, str2);
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
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj6 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj6);
                            int i22 = 0;
                            h00 h00Var = new h00(i3Var, i22);
                            c9Var.getClass();
                            ((CookieManager) obj6).removeAllCookies(new ac(h00Var, i22));
                            break;
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj7 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.webkit.CookieManager", obj7);
                            CookieManager cookieManager2 = (CookieManager) obj7;
                            Object obj8 = list2.get(1);
                            pr.g("null cannot be cast to non-null type android.webkit.WebView", obj8);
                            WebView webView = (WebView) obj8;
                            Object obj9 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj9);
                            boolean zBooleanValue = ((Boolean) obj9).booleanValue();
                            try {
                                c9Var4.getClass();
                                cookieManager2.setAcceptThirdPartyCookies(webView, zBooleanValue);
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

    public static void D(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.scrollTo", lxVar, null);
        if (c9Var != null) {
            final int i = 0;
            j1Var.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.scrollBy", lxVar, null);
        if (c9Var != null) {
            final int i2 = 1;
            j1Var2.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.getScrollPosition", lxVar, null);
        if (c9Var != null) {
            final int i3 = 2;
            j1Var3.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.setVerticalScrollBarEnabled", lxVar, null);
        if (c9Var != null) {
            final int i4 = 3;
            j1Var4.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.setHorizontalScrollBarEnabled", lxVar, null);
        if (c9Var != null) {
            final int i5 = 4;
            j1Var5.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.setOverScrollMode", lxVar, null);
        if (c9Var == null) {
            j1Var6.l(null);
        } else {
            final int i6 = 5;
            j1Var6.l(new u5() { // from class: sensei0.n00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i6) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj2);
                            View view = (View) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj4);
                            long jLongValue2 = ((Long) obj4).longValue();
                            try {
                                c9Var2.getClass();
                                view.scrollTo((int) jLongValue, (int) jLongValue2);
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
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj5);
                            View view2 = (View) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj6);
                            long jLongValue3 = ((Long) obj6).longValue();
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                            long jLongValue4 = ((Long) obj7).longValue();
                            try {
                                c9Var3.getClass();
                                view2.scrollBy((int) jLongValue3, (int) jLongValue4);
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
                            return;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj8 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj8);
                            View view3 = (View) obj8;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(new kk0(view3.getScrollX(), view3.getScrollY()));
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
                            return;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj9 = list3.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj9);
                            View view4 = (View) obj9;
                            Object obj10 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var5.getClass();
                                view4.setVerticalScrollBarEnabled(zBooleanValue);
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
                            return;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj11);
                            View view5 = (View) obj11;
                            Object obj12 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue2 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var6.getClass();
                                view5.setHorizontalScrollBarEnabled(zBooleanValue2);
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
                            return;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            pr.g("null cannot be cast to non-null type android.view.View", obj13);
                            View view6 = (View) obj13;
                            Object obj14 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode", obj14);
                            nz nzVar = (nz) obj14;
                            try {
                                c9Var7.getClass();
                                int iOrdinal = nzVar.ordinal();
                                if (iOrdinal == 0) {
                                    view6.setOverScrollMode(0);
                                } else if (iOrdinal == 1) {
                                    view6.setOverScrollMode(1);
                                } else if (iOrdinal == 2) {
                                    view6.setOverScrollMode(2);
                                } else if (iOrdinal == 3) {
                                    g30 g30Var2 = c9Var7.a;
                                    nz nzVar2 = nz.c;
                                    g30Var2.getClass();
                                    throw new IllegalArgumentException(nzVar2 + " doesn't represent a native value.");
                                }
                                listF06 = k6.G(null);
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            return;
                    }
                }
            });
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String E(String str) {
        int iHashCode = str.hashCode();
        switch (iHashCode) {
            case -2061550653:
                if (str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -2056817302:
                if (str.equals("java.lang.Integer")) {
                    return "Int";
                }
                return null;
            case -2034166429:
                if (str.equals("java.lang.Cloneable")) {
                    return "Cloneable";
                }
                return null;
            case -1979556166:
                if (str.equals("java.lang.annotation.Annotation")) {
                    return "Annotation";
                }
                return null;
            case -1571515090:
                if (str.equals("java.lang.Comparable")) {
                    return "Comparable";
                }
                return null;
            case -1383349348:
                if (str.equals("java.util.Map")) {
                    return "Map";
                }
                return null;
            case -1383343454:
                if (str.equals("java.util.Set")) {
                    return "Set";
                }
                return null;
            case -1325958191:
                if (str.equals("double")) {
                    return "Double";
                }
                return null;
            case -1182275604:
                if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -1062240117:
                if (str.equals("java.lang.CharSequence")) {
                    return "CharSequence";
                }
                return null;
            case -688322466:
                if (str.equals("java.util.Collection")) {
                    return "Collection";
                }
                return null;
            case -527879800:
                if (str.equals("java.lang.Float")) {
                    return "Float";
                }
                return null;
            case -515992664:
                if (str.equals("java.lang.Short")) {
                    return "Short";
                }
                return null;
            case -246476834:
                if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -207262728:
                if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -165139126:
                if (str.equals("java.util.Map$Entry")) {
                    return "Entry";
                }
                return null;
            case 104431:
                if (str.equals("int")) {
                    return "Int";
                }
                return null;
            case 3039496:
                if (str.equals("byte")) {
                    return "Byte";
                }
                return null;
            case 3052374:
                if (str.equals("char")) {
                    return "Char";
                }
                return null;
            case 3327612:
                if (str.equals("long")) {
                    return "Long";
                }
                return null;
            case 64711720:
                if (str.equals("boolean")) {
                    return "Boolean";
                }
                return null;
            case 65821278:
                if (str.equals("java.util.List")) {
                    return "List";
                }
                return null;
            case 77230534:
                if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 97526364:
                if (str.equals("float")) {
                    return "Float";
                }
                return null;
            case 109413500:
                if (str.equals("short")) {
                    return "Short";
                }
                return null;
            case 155276373:
                if (str.equals("java.lang.Character")) {
                    return "Char";
                }
                return null;
            case 226173651:
                if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    return "Boolean";
                }
                return null;
            case 398507100:
                if (str.equals("java.lang.Byte")) {
                    return "Byte";
                }
                return null;
            case 398585941:
                if (str.equals("java.lang.Enum")) {
                    return "Enum";
                }
                return null;
            case 398795216:
                if (str.equals("java.lang.Long")) {
                    return "Long";
                }
                return null;
            case 482629606:
                if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 499831342:
                if (str.equals("java.util.Iterator")) {
                    return "Iterator";
                }
                return null;
            case 577341676:
                if (str.equals("java.util.ListIterator")) {
                    return "ListIterator";
                }
                return null;
            case 599019395:
                if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 761287205:
                if (str.equals("java.lang.Double")) {
                    return "Double";
                }
                return null;
            case 1052881309:
                if (str.equals("java.lang.Number")) {
                    return "Number";
                }
                return null;
            case 1063877011:
                if (str.equals("java.lang.Object")) {
                    return "Any";
                }
                return null;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    return "String";
                }
                return null;
            case 1275614662:
                if (str.equals("java.lang.Iterable")) {
                    return "Iterable";
                }
                return null;
            case 1383693018:
                if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 1630335596:
                if (str.equals("java.lang.Throwable")) {
                    return "Throwable";
                }
                return null;
            case 1877171123:
                if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "Companion";
                }
                return null;
            default:
                switch (iHashCode) {
                    case -1811142716:
                        if (str.equals("kotlin.jvm.functions.Function10")) {
                            return "Function10";
                        }
                        return null;
                    case -1811142715:
                        if (str.equals("kotlin.jvm.functions.Function11")) {
                            return "Function11";
                        }
                        return null;
                    case -1811142714:
                        if (str.equals("kotlin.jvm.functions.Function12")) {
                            return "Function12";
                        }
                        return null;
                    case -1811142713:
                        if (str.equals("kotlin.jvm.functions.Function13")) {
                            return "Function13";
                        }
                        return null;
                    case -1811142712:
                        if (str.equals("kotlin.jvm.functions.Function14")) {
                            return "Function14";
                        }
                        return null;
                    case -1811142711:
                        if (str.equals("kotlin.jvm.functions.Function15")) {
                            return "Function15";
                        }
                        return null;
                    case -1811142710:
                        if (str.equals("kotlin.jvm.functions.Function16")) {
                            return "Function16";
                        }
                        return null;
                    case -1811142709:
                        if (str.equals("kotlin.jvm.functions.Function17")) {
                            return "Function17";
                        }
                        return null;
                    case -1811142708:
                        if (str.equals("kotlin.jvm.functions.Function18")) {
                            return "Function18";
                        }
                        return null;
                    case -1811142707:
                        if (str.equals("kotlin.jvm.functions.Function19")) {
                            return "Function19";
                        }
                        return null;
                    default:
                        switch (iHashCode) {
                            case -1811142685:
                                if (str.equals("kotlin.jvm.functions.Function20")) {
                                    return "Function20";
                                }
                                return null;
                            case -1811142684:
                                if (str.equals("kotlin.jvm.functions.Function21")) {
                                    return "Function21";
                                }
                                return null;
                            case -1811142683:
                                if (str.equals("kotlin.jvm.functions.Function22")) {
                                    return "Function22";
                                }
                                return null;
                            default:
                                switch (iHashCode) {
                                    case 80123371:
                                        if (str.equals("kotlin.jvm.functions.Function0")) {
                                            return "Function0";
                                        }
                                        return null;
                                    case 80123372:
                                        if (str.equals("kotlin.jvm.functions.Function1")) {
                                            return "Function1";
                                        }
                                        return null;
                                    case 80123373:
                                        if (str.equals("kotlin.jvm.functions.Function2")) {
                                            return "Function2";
                                        }
                                        return null;
                                    case 80123374:
                                        if (str.equals("kotlin.jvm.functions.Function3")) {
                                            return "Function3";
                                        }
                                        return null;
                                    case 80123375:
                                        if (str.equals("kotlin.jvm.functions.Function4")) {
                                            return "Function4";
                                        }
                                        return null;
                                    case 80123376:
                                        if (str.equals("kotlin.jvm.functions.Function5")) {
                                            return "Function5";
                                        }
                                        return null;
                                    case 80123377:
                                        if (str.equals("kotlin.jvm.functions.Function6")) {
                                            return "Function6";
                                        }
                                        return null;
                                    case 80123378:
                                        if (str.equals("kotlin.jvm.functions.Function7")) {
                                            return "Function7";
                                        }
                                        return null;
                                    case 80123379:
                                        if (str.equals("kotlin.jvm.functions.Function8")) {
                                            return "Function8";
                                        }
                                        return null;
                                    case 80123380:
                                        if (str.equals("kotlin.jvm.functions.Function9")) {
                                            return "Function9";
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void F(jp jpVar, g gVar, g gVar2) {
        try {
            pr.M(mg0.a, pr.D(((l5) jpVar).j(gVar, gVar2)));
        } catch (Throwable th) {
            gVar2.h(i(th));
            throw th;
        }
    }

    public static void G(String str, Object obj) {
        ClassCastException classCastException = new ClassCastException((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        pr.N(classCastException, wf0.class.getName());
        throw classCastException;
    }

    public static final void H(Object obj) {
        if (obj instanceof u50) {
            throw ((u50) obj).a;
        }
    }

    public static final Object I(lc lcVar, jp jpVar, yb ybVar) throws Throwable {
        lc lcVarF = ybVar.f();
        lc lcVarJ = !((Boolean) lcVar.d(Boolean.FALSE, mc.d)).booleanValue() ? lcVarF.j(lcVar) : xe.k(lcVarF, lcVar, false);
        bs bsVar = (bs) lcVarJ.n(mh.p);
        if (bsVar != null && !bsVar.a()) {
            throw ((ls) bsVar).z();
        }
        if (lcVarJ == lcVarF) {
            x60 x60Var = new x60(ybVar, lcVarJ);
            return k6.V(x60Var, x60Var, jpVar);
        }
        mh mhVar = mh.c;
        if (pr.b(lcVarJ.n(mhVar), lcVarF.n(mhVar))) {
            jg0 jg0Var = new jg0(ybVar, lcVarJ);
            lc lcVar2 = jg0Var.c;
            Object objP = xe.P(lcVar2, null);
            try {
                return k6.V(jg0Var, jg0Var, jpVar);
            } finally {
                xe.C(lcVar2, objP);
            }
        }
        ig igVar = new ig(ybVar, lcVarJ);
        F(jpVar, igVar, igVar);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ig.f;
        do {
            int i = atomicIntegerFieldUpdater.get(igVar);
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objO = xe.O(igVar.D());
                if (objO instanceof ga) {
                    throw ((ga) objO).a;
                }
                return objO;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(igVar, 0, 1));
        return vc.a;
    }

    public static Object J(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(J(it.next()));
            }
            return jSONArray;
        }
        if (obj.getClass().isArray()) {
            JSONArray jSONArray2 = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray2.put(J(Array.get(obj, i)));
            }
            return jSONArray2;
        }
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONObject.put((String) entry.getKey(), J(entry.getValue()));
            }
            return jSONObject;
        }
        if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
            return obj;
        }
        if (obj.getClass().getPackage().getName().startsWith("java.")) {
            return obj.toString();
        }
        return null;
    }

    public static void a(Throwable th, Throwable th2) {
        pr.j("<this>", th);
        pr.j("exception", th2);
        if (th != th2) {
            Integer num = wr.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = x00.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(sensei0.s20 r4, sensei0.y10 r5, sensei0.yb r6) {
        /*
            boolean r0 = r6 instanceof sensei0.q20
            if (r0 == 0) goto L13
            r0 = r6
            sensei0.q20 r0 = (sensei0.q20) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            sensei0.q20 r0 = new sensei0.q20
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f
            int r1 = r0.h
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            sensei0.y10 r5 = r0.d
            H(r6)     // Catch: java.lang.Throwable -> L27
            goto L65
        L27:
            r4 = move-exception
            goto L6b
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            H(r6)
            sensei0.lc r6 = r0.b
            sensei0.pr.f(r6)
            sensei0.mh r1 = sensei0.mh.p
            sensei0.jc r6 = r6.n(r1)
            if (r6 != r4) goto L6f
            r0.d = r5     // Catch: java.lang.Throwable -> L27
            r0.h = r2     // Catch: java.lang.Throwable -> L27
            sensei0.f7 r6 = new sensei0.f7     // Catch: java.lang.Throwable -> L27
            sensei0.xb r0 = sensei0.pr.D(r0)     // Catch: java.lang.Throwable -> L27
            r6.<init>(r2, r0)     // Catch: java.lang.Throwable -> L27
            r6.u()     // Catch: java.lang.Throwable -> L27
            sensei0.se r0 = new sensei0.se     // Catch: java.lang.Throwable -> L27
            r1 = 1
            r0.<init>(r1, r6)     // Catch: java.lang.Throwable -> L27
            sensei0.r20 r4 = (sensei0.r20) r4     // Catch: java.lang.Throwable -> L27
            r4.W(r0)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r6.t()     // Catch: java.lang.Throwable -> L27
            sensei0.vc r6 = sensei0.vc.a
            if (r4 != r6) goto L65
            return r6
        L65:
            r5.a()
            sensei0.mg0 r4 = sensei0.mg0.a
            return r4
        L6b:
            r5.a()
            throw r4
        L6f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.wf0.b(sensei0.s20, sensei0.y10, sensei0.yb):java.lang.Object");
    }

    public static void c(int i, Object obj) {
        if (obj == null || p(i, obj)) {
            return;
        }
        G("kotlin.jvm.functions.Function" + i, obj);
        throw null;
    }

    public static void d(int i, int i2, int i3) {
        if (i >= 0 && i2 <= i3) {
            if (i > i2) {
                throw new IllegalArgumentException(za0.j("fromIndex: ", i, " > toIndex: ", i2));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String e(String str) {
        int iHashCode = str.hashCode();
        switch (iHashCode) {
            case -2061550653:
                if (str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "kotlin.Double.Companion";
                }
                return null;
            case -2056817302:
                if (str.equals("java.lang.Integer")) {
                    return "kotlin.Int";
                }
                return null;
            case -2034166429:
                if (str.equals("java.lang.Cloneable")) {
                    return "kotlin.Cloneable";
                }
                return null;
            case -1979556166:
                if (str.equals("java.lang.annotation.Annotation")) {
                    return "kotlin.Annotation";
                }
                return null;
            case -1571515090:
                if (str.equals("java.lang.Comparable")) {
                    return "kotlin.Comparable";
                }
                return null;
            case -1383349348:
                if (str.equals("java.util.Map")) {
                    return "kotlin.collections.Map";
                }
                return null;
            case -1383343454:
                if (str.equals("java.util.Set")) {
                    return "kotlin.collections.Set";
                }
                return null;
            case -1325958191:
                if (str.equals("double")) {
                    return "kotlin.Double";
                }
                return null;
            case -1182275604:
                if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "kotlin.Byte.Companion";
                }
                return null;
            case -1062240117:
                if (str.equals("java.lang.CharSequence")) {
                    return "kotlin.CharSequence";
                }
                return null;
            case -688322466:
                if (str.equals("java.util.Collection")) {
                    return "kotlin.collections.Collection";
                }
                return null;
            case -527879800:
                if (str.equals("java.lang.Float")) {
                    return "kotlin.Float";
                }
                return null;
            case -515992664:
                if (str.equals("java.lang.Short")) {
                    return "kotlin.Short";
                }
                return null;
            case -246476834:
                if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "kotlin.Char.Companion";
                }
                return null;
            case -207262728:
                if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "kotlin.Long.Companion";
                }
                return null;
            case -165139126:
                if (str.equals("java.util.Map$Entry")) {
                    return "kotlin.collections.Map.Entry";
                }
                return null;
            case 104431:
                if (str.equals("int")) {
                    return "kotlin.Int";
                }
                return null;
            case 3039496:
                if (str.equals("byte")) {
                    return "kotlin.Byte";
                }
                return null;
            case 3052374:
                if (str.equals("char")) {
                    return "kotlin.Char";
                }
                return null;
            case 3327612:
                if (str.equals("long")) {
                    return "kotlin.Long";
                }
                return null;
            case 64711720:
                if (str.equals("boolean")) {
                    return "kotlin.Boolean";
                }
                return null;
            case 65821278:
                if (str.equals("java.util.List")) {
                    return "kotlin.collections.List";
                }
                return null;
            case 77230534:
                if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "kotlin.Short.Companion";
                }
                return null;
            case 97526364:
                if (str.equals("float")) {
                    return "kotlin.Float";
                }
                return null;
            case 109413500:
                if (str.equals("short")) {
                    return "kotlin.Short";
                }
                return null;
            case 155276373:
                if (str.equals("java.lang.Character")) {
                    return "kotlin.Char";
                }
                return null;
            case 226173651:
                if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "kotlin.Enum.Companion";
                }
                return null;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    return "kotlin.Boolean";
                }
                return null;
            case 398507100:
                if (str.equals("java.lang.Byte")) {
                    return "kotlin.Byte";
                }
                return null;
            case 398585941:
                if (str.equals("java.lang.Enum")) {
                    return "kotlin.Enum";
                }
                return null;
            case 398795216:
                if (str.equals("java.lang.Long")) {
                    return "kotlin.Long";
                }
                return null;
            case 482629606:
                if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "kotlin.Float.Companion";
                }
                return null;
            case 499831342:
                if (str.equals("java.util.Iterator")) {
                    return "kotlin.collections.Iterator";
                }
                return null;
            case 577341676:
                if (str.equals("java.util.ListIterator")) {
                    return "kotlin.collections.ListIterator";
                }
                return null;
            case 599019395:
                if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "kotlin.String.Companion";
                }
                return null;
            case 761287205:
                if (str.equals("java.lang.Double")) {
                    return "kotlin.Double";
                }
                return null;
            case 1052881309:
                if (str.equals("java.lang.Number")) {
                    return "kotlin.Number";
                }
                return null;
            case 1063877011:
                if (str.equals("java.lang.Object")) {
                    return "kotlin.Any";
                }
                return null;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    return "kotlin.String";
                }
                return null;
            case 1275614662:
                if (str.equals("java.lang.Iterable")) {
                    return "kotlin.collections.Iterable";
                }
                return null;
            case 1383693018:
                if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "kotlin.Boolean.Companion";
                }
                return null;
            case 1630335596:
                if (str.equals("java.lang.Throwable")) {
                    return "kotlin.Throwable";
                }
                return null;
            case 1877171123:
                if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "kotlin.Int.Companion";
                }
                return null;
            default:
                switch (iHashCode) {
                    case -1811142716:
                        if (str.equals("kotlin.jvm.functions.Function10")) {
                            return "kotlin.Function10";
                        }
                        return null;
                    case -1811142715:
                        if (str.equals("kotlin.jvm.functions.Function11")) {
                            return "kotlin.Function11";
                        }
                        return null;
                    case -1811142714:
                        if (str.equals("kotlin.jvm.functions.Function12")) {
                            return "kotlin.Function12";
                        }
                        return null;
                    case -1811142713:
                        if (str.equals("kotlin.jvm.functions.Function13")) {
                            return "kotlin.Function13";
                        }
                        return null;
                    case -1811142712:
                        if (str.equals("kotlin.jvm.functions.Function14")) {
                            return "kotlin.Function14";
                        }
                        return null;
                    case -1811142711:
                        if (str.equals("kotlin.jvm.functions.Function15")) {
                            return "kotlin.Function15";
                        }
                        return null;
                    case -1811142710:
                        if (str.equals("kotlin.jvm.functions.Function16")) {
                            return "kotlin.Function16";
                        }
                        return null;
                    case -1811142709:
                        if (str.equals("kotlin.jvm.functions.Function17")) {
                            return "kotlin.Function17";
                        }
                        return null;
                    case -1811142708:
                        if (str.equals("kotlin.jvm.functions.Function18")) {
                            return "kotlin.Function18";
                        }
                        return null;
                    case -1811142707:
                        if (str.equals("kotlin.jvm.functions.Function19")) {
                            return "kotlin.Function19";
                        }
                        return null;
                    default:
                        switch (iHashCode) {
                            case -1811142685:
                                if (str.equals("kotlin.jvm.functions.Function20")) {
                                    return "kotlin.Function20";
                                }
                                return null;
                            case -1811142684:
                                if (str.equals("kotlin.jvm.functions.Function21")) {
                                    return "kotlin.Function21";
                                }
                                return null;
                            case -1811142683:
                                if (str.equals("kotlin.jvm.functions.Function22")) {
                                    return "kotlin.Function22";
                                }
                                return null;
                            default:
                                switch (iHashCode) {
                                    case 80123371:
                                        if (str.equals("kotlin.jvm.functions.Function0")) {
                                            return "kotlin.Function0";
                                        }
                                        return null;
                                    case 80123372:
                                        if (str.equals("kotlin.jvm.functions.Function1")) {
                                            return "kotlin.Function1";
                                        }
                                        return null;
                                    case 80123373:
                                        if (str.equals("kotlin.jvm.functions.Function2")) {
                                            return "kotlin.Function2";
                                        }
                                        return null;
                                    case 80123374:
                                        if (str.equals("kotlin.jvm.functions.Function3")) {
                                            return "kotlin.Function3";
                                        }
                                        return null;
                                    case 80123375:
                                        if (str.equals("kotlin.jvm.functions.Function4")) {
                                            return "kotlin.Function4";
                                        }
                                        return null;
                                    case 80123376:
                                        if (str.equals("kotlin.jvm.functions.Function5")) {
                                            return "kotlin.Function5";
                                        }
                                        return null;
                                    case 80123377:
                                        if (str.equals("kotlin.jvm.functions.Function6")) {
                                            return "kotlin.Function6";
                                        }
                                        return null;
                                    case 80123378:
                                        if (str.equals("kotlin.jvm.functions.Function7")) {
                                            return "kotlin.Function7";
                                        }
                                        return null;
                                    case 80123379:
                                        if (str.equals("kotlin.jvm.functions.Function8")) {
                                            return "kotlin.Function8";
                                        }
                                        return null;
                                    case 80123380:
                                        if (str.equals("kotlin.jvm.functions.Function9")) {
                                            return "kotlin.Function9";
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean g(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zH = h(file, inputStreamOpenRawResource);
                f(inputStreamOpenRawResource);
                return zH;
            } catch (Throwable th) {
                th = th;
                f(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean h(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    f(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            f(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            f(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static final u50 i(Throwable th) {
        pr.j("exception", th);
        return new u50(th);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        if (r1.d(r11, r0) == r5) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:25:0x005e, B:29:0x0072, B:31:0x007a, B:33:0x0080, B:35:0x0086, B:38:0x0097, B:39:0x009f, B:40:0x00a0, B:41:0x00a7, B:20:0x0049, B:24:0x0054), top: B:60:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0094 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object j(sensei0.il r8, sensei0.r20 r9, boolean r10, sensei0.yb r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.wf0.j(sensei0.il, sensei0.r20, boolean, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r5.c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.ColorStateList k(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            sensei0.r50 r1 = new sensei0.r50
            r1.<init>(r0, r8)
            java.lang.Object r2 = sensei0.s50.c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = sensei0.s50.b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            sensei0.q50 r5 = (sensei0.q50) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            android.content.res.Configuration r6 = r5.b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb8
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            android.content.res.ColorStateList r3 = r5.a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = sensei0.s50.a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L67
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = sensei0.w9.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb3
            java.lang.Object r2 = sensei0.s50.c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = sensei0.s50.b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            android.util.SparseArray r3 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb1
        La1:
            sensei0.q50 r0 = new sensei0.q50     // Catch: java.lang.Throwable -> L9f
            android.content.res.Resources r1 = r1.a     // Catch: java.lang.Throwable -> L9f
            android.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L9f
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            goto Lb7
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb3:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lb7:
            return r4
        Lb8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.wf0.k(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static float l(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return lh.b(edgeEffect);
        }
        return 0.0f;
    }

    public static Drawable m(Context context, int i) {
        return p50.b().c(context, i);
    }

    public static File n(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static final void o(Throwable th, lc lcVar) {
        try {
            r2 r2Var = (r2) lcVar.n(mh.d);
            if (r2Var != null) {
                r2Var.e(th);
            } else {
                pr.C(th, lcVar);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a(runtimeException, th);
                th = runtimeException;
            }
            pr.C(th, lcVar);
        }
    }

    public static boolean p(int i, Object obj) {
        if (obj instanceof rp) {
            if ((obj instanceof sp ? ((sp) obj).b() : obj instanceof uo ? 0 : obj instanceof fp ? 1 : obj instanceof jp ? 2 : obj instanceof kp ? 3 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static ob0 q(uc ucVar, jp jpVar) {
        lc lcVarK = xe.k(ucVar.g(), oi.a, true);
        nf nfVar = kg.a;
        if (lcVarK != nfVar && lcVarK.n(mh.c) == null) {
            lcVarK = lcVarK.j(nfVar);
        }
        ob0 ob0Var = new ob0(lcVarK, true);
        ob0Var.V(xc.a, ob0Var, jpVar);
        return ob0Var;
    }

    public static MappedByteBuffer r(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static float s(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return lh.c(edgeEffect, f, f2);
        }
        kh.a(edgeEffect, f, f2);
        return f;
    }

    public static ih0 t(String str) {
        String strGroup;
        if (str == null || fc0.l0(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
        if (!matcher.matches() || (strGroup = matcher.group(1)) == null) {
            return null;
        }
        int i = Integer.parseInt(strGroup);
        String strGroup2 = matcher.group(2);
        if (strGroup2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(strGroup2);
        String strGroup3 = matcher.group(3);
        if (strGroup3 == null) {
            return null;
        }
        int i3 = Integer.parseInt(strGroup3);
        String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
        pr.i("description", strGroup4);
        return new ih0(strGroup4, i, i2, i3);
    }

    public static rx u(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = byteBufferDuplicate.getInt();
                long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    byteBufferDuplicate.position((int) (j3 + j));
                    rx rxVar = new rx();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    rxVar.d = byteBufferDuplicate;
                    rxVar.a = iPosition;
                    int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    rxVar.b = i6;
                    rxVar.c = ((ByteBuffer) rxVar.d).getShort(i6);
                    return rxVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void v(ya yaVar, MediaExtractor mediaExtractor) {
        try {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.startsWith("image/")) {
                    int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
                    int i2 = yaVar.f;
                    int i3 = yaVar.e;
                    if (integer != 90 && integer != 270) {
                        i3 = i2;
                        i2 = i3;
                    }
                    yaVar.b = i2;
                    yaVar.a = i3;
                    yaVar.c = integer;
                    return;
                }
            }
        } catch (Exception e2) {
            Log.e("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e2);
        }
    }

    public static void w(em emVar) {
        try {
            GeneratedPluginRegistrant.class.getDeclaredMethod("registerWith", em.class).invoke(null, emVar);
        } catch (Exception e2) {
            Log.e("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + emVar + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.e("GeneratedPluginsRegister", "Received exception while registering", e2);
        }
    }

    public static TypedValue x(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static TypedValue y(Context context, int i, String str) {
        TypedValue typedValueX = x(context, i);
        if (typedValueX != null) {
            return typedValueX;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Object z(jp jpVar) throws Throwable {
        lc lcVar;
        Thread threadCurrentThread = Thread.currentThread();
        mh mhVar = mh.c;
        dj djVarA = ie0.a();
        boolean zBooleanValue = ((Boolean) djVarA.d(Boolean.FALSE, mc.d)).booleanValue();
        if (zBooleanValue) {
            oi oiVar = oi.a;
            lc lcVar2 = (lc) (zBooleanValue ? djVarA.d(oiVar, mc.c) : djVarA);
            oiVar.j(lcVar2);
            lcVar = lcVar2;
        } else {
            lcVar = djVarA;
        }
        nf nfVar = kg.a;
        lc lcVarJ = lcVar;
        if (lcVar != nfVar) {
            jc jcVarN = lcVar.n(mhVar);
            lcVarJ = lcVar;
            if (jcVarN == null) {
                lcVarJ = lcVar.j(nfVar);
            }
        }
        b6 b6Var = new b6(lcVarJ, threadCurrentThread, djVarA);
        b6Var.V(xc.a, b6Var, jpVar);
        dj djVar = b6Var.f;
        if (djVar != null) {
            int i = dj.h;
            djVar.i(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jK = djVar != null ? djVar.k() : Long.MAX_VALUE;
                if (!(b6Var.D() instanceof wq)) {
                    if (djVar != null) {
                        int i2 = dj.h;
                        djVar.g(false);
                    }
                    Object objO = xe.O(b6Var.D());
                    ga gaVar = objO instanceof ga ? (ga) objO : null;
                    if (gaVar == null) {
                        return objO;
                    }
                    throw gaVar.a;
                }
                LockSupport.parkNanos(b6Var, jK);
            } catch (Throwable th) {
                if (djVar != null) {
                    int i3 = dj.h;
                    djVar.g(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        b6Var.r(interruptedException);
        throw interruptedException;
    }
}
