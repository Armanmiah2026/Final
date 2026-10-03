package sensei0;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class uj0 extends WebViewClient {
    public final /* synthetic */ vj0 a;

    public uj0(vj0 vj0Var) {
        this.a = vj0Var;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        this.a.a.c.loadUrl(webResourceRequest.getUrl().toString());
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.a.c.loadUrl(str);
        return true;
    }
}
