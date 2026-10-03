package sensei0;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ck0 extends WebViewClient {
    public static final /* synthetic */ int c = 0;
    public final c9 a;
    public boolean b = false;

    public ck0(c9 c9Var) {
        this.a = c9Var;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(final WebView webView, final String str, final boolean z) {
        this.a.a.c(new Runnable() { // from class: sensei0.ak0
            @Override // java.lang.Runnable
            public final void run() {
                ck0 ck0Var = this.a;
                c9 c9Var = ck0Var.a;
                a3 a3Var = new a3(24);
                c9Var.getClass();
                WebView webView2 = webView;
                pr.j("webViewArg", webView2);
                String str2 = str;
                pr.j("urlArg", str2);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.doUpdateVisitedHistory", g30Var.a(), null).k(p9.f0(ck0Var, webView2, str2, Boolean.valueOf(z)), new s00(a3Var, 1));
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        this.a.a.c(new rg(this, webView, message, message2, 1));
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        this.a.a.c(new xj0(this, webView, str, 2));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        this.a.a.c(new xj0(this, webView, str, 4));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.a.a.c(new xj0(this, webView, str, 3));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.a.c(new xj0(this, webView, str, 0));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        this.a.a.c(new wh(this, webView, clientCertRequest, 4));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.a.a.c(new rg(this, webView, webResourceRequest, webResourceError, 3));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.a.a.c(new zj0(this, webView, httpAuthHandler, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.a.a.c(new rg(this, webView, webResourceRequest, webResourceResponse, 4));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.a.a.c(new zj0(this, webView, str, str2, str3));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.a.a.c(new rg(this, webView, sslErrorHandler, sslError, 2));
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(final WebView webView, final float f, final float f2) {
        this.a.a.c(new Runnable() { // from class: sensei0.bk0
            @Override // java.lang.Runnable
            public final void run() {
                ck0 ck0Var = this.a;
                c9 c9Var = ck0Var.a;
                double d = f;
                double d2 = f2;
                a3 a3Var = new a3(24);
                c9Var.getClass();
                WebView webView2 = webView;
                pr.j("viewArg", webView2);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onScaleChanged", g30Var.a(), null).k(p9.f0(ck0Var, webView2, Double.valueOf(d), Double.valueOf(d2)), new s00(a3Var, 14));
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        this.a.a.c(new wh(this, webView, webResourceRequest, 5));
        return webResourceRequest.isForMainFrame() && this.b;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(final WebView webView, final int i, final String str, final String str2) {
        this.a.a.c(new Runnable() { // from class: sensei0.yj0
            @Override // java.lang.Runnable
            public final void run() {
                ck0 ck0Var = this.a;
                c9 c9Var = ck0Var.a;
                long j = i;
                a3 a3Var = new a3(24);
                c9Var.getClass();
                WebView webView2 = webView;
                pr.j("webViewArg", webView2);
                String str3 = str;
                pr.j("descriptionArg", str3);
                String str4 = str2;
                pr.j("failingUrlArg", str4);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedError", g30Var.a(), null).k(p9.f0(ck0Var, webView2, Long.valueOf(j), str3, str4), new s00(a3Var, 10));
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.a.c(new xj0(this, webView, str, 1));
        return this.b;
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }
}
