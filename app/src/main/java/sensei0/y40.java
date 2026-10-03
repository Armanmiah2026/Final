package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y40 {
    public static final z40 a;

    static {
        z40 z40Var = null;
        try {
            z40Var = (z40) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (z40Var == null) {
            z40Var = new z40();
        }
        a = z40Var;
    }

    public static t8 a(Class cls) {
        a.getClass();
        return new t8(cls);
    }
}
