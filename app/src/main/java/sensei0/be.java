package sensei0;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class be extends et implements uo {
    public final /* synthetic */ int b;
    public final /* synthetic */ ve c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ be(ve veVar, int i) {
        super(0);
        this.b = i;
        this.c = veVar;
    }

    @Override // sensei0.uo
    public final Object a() throws IOException {
        switch (this.b) {
            case 0:
                return ((zk) this.c.r.a()).b;
            default:
                wk wkVar = this.c.a;
                File canonicalFile = ((File) wkVar.b.a()).getCanonicalFile();
                synchronized (wk.d) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = wk.c;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    pr.i("path", absolutePath);
                    linkedHashSet.add(absolutePath);
                }
                return new zk(canonicalFile, (oa0) wkVar.a.g(canonicalFile), new vk(0, canonicalFile));
        }
    }
}
