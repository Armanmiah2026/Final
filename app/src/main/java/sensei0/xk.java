package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xk extends yb {
    public zk d;
    public uk f;
    public boolean h;
    public /* synthetic */ Object o;
    public final /* synthetic */ zk p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk(zk zkVar, yb ybVar) {
        super(ybVar);
        this.p = zkVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.o = obj;
        this.q |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.p.a(null, this);
    }
}
