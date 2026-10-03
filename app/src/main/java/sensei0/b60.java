package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b60 extends yb {
    public j1 d;
    public hy f;
    public /* synthetic */ Object h;
    public final /* synthetic */ j1 o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b60(j1 j1Var, yb ybVar) {
        super(ybVar);
        this.o = j1Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.h = obj;
        this.p |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.o.j(this);
    }
}
