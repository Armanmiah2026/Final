package sensei0;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qh extends mm0 {
    public final /* synthetic */ fy l;

    public qh(fy fyVar) {
        this.l = fyVar;
    }

    @Override // sensei0.mm0
    public final void P(Throwable th) {
        ((uh) this.l.a).d(th);
    }

    @Override // sensei0.mm0
    public final void S(j1 j1Var) {
        fy fyVar = this.l;
        fyVar.c = j1Var;
        j1 j1Var2 = (j1) fyVar.c;
        uh uhVar = (uh) fyVar.a;
        fyVar.b = new o4(j1Var2, uhVar.g, uhVar.i, Build.VERSION.SDK_INT >= 34 ? ai.a() : k6.x());
        uh uhVar2 = (uh) fyVar.a;
        uhVar2.getClass();
        ArrayList arrayList = new ArrayList();
        uhVar2.a.writeLock().lock();
        try {
            uhVar2.c = 1;
            arrayList.addAll(uhVar2.b);
            uhVar2.b.clear();
            uhVar2.a.writeLock().unlock();
            uhVar2.d.post(new b7(arrayList, uhVar2.c, null));
        } catch (Throwable th) {
            uhVar2.a.writeLock().unlock();
            throw th;
        }
    }
}
