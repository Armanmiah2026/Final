package sensei0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d70 extends na implements uy {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(d70.class, "cleanedAndPointers$volatile");
    public final long c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public d70(long j, d70 d70Var, int i) {
        super(d70Var);
        this.c = j;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // sensei0.na
    public final boolean c() {
        return d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, lc lcVar);

    public final void h() {
        if (d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, Proxy.SOCKS_NO_PROXY + i));
        return true;
    }
}
