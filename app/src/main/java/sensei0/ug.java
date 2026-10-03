package sensei0;

import android.webkit.DownloadListener;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ug implements DownloadListener {
    public final c9 a;

    public ug(c9 c9Var) {
        this.a = c9Var;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j) {
        this.a.a.c(new Runnable() { // from class: sensei0.tg
            @Override // java.lang.Runnable
            public final void run() {
                ug ugVar = this.a;
                c9 c9Var = ugVar.a;
                a3 a3Var = new a3(1);
                String str5 = str;
                pr.j("urlArg", str5);
                String str6 = str2;
                pr.j("userAgentArg", str6);
                String str7 = str3;
                pr.j("contentDispositionArg", str7);
                String str8 = str4;
                pr.j("mimetypeArg", str8);
                g30 g30Var = c9Var.a;
                g30Var.getClass();
                new j1(g30Var.a, "dev.flutter.pigeon.webview_flutter_android.DownloadListener.onDownloadStart", g30Var.a(), null).k(p9.f0(ugVar, str5, str6, str7, str8, Long.valueOf(j)), new b0(14, a3Var));
            }
        });
    }
}
