package sensei0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f80 {
    public final n80[] a = new n80[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final n80 g = new n80();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public f80() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new n80();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(d80 d80Var, float f, RectF rectF, ws wsVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr;
        int i;
        n80[] n80VarArr;
        Matrix[] matrixArr2;
        char c;
        float f2;
        char c2;
        int i2;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = this.c;
            fArr = this.h;
            n80VarArr = this.a;
            matrixArr2 = this.b;
            c = 0;
            if (i3 >= 4) {
                break;
            }
            ic icVar = i3 != 1 ? i3 != 2 ? i3 != 3 ? d80Var.f : d80Var.e : d80Var.h : d80Var.g;
            mm0 mm0Var = i3 != 1 ? i3 != 2 ? i3 != 3 ? d80Var.b : d80Var.a : d80Var.d : d80Var.c;
            n80 n80Var = n80VarArr[i3];
            mm0Var.getClass();
            mm0Var.u(n80Var, f, icVar.a(rectF));
            int i4 = i3 + 1;
            float f3 = (i4 % 4) * 90;
            matrixArr2[i3].reset();
            PointF pointF = this.d;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f3);
            n80 n80Var2 = n80VarArr[i2];
            fArr[0] = n80Var2.b;
            fArr[1] = n80Var2.c;
            matrixArr2[i2].mapPoints(fArr);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr[0], fArr[1]);
            matrixArr[i2].preRotate(f3);
            i3 = i4;
        }
        int i5 = 0;
        for (i = 4; i5 < i; i = 4) {
            n80 n80Var3 = n80VarArr[i5];
            n80Var3.getClass();
            fArr[c] = 0.0f;
            fArr[1] = n80Var3.a;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 0) {
                path.moveTo(fArr[c], fArr[1]);
            } else {
                path.lineTo(fArr[c], fArr[1]);
            }
            n80VarArr[i5].b(matrixArr2[i5], path);
            if (wsVar != null) {
                n80 n80Var4 = n80VarArr[i5];
                Matrix matrix = matrixArr2[i5];
                kw kwVar = (kw) wsVar.b;
                f2 = 0.0f;
                BitSet bitSet = kwVar.d;
                n80Var4.getClass();
                bitSet.set(i5, (boolean) c);
                m80[] m80VarArr = kwVar.b;
                n80Var4.a(n80Var4.e);
                m80VarArr[i5] = new g80(new ArrayList(n80Var4.g), new Matrix(matrix));
            } else {
                f2 = 0.0f;
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            n80 n80Var5 = n80VarArr[i5];
            fArr[0] = n80Var5.b;
            fArr[1] = n80Var5.c;
            matrixArr2[i5].mapPoints(fArr);
            n80 n80Var6 = n80VarArr[i7];
            n80Var6.getClass();
            float[] fArr2 = this.i;
            fArr2[0] = f2;
            fArr2[1] = n80Var6.a;
            matrixArr2[i7].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr;
            n80[] n80VarArr2 = n80VarArr;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, f2);
            n80 n80Var7 = n80VarArr2[i5];
            fArr[0] = n80Var7.b;
            fArr[1] = n80Var7.c;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 1 || i5 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            n80 n80Var8 = this.g;
            n80Var8.d(0.0f, 270.0f, 0.0f);
            (i5 != 1 ? i5 != 2 ? i5 != 3 ? d80Var.j : d80Var.i : d80Var.l : d80Var.k).getClass();
            n80Var8.c(fMax, 0.0f);
            Path path4 = this.j;
            path4.reset();
            n80Var8.b(matrixArr3[i5], path4);
            if (this.l && (b(path4, i5) || b(path4, i7))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = n80Var8.a;
                matrixArr3[i5].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                n80Var8.b(matrixArr3[i5], path2);
            } else {
                n80Var8.b(matrixArr3[i5], path);
            }
            if (wsVar != null) {
                Matrix matrix2 = matrixArr3[i5];
                kw kwVar2 = (kw) wsVar.b;
                c2 = 0;
                kwVar2.d.set(i5 + 4, false);
                m80[] m80VarArr2 = kwVar2.c;
                n80Var8.a(n80Var8.e);
                m80VarArr2[i5] = new g80(new ArrayList(n80Var8.g), new Matrix(matrix2));
            } else {
                c2 = 0;
            }
            i5 = i6;
            c = c2;
            n80VarArr = n80VarArr2;
            matrixArr = matrixArr3;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.k;
        path2.reset();
        this.a[i].b(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
