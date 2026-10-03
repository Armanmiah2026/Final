package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dd0 implements Serializable {
    public uo a;
    public volatile Object b = mh.t;
    public final Object c = this;

    public dd0(uo uoVar) {
        this.a = uoVar;
    }

    public final Object a() {
        Object objA;
        Object obj = this.b;
        mh mhVar = mh.t;
        if (obj != mhVar) {
            return obj;
        }
        synchronized (this.c) {
            objA = this.b;
            if (objA == mhVar) {
                uo uoVar = this.a;
                pr.f(uoVar);
                objA = uoVar.a();
                this.b = objA;
                this.a = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.b != mh.t ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
