package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vc {
    public static final vc a;
    public static final /* synthetic */ vc[] b;

    static {
        vc vcVar = new vc("COROUTINE_SUSPENDED", 0);
        a = vcVar;
        b = new vc[]{vcVar, new vc("UNDECIDED", 1), new vc("RESUMED", 2)};
    }

    public static vc valueOf(String str) {
        return (vc) Enum.valueOf(vc.class, str);
    }

    public static vc[] values() {
        return (vc[]) b.clone();
    }
}
