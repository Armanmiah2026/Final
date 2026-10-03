package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pc extends h implements zb {
    public static final oc b = new oc(mh.c, nc.c);

    public pc() {
        super(mh.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (((sensei0.jc) r3.a.g(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (sensei0.mh.c == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        return sensei0.oi.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        return r2;
     */
    /* JADX WARN: Type inference failed for: r3v3, types: [sensei0.et, sensei0.fp] */
    @Override // sensei0.h, sensei0.lc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.lc c(sensei0.kc r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            sensei0.pr.j(r0, r3)
            boolean r0 = r3 instanceof sensei0.oc
            if (r0 == 0) goto L20
            sensei0.oc r3 = (sensei0.oc) r3
            sensei0.kc r0 = r2.a
            if (r0 == r3) goto L15
            sensei0.kc r1 = r3.b
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            sensei0.et r3 = r3.a
            java.lang.Object r3 = r3.g(r2)
            sensei0.jc r3 = (sensei0.jc) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            sensei0.mh r0 = sensei0.mh.c
            if (r0 != r3) goto L27
        L24:
            sensei0.oi r3 = sensei0.oi.a
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pc.c(sensei0.kc):sensei0.lc");
    }

    public abstract void e(lc lcVar, Runnable runnable);

    public boolean f() {
        return !(this instanceof ig0);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [sensei0.et, sensei0.fp] */
    @Override // sensei0.h, sensei0.lc
    public final jc n(kc kcVar) {
        jc jcVar;
        pr.j("key", kcVar);
        if (kcVar instanceof oc) {
            oc ocVar = (oc) kcVar;
            kc kcVar2 = this.a;
            if ((kcVar2 == ocVar || ocVar.b == kcVar2) && (jcVar = (jc) ocVar.a.g(this)) != null) {
                return jcVar;
            }
        } else if (mh.c == kcVar) {
            return this;
        }
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + xe.o(this);
    }
}
