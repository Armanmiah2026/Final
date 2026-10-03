package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k8 {
    public long a = 0;
    public k8 b;

    public final void a(int i) {
        if (i < 64) {
            this.a &= ~(1 << i);
            return;
        }
        k8 k8Var = this.b;
        if (k8Var != null) {
            k8Var.a(i - 64);
        }
    }

    public final int b(int i) {
        k8 k8Var = this.b;
        if (k8Var == null) {
            return i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.a & ((1 << i) - 1));
        }
        return Long.bitCount(this.a) + k8Var.b(i - 64);
    }

    public final void c() {
        if (this.b == null) {
            this.b = new k8();
        }
    }

    public final boolean d(int i) {
        if (i < 64) {
            return (this.a & (1 << i)) != 0;
        }
        c();
        return this.b.d(i - 64);
    }

    public final boolean e(int i) {
        if (i >= 64) {
            c();
            return this.b.e(i - 64);
        }
        long j = 1 << i;
        long j2 = this.a;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.a = j3;
        long j4 = j - 1;
        this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        k8 k8Var = this.b;
        if (k8Var != null) {
            if (k8Var.d(0)) {
                g(63);
            }
            this.b.e(0);
        }
        return z;
    }

    public final void f() {
        this.a = 0L;
        k8 k8Var = this.b;
        if (k8Var != null) {
            k8Var.f();
        }
    }

    public final void g(int i) {
        if (i < 64) {
            this.a |= 1 << i;
        } else {
            c();
            this.b.g(i - 64);
        }
    }

    public final String toString() {
        if (this.b == null) {
            return Long.toBinaryString(this.a);
        }
        return this.b.toString() + "xx" + Long.toBinaryString(this.a);
    }
}
