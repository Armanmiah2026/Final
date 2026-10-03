package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class td extends yb {
    public Serializable d;
    public Iterator f;
    public /* synthetic */ Object h;
    public int o;

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.h = obj;
        this.o |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return mm0.b(null, null, this);
    }
}
