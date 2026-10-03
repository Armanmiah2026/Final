package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import sensei0.e3;
import sensei0.r70;
import sensei0.tj0;
import sensei0.vj0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewActivity extends Activity {
    public static final /* synthetic */ int f = 0;
    public WebView c;
    public final r70 a = new r70(this, 1);
    public final tj0 b = new tj0();
    public final IntentFilter d = new IntentFilter("close action");

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Map<String, String> map;
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.c = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        Bundle bundleExtra = intent.getBundleExtra("com.android.browser.headers");
        if (bundleExtra == null) {
            map = Collections.EMPTY_MAP;
        } else {
            HashMap map2 = new HashMap();
            for (String str : bundleExtra.keySet()) {
                map2.put(str, bundleExtra.getString(str));
            }
            map = map2;
        }
        this.c.loadUrl(stringExtra, map);
        this.c.getSettings().setJavaScriptEnabled(booleanExtra);
        this.c.getSettings().setDomStorageEnabled(booleanExtra2);
        this.c.setWebViewClient(this.b);
        this.c.getSettings().setSupportMultipleWindows(true);
        this.c.setWebChromeClient(new vj0(this));
        int i = Build.VERSION.SDK_INT;
        r70 r70Var = this.a;
        IntentFilter intentFilter = this.d;
        if (i >= 33) {
            e3.e(this, r70Var, intentFilter);
        } else if (i >= 26) {
            e3.d(this, r70Var, intentFilter);
        } else {
            registerReceiver(r70Var, intentFilter, null, null);
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.a);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.c.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.c.goBack();
        return true;
    }
}
