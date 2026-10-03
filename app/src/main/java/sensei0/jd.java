package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jd {
    public final String a;
    public final String b;
    public final String c;

    public jd(String str, String str2) {
        this.a = str;
        this.b = null;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jd.class != obj.getClass()) {
            return false;
        }
        jd jdVar = (jd) obj;
        if (this.a.equals(jdVar.a)) {
            return this.c.equals(jdVar.c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DartEntrypoint( bundle path: ");
        sb.append(this.a);
        sb.append(", function: ");
        return za0.o(sb, this.c, " )");
    }

    public jd(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
