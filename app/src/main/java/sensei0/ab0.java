package sensei0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ab0 {
    public boolean a;
    public float e;
    public int l;
    public int b = -1;
    public int c = -1;
    public int d = 0;
    public boolean f = false;
    public final float[] g = new float[9];
    public final float[] h = new float[9];
    public a5[] i = new a5[16];
    public int j = 0;
    public int k = 0;

    public ab0(int i) {
        this.l = i;
    }

    public final void a(a5 a5Var) {
        int i = 0;
        while (true) {
            int i2 = this.j;
            if (i >= i2) {
                a5[] a5VarArr = this.i;
                if (i2 >= a5VarArr.length) {
                    this.i = (a5[]) Arrays.copyOf(a5VarArr, a5VarArr.length * 2);
                }
                a5[] a5VarArr2 = this.i;
                int i3 = this.j;
                a5VarArr2[i3] = a5Var;
                this.j = i3 + 1;
                return;
            }
            if (this.i[i] == a5Var) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(a5 a5Var) {
        int i = this.j;
        int i2 = 0;
        while (i2 < i) {
            if (this.i[i2] == a5Var) {
                while (i2 < i - 1) {
                    a5[] a5VarArr = this.i;
                    int i3 = i2 + 1;
                    a5VarArr[i2] = a5VarArr[i3];
                    i2 = i3;
                }
                this.j--;
                return;
            }
            i2++;
        }
    }

    public final void c() {
        this.l = 5;
        this.d = 0;
        this.b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            this.i[i2] = null;
        }
        this.j = 0;
        this.k = 0;
        this.a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public final void d(a5 a5Var) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            this.i[i2].h(a5Var, false);
        }
        this.j = 0;
    }

    public final String toString() {
        return "" + this.b;
    }
}
