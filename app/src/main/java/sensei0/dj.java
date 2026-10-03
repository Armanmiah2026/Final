package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dj extends pc {
    public static final /* synthetic */ int h = 0;
    public long c;
    public boolean d;
    public r4 f;

    public final void g(boolean z) {
        long j = this.c - (z ? 4294967296L : 1L);
        this.c = j;
        if (j <= 0 && this.d) {
            shutdown();
        }
    }

    public abstract Thread h();

    public final void i(boolean z) {
        this.c = (z ? 4294967296L : 1L) + this.c;
        if (z) {
            return;
        }
        this.d = true;
    }

    public abstract long k();

    public final boolean l() {
        r4 r4Var = this.f;
        if (r4Var == null) {
            return false;
        }
        jg jgVar = (jg) (r4Var.isEmpty() ? null : r4Var.removeFirst());
        if (jgVar == null) {
            return false;
        }
        jgVar.run();
        return true;
    }

    public abstract void shutdown();
}
