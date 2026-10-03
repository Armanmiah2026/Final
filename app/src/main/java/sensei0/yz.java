package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yz {
    public static final yz a;
    public static final yz b;
    public static final /* synthetic */ yz[] c;

    static {
        yz yzVar = new yz("RAW", 0);
        a = yzVar;
        yz yzVar2 = new yz("HTTP_CONNECT", 1);
        b = yzVar2;
        c = new yz[]{yzVar, yzVar2};
    }

    public static yz valueOf(String str) {
        return (yz) Enum.valueOf(yz.class, str);
    }

    public static yz[] values() {
        return (yz[]) c.clone();
    }
}
