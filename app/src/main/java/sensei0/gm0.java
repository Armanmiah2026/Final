package sensei0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class gm0 {
    public static final cm0 c;
    public static final dm0 d;
    public static final em0 f;
    public static final /* synthetic */ gm0[] h;
    public final hm0 a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    gm0 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    gm0 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    gm0 EF2;

    static {
        gm0 gm0Var = new gm0("DOUBLE", 0, hm0.d, 1);
        gm0 gm0Var2 = new gm0("FLOAT", 1, hm0.c, 5);
        hm0 hm0Var = hm0.b;
        gm0 gm0Var3 = new gm0("INT64", 2, hm0Var, 0);
        gm0 gm0Var4 = new gm0("UINT64", 3, hm0Var, 0);
        hm0 hm0Var2 = hm0.a;
        gm0 gm0Var5 = new gm0("INT32", 4, hm0Var2, 0);
        gm0 gm0Var6 = new gm0("FIXED64", 5, hm0Var, 1);
        gm0 gm0Var7 = new gm0("FIXED32", 6, hm0Var2, 5);
        gm0 gm0Var8 = new gm0("BOOL", 7, hm0.f, 0);
        cm0 cm0Var = new cm0("STRING", 8, hm0.h, 2);
        c = cm0Var;
        hm0 hm0Var3 = hm0.q;
        dm0 dm0Var = new dm0("GROUP", 9, hm0Var3, 3);
        d = dm0Var;
        em0 em0Var = new em0("MESSAGE", 10, hm0Var3, 2);
        f = em0Var;
        h = new gm0[]{gm0Var, gm0Var2, gm0Var3, gm0Var4, gm0Var5, gm0Var6, gm0Var7, gm0Var8, cm0Var, dm0Var, em0Var, new fm0("BYTES", 11, hm0.o, 2), new gm0("UINT32", 12, hm0Var2, 0), new gm0("ENUM", 13, hm0.p, 0), new gm0("SFIXED32", 14, hm0Var2, 5), new gm0("SFIXED64", 15, hm0Var, 1), new gm0("SINT32", 16, hm0Var2, 0), new gm0("SINT64", 17, hm0Var, 0)};
    }

    public gm0(String str, int i, hm0 hm0Var, int i2) {
        this.a = hm0Var;
        this.b = i2;
    }

    public static gm0 valueOf(String str) {
        return (gm0) Enum.valueOf(gm0.class, str);
    }

    public static gm0[] values() {
        return (gm0[]) h.clone();
    }
}
