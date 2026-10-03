package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p40 {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public final int a() {
        return this.f ? this.b - this.c : this.d;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.a + ", mData=null, mItemCount=" + this.d + ", mIsMeasuring=" + this.h + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.e + ", mInPreLayout=" + this.f + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
    }
}
