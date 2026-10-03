package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jl extends yb {
    public il d;
    public w30 f;
    public n6 h;
    public boolean o;
    public /* synthetic */ Object p;
    public int q;

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.p = obj;
        this.q |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return wf0.j(null, null, false, this);
    }
}
