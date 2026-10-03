package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class te extends yb {
    public w40 d;
    public /* synthetic */ Object f;
    public final /* synthetic */ ve h;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te(ve veVar, yb ybVar) {
        super(ybVar);
        this.h = veVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.f = obj;
        this.o |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.h.j(null, false, this);
    }
}
