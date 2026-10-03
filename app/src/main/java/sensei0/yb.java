package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yb extends l5 {
    public final lc b;
    public transient xb c;

    public yb(xb xbVar, lc lcVar) {
        super(xbVar);
        this.b = lcVar;
    }

    @Override // sensei0.xb
    public lc f() {
        lc lcVar = this.b;
        pr.f(lcVar);
        return lcVar;
    }

    @Override // sensei0.l5
    public void o() {
        xb xbVar = this.c;
        if (xbVar != null && xbVar != this) {
            jc jcVarN = f().n(mh.c);
            pr.f(jcVarN);
            hg hgVar = (hg) xbVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = hg.p;
            while (atomicReferenceFieldUpdater.get(hgVar) == pr.c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(hgVar);
            f7 f7Var = obj instanceof f7 ? (f7) obj : null;
            if (f7Var != null) {
                f7Var.q();
            }
        }
        this.c = fa.b;
    }

    public yb(xb xbVar) {
        this(xbVar, xbVar != null ? xbVar.f() : null);
    }
}
