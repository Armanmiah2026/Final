package sensei0;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tn implements fi {
    public static final tn c;
    public static final tn d;
    public static final tn f;
    public static final tn h;
    public static final tn o;
    public static final tn p;
    public final /* synthetic */ int a;
    public final String b;

    static {
        int i = 0;
        c = new tn("NONE", i);
        d = new tn("FULL", i);
        int i2 = 1;
        f = new tn("FLAT", i2);
        h = new tn("HALF_OPENED", i2);
        int i3 = 2;
        o = new tn("FOLD", i3);
        p = new tn("HINGE", i3);
    }

    public /* synthetic */ tn(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // sensei0.fi
    public boolean q(CharSequence charSequence, int i, int i2, eg0 eg0Var) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.b)) {
            return true;
        }
        eg0Var.c = (eg0Var.c & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return this.b;
            case 1:
                return this.b;
            case 2:
                return this.b;
            case 3:
            default:
                return super.toString();
            case 4:
                return "<" + this.b + '>';
        }
    }

    @Override // sensei0.fi
    public Object a() {
        return this;
    }
}
