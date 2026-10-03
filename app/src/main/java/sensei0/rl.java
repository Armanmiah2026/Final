package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rl extends yb {
    public y80 d;
    public /* synthetic */ Object f;
    public int h;
    public final /* synthetic */ y80 o;
    public Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl(y80 y80Var, yb ybVar) {
        super(ybVar);
        this.o = y80Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.f = obj;
        this.h |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.o.d(null, this);
    }
}
