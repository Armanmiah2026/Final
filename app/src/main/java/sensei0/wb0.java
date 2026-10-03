package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wb0 extends yb {
    public xb0 d;
    public il f;
    public yb0 h;
    public bs o;
    public Object p;
    public /* synthetic */ Object q;
    public final /* synthetic */ xb0 r;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wb0(xb0 xb0Var, yb ybVar) {
        super(ybVar);
        this.r = xb0Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.q = obj;
        this.s |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        this.r.e(null, this);
        return vc.a;
    }
}
