package sensei0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yn implements th {
    public final Context a;
    public final xn b;
    public final pf c;
    public final Object d = new Object();
    public Handler f;
    public ThreadPoolExecutor h;
    public ThreadPoolExecutor o;
    public mm0 p;

    public yn(Context context, xn xnVar) {
        pr.h("Context cannot be null", context);
        this.a = context.getApplicationContext();
        this.b = xnVar;
        this.c = zn.d;
    }

    public final void a() {
        synchronized (this.d) {
            try {
                this.p = null;
                Handler handler = this.f;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f = null;
                ThreadPoolExecutor threadPoolExecutor = this.o;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.h = null;
                this.o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final jo b() {
        try {
            pf pfVar = this.c;
            Context context = this.a;
            xn xnVar = this.b;
            pfVar.getClass();
            Object[] objArr = {xnVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            i6 i6VarA = wn.a(context, Collections.unmodifiableList(arrayList));
            int i = i6VarA.a;
            if (i != 0) {
                throw new RuntimeException(za0.i(i, "fetchFonts failed (", ")"));
            }
            jo[] joVarArr = (jo[]) ((List) i6VarA.b).get(0);
            if (joVarArr == null || joVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return joVarArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }

    @Override // sensei0.th
    public final void u(mm0 mm0Var) {
        synchronized (this.d) {
            this.p = mm0Var;
        }
        synchronized (this.d) {
            try {
                if (this.p == null) {
                    return;
                }
                if (this.h == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ka("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.o = threadPoolExecutor;
                    this.h = threadPoolExecutor;
                }
                this.h.execute(new u2(7, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
