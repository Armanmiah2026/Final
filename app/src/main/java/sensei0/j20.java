package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class j20 extends cq {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final j20 DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile sz PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        j20 j20Var = new j20();
        DEFAULT_INSTANCE = j20Var;
        cq.j(j20.class, j20Var);
    }

    public static i20 D() {
        return (i20) ((aq) DEFAULT_INSTANCE.c(5));
    }

    public static void l(j20 j20Var, long j) {
        j20Var.valueCase_ = 4;
        j20Var.value_ = Long.valueOf(j);
    }

    public static void m(j20 j20Var, String str) {
        j20Var.getClass();
        j20Var.valueCase_ = 5;
        j20Var.value_ = str;
    }

    public static void n(j20 j20Var, h20 h20Var) {
        j20Var.getClass();
        j20Var.value_ = h20Var;
        j20Var.valueCase_ = 6;
    }

    public static void o(j20 j20Var, double d) {
        j20Var.valueCase_ = 7;
        j20Var.value_ = Double.valueOf(d);
    }

    public static void p(j20 j20Var, u6 u6Var) {
        j20Var.getClass();
        j20Var.valueCase_ = 8;
        j20Var.value_ = u6Var;
    }

    public static void q(j20 j20Var, boolean z) {
        j20Var.valueCase_ = 1;
        j20Var.value_ = Boolean.valueOf(z);
    }

    public static void r(j20 j20Var, float f) {
        j20Var.valueCase_ = 2;
        j20Var.value_ = Float.valueOf(f);
    }

    public static void s(j20 j20Var, int i) {
        j20Var.valueCase_ = 3;
        j20Var.value_ = Integer.valueOf(i);
    }

    public static j20 v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public final h20 B() {
        return this.valueCase_ == 6 ? (h20) this.value_ : h20.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    @Override // sensei0.cq
    public final Object c(int i) {
        sz bqVar;
        switch (za0.u(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t30(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", h20.class});
            case 3:
                return new j20();
            case 4:
                return new i20(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                sz szVar = PARSER;
                if (szVar != null) {
                    return szVar;
                }
                synchronized (j20.class) {
                    try {
                        bqVar = PARSER;
                        if (bqVar == null) {
                            bqVar = new bq();
                            PARSER = bqVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bqVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final u6 u() {
        return this.valueCase_ == 8 ? (u6) this.value_ : u6.c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
