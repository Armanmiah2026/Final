package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qe extends yb {
    public Object d;
    public Object f;
    public Serializable h;
    public x40 o;
    public boolean p;
    public int q;
    public /* synthetic */ Object r;
    public final /* synthetic */ ve s;
    public int t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qe(ve veVar, yb ybVar) {
        super(ybVar);
        this.s = veVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.r = obj;
        this.t |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return ve.f(this.s, false, this);
    }
}
