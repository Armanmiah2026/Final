package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ky extends g70 implements hy {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(ky.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile = xe.n;

    public final Object c(yb ybVar) throws Throwable {
        boolean zD = d();
        mg0 mg0Var = mg0.a;
        if (!zD) {
            f7 f7VarZ = pr.z(pr.D(ybVar));
            try {
                a(new jy(this, f7VarZ));
                Object objT = f7VarZ.t();
                vc vcVar = vc.a;
                if (objT != vcVar) {
                    objT = mg0Var;
                }
                if (objT == vcVar) {
                    return objT;
                }
            } catch (Throwable th) {
                f7VarZ.A();
                throw th;
            }
        }
        return mg0Var;
    }

    public final boolean d() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g70.f;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 > 1) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > 1) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 1));
            } else {
                if (i2 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    g.set(this, null);
                    return true;
                }
            }
        }
    }

    public final void e(Object obj) {
        while (Math.max(g70.f.get(this), 0) == 0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            tn tnVar = xe.n;
            if (obj2 != tnVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, tnVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Mutex@");
        sb.append(xe.o(this));
        sb.append("[isLocked=");
        sb.append(Math.max(g70.f.get(this), 0) == 0);
        sb.append(",owner=");
        sb.append(g.get(this));
        sb.append(']');
        return sb.toString();
    }
}
