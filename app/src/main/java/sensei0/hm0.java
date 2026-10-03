package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hm0 {
    public static final hm0 a;
    public static final hm0 b;
    public static final hm0 c;
    public static final hm0 d;
    public static final hm0 f;
    public static final hm0 h;
    public static final hm0 o;
    public static final hm0 p;
    public static final hm0 q;
    public static final /* synthetic */ hm0[] r;

    static {
        hm0 hm0Var = new hm0("INT", 0);
        a = hm0Var;
        hm0 hm0Var2 = new hm0("LONG", 1);
        b = hm0Var2;
        hm0 hm0Var3 = new hm0("FLOAT", 2);
        c = hm0Var3;
        hm0 hm0Var4 = new hm0("DOUBLE", 3);
        d = hm0Var4;
        hm0 hm0Var5 = new hm0("BOOLEAN", 4);
        f = hm0Var5;
        hm0 hm0Var6 = new hm0("STRING", 5);
        h = hm0Var6;
        u6 u6Var = u6.c;
        hm0 hm0Var7 = new hm0("BYTE_STRING", 6);
        o = hm0Var7;
        hm0 hm0Var8 = new hm0("ENUM", 7);
        p = hm0Var8;
        hm0 hm0Var9 = new hm0("MESSAGE", 8);
        q = hm0Var9;
        r = new hm0[]{hm0Var, hm0Var2, hm0Var3, hm0Var4, hm0Var5, hm0Var6, hm0Var7, hm0Var8, hm0Var9};
    }

    public static hm0 valueOf(String str) {
        return (hm0) Enum.valueOf(hm0.class, str);
    }

    public static hm0[] values() {
        return (hm0[]) r.clone();
    }
}
