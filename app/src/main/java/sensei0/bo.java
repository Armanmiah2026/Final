package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bo implements kb {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bo(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.kb
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                co coVar = (co) obj;
                if (coVar == null) {
                    coVar = new co(-3);
                }
                ((i3) this.b).G(coVar);
                return;
            default:
                co coVar2 = (co) obj;
                synchronized (eo.c) {
                    try {
                        ka0 ka0Var = eo.d;
                        ArrayList arrayList = (ArrayList) ka0Var.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        ka0Var.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((kb) arrayList.get(i)).accept(coVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
