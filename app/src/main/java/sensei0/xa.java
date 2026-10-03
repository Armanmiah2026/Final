package sensei0;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xa extends ViewGroup.MarginLayoutParams {
    public float A;
    public String B;
    public int C;
    public float D;
    public float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public float O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public String U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public int a;
    public int a0;
    public int b;
    public int b0;
    public float c;
    public int c0;
    public int d;
    public int d0;
    public int e;
    public int e0;
    public int f;
    public int f0;
    public int g;
    public float g0;
    public int h;
    public int h0;
    public int i;
    public int i0;
    public int j;
    public float j0;
    public int k;
    public hb k0;
    public int l;
    public int m;
    public int n;
    public float o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    public final void a() {
        this.Y = false;
        this.V = true;
        this.W = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.S) {
            this.V = false;
            if (this.H == 0) {
                this.H = 1;
            }
        }
        int i2 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i2 == -2 && this.T) {
            this.W = false;
            if (this.I == 0) {
                this.I = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.V = false;
            if (i == 0 && this.H == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.S = true;
            }
        }
        if (i2 == 0 || i2 == -1) {
            this.W = false;
            if (i2 == 0 && this.I == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.T = true;
            }
        }
        if (this.c == -1.0f && this.a == -1 && this.b == -1) {
            return;
        }
        this.Y = true;
        this.V = true;
        this.W = true;
        if (!(this.k0 instanceof hq)) {
            this.k0 = new hq();
        }
        ((hq) this.k0).B(this.R);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resolveLayoutDirection(int r10) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xa.resolveLayoutDirection(int):void");
    }
}
