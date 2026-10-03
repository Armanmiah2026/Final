package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class x60 extends g implements wc {
    public final yb d;

    public x60(yb ybVar, lc lcVar) {
        super(lcVar, true);
        this.d = ybVar;
    }

    @Override // sensei0.ls
    public final boolean I() {
        return true;
    }

    @Override // sensei0.wc
    public final wc e() {
        yb ybVar = this.d;
        if (ybVar != null) {
            return ybVar;
        }
        return null;
    }

    @Override // sensei0.ls
    public void p(Object obj) {
        pr.M(xe.B(obj), pr.D(this.d));
    }

    @Override // sensei0.ls
    public void q(Object obj) {
        this.d.h(xe.B(obj));
    }
}
