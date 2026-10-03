package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie0 {
    public static final ThreadLocal a = new ThreadLocal();

    public static dj a() {
        ThreadLocal threadLocal = a;
        dj djVar = (dj) threadLocal.get();
        if (djVar != null) {
            return djVar;
        }
        c6 c6Var = new c6(Thread.currentThread());
        threadLocal.set(c6Var);
        return c6Var;
    }
}
