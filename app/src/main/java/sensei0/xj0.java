package sensei0;

import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xj0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ck0 b;
    public final /* synthetic */ WebView c;
    public final /* synthetic */ String d;

    public /* synthetic */ xj0(ck0 ck0Var, WebView webView, String str, int i) {
        this.a = i;
        this.b = ck0Var;
        this.c = webView;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ck0 ck0Var = this.b;
                c9 c9Var = ck0Var.a;
                a3 a3Var = new a3(24);
                c9Var.getClass();
                WebView webView = this.c;
                pr.j("webViewArg", webView);
                String str = this.d;
                pr.j("urlArg", str);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageStarted", g30Var.a(), null).k(p9.f0(ck0Var, webView, str), new s00(a3Var, 5));
                break;
            case 1:
                ck0 ck0Var2 = this.b;
                c9 c9Var2 = ck0Var2.a;
                a3 a3Var2 = new a3(24);
                c9Var2.getClass();
                WebView webView2 = this.c;
                pr.j("webViewArg", webView2);
                String str2 = this.d;
                pr.j("urlArg", str2);
                g30 g30Var2 = c9Var2.a;
                g30Var2.getClass();
                new j1(g30Var2.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.urlLoading", g30Var2.a(), null).k(p9.f0(ck0Var2, webView2, str2), new s00(a3Var2, 0));
                break;
            case 2:
                ck0 ck0Var3 = this.b;
                c9 c9Var3 = ck0Var3.a;
                a3 a3Var3 = new a3(24);
                c9Var3.getClass();
                WebView webView3 = this.c;
                pr.j("viewArg", webView3);
                String str3 = this.d;
                pr.j("urlArg", str3);
                g30 g30Var3 = c9Var3.a;
                g30Var3.getClass();
                new j1(g30Var3.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onLoadResource", g30Var3.a(), null).k(p9.f0(ck0Var3, webView3, str3), new s00(a3Var3, 3));
                break;
            case 3:
                ck0 ck0Var4 = this.b;
                c9 c9Var4 = ck0Var4.a;
                a3 a3Var4 = new a3(24);
                c9Var4.getClass();
                WebView webView4 = this.c;
                pr.j("webViewArg", webView4);
                String str4 = this.d;
                pr.j("urlArg", str4);
                g30 g30Var4 = c9Var4.a;
                g30Var4.getClass();
                new j1(g30Var4.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageFinished", g30Var4.a(), null).k(p9.f0(ck0Var4, webView4, str4), new s00(a3Var4, 9));
                break;
            default:
                ck0 ck0Var5 = this.b;
                c9 c9Var5 = ck0Var5.a;
                a3 a3Var5 = new a3(24);
                c9Var5.getClass();
                WebView webView5 = this.c;
                pr.j("viewArg", webView5);
                String str5 = this.d;
                pr.j("urlArg", str5);
                g30 g30Var5 = c9Var5.a;
                g30Var5.getClass();
                new j1(g30Var5.a, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageCommitVisible", g30Var5.a(), null).k(p9.f0(ck0Var5, webView5, str5), new s00(a3Var5, 8));
                break;
        }
    }
}
