package sensei0;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k7 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ sw b;

    public /* synthetic */ k7(sw swVar, int i) {
        this.a = i;
        this.b = swVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.a) {
            case 0:
                o7 o7Var = (o7) this.b;
                ArrayList arrayList = o7Var.p;
                if (o7Var.h() && arrayList.size() > 0) {
                    int i = 0;
                    if (!((n7) arrayList.get(0)).a.C) {
                        View view = o7Var.w;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                ((n7) obj).a.b();
                            }
                        } else {
                            o7Var.dismiss();
                        }
                    }
                    break;
                }
                break;
            default:
                pb0 pb0Var = (pb0) this.b;
                yw ywVar = pb0Var.p;
                if (pb0Var.h() && !ywVar.C) {
                    View view2 = pb0Var.u;
                    if (view2 != null && view2.isShown()) {
                        ywVar.b();
                    } else {
                        pb0Var.dismiss();
                    }
                    break;
                }
                break;
        }
    }
}
