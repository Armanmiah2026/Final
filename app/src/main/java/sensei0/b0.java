package sensei0;

import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.DebugLogger;
import com.trilead.ssh2.sftp.ErrorCodes;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements i0, DebugLogger, v5, u5 {
    public final /* synthetic */ int a;

    public /* synthetic */ b0(int i) {
        this.a = i;
    }

    @Override // sensei0.u5
    public void j(Object obj, i3 i3Var) {
        List listF0;
        List listF02;
        List listF03;
        List listF04;
        List listF05;
        List listF06;
        List listF07;
        switch (this.a) {
            case 6:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj2 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.os.Message", obj2);
                try {
                    ((Message) obj2).sendToTarget();
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
            case 8:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj3 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type java.security.cert.Certificate", obj3);
                try {
                    try {
                        listF02 = k6.G(((Certificate) obj3).getEncoded());
                    } catch (CertificateEncodingException e) {
                        throw new RuntimeException(e);
                    }
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
            case 13:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj4 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.webkit.WebChromeClient.CustomViewCallback", obj4);
                try {
                    ((WebChromeClient.CustomViewCallback) obj4).onCustomViewHidden();
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
                return;
            case 18:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                List list = (List) obj;
                Object obj5 = list.get(0);
                pr.g("null cannot be cast to non-null type android.webkit.GeolocationPermissions.Callback", obj5);
                GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) obj5;
                Object obj6 = list.get(1);
                pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                String str = (String) obj6;
                Object obj7 = list.get(2);
                pr.g("null cannot be cast to non-null type kotlin.Boolean", obj7);
                boolean zBooleanValue = ((Boolean) obj7).booleanValue();
                Object obj8 = list.get(3);
                pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                try {
                    callback.invoke(str, zBooleanValue, ((Boolean) obj8).booleanValue());
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
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                List list2 = (List) obj;
                Object obj9 = list2.get(0);
                pr.g("null cannot be cast to non-null type android.webkit.PermissionRequest", obj9);
                PermissionRequest permissionRequest = (PermissionRequest) obj9;
                Object obj10 = list2.get(1);
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj10);
                try {
                    permissionRequest.grant((String[]) ((List) obj10).toArray(new String[0]));
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
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj11 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.webkit.PermissionRequest", obj11);
                try {
                    ((PermissionRequest) obj11).deny();
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
                return;
            default:
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj12 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type android.net.http.SslError", obj12);
                try {
                    int primaryError = ((SslError) obj12).getPrimaryError();
                    listF07 = k6.G(primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? hb0.q : hb0.h : hb0.c : hb0.p : hb0.f : hb0.d : hb0.o);
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
                return;
        }
    }

    @Override // com.trilead.ssh2.DebugLogger
    public void log(int i, String str, String str2) {
        Connection.lambda$enableDebugging$1(i, str, str2);
    }

    @Override // sensei0.v5
    public void s(Object obj) {
        switch (this.a) {
            case 5:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance'.", "");
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
            case 6:
            case 8:
            case 13:
            case 18:
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
            default:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.pigeon_newInstance'.", "");
                    int i4 = b3.i;
                } else {
                    List list2 = (List) obj;
                    if (list2.size() <= 1) {
                        int i5 = b3.i;
                    } else {
                        Object obj4 = list2.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                        Object obj5 = list2.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                        wf0.i(new t2((String) obj4, (String) obj5, (String) list2.get(2)));
                        int i6 = b3.i;
                    }
                }
                break;
            case 7:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.Certificate.pigeon_newInstance'.", "");
                    int i7 = b3.i;
                } else {
                    List list3 = (List) obj;
                    if (list3.size() <= 1) {
                        int i8 = b3.i;
                    } else {
                        Object obj6 = list3.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                        Object obj7 = list3.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj7);
                        wf0.i(new t2((String) obj6, (String) obj7, (String) list3.get(2)));
                        int i9 = b3.i;
                    }
                }
                break;
            case 9:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance'.", "");
                    int i10 = b3.i;
                } else {
                    List list4 = (List) obj;
                    if (list4.size() <= 1) {
                        int i11 = b3.i;
                    } else {
                        Object obj8 = list4.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                        Object obj9 = list4.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj9);
                        wf0.i(new t2((String) obj8, (String) obj9, (String) list4.get(2)));
                        int i12 = b3.i;
                    }
                }
                break;
            case 10:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.ConsoleMessage.pigeon_newInstance'.", "");
                    int i13 = b3.i;
                } else {
                    List list5 = (List) obj;
                    if (list5.size() <= 1) {
                        int i14 = b3.i;
                    } else {
                        Object obj10 = list5.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                        Object obj11 = list5.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                        wf0.i(new t2((String) obj10, (String) obj11, (String) list5.get(2)));
                        int i15 = b3.i;
                    }
                }
                break;
            case 11:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance'.", "");
                    int i16 = b3.i;
                } else {
                    List list6 = (List) obj;
                    if (list6.size() <= 1) {
                        int i17 = b3.i;
                    } else {
                        Object obj12 = list6.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                        Object obj13 = list6.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                        wf0.i(new t2((String) obj12, (String) obj13, (String) list6.get(2)));
                        int i18 = b3.i;
                    }
                }
                break;
            case 12:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.pigeon_newInstance'.", "");
                    int i19 = b3.i;
                } else {
                    List list7 = (List) obj;
                    if (list7.size() <= 1) {
                        int i20 = b3.i;
                    } else {
                        Object obj14 = list7.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                        Object obj15 = list7.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                        wf0.i(new t2((String) obj14, (String) obj15, (String) list7.get(2)));
                        int i21 = b3.i;
                    }
                }
                break;
            case 14:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.DownloadListener.onDownloadStart'.", "");
                } else {
                    List list8 = (List) obj;
                    if (list8.size() > 1) {
                        Object obj16 = list8.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                        Object obj17 = list8.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj17);
                        wf0.i(new t2((String) obj16, (String) obj17, (String) list8.get(2)));
                    }
                }
                break;
            case 15:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.FileChooserParams.pigeon_newInstance'.", "");
                    int i22 = b3.i;
                } else {
                    List list9 = (List) obj;
                    if (list9.size() <= 1) {
                        int i23 = b3.i;
                    } else {
                        Object obj18 = list9.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                        Object obj19 = list9.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                        wf0.i(new t2((String) obj18, (String) obj19, (String) list9.get(2)));
                        int i24 = b3.i;
                    }
                }
                break;
            case 16:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.pigeon_newInstance'.", "");
                    int i25 = b3.i;
                } else {
                    List list10 = (List) obj;
                    if (list10.size() <= 1) {
                        int i26 = b3.i;
                    } else {
                        Object obj20 = list10.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj20);
                        Object obj21 = list10.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                        wf0.i(new t2((String) obj20, (String) obj21, (String) list10.get(2)));
                        int i27 = b3.i;
                    }
                }
                break;
            case 17:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.pigeon_newInstance'.", "");
                    int i28 = b3.i;
                } else {
                    List list11 = (List) obj;
                    if (list11.size() <= 1) {
                        int i29 = b3.i;
                    } else {
                        Object obj22 = list11.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj22);
                        Object obj23 = list11.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj23);
                        wf0.i(new t2((String) obj22, (String) obj23, (String) list11.get(2)));
                        int i30 = b3.i;
                    }
                }
                break;
            case 19:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance'.", "");
                    int i31 = b3.i;
                } else {
                    List list12 = (List) obj;
                    if (list12.size() <= 1) {
                        int i32 = b3.i;
                    } else {
                        Object obj24 = list12.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj24);
                        Object obj25 = list12.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj25);
                        wf0.i(new t2((String) obj24, (String) obj25, (String) list12.get(2)));
                        int i33 = b3.i;
                    }
                }
                break;
            case 20:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage'.", "");
                } else {
                    List list13 = (List) obj;
                    if (list13.size() > 1) {
                        Object obj26 = list13.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                        Object obj27 = list13.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                        wf0.i(new t2((String) obj26, (String) obj27, (String) list13.get(2)));
                    }
                }
                break;
            case 21:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance'.", "");
                    int i34 = b3.i;
                } else {
                    List list14 = (List) obj;
                    if (list14.size() <= 1) {
                        int i35 = b3.i;
                    } else {
                        Object obj28 = list14.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj28);
                        Object obj29 = list14.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                        wf0.i(new t2((String) obj28, (String) obj29, (String) list14.get(2)));
                        int i36 = b3.i;
                    }
                }
                break;
            case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PrivateKey.pigeon_newInstance'.", "");
                    int i37 = b3.i;
                } else {
                    List list15 = (List) obj;
                    if (list15.size() <= 1) {
                        int i38 = b3.i;
                    } else {
                        Object obj30 = list15.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj30);
                        Object obj31 = list15.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj31);
                        wf0.i(new t2((String) obj30, (String) obj31, (String) list15.get(2)));
                        int i39 = b3.i;
                    }
                }
                break;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslCertificate.pigeon_newInstance'.", "");
                    int i40 = b3.i;
                } else {
                    List list16 = (List) obj;
                    if (list16.size() <= 1) {
                        int i41 = b3.i;
                    } else {
                        Object obj32 = list16.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                        Object obj33 = list16.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj33);
                        wf0.i(new t2((String) obj32, (String) obj33, (String) list16.get(2)));
                        int i42 = b3.i;
                    }
                }
                break;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.pigeon_newInstance'.", "");
                    int i43 = b3.i;
                } else {
                    List list17 = (List) obj;
                    if (list17.size() <= 1) {
                        int i44 = b3.i;
                    } else {
                        Object obj34 = list17.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj34);
                        Object obj35 = list17.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj35);
                        wf0.i(new t2((String) obj34, (String) obj35, (String) list17.get(2)));
                        int i45 = b3.i;
                    }
                }
                break;
            case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                if (!(obj instanceof List)) {
                    za0.r("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.SslError.pigeon_newInstance'.", "");
                    int i46 = b3.i;
                } else {
                    List list18 = (List) obj;
                    if (list18.size() <= 1) {
                        int i47 = b3.i;
                    } else {
                        Object obj36 = list18.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj36);
                        Object obj37 = list18.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj37);
                        wf0.i(new t2((String) obj36, (String) obj37, (String) list18.get(2)));
                        int i48 = b3.i;
                    }
                }
                break;
        }
    }

    public /* synthetic */ b0(int i, Object obj) {
        this.a = i;
    }
}
