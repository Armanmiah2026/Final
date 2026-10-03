package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mt {
    public static final mt a;
    public static final mt b;
    public static final mt c;
    public static final mt d;
    public static final mt f;
    public static final /* synthetic */ mt[] h;

    static {
        mt mtVar = new mt("DESTROYED", 0);
        a = mtVar;
        mt mtVar2 = new mt("INITIALIZED", 1);
        b = mtVar2;
        mt mtVar3 = new mt("CREATED", 2);
        c = mtVar3;
        mt mtVar4 = new mt("STARTED", 3);
        d = mtVar4;
        mt mtVar5 = new mt("RESUMED", 4);
        f = mtVar5;
        h = new mt[]{mtVar, mtVar2, mtVar3, mtVar4, mtVar5};
    }

    public static mt valueOf(String str) {
        return (mt) Enum.valueOf(mt.class, str);
    }

    public static mt[] values() {
        return (mt[]) h.clone();
    }
}
