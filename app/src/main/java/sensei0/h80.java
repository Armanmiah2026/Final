package sensei0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class h80 extends m80 {
    public final j80 c;

    public h80(j80 j80Var) {
        this.c = j80Var;
    }

    @Override // sensei0.m80
    public final void a(Matrix matrix, b80 b80Var, int i, Canvas canvas) {
        float f;
        j80 j80Var = this.c;
        float f2 = j80Var.f;
        float f3 = j80Var.g;
        RectF rectF = new RectF(j80Var.b, j80Var.c, j80Var.d, j80Var.e);
        Paint paint = b80Var.b;
        boolean z = f3 < 0.0f;
        Path path = b80Var.g;
        int[] iArr = b80.k;
        if (z) {
            iArr[0] = 0;
            iArr[1] = b80Var.f;
            iArr[2] = b80Var.e;
            iArr[3] = b80Var.d;
            f = 0.0f;
        } else {
            path.rewind();
            f = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i;
            rectF.inset(f4, f4);
            iArr[0] = 0;
            iArr[1] = b80Var.d;
            iArr[2] = b80Var.e;
            iArr[3] = b80Var.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= f) {
            return;
        }
        float f5 = 1.0f - (i / fWidth);
        float[] fArr = b80.l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, b80Var.h);
        }
        canvas.drawArc(rectF, f2, f3, true, paint);
        canvas.restore();
    }
}
