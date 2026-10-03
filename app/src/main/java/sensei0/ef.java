package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ef implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ kf c;

    public /* synthetic */ ef(kf kfVar, ArrayList arrayList, int i) {
        this.a = i;
        this.c = kfVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ArrayList arrayList = this.b;
                int size = arrayList.size();
                kf kfVar = this.c;
                if (size <= 0) {
                    arrayList.clear();
                    kfVar.m.remove(arrayList);
                    return;
                } else {
                    ((jf) arrayList.get(0)).getClass();
                    kfVar.getClass();
                    throw null;
                }
            case 1:
                ArrayList arrayList2 = this.b;
                int size2 = arrayList2.size();
                int i = 0;
                while (true) {
                    kf kfVar2 = this.c;
                    if (i >= size2) {
                        arrayList2.clear();
                        kfVar2.n.remove(arrayList2);
                        return;
                    } else {
                        Object obj = arrayList2.get(i);
                        i++;
                        ArrayList arrayList3 = kfVar2.r;
                        ((hf) obj).getClass();
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.b;
                int size3 = arrayList4.size();
                kf kfVar3 = this.c;
                if (size3 <= 0) {
                    arrayList4.clear();
                    kfVar3.l.remove(arrayList4);
                    return;
                } else {
                    s40 s40Var = (s40) arrayList4.get(0);
                    kfVar3.getClass();
                    s40Var.getClass();
                    throw null;
                }
        }
    }
}
