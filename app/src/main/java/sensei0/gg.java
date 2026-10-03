package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class gg extends wf {
    public int m;

    public gg(ok0 ok0Var) {
        super(ok0Var);
        if (ok0Var instanceof oq) {
            this.e = 2;
        } else {
            this.e = 3;
        }
    }

    @Override // sensei0.wf
    public final void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            uf ufVar = (uf) obj;
            ufVar.a(ufVar);
        }
    }
}
