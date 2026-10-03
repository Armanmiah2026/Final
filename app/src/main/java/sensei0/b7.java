package sensei0;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b7 implements Runnable {
    public final /* synthetic */ int a = 1;
    public final int b;
    public final Object c;

    public b7(fb0 fb0Var, int i) {
        this.c = fb0Var;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                pr prVar = (pr) ((fb0) this.c).a;
                if (prVar != null) {
                    prVar.H(this.b);
                }
                break;
            default:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                int i = 0;
                if (this.b == 1) {
                    while (i < size) {
                        ((sh) arrayList.get(i)).b();
                        i++;
                    }
                } else {
                    while (i < size) {
                        ((sh) arrayList.get(i)).a();
                        i++;
                    }
                }
                break;
        }
    }

    public b7(List list, int i, Throwable th) {
        pr.h("initCallbacks cannot be null", list);
        this.c = new ArrayList(list);
        this.b = i;
    }
}
