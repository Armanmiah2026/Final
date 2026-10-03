package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m6 {
    public static final m6 a;
    public static final m6 b;
    public static final m6 c;
    public static final /* synthetic */ m6[] d;

    static {
        m6 m6Var = new m6("SUSPEND", 0);
        a = m6Var;
        m6 m6Var2 = new m6("DROP_OLDEST", 1);
        b = m6Var2;
        m6 m6Var3 = new m6("DROP_LATEST", 2);
        c = m6Var3;
        d = new m6[]{m6Var, m6Var2, m6Var3};
    }

    public static m6 valueOf(String str) {
        return (m6) Enum.valueOf(m6.class, str);
    }

    public static m6[] values() {
        return (m6[]) d.clone();
    }
}
