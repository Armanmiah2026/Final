package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xc {
    public static final xc a;
    public static final xc b;
    public static final /* synthetic */ xc[] c;

    static {
        xc xcVar = new xc("DEFAULT", 0);
        a = xcVar;
        xc xcVar2 = new xc("LAZY", 1);
        xc xcVar3 = new xc("ATOMIC", 2);
        b = xcVar3;
        c = new xc[]{xcVar, xcVar2, xcVar3, new xc("UNDISPATCHED", 3)};
    }

    public static xc valueOf(String str) {
        return (xc) Enum.valueOf(xc.class, str);
    }

    public static xc[] values() {
        return (xc[]) c.clone();
    }
}
