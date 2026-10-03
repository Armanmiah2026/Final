package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ls implements xb, uc {
    public final lc c;

    public g(lc lcVar, boolean z) {
        super(z);
        G((bs) lcVar.n(mh.p));
        this.c = lcVar.j(this);
    }

    @Override // sensei0.ls
    public final void F(ia iaVar) {
        wf0.o(iaVar, this.c);
    }

    @Override // sensei0.ls
    public final void N(Object obj) {
        if (!(obj instanceof ga)) {
            U(obj);
        } else {
            ga gaVar = (ga) obj;
            T(gaVar.a, ga.b.get(gaVar) != 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(xc xcVar, g gVar, jp jpVar) {
        int iOrdinal = xcVar.ordinal();
        if (iOrdinal == 0) {
            wf0.F(jpVar, gVar, this);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                pr.D(((l5) jpVar).j(gVar, this)).h(mg0.a);
                return;
            }
            if (iOrdinal != 3) {
                throw new ia();
            }
            try {
                lc lcVar = this.c;
                Object objP = xe.P(lcVar, null);
                try {
                    wf0.c(2, jpVar);
                    Object objC = jpVar.c(gVar, this);
                    if (objC != vc.a) {
                        h(objC);
                    }
                } finally {
                    xe.C(lcVar, objP);
                }
            } catch (Throwable th) {
                h(wf0.i(th));
            }
        }
    }

    @Override // sensei0.xb
    public final lc f() {
        return this.c;
    }

    @Override // sensei0.uc
    public final lc g() {
        return this.c;
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        Throwable thA = v50.a(obj);
        if (thA != null) {
            obj = new ga(thA, false);
        }
        Object objK = K(obj);
        if (objK == xe.h) {
            return;
        }
        q(objK);
    }

    @Override // sensei0.ls
    public final String u() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void U(Object obj) {
    }

    public void T(Throwable th, boolean z) {
    }
}
