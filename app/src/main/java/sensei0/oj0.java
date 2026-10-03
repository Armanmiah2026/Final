package sensei0;

import android.webkit.JsResult;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oj0 implements fp {
    public final /* synthetic */ int a;
    public final /* synthetic */ qj0 b;
    public final /* synthetic */ JsResult c;

    public /* synthetic */ oj0(qj0 qj0Var, JsResult jsResult, int i) {
        this.a = i;
        this.b = qj0Var;
        this.c = jsResult;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        w50 w50Var = (w50) obj;
        switch (this.a) {
            case 0:
                if (!w50Var.d) {
                    boolean zEquals = Boolean.TRUE.equals(w50Var.b);
                    JsResult jsResult = this.c;
                    if (!zEquals) {
                        jsResult.cancel();
                    } else {
                        jsResult.confirm();
                    }
                } else {
                    g30 g30Var = this.b.b.a;
                    Throwable th = w50Var.c;
                    Objects.requireNonNull(th);
                    g30Var.getClass();
                    g30.b(th);
                }
                break;
            default:
                if (!w50Var.d) {
                    this.c.confirm();
                } else {
                    g30 g30Var2 = this.b.b.a;
                    Throwable th2 = w50Var.c;
                    Objects.requireNonNull(th2);
                    g30Var2.getClass();
                    g30.b(th2);
                }
                break;
        }
        return null;
    }
}
