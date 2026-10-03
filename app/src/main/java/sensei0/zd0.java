package sensei0;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zd0 implements uq {
    public final /* synthetic */ io.flutter.plugin.editing.b a;

    public /* synthetic */ zd0(io.flutter.plugin.editing.b bVar) {
        this.a = bVar;
    }

    public void a(int i, qd0 qd0Var) {
        io.flutter.plugin.editing.b bVar = this.a;
        bVar.d();
        bVar.f = qd0Var;
        bVar.e = new ft(2, i);
        bVar.h.e(bVar);
        j1 j1Var = qd0Var.j;
        bVar.h = new uu(j1Var != null ? (td0) j1Var.d : null, bVar.a);
        bVar.e(qd0Var);
        bVar.i = true;
        if (bVar.e.b == 3) {
            bVar.p = false;
        }
        bVar.m = null;
        bVar.h.a(bVar);
    }

    public void b(double d, double d2, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d3 = dArr[12];
        double d4 = dArr[15];
        double d5 = d3 / d4;
        dArr2[1] = d5;
        dArr2[0] = d5;
        double d6 = dArr[13] / d4;
        dArr2[3] = d6;
        dArr2[2] = d6;
        s60 s60Var = new s60(z, dArr, dArr2);
        s60Var.a(d, 0.0d);
        s60Var.a(d, d2);
        s60Var.a(0.0d, d2);
        io.flutter.plugin.editing.b bVar = this.a;
        double d7 = bVar.a.getContext().getResources().getDisplayMetrics().density;
        bVar.m = new Rect((int) (dArr2[0] * d7), (int) (dArr2[2] * d7), (int) Math.ceil(dArr2[1] * d7), (int) Math.ceil(dArr2[3] * d7));
    }

    public void c(td0 td0Var) {
        td0 td0Var2;
        int i;
        int i2;
        io.flutter.plugin.editing.b bVar = this.a;
        View view = bVar.a;
        if (!bVar.i && (td0Var2 = bVar.o) != null && (i = td0Var2.d) >= 0 && (i2 = td0Var2.e) > i) {
            int i3 = i2 - i;
            int i4 = td0Var.e;
            int i5 = td0Var.d;
            boolean z = true;
            if (i3 == i4 - i5) {
                int i6 = 0;
                while (true) {
                    if (i6 >= i3) {
                        z = false;
                        break;
                    } else if (td0Var2.a.charAt(i6 + i) != td0Var.a.charAt(i6 + i5)) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            bVar.i = z;
        }
        bVar.o = td0Var;
        bVar.h.f(td0Var);
        if (bVar.i) {
            bVar.b.restartInput(view);
            bVar.i = false;
        }
    }
}
