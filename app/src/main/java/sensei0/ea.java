package sensei0;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ea {
    public final Object a;
    public final og b;
    public final fp c;
    public final Object d;
    public final Throwable e;

    public ea(Object obj, og ogVar, fp fpVar, Object obj2, Throwable th) {
        this.a = obj;
        this.b = ogVar;
        this.c = fpVar;
        this.d = obj2;
        this.e = th;
    }

    public static ea a(ea eaVar, og ogVar, CancellationException cancellationException, int i) {
        Object obj = eaVar.a;
        if ((i & 2) != 0) {
            ogVar = eaVar.b;
        }
        og ogVar2 = ogVar;
        fp fpVar = eaVar.c;
        Object obj2 = eaVar.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = eaVar.e;
        }
        return new ea(obj, ogVar2, fpVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ea)) {
            return false;
        }
        ea eaVar = (ea) obj;
        return pr.b(this.a, eaVar.a) && pr.b(this.b, eaVar.b) && pr.b(this.c, eaVar.c) && pr.b(this.d, eaVar.d) && pr.b(this.e, eaVar.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        og ogVar = this.b;
        int iHashCode2 = (iHashCode + (ogVar == null ? 0 : ogVar.hashCode())) * 31;
        fp fpVar = this.c;
        int iHashCode3 = (iHashCode2 + (fpVar == null ? 0 : fpVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ ea(Object obj, og ogVar, fp fpVar, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : ogVar, (i & 4) != 0 ? null : fpVar, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
