package sensei0;

import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import com.trilead.ssh2.sftp.ErrorCodes;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m00 implements u5, v5, wd0, lf0 {
    public final /* synthetic */ int a;

    public /* synthetic */ m00(int i) {
        this.a = i;
    }

    @Override // sensei0.lf0
    public void a(jf0 jf0Var, mf0 mf0Var, boolean z) {
        switch (this.a) {
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                jf0Var.f(mf0Var);
                break;
            case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                jf0Var.a(mf0Var);
                break;
            case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                jf0Var.c(mf0Var);
                break;
            default:
                jf0Var.b();
                break;
        }
    }

    @Override // sensei0.u5
    public void j(Object obj, i3 i3Var) {
        List listF0;
        List listF02;
        List listF03;
        List listF04;
        List listF05;
        switch (this.a) {
            case 0:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj2 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.webkit.SslErrorHandler", obj2);
                try {
                    ((SslErrorHandler) obj2).cancel();
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
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj3 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.webkit.SslErrorHandler", obj3);
                try {
                    ((SslErrorHandler) obj3).proceed();
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
            case 15:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                List list = (List) obj;
                Object obj4 = list.get(0);
                pr.g("null cannot be cast to non-null type android.webkit.WebSettings", obj4);
                WebSettings webSettings = (WebSettings) obj4;
                Object obj5 = list.get(1);
                pr.g("null cannot be cast to non-null type kotlin.Boolean", obj5);
                try {
                    mz.i(webSettings, ((Boolean) obj5).booleanValue());
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
            case 17:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj6 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.webkit.WebStorage", obj6);
                try {
                    ((WebStorage) obj6).deleteAllData();
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
            default:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj7 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type kotlin.String", obj7);
                try {
                    listF05 = k6.G(Boolean.valueOf(fi0.a((String) obj7)));
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

    @Override // sensei0.v5
    public void s(Object obj) {
        switch (this.a) {
            case 2:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance'.", "");
                    int i = b3.i;
                } else {
                    List list = (List) obj;
                    if (list.size() <= 1) {
                        int i2 = b3.i;
                    } else {
                        Object obj2 = list.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                        Object obj3 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                        wf0.i(new t2((String) obj2, (String) obj3, (String) list.get(2)));
                        int i3 = b3.i;
                    }
                }
                break;
            case 3:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView'.", "");
                    int i4 = qj0.h;
                } else {
                    List list2 = (List) obj;
                    if (list2.size() <= 1) {
                        int i5 = qj0.h;
                    } else {
                        Object obj4 = list2.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                        Object obj5 = list2.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                        wf0.i(new t2((String) obj4, (String) obj5, (String) list2.get(2)));
                        int i6 = qj0.h;
                    }
                }
                break;
            case 4:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged'.", "");
                    int i7 = qj0.h;
                } else {
                    List list3 = (List) obj;
                    if (list3.size() <= 1) {
                        int i8 = qj0.h;
                    } else {
                        Object obj6 = list3.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                        Object obj7 = list3.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj7);
                        wf0.i(new t2((String) obj6, (String) obj7, (String) list3.get(2)));
                        int i9 = qj0.h;
                    }
                }
                break;
            case 5:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest'.", "");
                    int i10 = qj0.h;
                } else {
                    List list4 = (List) obj;
                    if (list4.size() <= 1) {
                        int i11 = qj0.h;
                    } else {
                        Object obj8 = list4.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                        Object obj9 = list4.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj9);
                        wf0.i(new t2((String) obj8, (String) obj9, (String) list4.get(2)));
                        int i12 = qj0.h;
                    }
                }
                break;
            case 6:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView'.", "");
                    int i13 = qj0.h;
                } else {
                    List list5 = (List) obj;
                    if (list5.size() <= 1) {
                        int i14 = qj0.h;
                    } else {
                        Object obj10 = list5.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                        Object obj11 = list5.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                        wf0.i(new t2((String) obj10, (String) obj11, (String) list5.get(2)));
                        int i15 = qj0.h;
                    }
                }
                break;
            case 7:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage'.", "");
                    int i16 = qj0.h;
                } else {
                    List list6 = (List) obj;
                    if (list6.size() <= 1) {
                        int i17 = qj0.h;
                    } else {
                        Object obj12 = list6.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                        Object obj13 = list6.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                        wf0.i(new t2((String) obj12, (String) obj13, (String) list6.get(2)));
                        int i18 = qj0.h;
                    }
                }
                break;
            case 8:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt'.", "");
                    int i19 = qj0.h;
                } else {
                    List list7 = (List) obj;
                    if (list7.size() <= 1) {
                        int i20 = qj0.h;
                    } else {
                        Object obj14 = list7.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                        Object obj15 = list7.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                        wf0.i(new t2((String) obj14, (String) obj15, (String) list7.get(2)));
                        int i21 = qj0.h;
                    }
                }
                break;
            case 9:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt'.", "");
                    int i22 = qj0.h;
                } else {
                    List list8 = (List) obj;
                    if (list8.size() <= 1) {
                        int i23 = qj0.h;
                    } else {
                        Object obj16 = list8.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                        Object obj17 = list8.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj17);
                        wf0.i(new t2((String) obj16, (String) obj17, (String) list8.get(2)));
                        int i24 = qj0.h;
                    }
                }
                break;
            case 10:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceError.pigeon_newInstance'.", "");
                    int i25 = b3.i;
                } else {
                    List list9 = (List) obj;
                    if (list9.size() <= 1) {
                        int i26 = b3.i;
                    } else {
                        Object obj18 = list9.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                        Object obj19 = list9.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                        wf0.i(new t2((String) obj18, (String) obj19, (String) list9.get(2)));
                        int i27 = b3.i;
                    }
                }
                break;
            case 11:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceErrorCompat.pigeon_newInstance'.", "");
                    int i28 = b3.i;
                } else {
                    List list10 = (List) obj;
                    if (list10.size() <= 1) {
                        int i29 = b3.i;
                    } else {
                        Object obj20 = list10.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj20);
                        Object obj21 = list10.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                        wf0.i(new t2((String) obj20, (String) obj21, (String) list10.get(2)));
                        int i30 = b3.i;
                    }
                }
                break;
            case 12:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance'.", "");
                    int i31 = b3.i;
                } else {
                    List list11 = (List) obj;
                    if (list11.size() <= 1) {
                        int i32 = b3.i;
                    } else {
                        Object obj22 = list11.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj22);
                        Object obj23 = list11.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj23);
                        wf0.i(new t2((String) obj22, (String) obj23, (String) list11.get(2)));
                        int i33 = b3.i;
                    }
                }
                break;
            case 13:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebResourceResponse.pigeon_newInstance'.", "");
                    int i34 = b3.i;
                } else {
                    List list12 = (List) obj;
                    if (list12.size() <= 1) {
                        int i35 = b3.i;
                    } else {
                        Object obj24 = list12.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj24);
                        Object obj25 = list12.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj25);
                        wf0.i(new t2((String) obj24, (String) obj25, (String) list12.get(2)));
                        int i36 = b3.i;
                    }
                }
                break;
            case 14:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance'.", "");
                    int i37 = b3.i;
                } else {
                    List list13 = (List) obj;
                    if (list13.size() <= 1) {
                        int i38 = b3.i;
                    } else {
                        Object obj26 = list13.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                        Object obj27 = list13.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                        wf0.i(new t2((String) obj26, (String) obj27, (String) list13.get(2)));
                        int i39 = b3.i;
                    }
                }
                break;
            case 15:
            case 17:
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
            default:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.X509Certificate.pigeon_newInstance'.", "");
                    int i40 = b3.i;
                } else {
                    List list14 = (List) obj;
                    if (list14.size() <= 1) {
                        int i41 = b3.i;
                    } else {
                        Object obj28 = list14.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj28);
                        Object obj29 = list14.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                        wf0.i(new t2((String) obj28, (String) obj29, (String) list14.get(2)));
                        int i42 = b3.i;
                    }
                }
                break;
            case 16:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebStorage.pigeon_newInstance'.", "");
                    int i43 = b3.i;
                } else {
                    List list15 = (List) obj;
                    if (list15.size() <= 1) {
                        int i44 = b3.i;
                    } else {
                        Object obj30 = list15.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj30);
                        Object obj31 = list15.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj31);
                        wf0.i(new t2((String) obj30, (String) obj31, (String) list15.get(2)));
                        int i45 = b3.i;
                    }
                }
                break;
            case 18:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance'.", "");
                    int i46 = b3.i;
                } else {
                    List list16 = (List) obj;
                    if (list16.size() <= 1) {
                        int i47 = b3.i;
                    } else {
                        Object obj32 = list16.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                        Object obj33 = list16.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj33);
                        wf0.i(new t2((String) obj32, (String) obj33, (String) list16.get(2)));
                        int i48 = b3.i;
                    }
                }
                break;
            case 19:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged'.", "");
                    int i49 = nk0.d;
                } else {
                    List list17 = (List) obj;
                    if (list17.size() <= 1) {
                        int i50 = nk0.d;
                    } else {
                        Object obj34 = list17.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj34);
                        Object obj35 = list17.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj35);
                        wf0.i(new t2((String) obj34, (String) obj35, (String) list17.get(2)));
                        int i51 = nk0.d;
                    }
                }
                break;
            case 20:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_newInstance'.", "");
                    int i52 = b3.i;
                } else {
                    List list18 = (List) obj;
                    if (list18.size() <= 1) {
                        int i53 = b3.i;
                    } else {
                        Object obj36 = list18.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                        Object obj37 = list18.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj37);
                        wf0.i(new t2((String) obj36, (String) obj37, (String) list18.get(2)));
                        int i54 = b3.i;
                    }
                }
                break;
            case 21:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedRequestError'.", "");
                    int i55 = ck0.c;
                } else {
                    List list19 = (List) obj;
                    if (list19.size() <= 1) {
                        int i56 = ck0.c;
                    } else {
                        Object obj38 = list19.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj38);
                        Object obj39 = list19.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj39);
                        wf0.i(new t2((String) obj38, (String) obj39, (String) list19.get(2)));
                        int i57 = ck0.c;
                    }
                }
                break;
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewPoint.pigeon_newInstance'.", "");
                    int i58 = b3.i;
                } else {
                    List list20 = (List) obj;
                    if (list20.size() <= 1) {
                        int i59 = b3.i;
                    } else {
                        Object obj40 = list20.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj40);
                        Object obj41 = list20.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj41);
                        wf0.i(new t2((String) obj40, (String) obj41, (String) list20.get(2)));
                        int i60 = b3.i;
                    }
                }
                break;
        }
    }

    public /* synthetic */ m00(int i, Object obj) {
        this.a = i;
    }
}
