package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tp extends w6 implements sp, ms, rp {
    public final int o;

    public tp(int i, Class cls, String str, String str2, int i2) {
        this(i, v6.a, cls, str, str2, i2, 0);
    }

    @Override // sensei0.sp
    public final int b() {
        return this.o;
    }

    @Override // sensei0.w6
    public final ms d() {
        y40.a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tp) {
            tp tpVar = (tp) obj;
            return this.d.equals(tpVar.d) && this.f.equals(tpVar.f) && pr.b(this.b, tpVar.b) && e().equals(tpVar.e());
        }
        if (!(obj instanceof tp)) {
            return false;
        }
        ms msVar = this.a;
        if (msVar == null) {
            d();
            this.a = this;
            msVar = this;
        }
        return obj.equals(msVar);
    }

    public final int hashCode() {
        e();
        return this.f.hashCode() + ((this.d.hashCode() + (e().hashCode() * 31)) * 31);
    }

    public final String toString() {
        ms msVar = this.a;
        if (msVar == null) {
            d();
            this.a = this;
            msVar = this;
        }
        if (msVar != this) {
            return msVar.toString();
        }
        String str = this.d;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : za0.l("function ", str, " (Kotlin reflection is not available)");
    }

    public tp(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.o = i;
    }
}
