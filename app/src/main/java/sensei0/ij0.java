package sensei0;

import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ij0 implements Choreographer.FrameCallback {
    public long a;
    public final /* synthetic */ jj0 b;

    public ij0(jj0 jj0Var, long j) {
        this.b = jj0Var;
        this.a = j;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        long jNanoTime = System.nanoTime() - j;
        long j2 = jNanoTime < 0 ? 0L : jNanoTime;
        jj0 jj0Var = this.b;
        jj0Var.b.onVsync(j2, jj0Var.a, this.a);
        jj0Var.c = this;
    }
}
