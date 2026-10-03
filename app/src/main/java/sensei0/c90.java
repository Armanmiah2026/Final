package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c90 extends yb {
    public /* synthetic */ Object d;
    public int f;
    public final /* synthetic */ pl h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c90(pl plVar, yb ybVar) {
        super(ybVar);
        this.h = plVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.d = obj;
        this.f |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return this.h.d(null, this);
    }
}
