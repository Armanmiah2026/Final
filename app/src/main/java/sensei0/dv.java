package sensei0;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dv implements Interpolator {
    public final float[] a;
    public final float b;

    public dv(float[] fArr) {
        this.a = fArr;
        this.b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (iMin * f2)) / f2;
        float f4 = fArr[iMin];
        return ((fArr[iMin + 1] - f4) * f3) + f4;
    }
}
