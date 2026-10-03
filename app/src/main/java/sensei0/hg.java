package sensei0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hg extends jg implements wc, xb {
    public static final /* synthetic */ AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(hg.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final pc d;
    public final yb f;
    public Object h;
    public final Object o;

    public hg(pc pcVar, yb ybVar) {
        super(-1);
        this.d = pcVar;
        this.f = ybVar;
        this.h = pr.b;
        this.o = xe.M(ybVar.f());
    }

    @Override // sensei0.jg
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof ha) {
            throw null;
        }
    }

    @Override // sensei0.wc
    public final wc e() {
        yb ybVar = this.f;
        if (ybVar != null) {
            return ybVar;
        }
        return null;
    }

    @Override // sensei0.xb
    public final lc f() {
        return this.f.f();
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        yb ybVar = this.f;
        lc lcVarF = ybVar.f();
        Throwable thA = v50.a(obj);
        Object gaVar = thA == null ? obj : new ga(thA, false);
        pc pcVar = this.d;
        if (pcVar.f()) {
            this.h = gaVar;
            this.c = 0;
            pcVar.e(lcVarF, this);
            return;
        }
        dj djVarA = ie0.a();
        if (djVarA.c >= 4294967296L) {
            this.h = gaVar;
            this.c = 0;
            r4 r4Var = djVarA.f;
            if (r4Var == null) {
                r4Var = new r4();
                djVarA.f = r4Var;
            }
            r4Var.addLast(this);
            return;
        }
        djVarA.i(true);
        try {
            lc lcVarF2 = ybVar.f();
            Object objP = xe.P(lcVarF2, this.o);
            try {
                ybVar.h(obj);
                while (djVarA.l()) {
                }
            } finally {
                xe.C(lcVarF2, objP);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // sensei0.jg
    public final Object j() {
        Object obj = this.h;
        this.h = pr.b;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + xe.N(this.f) + ']';
    }

    @Override // sensei0.jg
    public final xb c() {
        return this;
    }
}
