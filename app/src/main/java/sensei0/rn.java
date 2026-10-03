package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rn {
    public final rb0 a = rb0.a;
    public final v2 b;

    public rn(v2 v2Var) {
        this.b = v2Var;
    }

    public final e10 a(Object obj) {
        if (((Integer) obj) == null) {
            throw new IllegalStateException("An identifier is required to retrieve a View instance.");
        }
        Object objE = this.b.e(r0.intValue());
        if (objE instanceof e10) {
            return (e10) objE;
        }
        if (objE instanceof View) {
            return new qn((View) objE);
        }
        throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + ", " + objE);
    }
}
