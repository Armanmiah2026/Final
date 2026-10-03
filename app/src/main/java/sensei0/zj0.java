package sensei0;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zj0 implements Runnable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ ck0 b;
    public final /* synthetic */ WebView c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String f;
    public final /* synthetic */ Object h;

    public /* synthetic */ zj0(ck0 ck0Var, WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b = ck0Var;
        this.c = webView;
        this.h = httpAuthHandler;
        this.d = str;
        this.f = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                String str = (String) this.h;
                ck0 ck0Var = this.b;
                c9 c9Var = ck0Var.a;
                a3 a3Var = new a3(24);
                c9Var.getClass();
                WebView webView = this.c;
                pr.j("viewArg", webView);
                String str2 = this.d;
                pr.j("realmArg", str2);
                pr.j("argsArg", str);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedLoginRequest", g30Var.a(), null).k(p9.f0(ck0Var, webView, str2, this.f, str), new s00(a3Var, 4));
                break;
            default:
                HttpAuthHandler httpAuthHandler = (HttpAuthHandler) this.h;
                ck0 ck0Var2 = this.b;
                c9 c9Var2 = ck0Var2.a;
                a3 a3Var2 = new a3(24);
                c9Var2.getClass();
                WebView webView2 = this.c;
                pr.j("webViewArg", webView2);
                pr.j("handlerArg", httpAuthHandler);
                String str3 = this.d;
                pr.j("hostArg", str3);
                String str4 = this.f;
                pr.j("realmArg", str4);
                g30 g30Var2 = c9Var2.a;
                g30Var2.getClass();
                new j1(g30Var2.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpAuthRequest", g30Var2.a(), null).k(p9.f0(ck0Var2, webView2, httpAuthHandler, str3, str4), new s00(a3Var2, 11));
                break;
        }
    }

    public /* synthetic */ zj0(ck0 ck0Var, WebView webView, String str, String str2, String str3) {
        this.b = ck0Var;
        this.c = webView;
        this.d = str;
        this.f = str2;
        this.h = str3;
    }
}
