package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yk extends yb {
    public zk d;
    public Object f;
    public Object h;
    public bl o;
    public /* synthetic */ Object p;
    public final /* synthetic */ zk q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yk(zk zkVar, yb ybVar) {
        super(ybVar);
        this.q = zkVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.p = obj;
        this.r |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.q.b(null, this);
    }
}
