package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f60 extends et implements jp {
    public final /* synthetic */ c60 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f60(c60 c60Var) {
        super(2);
        this.b = c60Var;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        int iIntValue = ((Number) obj).intValue();
        jc jcVar = (jc) obj2;
        kc key = jcVar.getKey();
        jc jcVarN = this.b.f.n(key);
        if (key != mh.p) {
            return Integer.valueOf(jcVar != jcVarN ? AttribFlags.SSH_FILEXFER_ATTR_EXTENDED : iIntValue + 1);
        }
        bs bsVar = (bs) jcVarN;
        bs parent = (bs) jcVar;
        while (true) {
            if (parent != null) {
                if (parent == bsVar || !(parent instanceof x60)) {
                    break;
                }
                i8 i8Var = (i8) ls.b.get((ls) parent);
                parent = i8Var != null ? i8Var.getParent() : null;
            } else {
                parent = null;
                break;
            }
        }
        if (parent == bsVar) {
            if (bsVar != null) {
                iIntValue++;
            }
            return Integer.valueOf(iIntValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + parent + ", expected child of " + bsVar + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
