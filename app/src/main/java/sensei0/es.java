package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class es extends ls {
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es() {
        super(true);
        boolean z = true;
        G(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ls.b;
        i8 i8Var = (i8) atomicReferenceFieldUpdater.get(this);
        j8 j8Var = i8Var instanceof j8 ? (j8) i8Var : null;
        if (j8Var == null) {
            z = false;
            break;
        }
        ls lsVarK = j8Var.k();
        while (!lsVarK.A()) {
            i8 i8Var2 = (i8) atomicReferenceFieldUpdater.get(lsVarK);
            j8 j8Var2 = i8Var2 instanceof j8 ? (j8) i8Var2 : null;
            if (j8Var2 == null) {
                z = false;
                break;
            }
            lsVarK = j8Var2.k();
        }
        this.c = z;
    }

    @Override // sensei0.ls
    public final boolean A() {
        return this.c;
    }

    @Override // sensei0.ls
    public final boolean B() {
        return true;
    }
}
