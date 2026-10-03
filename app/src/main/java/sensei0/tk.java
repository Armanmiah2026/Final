package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tk extends yb {
    public Object d;
    public FileInputStream f;
    public /* synthetic */ Object h;
    public final /* synthetic */ uk o;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk(uk ukVar, yb ybVar) {
        super(ybVar);
        this.o = ukVar;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        this.h = obj;
        this.p |= AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        return uk.a(this.o, this);
    }
}
