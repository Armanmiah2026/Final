package sensei0;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n80 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();

    public n80() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f) {
        float f2 = this.d;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.b;
        float f5 = this.c;
        j80 j80Var = new j80(f4, f5, f4, f5);
        j80Var.f = this.d;
        j80Var.g = f3;
        this.g.add(new h80(j80Var));
        this.d = f;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((l80) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f, float f2) {
        k80 k80Var = new k80();
        k80Var.b = f;
        k80Var.c = f2;
        this.f.add(k80Var);
        i80 i80Var = new i80(k80Var, this.b, this.c);
        float fB = i80Var.b() + 270.0f;
        float fB2 = i80Var.b() + 270.0f;
        a(fB);
        this.g.add(i80Var);
        this.d = fB2;
        this.b = f;
        this.c = f2;
    }

    public final void d(float f, float f2, float f3) {
        this.a = f;
        this.b = 0.0f;
        this.c = f;
        this.d = f2;
        this.e = (f2 + f3) % 360.0f;
        this.f.clear();
        this.g.clear();
    }
}
