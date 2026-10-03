package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class z9 implements lc, Serializable {
    public final lc a;
    public final jc b;

    public z9(lc lcVar, jc jcVar) {
        pr.j("left", lcVar);
        pr.j("element", jcVar);
        this.a = lcVar;
        this.b = jcVar;
    }

    @Override // sensei0.lc
    public final lc c(kc kcVar) {
        pr.j("key", kcVar);
        jc jcVar = this.b;
        jc jcVarN = jcVar.n(kcVar);
        lc lcVar = this.a;
        if (jcVarN != null) {
            return lcVar;
        }
        lc lcVarC = lcVar.c(kcVar);
        return lcVarC == lcVar ? this : lcVarC == oi.a ? jcVar : new z9(lcVarC, jcVar);
    }

    @Override // sensei0.lc
    public final Object d(Object obj, jp jpVar) {
        return jpVar.c(this.a.d(obj, jpVar), this.b);
    }

    public final boolean equals(Object obj) {
        boolean zB;
        if (this == obj) {
            return true;
        }
        if (obj instanceof z9) {
            z9 z9Var = (z9) obj;
            int i = 2;
            z9 z9Var2 = z9Var;
            int i2 = 2;
            while (true) {
                lc lcVar = z9Var2.a;
                z9Var2 = lcVar instanceof z9 ? (z9) lcVar : null;
                if (z9Var2 == null) {
                    break;
                }
                i2++;
            }
            z9 z9Var3 = this;
            while (true) {
                lc lcVar2 = z9Var3.a;
                z9Var3 = lcVar2 instanceof z9 ? (z9) lcVar2 : null;
                if (z9Var3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                z9 z9Var4 = this;
                while (true) {
                    jc jcVar = z9Var4.b;
                    if (!pr.b(z9Var.n(jcVar.getKey()), jcVar)) {
                        zB = false;
                        break;
                    }
                    lc lcVar3 = z9Var4.a;
                    if (!(lcVar3 instanceof z9)) {
                        pr.g("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element", lcVar3);
                        jc jcVar2 = (jc) lcVar3;
                        zB = pr.b(z9Var.n(jcVar2.getKey()), jcVar2);
                        break;
                    }
                    z9Var4 = (z9) lcVar3;
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode();
    }

    @Override // sensei0.lc
    public final lc j(lc lcVar) {
        pr.j("context", lcVar);
        return lcVar == oi.a ? this : (lc) lcVar.d(this, new y9(1));
    }

    @Override // sensei0.lc
    public final jc n(kc kcVar) {
        pr.j("key", kcVar);
        z9 z9Var = this;
        while (true) {
            jc jcVarN = z9Var.b.n(kcVar);
            if (jcVarN != null) {
                return jcVarN;
            }
            lc lcVar = z9Var.a;
            if (!(lcVar instanceof z9)) {
                return lcVar.n(kcVar);
            }
            z9Var = (z9) lcVar;
        }
    }

    public final String toString() {
        return "[" + ((String) d("", new y9(0))) + ']';
    }
}
