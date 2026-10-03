package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class g70 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(g70.class, Object.class, "head$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(g70.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(g70.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(g70.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(g70.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;
    public final se a;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public g70() {
        i70 i70Var = new i70(0L, null, 2);
        this.head$volatile = i70Var;
        this.tail$volatile = i70Var;
        this._availablePermits$volatile = 1;
        this.a = new se(2, this);
    }

    public final void a(jy jyVar) {
        Object objQ;
        i70 i70Var;
        f7 f7Var = jyVar.a;
        ky kyVar = jyVar.b;
        while (true) {
            int andDecrement = f.getAndDecrement(this);
            if (andDecrement <= 1) {
                mg0 mg0Var = mg0.a;
                if (andDecrement > 0) {
                    ky.g.set(kyVar, null);
                    f7Var.B(mg0Var, new iy(kyVar, jyVar, 0));
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                i70 i70Var2 = (i70) atomicReferenceFieldUpdater.get(this);
                long andIncrement = e.getAndIncrement(this);
                e70 e70Var = e70.p;
                long j = andIncrement / ((long) h70.f);
                while (true) {
                    objQ = k6.q(i70Var2, j, e70Var);
                    if (!k6.E(objQ)) {
                        d70 d70VarB = k6.B(objQ);
                        while (true) {
                            d70 d70Var = (d70) atomicReferenceFieldUpdater.get(this);
                            i70Var = i70Var2;
                            if (d70Var.c >= d70VarB.c) {
                                break;
                            }
                            if (!d70VarB.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, d70Var, d70VarB)) {
                                if (atomicReferenceFieldUpdater.get(this) != d70Var) {
                                    if (d70VarB.e()) {
                                        d70VarB.d();
                                    }
                                    i70Var2 = i70Var;
                                }
                            }
                            if (d70Var.e()) {
                                d70Var.d();
                            }
                        }
                    } else {
                        break;
                    }
                    i70Var2 = i70Var;
                }
                i70 i70Var3 = (i70) k6.B(objQ);
                AtomicReferenceArray atomicReferenceArray = i70Var3.e;
                int i = (int) (andIncrement % ((long) h70.f));
                while (!atomicReferenceArray.compareAndSet(i, null, jyVar)) {
                    if (atomicReferenceArray.get(i) != null) {
                        tn tnVar = h70.b;
                        tn tnVar2 = h70.c;
                        while (!atomicReferenceArray.compareAndSet(i, tnVar, tnVar2)) {
                            if (atomicReferenceArray.get(i) != tnVar) {
                                break;
                            }
                        }
                        ky.g.set(kyVar, null);
                        f7Var.B(mg0Var, new iy(kyVar, jyVar, 0));
                        return;
                    }
                }
                jyVar.a(i70Var3, i);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.g70.b():void");
    }
}
