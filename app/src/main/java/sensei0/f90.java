package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f90 extends yb {
    public Set d;
    public Map f;
    public Iterator h;
    public a20 o;
    public /* synthetic */ Object p;
    public final /* synthetic */ t90 q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f90(t90 t90Var, yb ybVar) {
        super(ybVar);
        this.q = t90Var;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.p = obj;
        this.r |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return t90.m(this.q, null, this);
    }
}
