package sensei0;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class id extends kw {
    public static final /* synthetic */ int G = 0;
    public hd F;

    @Override // sensei0.kw
    public final void e(Canvas canvas) {
        if (this.F.q.isEmpty()) {
            super.e(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.F.q);
        } else {
            canvas.clipRect(this.F.q, Region.Op.DIFFERENCE);
        }
        super.e(canvas);
        canvas.restore();
    }

    @Override // sensei0.kw, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.F = new hd(this.F);
        return this;
    }

    public final void n(float f, float f2, float f3, float f4) {
        RectF rectF = this.F.q;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }
}
