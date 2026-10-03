package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hd0 extends gd0 {
    public final Runnable c;

    public hd0(Runnable runnable, long j, xs xsVar) {
        super(j, xsVar);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.run();
        } finally {
            this.b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(xe.o(runnable));
        sb.append(", ");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(']');
        return sb.toString();
    }
}
