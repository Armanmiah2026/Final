package sensei0;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b3 extends lx {
    public static final /* synthetic */ int i = 0;
    public final g30 h;

    public b3(g30 g30Var) {
        super(3);
        this.h = g30Var;
    }

    @Override // sensei0.lx, sensei0.rb0
    public final Object f(byte b, ByteBuffer byteBuffer) {
        pr.j("buffer", byteBuffer);
        if (b != -128) {
            return super.f(b, byteBuffer);
        }
        Object objE = e(byteBuffer);
        pr.g("null cannot be cast to non-null type kotlin.Long", objE);
        long jLongValue = ((Long) objE).longValue();
        Object objE2 = this.h.b.e(jLongValue);
        if (objE2 == null) {
            Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + jLongValue);
        }
        return objE2;
    }

    @Override // sensei0.lx, sensei0.rb0
    public final void k(qb0 qb0Var, Object obj) {
        String str;
        g30 g30Var = this.h;
        a6 a6Var = g30Var.a;
        v2 v2Var = g30Var.b;
        if ((obj instanceof Boolean) || (obj instanceof byte[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof float[]) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof List) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Map) || (obj instanceof String) || (obj instanceof mk) || (obj instanceof qa) || (obj instanceof nz) || (obj instanceof hb0) || (obj instanceof vx) || obj == null) {
            super.k(qb0Var, obj);
            return;
        }
        if (obj instanceof WebResourceRequest) {
            WebResourceRequest webResourceRequest = (WebResourceRequest) obj;
            a3 a3Var = new a3(0);
            if (!v2Var.d(webResourceRequest)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(webResourceRequest)), webResourceRequest.getUrl().toString(), Boolean.valueOf(webResourceRequest.isForMainFrame()), Boolean.valueOf(webResourceRequest.isRedirect()), Boolean.valueOf(webResourceRequest.hasGesture()), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders() == null ? Collections.EMPTY_MAP : webResourceRequest.getRequestHeaders()), new m00(12, a3Var));
            }
        } else if (obj instanceof WebResourceResponse) {
            WebResourceResponse webResourceResponse = (WebResourceResponse) obj;
            a3 a3Var2 = new a3(0);
            if (!v2Var.d(webResourceResponse)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebResourceResponse.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(webResourceResponse)), Long.valueOf(webResourceResponse.getStatusCode())), new m00(13, a3Var2));
            }
        } else if (obj instanceof WebResourceError) {
            WebResourceError webResourceError = (WebResourceError) obj;
            a3 a3Var3 = new a3(0);
            if (!v2Var.d(webResourceError)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebResourceError.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(webResourceError)), Long.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription().toString()), new m00(10, a3Var3));
            }
        } else if (obj instanceof rj0) {
            rj0 rj0Var = (rj0) obj;
            a3 a3Var4 = new a3(0);
            if (!v2Var.d(rj0Var)) {
                long jB = v2Var.b(rj0Var);
                gk0.b.getClass();
                if (rj0Var.a == null) {
                    rj0Var.a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) ik0.a.a).convertWebResourceError(Proxy.getInvocationHandler(null));
                }
                long errorCode = rj0Var.a.getErrorCode();
                gk0.a.getClass();
                if (rj0Var.a == null) {
                    rj0Var.a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) ik0.a.a).convertWebResourceError(Proxy.getInvocationHandler(null));
                }
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebResourceErrorCompat.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(jB), Long.valueOf(errorCode), rj0Var.a.getDescription().toString()), new m00(11, a3Var4));
            }
        } else if (obj instanceof kk0) {
            kk0 kk0Var = (kk0) obj;
            a3 a3Var5 = new a3(0);
            if (!v2Var.d(kk0Var)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebViewPoint.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(kk0Var)), Long.valueOf(kk0Var.a), Long.valueOf(kk0Var.b)), new m00(23, a3Var5));
            }
        } else if (obj instanceof ConsoleMessage) {
            ConsoleMessage consoleMessage = (ConsoleMessage) obj;
            a3 a3Var6 = new a3(0);
            if (!v2Var.d(consoleMessage)) {
                long jB2 = v2Var.b(consoleMessage);
                long jLineNumber = consoleMessage.lineNumber();
                String strMessage = consoleMessage.message();
                int i2 = ra.a[consoleMessage.messageLevel().ordinal()];
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.ConsoleMessage.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(jB2), Long.valueOf(jLineNumber), strMessage, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? qa.p : qa.c : qa.d : qa.o : qa.f : qa.h, consoleMessage.sourceId()), new b0(10, a3Var6));
            }
        } else if (obj instanceof CookieManager) {
            CookieManager cookieManager = (CookieManager) obj;
            a3 a3Var7 = new a3(0);
            if (!v2Var.d(cookieManager)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(cookieManager))), new b0(11, a3Var7));
            }
        } else if (obj instanceof WebView) {
            WebView webView = (WebView) obj;
            a3 a3Var8 = new a3(0);
            if (!v2Var.d(webView)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(webView))), new m00(18, a3Var8));
            }
        } else if (obj instanceof WebSettings) {
            WebSettings webSettings = (WebSettings) obj;
            a3 a3Var9 = new a3(0);
            if (!v2Var.d(webSettings)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(webSettings))), new m00(14, a3Var9));
            }
        } else if (obj instanceof zr) {
            if (!v2Var.d((zr) obj)) {
                str = "Attempting to create a new Dart instance of JavaScriptChannel, but the class has a nonnull callback method.";
                za0.r("new-instance-error", str, "");
            }
        } else if (obj instanceof WebViewClient) {
            WebViewClient webViewClient = (WebViewClient) obj;
            a3 a3Var10 = new a3(0);
            if (!v2Var.d(webViewClient)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebViewClient.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(webViewClient))), new m00(20, a3Var10));
            }
        } else if (obj instanceof DownloadListener) {
            if (!v2Var.d((DownloadListener) obj)) {
                str = "Attempting to create a new Dart instance of DownloadListener, but the class has a nonnull callback method.";
                za0.r("new-instance-error", str, "");
            }
        } else if (obj instanceof qj0) {
            if (!v2Var.d((qj0) obj)) {
                str = "Attempting to create a new Dart instance of WebChromeClient, but the class has a nonnull callback method.";
                za0.r("new-instance-error", str, "");
            }
        } else if (obj instanceof bm) {
            bm bmVar = (bm) obj;
            a3 a3Var11 = new a3(0);
            if (!v2Var.d(bmVar)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(bmVar))), new b0(16, a3Var11));
            }
        } else if (obj instanceof WebStorage) {
            WebStorage webStorage = (WebStorage) obj;
            a3 a3Var12 = new a3(0);
            if (!v2Var.d(webStorage)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebStorage.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(webStorage))), new m00(16, a3Var12));
            }
        } else if (obj instanceof WebChromeClient.FileChooserParams) {
            WebChromeClient.FileChooserParams fileChooserParams = (WebChromeClient.FileChooserParams) obj;
            a3 a3Var13 = new a3(0);
            if (!v2Var.d(fileChooserParams)) {
                long jB3 = v2Var.b(fileChooserParams);
                boolean zIsCaptureEnabled = fileChooserParams.isCaptureEnabled();
                List listAsList = Arrays.asList(fileChooserParams.getAcceptTypes());
                int mode = fileChooserParams.getMode();
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.FileChooserParams.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(jB3), Boolean.valueOf(zIsCaptureEnabled), listAsList, mode != 0 ? mode != 1 ? mode != 3 ? mk.h : mk.f : mk.d : mk.c, fileChooserParams.getFilenameHint()), new b0(15, a3Var13));
            }
        } else if (obj instanceof PermissionRequest) {
            PermissionRequest permissionRequest = (PermissionRequest) obj;
            a3 a3Var14 = new a3(0);
            if (!v2Var.d(permissionRequest)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(permissionRequest)), Arrays.asList(permissionRequest.getResources())), new b0(21, a3Var14));
            }
        } else if (obj instanceof WebChromeClient.CustomViewCallback) {
            WebChromeClient.CustomViewCallback customViewCallback = (WebChromeClient.CustomViewCallback) obj;
            a3 a3Var15 = new a3(0);
            if (!v2Var.d(customViewCallback)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.CustomViewCallback.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(customViewCallback))), new b0(12, a3Var15));
            }
        } else if (obj instanceof View) {
            View view = (View) obj;
            a3 a3Var16 = new a3(0);
            if (!v2Var.d(view)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(view))), new m00(2, a3Var16));
            }
        } else if (obj instanceof GeolocationPermissions.Callback) {
            GeolocationPermissions.Callback callback = (GeolocationPermissions.Callback) obj;
            a3 a3Var17 = new a3(0);
            if (!v2Var.d(callback)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.GeolocationPermissionsCallback.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(callback))), new b0(17, a3Var17));
            }
        } else if (obj instanceof HttpAuthHandler) {
            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj;
            a3 a3Var18 = new a3(0);
            if (!v2Var.d(httpAuthHandler)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(httpAuthHandler))), new b0(19, a3Var18));
            }
        } else if (obj instanceof Message) {
            Message message = (Message) obj;
            a3 a3Var19 = new a3(0);
            if (!v2Var.d(message)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(message))), new b0(5, a3Var19));
            }
        } else if (obj instanceof ClientCertRequest) {
            ClientCertRequest clientCertRequest = (ClientCertRequest) obj;
            a3 a3Var20 = new a3(0);
            if (!v2Var.d(clientCertRequest)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(clientCertRequest))), new b0(9, a3Var20));
            }
        } else if (obj instanceof PrivateKey) {
            PrivateKey privateKey = (PrivateKey) obj;
            a3 a3Var21 = new a3(0);
            if (!v2Var.d(privateKey)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.PrivateKey.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(privateKey))), new b0(24, a3Var21));
            }
        } else if (obj instanceof X509Certificate) {
            X509Certificate x509Certificate = (X509Certificate) obj;
            a3 a3Var22 = new a3(0);
            if (!v2Var.d(x509Certificate)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.X509Certificate.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(x509Certificate))), new m00(24, a3Var22));
            }
        } else if (obj instanceof SslErrorHandler) {
            SslErrorHandler sslErrorHandler = (SslErrorHandler) obj;
            a3 a3Var23 = new a3(0);
            if (!v2Var.d(sslErrorHandler)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslErrorHandler.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(sslErrorHandler))), new b0(29, a3Var23));
            }
        } else if (obj instanceof SslError) {
            SslError sslError = (SslError) obj;
            a3 a3Var24 = new a3(0);
            if (!v2Var.d(sslError)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslError.pigeon_newInstance", g30Var.a(), null).k(p9.f0(Long.valueOf(v2Var.b(sslError)), sslError.getCertificate(), sslError.getUrl()), new b0(27, a3Var24));
            }
        } else if (obj instanceof SslCertificate.DName) {
            SslCertificate.DName dName = (SslCertificate.DName) obj;
            a3 a3Var25 = new a3(0);
            if (!v2Var.d(dName)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificateDName.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(dName))), new b0(26, a3Var25));
            }
        } else if (obj instanceof SslCertificate) {
            SslCertificate sslCertificate = (SslCertificate) obj;
            a3 a3Var26 = new a3(0);
            if (!v2Var.d(sslCertificate)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.SslCertificate.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(sslCertificate))), new b0(25, a3Var26));
            }
        } else if (obj instanceof Certificate) {
            Certificate certificate = (Certificate) obj;
            a3 a3Var27 = new a3(0);
            if (!v2Var.d(certificate)) {
                new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.Certificate.pigeon_newInstance", g30Var.a(), null).k(k6.G(Long.valueOf(v2Var.b(certificate))), new b0(7, a3Var27));
            }
        }
        if (v2Var.d(obj)) {
            qb0Var.write(128);
            v2Var.f();
            Long l = (Long) v2Var.b.get(obj);
            if (l != null) {
                v2Var.d.put(l, obj);
            }
            k(qb0Var, l);
            return;
        }
        throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass().getName() + "'");
    }
}
