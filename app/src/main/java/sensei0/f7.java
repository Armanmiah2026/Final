package sensei0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class f7 extends jg implements e7, wc, kj0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(f7.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(f7.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(f7.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public final xb d;
    public final lc f;

    public f7(int i, xb xbVar) {
        super(i);
        this.d = xbVar;
        this.f = xbVar.f();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = k2.a;
    }

    public static Object D(uy uyVar, Object obj, int i, fp fpVar) {
        if (obj instanceof ga) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (fpVar != null || (uyVar instanceof og)) {
            return new ea(obj, uyVar instanceof og ? (og) uyVar : null, fpVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void y(uy uyVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + uyVar + ", already has " + obj).toString());
    }

    public final void A() {
        xb xbVar = this.d;
        Throwable th = null;
        hg hgVar = xbVar instanceof hg ? (hg) xbVar : null;
        if (hgVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = hg.p;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hgVar);
                tn tnVar = pr.c;
                if (obj == tnVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hgVar, tnVar, this)) {
                        if (atomicReferenceFieldUpdater.get(hgVar) != tnVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hgVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hgVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            q();
            p(th);
        }
    }

    public final void B(Object obj, fp fpVar) {
        C(obj, this.c, fpVar);
    }

    public final void C(Object obj, int i, fp fpVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof uy) {
                Object objD = D((uy) obj2, obj, i, fpVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objD)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!x()) {
                    q();
                }
                r(i);
                return;
            }
            if (obj2 instanceof g7) {
                g7 g7Var = (g7) obj2;
                if (g7.c.compareAndSet(g7Var, 0, 1)) {
                    if (fpVar != null) {
                        n(fpVar, g7Var.a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    @Override // sensei0.kj0
    public final void a(d70 d70Var, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = h;
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        w(d70Var);
    }

    @Override // sensei0.jg
    public final void b(Object obj, CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof uy) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof ga) {
                return;
            }
            if (!(obj2 instanceof ea)) {
                cancellationException2 = cancellationException;
                ea eaVar = new ea(obj2, (og) null, (fp) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, eaVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            ea eaVar2 = (ea) obj2;
            if (eaVar2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            ea eaVarA = ea.a(eaVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, eaVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    cancellationException2 = cancellationException;
                }
            }
            og ogVar = eaVar2.b;
            if (ogVar != null) {
                k(ogVar);
            }
            fp fpVar = eaVar2.c;
            if (fpVar != null) {
                n(fpVar, cancellationException);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // sensei0.jg
    public final xb c() {
        return this.d;
    }

    @Override // sensei0.jg
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // sensei0.wc
    public final wc e() {
        xb xbVar = this.d;
        if (xbVar instanceof wc) {
            return (wc) xbVar;
        }
        return null;
    }

    @Override // sensei0.xb
    public final lc f() {
        return this.f;
    }

    @Override // sensei0.jg
    public final Object g(Object obj) {
        return obj instanceof ea ? ((ea) obj).a : obj;
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        Throwable thA = v50.a(obj);
        if (thA != null) {
            obj = new ga(thA, false);
        }
        C(obj, this.c, null);
    }

    @Override // sensei0.jg
    public final Object j() {
        return o.get(this);
    }

    public final void k(og ogVar) {
        try {
            ogVar.a.b();
        } catch (Throwable th) {
            wf0.o(new ia("Exception in invokeOnCancellation handler for " + this, th), this.f);
        }
    }

    @Override // sensei0.e7
    public final tn l(Object obj, fp fpVar) {
        tn tnVar = pr.a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof uy)) {
                return null;
            }
            Object objD = D((uy) obj2, obj, this.c, fpVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objD)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!x()) {
                q();
            }
            return tnVar;
        }
    }

    @Override // sensei0.e7
    public final void m(Object obj) {
        r(this.c);
    }

    public final void n(fp fpVar, Throwable th) {
        try {
            fpVar.g(th);
        } catch (Throwable th2) {
            wf0.o(new ia("Exception in resume onCancellation handler for " + this, th2), this.f);
        }
    }

    public final void o(d70 d70Var, Throwable th) {
        lc lcVar = this.f;
        int i = h.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            d70Var.g(i, lcVar);
        } catch (Throwable th2) {
            wf0.o(new ia("Exception in invokeOnCancellation handler for " + this, th2), lcVar);
        }
    }

    public final void p(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof uy) {
                g7 g7Var = new g7(this, th, (obj instanceof og) || (obj instanceof d70));
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, g7Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                uy uyVar = (uy) obj;
                if (uyVar instanceof og) {
                    k((og) obj);
                } else if (uyVar instanceof d70) {
                    o((d70) obj, th);
                }
                if (!x()) {
                    q();
                }
                r(this.c);
                return;
            }
            return;
        }
    }

    public final void q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p;
        ng ngVar = (ng) atomicReferenceFieldUpdater.get(this);
        if (ngVar == null) {
            return;
        }
        ngVar.b();
        atomicReferenceFieldUpdater.set(this, ty.a);
    }

    public final void r(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = h;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i == 4;
                xb xbVar = this.d;
                if (!z && (xbVar instanceof hg)) {
                    boolean z2 = i == 1 || i == 2;
                    int i4 = this.c;
                    if (z2 == (i4 == 1 || i4 == 2)) {
                        hg hgVar = (hg) xbVar;
                        pc pcVar = hgVar.d;
                        lc lcVarF = hgVar.f.f();
                        if (pcVar.f()) {
                            pcVar.e(lcVarF, this);
                            return;
                        }
                        dj djVarA = ie0.a();
                        if (djVarA.c < 4294967296L) {
                            djVarA.i(true);
                            try {
                                xe.D(this, xbVar, true);
                                do {
                                } while (djVarA.l());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                            return;
                        }
                        r4 r4Var = djVarA.f;
                        if (r4Var == null) {
                            r4Var = new r4();
                            djVarA.f = r4Var;
                        }
                        r4Var.addLast(this);
                        return;
                    }
                }
                xe.D(this, xbVar, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    public Throwable s(ls lsVar) {
        return lsVar.z();
    }

    public final Object t() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        bs bsVar;
        boolean zX = x();
        do {
            atomicIntegerFieldUpdater = h;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zX) {
                    A();
                }
                Object obj = o.get(this);
                if (obj instanceof ga) {
                    throw ((ga) obj).a;
                }
                int i3 = this.c;
                if ((i3 != 1 && i3 != 2) || (bsVar = (bs) this.f.n(mh.p)) == null || bsVar.a()) {
                    return g(obj);
                }
                CancellationException cancellationExceptionZ = ((ls) bsVar).z();
                b(obj, cancellationExceptionZ);
                throw cancellationExceptionZ;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((ng) p.get(this)) == null) {
            v();
        }
        if (zX) {
            A();
        }
        return vc.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(z());
        sb.append('(');
        sb.append(xe.N(this.d));
        sb.append("){");
        Object obj = o.get(this);
        sb.append(obj instanceof uy ? "Active" : obj instanceof g7 ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(xe.o(this));
        return sb.toString();
    }

    public final void u() {
        ng ngVarV = v();
        if (ngVarV == null || (o.get(this) instanceof uy)) {
            return;
        }
        ngVarV.b();
        p.set(this, ty.a);
    }

    public final ng v() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        bs bsVar = (bs) this.f.n(mh.p);
        if (bsVar == null) {
            return null;
        }
        ng ngVarG = mm0.G(bsVar, true, new h8(this), 2);
        do {
            atomicReferenceFieldUpdater = p;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, ngVarG)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return ngVarG;
    }

    public final void w(uy uyVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof k2) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, uyVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            boolean z = true;
            if (obj instanceof og ? true : obj instanceof d70) {
                y(uyVar, obj);
                throw null;
            }
            if (obj instanceof ga) {
                ga gaVar = (ga) obj;
                if (!ga.b.compareAndSet(gaVar, 0, 1)) {
                    y(uyVar, obj);
                    throw null;
                }
                if (obj instanceof g7) {
                    Throwable th = gaVar.a;
                    if (uyVar instanceof og) {
                        k((og) uyVar);
                        return;
                    } else {
                        o((d70) uyVar, th);
                        return;
                    }
                }
                return;
            }
            if (obj instanceof ea) {
                ea eaVar = (ea) obj;
                if (eaVar.b != null) {
                    y(uyVar, obj);
                    throw null;
                }
                if (uyVar instanceof d70) {
                    return;
                }
                og ogVar = (og) uyVar;
                if (eaVar.e != null) {
                    k(ogVar);
                    return;
                }
                ea eaVarA = ea.a(eaVar, ogVar, null, 29);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, eaVarA)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return;
                }
            } else {
                if (uyVar instanceof d70) {
                    return;
                }
                ea eaVar2 = new ea(obj, (og) uyVar, (fp) null, (CancellationException) null, 28);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, eaVar2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return;
                }
            }
        }
    }

    public final boolean x() {
        if (this.c != 2) {
            return false;
        }
        xb xbVar = this.d;
        pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", xbVar);
        return hg.p.get((hg) xbVar) != null;
    }

    public String z() {
        return "CancellableContinuation";
    }
}
