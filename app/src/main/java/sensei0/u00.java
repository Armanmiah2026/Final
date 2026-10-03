package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u00 {
    public static final u00 a;
    public static final /* synthetic */ u00[] b;

    static {
        u00 u00Var = new u00("PLAIN_TEXT", 0);
        a = u00Var;
        b = new u00[]{u00Var};
    }

    public static u00 a(String str) {
        for (u00 u00Var : values()) {
            u00Var.getClass();
            if ("text/plain".equals(str)) {
                return u00Var;
            }
        }
        throw new NoSuchFieldException(za0.s("No such ClipboardContentFormat: ", str));
    }

    public static u00 valueOf(String str) {
        return (u00) Enum.valueOf(u00.class, str);
    }

    public static u00[] values() {
        return (u00[]) b.clone();
    }
}
