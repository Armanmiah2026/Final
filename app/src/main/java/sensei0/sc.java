package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sc {
    public static final sc a;
    public static final sc b;
    public static final sc c;
    public static final sc d;
    public static final sc f;
    public static final /* synthetic */ sc[] h;

    static {
        sc scVar = new sc("CPU_ACQUIRED", 0);
        a = scVar;
        sc scVar2 = new sc("BLOCKING", 1);
        b = scVar2;
        sc scVar3 = new sc("PARKING", 2);
        c = scVar3;
        sc scVar4 = new sc("DORMANT", 3);
        d = scVar4;
        sc scVar5 = new sc("TERMINATED", 4);
        f = scVar5;
        h = new sc[]{scVar, scVar2, scVar3, scVar4, scVar5};
    }

    public static sc valueOf(String str) {
        return (sc) Enum.valueOf(sc.class, str);
    }

    public static sc[] values() {
        return (sc[]) h.clone();
    }
}
