package sensei0;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.plugins.urllauncher.WebViewActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vj0 extends WebChromeClient {
    public final /* synthetic */ WebViewActivity a;

    public vj0(WebViewActivity webViewActivity) {
        this.a = webViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        uj0 uj0Var = new uj0(this);
        WebView webView2 = new WebView(this.a.c.getContext());
        webView2.setWebViewClient(uj0Var);
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }
}
