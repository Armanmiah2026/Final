package sensei0;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hr {
    public static final hr e = new hr(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public hr(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static hr a(hr hrVar, hr hrVar2) {
        return b(Math.max(hrVar.a, hrVar2.a), Math.max(hrVar.b, hrVar2.b), Math.max(hrVar.c, hrVar2.c), Math.max(hrVar.d, hrVar2.d));
    }

    public static hr b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new hr(i, i2, i3, i4);
    }

    public static hr c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return gr.a(this.a, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hr.class != obj.getClass()) {
            return false;
        }
        hr hrVar = (hr) obj;
        return this.d == hrVar.d && this.a == hrVar.a && this.c == hrVar.c && this.b == hrVar.b;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
