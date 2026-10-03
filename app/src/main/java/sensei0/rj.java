package sensei0;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rj {
    public static volatile rj b;
    public static final rj c = new rj();
    public final Map a = Collections.EMPTY_MAP;

    public static rj a() {
        rj rjVar;
        e30 e30Var = e30.c;
        rj rjVar2 = b;
        if (rjVar2 != null) {
            return rjVar2;
        }
        synchronized (rj.class) {
            try {
                rjVar = b;
                if (rjVar == null) {
                    Class cls = qj.a;
                    rj rjVar3 = null;
                    if (cls != null) {
                        try {
                            rjVar3 = (rj) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    rjVar = rjVar3 != null ? rjVar3 : c;
                    b = rjVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return rjVar;
    }
}
