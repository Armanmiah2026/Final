package sensei0;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xh extends mm0 {
    public final /* synthetic */ mm0 l;
    public final /* synthetic */ ThreadPoolExecutor m;

    public xh(mm0 mm0Var, ThreadPoolExecutor threadPoolExecutor) {
        this.l = mm0Var;
        this.m = threadPoolExecutor;
    }

    @Override // sensei0.mm0
    public final void P(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.m;
        try {
            this.l.P(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // sensei0.mm0
    public final void S(j1 j1Var) {
        ThreadPoolExecutor threadPoolExecutor = this.m;
        try {
            this.l.S(j1Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
