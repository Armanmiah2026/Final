package sensei0;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qc {
    public static final List a;

    static {
        try {
            Iterator it = Arrays.asList(new r2()).iterator();
            pr.j("<this>", it);
            a = v70.d0(new sa(new v9(3, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
