package sensei0;

import android.webkit.ValueCallback;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ac implements ValueCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ fp b;

    public /* synthetic */ ac(fp fpVar, int i) {
        this.a = i;
        this.b = fpVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.a) {
            case 0:
                h00 h00Var = (h00) this.b;
                wf0.c(1, h00Var);
                h00Var.g(new v50((Boolean) obj));
                break;
            default:
                h00 h00Var2 = (h00) this.b;
                wf0.c(1, h00Var2);
                h00Var2.g(new v50((String) obj));
                break;
        }
    }
}
