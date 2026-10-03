package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nl extends yb {
    public /* synthetic */ Object d;
    public int f;
    public final /* synthetic */ i3 h;
    public i3 o;
    public il p;
    public c60 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl(i3 i3Var, yb ybVar) {
        super(ybVar);
        this.h = i3Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.d = obj;
        this.f |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.h.e(null, this);
    }
}
