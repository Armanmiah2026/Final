package sensei0;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qj0 extends nj0 {
    public static final /* synthetic */ int h = 0;
    public final c9 b;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    public qj0(c9 c9Var) {
        this.b = c9Var;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("messageArg", consoleMessage);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage", g30Var.a(), null).k(p9.f0(this, consoleMessage), new m00(7, a3Var));
        return this.d;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt", g30Var.a(), null).k(k6.G(this), new m00(9, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("originArg", str);
        pr.j("callbackArg", callback);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt", g30Var.a(), null).k(p9.f0(this, str, callback), new m00(8, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView", g30Var.a(), null).k(k6.G(this), new m00(3, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!this.e) {
            return false;
        }
        f fVar = new f(3, new oj0(this, jsResult, 1));
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("webViewArg", webView);
        pr.j("urlArg", str);
        pr.j("messageArg", str2);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert", g30Var.a(), null).k(p9.f0(this, webView, str, str2), new o00(fVar, 1));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!this.f) {
            return false;
        }
        f fVar = new f(3, new oj0(this, jsResult, 0));
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("webViewArg", webView);
        pr.j("urlArg", str);
        pr.j("messageArg", str2);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm", g30Var.a(), null).k(p9.f0(this, webView, str, str2), new o00(fVar, 3));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!this.g) {
            return false;
        }
        f fVar = new f(3, new wz(1, this, jsPromptResult));
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("webViewArg", webView);
        pr.j("urlArg", str);
        pr.j("messageArg", str2);
        pr.j("defaultValueArg", str3);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt", g30Var.a(), null).k(p9.f0(this, webView, str, str2, str3), new o00(fVar, 0));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("requestArg", permissionRequest);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest", g30Var.a(), null).k(p9.f0(this, permissionRequest), new m00(5, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        long j = i;
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("webViewArg", webView);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged", g30Var.a(), null).k(p9.f0(this, webView, Long.valueOf(j)), new m00(4, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        a3 a3Var = new a3(23);
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("viewArg", view);
        pr.j("callbackArg", customViewCallback);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView", g30Var.a(), null).k(p9.f0(this, view, customViewCallback), new m00(6, a3Var));
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, final ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        final boolean z = this.c;
        f fVar = new f(3, new fp() { // from class: sensei0.pj0
            @Override // sensei0.fp
            public final Object g(Object obj) {
                w50 w50Var = (w50) obj;
                if (w50Var.d) {
                    g30 g30Var = this.a.b.a;
                    Throwable th = w50Var.c;
                    Objects.requireNonNull(th);
                    g30Var.getClass();
                    g30.b(th);
                    return null;
                }
                List list = (List) w50Var.b;
                Objects.requireNonNull(list);
                if (!z) {
                    return null;
                }
                Uri[] uriArr = new Uri[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    uriArr[i] = Uri.parse((String) list.get(i));
                }
                valueCallback.onReceiveValue(uriArr);
                return null;
            }
        });
        c9 c9Var = this.b;
        c9Var.getClass();
        pr.j("webViewArg", webView);
        pr.j("paramsArg", fileChooserParams);
        g30 g30Var = c9Var.a;
        g30Var.getClass();
        new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser", g30Var.a(), null).k(p9.f0(this, webView, fileChooserParams), new o00(fVar, 2));
        return z;
    }
}
