package sensei0;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xk0 extends yk0 {
    public final WindowInsetsAnimation e;

    public xk0(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    @Override // sensei0.yk0
    public final long a() {
        return this.e.getDurationMillis();
    }

    @Override // sensei0.yk0
    public final float b() {
        return this.e.getInterpolatedFraction();
    }

    @Override // sensei0.yk0
    public final int c() {
        return this.e.getTypeMask();
    }

    @Override // sensei0.yk0
    public final void d(float f) {
        this.e.setFraction(f);
    }
}
