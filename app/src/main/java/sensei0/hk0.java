package sensei0;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class hk0 implements xm, l2 {
    public j1 a;
    public g30 b;

    @Override // sensei0.l2
    public final void b() {
        this.b.d = (Context) this.a.a;
    }

    @Override // sensei0.l2
    public final void c(af0 af0Var) {
        this.b.d = (Activity) af0Var.a;
    }

    @Override // sensei0.l2
    public final void d(af0 af0Var) {
        g30 g30Var = this.b;
        if (g30Var != null) {
            g30Var.d = (Activity) af0Var.a;
        }
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        g30 g30Var = this.b;
        if (g30Var != null) {
            dd0 dd0Var = z2.b;
            a6 a6Var = g30Var.a;
            xe.H(a6Var, null);
            wf0.C(a6Var, null);
            xe.J(a6Var, null);
            k6.U(a6Var, null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.pigeon_defaultConstructor", new lx(3), null).l(null);
            lx lxVar = new lx(3);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_defaultConstructor", lxVar, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.setSynchronousReturnValueForShouldOverrideUrlLoading", lxVar, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.pigeon_defaultConstructor", new lx(3), null).l(null);
            mm0.g0(a6Var, null);
            mm0.f0(a6Var, null);
            lx lxVar2 = new lx(3);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebStorage.instance", lxVar2, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebStorage.deleteAllData", lxVar2, null).l(null);
            lx lxVar3 = new lx(3);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.grant", lxVar3, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.deny", lxVar3, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.onCustomViewHidden", new lx(3), null).l(null);
            wf0.D(a6Var, null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.invoke", new lx(3), null).l(null);
            k6.T(a6Var, null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", new lx(3), null).l(null);
            pr.R(a6Var, null);
            lx lxVar4 = new lx(3);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.cancel", lxVar4, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.proceed", lxVar4, null).l(null);
            lx lxVar5 = new lx(3);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslError.getPrimaryError", lxVar5, null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslError.hasError", lxVar5, null).l(null);
            pr.S(a6Var, null);
            xe.I(a6Var, null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.Certificate.getEncoded", new lx(3), null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettingsCompat.setPaymentRequestEnabled", new lx(3), null).l(null);
            new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebViewFeature.isFeatureSupported", new lx(3), null).l(null);
            v2 v2Var = this.b.b;
            v2Var.g.removeCallbacks(v2Var.h);
            v2Var.j = true;
            this.b = null;
        }
    }

    @Override // sensei0.l2
    public final void f() {
        this.b.d = (Context) this.a.a;
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        this.a = j1Var;
        a6 a6Var = (a6) j1Var.b;
        Context context = (Context) j1Var.a;
        g30 g30Var = new g30(a6Var, context, new bm(context.getAssets(), (sv) j1Var.d));
        this.b = g30Var;
        lm lmVar = (lm) j1Var.c;
        rn rnVar = new rn(g30Var.b);
        HashMap map = lmVar.a;
        if (!map.containsKey("plugins.flutter.io/webview")) {
            map.put("plugins.flutter.io/webview", rnVar);
        }
        g30 g30Var2 = this.b;
        g30Var2.getClass();
        dd0 dd0Var = z2.b;
        a6 a6Var2 = g30Var2.a;
        xe.H(a6Var2, g30Var2.b);
        final int i = 1;
        wf0.C(a6Var2, new c9(g30Var2, 1));
        xe.J(a6Var2, new c9(g30Var2, 14));
        k6.U(a6Var2, new c9(g30Var2, 11));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.pigeon_defaultConstructor", g30Var2.a(), null).l(new x2(7, new c9(g30Var2, 5)));
        final c9 c9Var = new c9(g30Var2, 13);
        dx dxVarA = g30Var2.a();
        final int i2 = 0;
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_defaultConstructor", dxVarA, null).l(new u5() { // from class: sensei0.t00
            @Override // sensei0.u5
            public final void j(Object obj, i3 i3Var) {
                List listF0;
                List listF02;
                switch (i2) {
                    case 0:
                        c9 c9Var2 = c9Var;
                        pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                        Object obj2 = ((List) obj).get(0);
                        pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                        try {
                            c9Var2.a.b.a(((Long) obj2).longValue(), new ck0(c9Var2));
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
                    default:
                        c9 c9Var3 = c9Var;
                        pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                        List list = (List) obj;
                        Object obj3 = list.get(0);
                        pr.g("null cannot be cast to non-null type android.webkit.WebViewClient", obj3);
                        WebViewClient webViewClient = (WebViewClient) obj3;
                        Object obj4 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                        try {
                            if (!(webViewClient instanceof wj0)) {
                                c9Var3.a.getClass();
                                if (!(webViewClient instanceof ck0)) {
                                    throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
                                }
                                ((ck0) webViewClient).b = zBooleanValue;
                            }
                            listF02 = k6.G(null);
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
                }
            }
        });
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.setSynchronousReturnValueForShouldOverrideUrlLoading", dxVarA, null).l(new u5() { // from class: sensei0.t00
            @Override // sensei0.u5
            public final void j(Object obj, i3 i3Var) {
                List listF0;
                List listF02;
                switch (i) {
                    case 0:
                        c9 c9Var2 = c9Var;
                        pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                        Object obj2 = ((List) obj).get(0);
                        pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                        try {
                            c9Var2.a.b.a(((Long) obj2).longValue(), new ck0(c9Var2));
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
                    default:
                        c9 c9Var3 = c9Var;
                        pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                        List list = (List) obj;
                        Object obj3 = list.get(0);
                        pr.g("null cannot be cast to non-null type android.webkit.WebViewClient", obj3);
                        WebViewClient webViewClient = (WebViewClient) obj3;
                        Object obj4 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                        try {
                            if (!(webViewClient instanceof wj0)) {
                                c9Var3.a.getClass();
                                if (!(webViewClient instanceof ck0)) {
                                    throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
                                }
                                ((ck0) webViewClient).b = zBooleanValue;
                            }
                            listF02 = k6.G(null);
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
                }
            }
        });
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.pigeon_defaultConstructor", g30Var2.a(), null).l(new x2(6, new c9(g30Var2, 2)));
        mm0.g0(a6Var2, new c9(g30Var2, 10));
        mm0.f0(a6Var2, new c9(g30Var2, 3));
        c9 c9Var2 = new c9(g30Var2, 12);
        dx dxVarA2 = g30Var2.a();
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebStorage.instance", dxVarA2, null).l(new x2(9, c9Var2));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebStorage.deleteAllData", dxVarA2, null).l(new m00(17, c9Var2));
        mz mzVar = new mz(1);
        dx dxVarA3 = g30Var2.a();
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.grant", dxVarA3, null).l(new b0(22, mzVar));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.deny", dxVarA3, null).l(new b0(23, mzVar));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.onCustomViewHidden", g30Var2.a(), null).l(new b0(13, new mh(26)));
        wf0.D(a6Var2, new c9(g30Var2, 9));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.invoke", g30Var2.a(), null).l(new b0(18, new pf(17)));
        k6.T(a6Var2, new c9(g30Var2, 4));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", g30Var2.a(), null).l(new b0(6, new pf(25)));
        pr.R(a6Var2, new c9(g30Var2, 0));
        mz mzVar2 = new mz(14);
        dx dxVarA4 = g30Var2.a();
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.cancel", dxVarA4, null).l(new m00(0, mzVar2));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.proceed", dxVarA4, null).l(new m00(1, mzVar2));
        c9 c9Var3 = new c9(g30Var2, 8);
        dx dxVarA5 = g30Var2.a();
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.SslError.getPrimaryError", dxVarA5, null).l(new b0(28, c9Var3));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.SslError.hasError", dxVarA5, null).l(new x2(8, c9Var3));
        pr.S(a6Var2, new c9(g30Var2, 6));
        xe.I(a6Var2, new c9(g30Var2, 7));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.Certificate.getEncoded", g30Var2.a(), null).l(new b0(8, new mh(24)));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebSettingsCompat.setPaymentRequestEnabled", g30Var2.a(), null).l(new m00(15, new mz(23)));
        new j1(a6Var2, "dev.flutter.pigeon.webview_flutter_android.WebViewFeature.isFeatureSupported", g30Var2.a(), null).l(new m00(22, new mz(24)));
    }
}
