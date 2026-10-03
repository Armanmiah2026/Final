package sensei0;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nb {
    public final ClassLoader a;

    public /* synthetic */ nb(ClassLoader classLoader) {
        this.a = classLoader;
    }

    public mb a(Object obj, t8 t8Var, Activity activity, vj vjVar) throws IllegalAccessException, InvocationTargetException {
        lb lbVar = new lb(t8Var, vjVar);
        Object objNewProxyInstance = Proxy.newProxyInstance(this.a, new Class[]{b()}, lbVar);
        pr.i("newProxyInstance(loader,…onsumerClass()), handler)", objNewProxyInstance);
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, objNewProxyInstance);
        return new mb(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, objNewProxyInstance);
    }

    public Class b() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.a.loadClass("java.util.function.Consumer");
        pr.i("loader.loadClass(\"java.util.function.Consumer\")", clsLoadClass);
        return clsLoadClass;
    }
}
