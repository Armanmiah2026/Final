package sensei0;

import androidx.window.extensions.layout.WindowLayoutComponent;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qk0 extends et implements uo {
    public static final qk0 b = new qk0(0);

    @Override // sensei0.uo
    public final Object a() {
        WindowLayoutComponent windowLayoutComponentA;
        try {
            ClassLoader classLoader = sk0.class.getClassLoader();
            m60 m60Var = classLoader != null ? new m60(classLoader, new nb(classLoader)) : null;
            if (m60Var == null || (windowLayoutComponentA = m60Var.a()) == null) {
                return null;
            }
            pr.i("loader", classLoader);
            nb nbVar = new nb(classLoader);
            int iA = yj.a();
            return iA >= 2 ? new xj(windowLayoutComponentA) : iA == 1 ? new wj(windowLayoutComponentA, nbVar) : new uj();
        } catch (Throwable unused) {
            rk0 rk0Var = rk0.a;
            return null;
        }
    }
}
