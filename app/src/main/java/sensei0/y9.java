package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y9 implements jp {
    public final /* synthetic */ int a;

    public /* synthetic */ y9(int i) {
        this.a = i;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        z9 z9Var;
        switch (this.a) {
            case 0:
                String str = (String) obj;
                jc jcVar = (jc) obj2;
                pr.j("acc", str);
                pr.j("element", jcVar);
                if (str.length() == 0) {
                    return jcVar.toString();
                }
                return str + ", " + jcVar;
            default:
                lc lcVar = (lc) obj;
                jc jcVar2 = (jc) obj2;
                pr.j("acc", lcVar);
                pr.j("element", jcVar2);
                lc lcVarC = lcVar.c(jcVar2.getKey());
                oi oiVar = oi.a;
                if (lcVarC == oiVar) {
                    return jcVar2;
                }
                mh mhVar = mh.c;
                zb zbVar = (zb) lcVarC.n(mhVar);
                if (zbVar == null) {
                    z9Var = new z9(lcVarC, jcVar2);
                } else {
                    lc lcVarC2 = lcVarC.c(mhVar);
                    if (lcVarC2 == oiVar) {
                        return new z9(jcVar2, zbVar);
                    }
                    z9Var = new z9(new z9(lcVarC2, jcVar2), zbVar);
                }
                return z9Var;
        }
    }
}
