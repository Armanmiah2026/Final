package sensei0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i80 extends m80 {
    public final k80 c;
    public final float d;
    public final float e;

    public i80(k80 k80Var, float f, float f2) {
        this.c = k80Var;
        this.d = f;
        this.e = f2;
    }

    @Override // sensei0.m80
    public final void a(Matrix matrix, b80 b80Var, int i, Canvas canvas) {
        k80 k80Var = this.c;
        float f = k80Var.c;
        float f2 = this.e;
        float f3 = k80Var.b;
        float f4 = this.d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = this.a;
        matrix2.set(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(b());
        b80Var.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int i2 = b80Var.f;
        int[] iArr = b80.i;
        iArr[0] = i2;
        iArr[1] = b80Var.e;
        iArr[2] = b80Var.d;
        Paint paint = b80Var.c;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, b80.j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        k80 k80Var = this.c;
        return (float) Math.toDegrees(Math.atan((k80Var.c - this.e) / (k80Var.b - this.d)));
    }
}
