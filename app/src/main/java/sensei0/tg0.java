package sensei0;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tg0 extends vg0 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tg0(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // sensei0.vg0
    public final boolean c(long j, Object obj) {
        switch (this.b) {
            case 0:
                if (!wg0.g) {
                }
                break;
            default:
                if (!wg0.g) {
                }
                break;
        }
        return wg0.c(j, obj);
    }

    @Override // sensei0.vg0
    public final double d(long j, Object obj) {
        switch (this.b) {
        }
        return Double.longBitsToDouble(g(j, obj));
    }

    @Override // sensei0.vg0
    public final float e(long j, Object obj) {
        switch (this.b) {
        }
        return Float.intBitsToFloat(f(j, obj));
    }

    @Override // sensei0.vg0
    public final void j(Object obj, long j, boolean z) {
        switch (this.b) {
            case 0:
                if (!wg0.g) {
                    wg0.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    wg0.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!wg0.g) {
                    wg0.l(obj, j, z ? (byte) 1 : (byte) 0);
                } else {
                    wg0.k(obj, j, z ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // sensei0.vg0
    public final void k(Object obj, long j, byte b) {
        switch (this.b) {
            case 0:
                if (!wg0.g) {
                    wg0.l(obj, j, b);
                } else {
                    wg0.k(obj, j, b);
                }
                break;
            default:
                if (!wg0.g) {
                    wg0.l(obj, j, b);
                } else {
                    wg0.k(obj, j, b);
                }
                break;
        }
    }

    @Override // sensei0.vg0
    public final void l(Object obj, long j, double d) {
        switch (this.b) {
            case 0:
                o(obj, j, Double.doubleToLongBits(d));
                break;
            default:
                o(obj, j, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // sensei0.vg0
    public final void m(Object obj, long j, float f) {
        switch (this.b) {
            case 0:
                n(obj, j, Float.floatToIntBits(f));
                break;
            default:
                n(obj, j, Float.floatToIntBits(f));
                break;
        }
    }

    @Override // sensei0.vg0
    public final boolean r() {
        switch (this.b) {
        }
        return false;
    }
}
