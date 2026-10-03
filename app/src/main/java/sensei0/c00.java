package sensei0;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c00 implements X509TrustManager {
    public final /* synthetic */ int a;

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        int i = this.a;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        int i = this.a;
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        switch (this.a) {
            case 0:
                return null;
            default:
                return new X509Certificate[0];
        }
    }

    private final void a(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void b(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void c(X509Certificate[] x509CertificateArr, String str) {
    }

    private final void d(X509Certificate[] x509CertificateArr, String str) {
    }
}
