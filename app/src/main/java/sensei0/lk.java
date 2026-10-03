package sensei0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
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
public final class lk {
    public static final lk b;
    public static final lk c;
    public static final lk[] d;
    public static final /* synthetic */ lk[] f;
    public final int a;

    /* JADX INFO: Fake field, exist only in values array */
    lk EF0;

    static {
        as asVar = as.f;
        lk lkVar = new lk("DOUBLE", 0, 0, 1, asVar);
        as asVar2 = as.d;
        lk lkVar2 = new lk("FLOAT", 1, 1, 1, asVar2);
        as asVar3 = as.c;
        lk lkVar3 = new lk("INT64", 2, 2, 1, asVar3);
        lk lkVar4 = new lk("UINT64", 3, 3, 1, asVar3);
        as asVar4 = as.b;
        lk lkVar5 = new lk("INT32", 4, 4, 1, asVar4);
        lk lkVar6 = new lk("FIXED64", 5, 5, 1, asVar3);
        lk lkVar7 = new lk("FIXED32", 6, 6, 1, asVar4);
        as asVar5 = as.h;
        lk lkVar8 = new lk("BOOL", 7, 7, 1, asVar5);
        as asVar6 = as.o;
        lk lkVar9 = new lk("STRING", 8, 8, 1, asVar6);
        as asVar7 = as.r;
        lk lkVar10 = new lk("MESSAGE", 9, 9, 1, asVar7);
        as asVar8 = as.p;
        lk lkVar11 = new lk("BYTES", 10, 10, 1, asVar8);
        lk lkVar12 = new lk("UINT32", 11, 11, 1, asVar4);
        as asVar9 = as.q;
        lk lkVar13 = new lk("ENUM", 12, 12, 1, asVar9);
        lk lkVar14 = new lk("SFIXED32", 13, 13, 1, asVar4);
        lk lkVar15 = new lk("SFIXED64", 14, 14, 1, asVar3);
        lk lkVar16 = new lk("SINT32", 15, 15, 1, asVar4);
        lk lkVar17 = new lk("SINT64", 16, 16, 1, asVar3);
        lk lkVar18 = new lk("GROUP", 17, 17, 1, asVar7);
        lk lkVar19 = new lk("DOUBLE_LIST", 18, 18, 2, asVar);
        lk lkVar20 = new lk("FLOAT_LIST", 19, 19, 2, asVar2);
        lk lkVar21 = new lk("INT64_LIST", 20, 20, 2, asVar3);
        lk lkVar22 = new lk("UINT64_LIST", 21, 21, 2, asVar3);
        lk lkVar23 = new lk("INT32_LIST", 22, 22, 2, asVar4);
        lk lkVar24 = new lk("FIXED64_LIST", 23, 23, 2, asVar3);
        lk lkVar25 = new lk("FIXED32_LIST", 24, 24, 2, asVar4);
        lk lkVar26 = new lk("BOOL_LIST", 25, 25, 2, asVar5);
        lk lkVar27 = new lk("STRING_LIST", 26, 26, 2, asVar6);
        lk lkVar28 = new lk("MESSAGE_LIST", 27, 27, 2, asVar7);
        lk lkVar29 = new lk("BYTES_LIST", 28, 28, 2, asVar8);
        lk lkVar30 = new lk("UINT32_LIST", 29, 29, 2, asVar4);
        lk lkVar31 = new lk("ENUM_LIST", 30, 30, 2, asVar9);
        lk lkVar32 = new lk("SFIXED32_LIST", 31, 31, 2, asVar4);
        lk lkVar33 = new lk("SFIXED64_LIST", 32, 32, 2, asVar3);
        lk lkVar34 = new lk("SINT32_LIST", 33, 33, 2, asVar4);
        lk lkVar35 = new lk("SINT64_LIST", 34, 34, 2, asVar3);
        lk lkVar36 = new lk("DOUBLE_LIST_PACKED", 35, 35, 3, asVar);
        b = lkVar36;
        lk lkVar37 = new lk("FLOAT_LIST_PACKED", 36, 36, 3, asVar2);
        lk lkVar38 = new lk("INT64_LIST_PACKED", 37, 37, 3, asVar3);
        lk lkVar39 = new lk("UINT64_LIST_PACKED", 38, 38, 3, asVar3);
        lk lkVar40 = new lk("INT32_LIST_PACKED", 39, 39, 3, asVar4);
        lk lkVar41 = new lk("FIXED64_LIST_PACKED", 40, 40, 3, asVar3);
        lk lkVar42 = new lk("FIXED32_LIST_PACKED", 41, 41, 3, asVar4);
        lk lkVar43 = new lk("BOOL_LIST_PACKED", 42, 42, 3, asVar5);
        lk lkVar44 = new lk("UINT32_LIST_PACKED", 43, 43, 3, asVar4);
        lk lkVar45 = new lk("ENUM_LIST_PACKED", 44, 44, 3, asVar9);
        lk lkVar46 = new lk("SFIXED32_LIST_PACKED", 45, 45, 3, asVar4);
        lk lkVar47 = new lk("SFIXED64_LIST_PACKED", 46, 46, 3, asVar3);
        lk lkVar48 = new lk("SINT32_LIST_PACKED", 47, 47, 3, asVar4);
        lk lkVar49 = new lk("SINT64_LIST_PACKED", 48, 48, 3, asVar3);
        c = lkVar49;
        f = new lk[]{lkVar, lkVar2, lkVar3, lkVar4, lkVar5, lkVar6, lkVar7, lkVar8, lkVar9, lkVar10, lkVar11, lkVar12, lkVar13, lkVar14, lkVar15, lkVar16, lkVar17, lkVar18, lkVar19, lkVar20, lkVar21, lkVar22, lkVar23, lkVar24, lkVar25, lkVar26, lkVar27, lkVar28, lkVar29, lkVar30, lkVar31, lkVar32, lkVar33, lkVar34, lkVar35, lkVar36, lkVar37, lkVar38, lkVar39, lkVar40, lkVar41, lkVar42, lkVar43, lkVar44, lkVar45, lkVar46, lkVar47, lkVar48, lkVar49, new lk("GROUP_LIST", 49, 49, 2, asVar7), new lk("MAP", 50, 50, 4, as.a)};
        lk[] lkVarArrValues = values();
        d = new lk[lkVarArrValues.length];
        for (lk lkVar50 : lkVarArrValues) {
            d[lkVar50.a] = lkVar50;
        }
    }

    public lk(String str, int i, int i2, int i3, as asVar) {
        this.a = i2;
        int iU = za0.u(i3);
        if (iU == 1 || iU == 3) {
            asVar.getClass();
        }
        if (i3 == 1) {
            asVar.ordinal();
        }
    }

    public static lk valueOf(String str) {
        return (lk) Enum.valueOf(lk.class, str);
    }

    public static lk[] values() {
        return (lk[]) f.clone();
    }
}
