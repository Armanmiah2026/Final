package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a00 {
    public static final a00 a;
    public static final a00 b;
    public static final /* synthetic */ a00[] c;

    static {
        a00 a00Var = new a00("SSH_BANNER", 0);
        a = a00Var;
        a00 a00Var2 = new a00("HTTP_HEADERS", 1);
        b = a00Var2;
        c = new a00[]{a00Var, a00Var2};
    }

    public static a00 valueOf(String str) {
        return (a00) Enum.valueOf(a00.class, str);
    }

    public static a00[] values() {
        return (a00[]) c.clone();
    }
}
