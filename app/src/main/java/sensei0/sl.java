package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sl extends yb {
    public x40 d;
    public z6 f;
    public /* synthetic */ Object h;
    public int o;

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.h = obj;
        this.o |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return pr.x(null, this);
    }
}
