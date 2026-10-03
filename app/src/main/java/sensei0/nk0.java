package sensei0;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nk0 extends WebView implements e10 {
    public static final /* synthetic */ int d = 0;
    public final c9 a;
    public WebViewClient b;
    public nj0 c;

    public nk0(c9 c9Var) {
        super(c9Var.a.d);
        this.a = c9Var;
        this.b = new WebViewClient();
        this.c = new nj0();
        setWebViewClient(this.b);
        setWebChromeClient(this.c);
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        return this.c;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        nn nnVar;
        super.onAttachedToWindow();
        this.a.a.getClass();
        if (Build.VERSION.SDK_INT >= 26) {
            ViewParent parent = this;
            while (true) {
                if (parent.getParent() == null) {
                    nnVar = null;
                    break;
                }
                parent = parent.getParent();
                if (parent instanceof nn) {
                    nnVar = (nn) parent;
                    break;
                }
            }
            if (nnVar != null) {
                nnVar.setImportantForAutofill(1);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(final int i, final int i2, final int i3, final int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.a.a.c(new Runnable() { // from class: sensei0.mk0
            @Override // java.lang.Runnable
            public final void run() {
                nk0 nk0Var = this.a;
                c9 c9Var = nk0Var.a;
                long j = i;
                long j2 = i2;
                long j3 = i3;
                long j4 = i4;
                a3 a3Var = new a3(25);
                c9Var.getClass();
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged", g30Var.a(), null).k(p9.f0(nk0Var, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)), new m00(19, a3Var));
            }
        });
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        super.setWebChromeClient(webChromeClient);
        if (!(webChromeClient instanceof nj0)) {
            throw new AssertionError("Client must be a SecureWebChromeClient.");
        }
        nj0 nj0Var = (nj0) webChromeClient;
        this.c = nj0Var;
        nj0Var.a = this.b;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        this.b = webViewClient;
        this.c.a = webViewClient;
    }

    @Override // sensei0.e10
    public View getView() {
        return this;
    }
}
