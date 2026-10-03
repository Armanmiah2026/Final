package sensei0;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x00 {
    public static final Method a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        pr.f(methods);
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (pr.b(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                pr.i("getParameterTypes(...)", parameterTypes);
                if (pr.b(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        a = method;
        int length2 = methods.length;
        for (int i2 = 0; i2 < length2 && !pr.b(methods[i2].getName(), "getSuppressed"); i2++) {
        }
    }
}
