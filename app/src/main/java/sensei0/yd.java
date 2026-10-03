package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yd extends yb {
    public Object d;
    public Object f;
    public Object h;
    public x40 o;
    public ve p;
    public /* synthetic */ Object q;
    public final /* synthetic */ zd r;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd(zd zdVar, yb ybVar) {
        super(ybVar);
        this.r = zdVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.q = obj;
        this.s |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.r.a(null, this);
    }
}
