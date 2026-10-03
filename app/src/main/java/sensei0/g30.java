package sensei0;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g30 {
    public final a6 a;
    public final v2 b;
    public b3 c;
    public Context d;
    public final bm e;

    public g30(a6 a6Var, Context context, bm bmVar) {
        pr.j("binaryMessenger", a6Var);
        this.a = a6Var;
        this.b = new v2(new sv(5, new z2(a6Var)));
        this.d = context;
        this.e = bmVar;
    }

    public static void b(Throwable th) {
        Log.e("WebChromeClientImpl", th.getClass().getSimpleName() + ", Message: " + th.getMessage() + ", Stacktrace: " + Log.getStackTraceString(th));
    }

    public final dx a() {
        if (this.c == null) {
            this.c = new b3(this);
        }
        b3 b3Var = this.c;
        pr.f(b3Var);
        return b3Var;
    }

    public final void c(Runnable runnable) {
        Context context = this.d;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
