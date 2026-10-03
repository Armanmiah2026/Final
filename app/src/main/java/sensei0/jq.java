package sensei0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jq extends pc implements rf {
    public final Handler c;
    public final boolean d;
    public final jq f;

    public jq(Handler handler, boolean z) {
        this.c = handler;
        this.d = z;
        this.f = z ? this : new jq(handler, true);
    }

    @Override // sensei0.pc
    public final void e(lc lcVar, Runnable runnable) {
        if (this.c.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        bs bsVar = (bs) lcVar.n(mh.p);
        if (bsVar != null) {
            bsVar.b(cancellationException);
        }
        kg.b.e(lcVar, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jq)) {
            return false;
        }
        jq jqVar = (jq) obj;
        return jqVar.c == this.c && jqVar.d == this.d;
    }

    @Override // sensei0.pc
    public final boolean f() {
        return (this.d && pr.b(Looper.myLooper(), this.c.getLooper())) ? false : true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.c) ^ (this.d ? 1231 : 1237);
    }

    @Override // sensei0.pc
    public final String toString() {
        jq jqVar;
        String str;
        nf nfVar = kg.a;
        jq jqVar2 = qv.a;
        if (this == jqVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                jqVar = jqVar2.f;
            } catch (UnsupportedOperationException unused) {
                jqVar = null;
            }
            str = this == jqVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.c.toString();
        return this.d ? za0.k(string, ".immediate") : string;
    }
}
