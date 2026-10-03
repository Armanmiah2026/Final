package sensei0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ls implements bs, rz {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ls.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ls.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public ls(boolean z) {
        this._state$volatile = z ? xe.m : xe.l;
    }

    public static j8 L(xu xuVar) {
        while (xuVar.j()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = xu.b;
            xu xuVarF = xuVar.f();
            if (xuVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(xuVar);
                while (true) {
                    xuVar = (xu) obj;
                    if (!xuVar.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(xuVar);
                }
            } else {
                xuVar = xuVarF;
            }
        }
        while (true) {
            xuVar = xuVar.i();
            if (!xuVar.j()) {
                if (xuVar instanceof j8) {
                    return (j8) xuVar;
                }
                if (xuVar instanceof sy) {
                    return null;
                }
            }
        }
    }

    public static String R(Object obj) {
        if (!(obj instanceof js)) {
            return obj instanceof wq ? ((wq) obj).a() ? "Active" : "New" : obj instanceof ga ? "Cancelled" : "Completed";
        }
        js jsVar = (js) obj;
        return jsVar.d() ? "Cancelling" : jsVar.f() ? "Completing" : "Active";
    }

    public boolean A() {
        return true;
    }

    public boolean B() {
        return this instanceof da;
    }

    public final sy C(wq wqVar) {
        sy syVarE = wqVar.e();
        if (syVarE != null) {
            return syVarE;
        }
        if (wqVar instanceof mi) {
            return new sy();
        }
        if (wqVar instanceof gs) {
            P((gs) wqVar);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + wqVar).toString());
    }

    public final Object D() {
        while (true) {
            Object obj = a.get(this);
            if (!(obj instanceof bz)) {
                return obj;
            }
            ((bz) obj).a(this);
        }
    }

    public boolean E(Throwable th) {
        return false;
    }

    public final void G(bs bsVar) {
        int iQ;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        ty tyVar = ty.a;
        if (bsVar == null) {
            atomicReferenceFieldUpdater.set(this, tyVar);
            return;
        }
        ls lsVar = (ls) bsVar;
        do {
            iQ = lsVar.Q(lsVar.D());
            if (iQ == 0) {
                break;
            }
        } while (iQ != 1);
        i8 i8Var = (i8) mm0.G(lsVar, true, new j8(this), 2);
        atomicReferenceFieldUpdater.set(this, i8Var);
        if (D() instanceof wq) {
            return;
        }
        i8Var.b();
        atomicReferenceFieldUpdater.set(this, tyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.ng H(boolean r9, boolean r10, sensei0.or r11) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ls.H(boolean, boolean, sensei0.or):sensei0.ng");
    }

    public boolean I() {
        return this instanceof b6;
    }

    public final boolean J(Object obj) {
        Object objS;
        do {
            objS = S(D(), obj);
            if (objS == xe.g) {
                return false;
            }
            if (objS == xe.h) {
                return true;
            }
        } while (objS == xe.i);
        p(objS);
        return true;
    }

    public final Object K(Object obj) {
        Object objS;
        do {
            objS = S(D(), obj);
            if (objS == xe.g) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                ga gaVar = obj instanceof ga ? (ga) obj : null;
                throw new IllegalStateException(str, gaVar != null ? gaVar.a : null);
            }
        } while (objS == xe.i);
        return objS;
    }

    public final void M(sy syVar, Throwable th) {
        Object objH = syVar.h();
        pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", objH);
        ia iaVar = null;
        for (xu xuVarI = (xu) objH; !xuVarI.equals(syVar); xuVarI = xuVarI.i()) {
            if (xuVarI instanceof ds) {
                gs gsVar = (gs) xuVarI;
                try {
                    gsVar.d(th);
                } catch (Throwable th2) {
                    if (iaVar != null) {
                        wf0.a(iaVar, th2);
                    } else {
                        iaVar = new ia("Exception in completion handler " + gsVar + " for " + this, th2);
                    }
                }
            }
        }
        if (iaVar != null) {
            F(iaVar);
        }
        t(th);
    }

    public final void P(gs gsVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        sy syVar = new sy();
        gsVar.getClass();
        xu.b.set(syVar, gsVar);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = xu.a;
        atomicReferenceFieldUpdater2.set(syVar, gsVar);
        loop0: while (true) {
            if (gsVar.h() == gsVar) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(gsVar, gsVar, syVar)) {
                    if (atomicReferenceFieldUpdater2.get(gsVar) != gsVar) {
                        break;
                    }
                }
                syVar.g(gsVar);
                break loop0;
            }
            break;
        }
        xu xuVarI = gsVar.i();
        do {
            atomicReferenceFieldUpdater = a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, gsVar, xuVarI)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == gsVar);
    }

    public final int Q(Object obj) {
        boolean z = obj instanceof mi;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        if (z) {
            if (((mi) obj).a) {
                return 0;
            }
            mi miVar = xe.m;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, miVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof vq)) {
            return 0;
        }
        sy syVar = ((vq) obj).a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, syVar)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    public final Object S(Object obj, Object obj2) {
        if (!(obj instanceof wq)) {
            return xe.g;
        }
        if (((obj instanceof mi) || (obj instanceof gs)) && !(obj instanceof j8) && !(obj2 instanceof ga)) {
            wq wqVar = (wq) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            Object xqVar = obj2 instanceof wq ? new xq((wq) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, wqVar, xqVar)) {
                if (atomicReferenceFieldUpdater.get(this) != wqVar) {
                    return xe.i;
                }
            }
            N(obj2);
            w(wqVar, obj2);
            return obj2;
        }
        wq wqVar2 = (wq) obj;
        sy syVarC = C(wqVar2);
        if (syVarC == null) {
            return xe.i;
        }
        j8 j8VarL = null;
        js jsVar = wqVar2 instanceof js ? (js) wqVar2 : null;
        if (jsVar == null) {
            jsVar = new js(syVarC, null);
        }
        synchronized (jsVar) {
            if (jsVar.f()) {
                return xe.g;
            }
            js.b.set(jsVar, 1);
            if (jsVar != wqVar2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, wqVar2, jsVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != wqVar2) {
                        return xe.i;
                    }
                }
            }
            boolean zD = jsVar.d();
            ga gaVar = obj2 instanceof ga ? (ga) obj2 : null;
            if (gaVar != null) {
                jsVar.b(gaVar.a);
            }
            Throwable thC = jsVar.c();
            if (zD) {
                thC = null;
            }
            if (thC != null) {
                M(syVarC, thC);
            }
            j8 j8Var = wqVar2 instanceof j8 ? (j8) wqVar2 : null;
            if (j8Var == null) {
                sy syVarE = wqVar2.e();
                if (syVarE != null) {
                    j8VarL = L(syVarE);
                }
            } else {
                j8VarL = j8Var;
            }
            if (j8VarL != null) {
                while (mm0.G(j8VarL.e, false, new is(this, jsVar, j8VarL, obj2), 1) == ty.a) {
                    j8VarL = L(j8VarL);
                    if (j8VarL == null) {
                    }
                }
                return xe.h;
            }
            return y(jsVar, obj2);
        }
    }

    @Override // sensei0.bs
    public boolean a() {
        Object objD = D();
        return (objD instanceof wq) && ((wq) objD).a();
    }

    @Override // sensei0.bs
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new cs(u(), null, this);
        }
        s(cancellationException);
    }

    @Override // sensei0.lc
    public final lc c(kc kcVar) {
        return k6.J(this, kcVar);
    }

    @Override // sensei0.lc
    public final Object d(Object obj, jp jpVar) {
        return jpVar.c(obj, this);
    }

    @Override // sensei0.jc
    public final kc getKey() {
        return mh.p;
    }

    @Override // sensei0.lc
    public final lc j(lc lcVar) {
        pr.j("context", lcVar);
        return lcVar == oi.a ? this : (lc) lcVar.d(this, new y9(1));
    }

    @Override // sensei0.lc
    public final jc n(kc kcVar) {
        return k6.s(this, kcVar);
    }

    public final boolean o(wq wqVar, sy syVar, gs gsVar) {
        xu xuVarF;
        ks ksVar = new ks(gsVar, this, wqVar);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = xu.b;
            xuVarF = syVar.f();
            if (xuVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(syVar);
                while (true) {
                    xuVarF = (xu) obj;
                    if (!xuVarF.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(xuVarF);
                }
            }
            xu.b.set(gsVar, xuVarF);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = xu.a;
            atomicReferenceFieldUpdater2.set(gsVar, syVar);
            ksVar.c = syVar;
            while (!atomicReferenceFieldUpdater2.compareAndSet(xuVarF, syVar, ksVar)) {
                if (atomicReferenceFieldUpdater2.get(xuVarF) != syVar) {
                    break;
                }
            }
        }
        return ksVar.a(xuVarF) == null;
    }

    public void q(Object obj) {
        p(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[PHI: r0
      0x003a: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0008, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ls.r(java.lang.Object):boolean");
    }

    public void s(CancellationException cancellationException) {
        r(cancellationException);
    }

    public final boolean t(Throwable th) {
        if (I()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        i8 i8Var = (i8) b.get(this);
        return (i8Var == null || i8Var == ty.a) ? z : i8Var.c(th) || z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + R(D()) + '}');
        sb.append('@');
        sb.append(xe.o(this));
        return sb.toString();
    }

    public String u() {
        return "Job was cancelled";
    }

    public boolean v(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return r(th) && A();
    }

    public final void w(wq wqVar, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        i8 i8Var = (i8) atomicReferenceFieldUpdater.get(this);
        if (i8Var != null) {
            i8Var.b();
            atomicReferenceFieldUpdater.set(this, ty.a);
        }
        ia iaVar = null;
        ga gaVar = obj instanceof ga ? (ga) obj : null;
        Throwable th = gaVar != null ? gaVar.a : null;
        if (wqVar instanceof gs) {
            try {
                ((gs) wqVar).d(th);
                return;
            } catch (Throwable th2) {
                F(new ia("Exception in completion handler " + wqVar + " for " + this, th2));
                return;
            }
        }
        sy syVarE = wqVar.e();
        if (syVarE != null) {
            Object objH = syVarE.h();
            pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", objH);
            for (xu xuVarI = (xu) objH; !xuVarI.equals(syVarE); xuVarI = xuVarI.i()) {
                if (xuVarI instanceof gs) {
                    gs gsVar = (gs) xuVarI;
                    try {
                        gsVar.d(th);
                    } catch (Throwable th3) {
                        if (iaVar != null) {
                            wf0.a(iaVar, th3);
                        } else {
                            iaVar = new ia("Exception in completion handler " + gsVar + " for " + this, th3);
                        }
                    }
                }
            }
            if (iaVar != null) {
                F(iaVar);
            }
        }
    }

    public final Throwable x(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        ls lsVar = (ls) ((rz) obj);
        Object objD = lsVar.D();
        if (objD instanceof js) {
            thC = ((js) objD).c();
        } else if (objD instanceof ga) {
            thC = ((ga) objD).a;
        } else {
            if (objD instanceof wq) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objD).toString());
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new cs("Parent job is ".concat(R(objD)), thC, lsVar) : cancellationException;
    }

    public final Object y(js jsVar, Object obj) {
        Object obj2 = null;
        Throwable csVar = null;
        ga gaVar = obj instanceof ga ? (ga) obj : null;
        Throwable th = gaVar != null ? gaVar.a : null;
        synchronized (jsVar) {
            jsVar.d();
            ArrayList arrayListG = jsVar.g(th);
            if (!arrayListG.isEmpty()) {
                int size = arrayListG.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj3 = arrayListG.get(i);
                    i++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                csVar = (Throwable) obj2;
                if (csVar == null) {
                    csVar = (Throwable) arrayListG.get(0);
                }
            } else if (jsVar.d()) {
                csVar = new cs(u(), null, this);
            }
            if (csVar != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                int size2 = arrayListG.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj4 = arrayListG.get(i2);
                    i2++;
                    Throwable th2 = (Throwable) obj4;
                    if (th2 != csVar && th2 != csVar && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        wf0.a(csVar, th2);
                    }
                }
            }
        }
        if (csVar != null && csVar != th) {
            obj = new ga(csVar, false);
        }
        if (csVar != null && (t(csVar) || E(csVar))) {
            pr.g("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally", obj);
            ga.b.compareAndSet((ga) obj, 0, 1);
        }
        N(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object xqVar = obj instanceof wq ? new xq((wq) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, jsVar, xqVar) && atomicReferenceFieldUpdater.get(this) == jsVar) {
        }
        w(jsVar, obj);
        return obj;
    }

    public final CancellationException z() {
        CancellationException cancellationException;
        Object objD = D();
        if (!(objD instanceof js)) {
            if (objD instanceof wq) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objD instanceof ga)) {
                return new cs(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((ga) objD).a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new cs(u(), th, this) : cancellationException;
        }
        Throwable thC = ((js) objD).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = u();
        }
        return new cs(strConcat, thC, this);
    }

    public void F(ia iaVar) {
        throw iaVar;
    }

    public void N(Object obj) {
    }

    public void p(Object obj) {
    }

    public void O() {
    }
}
