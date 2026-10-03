package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m10 implements View.OnFocusChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ j10 c;

    public /* synthetic */ m10(j10 j10Var, int i, int i2) {
        this.a = i2;
        this.c = j10Var;
        this.b = i;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.a) {
            case 0:
                io.flutter.plugin.platform.c cVar = (io.flutter.plugin.platform.c) this.c;
                int i = this.b;
                if (!z) {
                    io.flutter.plugin.editing.b bVar = cVar.o;
                    if (bVar != null) {
                        bVar.b(i);
                    }
                    break;
                } else {
                    aj ajVar = (aj) cVar.p.b;
                    if (ajVar != null) {
                        ajVar.a("viewFocused", Integer.valueOf(i), null);
                        break;
                    }
                }
                break;
            default:
                q10 q10Var = (q10) this.c;
                int i2 = this.b;
                if (!z) {
                    io.flutter.plugin.editing.b bVar2 = q10Var.h;
                    if (bVar2 != null) {
                        bVar2.b(i2);
                    }
                    break;
                } else {
                    aj ajVar2 = (aj) q10Var.o.b;
                    if (ajVar2 != null) {
                        ajVar2.a("viewFocused", Integer.valueOf(i2), null);
                        break;
                    }
                }
                break;
        }
    }
}
