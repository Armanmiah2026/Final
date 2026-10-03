package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d30 extends w6 implements ps {
    public final boolean o;

    public d30(Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, true);
        this.o = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d30) {
            d30 d30Var = (d30) obj;
            return e().equals(d30Var.e()) && this.d.equals(d30Var.d) && this.f.equals(d30Var.f) && pr.b(this.b, d30Var.b);
        }
        if (obj instanceof ps) {
            return obj.equals(f());
        }
        return false;
    }

    public final ms f() {
        if (this.o) {
            return this;
        }
        ms msVar = this.a;
        if (msVar != null) {
            return msVar;
        }
        ms msVarD = d();
        this.a = msVarD;
        return msVarD;
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.d.hashCode() + (e().hashCode() * 31)) * 31);
    }

    public final String toString() {
        ms msVarF = f();
        return msVarF != this ? msVarF.toString() : za0.o(new StringBuilder("property "), this.d, " (Kotlin reflection is not available)");
    }
}
