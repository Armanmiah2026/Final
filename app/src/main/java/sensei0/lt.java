package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class lt {
    private static final /* synthetic */ lt[] $VALUES;
    public static final jt Companion;
    public static final lt ON_ANY;
    public static final lt ON_CREATE;
    public static final lt ON_DESTROY;
    public static final lt ON_PAUSE;
    public static final lt ON_RESUME;
    public static final lt ON_START;
    public static final lt ON_STOP;

    static {
        lt ltVar = new lt("ON_CREATE", 0);
        ON_CREATE = ltVar;
        lt ltVar2 = new lt("ON_START", 1);
        ON_START = ltVar2;
        lt ltVar3 = new lt("ON_RESUME", 2);
        ON_RESUME = ltVar3;
        lt ltVar4 = new lt("ON_PAUSE", 3);
        ON_PAUSE = ltVar4;
        lt ltVar5 = new lt("ON_STOP", 4);
        ON_STOP = ltVar5;
        lt ltVar6 = new lt("ON_DESTROY", 5);
        ON_DESTROY = ltVar6;
        lt ltVar7 = new lt("ON_ANY", 6);
        ON_ANY = ltVar7;
        $VALUES = new lt[]{ltVar, ltVar2, ltVar3, ltVar4, ltVar5, ltVar6, ltVar7};
        Companion = new jt();
    }

    public static lt valueOf(String str) {
        return (lt) Enum.valueOf(lt.class, str);
    }

    public static lt[] values() {
        return (lt[]) $VALUES.clone();
    }

    public final mt a() {
        switch (kt.a[ordinal()]) {
            case 1:
            case 2:
                return mt.c;
            case 3:
            case 4:
                return mt.d;
            case 5:
                return mt.f;
            case 6:
                return mt.a;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
