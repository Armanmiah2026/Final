package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class as {
    public static final as a;
    public static final as b;
    public static final as c;
    public static final as d;
    public static final as f;
    public static final as h;
    public static final as o;
    public static final as p;
    public static final as q;
    public static final as r;
    public static final /* synthetic */ as[] s;

    static {
        as asVar = new as("VOID", 0);
        a = asVar;
        as asVar2 = new as("INT", 1);
        b = asVar2;
        as asVar3 = new as("LONG", 2);
        c = asVar3;
        as asVar4 = new as("FLOAT", 3);
        d = asVar4;
        as asVar5 = new as("DOUBLE", 4);
        f = asVar5;
        as asVar6 = new as("BOOLEAN", 5);
        h = asVar6;
        as asVar7 = new as("STRING", 6);
        o = asVar7;
        u6 u6Var = u6.c;
        as asVar8 = new as("BYTE_STRING", 7);
        p = asVar8;
        as asVar9 = new as("ENUM", 8);
        q = asVar9;
        as asVar10 = new as("MESSAGE", 9);
        r = asVar10;
        s = new as[]{asVar, asVar2, asVar3, asVar4, asVar5, asVar6, asVar7, asVar8, asVar9, asVar10};
    }

    public static as valueOf(String str) {
        return (as) Enum.valueOf(as.class, str);
    }

    public static as[] values() {
        return (as[]) s.clone();
    }
}
