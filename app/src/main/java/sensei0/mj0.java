package sensei0;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mj0 extends WebViewClient {
    public final /* synthetic */ WebView a;
    public final /* synthetic */ nj0 b;

    public mj0(nj0 nj0Var, WebView webView) {
        this.b = nj0Var;
        this.a = webView;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient = this.b.a;
        WebView webView2 = this.a;
        if (webViewClient.shouldOverrideUrlLoading(webView2, webResourceRequest)) {
            return true;
        }
        webView2.loadUrl(webResourceRequest.getUrl().toString());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewClient webViewClient = this.b.a;
        WebView webView2 = this.a;
        if (webViewClient.shouldOverrideUrlLoading(webView2, str)) {
            return true;
        }
        webView2.loadUrl(str);
        return true;
    }
}
